package org.gb.homework.schooldata.model.factories.impls;

import org.gb.homework.schooldata.AppConst;
import org.gb.homework.schooldata.model.Student;
import org.gb.homework.schooldata.model.factories.UserFactory;

public class StudentFactory implements UserFactory<Student> {

    @Override
    public Student deserialize(String line) {
        var strings = line.split(AppConst.DELIMITER);

        int id = Integer.parseInt(strings[1]);
        boolean isActual = Boolean.parseBoolean(strings[2]);
        String name = strings[3];
        float grade = Float.parseFloat(strings[4].replace(',', '.'));
        int year = Integer.parseInt(strings[5]);

        Student student = new Student(id, name, grade, year);
        student.setActual(isActual);

        return student;
    }
}
