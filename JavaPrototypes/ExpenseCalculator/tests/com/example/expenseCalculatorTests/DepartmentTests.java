package com.example.expenseCalculatorTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.expenseCalculator.Department;
import com.example.expenseCalculator.Employee;
import com.example.expenseCalculator.EmployeeFactory;
import com.example.expenseCalculator.EmployeeType;
import com.example.expenseCalculator.Manager;

public class DepartmentTests {

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
	public void DepartmentTotalExpenses_Equals_TotalEmployeeExpenses() {
		
		Department marketing = new Department() {{
				setName("Markteting");
			}};
		
		Employee employeeQA = EmployeeFactory.create(EmployeeType.Employee, _qatester.x, _qatester.y);
		Employee employeeDEV = EmployeeFactory.create(EmployeeType.Employee, _developer.x, _developer.y);
		Manager employeeMGR = (Manager) EmployeeFactory.create(EmployeeType.Manager, _manager.x, _manager.y);
	
		employeeMGR.getEmployees().add(employeeQA);
		employeeMGR.getEmployees().add(employeeDEV);
		
		marketing.getEmployees().add(employeeMGR);
		
		Assert.assertEquals(testHelper.getTotalExpenses(), marketing.getTotalExpenses(), 0);
	}
	
	@Test
	public void DepartmentWithStandAloneEmployeesTotalExpenses_Equals_TotalEmployeeExpenses() {
		
		Department marketing = new Department() {{
				setName("Markteting");
			}};
		
		Employee employeeQA = EmployeeFactory.create(EmployeeType.Employee, _qatester.x, _qatester.y);
		Employee employeeDEV = EmployeeFactory.create(EmployeeType.Employee, _developer.x, _developer.y);
		Manager employeeMGR = (Manager) EmployeeFactory.create(EmployeeType.Manager, _manager.x, _manager.y);
	
		employeeMGR.getEmployees().add(employeeQA);
		employeeMGR.getEmployees().add(employeeDEV);
		
		double manager1Expenses = testHelper.getTotalExpenses();
		
		Employee employeeQA1 = EmployeeFactory.create(EmployeeType.Employee, _qatester.x, _qatester.y);
		Employee employeeDEV1 = EmployeeFactory.create(EmployeeType.Employee, _developer.x, _developer.y);
		
		marketing.getEmployees().add(employeeQA1);
		marketing.getEmployees().add(employeeDEV1);
		marketing.getEmployees().add(employeeMGR);
		
		Assert.assertEquals(manager1Expenses + employeeQA1.getExpenseAllocation() + employeeDEV1.getExpenseAllocation(), marketing.getTotalExpenses(),  0);
	}
	
	@Test
	public void DepartmentWithNestedManagerTotalExpenses_Equals_TotalEmployeeExpenses() {
		
		Department marketing = new Department() {{
			setName("Markteting");
		}};
		
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
		
		marketing.getEmployees().add(employeeMGR1);
		
		Assert.assertEquals(totalExpenses, marketing.getTotalExpenses(), 0);
	}

}
