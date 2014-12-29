package com.example.expenseCalculatorTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.expenseCalculator.Employee;
import com.example.expenseCalculator.EmployeeFactory;
import com.example.expenseCalculator.EmployeeType;

public class EmployeeFactoryTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	private static ExpenseCalculatorTestHelper testHelper = new ExpenseCalculatorTestHelper();
	private Pair<String, Double> _qatester = testHelper.findPairByString("QA Tester");
	private Pair<String, Double> _developer = testHelper.findPairByString("Developer");
	private Pair<String, Double> _manager = testHelper.findPairByString("Manager");

	@Test
	public void createQATester_Expense_Is_500() {
		Employee employee = EmployeeFactory.create(EmployeeType.Employee, _qatester.x, _qatester.y);
		
		double actual = employee.getExpenseAllocation();
		double expected = (double)_qatester.y;
		
		Assert.assertEquals(expected, actual, 0);
	}
	
	@Test
	public void createDeveloper_Expense_Is_1000() {
		Employee employee = EmployeeFactory.create(EmployeeType.Employee, _developer.x, _developer.y);
		
		double actual = employee.getExpenseAllocation();
		double expected = (double)_developer.y;
		
		Assert.assertEquals(expected, actual, 0);
	}
	
	@Test
	public void createManager_Expense_Is_300() {
		Employee employee = EmployeeFactory.create(EmployeeType.Employee, _manager.x, _manager.y);
		
		double actual = employee.getExpenseAllocation();
		double expected = (double)_manager.y;
		
		Assert.assertEquals(expected, actual, 0);
	}

}
