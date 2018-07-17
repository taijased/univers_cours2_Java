package fractal1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;

import converter.Converter;




public class MainFrame extends JFrame {
	class JGraphicsPanel extends JPanel{
		@Override
		public void paint(Graphics g){
			Graphics gg=mainView.getGraphics();
			
			int n=4;
			Mandelbrot[]f=new Mandelbrot[n];
			Mandelbrot.cnt++;
			for(int i=0;i<n;i++){
				f[i]=new Mandelbrot(gg,mainView.getWidth(),mainView.getHeight(),minx1,maxx1,miny1,maxy1,i+1);
				new Thread (f[i]).start();
			}
			//m.paint(g);
		}
		
	}
	
	
	private static final long serialVersionUID = 1L;
	public MainFrame()
	{
		super();
		createView();
		
		
		
		
	}
	private JGraphicsPanel mainView;
	private JPanel mainView1;
	private JButton exit; 
	private JButton clear; 
	private JButton build; 
	private Mandelbrot m;
	int x1,y1,x2,y2,x3,y3,x4,y4;
	private Converter c;
	double minx1=-2,maxx1=1,miny1=-1.5,maxy1=1.5;
	int i;
	Graphics g;
	
	
protected void createView()
{
	
	setTitle("ÔÐÀÊÒÀË");//çàäàåì çàãîëîâîê îêíà
	setSize(800,800);//ðàçìåð îêíà
	setBackground(Color.LIGHT_GRAY);
	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	mainView=new JGraphicsPanel();
	mainView.setBackground(Color.WHITE);
	mainView.setBounds(2,2,782,500);
	mainView.setBorder(new EtchedBorder(1));
	
	mainView1=new JPanel();
	mainView1.setBackground(Color.BLACK);
	mainView1.setBounds(2,505,782,70);
	
	exit=new JButton();
	exit.setBackground(Color.RED);
	exit.setBounds(50,30,80,50);
	//mainView1.setLayout(null);
	exit.setText("ÂÛÕÎÄ");
	
	exit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt)
		{
			exit (evt);
		}
		private void exit (ActionEvent evt)
		{
			setVisible(false);
			
		}
	});
	
	clear=new JButton();
	clear.setBackground(Color.RED);
	clear.setBounds(680,40,90,55);
	//mainView.setLayout(null);
	clear.setText("Î×ÈÑÒÈÒÜ");
	clear.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt)
		{
			mainView.setBackground(Color.WHITE);
		}
	});
	
	
	GroupLayout gl=new GroupLayout(getContentPane());
	gl.setVerticalGroup(gl.createSequentialGroup()
			.addComponent(mainView,200,450,Short.MAX_VALUE)
			.addPreferredGap(ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE)
			.addComponent(mainView1,110,110,110)
			);
	gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addComponent(mainView,300,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
			.addComponent(mainView1,300,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE));
	this.setLayout(gl);
	GroupLayout gl1=new GroupLayout(mainView1);
	gl1.setVerticalGroup(
	gl1.createSequentialGroup()
	.addPreferredGap(ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE)
	.addGroup(gl1.createParallelGroup(GroupLayout.Alignment.BASELINE)
			.addGroup(gl1.createParallelGroup(GroupLayout.Alignment.BASELINE))
					.addComponent(clear,30,30,30))
					.addPreferredGap(ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE)
					.addComponent(exit,30,30,30));
	
	gl1.setHorizontalGroup(
			gl1.createSequentialGroup()	
			.addGap(650)
			.addGroup(gl1.createParallelGroup(GroupLayout.Alignment.LEADING))
					.addPreferredGap(ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE)
			.addGroup(gl1.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(clear,40,40,100)
						.addComponent(exit,40,40,100)));
						
			
	mainView1.setLayout(gl1);
	 mainView.addMouseListener(new MouseAdapter()
	    {
	    	public void mouseClicked(MouseEvent e)
	    	{
	    		panelClicked(e);
	    	}
	    });
	 mainView.addMouseListener(new MouseAdapter()
	 {
		 public void mousePressed(MouseEvent e)
		 {
			 x1 = e.getX();
			 y1 = e.getY();
			 
		 }
		 public void mouseReleased(MouseEvent e)
		 {
			 c=new converter.Converter(mainView.getWidth(),mainView.getHeight(),minx1,maxx1,miny1,maxy1);
			 x2 = e.getX();
			 y2 = e.getY();
			 if (x2<x1){
				 int t=x1;
				 x1=x2;
				 x2=t;}
			 if(y2<y1){
				 int t1=y2;
				 y2=y1;
				 y2=t1;
			 }
			 double minx= c.xScr2Dec(x1);
			 double maxx= c.xScr2Dec(x2);
			 double miny= c.yScr2Dec(y2);
			 double maxy= c.yScr2Dec(y1);
			 if (maxx-minx<maxy-miny){
				 maxx=maxy-miny+minx;
			 }
			 if(maxx-minx>maxy-miny){
				 maxy=maxx-minx+miny;
			 }
			 minx1=minx;
			 maxx1=maxx;
			 miny1=miny;
			 maxy1=maxy;
			// m=new Mandelbrot(mainView.getWidth(),mainView.getHeight(),minx,maxx,miny,maxy);
			 mainView.repaint();}
			 
	 });
	 mainView.addMouseMotionListener(new MouseAdapter(){
		 public void mousePressed(MouseEvent e)
		 {
			 x1=x4 = e.getX();
			 y1=y4 = e.getY();
			 
		 }
		
		
		public void mouseDragged(MouseEvent evt){
			 x3 = evt.getX(); 
			 y3 = evt.getY();
			Graphics g = mainView.getGraphics();
			int minx11=Math.min(x1,x3);
			int miny11=Math.min(y1,y3);
			int maxx11=Math.max(x1,x3);
			int maxy11=Math.max(y1,y3);
		
			
			m = new Mandelbrot(g,mainView.getWidth(),mainView.getHeight(),minx1,maxx1,miny1,maxy1,0);
			m.prectt( x1,y1,x4, y4 );
			x4=x3;
			y4=y3;
			//m.prectt(minx11, miny11, maxx11, maxy11);
			g.setColor(Color.BLACK);
			g.drawRect(minx11,miny11,maxx11-minx11,maxy11-miny11);
			
			
		}});
	 
	 
	    mainView.addComponentListener(new ComponentAdapter()
	    {
	    	public void componentResized(ComponentEvent e)
	    	{
	    		//m=new Mandelbrot(mainView.getWidth(),mainView.getHeight(),minx1,maxx1,miny1,maxy1);
	    		mainView.repaint();
	    	}
	    });
	   // m=new Mandelbrot(mainView.getWidth(),mainView.getHeight(),-2,1,-1.5,1.5);
	    setVisible(true);
	 
			
			}
	public void panelClicked(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		
		mainView.repaint();     
	}

	



	
public static void main(String[] args) {
	// TODO Auto-generated method stub
	MainFrame form=new MainFrame();
	
}
}