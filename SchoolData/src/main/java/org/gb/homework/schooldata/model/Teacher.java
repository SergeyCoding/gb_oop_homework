package org.gb.homework.schooldata.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher extends User {
    private List<Student> group = new ArrayList<>();

    public Teacher(int id, String name) {
        super(id, name);
    }

    public List<Student> getGroup() {
        return group.stream().toList();
    }

    public void addStudent(Student student) {
        this.group.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("id=%d name=%s", getId(), name);
    }
}
