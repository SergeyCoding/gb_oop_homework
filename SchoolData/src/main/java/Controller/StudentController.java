package Controller;

import Model.Student;
import Service.StudentService;
import Service.impls.StudentServiceImpl;
//Контроллер
public class StudentController {
    private StudentService studentService = new StudentServiceImpl();
    public void getStudentInfo(String name, float grade, int year){
        studentService.add(new Student(name,grade,year));

    }
}
