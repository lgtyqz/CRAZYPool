import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;
public class PoolOfTears
{
    /**
     * Runs the main program.
     */
    public static void main(String[] args) {
        System.out.println("Loading...");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                System.out.println("Loading some more...");
                createAndShowGUI();
            }
        });
        
    }
    /**
     * Creates and shows the GUI.
     * Note that only the last line actually shows the GUI.
     */
    private static void createAndShowGUI() {
        //System.out.println("Created GUI on EDT? "+
        //SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Preparing sandwiches...");
        WhereStuffActuallyHappens game = new WhereStuffActuallyHappens();
        f.add(game);
        System.out.println("Installing more RAM...");
        f.pack();
        System.out.println("Ready!");
        f.setVisible(true);
    }
    /**
     * Returns a concise summary of the class's actions.
     */
    public String toString(){
        return "I run the whole program and contain the main function.";
    }
}
