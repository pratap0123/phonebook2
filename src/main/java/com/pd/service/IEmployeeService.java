package com.pd.service;

import java.util.List;

import com.pd.dto.EmployeeDTO;
import com.pd.response.EmployeeResponse;

public interface IEmployeeService {

	String saveEmployeeDetails(EmployeeDTO employee);

	List<EmployeeResponse> fetchEmployeeTaxDetails();
}
