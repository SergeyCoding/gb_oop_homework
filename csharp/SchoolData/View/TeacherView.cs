using Gb.Homework.SchoolData.Model;
using Gb.Homework.SchoolData.View.Tools;

namespace Gb.Homework.SchoolData.View
{


    public class TeacherView
    {

        public int showMenu(Teacher currentTeacher)
        {
            Console.WriteLine("\nУчителя");

            if (currentTeacher != null)
            {
                Console.WriteLine("Текущий учитель: %s\n", currentTeacher.getName());
            }

            Console.WriteLine("1. Показать всех учителей");
            Console.WriteLine("2. Выбрать");
            Console.WriteLine("3. Добавить");
            Console.WriteLine("4. Изменить");
            Console.WriteLine("5. Удалить");

            Console.WriteLine("0. Вернуться в главное меню");

            return ConsoleHelper.getNaturalInteger("Выберите номер задачи: ", x->x >= 0 && x <= 5);
        }

        public void showAll(List<Teacher> users)
        {
            if (users.size() == 0)
            {
                Console.WriteLine("\nНет ни одного учителя");
                return;
            }

            Console.WriteLine("Список учителей:");

            for (var u : users)
            {
                Console.WriteLine(u);
            }
        }

        public void showTaskError()
        {
            Console.WriteLine("Задача не выбрана");
        }

        public int getTeacherId(int nextId)
        {
            if (nextId == 0)
            {
                Console.WriteLine("\nНет ни одного учителя");
                return -1;
            }

            return ConsoleHelper.getNaturalInteger("Выберите id учителя: ", x->x >= 0 && x < nextId);
        }

        public String inputName()
        {
            Console.WriteLine("Добавление/изменение учителя ");
            return ConsoleHelper.getString("Введите имя: ", x-> !x.isBlank());
        }

        public void showCurrentTeacherError()
        {
            Console.WriteLine("Не выбран учитель");
        }
    }

}