import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Testing extends JFrame implements MouseListener
{
	Graphics g;
	int x1,y1,x2,y2;
	boolean isdraw= false;
	Graphics2D g2 = (Graphics2D) g;
	
	Testing()
	{
		setTitle("Digital Clock");
		 setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		addMouseListener(this);
		g=getGraphics();
		g2 = (Graphics2D) g;
	}
	
	public void DDA(int x1,int y1,int x2,int y2)
	{
		int dx,dy;
		double step,x,y,xinc,yinc;
		
		dx=x2-x1;
		dy=y2-y1;
		
		if(Math.abs(dx)>Math.abs(dy))
		{
			step= Math.abs(dx);
			
		}
		else
		{
			step= Math.abs(dy);
		}
		
		xinc=dx/step;
		yinc=dy/step;
		
		x=x1;
		y=y1;
		g.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),(int)Math.round(y));
		
		for(int i =1; i<=step; i++)
		{
			x=x+xinc;
			y=y+yinc;
			g.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),
			(int)Math.round(y));
		}
	}
	
	public void drawChar( int x1,int y1 ){
		g.setColor(Color.black);
		Font myFont = new Font("Arial",Font.BOLD,24);
		g.setFont(myFont);
		g.drawString("Vavuniya",x1+87,y1-15);
		
		g.setColor(Color.red);
		//number 1
		DDA(x1+40,y1+50,x1+50,y1+35);
		DDA(x1+50,y1+35,x1+50,y1+95);
		DDA(x1+40,y1+95,x1+60,y1+95);
		
		//number 5
		DDA(x1+70,y1+35,x1+95,y1+35);
		DDA(x1+70,y1+35,x1+70,y1+60);
		DDA(x1+70,y1+60,x1+95,y1+60);
		DDA(x1+95,y1+60,x1+95,y1+95);
		DDA(x1+95,y1+95,x1+70,y1+95);
		
		//dash
		DDA(x1+115,y1+65,x1+135,y1+65);
		
		//number 3
		DDA(x1+155,y1+35,x1+180,y1+35);
		DDA(x1+180,y1+35,x1+180,y1+65);
		DDA(x1+155,y1+65,x1+180,y1+65);
		DDA(x1+180,y1+65,x1+180,y1+95);
		DDA(x1+155,y1+95,x1+180,y1+95);
		
		//number 2
		DDA(x1+195,y1+35,x1+220,y1+35);
		DDA(x1+220,y1+35,x1+220,y1+65);
		DDA(x1+195,y1+65,x1+220,y1+65);
		DDA(x1+195,y1+65,x1+195,y1+95);
		DDA(x1+195,y1+95,x1+220,y1+95);
	}
	
	public void drawBox(int x1,int y1)
	{
		g2.setColor(Color.GRAY);
		g2.setStroke(new BasicStroke(6));
		//rectanglar part
		DDA(x1,y1,x1+270,y1);
		DDA(x1,y1,x1,y1+140);
		DDA(x1+270,y1,x1+270,y1+140);
		DDA(x1,y1+140,x1+270,y1+140);
		
		//tower part
		DDA(x1+63,y1+140,x1+63,y1+635);
		DDA(x1+207,y1+140,x1+207,y1+635);
		DDA(x1+63,y1+635,x1+207,y1+635);
		
		//roof part
		DDA(x1,y1,x1+135,y1-60);		
		DDA(x1+135,y1-60,x1+270,y1);		
	}
	
	public void fillSquare(int x1,int y1)
	{
		//drawing blck box
		g.setColor(Color.black);
		g.fillRect(x1+25,y1+15,220,110);
		
		//drawing small squares
		int x= x1+65;
		int y= y1+143;
		
		int cellwidth= 70;
		int cellheight= 70;
		
		for(int row=0; row<7; row++)
		{
			for(int col=0;col<2; col++)
			{
				if((row+col)%2==0)
				{g.setColor(Color.white);}
				else
				{g.setColor(Color.black);}
				g.fillRect(x+col*cellwidth,y+row*cellheight,cellwidth,cellheight);
			}
		}
	}
	
	public void mouseClicked(MouseEvent e){
		if(!isdraw){
		x1=e.getX();
		y1=e.getY();
		
		drawBox(x1,y1);
		fillSquare(x1,y1);
		drawChar(x1,y1);
		
		isdraw= true;
		}
	}
	public void mousePressed(MouseEvent e){
		
	}
	public void mouseReleased(MouseEvent e){
		
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	
	public static void main(String[] args)
	{
		new Testing();
	}
}