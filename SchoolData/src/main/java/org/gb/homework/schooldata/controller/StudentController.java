package org.gb.homework.schooldata.controller;

import org.gb.homework.schooldata.model.Student;
import org.gb.homework.schooldata.service.UserService;
import org.gb.homework.schooldata.view.StudentView;

public class StudentController {
    private final UserService<Student> studentService;
    private final StudentView view;
    public Student currentStudent;

    public StudentController(UserService<Student> service, StudentView view) {
        this.studentService = service;
        this.view = view;
    }


    public void printAll() {
        var users = studentService.getAllUsers();
        view.showAll(users);
    }

    public void run() {
        var isWorking = true;

        while (isWorking) {

            var numberTask = view.showMenu(currentStudent);

            switch (numberTask) {
                case 0 -> isWorking = false;
                case 1 -> printAll();
                case 2 -> chooseStudent();
                case 3 -> addStudent();
                case 4 -> editStudent();
                case 5 -> deleteStudent();
                default -> view.showTaskError();
            }
        }

    }

    private void deleteStudent() {
        if (currentStudent == null) {
            view.showCurrentStudentError();
            return;
        }
        studentService.remove(currentStudent);
        currentStudent = null;
    }

    private void editStudent() {
        if (currentStudent == null) {
            view.showCurrentStudentError();
            return;
        }

        var name = view.inputName();
        var grade = view.inputGrade();
        var year = view.inputYear();
        currentStudent.setName(name);
        currentStudent.setGrade(grade);
        currentStudent.setYear(year);
        studentService.edit(currentStudent);
    }

    private void addStudent() {
        var name = view.inputName();
        var grade = view.inputGrade();
        var year = view.inputYear();

        var nextId = studentService.getNextId();

        studentService.add(new Student(nextId, name, (float) grade, year));
    }

    private void chooseStudent() {
        var nextId = studentService.getNextId();
        var teacherId = view.getStudentId(nextId);

        currentStudent = studentService.getAllUsers().stream().filter(x -> x.getId() == teacherId)
                .findFirst().orElse(null);
    }
}
