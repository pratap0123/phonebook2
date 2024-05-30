package com.pd.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String empCode;
	private String firstName;
	private String lastName;
	private String email;
	@ElementCollection
	@CollectionTable(name = "emp_phone_numbers",
		joinColumns = @JoinColumn(name = "id"))
	@Column(name = "phone_number")
	private List<String> phonNumbers;
	private LocalDate doj;
	private Double salary;

	public Employee() {
	}

	public Employee(Long id, String empCode, String firstName, String lastName, String email, List<String> phonNumbers,
			LocalDate doj, Double salary) {
		this.id = id;
		this.empCode = empCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phonNumbers = phonNumbers;
		this.doj = doj;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhonNumbers() {
		return phonNumbers;
	}

	public void setPhonNumbers(List<String> phonNumbers) {
		this.phonNumbers = phonNumbers;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
