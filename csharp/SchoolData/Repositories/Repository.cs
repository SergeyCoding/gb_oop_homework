using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.Model.Factories;

namespace Gb.Homework.SchoolData.Repositories
{


    /// <summary>
    /// 
    /// </summary>
    public class Repository<T> : IUserRepository where T : User
    {
        private static readonly bool isCommitEverytime = true;
        private readonly string fileDb;

        private readonly UserFactory<T> userFactory;
        private readonly Dictionary<int, T> users = new();
        private bool isFetch = false;

        public Repository(string fileDb, UserFactory<T> userFactory)
        {
            this.fileDb = fileDb;
            this.userFactory = userFactory;
        }

        public void Remove(T user)
        {
            Fetch();
            users[user.Id].IsActual = false;
            Commit();
        }

        public void Save(T user)
        {
            Fetch();
            users[user.Id] = user;
            Commit();
        }

        public List<T> All
        {
            get
            {
                Fetch();
                return users.Values.ToList();
            }
        }

        List<User> IUserRepository.All => throw new NotImplementedException();

        public void Fetch()
        {
            if (isFetch)
                return;
            isFetch = true;

            try
            {
                if (File.Exists(fileDb))
                {
                    List<String> allLines = File.ReadLines(fileDb).ToList();

                    foreach (String line in allLines)
                    {
                        T user = userFactory.Deserialize(line);
                        users[user.Id] = user;
                    }
                }
            }
            catch (IOException e)
            {
                Console.WriteLine(e.Message);
            }

        }

        public void Commit()
        {
            if (!isCommitEverytime)
                return;

            try
            {
                File.WriteAllLines(fileDb, users.Values.Select(x => x.Serialize()));
            }
            catch (Exception)
            {
            }
        }

        void IUserRepository.Remove(User user)
        {
            Remove((T)user);
        }

        void IUserRepository.Save(User user)
        {
            Save((T)user);
        }
    }
}
