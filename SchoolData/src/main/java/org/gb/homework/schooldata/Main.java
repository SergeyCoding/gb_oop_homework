package org.gb.homework.schooldata;

import org.gb.homework.schooldata.controller.AppController;
import org.gb.homework.schooldata.controller.TeacherController;
import org.gb.homework.schooldata.model.factories.impls.StudentFactory;
import org.gb.homework.schooldata.model.factories.impls.TeacherFactory;
import org.gb.homework.schooldata.repository.Repository;
import org.gb.homework.schooldata.service.UserService;
import org.gb.homework.schooldata.service.impls.UserServiceImpl;
import org.gb.homework.schooldata.view.SchoolDataView;

import java.util.HashMap;
import java.util.Map;

/**
 * Доделать проект (использовать параметризацию)
 * Сохранение в файл, редактирование, чтение и удаление
 */
public class Main {
    private static final Map<String, Repository> repositories = new HashMap<>();
    private static final Map<String, UserService> services = new HashMap<>();

    private static SchoolDataView view;
    private static TeacherController teacherController;

    public static void main(String[] args) {
        repositories.put(AppConst.STUDENT, new Repository<>("students.txt", new StudentFactory()));
        repositories.put(AppConst.TEACHER, new Repository<>("teachers.txt", new TeacherFactory()));

        services.put(AppConst.STUDENT, new UserServiceImpl<>(repositories.get(AppConst.STUDENT)));
        services.put(AppConst.TEACHER, new UserServiceImpl<>(repositories.get(AppConst.TEACHER)));

        AppController controller = new AppController(services);
        controller.run();
    }
}
