using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.Service;
using Gb.Homework.SchoolData.View;

namespace Gb.Homework.SchoolData.Controllers
{


    public class TeacherController
    {
        private readonly ISchoolUserService<Teacher> teacherService;
        private readonly TeacherView view;
        public Teacher? currentTeacher;

        public TeacherController(ISchoolUserService<Teacher> service, TeacherView view)
        {
            teacherService = service;
            this.view = view;
        }


        public void PrintAll()
        {
            var users = teacherService.GetAllUsers();
            view.ShowAll(users);
        }

        public Teacher? GetCurrentTeacher()
        {
            return currentTeacher;
        }

        public void Run()
        {
            var isWorking = true;

            while (isWorking)
            {

                var numberTask = view.ShowMenu(currentTeacher);

                switch (numberTask)
                {
                    case 0:
                        isWorking = false;
                        break;
                    case 1:
                        PrintAll();
                        break;
                    case 2:
                        ChooseTeacher();
                        break;
                    case 3:
                        AddTeacher();
                        break;
                    case 4:
                        EditTeacher();
                        break;
                    case 5:
                        DeleteTeacher();
                        break;
                    default:
                        view.ShowTaskError();
                        break;
                }
            }

        }


        private void DeleteTeacher()
        {
            if (currentTeacher == null)
            {
                view.ShowCurrentTeacherError();
                return;
            }
            teacherService.Remove(currentTeacher);
            currentTeacher = null;
        }

        private void EditTeacher()
        {
            if (currentTeacher == null)
            {
                view.ShowCurrentTeacherError();
                return;
            }

            var name = view.InputName();
            currentTeacher.Name = name;
            teacherService.Edit(currentTeacher);
        }

        private void AddTeacher()
        {
            var name = view.InputName();

            var lastTeacher = teacherService.GetAllUsers().MaxBy(x => x.Id);

            var nextId = 0;

            if (lastTeacher != null)
                nextId = lastTeacher.Id + 1;

            teacherService.Add(new Teacher(nextId, name));
        }

        private void ChooseTeacher()
        {
            var nextId = teacherService.GetNextId();
            var teacherId = view.GetTeacherId(nextId);

            currentTeacher = teacherService.GetAllUsers().Where(x => x.Id == teacherId).First();
        }
    }

}
