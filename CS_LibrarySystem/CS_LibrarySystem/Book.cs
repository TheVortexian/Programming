using System;
namespace CS_LibrarySystem
{
    public class Book
    {
        private string name;
        private int pages;
        bool checkedOut;

        public Book(string name, int pages)
        {
            this.name = name;
            this.pages = pages;
            this.checkedOut = false;
        }

        public string getName()
        {
            return this.name;
        }
        public int getPages()
        {
            return this.pages;
        }
        public bool isCheckedOut()
        {
            return this.checkedOut;
        }
        public void setCheckedOut(bool b)
        {
            this.checkedOut = b;
        }
    }
}
