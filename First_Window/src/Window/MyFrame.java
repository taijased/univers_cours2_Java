package Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {

	private JTextField tf1;
	private JButton btn1;
	private JLabel lbl1;
	
	public MyFrame(){
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	this.setSize(500, 400);
	
	setLayout(null);
	tf1=new JTextField();
	tf1.setBounds(30, 30, 400, 25);
	add(tf1);
	btn1=new JButton();
	btn1.setBounds(30,60,400,25);
	btn1.setText("Нажать нежно!!!");
	
	btn1.addActionListener(new ActionListener(){           	//														// анонимный класс	
		@Override											//
		public void actionPerformed(ActionEvent ae) {		//
			btn1Press(ae);	
		}
	});
	add(btn1);
	
	lbl1=new JLabel();
	lbl1.setBounds(30,90,400,25);
	lbl1.addMouseListener(new MouseAdapter (){
		@Override
		public void mouseClicked(MouseEvent e){
			
			lbl1Click(e);
		}
	});
	add(lbl1);
	}
	
	protected void lbl1Click(MouseEvent e){
		lbl1.setText("I'm here: ("+ e.getX()+","+e.getY()+")!");
	}
	
protected  void btn1Press(ActionEvent ae){
		lbl1.setText(tf1.getText());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame frame= new MyFrame();
		frame.setVisible(true);
	}
}