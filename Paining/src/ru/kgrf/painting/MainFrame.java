package ru.kgrf.painting;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private JPanel mainPanel;
	private JPanel controlPanel;
	private JButton btnPaint;
	private JButton btnExit;
	public MainFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		mainPanel = new JPanel();
		controlPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		controlPanel.setBackground(Color.DARK_GRAY);
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
		btnPaint = new JButton();
		btnExit = new JButton();
		btnPaint.setText("Нарисовать");
		btnExit.setText("Выход");
		btnExit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				exit();
				}
			});
		
		btnPaint.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				draw();
			}
			});
		
		GroupLayout g12 = new GroupLayout(controlPanel);
		controlPanel.setLayout(g12);
		g12.setHorizontalGroup(
				g12.createParallelGroup(Alignment.CENTER)
				.addGroup(g12.createSequentialGroup()
				.addGap(8,8,Integer.MAX_VALUE)
				.addComponent(btnPaint, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(8,8,Integer.MAX_VALUE)
				.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(8,8,Integer.MAX_VALUE)
				)
					);
		g12.setVerticalGroup(g12.createParallelGroup(Alignment.CENTER)
				.addGroup(g12.createSequentialGroup()
						.addGap(8)
						.addComponent(btnPaint, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(8)
						
						)
				.addGroup(g12.createSequentialGroup()
						.addGap(8)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(8)
						)
				);	
	}
	
	public void exit(){
		setVisible(false);
		dispose();//вызывает деструктор
	}

	//переопределяем метод
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Painter p = new Painter(mainPanel.getGraphics());
		p.paint();
	}
	
	protected void draw(){
		Painter p = new Painter(mainPanel.getGraphics());
		p.paint();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame frm = new MainFrame();
		frm.setVisible(true);
	}
}
