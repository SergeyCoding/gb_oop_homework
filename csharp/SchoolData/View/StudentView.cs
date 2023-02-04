using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.View.Tools;

namespace Gb.Homework.SchoolData.View
{


    public class StudentView
    {

        public int ShowMenu(Student? currentStudent)
        {
            Console.WriteLine("\nСтуденты:");

            if (currentStudent != null)
            {
                Console.WriteLine("Текущий студент: %s\n", currentStudent.Name);
            }

            Console.WriteLine("1. Показать всех студентов");
            Console.WriteLine("2. Выбрать");
            Console.WriteLine("3. Добавить");
            Console.WriteLine("4. Изменить");
            Console.WriteLine("5. Удалить");

            Console.WriteLine("0. Вернуться в главное меню");

            return ConsoleHelper.GetNaturalInteger("Выберите номер задачи: ", x => x >= 0 && x <= 5);
        }

        public void ShowAll(List<Student> users)
        {
            if (users.Count == 0)
            {
                Console.WriteLine("\nНет ни одного студента");
                return;
            }

            Console.WriteLine("Список студентов:");

            foreach (Student student in users)
            {
                Console.WriteLine(student.Name);
            }

        }

        public void showTaskError()
        {
            Console.WriteLine("Задача не выбрана");
        }

        public int getStudentId(int nextId)
        {
            if (nextId == 0)
            {
                Console.WriteLine("\nНет ни одного студента");
                return -1;
            }

            return ConsoleHelper.GetNaturalInteger("Выберите id студента: ", x => x >= 0 && x < nextId);
        }

        public string InputName()
        {
            Console.WriteLine("Добавление/изменение студента");
            return ConsoleHelper.GetString("Введите имя: ", x => !string.IsNullOrWhiteSpace(x));
        }

        public void ShowCurrentStudentError()
        {
            Console.WriteLine("Не выбран студент");
        }

        public int InputGrade()
        {
            return ConsoleHelper.GetNaturalInteger("Оценка: ", x => x >= 1 && x <= 5);
        }

        public int InputYear()
        {
            return ConsoleHelper.GetNaturalInteger("Год: ", x => x >= 1900 && x <= DateTime.Now.Year + 1);
        }
    }

}
