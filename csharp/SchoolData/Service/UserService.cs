using Gb.Homework.SchoolData.Model;

namespace Gb.Homework.SchoolData.Service
{

    public interface UserService<T> where T : User
    {
        List<T> getAllUsers();

        void add(T user);

        void edit(T user);

        void remove(T user);

        int getNextId();
    }

}
