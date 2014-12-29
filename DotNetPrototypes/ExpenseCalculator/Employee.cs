namespace ExpenseCalculator
{
    public class Employee : IEmployee
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

        public Employee(string title, decimal expenseAllocation)
        {
            this.Title = title;
            this.ExpenseAllocation = expenseAllocation;
        }
    }
}
