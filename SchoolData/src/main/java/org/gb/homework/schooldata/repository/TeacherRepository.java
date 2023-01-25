//package org.gb.homework.schooldata.repository;
//
//import org.gb.homework.schooldata.model.Teacher;
//
//import java.io.FileWriter;
//
//public class TeacherRepository extends Repository<Teacher> {
//    public TeacherRepository(String fileDb) {
//        super(fileDb);
//    }
//
//    public void save(Teacher teacher) {
//        try (FileWriter fileWriter = new FileWriter("students.txt")) {
//            fileWriter.write(teacher.toString());
//            fileWriter.flush();
//
//        } catch (Exception exception) {
//        }
//    }
//
//
//}
