/*
Shane Snediker
Dr. Pete Tucker
Java Applications

I affirm that all code written in this project was written by me, 
Shane Snediker, according to the parameters and guidlines outlined
for us in class.

*/

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.io.*;

public class exam extends JFrame implements ActionListener {

    // private attributes
    
    // JPanels
    private JPanel scrollPanel = new JPanel();                                  // The panel that will hold the verticle box of JButtons
    private JPanel displayPanel = new JPanel();                                 // The panel that will hold the display
    private JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));   // The Panel that will hold the shape JLabel
    // A JScrollPane to hold each of our shape object JButtons 
    JScrollPane scrollPane = new JScrollPane(scrollPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    // JLabels
    private JLabel circlePic;
    private JLabel squarePic;
    private JLabel rectPic;
    private JLabel triPic;
    // JButton member variables that I will use to instantiate the Shape buttons
    private JButton circButton;  
    private JButton squButton; 
    private JButton rectButton;
    private JButton triButton; 
    // A JTextArea to hold the Shape property information
    private JTextArea display = new JTextArea(10, 1);
    // Now we have 4 hash maps which hold the 4 different kinds of Shape objects, each uniquely identified by its id number
    private static ArrayList<Circle> circleArray = new ArrayList<Circle>();
    private static ArrayList<Square> squareArray = new ArrayList<Square>();
    private static ArrayList<Rectangle> rectangleArray = new ArrayList<Rectangle>();
    private static ArrayList<Triangle> triangleArray = new ArrayList<Triangle>();
    // Now I need to have an Image member variable to capture the Shape pics
    private Image imgHolder;
    // I will need a Random object so that I can randomly generate the JButton Shapes
    private Random buttonRandomizer = new Random();
    // Static variables to help with calculations
    private static int TOTAL_SHAPE_OBJECTS = 96;    
    private static int CIRCLES = 44;
    private static int SQUARES = 10;
    private static int RECTANGLES = 17;
    private static int TRIANGLES = 25;

    /**
     * Exam constructor initializes an Exam object, which defines the main window of this GUI app
     */
    public exam() {

        // Initial characterisitics
        setBounds(500, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Shape GUI");
        setLayout(new BorderLayout());
        // Call the function that will read the Shape object data from the .txt file and load it into the maps
        loadMaps();
        // Call the function that will define my JComponents
        createUIComponents(); 
        // Add the Box to this JFrame
        add(scrollPane, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(displayPanel, BorderLayout.EAST);
        // Add action listeners to our JButton variables
        circButton.addActionListener(this);
        squButton.addActionListener(this);
        rectButton.addActionListener(this);
        triButton.addActionListener(this);
           
        setVisible(true);
        
    }

    /**
     * A core function to this program.  This function sets up the JComponents that will come to 
     * comprise the GUI
     */
    public void createUIComponents() {

        // Capture the photos
        try {
            Toolkit imageKit = Toolkit.getDefaultToolkit();
            // Set up the Circle picture
            URL circleURL = new URL("http://www.charlespetzold.com/blog/2012/12/BezierCircleFigure3.png");
            imgHolder = imageKit.getImage(circleURL);
            imgHolder = imgHolder.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon circleIcon = new ImageIcon(imgHolder);
            circlePic = new JLabel(circleIcon);
    
            // Set up the Square picture
            URL squareURL = new URL("http://star.spsk12.net/math/4/shapes%20game/4th%20math/square_yellow.jpg");
            imgHolder = imageKit.getImage(squareURL);
            imgHolder = imgHolder.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon squareIcon = new ImageIcon(imgHolder);
            squarePic = new JLabel(squareIcon);

             // Set up the Rectangle picture
             URL rectURL = new URL("http://www.clker.com/cliparts/A/4/p/x/H/7/red-rectangle-vertical-md.png");
             imgHolder = imageKit.getImage(rectURL);
             imgHolder = imgHolder.getScaledInstance(100, 300, Image.SCALE_SMOOTH);
             ImageIcon rectIcon = new ImageIcon(imgHolder);
             rectPic = new JLabel(rectIcon);

              // Set up the Triangle picture
            URL triURL = new URL("https://dev.opera.com/articles/raw-webgl-part-1-getting-started/figure3.png");
            imgHolder = imageKit.getImage(triURL);
            imgHolder = imgHolder.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon triIcon = new ImageIcon(imgHolder);
            triPic = new JLabel(triIcon);
            }
            catch(Exception ex) { System.out.println("Oops, something went wrong!"); }

        // Configure the center panel which will hold the Shape picture
        centerPanel.setPreferredSize(new Dimension(150, 900));              // Give the center panel a preferred measurement
        FlowLayout vSpacing = new FlowLayout(FlowLayout.LEFT, 10, 10);      // Establish a FlowLayout object left aligned
        vSpacing.setVgap(200);                                              // Give that FlowLayout object a verticle gap to center the Shape photos on the JFrame
        centerPanel.setLayout(vSpacing);                                    // Give the center panel this FlowLayout object
        // Now it's time to allocate JButtons for the scroll panel, but we need to do it randomly, so that there isn't all the cirlcles followed by all the squares, etc, etc.
        // Initialize the scroll bar panel and add the JButtons
        scrollPanel.add(Box.createVerticalStrut(20));
        scrollPanel.setPreferredSize(new Dimension(200, 3000));
        //Alright, thus begins the algorithm that will make sure that the kind of shape button on the panel is random        
        while(TOTAL_SHAPE_OBJECTS > 0) {
            int holder = buttonRandomizer.nextInt(96) + 1;
            // Theres a 44% chance of this shape button being a circle
            if (holder > 51) {
                // Check to make sure that we haven't already ran out of circle objects to make buttons for
                if (CIRCLES > 0) {
                    circButton = new JButton(circleArray.get(CIRCLES - 1).toString());
                    // Access the button label using the Circle toString interface method and add this button to the scroll panel
                    scrollPanel.add(circButton);
                    //System.out.println(holder);
                    // Let's do a little bit of spacing
                    scrollPanel.add(Box.createVerticalStrut(10));
                    // Decrement our circle counter
                    CIRCLES--;
                    // Decrement our while loop ensure exit counter
                    TOTAL_SHAPE_OBJECTS--;
                }
            }
            // Theres a 25% chance of this object being a triangle
            else if (holder < 26) {
                // Check to make sure that we haven't already ran out of triangle objects to make buttons for
                if (TRIANGLES > 0) {
                    triButton = new JButton(triangleArray.get(TRIANGLES - 1).toString());
                    // Access the button label using the Triangle toString interface method and add this button to the scroll panel
                    scrollPanel.add(triButton);
                    // Let's do a little bit of spacing
                    scrollPanel.add(Box.createVerticalStrut(10));
                    // Decrement our triangle counter
                    TRIANGLES--;
                    // Decrement our while loop ensure exit counter
                    TOTAL_SHAPE_OBJECTS--;
                }
            }
            // Theres a 17% change of this object being a rectangle
            else if (holder > 25 && holder < 37) {
                // Check to make sure that we haven't already ran out of rectangle objects to make buttons for
                if (RECTANGLES > 0) {
                    rectButton = new JButton(rectangleArray.get(RECTANGLES - 1).toString());
                    // Access the button label using the Rectangle toString interface method and add this button to the scroll panel
                    scrollPanel.add(rectButton);
                    // Let's do a little bit of spacing
                    scrollPanel.add(Box.createVerticalStrut(10));
                     // Decrement our rectangle counter
                     RECTANGLES--;
                     // Decrement our while loop ensure exit counter
                     TOTAL_SHAPE_OBJECTS--;
                }
            }
            // There's a 10% chance of this object being a square
            else {
                // Check to make sure that we haven't already ran out of square objects to make buttons for
                if (SQUARES > 0) {
                    squButton = new JButton(squareArray.get(SQUARES - 1).toString());
                    // Access the button label using the Square toString interface method and add this button to the scroll panel
                    scrollPanel.add(squButton);
                    // Let's do a little bit of spacing
                    scrollPanel.add(Box.createVerticalStrut(10));
                    // Decrement our rectangle counter
                    SQUARES--;
                    // Decrement our while loop ensure exit counter
                    TOTAL_SHAPE_OBJECTS--;
                }
            }
        }

        // Let's set up our text area that will be on the right side of the JFrame displaying the properties from each respective button push
        displayPanel.setPreferredSize(new Dimension(150, 300));              // Give the display panel a preferred measurement
        FlowLayout vSpacing2 = new FlowLayout(FlowLayout.LEFT, 10, 10);      // Establish a FlowLayout object center aligned
        vSpacing2.setVgap(200);                                              // Give that FlowLayout object a verticle gap to center the text area on the JFrame
        displayPanel.setLayout(vSpacing);                                    // Give the center panel this FlowLayout object
        display.setFont(new Font("Serif", Font.ITALIC, 16));
        displayPanel.add(display);

    }

    /**
     * The implementation of the ActionListener interface method actionPerformed
     */
    public void actionPerformed(ActionEvent click) {
        // Start with the Circle object ArrayList, iterate through it, and determine the activity of button clicks
        for(Circle iter: circleArray) {
            // If the button click matched the button that the iterator is currently pointing to
            if (click.getSource() == circButton) {
                // Change the text in the TextArea to a display that features the properties of this Circle object
                display.setText(iter.getDetailString());
                // Clear the previous picture from the center panel
                centerPanel.removeAll();
                // Reload the center panel with a Circle picture
                centerPanel.add(circlePic);
            }
        }
        // Now let's traverse the Square ojbect ArrayList to check and see if this button click belonged to a Square JButton
        for(Square iter: squareArray) {
            // Does the button click match the button that the iterator is currently pointing to?
            if (click.getSource() == squButton) {
                // YES!  So, we need to change the text to display the properties of this Circle object
                display.setText(iter.getDetailString());
                // Clear the previous picture from the center panel
                centerPanel.removeAll();
                // Reload the center panel with a Square picture
                centerPanel.add(squarePic);
            }
        }
        // Now let's traverse the Rectangle ojbect ArrayList to check and see if this button click belonged to a Square JButton
        for(Rectangle iter: rectangleArray) {
            // Does the button click match the button that the iterator is currently pointing to?
            if (click.getSource() == rectButton) {
                // Boy howdy, it does!  So, we need to change the text to display the properties of this Rectangle object
                display.setText(iter.getDetailString());
                // Clear the previous picture from the center panel
                centerPanel.removeAll();
                // Reload the center panel with a Rectangle picture
                centerPanel.add(rectPic);
            }
        }
        // Lastly, we need to go through our Triangle ArrayList to see if this button click was a triangle option
        for(Triangle iter: triangleArray) {
            // So, does this particular button click match the button that the iterator is currently pointing toward
            if (click.getSource() == triButton) {
                // Now that we know this was the button that was pushed, we need to display its properties
                display.setText(iter.getDetailString());
                // Clear the previous picture from the center panel
                centerPanel.removeAll();
                // Reload the center panel with a Triangle picture
                centerPanel.add(triPic);
            }
        }
        revalidate();
        repaint();

    }

    /**
     * This is a function that uses a detailed algorithm to parse out the .txt file line by line and save
     * each Shape into a HashMap.  Circles are saved in the Circle HashMap, Squares in the Square HashMap,
     * Rectangles in the Rectangle HashMap and Triangles in the Triangle HashMap
     */
    public void loadMaps() {

        try(FileInputStream is = new FileInputStream("Data.txt")) {
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader breader = new BufferedReader(ir);
            String lineHolder = breader.readLine();
            while (lineHolder != null) {
                String [] parts = lineHolder.split(":");                // Split the line into the Shape kind and the stats
                String shape = parts[0];                                // Hold the Shape kind in a String variable
                
                // Now we need to determine what Shape this is so that we can create the correct Shape object
                // Is it a Circle?
                if (shape.charAt(0) == 'c') {          
                    String circleStats = parts[1];                         // Capture just the properties portion of the string array
                    String [] splitCirStats = circleStats.split(" ");      // Separate the properties portion of the string into separate characteristics using the " " regex
                    int cirID = Integer.parseInt(splitCirStats[1]);        // Parse the string version of the id number into an integer value and hold it
                    int rad = Integer.parseInt(splitCirStats[2]);          // Parse the string version of the radius into an integer value and hold it
                    String cirCol = splitCirStats[3];                      // Hold the string value representing this Shape's color
                    Circle newCircle = new Circle(cirID, rad, cirCol);     // Create a new Circle, using these properties
                    circleArray.add(newCircle);                            // Add this Circle object to the circle HashMap
                   
                }
                // Is it a Square?
                else if (shape.charAt(0) == 's') {
                    String squareStats = parts[1];                          // Capture just the properties portion of the string array 
                    String [] splitSquStats = squareStats.split(" ");       // Separate the properties portion of the string into separate characteristics using the " " regex
                    int squID = Integer.parseInt(splitSquStats[1]);         // Parse the string version of the id number into an integer value and hold it
                    int side = Integer.parseInt(splitSquStats[2]);          // Parse the string version of the Square side length into an integer value and hold it
                    String squCol = splitSquStats[3];                       // Hold the string value representing this Squares color
                    Square newSquare = new Square(squID, squCol, side);     // Create a new Square, using these properties
                    squareArray.add(newSquare);                             // Add this Square object to the square HashMap 
                }
                // Is it a Rectangle?
                else if (shape.charAt(0) == 'r') {
                    String rectStats = parts[1];                            // Capture just the properties portion of the string array 
                    String [] splitRecStats = rectStats.split(" ");         // Separate the properties portion of the string into separate characteristics using the " " regex
                    int rectID = Integer.parseInt(splitRecStats[1]);        // Parse the string version of the id number into an integer value and hold it
                    int rectLength = Integer.parseInt(splitRecStats[2]);    // Parse the string version of the length of this rectangle into an integer value and hold it
                    int rectWidth = Integer.parseInt(splitRecStats[3]);     // Parse the string version of the width of this rectangle into an integer value and hold it
                    String rectCol = splitRecStats[4];                      // Hold the string value representing this Rectangle's color
                    Rectangle newRect = new Rectangle(rectID, rectCol, rectLength, rectWidth);     // Create a new Rectangle, using these properties
                    rectangleArray.add(newRect);                            // Add this Rectangle object to the rectangle HashMap 
                }
                // Well, then it must be a triangle
                else {
                    String triStats = parts[1];                            // Capture just the properties portion of the string array 
                    String [] splitTriStats = triStats.split(" ");         // Separate the properties portion of the string into separate characteristics using the " " regex
                    int triID = Integer.parseInt(splitTriStats[1]);        // Parse the string version of the id number into an integer value and hold it
                    int one = Integer.parseInt(splitTriStats[2]);          // Parse the string version of the length of the first side of this Triangle into an integer value and hold it
                    int two = Integer.parseInt(splitTriStats[3]);          // Parse the string version of the length of the second side of this Triangle into an integer value and hold it
                    int three = Integer.parseInt(splitTriStats[4]);        // Parse the string version of the length of the third side of this Triangle into an integer value and hold it
                    String triCol = splitTriStats[5];                      // Hold the string value representing this Triangle's color
                    Triangle newTri = new Triangle(triID, triCol, one, two, three);   // Create a new Triangle, using these properties
                    triangleArray.add(newTri);                             // Add this Triangle object to the triangle HashMap 
                }

                lineHolder = breader.readLine();                           // Go to the next line
        }
    }
        catch(Exception ex) { System.out.print("Oops"); }
    }  

}