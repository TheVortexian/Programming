using System;
namespace CS_LibrarySystem
{
    public class Book
    {

        public Book(string name, int pages)
        {
            this.name = name;
            this.pages = pages;
            this.checkedOut = false;
        }

        public string name { get; set; }
        public int pages { get; set; }
        public bool checkedOut { get; set; }
    }
}
