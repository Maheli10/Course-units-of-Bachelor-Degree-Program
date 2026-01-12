import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Testdda extends JFrame implements MouseListener
{
	
	int x1,y1,x2,y2;
	Graphics g;
	Testdda(){
	
	setTitle("Math word");
	setSize(600,500);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocation(new java.awt.Point(100, 30));
	getContentPane().setBackground(Color.RED);
	addMouseListener(this);
	g=getGraphics();
	
	}
	public void DDA(int x1,int y1,int x2,int y2)
	{
		int dx,dy;
		int step,xinc,yinc,x,y;
		
		dx=x2-x1;
		dy=y2-y1;
		
		if(Math.abs(dx)>Math.abs(dy))
		{
			step= Math.abs(dx);
		}
		else
		{
			step=Math.abs(dy);
		}
		
		xinc=dx/step;
		yinc=dy/step;
		
		x=x1;
		y=y1;
		g.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),(int)Math.round(y));
		
		for(int i=1; i<step; i++)
		{
		x=x+xinc;
		y=y+yinc;
		g.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),(int)Math.round(y));
		}	
	}
	
	public void drawM(int x1,int y1){
		g.setColor(Color.white);
		DDA(x1,y1,x1,y1+50);
	}
	
	public void mouseClicked(MouseEvent e)
	{
		x1=e.getX();
		y1=e.getY();
		drawM(x1,y1);
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}

public static void main(String[] arg){
	new Testdda();
}

}