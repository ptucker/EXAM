// A class defining Rectangle objects

public class Rectangle implements Shape {

     // private attributes
     int idNumber;
     String color;
     int length;
     int width;
     int area;
     int perimeter;
 
     /**
      * No arg constructor
      */
     public Rectangle () {}
 
     /**
      * Rectangle object constructor initializes a Rectangle given an id number, color, length and width
      * @param idNumber represents this Rectangle object's id number
      * @param color represents this Rectangle object's color
      * @param sideLength represents this Rectangle object's length
      * @param width represents this Rectangle object's width
      */
     public Rectangle (int idNumber, String color, int length, int width) {
         this.idNumber = idNumber;
         this.color = color;
         this.length = length;
         area = length * width;
         perimeter = (length * 2) + (width * 2);
     }
 
     // Setters
 
      // Getters
 
     /**
      * A function that provides a string declaring that this Rectangle object is a Rectangle and its id number as well
      * @return a string saying Rectangle followed by this Square objects id number
      */
     public String toString() { return String.format("Rectangle (ID#  " + idNumber + ")"); }
 
     /**
      * A function that provides a string declaring that this Rectangle object is a Rectangle
      * @return a string saying Rectangle
      */
     public String getKind() { return "Triangle"; }
 
     /**
      * A function to format a little display message defining the characteristics of this Rectangle object
      * @return a formatted string representation of this Rectangle object
      */
     public String getDetailString() { return String.format(toString() + "\n" + "Color: " + color + "\n" + "Length: " + length + "\n" + "Width: " + width + "\n" + "Area: " + area + "\n" + "Perimeter: " + perimeter); }
     
     /**
      * A function to capture this Rectangle object's id number
      * @return the integer value representing this Rectangle object's id number
      */
     public int getID() { return idNumber; }

    }