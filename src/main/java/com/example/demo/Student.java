package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class Student {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String dep;

	
	public Student() {
		
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dep=" + dep + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getDep()=" + getDep() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dep, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(dep, other.dep) && id == other.id && Objects.equals(name, other.name);
	}

	public Student(long id, String name, String dep) {
		super();
		this.id = id;
		this.name = name;
		this.dep = dep;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

}
