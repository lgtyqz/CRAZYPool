import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.MouseInfo;
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class WhereStuffActuallyHappens extends JPanel implements KeyListener,
MouseListener, MouseMotionListener, ActionListener
{
    Timer timer;
    private int squareX = 50;
    private int squareY = 50;
    private int squareW = 20;
    private int squareH = 20;
    int fps = 10;
    int delay = Math.round(1000/fps);
    ArrayList<BoardObject> staticEntities = new ArrayList<BoardObject>();
    ArrayList<CollidableObject> entities = new ArrayList<CollidableObject>();
    boolean selected = false;
    /**
     * Initializes the controller class.
     * Adds 15 pool balls and a controllable cue, as well as the mouse listener.
     */
    public WhereStuffActuallyHappens() {
        entities.add(new PoolBall(300, 200, 15, 1, 1));
        entities.add(new PoolBall(270, 185, 15, 1, 2));
        entities.add(new PoolBall(270, 215, 15, 1, 3));
        entities.add(new PoolBall(240, 170, 15, 1, 4));
        entities.add(new PoolBall(240, 200, 15, 1, 5));
        entities.add(new PoolBall(240, 230, 15, 1, 6));
        entities.add(new PoolBall(210, 155, 15, 1, 7));
        entities.add(new PoolBall(210, 185, 15, 1, 8));
        entities.add(new PoolBall(210, 215, 15, 1, 9));
        entities.add(new PoolBall(210, 245, 15, 1, 10));
        entities.add(new PoolBall(180, 140, 15, 1, 11));
        entities.add(new PoolBall(180, 170, 15, 1, 12));
        entities.add(new PoolBall(180, 200, 15, 1, 13));
        entities.add(new PoolBall(180, 230, 15, 1, 14));
        entities.add(new PoolBall(180, 260, 15, 1, 15));
        
        entities.add(new Hole(0, 0, 20));
        entities.add(new Hole(800, 0, 20));
        entities.add(new Hole(0, 400, 20));
        entities.add(new Hole(800, 400, 20));
        entities.add(new Hole(400, 0, 20));
        entities.add(new Hole(400, 400, 20));
        //Neutron Star Cue
        entities.add(new CueBall(600, 200, 15, 1));
        timer = new Timer(20, this);
        timer.start();
        addMouseListener(this);
        for(double i = 0.0; i < 2 * Math.PI; i += Math.PI/12){
            double d = Math.atan2(Math.sin(i), Math.cos(i));
            System.out.println("AS:DKFJ");
            System.out.println(d);
            System.out.println(Math.sin(d));
            System.out.println(Math.cos(d));
        }
    }
    public void keyTyped(KeyEvent e){
        
    }
    public void keyPressed(KeyEvent e){
        
    }
    public void keyReleased(KeyEvent e){
        
    }
    public void mouseMoved(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
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
     * Launches the cue ball when released if already selected, based on distance from the cue ball.
     * @param e: MouseEvent object, to detect mouse events.
     */
    public void mouseReleased(MouseEvent e){
        CollidableObject cue = new CueBall(-420, -420, 420, 420);
        for(int i = 0; i < entities.size(); i++){
            if(entities.get(i).getClass() == CueBall.class){
                cue = entities.get(i);
            }
        }
        if(cue != null){
            double X = MouseInfo.getPointerInfo().getLocation().getX() - getLocationOnScreen().getX();
            double Y = MouseInfo.getPointerInfo().getLocation().getY() - getLocationOnScreen().getY();
            if(selected && distance(cue.getX(), cue.getY(), X, Y) > cue.getRadius()){
                selected = false;
                cue.setXVel(-(X - cue.getX())/10);
                cue.setYVel(-(Y - cue.getY())/10);
            }
        }
    }
    /**
     * If the mouse is over the cue ball, the cue ball is selected.
     * @param e: MouseEvent object, to detect mouse events.
     */
    public void mousePressed(MouseEvent e){
        //System.out.println("BALLS");
        CollidableObject cue = new CueBall(-420, -420, 420, 420);
        for(int i = 0; i < entities.size(); i++){
            if(entities.get(i).getClass() == CueBall.class){
                cue = entities.get(i);
            }
        }
        if(cue != null){
            double X = MouseInfo.getPointerInfo().getLocation().getX() - getLocationOnScreen().getX();
            double Y = MouseInfo.getPointerInfo().getLocation().getY() - getLocationOnScreen().getY();
            //System.out.println(cue.getX());
            //System.out.println(X);
            if(distance(cue.getX(), cue.getY(), X, Y) <= cue.getRadius()){
                System.out.println("NUT");
                selected = true;
            }
            if(SwingUtilities.isRightMouseButton(e)){
                selected = false;
                
                /*for(CollidableObject o : entities){
                    if(o.getClass() == PoolBall.class){
                        o.setXVel(6000 + Math.random() * 9000);
                        o.setYVel(5000 + Math.random() * 9000);
                    }
                }*/
                
                cue.setXVel(6000 + Math.random() * 9000);
                cue.setYVel(5000 + Math.random() * 9000);
                System.out.println("NUCLEAR CUE STICK SUCCESSFULLY ACTIVATED");
            }
        }
    }
    public void mouseClicked(MouseEvent e){}
    public void mouseDragged(MouseEvent e){}
    /**
     * Repaints the canvas after every Timer tick.
     */
    public void actionPerformed(ActionEvent e){
        //System.out.println("h*ck yes boiz");
        repaint();
    }
    /**
     * Sets the canvas size.
     */
    public Dimension getPreferredSize() {
        return new Dimension(800, 400);
    }
    /**
     * Draws stuff on the canvas.
     * First, draws all CollidableObjects.
     * Then, it kills everything that has fallen into a hole.
     * If the cue ball is selected, it then draws a line between the cue ball and the cursor.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);       
        for(int i = 0; i < entities.size(); i++){
            CollidableObject b = entities.get(i);
            b.checkBoundaries(800, 400);
            b.draw(g);
            for(int j = 0; j < entities.size(); j++){
                CollidableObject b2 = entities.get(j);
                if(b.getX() != b2.getX() && b.getY() != b2.getY()){
                    b.checkCollision(b2);
                }
            }
        }
        for(int i = entities.size() - 1; i >= 0; i--){
            if(entities.get(i).dead){
                if(entities.get(i).getClass() == CueBall.class){
                    entities.get(i).setX(600);
                    entities.get(i).setY(200);
                    entities.get(i).dead = false;
                }else{
                    entities.remove(i);
                }
            }
        }
        //Draw Line if Cue Ball is selected
        if(selected){
            CollidableObject cue = new CueBall(-420, -420, 420, 420);
            for(int i = 0; i < entities.size(); i++){
                if(entities.get(i).getClass() == CueBall.class){
                    cue = entities.get(i);
                }
            }
            double X = MouseInfo.getPointerInfo().getLocation().getX() - getLocationOnScreen().getX();
            double Y = MouseInfo.getPointerInfo().getLocation().getY() - getLocationOnScreen().getY();
            g.drawLine((int)cue.getX(), (int)cue.getY(), (int)X, (int)Y);
        }
    }
    /**
     * Returns a concise summary of what this class does.
     */
    public String toString(){
        return "I do all the heavy lifting around here.";
    }
}
