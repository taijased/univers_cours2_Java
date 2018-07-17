/*import java.awt.Color;
import java.awt.List;

import javax.imageio.ImageIO;
import javax.swing.event.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;





public class MainFrame extends JFrame {
	
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem form1,form2,form3,form4;
	
	private int formula;
	private JButton btnRestart;
	private JButton btnSpace;
	private JButton btnSave;
	private JPanel mainPanel;	
	private JPanel controlPanel;
	private double xMin,xMax,yMin,yMax;
	private double t_xmax,t_xmin,t_ymax,t_ymin;
	private int x1,x2,y1,y2,xXOR, yXOR;
	private int test;
	private double cx,cy;
	private int mpW,mpH;
	private BufferedImage buffer;
	private boolean boolka;
	

	public MainFrame(boolean temp,double c_x,double c_y){
 
		
		boolka = temp;
		xMin =-2;
		xMax =2;
		yMin =-2;
		yMax =2;
		cx = c_x;
		cy = c_y;
		test = 1;
		
		createPanel();
		createControlPanel();
		setVisible(true);
		
		mpH = mainPanel.getHeight();
		mpW = mainPanel.getWidth();
		
	}

	
	
	public void createPanel(){
		
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		
		
		controlPanel = new JPanel();
		controlPanel.setBackground(Color.GRAY);
	
		
		Integer ps = GroupLayout.PREFERRED_SIZE;
		Integer ds = GroupLayout.DEFAULT_SIZE;
		Integer ot = 8;
	

		menuBar = new JMenuBar();
	    
	    menu = new JMenu("Menu");

	    form1 =new JMenuItem("z^2 + c");
	    form2 =new JMenuItem("z^3 + c");
	    form3 =new JMenuItem("z^2 + z + c");
	    form4 =new JMenuItem("z^3 + z + c");
	    
	    menu.add(form1);
	    menu.add(form2);
	    menu.add(form3);
	    menu.add(form4);
	    
		 
	    menuBar.add(menu);

	    
		GroupLayout gl1 = new GroupLayout(getContentPane());
		setLayout(gl1);
	gl1.setHorizontalGroup(
	         gl1.createSequentialGroup()
	         .addGap(ot)
	    	.addGroup(gl1.createParallelGroup(Alignment.LEADING)
 			.addComponent(mainPanel,ds,ds,ds)
 			.addGap(ot)
 			.addComponent(controlPanel,ds,ds,ds))
	    	.addGap(ot)
    		);
    gl1.setVerticalGroup(
    		gl1.createSequentialGroup()
    		.addGap(ot)
			.addComponent(mainPanel,ds,ds,ds)
			.addGap(ot)
			.addComponent(controlPanel,ps,ps,ps)
			.addGap(ot)
			
		);

   
  
    
	}
	public void createControlPanel(){

		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setJMenuBar(menuBar);

		
		form1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				formula = 1;
				repaint();
			}
			
		});
		form2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				formula = 2;
				repaint();
			}
			
		});
		form3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				formula = 3;
				repaint();
			}
			
		});
		form4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				formula = 4;
				repaint();
			}
			
		});
		btnRestart = new JButton();
		btnRestart.setText("Restart");
		
		btnRestart.addActionListener(new ActionListener(){
		
		    	@Override
		    	public void actionPerformed(ActionEvent arg0){
		    		
		    		xMin =-2;
				    xMax = 2;
				    yMin =-2;
				    yMax = 2;

				    		
		    		repaint();
		    	
		    		
		    	}
		    });

		
		btnSpace = new JButton();
		btnSpace.setText("Space");
		btnSpace.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			 
				
		        JFileChooser choose = new JFileChooser();

		        if (choose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ) {
		            try {	              
		            	loadTXT(choose.getSelectedFile().getPath());
		            }
		            catch (Exception e ) {
		                System.out.println(e.getMessage());
		            }
		        }
				
			}
			
		});
	
		
		btnSave = new JButton();
		btnSave.setText("Save");
		
		btnSave.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

					FileFilter filter = new FileNameExtensionFilter("txt","jpg");
			      
					JFileChooser choose = new JFileChooser();
			        choose.addChoosableFileFilter(filter);
			        if (choose.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {	
			            try {
			            	System.out.println(choose.getSelectedFile().getPath());
			            	
			            	
			            	//if(choose.getFileFilter() == "txt"){
			            		
			            		saveTXT(choose.getSelectedFile().getPath());
			            		
			            	//}
			            	
			            	//else{
			            		ImageIO.write(buffer,"jpeg", 
			            				new File(choose.getSelectedFile().getPath()));
			            //	}
			            	       	
			            }
			            catch (Exception e ) {
			                System.out.println("Æèçíü áîëü!");
			            }
			        }
				
			}
			
		});
		

		
		Integer ps = GroupLayout.PREFERRED_SIZE;
		Integer ds = GroupLayout.DEFAULT_SIZE;
		Integer ot = 8;
	    GroupLayout gl2 = new GroupLayout(controlPanel);
	    controlPanel.setLayout(gl2);
	    
		    gl2.setHorizontalGroup(gl2.createParallelGroup()	    
		    		.addGroup(gl2.createSequentialGroup()
		    				.addGap(ot, ot,ot)
		    				.addComponent(btnSpace,ps,ps,ps)
		    				.addGap(ot,ot,ot)
		    				)	
		    		.addGroup(gl2.createSequentialGroup()
		    				.addGap(ot, ot,230)
		    				.addComponent(btnSave,ps,ps,ps)
		    				.addGap(ot,ot,ot)
		    				)				
		    		.addGroup(gl2.createSequentialGroup()
		    				.addGap(ot, ot,Integer.MAX_VALUE)
			    			.addComponent(btnRestart,ps,ps,ps)
			    			.addGap(ot,ot,ot)
			    			)  		
		    		);
		    gl2.setVerticalGroup(gl2.createParallelGroup()
		    		.addGroup(gl2.createSequentialGroup()
		    				.addGap(ot)
		    				.addComponent(btnSpace,ps,ps,ps)	
		    			   	.addGap(ot)
		    			   	
		    				)
		    		.addGroup(gl2.createSequentialGroup()
		    				.addGap(ot, ot,230)
		    				.addComponent(btnSave,ps,ps,ps)
		    				.addGap(ot,ot,ot)
		    				)			
				   	.addGroup(gl2.createSequentialGroup()
				   			.addGap(ot)
							.addComponent(btnRestart,ps,ps,ps)
						    .addGap(ot)
				   			)
		    				
		    	
		    		);

	 mainPanel.addMouseListener(new MouseListener(){

	
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
					if(boolka){
						
						Convert conv = new Convert(xMin,xMax,yMin,yMax,mainPanel.getWidth(),mainPanel.getHeight());
						cx = conv.xToDecart(arg0.getX());
						cy = conv.yToDecart(arg0.getY());
						
						MainFrame julia = new MainFrame(false,cx,cy);
						
						
						julia.setVisible(true);
						
						repaint();
					}
					
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}
		
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
		
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
				
					xXOR = x1 = arg0.getX();
					yXOR = y1 = arg0.getY();

					
				}
		
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
					Convert conv = new Convert(xMin, xMax, yMin, yMax, mainPanel.getWidth(), mainPanel.getHeight());
					x2 = arg0.getX();
					y2 = arg0.getY();
					if(Math.abs(x1 - x2) > 10 && Math.abs(y1 - y2) > 10){
						xMin = conv.xToDecart(x1 < x2 ? x1 : x2);
						yMin = conv.yToDecart(y1 > y2 ? y1 : y2);		
										
									
						xMax = conv.xToDecart(x1 > x2 ? x1 : x2);
						yMax = conv.yToDecart(y1 < y2 ? y1 : y2);
						
						double[] zoom = getZoom(xMin,xMax,yMin,yMax);
						xMax = zoom[0];
						yMax = zoom[1];
						
						repaint();
					}
				
					
					
					


				}
		 
				
	 		} );
				
				
	 	
	 mainPanel.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e){
				paintBorder(xXOR,yXOR);
				paintBorder(e.getX(), e.getY());
				xXOR = e.getX();
				yXOR = e.getY();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	   
	 
	}
	
	void saveTXT(String temp){
		try{
			BufferedWriter wr = new BufferedWriter(new FileWriter(temp));
			
			wr.write( xMin + "\n" + xMax + "\n" + yMin + "\n" + yMax);
			wr.close();
		}catch(Exception ex){System.out.println(ex.getMessage());}
		
	}
	void loadTXT(String temp){
		
		double[] points = new double[4];
		try{
		BufferedReader buf = new BufferedReader(new FileReader(temp));
		 String line;
	        ArrayList<String> lines = new ArrayList<String>();
	        
	        while ((line = buf.readLine()) != null) {
	            lines.add(line);
	        }
	        buf.close();
	        for(int i=0; i<lines.size();i++){
	        	points[i] = Double.parseDouble(lines.get(i));
	        }
	        
		}catch(Exception ex){System.out.println(ex.getMessage());}
		
		xMin = points[0];
		xMax = points[1];
		yMin = points[2];
		yMax = points[3];
		
		repaint();
		
	
	}
	
	void paintBorder(int i, int j){
		Graphics g = buffer.getGraphics();
		g.setColor(Color.BLACK);
		g.setXORMode(Color.WHITE);
		g.drawRect((i < x1) ? i : x1, (j < y1) ? j : y1 , Math.abs(i - x1),Math.abs(j - y1));
		mainPanel.getGraphics().drawImage(buffer,0,0,null);
	}
	
	double[] getZoom(double x_1,double x_2,double y_1,double y_2){
		
		double[] res = new double[2];
		
		if(x_1 < x_2 && y_1 > y_2){
			res[0] = x_1 + (y_1 - y_2)*mainPanel.getWidth()/mainPanel.getHeight();
			res[1] = y_1 - (res[0] - x_1)*mainPanel.getHeight()/mainPanel.getWidth();

		}
		if(x_1 > x_2 && y_1 > y_2){
					
			res[0] = x_1 - (y_1 - y_2)*mainPanel.getWidth()/mainPanel.getHeight();
			res[1] = y_1 - (x_1 - res[0])*mainPanel.getHeight()/mainPanel.getWidth();
			
		}
		if(x_1 < x_2 && y_1 < y_2){
			
			res[1] = y_1 + (x_2 - x_1)*mainPanel.getHeight()/mainPanel.getWidth();
			res[0] = x_1 + (res[1] - y_1)*mainPanel.getWidth()/mainPanel.getHeight();
	
			
		}
		if(x_1 > x_2 && y_1 < y_2){
			res[0] = x_1 + (y_2 - y_1)*mainPanel.getWidth()/mainPanel.getHeight();
			res[1] = y_1 + (x_2 - x_1)*mainPanel.getHeight()/mainPanel.getWidth();
		
			
		}
	
		return res;
	}
	public void saveProp(){
		//System.out.println( xMin + "\n" + xMax + "\n" + yMin + "\n" + yMax);
			if(mpW != mainPanel.getWidth()){
				double kofs = (xMax - xMin)*((double)mainPanel.getWidth()/mpW - 1)/2;
				System.out.println(kofs);
				xMin -= kofs;
				xMax += kofs;
			}
			if(mpH != mainPanel.getHeight()){
				double kofs = (yMax-yMin)*((double)mainPanel.getHeight()/mpH - 1)/2;
				yMin -= kofs;
				yMax += kofs;
			}
			mpW = mainPanel.getWidth();
			mpH = mainPanel.getHeight(); 
			System.out.println( xMin + "\n" + xMax + "\n" + yMin + "\n" + yMax);
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
	
		saveProp();

		Convert conv = new Convert(xMin,xMax,yMin,yMax,mainPanel.getWidth(),mainPanel.getHeight());
		
		buffer = new BufferedImage(mainPanel.getWidth(), mainPanel.getHeight(),BufferedImage.TYPE_INT_RGB);

		g = buffer.getGraphics();
		
		
		Fractal frac= new Fractal(mainPanel,g,conv,formula);
		
		if(formula == 0) formula = 1;
		if(boolka){
			
			frac.threadMandelbrod();
			

		}
		else{
			frac.Julia(conv.xToPxl(cx),conv.yToPxl(cy));
			
			g.setColor(Color.WHITE);
			
			g.drawString("C = " + ((int)(cx * 1000))*1.0/1000 + ((cy > 0) ? "  +  " : "  -  " )
					+ ((int)(Math.abs(cy) * 1000))*1.0/1000  + "i",
					mainPanel.getWidth() - 200,mainPanel.getHeight() - 25);
		}
	
	  mainPanel.getGraphics().drawImage(buffer,0,0, null);

	  if(test == 1){
		   test++;
		   repaint();
	   }
		   

		
	}

	
	
    public void exit(){ 
		setVisible(true);
		dispose();
	}
	public static void main(String[] args){
		MainFrame frm = new MainFrame(true,0,0);
	
		//frm.setVisible(true);
	}


	
	
	
	
	

}*/
