/*Program name: exercise 9_9.java
* Author: Laura Amorim
* Date last updated: 01/18/2026
* Purpose: define RegularPolygon class and three different constructors with defined values
*/

public class exercise9_9 {
    public static void main(String[] args) // main to display result
    {
    
        RegularPolygon firstPolygon = new RegularPolygon();
        RegularPolygon secondPolygon = new RegularPolygon(6, 4);
        RegularPolygon thirdPolygon = new RegularPolygon(10, 4, 5.6, 7.8);
        
        System.out.println("First perimeter: " + firstPolygon.getPerimeter());
        System.out.println("First area: " + firstPolygon.getArea());

        System.out.println("Second perimeter: " + secondPolygon.getPerimeter());
        System.out.println("Second area: " + secondPolygon.getArea());

        System.out.println("Third perimeter: " + thirdPolygon.getPerimeter());
        System.out.println("Third area: " + thirdPolygon.getArea());
    }

   static class RegularPolygon 
    {
        private int n = 3; //defines number of sides
        private double side = 1; //defines lenght of the side
        private double x = 0; //defines x coordinate of polygons center
        private double y = 0; //defines x coordinate of polygons center

        RegularPolygon(){}//no arg constructor
        
        RegularPolygon(int newN, int newSide)
        {
            n = newN;
            side = newSide;
        }

        RegularPolygon(int newN, double newSide, double newX, double newY){
            n = newN;
            side = newSide;
            x = newX;
            y = newY;
        }

        public int getN()//accessor methods
        { 
            return n;
        }  

        public double getSide()
        {
            return side;
        }

        public double getX()
        {
            return x;
        }

        public double getY()
        {
            return y;
        }

        public void setN(int newN) //mutator methods
        {
            n = newN;
        }

        public void setSide(double newSide)
        {
            side = newSide;
        }

        public void setX(double newX) 
        {
            x = newX;
        }

        public void setY(double newY) 
        {
            x = newY;
        }

        double getPerimeter()
        {
            return n * side; 
        }

        double getArea()
        {
            return (n * (side * side))/(4 * Math.tan(Math.PI / n));
        }
    }


}
