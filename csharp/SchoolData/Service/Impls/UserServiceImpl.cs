using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.Repositories;

namespace Gb.Homework.SchoolData.Service.Impls
{

    public class UserServiceImpl<T> : UserService<T> where T : User
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

        public static implicit operator UserServiceImpl<User>(UserServiceImpl<T> t)
        {
            return new UserServiceImpl<User> { t };
        }
    }

}