/**
 * Class: CMSC203 CRN23488
 * Instructor: Dr. Aygun
 * Assignment #4
 * Description: (Write an application that lets the user create a management 
 * company and add the properties managed by the company to its list.)
 * Due: 10/28/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * Print your Name here: Ata Onol
 */
/**
 * The Plot class represents a rectangular area on a 2D plane.
 * It includes attributes for coordinates, width, and depth, 
 * and provides methods to determine if one plot overlaps or
 * is fully encompassed by another plot. This class is often
 * used as a spatial representation for properties within a 
 * management system.
 */
public class Plot {
    /**Set the x, and y coordinate of the upper left corner, as well as the
     * width and height of the plot
	*/
    private int x; 
    private int y; 
    private int width; 
    private int depth; 
    
    // Default constructor: sets default values
    public Plot() {
        x = 0;
        y = 0;
        width = 1;
        depth = 1;
    }
    
    // Copy constructor: duplicates another Plot's values
    public Plot(Plot otherPlot) {
        x = otherPlot.x;
        y = otherPlot.y;
        width = otherPlot.width;
        depth = otherPlot.depth;
    }
    
    // Main constructor: sets custom x, y, width, and depth values
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }
    
    // Getters and Setters
    public int getX() { 
    	return x; 
    }
    public void setX(int x) { 
    	this.x = x; 
    }
    public int getY() { 
    	return y; 
    }
    public void setY(int y) { 
    	this.y = y; 
    }
    public int getWidth() { 
    	return width; 
    }
    public void setWidth(int width) { 
    	this.width = width; 
    }
    public int getDepth() { 
    	return depth;
    }
    public void setDepth(int depth) { 
    	this.depth = depth; 
    }
    
    // Check if this plot overlaps with another
    public boolean overlaps(Plot plot) {
        return this.x < plot.x + plot.width && this.x + this.width > plot.x &&
               this.y < plot.y + plot.depth && this.y + this.depth > plot.y;
    }
    
    // Check if this plot completely contains another
    public boolean encompasses(Plot plot) {
        return this.x <= plot.x && this.y <= plot.y &&
               this.x + this.width >= plot.x + plot.width &&
               this.y + this.depth >= plot.y + plot.depth;
    }
    
    // return a formatted string of plot's properties
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}