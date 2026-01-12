mport java.awt.*;
import javax.swing.*;

class InCircles extends JFrame
{
	InCircles()
	{
		setTitle("Circles");
		setSize(800,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void paint (Graphics g)
	{
		g.setColor(Color.pink);
		g.fillRect(0,0,800,800);
		
		g.setColor(Color.green);
		g.fillOval(250,150,300,300);
		
		g.setColor(Color.red);
		g.fillOval(275,175,250,250);
		
		g.setColor(Color.yellow);
		g.fillOval(300,200,200,200);
		
		g.setColor(Color.blue);
		g.fillOval(325,225,150,150);
		
		g.setColor(Color.white);
		g.fillOval(350,250,100,100);
		
	}
	
	public static void main(String [] args)
	{
		new InCircles();
	}
}