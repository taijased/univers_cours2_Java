/*
 Regular Expressions
 
 Pattern
 Matcher
 
 */
/*
 [^;]*?\.(bmp|jpg|gif|png); ��� ����� �������, ����� 
 [^;]*?\.(bmp|jpg|gif|png)   //////    ab.txt;a.bmp;s.zip;abc.jpg
 
 (ma)+
 
 a.*?;
 
 a.*
 ����� ���������� ����� ������
 ��������� ���������� ����� ����������
 */

import java.util.regex.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;



public class MainFrame extends JFrame  {
	JScrollPane sp;
	JPanel controlPanel;
	
	public MainFrame(){
		
	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	JTextPane tp = new JTextPane();
	sp = new JScrollPane (tp);
	tp.setContentType("text/html");
	controlPanel = new JPanel();
	setSize(800,600);
	}
	
	public static void main(String[] args) {
	controlPanel.setVisible(true);
		// TODO Auto-generated method stub
		/*
		�������
		JTextPane tp;
		JScrollPane sp = new JScrollPane(tp);
		tp= new
		tp.setContentType("text\html");
		*/
	/*	
Pattern p = Pattern.compile("m+ ");//������ ������
Matcher m = p.matcher("����� ������, ��� ����");
	m.find();//����� ������ ������ ��������� ��������������� ������ �������.
	m.start();
	m.end();
	
	System.out.println(m);
	}
*/
}
	}
