namespace ExpenseCalculator
{
    public class EmployeeFactory
    {
        public static IEmployee Create(EmployeeType employeeType, string title, decimal expenseAllocation)
        {
            switch (employeeType) { 
                case EmployeeType.Manager:
                    return new Manager(title, expenseAllocation);
                default:
                    return new Employee(title, expenseAllocation);
            }
        }
    }

    public enum EmployeeType { 
        Manager,
        Employee
    }
}
