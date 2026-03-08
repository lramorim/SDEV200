/*Program name: Library.java
* Author: Laura Amorim
* Date last updated: 3/6/2026
* Purpose: define Library class
*/

import java.util.ArrayList;

public class Library 
{
    private int total;
    private ArrayList<Book> books;
    private ArrayList<AudioBook> audioBooks;

    public Library()
    {
        books = new ArrayList<>();
        audioBooks = new ArrayList<>();
        total = 0;
    }

    public void addBook(Book book)
    {
        books.add(book);
        total++;
    }

    public void addAudioBook(AudioBook audioBook)
    {
        audioBooks.add(audioBook);
        total++;
    }


    public int getTotal()
    {
        return total;
    }

    public ArrayList<Book> getBooks() //object arrays
    {
        return books;
    }

    public ArrayList<AudioBook> getAudioBooks() 
    {
        return audioBooks;
    }

    public void printLibrary() 
    {
        System.out.println("\n-Books-");
        for (Book b : books) 
        {
            System.out.println(b);
        }

        System.out.println("\n-Audiobooks-");
        for (AudioBook a : audioBooks) 
        {
            System.out.println(a);
        }
    }

}
