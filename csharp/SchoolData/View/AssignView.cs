using Gb.Homework.SchoolData.Model;

namespace Gb.Homework.SchoolData.View
{


    public class AssignView
    {
        public void ShowTeacher(Teacher teacher)
        {
            Console.WriteLine("\nУчитель - %d %s\n", teacher.Id, teacher.Name);

            List<Student> group = teacher.getGroup();

            if (group.Count == 0)
                Console.WriteLine("\tстуденты не назначены");

            Console.WriteLine("\tстуденты:");

            foreach (Student student in group)
            {
                Console.WriteLine("\t%d %s |", student.Id, student.Name);
            }
            Console.WriteLine();
        }

        public void ShowTitle()
        {
            Console.WriteLine("\nРаспределение студентов по учителям:");
        }
    }

}
