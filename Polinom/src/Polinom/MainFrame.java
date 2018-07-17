package Polinom;

import java.awt.Color; 
import java.awt.Graphics; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import javax.swing.GroupLayout; 
import javax.swing.GroupLayout.Alignment; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.event.ChangeEvent; 
import javax.swing.event.ChangeListener; 
import javax.swing.JSpinner; 
import javax.swing.SpinnerNumberModel;

public class MainFrame extends JFrame { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel; 
	private JPanel controlPanel; 
	private JButton btnPaint; 
	private JButton btnExit; 
	private JLabel lblxmin; 
	private JLabel lblymin; 
	private JLabel lblxmax; 
	private JLabel lblymax; 
	private JSpinner spxmin; 
	private JSpinner spymin; 
	private JSpinner spxmax; 
	private JSpinner spymax; 
	private PaintLagrange plg;
	
	public MainFrame(){  
		plg = new PaintLagrange();
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		mainPanel = new JPanel(); 
		mainPanel.setBackground(Color.LIGHT_GRAY);
		controlPanel = new JPanel(); 
		
		lblxmin = new JLabel(); 
		lblxmax = new JLabel(); 
		lblymin = new JLabel(); 
		lblymax = new JLabel(); 
		setSize(800,600); 
		setTitle("������� ��������"); 
		GroupLayout gl1 = new GroupLayout(getContentPane()); 
		setLayout(gl1); 
		spxmin = new JSpinner(new SpinnerNumberModel(-5.1,-50,5.2,0.1)); 
		spxmax = new JSpinner(new SpinnerNumberModel(5.1,-5.0,50,0.1)); 
		spymin = new JSpinner(new SpinnerNumberModel(-5.5,-50,5.4,0.1)); 
		spymax = new JSpinner(new SpinnerNumberModel(5.5,-5.4,50,0.1)); 
		lblxmin.setText("Xmin");
		lblxmax.setText("Xmax"); 
		lblymin.setText("Ymin"); 
		lblymax.setText("Ymax"); 
		spxmin.addChangeListener(new ChangeListener(){ 
			@Override 
			public void stateChanged(ChangeEvent ce) { 
				//TODO Auto-generated method stub 
				spvalChanged(ce,1); 
			} 
		}); 
		spxmax.addChangeListener(new ChangeListener(){ 
			@Override 
			public void stateChanged(ChangeEvent ce) { 
				//TODO Auto-generated method stub 
				spvalChanged(ce,2); 
			} 
		}); 

		spymin.addChangeListener(new ChangeListener(){ 

			@Override 
			public void stateChanged(ChangeEvent ce) { 
				//TODO Auto-generated method stub 
				spvalChanged(ce,3); 
			} 
		}); 

		spymax.addChangeListener(new ChangeListener(){ 

			@Override 
			public void stateChanged(ChangeEvent ce) { 
				//TODO Auto-generated method stub 
				spvalChanged(ce,4); 
			} 
		}); 

		mainPanel.addMouseListener(new MouseAdapter(){ 
			public void mouseClicked(MouseEvent e){ 
			//System.out.println ("sdf"); 
				panelClick(e); 
			} 
		}); 

		gl1.setHorizontalGroup( 
				gl1.createSequentialGroup() 
				.addGap(8) 
				.addGroup(gl1.createParallelGroup(Alignment.LEADING) 
						.addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE) 
						.addGap(8) 
						.addComponent(controlPanel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE) 
						) 
				
				.addGap(8) 
				); 

		gl1.setVerticalGroup( 
				gl1.createSequentialGroup() 
				.addGap(8) 
				.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 
						GroupLayout.DEFAULT_SIZE) 
				.addGap(8) 
				.addComponent(controlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
						GroupLayout.PREFERRED_SIZE) 
				.addGap(8) 
				); 

		btnPaint = new JButton(); 
		btnPaint.setBackground(Color.GRAY);
		btnExit = new JButton(); 
		btnExit.setBackground(Color.GRAY);
		btnPaint.setText("��������"); 
		
		btnExit.setText("�����");
		btnExit.addActionListener(new ActionListener(){ // ��������� ����� 

			public void actionPerformed(ActionEvent ae) { 
				btnExitPress(ae); 
			} 

		}); 

		btnPaint.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent ae) { 
				draw(ae); 
			} 
		}); 

		GroupLayout gl2 = new GroupLayout(controlPanel); 
		controlPanel.setLayout(gl2); 
		gl2.setHorizontalGroup(gl2.createSequentialGroup() 
				.addGroup(gl2.createParallelGroup(Alignment.LEADING) 
						.addGroup(gl2.createSequentialGroup() 
								.addGap(16) 
								.addComponent(lblxmin, GroupLayout.PREFERRED_SIZE,
										GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
								.addGap(8) 
								.addComponent(spxmin, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE) 
								.addGap(8,8,Integer.MAX_VALUE) 
								.addComponent(lblxmax, GroupLayout.PREFERRED_SIZE,
										GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
								.addGap(8) 
								.addComponent(spxmax, GroupLayout.PREFERRED_SIZE, 
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE) 
								) 
						.addGroup(gl2.createSequentialGroup() 
								.addGap(16) 
								.addComponent(lblymin, GroupLayout.PREFERRED_SIZE, 
										GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
								.addGap(8) 
								.addComponent(spymin, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE) 
								.addGap(8,8,Integer.MAX_VALUE) 
								.addComponent(lblymax, GroupLayout.PREFERRED_SIZE,
										GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
								.addGap(8) 
								.addComponent(spymax, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE) 
								) 
						) 
				.addGroup(gl2.createParallelGroup(Alignment.TRAILING) 
						.addGroup(gl2.createSequentialGroup() 
								.addGap(8,8,Integer.MAX_VALUE) 
								.addComponent(btnPaint, GroupLayout.PREFERRED_SIZE,
										GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
								.addGap(8) 
								.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 
										GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
								.addGap(16) 
								) 
						) 
				); 

		gl2.setVerticalGroup(gl2.createParallelGroup(Alignment.LEADING) 
				.addGroup(gl2.createSequentialGroup() 
						.addGap(8) 
						.addComponent(lblxmin, GroupLayout.PREFERRED_SIZE,
								GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
						.addGap(8) 
						.addComponent(lblymin, GroupLayout.PREFERRED_SIZE,
								GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
						.addGap(8) 
						) 
				.addGroup(gl2.createSequentialGroup() 
						.addGap(8) 
						.addComponent(spxmin, GroupLayout.PREFERRED_SIZE,
								GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
						.addGap(8) 
						.addComponent(spymin, GroupLayout.PREFERRED_SIZE, 
								GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
						.addGap(8) 
						) 
				.addGroup(gl2.createSequentialGroup() 
						.addGap(8) 
						.addComponent(lblxmax, GroupLayout.PREFERRED_SIZE, 
								GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
						.addGap(8) 
						.addComponent(lblymax, GroupLayout.PREFERRED_SIZE, 
								GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
						.addGap(8) 
						) 
				.addGroup(gl2.createSequentialGroup() 
						.addGap(8) 
						.addComponent(spxmax, GroupLayout.PREFERRED_SIZE,
								GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
						.addGap(8) 
						.addComponent(spymax, GroupLayout.PREFERRED_SIZE,
								GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
						.addGap(8) 
						) 

				.addGroup(gl2.createSequentialGroup() 
						.addGap(20) 
						.addComponent(btnPaint, GroupLayout.PREFERRED_SIZE,
								GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
						.addGap(20) 
						)
				.addGroup(gl2.createSequentialGroup() 
						.addGap(20) 
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE,
								GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE) 
						.addGap(20) 
						)); 
	} 


	public void repaintGraphic(){ 
		Graphics g = mainPanel.getGraphics(); 
		g.setColor(Color.white); 
		g.fillRect(0, 0, mainPanel.getWidth(), mainPanel.getHeight()); 
		DecartPainter dp = new DecartPainter((double)spxmin.getValue(),
				(double)spxmax.getValue(),(double)spymin.getValue(),
				(double)spymax.getValue(),mainPanel.getWidth(),mainPanel.getHeight()); 
		dp.PaintAxes(g); 
		dp.PaintDiv(g); 
	} 
	
	protected void spvalChanged(ChangeEvent ce,int x){// ��������� ������� �� ���� 
		SpinnerNumberModel snm; 
		switch(x){ 
			case 1:{ 
				double d = (double)spxmax.getValue(); 
				snm = new SpinnerNumberModel(d,(double)spxmin.getValue()+0.1,50,0.1); 
				spxmax.setModel(snm); 
				break; 
			} 
			case 2:{ 
				double d = (double)spxmin.getValue(); 
				snm = new SpinnerNumberModel(d,-50,(double)spxmax.getValue()-0.1,0.1); 
				spxmin.setModel(snm); 
				break; 
			} 
			case 3:{ 
				double d = (double)spymax.getValue(); 
				snm = new SpinnerNumberModel(d,(double)spymin.getValue()+0.1,50,0.1); 
				spymax.setModel(snm); 
				break; 
			} 
			case 4:{ 
				double d = (double)spymin.getValue(); 
				snm = new SpinnerNumberModel(d,-50,(double)spymax.getValue()-0.1,0.1); 
				spymin.setModel(snm); 
				break; 
			} 
		} 
		repaintGraphic(); 

		Graphics g = mainPanel.getGraphics(); 

		plg.ShowNodes(g,(double)spxmin.getValue(),(double)spxmax.getValue(),(double)spymin.getValue(),
				(double)spymax.getValue(),mainPanel.getWidth(),mainPanel.getHeight()); 
		plg.ShowLagrange(g,(double)spxmin.getValue(),(double)spxmax.getValue(),(double)spymin.getValue(),
				(double)spymax.getValue(),mainPanel.getWidth(),mainPanel.getHeight() ); 
	} 

	protected void panelClick(MouseEvent e){ 
		if(e.getButton()==MouseEvent.BUTTON1){ 
			int px = e.getX(); 
			int py = e.getY(); 
			Converter con = new Converter((double)spxmin.getValue(),(double)spxmax.getValue(),
					(double)spymin.getValue(), (double)spymax.getValue(),mainPanel.getWidth(), 
					mainPanel.getHeight()); 
			double x = con.PxtoX(px); 
			double y = con.PytoY(py); 
			plg.AddNodes(x, y);
		
		//	plg.GetLagrange();
			showGraphic();
		}
	} 
	
	protected void showGraphic(){ 
		repaintGraphic(); 
		Graphics g= mainPanel.getGraphics() ; 
		plg.ShowNodes(g, (double)spxmin.getValue(),(double)spxmax.getValue(),
				(double)spymin.getValue(), (double)spymax.getValue(),mainPanel.getWidth(),mainPanel.getHeight()); 
		plg.ShowLagrange(g, (double)spxmin.getValue(),(double)spxmax.getValue(),
				(double)spymin.getValue(), (double)spymax.getValue(),mainPanel.getWidth(),mainPanel.getHeight()); 
	
	} 

	protected void btnExitPress(ActionEvent ae){ 
		setVisible(false); 
		this.dispose(); 
	} 

	protected void draw(ActionEvent ae){ 
		repaintGraphic(); 
		plg = new PaintLagrange();
	} 

	public void paint(Graphics g){ 
		super.paint(g); 
		DecartPainter dp = new DecartPainter((double)spxmin.getValue(),(double)spxmax.getValue(),
				(double)spymin.getValue(),(double)spymax.getValue(),mainPanel.getWidth(),mainPanel.getHeight()); 
		dp.PaintAxes(g); 
		dp.PaintDiv(g); 
		showGraphic(); 
	} 
	
	public static void main(String[] args){ 
		MainFrame frm = new MainFrame(); 
		frm.setVisible(true); 
	} 
}