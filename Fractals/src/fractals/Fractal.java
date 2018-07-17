package fractals;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Fractal{
	protected int  w, h;
	private int formula;
	protected  double minx,miny,maxx,maxy;
	protected converter.Converter conv;
	protected Graphics g;

	JPanel panel;
	
	public Fractal(Graphics g,int w, int h, double minx, double maxx, double miny, double maxy,JPanel p,int temp){
		this.w = w;
		this.h = h;
		this.minx = minx;
		this.maxx = maxx;
		this.miny = miny;
		this.maxy = maxy;
		formula=temp;
		panel = p;
		conv = new converter.Converter(w, h, minx, maxx, miny, maxy);
		this.g=g;
	}
	
	public Color getColors(int q){
		int rr = 35;
		int gg = 5;
		int bb = 13;
		return new Color ((rr*q)%255,(gg*q)%255,(bb*q)%255);
	}
	public void Mandelbrot(){
		Thread t1 = new Thread(){
			public void run(){
				for(int i = 0;i < panel.getWidth()/4; i++){
					for (int j = 0;j < panel.getHeight(); j++){
						int q=isInSet(i,j);
						Color t = getColors(q);
						synchronized(g){
							g.setColor(t);		
							g.drawLine(i, j, i, j);	
						}
					}
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				for(int i = panel.getWidth()/4;i < panel.getWidth()/2; i++){
					for (int j = 0;j < panel.getHeight(); j++){
						int q=isInSet(i,j);
						Color t = getColors(q);
						synchronized(g){
							g.setColor(t);		
							g.drawLine(i, j, i, j);	
						}
					}
				}
			}
		};
		Thread t3 = new Thread(){
			public void run(){
				for(int i = panel.getWidth()/2;i < panel.getWidth()*3/4; i++){
					for (int j = 0;j < panel.getHeight(); j++){
						int q=isInSet(i,j);
						Color t = getColors(q);
						synchronized(g){
							g.setColor(t);		
							g.drawLine(i, j, i, j);	
						}			
					}
				}
			}
		};
		Thread t4 = new Thread(){
			public void run(){
				for(int i =  panel.getWidth()*3/4;i < panel.getWidth(); i++){
					for (int j = 0;j < panel.getHeight(); j++){
						Complex c = new Complex(i, j);
						Complex z = new Complex(0,0);
						switch(formula){
					
						case 1: z = z.mult(z).plus(c); break;
						case 2: z = z.mult(z.mult(z)).plus(c); break;
						case 3: z = z.mult(z).plus(z).plus(c); break;
						case 4: z = z.mult(z.mult(z)).plus(z).plus(c); break;
					
						default : break;
					}
						
						int q=isInSet(i,j);
						Color t = getColors(q);
						synchronized(g){
							g.setColor(t);		
							g.drawLine(i, j, i, j);	
						}				
					}
				}
			}
		};
			
		try {
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void prectt(int x1,int y1,int x3,int y3){
		int minx11=Math.min(x1,x3);
		int miny11=Math.min(y1,y3);
		int maxx11=Math.max(x1,x3);
		int maxy11=Math.max(y1,y3);
		
		for(int i =minx11 ;i <= maxx11; i++){
			PaintOneDot(g,i,miny11);
			PaintOneDot(g,i,maxy11);	
		}
			
		for (int j =miny11;j <=maxy11; j++){
			PaintOneDot(g,minx11,j);
			PaintOneDot(g,maxx11,j);	
		}
	}
	
	public void PaintOneDot(Graphics g,int i,int j){
	int q=isInSet(i,j);
		int rr = 35;
		int gg = 5;
		int bb = 13;
		Color t = new Color ((rr*q)%255,(gg*q)%255,(bb*q)%255);
		//Color t = Color.RED;
		g.setColor(t);
		//����� ���������� ���� ���, ����� � ���� �������
		g.drawLine(i, j, i, j);	
	}
		
	public int isInSet(int i, int j){
		return isInSet(conv.xScr2Dec(i),conv.yScr2Dec(j));	
	}

	public int isInSet(double re, double im){
		Complex c = new Complex(re, im);
		Complex z = new Complex(0,0);
		for (int n = 0; n < 255; n++){	
			switch(formula){
			case 1: z = z.mult(z).plus(c); break;
			case 2: z = z.mult(z.mult(z)).plus(c); break;
			case 3: z = z.mult(z).plus(z).plus(c); break;
			case 4: z = z.mult(z.mult(z)).plus(z).plus(c); break;
		default:z = z.mult(z).plus(c);
			}	
			if (z.abs() > 2) return n;	
		}
		return 255;
	}


public void Julia(int cx,int cy){
	Complex c = new Complex(conv.xScr2Dec(cx),conv.yScr2Dec(cy));
	for(int i = 0; i < panel.getWidth();i++){
		for(int j =0; j < panel.getHeight();j++){		
			Complex z = new Complex();
			z.re = conv.xScr2Dec(i);
			z.im = conv.yScr2Dec(j);
			int k = 0;
			while(k < 255 && Math.sqrt(z.abs()) < 4){				
				
				 z = z.mult(z).plus(c); break;
			}	
			Color color;
			if(k == 255) {
				color = Color.black;
			}
			else {			
				color = getColors(k);
			}
			g.setColor(color); 
			g.fillRect(i, j, 1, 1);
	
		}
	}
}
}
