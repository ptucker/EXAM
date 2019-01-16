// A class defining Triangle objects

public class Triangle implements Shape {

    // private attributes
    int idNumber;
    String color;
    int side1;
    int side2;
    int side3;
    int perimeter;

    /**
     * No arg constructor
     */
    public Triangle() {}

    /**
     * Triangle object constructor that initializes a Triangle given its id number, color, and the length of its sides
     * @param idNumber represents this Triangle object's id number
     * @param color represents this Triangle object's color
     * @param side1 represents the length of the first side of this Triangle object
     * @param side2 represents the length of the second side of this Triangle object
     * @param side3 represents the length of the third side of this Triangle object
     */
    public Triangle(int idNumber, String color, int side1, int side2, int side3) {
        this.idNumber = idNumber;
        this.color = color;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        perimeter = side1 + side2 + side3;
    }

   // Setters
 
      // Getters
 
     /**
      * A function that provides a string declaring that this Triangle object is a Triangle and its id number as well
      * @return a string saying Rectangle followed by this Triangle objects id number
      */
      public String toString() { return String.format("Triangle (ID#  " + idNumber + ")"); }
 
      /**
       * A function that provides a string declaring that this Triangle object is a Triangle
       * @return a string saying Triangle
       */
      public String getKind() { return "Triangle"; }
  
      /**
       * A function to format a little display message defining the characteristics of this Triangle object
       * @return a formatted string representation of this Triangle object
       */
      public String getDetailString() { return String.format(toString() + "\n" + "Color: " + color + "\n" + "Length of side 1: " +side1 + "\n" + "Length of side 2: " + side2 + "\n" + "Length of side 3: " + side3 + "\n" + "Perimeter: " + perimeter); }
      
      /**
       * A function to capture this Triangle object's id number
       * @return the integer value representing this Triangle object's id number
       */
      public int getID() { return idNumber; }
 
     }
