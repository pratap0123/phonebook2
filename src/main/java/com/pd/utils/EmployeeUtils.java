package com.pd.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import com.pd.constants.Constants;
import com.pd.entity.Employee;
import com.pd.response.EmployeeResponse;

public class EmployeeUtils {

	public static String generateEmpCode() {
		Random random = new Random();
		int legth = 4;
		StringBuilder empCode = new StringBuilder();
		for (int i = 0; i < legth; i++) {
			empCode.append(random.nextInt(10));
		}
		return (Constants.EMPLOYEE_CODE_PREFIX + empCode.toString() + 
				Constants.EMPLOYEE_CODE_SUFFIX);

	}

	public static EmployeeResponse calculateTaxEmployee(Employee employee) {
		EmployeeResponse empResponse = calculateTaxForEmployee(employee);
		return empResponse;

	}

	private static EmployeeResponse calculateTaxForEmployee(Employee employee) {
		EmployeeResponse empResponse = new EmployeeResponse();
		empResponse.setEmpCode(employee.getEmpCode());
		empResponse.setFirstName(employee.getFirstName());
		empResponse.setLastName(employee.getLastName());

		LocalDate doj = employee.getDoj();
		LocalDate financialYear = LocalDate.of(LocalDate.now().getYear(), 4, 1);
		if (doj.isAfter(financialYear)) {
			financialYear = doj.withDayOfMonth(1).plusMonths(1);
		}
		long monthsWorked = ChronoUnit.MONTHS.between(financialYear, LocalDate.now()) + 1;

		Double yearlySalary = employee.getSalary() * monthsWorked;
		empResponse.setYearlySalary(yearlySalary);
		Double taxAmount = calculateTax(yearlySalary);

		Double cessAmount = (yearlySalary > 2500000) ? (yearlySalary - 2500000) * 0.02 : 0;

		empResponse.setTaxAmount(taxAmount);
		empResponse.setCessAmount(cessAmount);

		return empResponse;
	}

	private static double calculateTax(double yearlySalary) {
		double tax = 0;
		if (yearlySalary > 1000000) {
			tax += (yearlySalary - 1000000) * 0.20;
			yearlySalary = 1000000;
		}
		if (yearlySalary > 500000) {
			tax += (yearlySalary - 500000) * 0.10;
			yearlySalary = 500000;
		}
		if (yearlySalary > 250000) {
			tax += (yearlySalary - 250000) * 0.05;
		}
		return tax;
	}

}
