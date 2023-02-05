using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.Service;
using Gb.Homework.SchoolData.View;

namespace Gb.Homework.SchoolData.Controllers
{


    public class AppController
    {
        private readonly Dictionary<string, IUserService> services;
        private readonly SchoolDataView view;

        public AppController(Dictionary<string, IUserService> services, SchoolDataView view)
        {
            this.services = services;
            this.view = view;
        }

        public void Run()
        {
            var isWorking = true;

            while (isWorking)
            {

                var numberTask = view.ShowMenu();

                switch (numberTask)
                {
                    case 0:
                        isWorking = false;
                        break;
                    case 1:
                        var teacherController = new TeacherController((ISchoolUserService<Teacher>)services[AppConst.TEACHER], new TeacherView());
                        teacherController.Run();
                        break;
                    case 2:
                        var studentController = new StudentController((ISchoolUserService<Student>)services[AppConst.STUDENT], new StudentView());
                        studentController.Run();
                        break;
                    case 3:
                        var teacherService = (ISchoolUserService<Teacher>)services[AppConst.TEACHER];
                        var studentService = (ISchoolUserService<Student>)services[AppConst.STUDENT];
                        var assignController = new AssignController(teacherService, studentService, new AssignView());
                        assignController.Run();
                        break;
                    default:
                        view.showTaskError();
                        break;
                }
            }

            view.showWorkComplete();
        }
    }

}
