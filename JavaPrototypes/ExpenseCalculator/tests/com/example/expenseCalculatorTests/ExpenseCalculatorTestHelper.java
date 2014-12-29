package com.example.expenseCalculatorTests;

import java.util.Arrays;
import java.util.List;

public class ExpenseCalculatorTestHelper {
	public List<Pair<String, Double>> Employees = Arrays.asList(
			new Pair<String, Double>("QA Tester", (double) 500), 
			new Pair<String, Double>("Developer", (double) 1000), 
			new Pair<String, Double>("Manager", (double) 300)
	);
	
	public Pair<String, Double> findPairByString(String value)
	{
		for (Pair<String, Double> employee : this.Employees)
		{
			if (employee.x == value)
				return employee;
		}
		
		return null;
	}
	
	public double getTotalExpenses()
	{
		double expenses = 0;
		for (Pair<String, Double> employee : this.Employees)
		{
			expenses += employee.y;
		}
		return expenses;
	}

}
