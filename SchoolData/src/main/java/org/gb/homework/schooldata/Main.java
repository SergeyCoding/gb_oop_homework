package org.gb.homework.schooldata;

import org.gb.homework.schooldata.model.Student;
import org.gb.homework.schooldata.model.Teacher;
import org.gb.homework.schooldata.repository.Repository;
import org.gb.homework.schooldata.service.UserService;
import org.gb.homework.schooldata.service.impls.UserServiceImpl;

/**
 * Доделать проект (использовать параметризацию)
 * Сохранение в файл, редактирование, чтение и удаление
 */
public class Main {
    public static void main(String[] args) {
        var studentRepository = new Repository<Student>("student.txt");
        var teacherRepository = new Repository<Teacher>("teacher.txt");

        UserService<Student> service = new UserServiceImpl<>(studentRepository);
        UserService<Teacher> teacherService = new UserServiceImpl<>(teacherRepository);

        service.add(new Student("Roman", 4.92f, 4));
    }
}
