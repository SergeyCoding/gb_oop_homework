using Gb.Homework.SchoolData.Model;

namespace Gb.Homework.SchoolData.Service
{
    /// <summary>
    /// 
    /// </summary>
    public interface IUserService
    {
        List<User> GetAllUsers();

        void Add(User user);

        void Edit(User user);

        void Remove(User user);

        int GetNextId();
    }
}
