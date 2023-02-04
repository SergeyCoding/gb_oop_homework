namespace Gb.Homework.SchoolData.Model
{


    public class Teacher : User
    {
        private List<Student> group = new();

        public Teacher(int id, String name) : base(id, name) { }

        public override String Serialize()
        {
            List<String> ts = new[] { AppConst.TEACHER, getId()., Boolean.toString(IsActual()), getName() };
            return String.Join(AppConst.DELIMITER, ts);
        }

        public List<Student> getGroup()
        {
            return group.ToList();
        }

        public void addStudent(Student student)
        {
            group.Add(student);
        }

        public override bool Equals(object? obj)
        {
            if (this == obj) return true;
            if (obj == null || GetType() != obj.GetType()) return false;
            Teacher teacher = (Teacher)obj;
            return object.Equals(name, teacher.name);
        }

        public override int GetHashCode()
        {
            return name.GetHashCode();
        }


        public override String ToString()
        {
            return String.Format("id=%d name=%s", getId(), name);
        }

        public void clearGroup()
        {
            group.clear();
        }
    }

}
