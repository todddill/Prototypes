using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DataObjectsWrapper;

namespace CouchDBConfigDataDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            string check;
            do
            {
                Console.WriteLine(WriteTestUrl());
                Console.WriteLine("enter a command (refresh, exit):");
                check = Console.ReadLine();
            }
            while (check.Equals("refresh"));

            if (!check.Equals("exit"))
            {
                Console.WriteLine("invalid command - exiting");
            }

            Environment.Exit(0);
        }

        private static string WriteTestUrl()
        {
            CouchDbDataAccessLayer dal = new CouchDbDataAccessLayer("http://localhost:5984/sample_config");

            string testurl = GetTestUrl(dal);
            return "test URL:  " + testurl;
        }

        private static string GetTestUrl(CouchDbDataAccessLayer dal)
        {
            string testurl = dal.GetJsonValue("4ef4a8097e1f9e72022a2a7303000daa", "testurl");
            return testurl;
        }
    }
}
