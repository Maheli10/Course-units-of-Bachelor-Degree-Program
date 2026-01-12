import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PP2020 extends JFrame implements MouseListener
{
	int x1,x2,y1,y2;
	int xc,yc,r;
	Graphics g;
	Graphics2D g2= (Graphics2D)g;
	
	PP2020(){
		setTitle("2020-22 paper");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.BLACK);
		addMouseListener(this);
		g=getGraphics();
		g2= (Graphics2D)g;
	}
	
	public void DDA(int x1,int y1,int x2,int y2)
	{
		double dx,dy,x,y,step,xinc,yinc;
		
		dx= x2-x1;
		dy= y2-y1;
		
		if(Math.abs(dx)>Math.abs(dy)){
			step= Math.abs(dx);
		}
		else{
			step= Math.abs(dy);
		}
		
		xinc= dx/step;
		yinc= dy/step;
		
		x=x1;
		y=y1;
		
		g.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),(int)Math.round(y));
		for(int i=1; i<step; i++){
			x=x+xinc;
			y=y+yinc;
			g.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),(int)Math.round(y));
		}
		
	}
	/*public void drawTriangle(int x1,int y1){
		g.setColor(Color.white);
		DDA(x1,y1,x1+100,y1);
		DDA(x1+100,y1,x1+25,y1-25);
		DDA(x1+25,y1-25,x1,y1);
		
	}*/
	
	public void midpointCircle(int xc,int yc,int r){
		int x=0;
		int y=r;
		int p= 1-r;
		
		while(x<=y){
			plotPixel(xc,yc,x,y);
			if(p<0){
				p=p+2*x + 3;
			}
			else{
				p= p+2*(x-y)+5;
				y--;
			}
			x++;
		}
	}
	public void plotPixel(int xc,int yc, int x,int y){
		g.setColor(Color.red);
		g.fillRect(xc+x,yc+y,3,3);
		g.fillRect(xc+y,yc+x,3,3);
		g.fillRect(xc+x,yc-y,3,3);
		g.fillRect(xc-x,yc+y,3,3);
		g.fillRect(xc-x,yc-y,3,3);
		g.fillRect(xc-y,yc-x,3,3);
		g.fillRect(xc-y,yc+x,3,3);
		g.fillRect(xc+y,yc-x,3,3);
	}
	
	void drawObject1([][]point){
		midpointCircle((int)p [0][0],(int)p [1][0]+200,200);
		midpointCircle((int)p [0][0],(int)p [1][0]+200,100);
	}
	
	void dawObject(double [][] point){
		DDA((int)p [0][0],(int)p [1][0],(int)p [0][1],(int)p [1][1]);
		DDA((int)p [0][1],(int)p [1][1],(int)p [0][2],(int)p [1][2]);
		DDA((int)p [0][2],(int)p [1][2],(int)p [0][0],(int)p [1][0]);
		
		DDA((int)p [0][0]+200,(int)p [1][0]+200,(int)p [0][1]+200,(int)p [1]+200[1]);
		DDA((int)p [0][1]+200,(int)p [1][1]+200,(int)p [0][2]+200,(int)p [1][2]+200);
		DDA((int)p [0][2]+200,(int)p [1][2]+200,(int)p [0][0]+200,(int)p [1][0]+200);
		
		DDA((int)p [0][0],(int)p [1][0]+400,(int)p [0][1],(int)p [1][1]+400);
		DDA((int)p [0][1],(int)p [1][1]+400,(int)p [0][2],(int)p [1][2]+400);
		DDA((int)p [0][2],(int)p [1][2]+400,(int)p [0][0],(int)p [1][0]+400);
		
		DDA((int)p [0][0]+200,(int)p [1][0]+200,(int)p [0][1]+200,(int)p [1]+200[1]);
		DDA((int)p [0][1]+200,(int)p [1][1]+200,(int)p [0][2]+200,(int)p [1][2]+200);
		DDA((int)p [0][2]+200,(int)p [1][2]+200,(int)p [0][0]+200,(int)p [1][0]+200);
	}
	
	double [][] multiplyMatrix(double []] x,double [][]y){
		double ans[][] = new double[x.length][y[0].length];
		
		for(int i=0; i<x.length; i++){
			for (int j=0; j<y.length; j++){
				for(int k=0; k<x[0].length; k++){
					ans[i][j] += x[i][k] * y[k][j];
				}
			}
		}
		return ans;
	}
	
	double [][] translateMatrix(double dx,double dy){
		doble [][] a= {
			{1,0,dx},
			{0,1,dy},
			{0,0,1}
		};
		return a;
	}
	
	void translate(){
		double [][] t = new double [3][3];
		t= translateMatrix(100,100);
		dawObject(p);
		p= multiplyMatrix(t,p);
	}
	
	
	public void mousePressed(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){
		int x1= e.getX();
		int y1= e.getY();
		 drawTriangle(x1,y1);
		 //midpitCircle(x1,y1,100);
		
	}
	public void mouseExited(MouseEvent e){}
	
	public static void main(String [] args)
	{
		new PP2020();
	}
	
}