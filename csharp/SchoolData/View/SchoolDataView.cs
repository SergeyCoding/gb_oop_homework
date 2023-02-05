using Gb.Homework.SchoolData.View.Tools;

namespace Gb.Homework.SchoolData.View
{
    public class SchoolDataView
    {

        public int ShowMenu()
        {

            Console.WriteLine("\nУчебное заведение");
            Console.WriteLine("1. Учителя");
            Console.WriteLine("2. Студенты");
            Console.WriteLine("3. Распределить студентов по учителям");

            Console.WriteLine("0. Выход");

            return ConsoleHelper.GetNaturalInteger("Выберите номер задачи: ", x => x >= 0 && x <= 3);
        }

        public void showWorkComplete()
        {
            Console.WriteLine("Работа завершена...");
        }


        public void showTaskError()
        {
            Console.WriteLine("Задача не выбрана");
        }
    }
}
