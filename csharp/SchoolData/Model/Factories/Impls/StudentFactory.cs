namespace Gb.Homework.SchoolData.Model.Factories.Impls
{
    public class StudentFactory : UserFactory<Student>
    {
        public Student Deserialize(string line)
        {
            var strings = line.Split(AppConst.DELIMITER);

            int id = int.Parse(strings[1]);
            var isActual = bool.Parse(strings[2]);
            var name = strings[3];
            float grade = float.Parse(strings[4].Replace(',', '.'));
            int year = int.Parse(strings[5]);

            var student = new Student(id, name, grade, year)
            {
                IsActual = isActual
            };

            return student;
        }
    }
}
