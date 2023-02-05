using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.Service;
using Gb.Homework.SchoolData.View;

namespace Gb.Homework.SchoolData.Controllers
{

    public class AssignController
    {
        private readonly ISchoolUserService<Teacher> teacherService;
        private readonly ISchoolUserService<Student> studentService;
        private readonly AssignView view;

        public AssignController(ISchoolUserService<Teacher> teacherService, ISchoolUserService<Student> studentService, AssignView assignView)
        {
            this.teacherService = teacherService;
            this.studentService = studentService;
            view = assignView;
        }

        public void Run()
        {
            view.ShowTitle();

            foreach (var item in teacherService.GetAllUsers())
            {
                item.ClearGroup();
            }

            Stack<Student> students = new Stack<Student>();

            foreach (var item in studentService.GetAllUsers())
            {

                students.Push(item);
            }


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
