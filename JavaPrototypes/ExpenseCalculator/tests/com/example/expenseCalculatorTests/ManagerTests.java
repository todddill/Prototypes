package com.example.expenseCalculatorTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.expenseCalculator.Employee;
import com.example.expenseCalculator.EmployeeFactory;
import com.example.expenseCalculator.EmployeeType;
import com.example.expenseCalculator.Manager;

public class ManagerTests {

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
	public void ManagerTotalExpenses_Equals_TotalEmployeeExpenses() {
		Employee employeeQA = EmployeeFactory.create(EmployeeType.Employee, _qatester.x, _qatester.y);
		Employee employeeDEV = EmployeeFactory.create(EmployeeType.Employee, _developer.x, _developer.y);
		Manager employeeMGR = (Manager) EmployeeFactory.create(EmployeeType.Manager, _manager.x, _manager.y);
	
		employeeMGR.getEmployees().add(employeeQA);
		employeeMGR.getEmployees().add(employeeDEV);
		
		Assert.assertEquals(testHelper.getTotalExpenses(), employeeMGR.getTotalExpenses(), 0);
	}
	
	@Test
	public void NestedManagerTotalExpenses_Equals_TotalEmployeeExpenses() {
		Employee employeeQA = EmployeeFactory.create(EmployeeType.Employee, _qatester.x, _qatester.y);
		Employee employeeDEV = EmployeeFactory.create(EmployeeType.Employee, _developer.x, _developer.y);
		Manager employeeMGR = (Manager) EmployeeFactory.create(EmployeeType.Manager, _manager.x, _manager.y);
	
		employeeMGR.getEmployees().add(employeeQA);
		employeeMGR.getEmployees().add(employeeDEV);
		
		double manager1Expenses = testHelper.getTotalExpenses();
		
		Employee employeeQA1 = EmployeeFactory.create(EmployeeType.Employee, _qatester.x, _qatester.y);
		Employee employeeDEV1 = EmployeeFactory.create(EmployeeType.Employee, _developer.x, _developer.y);
		Manager employeeMGR1 = (Manager) EmployeeFactory.create(EmployeeType.Manager, _manager.x, _manager.y);
		
		employeeMGR1.getEmployees().add(employeeQA1);
		employeeMGR1.getEmployees().add(employeeDEV1);
		
		double manager2Expenses = testHelper.getTotalExpenses();
		
		employeeMGR1.getEmployees().add(employeeMGR);
		
		double totalExpenses = manager1Expenses + manager2Expenses;
		
		Assert.assertEquals(totalExpenses, employeeMGR1.getTotalExpenses(), 0);
	}
	
	@Test
	public void NestedManagerSampleScenarioTotalExpenses_Equals_TotalEmployeeExpenses() {
		Employee employeeQA = EmployeeFactory.create(EmployeeType.Employee, _qatester.x, _qatester.y);
		Employee employeeDEV = EmployeeFactory.create(EmployeeType.Employee, _developer.x, _developer.y);
		Manager employeeMGR = (Manager) EmployeeFactory.create(EmployeeType.Manager, _manager.x, _manager.y);
	
		employeeMGR.getEmployees().add(employeeQA);
		employeeMGR.getEmployees().add(employeeDEV);
		
		double manager1Expenses = testHelper.getTotalExpenses();
		
		Manager employeeMGR1 = (Manager) EmployeeFactory.create(EmployeeType.Manager, _manager.x, _manager.y);
		
		employeeMGR1.getEmployees().add(employeeMGR);
		
		double totalExpenses = manager1Expenses + employeeMGR1.getExpenseAllocation();
		
		Assert.assertEquals(totalExpenses, employeeMGR1.getTotalExpenses(), 0);
	}
}
