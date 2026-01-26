/*Program name: exercise11_1.java
* Author: Laura Amorim
* Date last updated: 01/25/2026
* Purpose: define Triangle class and create an object based on user input
*/
import java.util.Scanner;

public class exercise11_1 {
    public static void main(String[] args) //test program
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size #1: ");
        double side1 = input.nextDouble();

        System.out.print("Enter size #2: ");
        double side2 = input.nextDouble();

        System.out.print("Enter size #3: ");
        double side3 = input.nextDouble();

        System.out.print("Enter a color: ");
        String color = input.next();

        System.out.print("Is the triangle filled?(True/False) ");
        boolean filled = input.nextBoolean();

        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);

        System.out.println("\nArea: " + triangle.getArea()); //displays input
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Is filled? " + triangle.isFilled());


        input.close();
    }
    static class Triangle extends GeometricObject
    {
        private double side1 = 1.0;
        private double side2 = 1.0;
        private double side3 = 1.0;

        public Triangle(){} //no arg constructor

        public Triangle(double side1, double side2, double side3)
        {
            this.side1 =side1;
            this.side2 =side2;
            this.side3 =side3;
        } 

        public double getSide1() //accessor methods
        {
            return side1;
        }

        public double getSide2()
        {
            return side2;
        }

        public double getSide3()
        {
            return side3;
        }

        @Override
        public double getArea() { //triangle area
            double s = (side1 + side2+ side3)/2;
            return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
        }

        @Override
        public double getPerimeter() { //triangle perimenter
            return (side1+side2+side3);
        }

        @Override
        public String toString(){
            return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
        }
       
    }
}
