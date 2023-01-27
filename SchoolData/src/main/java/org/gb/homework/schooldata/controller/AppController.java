package org.gb.homework.schooldata.controller;


import org.gb.homework.schooldata.AppConst;
import org.gb.homework.schooldata.service.UserService;
import org.gb.homework.schooldata.view.AssignView;
import org.gb.homework.schooldata.view.SchoolDataView;
import org.gb.homework.schooldata.view.StudentView;
import org.gb.homework.schooldata.view.TeacherView;

import java.util.Map;

public class AppController {
    private final Map<String, UserService> services;

    public AppController(Map<String, UserService> services) {
        this.services = services;
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
                case 2 -> {
                    var studentController = new StudentController(services.get(AppConst.STUDENT), new StudentView());
                    studentController.run();
                }
                case 3 -> {
                    var assignController = new AssignController(services.get(AppConst.TEACHER), services.get(AppConst.STUDENT), new AssignView());
                    assignController.run();
                }
                default -> view.showTaskError();
            }
        }

        view.showWorkComplete();
    }
}
