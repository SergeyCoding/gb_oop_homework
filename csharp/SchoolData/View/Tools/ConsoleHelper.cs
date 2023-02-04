namespace Gb.Homework.SchoolData.View.Tools
{


    public static class ConsoleHelper
    {

        public static int GetNaturalInteger(string prompt)
        {
            return GetFromConsole(prompt, n => n > 0);
        }

        public static int GetNaturalInteger(string prompt, Predicate<int> fun)
        {
            return GetFromConsole(prompt, fun);
        }

        public static int GetNaturalInteger(string prompt, Predicate<int> fun, int defaultValue)
        {
            return GetFromConsole(string.Format("%s [%d] ", prompt, defaultValue), fun, defaultValue);
        }

        public static int GetInteger(string prompt)
        {
            return GetFromConsole(prompt, n => n > 0);
        }

        public static string getString(string prompt)
        {
            Console.WriteLine(prompt);

            return Console.ReadLine() ?? string.Empty;
        }

        public static string GetString(string prompt, Predicate<string> fun)
        {
            while (true)
            {
                Console.WriteLine(prompt);
                var s = Console.ReadLine() ?? string.Empty;

                if (fun(s))
                {
                    return s;
                }

                Console.WriteLine("Ошибка! ");
            }
        }

        private static int GetFromConsole(string prompt, Predicate<int> fun)
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