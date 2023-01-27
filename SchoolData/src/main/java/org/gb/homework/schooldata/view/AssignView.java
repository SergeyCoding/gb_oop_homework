package org.gb.homework.schooldata.view;

import org.gb.homework.schooldata.model.Student;
import org.gb.homework.schooldata.model.Teacher;

import java.util.List;

public class AssignView {
    public void showTeacher(Teacher teacher) {
        System.out.printf("\nУчитель - %d %s\n", teacher.getId(), teacher.getName());

        List<Student> group = teacher.getGroup();

        if (group.size() == 0)
            System.out.println("\tстуденты не назначены");

        System.out.printf("\tстуденты:");
        for (var s : group) {
            System.out.printf("\t%d %s |", s.getId(), s.getName());
        }
        System.out.println();
    }

    public void showTitle() {
        System.out.println("\nРаспределение студентов по учителям:");
    }
}
