using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FizzBuzz
{
    class Program
    {
        static void Main(string[] args)
        {
            int input = 0;

            string stdin = Console.ReadLine();

            if (stdin.Length > 0 && int.TryParse(stdin, out input))
                printNumbers(input);
            else
                Console.WriteLine("Invalid input");
            Console.WriteLine("Press any to continue...");
            Console.ReadLine();
        }

        private static void printNumbers(int input)
        {
            for (int number = 1; number <= input; number++)
            {
                if (number % 3 == 0 && number % 5 == 0) Console.WriteLine("FizzBuzz");
                else if (number % 3 == 0) Console.WriteLine("Fizz");
                else if (number % 5 == 0) Console.WriteLine("Buzz");
                else Console.WriteLine(number);
            }
        }
    }
}
