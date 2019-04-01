package bouncyball;
import java.awt.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.*;

class BallLabel extends JLabel
{
    public DynamicIcon dynamicIcon;
    private static final Random randomGenerator = new Random();
    
    public class DynamicIcon implements Icon
    {
        final int my_width = 75;
        Color myColor;

        private int curr_x = 20;
        private int curr_y = 20;

        private int x_velocity = 3;
        private int y_velocity = 3;

        
        public DynamicIcon(int x, int y, int vx, int vy, Color c)
        {
            curr_x = x;
            curr_y = y;
            x_velocity = vx;
            y_velocity = vy;
            
            myColor = c;
        }

        @Override
        public int getIconWidth() { return my_width; }
        @Override
        public int getIconHeight() { return my_width; }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(myColor);
            g.fillOval(curr_x, curr_y, my_width, my_width );
        }

        public void moveIcon(Rectangle bounds)
        {
            int new_x = curr_x + x_velocity;

            if (new_x < 0)
                x_velocity = -x_velocity;
            else if (new_x > bounds.width - my_width)
                x_velocity = -x_velocity;

            int new_y = curr_y + y_velocity;

            if (new_y < 0)
                y_velocity = -y_velocity;
            else if (new_y > bounds.height - my_width)
                y_velocity = -y_velocity;

            curr_x += x_velocity;
            curr_y+= y_velocity;
        }

    };
        
    public BallLabel(int x, int y, int vx, int vy)
    {
        super();
        
        Color newc = new Color(randomGenerator.nextInt(255),
            randomGenerator.nextInt(255),
            randomGenerator.nextInt(255));
        
        dynamicIcon = new DynamicIcon(x, y, vx, vy, newc);

        System.out.println("Create dynamic icon with width " + Integer.toString(dynamicIcon.my_width));
        System.out.println("with " + dynamicIcon.myColor);

        setIcon(dynamicIcon);
    }
    
}
