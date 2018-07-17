package Polinom;
import java.awt.Color; 
import java.awt.Font; 
import java.awt.Graphics; 

public class DecartPainter extends Converter { 
	public DecartPainter(){ 
		super();
	} 

	DecartPainter(double xmin, double xmax, double ymin, double ymax, int width,int height){ 
		super(xmin,xmax,ymin,ymax,width,height); 
	} 

	public void PaintAxes(Graphics g){ 
		g.setColor(new Color(0,100,0)); 
		int x0 = XtoPx(0); 
		int y0 = YtoPy(0); 
		g.drawLine(0, y0, W, y0); 
		g.drawLine(x0,0,x0,H);
	} 

	public void PaintDiv(Graphics g){ 
		g.setColor(Color.black); 
		Converter con = new Converter(10*xmin,10*xmax,10*ymin,10*ymax,W,H); 
		int x0 = con.XtoPx(0); 
		int y0 = con.YtoPy(0); 
		g.setFont(new Font("Cambria",12,12)); 
		for(int x = (int)(10*xmin+1);x<10*xmax;x+=1){ 
			int px = con.XtoPx(x); 
			if(x%10==0){ 
				g.setColor(new Color(32,178,170)); 
				g.drawLine(px,y0-6,px,y0+6); 
				g.setColor(Color.black); 
				String s=Integer.toString(x/10); 
				if(x>0){ 
					g.drawString(s,px-3,y0+18); 
				} 
				else { 
					g.drawString(s,px-8,y0+18); 
				} 
			} 
			else if(x%5==0){ 
				g.drawLine(px,y0-3,px,y0+3); 
			} 
			else{ 
				g.drawLine(px,y0-1,px,y0+1); 
			} 
		} 
		for(int y = (int)(10*ymin+1);y<10*ymax;y+=1){ 
			int py = con.YtoPy(y); 
			if(y%10==0){ 
				g.setColor(new Color(32,178,170)); 
				g.drawLine(x0-6,py,x0+6,py); 
				g.setColor(Color.black); 
				String s=Integer.toString(y/10); 
				if(y>0){ 
					g.drawString(s,x0-15,py+4); 
				} 
				else if(y<0){ 
					g.drawString(s,x0-20,py+4); 
				} 
			} 
			else if(y%5==0){ 
				g.drawLine(x0-3,py,x0+3,py); 
			} 
			else{ 
				g.drawLine(x0-1,py,x0+1,py); 
			} 
		} 
	} 
}