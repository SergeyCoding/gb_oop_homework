import Model.Student;
import Service.StudentService;
import Service.impls.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        studentService.add(new Student("Roman", 4.92f , 4));
    }


}
