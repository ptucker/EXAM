// A class defining Circle objects

public class Circle implements Shape {

    // private attributes
    private int idNumber;
    private String color;
    private int radius;
    private double area;
    private double circumference;
    private static double PI = 3.14159;         // Used for calculating the area and circumference

    /**
     * No arg constructor
     */
    public Circle() {}

     /**
      * Circle object constructor initializes a Circle object given the id number, radius, and color
      * @param idNumber represents the id number for this Circle object
      * @param radius represents the radius of this Circle object
      * @param color represents the color of this Circle object
      */
    public Circle(int idNumber, int radius, String color) {
        this.idNumber = idNumber;
        this.radius = radius;
        this.color = color;
        area = (PI * radius * radius);
        circumference = (2 * PI * radius);
    }

    // Setters

    // Getters

    /**
     * A function that provides a string declaring that this Shape object is a Circle and its id number as well
     * @return a string saying Circle followed by this Cirlce objects id number
     */
    public String toString() { return String.format("Circle (ID#  " + idNumber + ")"); }

    /**
     * A function that provides a string declaring that this Shape object is a Circle
     * @return a string saying Circle
     */
    public String getKind() { return "Circle"; }

    /**
     * A function to format a little display message defining the characteristics of this Circle object
     * @return a formatted string representation of this Circle object
     */
    public String getDetailString() { return String.format(toString() + "\n" + "Color: " + color + "\n" + "Radius: " + radius + "\n" + "Area: " + area + "\n" + "Circumference: " + circumference); }
    
    /**
     * A function to capture this Circle object's id number
     * @return the integer value representing this Circle object's id number
     */
    public int getID() { return idNumber; }
    
}