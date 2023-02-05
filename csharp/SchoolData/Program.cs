using Gb.Homework.SchoolData.Controllers;
using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.Model.Factories.Impls;
using Gb.Homework.SchoolData.Repositories;
using Gb.Homework.SchoolData.Service;
using Gb.Homework.SchoolData.Service.Impls;
using Gb.Homework.SchoolData.View;

namespace Gb.Homework.SchoolData
{
    internal class Program
    {
        private static readonly Dictionary<string, IUserRepository> repositories = new();
        private static readonly Dictionary<string, IUserService> services = new();

        static void Main(string[] args)
        {
            repositories[AppConst.STUDENT] = new Repository<Student>("students.txt", new StudentFactory());
            repositories[AppConst.TEACHER] = new Repository<Teacher>("teachers.txt", new TeacherFactory());

            services[AppConst.STUDENT] = new UserServiceImpl<Student>((Repository<Student>)repositories[AppConst.STUDENT]);
            services[AppConst.TEACHER] = new UserServiceImpl<Teacher>((Repository<Teacher>)repositories[AppConst.TEACHER]);

            AppController controller = new AppController(services, new SchoolDataView());
            controller.Run();
        }
    }
}