using System.Collections.Generic;

namespace ExpenseCalculator 
{
    public class Manager : IEmployee, IOrganizational
    {
        #region IEmployee Members

        public string Title
        {
            get;
            set;
        }

        public decimal ExpenseAllocation
        {
            get;
            set;
        }

        #endregion

        public Manager(string title, decimal expenseAllocation)
        {
            this.Title = title;
            this.ExpenseAllocation = expenseAllocation;
        }

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

            return expenses + ExpenseAllocation;
        }

        #endregion
    }
}
