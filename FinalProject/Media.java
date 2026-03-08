/*Program name: Media.java
* Author: Laura Amorim
* Date last updated: 03/6/2026
* Purpose: define Media class
*/

public abstract class Media {

    public enum Status
    {
        TO_BE_READ,
        CURRENTLY_READING,
        FINISHED;

        @Override
        public String toString() //Remove undescores from enum
        {
            String[] words = name().toLowerCase().split("_");
            StringBuilder result = new StringBuilder();
            for(String word : words)
            {
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
            return result.toString().trim();
        }
    }
    protected String title;
    protected String author;
    protected int rating;
    protected Status status;

    public Media(String title, String author) //constructor
    {
        this.title = title;
        this.author= author;
        this.status = Status.TO_BE_READ;
        this.rating = 0;
    }

    public String getTitle() //getters + setters
    {
        return title; 
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating) //error handling and makes sure books are completed before rating
    {
        if (status == Status.FINISHED && rating>=0 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Sorry, rating must be between 0 and 5 stars");
        }
    }

    public String getStars() //displays stars for rating instead of numbers
    {
        String stars = "";
        for (int i= 0; i < rating; i++)
        {
            stars += "⭐";
        }
        return stars;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public String toString() 
    {
        return title + " written by " + author + "\n | Rating: " + getStars() + " | Status: " + status;
    }
}
