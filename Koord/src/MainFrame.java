import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.GroupLayout.Alignment;

public class MainFrame extends JFrame {
	
	private JPanel mainPanel;
	private JPanel controlPanel;
	private JButton btnExit;
	private JSpinner jsxMin;
	private JSpinner jsxMax;
	private JSpinner jsyMin;
	private JSpinner jsyMax;
	private JLabel lbxMin;
	private JLabel lbxMax;
	private JLabel lbyMin;
	private JLabel lbyMax;
	
	public MainFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500,600);
		mainPanel = new JPanel();
		controlPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		btnExit = new JButton();
		btnExit.setText("Выход");
		btnExit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Exit();
			}
			
		});

		SpinnerNumberModel ma = new SpinnerNumberModel(5.0,1.0,10.0,0.1);
		SpinnerNumberModel mi = new SpinnerNumberModel(-5.0,-10.0,-1.0,0.1);
		SpinnerNumberModel yma = new SpinnerNumberModel(5.0,1.0,10.0,0.1);
		SpinnerNumberModel ymi = new SpinnerNumberModel(-5.0,-10.0,-1.0,0.1);
		jsxMin = new JSpinner(mi);
		jsxMin.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				//repaint();
				draw();
			}
			
		});
		jsxMax = new JSpinner(ma);
		jsxMax.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				draw();
			}
			
		});
		jsyMin = new JSpinner(ymi);
		jsyMin.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				draw();
			}
			
		});
		jsyMax = new JSpinner(yma);
		jsyMax.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				draw();
			}
			
		});
		lbxMin = new JLabel();
		lbxMin.setText("X min");
		lbxMax = new JLabel();
		lbxMax.setText("X max");
		lbyMin = new JLabel();
		lbyMin.setText("Y min");
		lbyMax = new JLabel();
		lbyMax.setText("Y max");
		/*this.addPropertyChangeListener(new PropertyChangeListener(){

			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				repaint();
			}
		});
		*/
		GroupLayout g11 = new GroupLayout(getContentPane());
		setLayout(g11);
		g11.setHorizontalGroup(
				g11.createSequentialGroup()
				.addGap(8)
				.addGroup(
				g11.createParallelGroup(Alignment.LEADING)
				.addGap(8)
				.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
				.addGap(8)
				.addComponent(controlPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
				)
				.addGap(8)
				);
		g11.setVerticalGroup(
				g11.createSequentialGroup()
				.addContainerGap()
				.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
				.addGap(8)
				.addComponent(controlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()		
				);
		
		GroupLayout g22 = new GroupLayout(controlPanel);
		controlPanel.setLayout(g22);
		g22.setHorizontalGroup(
				g22.createSequentialGroup()
				.addGroup(
						g22.createParallelGroup()
						.addGap(8)
						.addComponent(lbxMin, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(16)
						.addComponent(lbyMin, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(8)
						)
				.addGroup(
						g22.createParallelGroup()
						.addGap(8)
						.addComponent(jsxMin, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(16)
						.addComponent(jsyMin, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(8)
						)
				.addGap(20, 20, Integer.MAX_VALUE)
				.addGroup(
						g22.createParallelGroup()
						.addGap(8)
						.addComponent(lbxMax, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(16)
						.addComponent(lbyMax, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(8)					
						)
				
				.addGroup(
						g22.createParallelGroup()
						.addGap(8)
						.addComponent(jsxMax, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(16)
						.addComponent(jsyMax, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(8)
						
						)
				.addGap(8, 8, Integer.MAX_VALUE)
				.addGroup(
						g22.createParallelGroup()
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(8)
						)
				);
		
		g22.setVerticalGroup(
				g22.createParallelGroup()
				.addGroup(
						g22.createSequentialGroup()
						.addContainerGap()
						.addComponent(lbxMin, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(16)
						.addComponent(lbyMin, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(8)
						)
				.addGroup(
						g22.createSequentialGroup()
						.addContainerGap()
						.addComponent(jsxMin, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(16)
						.addComponent(jsyMin, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(8)
						
						)
				.addGroup(
						g22.createSequentialGroup()
						.addContainerGap()
						.addComponent(lbxMax, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(16)
						.addComponent(lbyMax, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(8)	
						)
				.addGroup(
						g22.createSequentialGroup()
						.addContainerGap()
						.addComponent(jsxMax, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(16)
						.addComponent(jsyMax, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addGap(8)												
						)
				
				.addComponent(btnExit, Alignment.CENTER)
				);	
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Preobraz preobr = new Preobraz(mainPanel.getWidth(),mainPanel.getHeight(),
				(double)(jsxMax.getValue()),(double)jsxMin.getValue(),
				(double)jsyMax.getValue(),(double)jsyMin.getValue());
		preobr.PaintDecart(mainPanel.getGraphics());
	}
	
	public void draw(){
		mainPanel.update(mainPanel.getGraphics());
		Preobraz preobr = new Preobraz(mainPanel.getWidth(),mainPanel.getHeight(),
				(double)(jsxMax.getValue()),(double)jsxMin.getValue(),
				(double)jsyMax.getValue(),(double)jsyMin.getValue());
		preobr.PaintDecart(mainPanel.getGraphics());
	}
	
	/**
	 * Метод предназначен для показания работы альт+шифт+j
	 * @param x
	 * @return
	 */
	public int testMethod(int x){
		return (x>0)? x:-x;
	}
	
	public void Exit(){
		dispose();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame frm = new MainFrame();
		frm.setVisible(true);
	}
}