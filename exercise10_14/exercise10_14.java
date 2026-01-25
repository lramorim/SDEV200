/*Program name: exercise10_14.java
* Author: Laura Amorim
* Date last updated: 01/25/2026
* Purpose: define MyDate class and two MyDate objects
*/

import java.util.GregorianCalendar;

public class exercise10_14 {

    public static void main(String[] args) //test program
    {
        MyDate firstDate = new MyDate();
        MyDate secondDate = new MyDate(34355555133101L);

        System.out.println("The current date is: ");
        System.out.println("Year: " + firstDate.getYear());
        System.out.println("Month: " + firstDate.getMonth());
        System.out.println("Day: " + firstDate.getDay());

        System.out.println("\nThe specified date is: ");
        System.out.println("Year: " + secondDate.getYear());
        System.out.println("Month: " + secondDate.getMonth());
        System.out.println("Day: " + secondDate.getDay());

    }
    
    static class MyDate 
    {
        private int year;
        private int month;
        private int day;

        MyDate()//no arg construct
        {
            GregorianCalendar current = new GregorianCalendar();
            this.year = current.get(GregorianCalendar.YEAR);
            this.month = current.get(GregorianCalendar.MONTH);
            this.day = current.get(GregorianCalendar.DAY_OF_MONTH);
        } 

        MyDate(long elapsedTime) //elapsed time constructor
        {
            setDate(elapsedTime);
        }

        MyDate(int year, int month, int day) //constructor with specified year, month, day
        {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int getYear()//getters
        {
            return year;
        }

        public int getMonth()
        {
            return month;
        }

        public int getDay()
        {
            return day;
        }
        
        public void setDate (long elapsedTime)
        {
            GregorianCalendar current = new GregorianCalendar();
            current.setTimeInMillis(elapsedTime);
            this.year = current.get(GregorianCalendar.YEAR);
            this.month =  current.get(GregorianCalendar.MONTH);
            this.day =  current.get(GregorianCalendar.DAY_OF_MONTH);
        }

    }
}
