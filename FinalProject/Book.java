/*Program name: Book.java
* Author: Laura Amorim
* Date last updated: 03/6/2026
* Purpose: define Book class (Media child class)
*/

public class Book extends Media
{

    private String genre;
    private int pages;

    public Book(String title, String author, String genre, int pages) //constructor
    {
        super(title, author);
        this.genre = genre;
        this.pages = pages;
    }
    
    public String getGenre() //getters+setters
    {
        return genre;
    }

    public void setGenre (String genre)
    {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) //error handling
    {
        if (pages > 0) {
            this.pages = pages;
        } else {
            System.out.println("Sorry, page number must be greater than 0.");
        }
    }

    @Override
    public String toString()
    {
        return title + " written by " + author + "\nRating: " + getStars() + " | Status: " + status + "\nGenre: " + genre +" | Pages: " + pages;
    }
}
