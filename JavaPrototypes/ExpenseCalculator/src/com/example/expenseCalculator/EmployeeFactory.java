package com.example.expenseCalculator;

public class EmployeeFactory {

	public static Employee create(EmployeeType employeeType, String title, Double expenseAllocation) {
		switch (employeeType) {
			case Manager:
				return new Manager(title, expenseAllocation);
			default:
				return new EmployeeInst(title, expenseAllocation);
		}
	}
}
