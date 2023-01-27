package org.gb.homework.schooldata.model.factories.impls;

import org.gb.homework.schooldata.model.Teacher;
import org.gb.homework.schooldata.model.factories.UserFactory;

public class TeacherFactory implements UserFactory<Teacher> {

    @Override
    public Teacher deserialize(String line) {
        var strings = line.split(";\t;");

        int id = Integer.parseInt(strings[1]);
        boolean isActual = Boolean.parseBoolean(strings[2]);
        String name = strings[3];

        Teacher teacher = new Teacher(id, name);
        teacher.setActual(isActual);

        return teacher;
    }
}
