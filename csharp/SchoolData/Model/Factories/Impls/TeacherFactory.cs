namespace Gb.Homework.SchoolData.Model.Factories.Impls
{

    public class TeacherFactory : UserFactory<Teacher>
    {

        public Teacher Deserialize(string line)
        {
            var strings = line.Split(";\t;");

            int id = int.Parse(strings[1]);
            bool isActual = bool.Parse(strings[2]);
            var name = strings[3];

            var teacher = new Teacher(id, name)
            {
                IsActual = isActual
            };

            return teacher;
        }
    }
}
