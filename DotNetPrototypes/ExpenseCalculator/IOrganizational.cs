using System.Collections.Generic;

namespace ExpenseCalculator
{
    public interface IOrganizational
    {
        List<IEmployee> Employees { get; }
        decimal GetTotalExpenses();
    }
}
