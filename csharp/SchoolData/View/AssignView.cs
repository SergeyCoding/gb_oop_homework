using Gb.Homework.SchoolData.Model;

namespace Gb.Homework.SchoolData.View
{


    public class AssignView
    {
        public void ShowTeacher(Teacher teacher)
        {
            Console.WriteLine($"\nУчитель - {teacher.Id} {teacher.Name}");

            List<Student> group = teacher.getGroup();

            if (group.Count == 0)
                Console.WriteLine("\tстуденты не назначены");

            Console.WriteLine("\tстуденты:");

            foreach (Student student in group)
            {
                Console.Write($"\t{student.Id} {student.Name} |");
            }
            Console.WriteLine();
        }

        public void ShowTitle()
        {
            Console.WriteLine("\nРаспределение студентов по учителям:");
        }
    }

}
