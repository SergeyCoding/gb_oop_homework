using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.Repositories;

namespace Gb.Homework.SchoolData.Service.Impls
{

    public class UserServiceImpl<T> : ISchoolUserService<T> where T : User
    {
        protected Repository<T> repository;

        public UserServiceImpl(Repository<T> repository)
        {
            this.repository = repository;
        }

        public List<T> GetAllUsers()
        {
            return repository.All.Where(x => x.IsActual).ToList();
        }

        public void Add(T user)
        {
            repository.Save(user);
        }

        public void Edit(T user)
        {
            repository.Save(user);
        }

        public void Remove(T user)
        {
            repository.Remove(user);
        }

        public int GetNextId()
        {
            var last = repository.All.MaxBy(x => x.Id);

            return last != null ? last.Id + 1 : 0;
        }

        List<User> IUserService.GetAllUsers()
        {
            return GetAllUsers().Cast<User>().ToList();
        }

        void IUserService.Add(User user)
        {
            Add((T)user);
        }

        void IUserService.Edit(User user)
        {
            Edit((T)user);
        }

        void IUserService.Remove(User user)
        {
            Remove((T)user);
        }
    }

}