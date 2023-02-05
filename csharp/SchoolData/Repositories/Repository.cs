using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.Model.Factories;

namespace Gb.Homework.SchoolData.Repositories
{


    /// <summary>
    /// 
    /// </summary>
    public class Repository<T> : IUserRepository where T : User
    {
        private static bool isCommitEverytime = true;
        private string fileDb;

        private UserFactory<T> userFactory;
        private Dictionary<int, T> users = new();
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
            //if (isFetch)
            //    return;
            //isFetch = true;

            //try
            //{
            //    Path path = Paths.get(fileDb);
            //    if (Files.exists(path))
            //    {
            //        List<String> allLines = Files.readAllLines(path);

            //        for (String line : allLines)
            //        {
            //            T user = userFactory.deserialize(line);
            //            users.put(user.getId(), user);
            //        }
            //    }
            //}
            //catch (IOException e)
            //{
            //    e.printStackTrace();
            //}

        }

        public void Commit()
        {
            //if (!isCommitEverytime)
            //    return;

            //try (FileWriter fileWriter = new FileWriter(fileDb)) {
            //    for (var u : users.values())
            //    {
            //        fileWriter.write(u.serialize());
            //        fileWriter.write(System.lineSeparator());
            //        fileWriter.flush();
            //    }
            //} catch (Exception ignored)
            //{
            //}
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
