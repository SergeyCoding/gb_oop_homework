package org.gb.homework.schooldata.repository;

import org.gb.homework.schooldata.model.Student;

import java.io.FileWriter;
import java.util.List;

public class StudentRepository extends Repository<Student> {
    private final String fileDb;

    public StudentRepository(String fileDb) {

        this.fileDb = fileDb;
    }

    public void save(Student student) {
        try (FileWriter fileWriter = new FileWriter(fileDb)) {
            fileWriter.write(student.toString());
            fileWriter.flush();

        } catch (Exception exception) {
        }
    }

    public void remove(Student student) {
    }

    public void edit(Student student) {
    }

    public List getAllStudents() {
        return null;
    }
}
