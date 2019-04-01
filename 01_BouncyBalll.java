// create bouncing ball via dynamic icon repaint

package bouncyball;
import javax.swing.*;
import java.awt.*;
import static java.lang.Thread.sleep;

public class BouncyBall
{
    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setSize(400, 300);
        
        Container c = f.getContentPane();
        c.setLayout(new BorderLayout());

        BallLabel dynamicLabel = new BallLabel(20, 20, 3, 3);
        c.add(dynamicLabel, BorderLayout.CENTER);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
        while (true)
        {
            try
            {
                sleep(25);
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
            
            dynamicLabel.dynamicIcon.moveIcon(c.getBounds());
            dynamicLabel.repaint();
        }
    }

}
