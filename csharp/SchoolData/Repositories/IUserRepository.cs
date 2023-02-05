using Gb.Homework.SchoolData.Model;

namespace Gb.Homework.SchoolData.Repositories
{
    /// <summary>
    /// 
    /// </summary>
    public interface IUserRepository
    {
        List<User> All { get; }

        void Commit();
        void Fetch();
        void Remove(User user);
        void Save(User user);
    }
}