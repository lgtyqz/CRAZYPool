import java.awt.Graphics;
import java.awt.Color;
import java.io.File;
public class Ball extends CollidableObject
{
    Color color;
    //Need a .wav instead :(
    String bip = "AAAAAA.wav";
    /**
     * Creates a Ball Object.
     * @param X: X-coordinate.
     * @param Y: Y-coordinate
     * @param R: Radius
     * @param W: Weight (mass)
     * @param C: Color of the ball.
     */
    public Ball(double X, double Y, double R, double W, Color C) {
        super(X, Y, R, W);
        color = C;
        fill = true;
        stroke = false;
        shapeType = "circle";
    }
    /**
     * Handles the collision between two CollidableObjects.
     * Changes velocity and position.
     */
    public void checkCollision(CollidableObject other){
        super.checkCollision(other);
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
     * Handles the collision between two CollidableObjects.
     * Changes velocity and position.
     */
    public void renderCollision(CollidableObject other){
        //Change velocity
        if(other.getClass() == CueBall.class){
            System.out.println("Red alert! We've been hit!");
        }
        
        //Old ver:
        //Change velocity
        double tempV = this.xVel;
        double tempW = this.yVel;
        double tempX = other.xVel;
        double tempY = other.yVel;
        double weightRatio = weight/other.weight;
        double radii = this.radius + other.radius;
        double power1 = Math.sqrt(this.xVel * this.xVel + this.yVel * this.yVel);
        double power2 = Math.sqrt(other.xVel * other.xVel + other.yVel * other.yVel);
        double angle = Math.atan2(y - other.y, x - other.x);
        double velAngle = Math.atan2(tempW, tempV);
        //System.out.println(angle);
        this.xVel += power2 * 1/weightRatio * Math.cos(angle) * 0.7;
        this.yVel += power2 * 1/weightRatio * Math.sin(angle) * 0.7;
        other.xVel -= power1 * 1/weightRatio * Math.cos(angle) * 0.7;
        other.yVel -= power1 * 1/weightRatio * Math.sin(angle) * 0.7;
        //Change position
        /*this.x = other.x + radii * Math.cos(angle);
        this.y = other.y + radii * Math.sin(angle);
        other.x = this.x - radii * Math.cos(angle);
        other.y = this.y - radii * Math.sin(angle);*/
        
        
        /* In-dev Version:
        double tempV = this.xVel;
        double tempW = this.yVel;
        double tempX = other.xVel;
        double tempY = other.yVel;
        double weightRatio = weight/other.weight;
        double radii = this.radius + other.radius;
        double angle = Math.atan2(y - other.y, x - other.x);
        double velAngle = Math.atan2(tempW, tempV);
        double velMag = distance(0, 0, tempV, tempW);
        double otherVelMag = distance(0, 0, other.xVel, other.yVel);
        double distanceBetween = distance(x, y, other.x, other.y);
        //System.out.println(angle);
        this.xVel += other.xVel * weightRatio * Math.cos(angle) * 0.7;
        this.yVel += other.yVel * weightRatio * Math.sin(angle) * 0.7;
        double newVelMag = Math.sqrt(
        Math.pow(velMag, 2) + Math.pow(distanceBetween, 2) - 
        2 * velMag * distanceBetween * Math.cos(angle));
        this.xVel -= newVelMag/velMag * weightRatio * Math.cos(angle) * 0.7;
        this.yVel -= newVelMag/velMag * weightRatio * Math.sin(angle) * 0.7;
        System.out.println(newVelMag);
        other.xVel += tempV * 1/weightRatio * Math.cos(angle) * 0.7;
        other.yVel += tempW * 1/weightRatio * Math.sin(angle) * 0.7;
        double otherNewVelMag = Math.sqrt(
        Math.pow(otherVelMag, 2) + Math.pow(distanceBetween, 2) - 
        2 * otherVelMag * distanceBetween * Math.cos(angle));
        other.xVel -= otherNewVelMag/otherVelMag * 1/weightRatio * Math.cos(angle) * 0.7;
        other.yVel -= otherNewVelMag/otherVelMag * 1/weightRatio * Math.sin(angle) * 0.7;
        //Change position
        this.x = other.x + radii * Math.cos(angle);
        this.y = other.y + radii * Math.sin(angle);
        other.x = this.x - radii * Math.cos(angle);
        other.y = this.y - radii * Math.sin(angle);
        */
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
     * Moves the ball every frame.
     */
    public void update(){
        x += xVel;
        y += yVel;
        xVel *= 0.97;
        yVel *= 0.97;
    }
    /**
     * Draws the ball, a circle.
     */
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval((int)(x - radius), (int)(y - radius),
        (int)(2 * radius), (int)(2 * radius));
        update();
    }
    /**
     * Returns the ball and its color.  
     */
    public String toString(){
        return "I am a " + color + " ball.";
    }
}
