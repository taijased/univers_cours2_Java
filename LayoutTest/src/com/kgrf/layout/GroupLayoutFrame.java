package com.kgrf.layout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GroupLayoutFrame extends JFrame {

	private JLabel lblTitle; //анкета
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblMiddleName;
	private JLabel lblSex;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfMiddleName;
	private JRadioButton rbMale;
	private JRadioButton rbFeMale;
	private JButton btnSave;
	
	public GroupLayoutFrame(){
		lblTitle=new JLabel();
		lblFirstName= new JLabel();
		lblLastName=new JLabel();
		lblMiddleName= new JLabel();
		lblSex= new JLabel();
		tfFirstName=new JTextField();
		tfLastName=new JTextField();
		tfMiddleName=new JTextField();
		rbMale=new JRadioButton ();
		rbFeMale=new JRadioButton ();
		btnSave=new JButton ();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		GroupLayout mainLayout=new GroupLayout(getContentPane());
		this.setLayout(mainLayout);
		mainLayout.setHorizontalGroup(
				mainLayout.createParallelGroup(
					GroupLayout.Alignment.LEADING).
						addGroup(GroupLayout.Alignment.LEADING,
						mainLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addGap(16, 16, 16)
						.addComponent(tfLastName, 75,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
				.addContainerGap())
						
				.addGroup(
						GroupLayout.Alignment.LEADING,
						mainLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblFirstName, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addGap(16, 16, 16)
						.addComponent(tfFirstName,75, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
						.addContainerGap())
				
				.addGroup(
						GroupLayout.Alignment.LEADING,
						mainLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblMiddleName, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addGap(16, 16, 16)
						.addComponent(tfMiddleName, 75, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE)
		.addContainerGap())
				);
	mainLayout.setVerticalGroup(
			mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(GroupLayout.Alignment.LEADING,
					mainLayout.createSequentialGroup()
					.addGap(0,5,300)
					.addComponent(lblLastName, 24, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(0,5,300)
					.addComponent(lblFirstName, 24, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(0,5,300)
					.addComponent(lblMiddleName, 24, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap()
					)
			.addGroup(GroupLayout.Alignment.LEADING,
					mainLayout.createSequentialGroup()
					.addGap(0,5,300)
					.addComponent(tfLastName, 24, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(0,5,300)
					.addComponent(tfFirstName, 24, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(0,5,300)
					.addComponent(tfMiddleName, 24, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap()
					)
			);
	lblLastName.setText("Фамилия:");
	lblFirstName.setText("Имя:");
	lblMiddleName.setText("Отчество:");
	setSize(400,300);
	
	}
	
	public static void main(String[] args) {
		GroupLayoutFrame frm=new GroupLayoutFrame();
		frm.setVisible(true);
	}

}
