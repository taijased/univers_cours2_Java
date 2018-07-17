package fractals.converter;

public class Converter 
{
	private  double minx,maxx,miny,maxy;
	private  int w,h;
	public Converter(int w,int h, double minx,double maxx,double miny,double maxy)
	{
		this.w=w;
		this.h=h;
		this.minx=minx;
		this.maxx=maxx;
		this.miny=miny;
		this.maxy=maxy;
	}
	public  int xDec2Scr(double x)
	{
		return (int)((x-minx)*w/(maxx-minx));
	}
	public  double xScr2Dec(int x)
	{
		return (double)((maxx-minx)*x/w+minx);
	}
	public  int yDec2Scr(double y)
	{
		return (int)(h*(maxy-y)/(maxy-miny));
	}
	public  double yScr2Dec(int y)
	{
		return (double)((-y*(maxy-miny))/h+maxy);
	}

}