namespace Gb.Homework.SchoolData.Model
{


    public class Student : User
    {
        private float grade;
        private int year;

        public Student(int id, String name, float grade, int year) : base(id, name)
        {
            this.grade = grade;
            this.year = year;
        }


        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public override String serialize()
        {
            return String.Format("%s;\t;%d;\t;%b;\t;%s;\t;%g;\t;%d", AppConst.STUDENT, getId(), isActual(), getName(), getGrade(), getYear());
        }

        public float getGrade()
        {
            return grade;
        }

        public void setGrade(float grade)
        {
            this.grade = grade;
        }

        public int getYear()
        {
            return year;
        }

        public void setYear(int year)
        {
            this.year = year;
        }

        @Override
    public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student)o;
            return Float.compare(student.grade, grade) == 0 && year == student.year && Objects.equals(name, student.name);
        }
        @Override
    public int hashCode()
        {
            return Objects.hash(name, grade, year);
        }

        @Override
    public String toString()
        {
            return String.format("id=%d name=%s grade=%g year=%d", getId(), name, grade, year);
        }
    }


}
