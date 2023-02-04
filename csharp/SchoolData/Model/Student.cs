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
            return string.Format("%s;\t;%d;\t;%b;\t;%s;\t;%g;\t;%d", AppConst.STUDENT, Id, IsActual, Name, Grade, Year);
        }



        public override string? ToString()
        {
            return string.Format("id=%d name=%s grade=%g year=%d", Id, Name, Grade, Year);
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
