using Gb.Homework.SchoolData.Controllers;
using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.Model.Factories.Impls;
using Gb.Homework.SchoolData.Repositories;
using Gb.Homework.SchoolData.Service.Impls;
using Gb.Homework.SchoolData.View;

namespace Gb.Homework.SchoolData
{
    internal class Program
    {
        private static Dictionary<string, object> repositories = new();
        private static Dictionary<string, object> services = new();

        private static SchoolDataView view;
        private static TeacherController teacherController;

        static void Main(string[] args)
        {
            repositories[AppConst.STUDENT] = new Repository<Student>("students.txt", new StudentFactory());
            repositories[AppConst.TEACHER] = new Repository<Teacher>("teachers.txt", new TeacherFactory());

            services[AppConst.STUDENT] = new UserServiceImpl<Student>((Repository<Student>)repositories[AppConst.STUDENT]);
            services[AppConst.TEACHER] = new UserServiceImpl<Teacher>((Repository<Teacher>)repositories[AppConst.TEACHER]);

            AppController controller = new AppController(services);
            controller.run();
        }
    }
}