using Gb.Homework.SchoolData.Model;

namespace Gb.Homework.SchoolData.Service
{
    public interface ISchoolUserService<T> : IUserService where T : User
    {
        new List<T> GetAllUsers();

        void Add(T user);

        void Edit(T user);

        void Remove(T user);
    }
}
