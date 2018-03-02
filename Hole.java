import java.awt.Color;
import java.awt.Graphics;
public class Hole extends CollidableObject
{
    Color color;
    //Need a .wav instead :(
    String bip = "AAAAAA.wav";
    /**
     * Makes a hole, which is always black and circular.
     */
    public Hole(double X, double Y, double R) {
        super(X, Y, R, 0);
        color = Color.BLACK;
        fill = true;
        stroke = false;
        shapeType = "HOLE";
    }
    /**
     * Checks whether a ball has fallen in (defined as center of mass in hole)
     * Holes can fall in other holes.
     */
    public void checkCollision(CollidableObject other){
        if(distance(x, y, other.x, other.y) < radius){
            renderCollision(other);
        }
    }
    /**
     * Takes the distance between two points.
     * @param x1: x position of point 1.
     * @param y1: y position of point 1.
     * @param x2: x position of point 2.
     * @param y2: y position of point 2.
     * @return: returns distance using the Pythagorean Theorem.
     */
    public double distance(double x1, double y1, double x2, double y2){
        return super.distance(x1, y1, x2, y2);
    }
    /**
     * Sends balls (CollidableObject other)
     * 
     * to
     * the
     * 
     * V O I D  O F  D O O M
     */
    public void renderCollision(CollidableObject other){
        other.dead = true;
    }
    /**
     * Checks whether the BoardObject is out of bounds, bounces the ball, and forces the ball back in.
     * @param width: width of canvas bounding box
     * @param height: height of canvas bounding box
     */
    public void checkBoundaries(int width, int height){
        if(x + radius > width){
            x = width - radius;
            xVel *= -1;
        }
        if(x - radius < 0){
            x = radius;
            xVel *= -1;
        }
        if(y + radius > height){
            y = height - radius;
            yVel *= -1;
        }
        if(y - radius < 0){
            y = radius;
            yVel *= -1;
        }
    }
    /**
     * Updates position...by not moving.
     */
    public void update(){
        
    }
    /**
     * Draws the hole, a black circle.
     */
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval((int)(x - radius), (int)(y - radius),
        (int)(2 * radius), (int)(2 * radius));
        update();
    }
    /**
     * Returns a short description of the hole.
     */
    public String toString(){
        return "I'm a holey guy.";
    }
}
