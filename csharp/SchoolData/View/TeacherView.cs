using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.View.Tools;

namespace Gb.Homework.SchoolData.View
{


    public class TeacherView
    {

        public int ShowMenu(Teacher? currentTeacher)
        {
            Console.WriteLine("\nУчителя");

            if (currentTeacher != null)
            {
                Console.WriteLine("Текущий учитель: %s\n", currentTeacher.Name);
            }

            Console.WriteLine("1. Показать всех учителей");
            Console.WriteLine("2. Выбрать");
            Console.WriteLine("3. Добавить");
            Console.WriteLine("4. Изменить");
            Console.WriteLine("5. Удалить");

            Console.WriteLine("0. Вернуться в главное меню");

            return ConsoleHelper.GetNaturalInteger("Выберите номер задачи: ", x => x >= 0 && x <= 5);
        }

        public void ShowAll(List<Teacher> users)
        {
            if (users.Count == 0)
            {
                Console.WriteLine("\nНет ни одного учителя");
                return;
            }

            Console.WriteLine("Список учителей:");

            foreach (Teacher teacher in users) { Console.WriteLine(teacher); }

        }

        public void ShowTaskError()
        {
            Console.WriteLine("Задача не выбрана");
        }

        public int GetTeacherId(int nextId)
        {
            if (nextId == 0)
            {
                Console.WriteLine("\nНет ни одного учителя");
                return -1;
            }

            return ConsoleHelper.GetNaturalInteger("Выберите id учителя: ", x => x >= 0 && x < nextId);
        }

        public string InputName()
        {
            Console.WriteLine("Добавление/изменение учителя ");
            return ConsoleHelper.GetString("Введите имя: ", x => !string.IsNullOrWhiteSpace(x));
        }

        public void ShowCurrentTeacherError()
        {
            Console.WriteLine("Не выбран учитель");
        }
    }

}