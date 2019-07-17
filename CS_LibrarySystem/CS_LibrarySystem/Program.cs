using System;

namespace CS_LibrarySystem
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            string userIn = "";
            bool exited = false;
            Console.WriteLine("Enter # of books in your library: ");
            int books = Convert.ToInt32(Console.ReadLine());
            Library lib = new Library(books);
            Console.WriteLine("Welcome to the Library.");
            Console.WriteLine("EXIT to exit, GET BOOK to get by index, CHECKOUT to check out a book by index,\n SEE BOOKS to view owned books," +
                "RETURN to return a book");
            while (!exited)
            {
                userIn = Console.ReadLine();
                switch(userIn.ToUpper())
                {
                    case ("CHECKOUT"):
                        //TODO: ADD CHECKOUT FUNCTIONS
                        Console.WriteLine("\nEnter index: ");
                        var _ = Convert.ToInt32(Console.ReadLine());
                        lib.checkoutBook(_);
                        break;
                    case ("GET BOOK"):
                        Console.WriteLine("\nEnter index: ");
                        _ = Convert.ToInt32(Console.ReadLine());
                        lib.getBookByIndex(_);
                        break;
                    case ("SEE BOOKS"):
                        lib.showCheckedOutBooks();
                        break;
                    case ("RETURN"):
                        Console.WriteLine("\nEnter index: ");
                        _ = Convert.ToInt32(Console.ReadLine());
                        lib.turnInBook(_);
                        break;
                    case ("EXIT"):
                        Console.WriteLine("\nExiting...");
                        exited = true;
                        break;
                }
            }
        }
    }
}
