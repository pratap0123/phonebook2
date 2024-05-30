package com.pd.dto;

import java.time.LocalDate;
import java.util.List;

import com.pd.cutomanotations.ValidEmailFormat;
import com.pd.cutomanotations.ValidPhoneNumber;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EmployeeDTO {

	@NotEmpty(message = "First name is required")
	private String firstName;
	@NotEmpty(message = "Last name is required")
	private String lastName;
	
	//custom Annotations
	@ValidEmailFormat
	private String email;
	//custom Annotations
	@ValidPhoneNumber
	private List<String> phonNumbers;
	@NotNull(message = "Date of joining is required")
	private LocalDate doj;
	@Min(value = 0, message = "Salary should be a positive number")
	private Double salary;

	public EmployeeDTO() {

	}

	public EmployeeDTO(String firstName, String lastName, String email, List<String> phonNumbers, LocalDate doj,
			Double salary) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phonNumbers = phonNumbers;
		this.doj = doj;
		this.salary = salary;
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
