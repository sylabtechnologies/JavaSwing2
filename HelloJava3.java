/**
 * 1. develop JComponent
 * 2. draw message w/ random colors
 * 3. implement the speficif listeners
 * 4. use flow layout
 * 5. is it correct call back registration?
 */

package hellojava3;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class HelloJava3
{
  public static void main( String[] args ) {
    JFrame frame = new JFrame( "HelloJava3" );
    frame.add( new HelloComponent3("Hello Java!") );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setLocationRelativeTo(null);
    frame.setSize( 300, 300 );
    frame.setVisible( true );
  }
}

class HelloComponent3 extends JComponent 
	implements MouseMotionListener, ActionListener
{
  String theMessage;
  int messageX = 125, messageY = 95;  // Coordinates of the message

  JButton theButton;

  int colorIndex;  // Current index into someColors
  static Color[] someColors = { 
	Color.black, Color.red, Color.green, Color.blue, Color.magenta };

  Random rand = new Random(155);
  
  public HelloComponent3( String message ) {
    theMessage = message;
    
    this.setFont(new Font("Helvetica Neue", Font.BOLD, 20));

    theButton = new JButton("Change Color");
    setLayout( new FlowLayout() );
    add( theButton );
    theButton.addActionListener( this );
    addMouseMotionListener( this );
    
  }

  public void paintComponent( Graphics g ) {
    g.drawString(theMessage, messageX, messageY);
  }

  public void mouseDragged( MouseEvent e ) {
    messageX = e.getX();
    messageY = e.getY();
    repaint();
  }

  public void mouseMoved( MouseEvent e ) {}

  public void actionPerformed( ActionEvent e ) {
    if (e.getSource() == theButton)
      changeColor();
  }

  synchronized private void changeColor() {
    // Change the index to the next color, awkwardly.
    if (++colorIndex == someColors.length)
      colorIndex = 0;
    
    // setForeground(currentColor(  )); // Use the new color.
    Color c = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    setForeground(c);
    repaint(  ); // Paint again so we can see the change.
  }

  synchronized private Color currentColor() {
    return someColors[colorIndex];
  }

}