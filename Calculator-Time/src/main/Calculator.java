package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator { 
	
	String firstNum = "";
	String secondNum = "";
	String result ="";
	int type = 0;
	boolean isFirst = true;
	boolean wasMath = false;
	
	JLabel main = new JLabel("");   
    JLabel typeL = new JLabel("");
    JLabel top = new JLabel("");
    	
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
        main.setFont(new Font("dsds", Font.BOLD, 29));
        
        top.setBounds(26,1,200,14);
        top.setFont(new Font("dsds", Font.PLAIN, 14));
        
        typeL.setBounds(16,1,20,14);
        typeL.setFont(new Font("dsds", Font.PLAIN, 12));
        s.setPreferredSize(new Dimension(200,55));
        
        p.setLayout(new GridLayout(4,4,3,3));
        s.setLayout(null);
               
        s.add(main);   
        s.add(top);
        s.add(typeL);
        
        frame.getContentPane().add(BorderLayout.NORTH, s);     
        frame.getContentPane().add(BorderLayout.CENTER, p); 
               
        JButton sev = new JButton("7"); 
        sev.setBackground(Color.WHITE);
        sev.setFont(new Font("dsds", Font.BOLD, 19));
        sev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (isFirst) {result = ""; firstNum += "7"; main.setText(firstNum);} else {secondNum += "7";  main.setText(secondNum);}   	
			}});					

        JButton eig = new JButton("8"); 
        eig.setBackground(Color.WHITE);
        eig.setFont(new Font("dsds", Font.BOLD, 19));
        eig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (isFirst) {result = ""; firstNum += "8"; main.setText(firstNum);} else {secondNum += "8";  main.setText(secondNum);}   	
			}});					

        JButton nin = new JButton("9");
        nin.setBackground(Color.WHITE);
        nin.setFont(new Font("dsds", Font.BOLD, 19));
        nin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (isFirst) {result = ""; firstNum += "9"; main.setText(firstNum);} else {secondNum += "9";  main.setText(secondNum);}   	
			}});					

        JButton del = new JButton("<="); 
        del.setBackground(new Color(240,240,240));
        del.addActionListener(new ActionListener() {
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
             
        JButton fou = new JButton("4"); 
        fou.setBackground(Color.WHITE);
        fou.setFont(new Font("dsds", Font.BOLD, 19));
        fou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (isFirst) {result = ""; firstNum += "4"; main.setText(firstNum);} else {secondNum += "4";  main.setText(secondNum);}   	
			}});					

        JButton fiv = new JButton("5"); 
        fiv.setBackground(Color.WHITE);
        fiv.setFont(new Font("dsds", Font.BOLD, 19));
        fiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (isFirst) {result = ""; firstNum += "5"; main.setText(firstNum);} else {secondNum += "5";  main.setText(secondNum);}   	
			}});					

        JButton six = new JButton("6");
        six.setBackground(Color.WHITE);
        six.setFont(new Font("dsds", Font.BOLD, 19));
        six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (isFirst) {result = ""; firstNum += "6"; main.setText(firstNum);} else {secondNum += "6";  main.setText(secondNum);}   	
			}});					

        JButton multi = new JButton("X");
        multi.setBackground(new Color(240,240,240));
        multi.addActionListener(new ActionListener() {
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
        
        JButton one = new JButton("1");
        one.setBackground(Color.WHITE);
        one.setFont(new Font("dsds", Font.BOLD, 19));      
        one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (isFirst) {result = ""; firstNum += "1"; main.setText(firstNum);} else {secondNum += "1";  main.setText(secondNum);}   	
			}});					

        JButton two = new JButton("2");
        two.setBackground(Color.WHITE);
        two.setFont(new Font("dsds", Font.BOLD, 19));
        two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (isFirst) {result = ""; firstNum += "2"; main.setText(firstNum);} else {secondNum += "2";  main.setText(secondNum);}   	
			}});					

        JButton thr = new JButton("3");
        thr.setBackground(Color.WHITE);
        thr.setFont(new Font("dsds", Font.BOLD, 19));
        thr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (isFirst) {result = ""; firstNum += "3"; main.setText(firstNum);} else {secondNum += "3";  main.setText(secondNum);}   	
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
        
        JButton min = new JButton("-");
        min.setBackground(new Color(240,240,240));
        min.addActionListener(new ActionListener() {
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
        
        JButton zer = new JButton("0");       
        zer.setBackground(Color.WHITE);
        zer.setFont(new Font("dsds", Font.BOLD, 19));
        zer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if (isFirst) {result = ""; firstNum += "0"; main.setText(firstNum);} else {secondNum += "0";  main.setText(secondNum);}   	
			}});					

        JButton plu = new JButton("+");  
        plu.setBackground(new Color(240,240,240));
        plu.addActionListener(new ActionListener() {
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
					top.setText("Выберите что-нибудь");					
				}
				
				if (result.length() > 0 && secondNum.equals("") ) {
					secondNum += result;
				}
				
				if (secondNum.equals("") && type > 0) secondNum += "0";
								
					if (type == 1) {
						result = "";
						result += Integer.valueOf(firstNum) + Integer.valueOf(secondNum);
						main.setText(result); top.setText(""); typeL.setText(""); firstNum = ""; secondNum = ""; isFirst = true; type = 0;	
				}				
					if (type == 2) {
						result = "";
						result += Integer.valueOf(firstNum) - Integer.valueOf(secondNum);
						main.setText(result); top.setText(""); typeL.setText(""); firstNum = ""; secondNum = ""; isFirst = true; type = 0;
				}
					
					if (type == 3) {
						result = "";
						result += Integer.valueOf(firstNum) * Integer.valueOf(secondNum);
						main.setText(result); top.setText(""); typeL.setText(""); firstNum = ""; secondNum = ""; isFirst = true; type = 0;			
				}
					
					if (type == 4) {
						result = "";
						result += Integer.valueOf(firstNum) / Integer.valueOf(secondNum);
						main.setText(result); top.setText(""); typeL.setText(""); firstNum = ""; secondNum = ""; isFirst = true; type = 0;
						}
							
				System.out.println("result - " + result);
				} });
                                           
        p.add(sev); 
        p.add(eig); 
        p.add(nin);
        p.add(del); 
        p.add(fou); 
        p.add(fiv); 
        p.add(six); 
        p.add(multi); 
        p.add(one); 
        p.add(two); 
        p.add(thr); 
        p.add(divide); 
        p.add(min);
        p.add(zer);          
        p.add(plu);     
        p.add(count); 
               
    }
}

