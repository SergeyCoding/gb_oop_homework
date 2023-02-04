namespace Gb.Homework.SchoolData.View.Tools
{


    public class ConsoleHelper
    {


        public static int GetNaturalInteger(string prompt)
        {
            return getFromConsole(prompt, n => n > 0);
        }

        public static int GetNaturalInteger(string prompt, Predicate<int> fun)
        {
            return getFromConsole(prompt, fun);
        }

        public static int GetNaturalInteger(string prompt, Predicate<int> fun, int defaultValue)
        {
            return GetFromConsole(string.Format("%s [%d] ", prompt, defaultValue), fun, defaultValue);
        }

        public static int GetInteger(string prompt)
        {
            return getFromConsole(prompt, n => n > 0);
        }

        public static string getString(string prompt)


            System.out.print(prompt);

            return scannerIn.nextLine();
        }

    public static string GetString(string prompt, Predicate<string> fun)
    {
        while (true)
        {
            System.out.print(prompt);
            var s = scannerIn.nextLine();

            if (fun.test(s))
            {
                return s;
            }

            System.out.print("Ошибка! ");
        }
    }

    private static int getFromConsole(string prompt, Predicate<int> fun)
    {
        while (true)
        {
            Console.WriteLine(prompt);
            try
            {
                var n = int.Parse(Console.ReadLine() ?? "0");

                if (fun(n))
                {
                    return n;
                }
            }
            catch (FormatException)
            {
            }

            Console.WriteLine("Ошибка! ");
        }
    }

    private static int GetFromConsole(string prompt, Predicate<int> fun, int defaultValue)
    {
        while (true)
        {
            Console.WriteLine(prompt);
            try
            {
                string? s = Console.ReadLine();

                if (string.IsNullOrEmpty(s))
                    return defaultValue;

                var n = int.Parse(s);

                if (fun(n))
                {
                    return n;
                }
            }
            catch (FormatException)
            {
            }
            Console.WriteLine("Ошибка! ");
        }
    }
}
}
