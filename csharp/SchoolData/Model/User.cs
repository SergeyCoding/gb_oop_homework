namespace Gb.Homework.SchoolData.Model
{
    /// <summary>
    /// 
    /// </summary>
    public abstract class User
    {
        private readonly int id;
        protected string name;
        public bool isActual { get; set; } = true;

        public User(int id, string name)
        {
            this.id = id;
            this.name = name;
        }


        public int GetId()
        {
            return id;
        }

        public string GetName()
        {
            return name;
        }

        public void SetName(string name)
        {
            this.name = name;
        }

        public abstract string serialize();
    }
}
