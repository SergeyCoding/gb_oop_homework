using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.Service;
using Gb.Homework.SchoolData.View;

namespace Gb.Homework.SchoolData.Controllers
{


    public class AppController
    {
        private Dictionary<string, UserService<User>> services;

        public AppController(Dictionary<string, UserService<User>> services)
        {
            this.services = services;
        }

        public void Run()
        {

            var view = new SchoolDataView();

            var isWorking = true;

            while (isWorking)
            {

                var numberTask = view.ShowMenu();

                switch (numberTask)
                {
                    case 0=>isWorking = false;
                    case 1=> {
                            var teacherController = new TeacherController(services.get(AppConst.TEACHER), new TeacherView());
                            teacherController.run();
                        }
                    case 2=> {
                            var studentController = new StudentController(services.get(AppConst.STUDENT), new StudentView());
                            studentController.run();
                        }
                    case 3=> {
                            var assignController = new AssignController(services.get(AppConst.TEACHER), services.get(AppConst.STUDENT), new AssignView());
                            assignController.run();
                        }
                    default => view.showTaskError();
                }
            }

            view.showWorkComplete();
        }
    }

}
