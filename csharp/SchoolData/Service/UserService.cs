using Gb.Homework.SchoolData.Model;

namespace Gb.Homework.SchoolData.Service
{
    /// <summary>
    /// 
    /// </summary>
    /// <typeparam name="T"></typeparam>
    public interface UserService<T> where T : User
    {
        List<T> GetAllUsers();

        void Add(T user);

        void Edit(T user);

        void Remove(T user);

        int GetNextId();
    }
}
