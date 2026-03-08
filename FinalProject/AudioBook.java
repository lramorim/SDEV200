/*Program name: AudioBook.java
* Author: Laura Amorim
* Date last updated: 03/6/2026
* Purpose: define AudioBook class (Media child class)
*/

public class AudioBook extends Media 
{
    private String narrator;
    private double audioLength;

    public AudioBook(String title, String author, String narrator, double audioLength) //constructor
    {
        super(title, author);
        this.narrator = narrator;
        this.audioLength = audioLength;
    }

    public String getNarrator()//getters + setters
    {
        return narrator;
    }

    public void setNarrator(String narrator)
    {
        this.narrator = narrator;
    }

    public double getAudioLength()
    {
        return audioLength;
    }

    public void setAudioLength(double audioLength) //error handling
    {
    if (audioLength >= 0.5) {
            this.audioLength = audioLength;
        } else {
            System.out.println("Sorry, audio must be at least half an hour long.");
        }
    }

    @Override
    public String toString() {
        return title + " written by " + author + "\nRating: " + getStars() + " | Status: " + status + "\nNarrated by: " + narrator + " | Length: " + audioLength + " hours";
    }

}
