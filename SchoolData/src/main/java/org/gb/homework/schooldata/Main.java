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
 * Рефакторинг и\или оптимизация проекта предыдущего дз с учетом теоретических основ SOLID’а
 * <p>
 * Небольшой анализ приложения с точки зрения принципов SOLID:
 * <p>
 * S - приложение разделено, в соответсвие с паттерном MVC.
 * Классы модели отвечают только за данные, view - только за отображение,
 * controller - за передачу сообщений между view и модели.
 * <p>
 * O - изменение в любом из модулей не требует изменений в других.
 * <p>
 * L - Student и Teacher расширяют класс User. И, без проблем использует сервис и репозиторий.
 * Сервис и репозиторий не делают особых предположений о типе с которым работают.
 * Им важно, что базовый путь будет User.
 * Есть потенциальная проблема при добавлении нового типа, унаследованного от User.
 * При добавлении нового типа, надо следить, что бы не вводить ограничений таких,
 * которые бы не нарушили принцип Lисков.
 * <p>
 * I - В проекте нет вынужденных реализаций интерфейса
 * <p>
 * D - Экземпляры классов MVC создаются в Main (или специальном AppController - выполняющем роль диспетчера),
 * Связка экземпляров происходит путем "инъекции" в конструктор.
 * <p>
 * Добавлен Builder для класса Person
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
