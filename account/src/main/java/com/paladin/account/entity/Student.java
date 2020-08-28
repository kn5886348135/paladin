package com.paladin.account.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 *  @author: paladin
 *  @Description:
 *  @date: created in 2020/8/26 20:27
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 2873889802257388937L;

    private String name;
    private int age;
    private String add;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public Student() {
    }

    public Student(String name, int age, String add) {
        this.name = name;
        this.age = age;
        this.add = add;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return age == student.age &&
                name.equals(student.name) &&
                add.equals(student.add);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, add);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("add='" + add + "'")
                .toString();
    }
}
