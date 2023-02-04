using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.Service;
using Gb.Homework.SchoolData.View;

namespace Gb.Homework.SchoolData.Controllers
{

    public class AssignController
    {
        private UserService<Teacher> teacherService;
        private UserService<Student> studentService;
        private AssignView view;

        public AssignController(UserService<Teacher> teacherService, UserService<Student> studentService, AssignView assignView)
        {
            this.teacherService = teacherService;
            this.studentService = studentService;
            this.view = assignView;
        }

        public void run()
        {
            view.ShowTitle();

            foreach (var item in teacherService.GetAllUsers())
            {
                item.ClearGroup();
            }

            Stack<Student> students = new Stack<Student>();

            studentService.GetAllUsers().ForEach(student => { students.Push(student); });

            while (students.Count > 0)
            {
                foreach (var t in teacherService.GetAllUsers())
                {
                    if (students.Count == 0)
                        break;

                    t.addStudent(students.Pop());
                }
            }


            foreach (var t in teacherService.GetAllUsers())
            {
                view.ShowTeacher(t);
            }
        }
    }
}
