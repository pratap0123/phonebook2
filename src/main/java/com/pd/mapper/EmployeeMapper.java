package com.pd.mapper;

import com.pd.dto.EmployeeDTO;
import com.pd.entity.Employee;
import com.pd.utils.EmployeeUtils;

public class EmployeeMapper {

	public static Employee convertEmpDtoToEntity(EmployeeDTO employeeDTO) {

		Employee employee = new Employee();
		// generate EMP code
		employee.setEmpCode(EmployeeUtils.generateEmpCode());
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setEmail(employeeDTO.getEmail());
//		List<String> phoneNumbers=new ArrayList<>();
//		for(String phone:employeeDTO.getPhonNumbers()) {
//			phoneNumbers.add(phone);
//		}
		employee.setPhonNumbers(employeeDTO.getPhonNumbers());
		employee.setDoj(employeeDTO.getDoj());
		employee.setSalary(employeeDTO.getSalary());
		return employee;

	}

	public static Employee convertEntityToEmpResponse(Employee employee) {

		return employee;

	}
}
