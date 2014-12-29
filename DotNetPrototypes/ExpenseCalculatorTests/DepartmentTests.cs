using System;
using ExpenseCalculator;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ExpenseCalculatorTests
{
    [TestClass]
    public class DepartmentTests
    {
        private static ExpenseCalculatorTestHelper testHelper = new ExpenseCalculatorTestHelper();
        private Tuple<string, decimal> _qatester = testHelper.Employees.Find(delegate(Tuple<string, decimal> t) { return t.Item1 == "QA Tester"; });
        private Tuple<string, decimal> _developer = testHelper.Employees.Find(delegate(Tuple<string, decimal> t) { return t.Item1 == "Developer"; });
        private Tuple<string, decimal> _manager = testHelper.Employees.Find(delegate(Tuple<string, decimal> t) { return t.Item1 == "Manager"; });

        [TestMethod]
        public void DepartmentTotalExpenses_Equals_TotalEmployeeExpenses()
        {
            Department marketing = new Department { 
                Name = "Markteting"
            };

            IEmployee qaTester = EmployeeFactory.Create(EmployeeType.Employee, _qatester.Item1, _qatester.Item2);
            IEmployee developer = EmployeeFactory.Create(EmployeeType.Employee, _developer.Item1, _developer.Item2);
            Manager manager = (Manager)EmployeeFactory.Create(EmployeeType.Manager, _manager.Item1, _manager.Item2);

            manager.Employees.Add(qaTester);
            manager.Employees.Add(developer);

            marketing.Employees.Add(manager);

            Assert.AreEqual(marketing.GetTotalExpenses(), testHelper.GetTotalExpenses());
        }

        [TestMethod]
        public void DepartmentWithStandAloneEmployeesTotalExpenses_Equals_TotalEmployeeExpenses()
        {
            Department marketing = new Department
            {
                Name = "Markteting"
            };

            IEmployee qaTester1 = EmployeeFactory.Create(EmployeeType.Employee, _qatester.Item1, _qatester.Item2);
            IEmployee developer1 = EmployeeFactory.Create(EmployeeType.Employee, _developer.Item1, _developer.Item2);
            Manager manager = (Manager)EmployeeFactory.Create(EmployeeType.Manager, _manager.Item1, _manager.Item2);

            manager.Employees.Add(qaTester1);
            manager.Employees.Add(developer1);

            decimal manager1Expenses = testHelper.GetTotalExpenses();

            IEmployee qaTester2 = EmployeeFactory.Create(EmployeeType.Employee, _qatester.Item1, _qatester.Item2);
            IEmployee developer2= EmployeeFactory.Create(EmployeeType.Employee, _developer.Item1, _developer.Item2);

            marketing.Employees.Add(manager);
            marketing.Employees.Add(qaTester2);
            marketing.Employees.Add(developer2);

            Assert.AreEqual(marketing.GetTotalExpenses(), manager1Expenses + qaTester2.ExpenseAllocation + developer2.ExpenseAllocation);
        }

        [TestMethod]
        public void DepartmentWithNestedManagerTotalExpenses_Equals_TotalEmployeeExpenses()
        {
            Department marketing = new Department
            {
                Name = "Markteting"
            };

            IEmployee qaTester1 = EmployeeFactory.Create(EmployeeType.Employee, _qatester.Item1, _qatester.Item2);
            IEmployee developer1 = EmployeeFactory.Create(EmployeeType.Employee, _developer.Item1, _developer.Item2);
            Manager manager1 = (Manager)EmployeeFactory.Create(EmployeeType.Manager, _manager.Item1, _manager.Item2);

            manager1.Employees.Add(qaTester1);
            manager1.Employees.Add(developer1);

            decimal manager1Expenses = testHelper.GetTotalExpenses();

            IEmployee qaTester2 = EmployeeFactory.Create(EmployeeType.Employee, _qatester.Item1, _qatester.Item2);
            IEmployee developer2 = EmployeeFactory.Create(EmployeeType.Employee, _developer.Item1, _developer.Item2);
            Manager manager2 = (Manager)EmployeeFactory.Create(EmployeeType.Manager, _manager.Item1, _manager.Item2);

            manager2.Employees.Add(qaTester2);
            manager2.Employees.Add(developer2);

            decimal manager2Expenses = testHelper.GetTotalExpenses();

            manager2.Employees.Add(manager1);

            marketing.Employees.Add(manager2);

            Assert.AreEqual(marketing.GetTotalExpenses(), manager1Expenses + manager2Expenses);
        }

    }
}
