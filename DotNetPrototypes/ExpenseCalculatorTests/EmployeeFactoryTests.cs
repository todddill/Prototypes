using System;
using ExpenseCalculator;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ExpenseCalculatorTests
{
    [TestClass]
    public class EmployeeFactoryTests
    {
        private static ExpenseCalculatorTestHelper testHelper = new ExpenseCalculatorTestHelper();
        private Tuple<string, decimal> _qatester = testHelper.Employees.Find(delegate(Tuple<string, decimal> t) { return t.Item1 == "QA Tester"; });
        private Tuple<string, decimal> _developer = testHelper.Employees.Find(delegate(Tuple<string, decimal> t) { return t.Item1 == "Developer"; });
        private Tuple<string, decimal> _manager = testHelper.Employees.Find(delegate(Tuple<string, decimal> t) { return t.Item1 == "Manager"; });

        [TestMethod]
        public void CreateQATester_Expense_Is_500()
        {

            IEmployee employee = EmployeeFactory.Create(EmployeeType.Employee, _qatester.Item1, _qatester.Item2);
            Assert.AreEqual(employee.ExpenseAllocation, _qatester.Item2);
        }

        [TestMethod]
        public void CreateDeveloper_Expense_Is_1000()
        {
            IEmployee employee = EmployeeFactory.Create(EmployeeType.Employee, _developer.Item1, _developer.Item2);
            Assert.AreEqual(employee.ExpenseAllocation, _developer.Item2);
        }

        [TestMethod]
        public void CreateManager_Expense_Is_300()
        {
            IEmployee employee = EmployeeFactory.Create(EmployeeType.Manager, _manager.Item1, _manager.Item2);
            Assert.AreEqual(employee.ExpenseAllocation, _manager.Item2);
        }
    }
}
