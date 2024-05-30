package com.pd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.dto.EmployeeDTO;
import com.pd.entity.Employee;
import com.pd.exception.ResourceNotFoundException;
import com.pd.mapper.EmployeeMapper;
import com.pd.repository.EmployeeRepository;
import com.pd.response.EmployeeResponse;
import com.pd.utils.EmployeeUtils;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository EmpRepository;

	@Override
	public String saveEmployeeDetails(EmployeeDTO employeeDTO) {
		Employee employee = EmployeeMapper.convertEmpDtoToEntity(employeeDTO);
		EmpRepository.save(employee);
		return "Employee Created";
	}

	@Override
	public List<EmployeeResponse>  fetchEmployeeTaxDetails() {
		List<Employee> employees = EmpRepository.findAll();
		if(employees.isEmpty()) {
			 throw new ResourceNotFoundException("Employees are  not found");
		}
		List<EmployeeResponse> empResposes = new ArrayList<>();
		for (Employee emp : employees) {
			EmployeeResponse employee = EmployeeUtils.calculateTaxEmployee(emp);
			empResposes.add(employee);
		}
//		return employees.stream()
//				.map(EmployeeUtils.calculateTaxEmployee(null))
//		.collect(Collectors.toList());
		return empResposes;
	}

}
