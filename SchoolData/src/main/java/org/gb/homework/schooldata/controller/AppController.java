package org.gb.homework.schooldata.controller;


import org.gb.homework.schooldata.AppConst;
import org.gb.homework.schooldata.service.UserService;
import org.gb.homework.schooldata.view.SchoolDataView;
import org.gb.homework.schooldata.view.TeacherView;

import java.util.Dictionary;

public class AppController {
    private final Dictionary<String, UserService> services;

    public AppController(Dictionary<String, UserService> services) {
        this.services = services;
    }

    public static void run2() {

    }

    public void printAllTeacher() {
//        UserService<Teacher> service = new UserServiceImpl<>(new Repository<>());
    }

    public void run() {

        var view = new SchoolDataView();

        var isWorking = true;

        while (isWorking) {

            var numberTask = view.showMenu();

            switch (numberTask) {
                case 0 -> isWorking = false;
                case 1 -> {
                    var teacherController = new TeacherController(services.get(AppConst.TEACHER), new TeacherView());
                    teacherController.run();
                }
//                case 2 -> society.choosePerson();
//                case 3 -> society.printParents();
//                case 4 -> society.printChildren();
//                case 5 -> society.printBrothers();
//                case 6 -> society.printIsSameFamily();
//                case 7 -> RestAmbienceManager.run(society.getActivePerson());
                default -> view.showTaskError();
            }
        }

        view.showWorkComplete();
    }
}
