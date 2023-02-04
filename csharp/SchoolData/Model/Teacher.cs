namespace Gb.Homework.SchoolData.Model
{


    public class Teacher : User
    {
        private List<Student> group = new();

        public Teacher(int id, string name) : base(id, name) { }

        public override string Serialize()
        {
            List<string> ts = new[] { AppConst.TEACHER, Id.ToString(), IsActual.ToString(), Name }.ToList();
            return string.Join(AppConst.DELIMITER, ts);
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
            return Equals(Name, teacher.Name);
        }

        public override int GetHashCode()
        {
            return Name.GetHashCode();
        }


        public override string ToString()
        {
            return string.Format("id=%d name=%s", Id, Name);
        }

        public void ClearGroup()
        {
            group.Clear();
        }
    }

}
