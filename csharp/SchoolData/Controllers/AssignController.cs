namespace Gb.Homework.SchoolData.Controllers
{

    public class AssignController
    {
        private final UserService<Teacher> teacherService;
        private final UserService<Student> studentService;
        private final AssignView view;

    public AssignController(UserService<Teacher> teacherService, UserService<Student> studentService, AssignView assignView)
        {
            this.teacherService = teacherService;
            this.studentService = studentService;
            this.view = assignView;
        }

        public void run()
        {
            view.showTitle();

            for (var t : teacherService.getAllUsers())
            {
                t.clearGroup();
            }

            Stack<Student> students = new Stack<>();
            students.addAll(studentService.getAllUsers());

            while (!students.isEmpty())
            {
                for (var t : teacherService.getAllUsers())
                {
                    if (students.isEmpty())
                        break;

                    t.addStudent(students.pop());
                }
            }


            for (var t : teacherService.getAllUsers())
            {
                view.showTeacher(t);
            }
        }
    }

}
