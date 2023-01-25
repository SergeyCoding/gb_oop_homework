package Service.impls;

import Model.Student;
import Service.StudentService;
import Repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository repository = new StudentRepository();

    @Override
    public void add(Student student) {
        if (student != null) {
            repository.save(student);
        } else {
            System.out.println("Student is null!");
        }


    }

    @Override
    public void remove(Student student) {
        if (student != null){
            repository.remove(student);
        }


    }

    @Override
    public void edit(Student student) {
        if (student != null){
            repository.edit(student);
        }

    }

    @Override
    public List getAllStudents() {
        return repository.getAllStudents();
    }
}
