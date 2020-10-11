package com.paladin.account.vo;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author: paladin
 * @Description:
 * @date: created in 2020/8/26 22:44
 */
public class StudentVO {
	private String name;
	private int age;
	private String add;

	public StudentVO() {
	}

	public StudentVO(String name, int age, String add) {
		this.name = name;
		this.age = age;
		this.add = add;
	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		StudentVO studentVO = (StudentVO) o;
		return age == studentVO.age &&
				name.equals(studentVO.name) &&
				add.equals(studentVO.add);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age, add);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", StudentVO.class.getSimpleName() + "[", "]")
				.add("name='" + name + "'")
				.add("age=" + age)
				.add("add='" + add + "'")
				.toString();
	}
}
