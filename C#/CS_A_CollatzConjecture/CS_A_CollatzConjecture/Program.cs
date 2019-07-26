using System;

namespace CS_A_CollatzConjecture
{
    class MainClass
    {
        public static int attempts = 0;
        public static void Main(string[] args)
        {
            Console.WriteLine("Enter n: ");
            int n = Convert.ToInt32(Console.ReadLine());
            Collatz(n);
        }
        // n>1
        // if even, divide by 2
        // if odd, multiply by 3 and add 1
        // how long to reach one?
        public static void Collatz(int n)
        {
            if (n < 1)
            {
                Console.WriteLine("Must be greater than 1!");
            }
            if (n % 2 == 0)
            {
                Collatz(n / 2);
            }
            if (n % 2 != 0)
            {
                Collatz((n * 3) + 1);
            }
            if (n == 1)
            {
                Console.WriteLine("Done! Took " + attempts + " attempts!");
            }
            attempts++;
        }
    }
}
