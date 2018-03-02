import java.awt.Graphics;
public abstract class BoardObject
{
    double x, y;
    double weight;
    boolean fill, stroke;
    String shapeType;
    /**
     * Getter & Setter Methods.
     */
    public double getX(){ return x; }
    public double getY(){ return y; }
    public void setX(double X){ x = X; }
    public void setY(double Y){ y = Y; }
    public double getWeight(){ return weight; }
    /**
     * Draws the BoardObject on the canvas using java.awt.Graphics;
     * @param Graphics g: The graphics object that BoardObject uses to draw shapes.
     */
    abstract void draw(Graphics g); //For drawing it
    /**
     * Updates the BoardObject's fields like x & y position.
     */
    abstract void update(); //For updating position, dimensions, color
    /**
     * Checks whether the BoardObject is out of bounds and takes action accordingly.
     * @param width: width of canvas bounding box
     * @param height: height of canvas bounding box
     */
    abstract void checkBoundaries(int width, int height);
    /**
     * Returns a string representation of a BoardObject.
     */
    public String toString(){
        return "I am a board object.";
    }
}
