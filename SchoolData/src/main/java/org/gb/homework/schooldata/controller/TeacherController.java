package org.gb.homework.schooldata.controller;

import org.gb.homework.schooldata.model.Teacher;
import org.gb.homework.schooldata.service.UserService;
import org.gb.homework.schooldata.view.TeacherView;

public class TeacherController {
    private final UserService<Teacher> teacherService;
    private final TeacherView view;
    public Teacher currentTeacher;

    public TeacherController(UserService<Teacher> service, TeacherView view) {
        this.teacherService = service;
        this.view = view;
    }


    public void printAll() {
        var users = teacherService.getAllUsers();
        view.showAll(users);
    }

    public void run() {
        var isWorking = true;

        while (isWorking) {

            var numberTask = view.showMenu(currentTeacher);

            switch (numberTask) {
                case 0 -> isWorking = false;
                case 1 -> printAll();
                case 2 -> chooseTeacher();
//                case 3 -> society.printParents();
//                case 4 -> society.printChildren();
//                case 5 -> society.printBrothers();
//                case 6 -> society.printIsSameFamily();
//                case 7 -> RestAmbienceManager.run(society.getActivePerson());
                default -> view.showTaskError();
            }
        }

    }

    private void chooseTeacher() {
        var users = teacherService.getAllUsers();
        var teacherId = view.getTeacherId(users.size());
        currentTeacher = users.get(teacherId);
    }
}
