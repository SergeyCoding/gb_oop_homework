package Service;

import Model.Student;
import Model.Teacher;

import java.util.List;

public interface TeacherService {
    void add(Teacher teacher);

    void remove(Teacher teacher);

    void edit(String name);

}
