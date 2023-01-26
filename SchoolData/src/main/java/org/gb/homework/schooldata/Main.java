package org.gb.homework.schooldata;

import org.gb.homework.schooldata.controller.AppController;
import org.gb.homework.schooldata.controller.TeacherController;
import org.gb.homework.schooldata.model.Student;
import org.gb.homework.schooldata.model.Teacher;
import org.gb.homework.schooldata.repository.Repository;
import org.gb.homework.schooldata.service.UserService;
import org.gb.homework.schooldata.service.impls.UserServiceImpl;
import org.gb.homework.schooldata.view.SchoolDataView;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Доделать проект (использовать параметризацию)
 * Сохранение в файл, редактирование, чтение и удаление
 */
public class Main {
    private static final Dictionary<String, Repository> repositories = new Hashtable<>();
    private static final Dictionary<String, UserService> services = new Hashtable<>();

    private static SchoolDataView view;
    private static TeacherController teacherController;

    public static void main(String[] args) {
        repositories.put(AppConst.STUDENT, new Repository<Student>("student.txt"));
        repositories.put(AppConst.TEACHER, new Repository<Teacher>("teacher.txt"));

        services.put(AppConst.STUDENT, new UserServiceImpl<>(repositories.get(AppConst.STUDENT)));
        services.put(AppConst.TEACHER, new UserServiceImpl<>(repositories.get(AppConst.TEACHER)));

        AppController controller = new AppController(services);
        controller.run();
    }
}
