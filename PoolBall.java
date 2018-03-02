import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
public class PoolBall extends Ball
{
    int number;
    /**
     * Constructs a Pool Ball, which maps number to color.
     * @param X: X-coordinate.
     * @param Y: Y-coordinate
     * @param R: Radius
     * @param W: Weight (mass)
     * @param N: Number of the ball.
     */
    public PoolBall(double X, double Y, double R, double W, int Number){
        super(X, Y, R, W, Color.BLACK);
        switch(Number % 8){
            case 0:
                color = Color.black;
            break;
            case 1:
                color = Color.yellow;
            break;
            case 2:
                color = Color.blue;
            break;
            case 3:
                color = Color.red;
            break;
            case 4:
                color = new Color(64, 0, 128);
            break;
            case 5:
                color = Color.orange;
            break;
            case 6:
                color = new Color(0, 128, 0);
            break;
            case 7:
                color = new Color(99, 0, 0);
            break;
        }
        number = Number;
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
     * Draws the circle from Ball.draw(), then superimposes a white circle and its number.
     */
    public void draw(Graphics g){
        super.draw(g);
        g.setColor(Color.white);
        g.fillOval((int)(x - 7), (int)(y - 7), 14, 14);
        if(number > 8){
            g.fillRect((int)(x - radius), (int)(y - 7), (int)(radius * 2), 15);
        }
        g.setColor(Color.black);
        g.drawString(Integer.toString(number),
        (int)(x - (7 * 0.707)), (int)(y + 7));
    }
    /**
     * Returns the ball number and suit (stripe, solid, or 8)
     */
    public String toString(){
        String stripe;
        if(number < 8){
            stripe = "solid.";
        }else if(number > 8){
            stripe = "stripe.";
        }else{
            stripe = "certified fortune teller.";
        }
        return "I am pool ball #" + number +", and I am a ";
    }
}
