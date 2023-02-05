namespace Gb.Homework.SchoolData.Model
{

    /// <summary>
    /// 
    /// </summary>
    public class Student : User
    {
        public int Year { get; set; }
        public float Grade { get; set; }

        public Student(int id, string name, float grade, int year) : base(id, name)
        {
            Grade = grade;
            Year = year;
        }



        public override string Serialize()
        {
            var arr = new[] { AppConst.STUDENT, Id.ToString(), IsActual.ToString(), Name, Grade.ToString(), Year.ToString() };
            return string.Join(AppConst.DELIMITER, arr);
        }



        public override string? ToString()
        {
            return $"id={Id} name={Name} grade={Grade} year={Year}";
        }

        public override bool Equals(object? obj)
        {
            return obj is Student student &&
                   Name == student.Name &&
                   Grade == student.Grade &&
                   Year == student.Year;
        }

        public override int GetHashCode()
        {
            return HashCode.Combine(Name, Grade, Year);
        }
    }
}
