/*Program name: Circle2.java
* Author: Laura Amorim
* Date last updated: 01/31/2026
* Purpose: to rewrite the Circle class to extend GeometricObject and implement the Comparable interface. 
*/


public class Circle2 extends GeometricObject implements Comparable <Circle2>
{
  private double radius;

  public Circle2() { //calls geometricobject constructor
    super();
  }

  public Circle2(double radius) {
    super();
    this.radius = radius;
  }

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double radius) {
    this.radius = radius;
  }

  @Override /** Return area */
  public double getArea() {
    return radius * radius * Math.PI;
  }

  @Override /** Return perimeter */
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  @Override
  public int compareTo(Circle2 o) //Two Circle objects are equal if their radii are the same
  {
    if (this.radius > o.radius) {
      return 1;
      } 
      else if(this.radius < o.radius){
        return -1;
      }
    else 
      return 0;
  }

  @Override
  public boolean equals(Object obj) //equals
  {
    if(this == obj)
      return true;

    if(obj==null || getClass()!= obj.getClass())
      return false;

    Circle2 other = (Circle2) obj;
    return this.radius == other.radius;
  }

}