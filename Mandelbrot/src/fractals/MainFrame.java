package fractals;
/*
 * 1. ������ ����� (�� 5)
 * �) ���������� ��������� ��� ���������������
 * 2. ���������� � ����: (����� ������ ���������� � �������� �����)
 * 		�) �� ���������� ������� ��������� (�� 12)
 * 		�*) �������� �� ����� � ������� ��������
 * 		�*) �������� ���� ����� �������������
 * 3**. ����� ������� ���������� (�� 13)
 * �) �������� �������� �����
 * ��� 
 * 4**. ���������� �������� ��������� ����� ��� ��������� �����
 * 5. ���������� �������� � ��������� �������. (�� 19)
 * ���� ������������� ������� �����������. BufferedImage �������� ������ 
 * */


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

//import converter.Converter;

public class MainFrame extends JFrame {
//	class JGraphicsPanel extends JPanel{
		/**
		 * 
		 */
	//	private static final long serialVersionUID = 1L;
//
	//	@Override
		/*public void paint(Graphics g){
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
	*/
		//}
	
		
//	private static final long serialVersionUID = 1L;
	
	public MainFrame(){
		super();
		createView();	
	}
	
	private JPanel mainView;
	private JPanel mainView1;
	private JButton exit; 
	private JButton clear; 

//	private Mandelbrot m;
	int x1,y1,x2,y2,x3,y3,x4,y4;
//	private Converter c;
	double minx1=-2,maxx1=1,miny1=-1.5,maxy1=1.5;
	int i;
	Graphics g;
	
	protected void createView(){
		setTitle("������� ������������");//������ ��������� ����
		setSize(800,700);//������ ����
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	
		mainView=new JPanel();
		mainView.setBackground(Color.WHITE);
		mainView.setBounds(5,5,800,500);
		mainView.setBorder(new EtchedBorder(1));
		mainView1=new JPanel();
		mainView1.setBackground(Color.LIGHT_GRAY);
		mainView1.setBounds(5,510,774,53);
	
		exit = new JButton();
		exit.setBackground(Color.GRAY);
		exit.setBounds(600, 30, 650, 50);
		exit.setText("�����");
		
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
	
		clear = new JButton();
		clear.setBackground(Color.GRAY);
		clear.setBounds(600, 10, 650, 20);
		clear.setText("��������");
		
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				//mainView.paint(g);
				mainView.repaint();
			//	mainView.setBackground(Color.WHITE);			
			}
		});
	
		GroupLayout gl = new GroupLayout(getContentPane());
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addComponent(mainView)
 				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
				.addComponent(mainView1, 70, 70, 70)
				);
		gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(mainView, 300, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(mainView1, 300, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		
		this.setLayout(gl);
GroupLayout gl1 = new GroupLayout(mainView1);
		
		gl1.setVerticalGroup(gl1.createSequentialGroup()
				.addGap(5)
				.addGroup(gl1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(clear,24,24,24))
				.addPreferredGap(ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE)
				.addGroup(gl1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(exit,24,24,24))
				);
		gl1.setHorizontalGroup(gl1.createSequentialGroup()
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)			
				.addGroup(gl1.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(clear, 90, 90, 90)
					.addComponent(exit, 90, 90, 90))
				.addGap(5)
							
				);
		mainView1.setLayout(gl1);
	}
	//mainView.addMouseListener(new MouseAdapter(){
	    //	public void mouseClicked(MouseEvent e){
	    	//	panelClicked(e);
	    	//}
	  //  });
/*	 mainView.addMouseListener(new MouseAdapter(){
		 public void mousePressed(MouseEvent e){
			 x1 = e.getX();
			 y1 = e.getY();
		 }
		 
		 public void mouseReleased(MouseEvent e){
		//	 c=new converter.Converter(mainView.getWidth(),mainView.getHeight(),minx1,maxx1,miny1,maxy1);
			 x2 = e.getX();
			 y2 = e.getY();
			 if (x2<x1){
				 int t=x1;
				 x1=x2;
				 x2=t;
			 }
	
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
			 mainView.repaint();
			 }	 
	 	});

	 mainView.addMouseMotionListener(new MouseAdapter(){
		 public void mousePressed(MouseEvent e){
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
			// m = new Mandelbrot(g,mainView.getWidth(),mainView.getHeight(),minx1,maxx1,miny1,maxy1,0);
			// m.prectt( x1,y1,x4, y4 );
			 x4=x3;
			 y4=y3;
			 //m.prectt(minx11, miny11, maxx11, maxy11);
			 g.setColor(Color.WHITE);
			 g.drawRect(minx11,miny11,maxx11-minx11,maxy11-miny11);			
		 }});

	 mainView.addComponentListener(new ComponentAdapter(){
		 public void componentResized(ComponentEvent e){
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
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame form=new MainFrame();
	}
}
