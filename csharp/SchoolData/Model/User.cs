namespace Gb.Homework.SchoolData.Model
{
    /// <summary>
    /// 
    /// </summary>
    public abstract class User
    {
        public int Id { private set; get; }
        public string Name { get; set; }
        public bool IsActual { get; set; } = true;

        public User(int id, string name)
        {
            Id = id;
            Name = name;
        }

        public abstract string Serialize();
    }
}
