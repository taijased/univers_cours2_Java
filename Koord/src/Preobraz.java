

import java.awt.Color;
import java.awt.Graphics;

public class Preobraz {
	private double xMax,xMin,yMax,yMin;
	private int width,heigth;

	public Preobraz(int width,int heigth, double xMax, 
			double xMin, double yMax, double yMin){
		this.width = width;
		this.heigth = heigth;
		this.xMax = xMax;
		this.xMin = xMin;
		this.yMax = yMax;
		this.yMin = yMin;
	}
	public int XtoPix(double p){//из координат в пиксели
		if (p < xMin){
			return -1;
		}
		if (p>xMax){
			return width + 1;
		}

		int x = (int)(((p - xMin)*width) / (xMax - xMin));
		return x;
	}
	
	//из пикселей в координаты
	public double PixtoX(int p){
		if (p < 0){
			return xMin - 1;
		}
		if (p>width){
			return xMax + 1;
		}
		double x = (p*(xMax - xMin) / width) + xMin;
		return x;
	}
	
	//из координат в пиксели
	public int YtoPix(double p){
		if (p < yMin){
			return heigth+1;
		}
		if (p > yMax){
			return -1;
		}
		int x = (int)((heigth / (yMax - yMin))*(yMax - p));
		return x;
	}
	
	//из пикселей в координаты
	public double PixtoY(int p){
		if (p < 0){
			return yMin - 1;
		}
		if (p > heigth){
			return yMax + 1;
		}
		double x = yMax - (p*(yMax - yMin) / heigth);
		return x;
	}

	public void PaintDecart(Graphics g){
		int n_width = XtoPix(0);
		int n_heigth = YtoPix(0);
		g.setColor(Color.BLACK);
		g.drawLine(n_width, 0, n_width, heigth);
		g.drawLine(0, n_heigth, width, n_heigth);
	}




}