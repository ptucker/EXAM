// An interface providing functionality to Shape objects

interface Shape {
    
    /**
     * A function that provides a string description of this Shape object
     * @return the kind and ID# of this Shape object
     */
    public String toString();

    /**
     * A function that provides a description of what kind of Shape object this is
     * @return the kind of Shape object
     */
    public String getKind();

    /**
     * A function that provides the details of this Shape object(kind, ID#, properties)
     * This is the function to be used to display this Shape's properties on the panel
     * @return a string detailing this Shape object
     */
    public String getDetailString();

    /**
     * A function to access this Shape ojbect's ID#
     * @return
     */
    public int getID();

}