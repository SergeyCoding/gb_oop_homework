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


        public void printAll()
        {
            var users = studentService.getAllUsers();
            view.ShowAll(users);
        }

        public void run()
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
                        printAll();
                        break;
                    case 2:
                        chooseStudent();
                        break;
                    case 3:
                        addStudent();
                        break;
                    case 4:
                        editStudent();
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
            studentService.remove(currentStudent);
            currentStudent = null;
        }

        private void editStudent()
        {
            if (currentStudent == null)
            {
                view.showCurrentStudentError();
                return;
            }

            var name = view.inputName();
            var grade = view.inputGrade();
            var year = view.inputYear();
            currentStudent.setName(name);
            currentStudent.setGrade(grade);
            currentStudent.setYear(year);
            studentService.edit(currentStudent);
        }

        private void addStudent()
        {
            var name = view.inputName();
            var grade = view.inputGrade();
            var year = view.inputYear();

            var nextId = studentService.getNextId();

            studentService.add(new Student(nextId, name, (float)grade, year));
        }

        private void chooseStudent()
        {
            var nextId = studentService.getNextId();
            var teacherId = view.getStudentId(nextId);

            currentStudent = studentService.getAllUsers().stream().filter(x->x.getId() == teacherId)
                    .findFirst().orElse(null);
        }
    }

}
