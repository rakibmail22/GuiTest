package guiTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
class CustomShape extends JFrame
{
JButton b1;
public CustomShape()
{
setTitle("Transparent JFrame Demo");
setLayout(new GridBagLayout());
setDefaultCloseOperation(EXIT_ON_CLOSE);
setUndecorated(true);
setVisible(true);
setOpacity(1.0f);

// Try different shapes

// Normal rounded rectangle
//setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,40));

//Ellipse shape
//setShape(new Ellipse2D.Double(0,0,400,400));

// Quad Curve
//setShape(new QuadCurve2D.Double(0,0,400,50,400,400));

// Cubic Curve. Looks funny:)
//setShape(new CubicCurve2D.Double(0,0,500,5,200,0,500,500));
setShape(new CubicCurve2D.Double(0,0,500,5,200,0,500,500));
// For three-fourth circle
//setShape(new Arc2D.Double(new Rectangle2D.Double(0,0,500,500),90,270,Arc2D.PIE));

// For round circle shape
//setShape(new Arc2D.Double(new Rectangle2D.Double(0,0,500,500),90,360,Arc2D.PIE));

b1=new JButton("I am a button!");
add(b1);

setSize(500,500);
setLocationRelativeTo(null);
}
public static void main(String args[])
{
new CustomShape();
}
}