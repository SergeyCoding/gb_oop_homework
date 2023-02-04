namespace Gb.Homework.SchoolData.Model.Factories
{
    /// <summary>
    /// 
    /// </summary>
    public interface UserFactory<T> where T : User
    {
        T Deserialize(string line);
    }
}
