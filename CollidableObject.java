import java.awt.Color;
import java.awt.Graphics;
public abstract class CollidableObject extends BoardObject implements Collidable
{
    double radius, xVel, yVel;
    boolean dead = false;
    /**
     * Constructs a CollidableObject and makes it a circle by default.
     * @param X: X-coordinate of the object.
     * @param Y: Y-coordinate of the object.
     * @param R: Radius of the object.
     * @param W: Weight (mass) of the object.
     */
    public CollidableObject(double X, double Y, double R, double W){
        super();
        x = X;
        y = Y;
        xVel = 0;
        yVel = 0;
        radius = R;
        weight = W;
        shapeType = "circle";
    }
    /**
     * Getter & Setter Methods.
     */
    public double getX(){ return x; }
    public double getY(){ return y; }
    public double getXVel(){ return xVel; }
    public double getYVel(){ return yVel; }
    public double getRadius(){ return radius; }
    public double getWeight(){ return weight; }
    public void setX(double X){ x = X; }
    public void setY(double Y){ y = Y; }
    public void setXVel(double XVel){ xVel = XVel; }
    public void setYVel(double YVel){ yVel = YVel; }
    /**
     * Draws the BoardObject on the canvas using java.awt.Graphics;
     * @param Graphics g: The graphics object that BoardObject uses to draw shapes.
     */
    abstract void draw(Graphics g);
    /**
     * Takes the distance between two points.
     * @param x1: x position of point 1.
     * @param y1: y position of point 1.
     * @param x2: x position of point 2.
     * @param y2: y position of point 2.
     * @return: returns distance using the Pythagorean Theorem.
     */
    public double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
    /**
     * Handles the collision between two CollidableObjects.
     * Changes velocity and position.
     */
    abstract void renderCollision(CollidableObject other);
    /**
     * Checks whether the BoardObject is out of bounds and takes action accordingly.
     * @param width: width of canvas bounding box
     * @param height: height of canvas bounding box
     */
    abstract void checkBoundaries(int width, int height);
    /**
     * Checks collisions with other circular CollidableObjects and renders them.
     * @param other: the object to check collision with.
     */
    public void checkCollision(CollidableObject other){
        if(this.shapeType == "circle" && other.shapeType == "circle"){
            if(distance(x, y, other.x, other.y) < radius + other.radius){
                renderCollision(other);
            }
        }
    }
    /**
     * Returns a string representation of a CollidableObject.
     */
    public String toString(){
        return "I am a collidable object, built by the interface Collidable";
    }
}
