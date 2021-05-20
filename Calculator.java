import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener
{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextArea textarea = new JTextArea(2,10);
	//textarea.setEditable(false);
	
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton button0 = new JButton("0");
	
	JButton buttonadd = new JButton("+");
	JButton buttonsub = new JButton("-");
	JButton buttonmul = new JButton("*");
	JButton buttondiv = new JButton("/");
	JButton buttonclear = new JButton("C");
	JButton buttondot = new JButton(".");
	JButton buttonequal = new JButton("=");
	
	double number1,number2,result;
	int addc=0,subc=0,mulc=0,divc=0;
	
	public Calculator()
	{
		frame.setSize(340,450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Calculator");
		
		frame.add(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		Border border = BorderFactory.createLineBorder(Color.RED,4);
		
		panel.add(textarea);
		textarea.setBackground(Color.BLACK);
		Border tborder = BorderFactory.createLineBorder(Color.BLUE,3);
		textarea.setBorder(tborder);
		Font font = new Font("arial",Font.BOLD,33);
		textarea.setFont(font);
		textarea.setForeground(Color.WHITE);
		
		textarea.setPreferredSize(new Dimension(2,10));
		textarea.getLineWrap();
		
		button1.setPreferredSize(new Dimension(100,40));
		button2.setPreferredSize(new Dimension(100,40));
		button3.setPreferredSize(new Dimension(100,40));
		button4.setPreferredSize(new Dimension(100,40));
		button5.setPreferredSize(new Dimension(100,40));
		button6.setPreferredSize(new Dimension(100,40));
		button7.setPreferredSize(new Dimension(100,40));
		button8.setPreferredSize(new Dimension(100,40));
		button9.setPreferredSize(new Dimension(100,40));
		button0.setPreferredSize(new Dimension(100,40));
		buttondot.setPreferredSize(new Dimension(100,40));
		buttonsub.setPreferredSize(new Dimension(100,40));
		buttonmul.setPreferredSize(new Dimension(100,40));
		buttondiv.setPreferredSize(new Dimension(100,40));
		buttonadd.setPreferredSize(new Dimension(100,40));
		buttonequal.setPreferredSize(new Dimension(100,40));
		buttonclear.setPreferredSize(new Dimension(100,40));
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(button0);
		panel.add(buttondot);
		panel.add(buttonsub);
		panel.add(buttonmul);
		panel.add(buttondiv);
		panel.add(buttonadd);
		panel.add(buttonequal);
		panel.add(buttonclear);
		
		button1.addActionListener((ActionListener) this);
		button2.addActionListener((ActionListener) this);
		button3.addActionListener((ActionListener) this);
		button4.addActionListener((ActionListener) this);
		button5.addActionListener((ActionListener) this);
		button6.addActionListener((ActionListener) this);
		button7.addActionListener((ActionListener) this);
		button8.addActionListener((ActionListener) this);
		button9.addActionListener((ActionListener) this);
		button0.addActionListener((ActionListener) this);
		buttonadd.addActionListener((ActionListener) this);
		buttonsub.addActionListener((ActionListener) this);
		buttonmul.addActionListener((ActionListener) this);
		buttondiv.addActionListener((ActionListener) this);
		buttondot.addActionListener((ActionListener) this);
		buttonequal.addActionListener((ActionListener) this);
		buttonclear.addActionListener((ActionListener) this);
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source==buttonclear)
		{
			number1=0.0;
			number2=0.0;
			textarea.setText("");
			textarea.setEditable(false);
		}
		if(source == button1)
		textarea.append("1");
		
		if(source == button2)
		textarea.append("2");
		
		if(source == button3)
		textarea.append("3");
		
		if(source == button4)
		textarea.append("4");
		
		if(source == button5)
		textarea.append("5");
		
		if(source == button6)
		textarea.append("6");
		
		if(source == button7)
		textarea.append("7");
		
		if(source == button8)
		textarea.append("8");
		
		if(source == button9)
		textarea.append("9");
		
		if(source == button0)
		textarea.append("0");
		
		if(source == buttondot)
		textarea.append(".");
		
		if(source == buttonadd)
		{
			number1=number_reader();
			textarea.setText("");
			addc=1;
			subc=0;
			mulc=0;
			divc=0;
		}
		if(source == buttondiv)
		{
			number1=number_reader();
			textarea.setText("");
			addc=0;
			subc=0;
			mulc=0;
			divc=1;
		}
		if(source == buttonsub)
		{
			number1=number_reader();
			textarea.setText("");
			addc=0;
			subc=1;
			mulc=0;
			divc=0;
		}
		if(source == buttonmul)
		{
			number1=number_reader();
			textarea.setText("");
			addc=0;
			subc=0;
			mulc=1;
			divc=0;
		}
		
		if(source==buttonequal)
		{
			textarea.setEditable(false);
			number2=number_reader();
			if(addc>0)
			{
				result=number1+number2;
				textarea.setText(Double.toString(result));
				textarea.setEditable(false);
			}
			if(subc>0)
			{
				result=number1-number2;
				textarea.setText(Double.toString(result));
			}
			if(mulc>0)
			{
				result=number1*number2;
				textarea.setText(Double.toString(result));
			}
			if(divc>0)
			{
				result=number1/number2;
				textarea.setText(Double.toString(result));
			}
		}
		
	}
	
	public double number_reader()
	{
		double num1;
		String s;
		s=textarea.getText();
		num1 = Double.valueOf(s);
		return num1;
	}
	
	
	public static void main(String[] args)
	{
		Calculator c = new Calculator();
	}
	
}