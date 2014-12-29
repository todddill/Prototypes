using System.Collections.Generic;

namespace ExpenseCalculator
{
    public class Department : IOrganizational
    {
        public string Name { get; set; }

        #region IOrganizational Members

        private List<IEmployee> employees = new List<IEmployee>();

        public List<IEmployee> Employees
        {
            get { return employees; }
        }

        public decimal GetTotalExpenses()
        {
            decimal expenses = 0;
            foreach (IEmployee employee in employees)
            {
                if (employee.GetType() == typeof(Manager))
                    expenses += ((Manager)employee).GetTotalExpenses();
                else
                    expenses += employee.ExpenseAllocation;
            }

            return expenses;
        }

        #endregion
    }
}
