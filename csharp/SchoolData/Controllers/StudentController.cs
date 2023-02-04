using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.Service;
using Gb.Homework.SchoolData.View;

namespace Gb.Homework.SchoolData.Controllers
{

    public class StudentController
    {
        private UserService<Student> studentService;
        private StudentView view;
        public Student? currentStudent;

        public StudentController(UserService<Student> service, StudentView view)
        {
            this.studentService = service;
            this.view = view;
        }


        public void PrintAll()
        {
            var users = studentService.GetAllUsers();
            view.ShowAll(users);
        }

        public void Run()
        {
            var isWorking = true;

            while (isWorking)
            {

                var numberTask = view.ShowMenu(currentStudent);

                switch (numberTask)
                {
                    case 0:
                        isWorking = false;
                        break;
                    case 1:
                        PrintAll();
                        break;
                    case 2:
                        ChooseStudent();
                        break;
                    case 3:
                        AddStudent();
                        break;
                    case 4:
                        EditStudent();
                        break;
                    case 5:
                        DeleteStudent();
                        break;
                    default:
                        view.showTaskError();
                        break;
                }
            }

        }

        private void DeleteStudent()
        {
            if (currentStudent == null)
            {
                view.ShowCurrentStudentError();
                return;
            }
            studentService.Remove(currentStudent);
            currentStudent = null;
        }

        private void EditStudent()
        {
            if (currentStudent == null)
            {
                view.ShowCurrentStudentError();
                return;
            }

            var name = view.InputName();
            var grade = view.InputGrade();
            var year = view.InputYear();
            currentStudent.Name = name;
            currentStudent.Grade = grade;
            currentStudent.Year = year;
            studentService.Edit(currentStudent);
        }

        private void AddStudent()
        {
            var name = view.InputName();
            var grade = view.InputGrade();
            var year = view.InputYear();

            var nextId = studentService.GetNextId();

            studentService.Add(new Student(nextId, name, (float)grade, year));
        }

        private void ChooseStudent()
        {
            var nextId = studentService.GetNextId();
            var teacherId = view.getStudentId(nextId);

            currentStudent = studentService.GetAllUsers().Where(x => x.Id == teacherId).FirstOrDefault();
        }
    }

}
