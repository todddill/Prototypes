package com.example.expenseCalculator;

public class EmployeeInst implements Employee {

	private String title = "";
	private Double expenseAllocation = (double) 0;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String value) {
		title = value;
	}

	public double getExpenseAllocation() {
		return expenseAllocation;
	}

	public void setExpenseAllocation(double value) {
		expenseAllocation = value;
	}
	
	public EmployeeInst(String title, double expenseAllocation)
	{
		this.title = title;
		this.expenseAllocation = expenseAllocation;
	}

}
