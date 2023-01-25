package Repository;

import Model.Teacher;

import java.io.FileWriter;

public class TeacherRepository {
    public void save(Teacher teacher){
        try(FileWriter fileWriter = new FileWriter("students.txt")){
            fileWriter.write(teacher.toString());
            fileWriter.flush();

        }catch (Exception exception){}
    }
    public void remove(Teacher teacher){}

    public void edit(String name){}


}
