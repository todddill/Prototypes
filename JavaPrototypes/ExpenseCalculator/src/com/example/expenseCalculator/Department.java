package com.example.expenseCalculator;

import java.util.ArrayList;
import java.util.List;

public class Department implements Organizational{
	
	private String name = "";
	private List<Employee> employees = new ArrayList<Employee>();
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String value)
	{
		name = value;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public double getTotalExpenses() {
		double expenses = 0;
		
		for(Employee employee : employees)
		{
			if (employee.getClass() ==  Manager.class)
				expenses += ((Manager)employee).getTotalExpenses();
			else
				expenses += employee.getExpenseAllocation();
		}
		
		return expenses;
	}

}
