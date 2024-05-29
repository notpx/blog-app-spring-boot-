package com.example.demo;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String dep;
	
	
	@JsonIgnore
    @OneToMany(mappedBy = "student")
    List<Marks> marks;

	
	

}
