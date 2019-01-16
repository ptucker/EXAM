// A class defining a Square object

public class Square implements Shape {

    // private attributes
    int idNumber;
    String color;
    int sideLength;
    int area;
    int perimeter;

    /**
     * No arg constructor
     */
    public Square () {}

    /**
     * Square object constructor initializes a Square given an id number, color, and side length
     * @param idNumber represents this Square object's id number
     * @param color represents this Square object's color
     * @param sideLength represents this Square object's side lengths
     */
    public Square (int idNumber, String color, int sideLength) {
        this.idNumber = idNumber;
        this.color = color;
        this.sideLength = sideLength;
        area = sideLength * sideLength;
        perimeter = sideLength * 4;
    }

    // Setters

     // Getters

    /**
     * A function that provides a string declaring that this Shape object is a Square and its id number as well
     * @return a string saying Square followed by this Square objects id number
     */
    public String toString() { return String.format("Square (ID#  " + idNumber + ")"); }

    /**
     * A function that provides a string declaring that this Square object is a Square
     * @return a string saying Rectangle
     */
    public String getKind() { return "Square"; }

    /**
     * A function to format a little display message defining the characteristics of this Square object
     * @return a formatted string representation of this Square object
     */
    public String getDetailString() { return String.format(toString() + "\n" + "Color: " + color + "\n" + "Side length: " + sideLength + "\n" + "Area: " + area + "\n" + "Perimeter: " + perimeter); }
    
    /**
     * A function to capture this Square object's id number
     * @return the integer value representing this Square object's id number
     */
    public int getID() { return idNumber; }

}