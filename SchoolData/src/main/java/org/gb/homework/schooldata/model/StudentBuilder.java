package org.gb.homework.schooldata.model;

/**
 * V
 */
public class StudentBuilder {
    int id;
    String name;
    float grade = 0;
    int year = 0;
    boolean isSetId = false;
    boolean isSetName = false;

    public StudentBuilder setId(int id) {
        if (id <= 0)
            return this;

        this.id = id;
        isSetId = true;
        return this;
    }

    public StudentBuilder setName(String name) {
        if (name.isBlank())
            return this;

        this.name = name;
        isSetName = true;
        return this;
    }

    public StudentBuilder setGrade(float grade) {
        this.grade = grade;
        return this;
    }

    public StudentBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public Student build() {
        if (!isSetId)
            throw new IllegalArgumentException("Необходимо установить id");

        if (!isSetName)
            throw new IllegalArgumentException("Необходимо установить name");

        return new Student(this.id, this.name, this.grade, this.year);
    }
}
