using System;
using System.Collections.Generic;
using System.IO;
using Microsoft.Win32;
using System.Globalization;

namespace CS_LibrarySystem
{
    public class Library
    {
        private int count;
        private string[] words;
        private List<Book> Books;
        private List<Book> CheckedOut;

        public Library (int count)
        {
            this.count = count;
            this.Books = new List<Book>();
            this.CheckedOut = new List<Book>();

            //get directory and load all words (excluding alpha-numerics, only alpha words)
            string projectDirectory = Directory.GetParent(Environment.CurrentDirectory).Parent.FullName;
            projectDirectory += "/words_alpha.txt";
            this.words = File.ReadAllLines(projectDirectory);

            // populate book titles list
            for (int i = 0; i < count; i++)
            {
                Random rnd = new Random();
                string fullName = "";

                int words = rnd.Next(5);
                for (int j = 0; j < words; j++)
                {
                    string selectedWord = "";
                    if (j != (words - 1))
                    {
                        selectedWord += (this.words[rnd.Next(this.words.Length)] + " ");
                    } else
                    {
                        selectedWord += (this.words[rnd.Next(this.words.Length)]);
                    }
                    fullName += selectedWord;
                }
                this.Books.Add(new Book(ToTitleCase(fullName), (int)rnd.Next(100, 750)));
            }
        }

        //sets every first letter to Uppercase
        protected string ToTitleCase(string str)
        {
            return CultureInfo.CurrentCulture.TextInfo.ToTitleCase(str.ToLower());
        }

        // get book by index
        public void getBookByIndex(int index)
        {
            try
            {
                int trueIndex = index - 1;
                Book selectedBook = this.Books[trueIndex];
                Console.WriteLine(selectedBook.getName());
            } catch (ArgumentOutOfRangeException e)
            {
                Console.WriteLine("Out of range, max range is " + (this.Books.Count));
            }
        }

        // checks out a valid book
        public void checkoutBook(int index)
        {
            try
            {
                int trueIndex = index - 1;
                Book selectedBook = this.Books[trueIndex];
                this.Books.RemoveAt(trueIndex); // remove the checked out book from available book list
                Console.WriteLine("Checking out '" + selectedBook.getName() + "'");
                this.CheckedOut.Add(selectedBook);
                selectedBook.setCheckedOut(true);
            } catch (ArgumentOutOfRangeException e)
            {
                Console.WriteLine("Out of range, max range is " + (this.Books.Count));
            }
        }

        // turns in a valid book
        public void turnInBook(int index)
        {
            try
            {
                int trueIndex = index - 1;
                Book selectedBook = this.CheckedOut[trueIndex];
                this.CheckedOut.RemoveAt(trueIndex);
                Console.WriteLine("Returning '" + selectedBook.getName() + "'");
                this.Books.Add(selectedBook);
                selectedBook.setCheckedOut(false);
            } catch (ArgumentOutOfRangeException e)
            {
                Console.WriteLine("Out of range, max range is " + (this.CheckedOut.Count));
            }
        }

        // displays checked out books
        public void showCheckedOutBooks()
        {
            if (CheckedOut.Count > 0)
            {
                foreach (Book b in CheckedOut)
                {
                    Console.WriteLine("Own '" + b.getName() + "'");
                }
            } else
            {
                Console.WriteLine("You don't have any books!");
            }
        }
    }
}
