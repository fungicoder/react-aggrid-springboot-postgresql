package com.fordevs.spring.jpa.postgresql.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
	private Long student_id;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "dob")
	private String dob;

    @Column(name = "dept_id")
    private Long dept_id;

    private Long subject_learning_id;

	@Column(name = "is_active")
	private Boolean isActive;

	// Relations
	@ManyToOne
	@JoinColumn(name = "dept_id", insertable = false, updatable = false)
	private  Department department;

	@ManyToMany // (mappedBy = "students" )
	@JoinColumn(name = "subject_learning_id")
	private List<SubjectLearning> subjectLearning = new ArrayList<>();
}

