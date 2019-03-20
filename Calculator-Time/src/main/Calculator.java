package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator implements ActionListener { 
	
	String firstNum = "";
	String secondNum = "";
	String result ="";
	int type = 0;
    int ii = 0;
	boolean isFirst = true;
	boolean wasMath = false;
	
	JLabel main = new JLabel("");   
    JLabel typeL = new JLabel("");
    JLabel top = new JLabel("");
    
    JButton[] buttons;
    	
    static JFrame frame = new JFrame();
    
    
    public static void main(String[] args) { 
           	 
   	 	frame.setTitle("CalcTime");	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(230,240);
        frame.setVisible(true); 
        frame.setLocationRelativeTo(null);
        
        Calculator cal = new Calculator();
        cal.setupGUI();
    }
           
     public void setupGUI() {
         
        JPanel p = new JPanel(); 
        JPanel s = new JPanel();      
        
        main.setBounds(10,15,200,40);
        main.setFont(new Font("font", Font.BOLD, 29));
        
        top.setBounds(26,1,200,14);
        top.setFont(new Font("font", Font.PLAIN, 14));
        
        typeL.setBounds(16,1,20,14);
        typeL.setFont(new Font("font", Font.PLAIN, 12));
        
        p.setLayout(new GridLayout(4,4,3,3));
        
        s.setPreferredSize(new Dimension(200,55));
        s.setLayout(null);            
        s.add(main);   
        s.add(top);
        s.add(typeL);
        
        frame.getContentPane().add(BorderLayout.NORTH, s);     
        frame.getContentPane().add(BorderLayout.CENTER, p); 
               
        buttons = new JButton[10];
        
        for (int i = 0; i < 10; i++) {
        	ii = i;
        	buttons[i]  = new JButton(String.valueOf(i));
        	buttons[i].setBackground(Color.WHITE);
        	buttons[i].setFont(new Font("font", Font.BOLD, 19));
        	buttons[i].addActionListener(this);
        }           
        
       
        JButton delete = new JButton("<="); 
        delete.setBackground(new Color(240,240,240));
        delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (result.length() > 0) { result = result.substring(0, result.length()-1); main.setText(result); }
				  if (isFirst && firstNum.length() > 0) {			  
					  firstNum = firstNum.substring(0, firstNum.length()-1);
					  main.setText(firstNum);
					  if (!isFirst && firstNum.length() > 0) {
					  secondNum = secondNum.substring(0, secondNum.length()-1);
					  main.setText(secondNum);
				  }
			}}});				     
             
        
        JButton multiply = new JButton("X");
        multiply.setBackground(new Color(240,240,240));
        multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (result.length() > 0) {
					type = 3;				 					  
					typeL.setText("x");
					isFirst = false;
					firstNum = "";
					firstNum += result;
					top.setText(firstNum);
				}
				type = 3;
				typeL.setText("x");
				isFirst = false;
				top.setText(firstNum);
			}});				
        
        
        JButton divide = new JButton("/");
        divide.setBackground(new Color(240,240,240));
        divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (result.length() > 0) {
					type = 4;				 					  
					typeL.setText("/");
					isFirst = false;
					firstNum = "";
					firstNum += result;
					top.setText(firstNum);
				}
				type = 4;
				typeL.setText("/");
				isFirst = false;
				top.setText(firstNum);
			}});				     
        
        JButton minus = new JButton("-");
        minus.setBackground(new Color(240,240,240));
        minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (result.length() > 0) {
					type = 2;				 					  
					typeL.setText("-");
					isFirst = false;
					firstNum = "";
					firstNum += result;
					top.setText(firstNum);
				}
				type = 2;
				typeL.setText("-");
				isFirst = false;
				top.setText(firstNum);
			}});				     
              
        JButton plus = new JButton("+");  
        plus.setBackground(new Color(240,240,240));
        plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (result.length() > 0) {					  					  
					firstNum = "";
					firstNum += result;					  
				}
				type = 1;				 
				typeL.setText("+");
				isFirst = false;
				top.setText(firstNum);
			}});				
      
        JButton count = new JButton("="); 
        count.setBackground(new Color(240,240,240));
        count.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (type == 0) {
					top.setText("Choose mathtype");		
					return;
				}				
				if (secondNum.equals("") && result.length() > 0) secondNum += result;
				if (secondNum.equals("") && type > 0) secondNum = firstNum;
				
				result = ""; 
				
				if (type == 1) result += Integer.valueOf(firstNum) + Integer.valueOf(secondNum);		
				if (type == 2) result += Integer.valueOf(firstNum) - Integer.valueOf(secondNum);					
				if (type == 3) result += Integer.valueOf(firstNum) * Integer.valueOf(secondNum);
				if (type == 4) result += Integer.valueOf(firstNum) / Integer.valueOf(secondNum);
				
				main.setText(result);
				top.setText("");
				typeL.setText("");
				firstNum = "";
				secondNum = "";
				isFirst = true;
				type = 0;
				System.out.println("result - " + result);
			} 
		});
                                           
        p.add(buttons[7]);
        p.add(buttons[8]);
        p.add(buttons[9]);
        p.add(delete); 
        p.add(buttons[4]); 
        p.add(buttons[5]);
        p.add(buttons[6]); 
        p.add(multiply); 
        p.add(buttons[1]); 
        p.add(buttons[2]);
        p.add(buttons[3]);
        p.add(divide); 
        p.add(minus);
        p.add(buttons[0]);         
        p.add(plus);     
        p.add(count); 
     
    }
        
     
	public void actionPerformed(ActionEvent e) {	
		int source = Integer.parseInt(e.getActionCommand());
		System.out.println(source);
		
		if (source >= 0 && source <= 9) {
			if (isFirst) {
				result = ""; 
				firstNum += String.valueOf(source); 
				main.setText(firstNum);
			} else {
				secondNum += String.valueOf(source) ;  
				main.setText(secondNum);
			}
			return;
		}				
	
	}
}

