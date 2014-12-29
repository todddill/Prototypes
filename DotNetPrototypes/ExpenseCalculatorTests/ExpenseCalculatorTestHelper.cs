using System;
using System.Collections.Generic;

namespace ExpenseCalculatorTests
{
    public class ExpenseCalculatorTestHelper
    {
        public List<Tuple<string, decimal>> Employees = new List<Tuple<string, decimal>>
        {
            new Tuple<string, decimal>("QA Tester", 500),
            new Tuple<string, decimal>("Developer", 1000),
            new Tuple<string, decimal>("Manager", 300)
        };

        public decimal GetTotalExpenses()
        {
            decimal expenses = 0;
            foreach (Tuple<string, decimal> employee in this.Employees)
            {
                expenses += employee.Item2;
            }
            return expenses;
        }
    }
}
