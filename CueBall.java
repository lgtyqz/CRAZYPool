import java.awt.Color;
import java.awt.Graphics;
public class CueBall extends PoolBall
{
    boolean selected = false;
    /**
     * Constructs a Cue ball.
     * CueBalls are always white and have a number of 0.
     * However, they are controllable, but only through the class with the mouse controller.
     * @param X: X-coordinate.
     * @param Y: Y-coordinate
     * @param R: Radius
     * @param W: Weight (mass)
     */
    public CueBall(double X, double Y, double R, double W){
        super(X, Y, R, W, 0);
        color = Color.white;
    }
    /**
     * Returns an accurate depiction of the cue ball.
     */
    public String toString(){
        return "I am Cue Ball, DESTROYER OF WORLDS.";
    }
}
