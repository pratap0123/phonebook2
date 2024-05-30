package com.pd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.dto.EmployeeDTO;
import com.pd.response.EmployeeResponse;
import com.pd.service.IEmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<?> saveEmployeeDetails(@Valid @RequestBody EmployeeDTO employee, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errors = new HashMap<>();
			result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		String saved = employeeService.saveEmployeeDetails(employee);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@GetMapping("/fetch")
	public ResponseEntity<List<EmployeeResponse>> fetchAllEmployeeDetails() {
		List<EmployeeResponse> empResposes = employeeService.fetchEmployeeTaxDetails();
		return new ResponseEntity<>(empResposes, HttpStatus.CREATED);
	}
}
