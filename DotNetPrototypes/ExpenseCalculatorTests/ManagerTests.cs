using System;
using ExpenseCalculator;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ExpenseCalculatorTests
{
    [TestClass]
    public class ManagerTests
    {
        private static ExpenseCalculatorTestHelper testHelper = new ExpenseCalculatorTestHelper();
        private Tuple<string, decimal> _qatester = testHelper.Employees.Find(delegate(Tuple<string, decimal> t) { return t.Item1 == "QA Tester"; });
        private Tuple<string, decimal> _developer = testHelper.Employees.Find(delegate(Tuple<string, decimal> t) { return t.Item1 == "Developer"; });
        private Tuple<string, decimal> _manager = testHelper.Employees.Find(delegate(Tuple<string, decimal> t) { return t.Item1 == "Manager"; });

        [TestMethod]
        /*  Manager
         *      QA Tester
         *      Developer
         *      1800
         */
        public void ManagerTotalExpenses_Equals_TotalEmployeeExpenses()
        {
            IEmployee qaTester = EmployeeFactory.Create(EmployeeType.Employee, _qatester.Item1, _qatester.Item2);
            IEmployee developer = EmployeeFactory.Create(EmployeeType.Employee, _developer.Item1, _developer.Item2);
            Manager manager = (Manager)EmployeeFactory.Create(EmployeeType.Manager, _manager.Item1, _manager.Item2);

            manager.Employees.Add(qaTester);
            manager.Employees.Add(developer);

            Assert.AreEqual(manager.GetTotalExpenses(), testHelper.GetTotalExpenses());
        }

        [TestMethod]
        /* Manager
         *      QA Tester
         *      Developer
         *      Manager
         *          QA Tester
         *          Developer
         *          3600
         */
        public void NestedManagerTotalExpenses_Equals_TotalEmployeeExpenses()
        {
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

            Assert.AreEqual(manager2.GetTotalExpenses(), manager1Expenses + manager2Expenses);
        }

        [TestMethod]
        /* Manager
         *      Manager
         *          QA Tester
         *          Developer
         *          2100
         */
        public void NestedManagerSampleScenarioTotalExpenses_Equals_TotalEmployeeExpenses()
        {
            IEmployee qaTester1 = EmployeeFactory.Create(EmployeeType.Employee, _qatester.Item1, _qatester.Item2);
            IEmployee developer1 = EmployeeFactory.Create(EmployeeType.Employee, _developer.Item1, _developer.Item2);
            Manager manager1 = (Manager)EmployeeFactory.Create(EmployeeType.Manager, _manager.Item1, _manager.Item2);

            manager1.Employees.Add(qaTester1);
            manager1.Employees.Add(developer1);

            decimal manager1Expenses = testHelper.GetTotalExpenses();

            Manager manager2 = (Manager)EmployeeFactory.Create(EmployeeType.Manager, _manager.Item1, _manager.Item2);

            decimal manager2Expenses = manager2.GetTotalExpenses();

            manager2.Employees.Add(manager1);

            Assert.AreEqual(manager2.GetTotalExpenses(), manager1Expenses + manager2Expenses);
        }
    }
}
