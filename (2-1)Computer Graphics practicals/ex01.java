import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ex01 extends JFrame implements MouseListener{
    Graphics g;
    int x1,y1;;
    double[][] p;

    ex01(){
        setTitle("Final");
        setSize(800,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addMouseListener(this);
        g=getGraphics();

        p = new double[3][3];
    }
	public void DDA(int x1, int y1, int x2, int y2) {

        int dx = x2 - x1;
        int dy = y2 - y1;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        double xinc = dx * 1.0 / steps;
        double yinc = dy * 1.0 / steps;

        double x = x1;
        double y = y1;

        for (int i = 0; i <= steps; i++) {
            g.drawLine((int) Math.round(x), (int) Math.round(y),
                       (int) Math.round(x), (int) Math.round(y));
            x += xinc;
            y += yinc;
        }
    }
	public void ica(int Xc,int Yc,int r){                    
		int x=0, y=r, d=3-2*r;
		while(x<=y){
			plotCircle(Xc,Yc,x,y);
			if(d<0)
				d=d+4*x+6;
			else{
				d=d+4*(x-y)+10;
				y--;
			}
			x++;
		}			
	}                                                                    
	
	public void plotCircle(int h,int k,int x,int y){                  
		g.drawLine(h+x,k+y,h+x,k+y);
		g.drawLine(h+y,k+x,h+y,k+x);
		g.drawLine(h-y,k+x,h-y,k+x);
		g.drawLine(h-x,k+y,h-x,k+y);
		
		g.drawLine(h-x,k-y,h-x,k-y);
		g.drawLine(h-y,k-x,h-y,k-x);
		g.drawLine(h+y,k-x,h+y,k-x);
		g.drawLine(h+x,k-y,h+x,k-y);		                         
	}
	
	void drawObject1(double[][] point){
		ica((int)p[0][0],(int)p[1][0]+200,200);
		ica((int)p[0][0],(int)p[1][0]+200,100);
	}

    void drawObject(double[][] point){
        DDA((int)p[0][0],(int)p[1][0],(int)p[0][1],(int)p[1][1]);
        DDA((int)p[0][1],(int)p[1][1],(int)p[0][2],(int)p[1][2]);
        DDA((int)p[0][2],(int)p[1][2],(int)p[0][0],(int)p[1][0]);
		
		DDA((int)p[0][0]+200,(int)p[1][0]+200,(int)p[0][1]+200,(int)p[1][1]+200);
        DDA((int)p[0][1]+200,(int)p[1][1]+200,(int)p[0][2]+200,(int)p[1][2]+200);
        DDA((int)p[0][2]+200,(int)p[1][2]+200,(int)p[0][0]+200,(int)p[1][0]+200);
		
		DDA((int)p[0][0],(int)p[1][0]+400,(int)p[0][1],(int)p[1][1]+400);
        DDA((int)p[0][1],(int)p[1][1]+400,(int)p[0][2],(int)p[1][2]+400);
        DDA((int)p[0][2],(int)p[1][2]+400,(int)p[0][0],(int)p[1][0]+400);
		
		DDA((int)p[0][0]-200,(int)p[1][0]+200,(int)p[0][1]-200,(int)p[1][1]+200);
        DDA((int)p[0][1]-200,(int)p[1][1]+200,(int)p[0][2]-200,(int)p[1][2]+200);
        DDA((int)p[0][2]-200,(int)p[1][2]+200,(int)p[0][0]-200,(int)p[1][0]+200);
    
	}
	

    double[][] multipleMatrix(double[][] x,double[][] y){
        double ans[][] = new double[x.length][y[0].length];

        for(int i=0;i<x.length;i++){
            for(int k=0;k<y[0].length;k++){
                ans[i][k]=0;
                for(int j=0;j<x[0].length;j++){
                    ans[i][k] += x[i][j] * y[j][k]; 
                }
            }
        }

        return ans;
    }

    double[][] translateMatrix(double dx,double dy){
        double a[][] = {{1,0,dx},{0,1,dy},{0,0,1}};
        return a;
    }

    void translate(){
        double[][] t = new double[3][3];
        t = translateMatrix(100,100);

        p = multipleMatrix(t, p);
        drawObject(p);
    }
	

    double[][] scaleMatrix(double sx,double sy){
        double a[][] = {{sx,0,0},{0,sy,0},{0,0,1}};
        return a;
    }

    void scale(){
        double[][] t1 = new double[3][3];
        double[][] s = new double[3][3];
        double[][] t2 = new double[3][3];
        double[][] tfinal = new double[3][3];

        t1 = translateMatrix(-x1, -y1);
        s = scaleMatrix(0.5,0.5);
        t2 = translateMatrix(x1, y1);

        tfinal = multipleMatrix(s,t1);
        tfinal = multipleMatrix(t2, tfinal);

        p = multipleMatrix(tfinal, p);
        drawObject(p);
		

    }

    double[][] reflectionXMatrix(){
        double a[][] = {{1,0,0},{0,-1,0},{0,0,1}}; 
        return a;
    }

    double[][] reflectionYMatrix(){
        double a[][] = {{-1,0,0},{0,1,0},{0,0,1}};
        return a;
    }

    void reflectX(){
        double[][] t1 = new double[3][3];
        double[][] rx = new double[3][3];
        double[][] t2 = new double[3][3];
        double[][] tfinal = new double[3][3];
        
        t1 = translateMatrix(0,-y1);
        rx = reflectionXMatrix();
        t2 = translateMatrix(0,y1);

        tfinal = multipleMatrix(rx,t1);
        tfinal = multipleMatrix(t2,tfinal);

        p = multipleMatrix(tfinal,p);
        drawObject(p);
    }

    void reflectY(){
        double[][] t1 = new double[3][3];
        double[][] ry = new double[3][3];
        double[][] t2 = new double[3][3];
        double[][] tfinal = new double[3][3];

        t1 = translateMatrix(-x1, 0);
        ry =reflectionYMatrix();
        t2 = translateMatrix(x1, 0);

        tfinal = multipleMatrix(ry, t1);
        tfinal = multipleMatrix(t2,tfinal);

        p = multipleMatrix(tfinal,p);
        drawObject(p);
    }

    double[][] rotateMatrix(double angle){
        double teta = Math.toRadians(angle);
        double a[][] = {{Math.cos(teta),-1*Math.sin(teta),0},{Math.sin(teta),Math.cos(teta),0},{0,0,1}};
        return a;
    }

    void rotate(){
        double[][] t1 = new double[3][3];
        double[][] ro = new double[3][3];
        double[][] t2 = new double[3][3];
        double[][] tfinal = new double[3][3];

        t1 = translateMatrix(-x1,-y1);
        ro = rotateMatrix(60.0);
        t2 = translateMatrix(x1,y1);

        tfinal = multipleMatrix(ro,t1);
        tfinal = multipleMatrix(t2,tfinal);

        p = multipleMatrix(tfinal,p);
        drawObject(p);

    }

    void big(){
        p[0][0]=x1;
        p[1][0]=y1;
        p[2][0]=1;

        p[0][1]=x1+100;
        p[1][1]=y1;
        p[2][1]=1;

        p[0][2]=x1+25;
        p[1][2]=y1-25;
        p[2][2]=1;

        g.setColor(Color.blue);
        drawObject(p);

        rotate();
        rotate();
        rotate();
		rotate();
		rotate();
        reflectY();
        rotate();
        rotate();
        rotate();
		rotate();
		rotate();
		
		g.setColor(Color.black);
		drawObject1(p);
    }

    void small(){
        p[0][0]=x1;
        p[1][0]=y1;
        p[2][0]=1;

        p[0][1]=x1+100;
        p[1][1]=y1;
        p[2][1]=1;

        p[0][2]=x1+25;
        p[1][2]=y1-25;
        p[2][2]=1;
        
        g.setColor(Color.red);
        scale();
        drawObject(p);
        rotate();
        rotate();
        rotate();
		rotate();
		rotate();
        reflectY();
		rotate();
        rotate();
        rotate();
		rotate();
		rotate();
    }

    public void mouseClicked(MouseEvent me){
        x1 = me.getX();
        y1=me.getY();
        big();
        small();
    }
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}

    public static void main(String[] args) {
        new ex01();
    }

}
    
    
    
    
    
    
