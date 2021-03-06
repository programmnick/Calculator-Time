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
	
	String firstNum = "0";
	String secondNum = "";
	String result = "";
	
	int type = 0;
	int source = 0;
	
	boolean isFirst = true;
	boolean wasMath = false;
	
	JLabel main = new JLabel("");   
    JLabel typeL = new JLabel("");
    JLabel top = new JLabel("");
    
    JButton[] buttons;
    String[] buttonNames = {"0","1","2","3","4","5","6","7","8","9","←","x","/","-","+","CE","C","+-",".","="};
                                                                   //10//11//12//13//14 //15//16//17 //18 //19
    	
    static JFrame frame = new JFrame();
     
    public static void main(String[] args) { 
           	 
   	 	frame.setTitle("CalcTime");	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(270,300);
        frame.setVisible(true); 
        frame.setLocationRelativeTo(null);
        
        Calculator cal = new Calculator();
        cal.setupGUI();
    }
           
     public void setupGUI() {         
        JPanel p = new JPanel(); 
        JPanel s = new JPanel();      
        
        main.setText(firstNum);
        main.setBounds(10,15,200,40);
        main.setFont(new Font("font", Font.BOLD, 29));
        
        top.setBounds(26,1,200,14);
        top.setFont(new Font("font", Font.PLAIN, 14));
        
        typeL.setBounds(16,1,20,14);
        typeL.setFont(new Font("font", Font.PLAIN, 12));
        
        p.setLayout(new GridLayout(5,4,3,3));
        
        s.setPreferredSize(new Dimension(200,55));
        s.setLayout(null);            
        s.add(main);   
        s.add(top);
        s.add(typeL);
        
        frame.getContentPane().add(BorderLayout.NORTH, s);     
        frame.getContentPane().add(BorderLayout.CENTER, p); 
               
        buttons = new JButton[20];
         
        for (int i = 0; i < 10; i++) {
        	buttons[i] = new JButton(String.valueOf(i));
        	buttons[i].setBackground(Color.WHITE);
        	buttons[i].setFont(new Font("font", Font.BOLD, 21));
        	buttons[i].addActionListener(this);
        }           
        
        for (int i = 10; i < 20; i++) {
        	buttons[i] = new JButton(buttonNames[i]);
        	buttons[i].setBackground(new Color(240,240,240)); 
        	if (i == 15 || i == 16)
        		buttons[i].setFont(new Font("font", Font.BOLD, 16));
        	else
        		buttons[i].setFont(new Font("font", Font.BOLD, 19));
        	buttons[i].addActionListener(this);
        }           
        
        p.add(buttons[15]);
        p.add(buttons[16]);
        p.add(buttons[10]);
        p.add(buttons[12]);
        p.add(buttons[7]);
        p.add(buttons[8]);
        p.add(buttons[9]);
        p.add(buttons[11]);        
        p.add(buttons[4]); 
        p.add(buttons[5]);
        p.add(buttons[6]);
        p.add(buttons[13]);
        p.add(buttons[1]); 
        p.add(buttons[2]);
        p.add(buttons[3]);
        p.add(buttons[14]); 
        p.add(buttons[17]);
        p.add(buttons[0]);         
        p.add(buttons[18]);     
        p.add(buttons[19]);  
    }
           
	public void actionPerformed(ActionEvent e) {	
		for (int i = 0; i < 20; i++) {
			if (e.getActionCommand().equals(buttonNames[i])) {
				source = i;
			}
		}			
		
		switch (source) {
		case 10: 		
			if (result.length() > 0) { 
				result = result.substring(0, result.length()-1); 
				main.setText(result); 				
			}
			if (isFirst && firstNum.length() > 0) {			  
				firstNum = firstNum.substring(0, firstNum.length()-1);
				main.setText(firstNum);
			}
			if (!isFirst && firstNum.length() > 0) {
				secondNum = secondNum.substring(0, secondNum.length()-1);
				main.setText(secondNum);			
			}
			return; 
		
		case 11:
		case 12:
		case 13:
		case 14:
			if (firstNum.equals("") && secondNum.equals("") && result.equals("")) 
				return;	
			
			if (result.length() > 0 && main.getText().equals(""))
				return;				
				else if (result.length() > 0) 						  					  
					firstNum = result;					  		
			
			type = source;				 
			typeL.setText(buttonNames[source]);
			isFirst = false;
			top.setText(firstNum); 
			return;
			
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			if (firstNum.equals("0"))
				firstNum = "";
			
			if (isFirst) {
				result = ""; 
				firstNum += String.valueOf(source); 
				main.setText(firstNum);
			} else {
				secondNum += String.valueOf(source) ;  
				main.setText(secondNum);
			}		
			return;
		
		case 17:
			if (firstNum.equals("") && secondNum.equals("")) 
				return;
			
			String case17 = "";		
			if (isFirst)  case17 = firstNum;
				else 	  case17 = secondNum;
			
			if (case17.substring(0,1).equals("-")) 
				case17 = case17.substring(1,case17.length());
			else case17 = "-" + case17;
			
			if (isFirst)  main.setText(firstNum = case17);
				else 	  main.setText(secondNum = case17);
			
			return;		
			
		case 18:
			if (firstNum.equals("0"))
				firstNum = "";
			
			if (isFirst) { 			
				for (int i=0; i < firstNum.length(); i++) {
					if (firstNum.substring(i,i+1).equals("."))
							return;
				}
				main.setText(firstNum += ".");
				
			} else	{		
				for (int i=0; i < secondNum.length(); i++) {
					if (secondNum.substring(i,i+1).equals("."))
							return;
				}
				main.setText(secondNum += ".");			
			}
			return;
			
		case 19: 
			if (type == 0) return;											
			if (secondNum.equals("") && result.length() > 0) secondNum += result;
			if (secondNum.equals("") && type > 0) secondNum = firstNum;
			if (firstNum.equals("")) firstNum = "0";
			
			result = ""; 
						
			if (type == 14) result += Double.valueOf(firstNum) + Double.valueOf(secondNum);
			if (type == 13) result += Double.valueOf(firstNum) - Double.valueOf(secondNum);					
			if (type == 11) result += Double.valueOf(firstNum) * Double.valueOf(secondNum);
			if (type == 12) result += Double.valueOf(firstNum) / Double.valueOf(secondNum);								
			
			if ((result.substring(result.length()-2,result.length()).equals(".0"))) 					
				result = result.substring(0,result.length()-2);
			if ((result.substring(result.length()-1,result.length()).equals("."))) 					
				result = result.substring(0,result.length()-2);
			
			System.out.println(firstNum + " " + secondNum + " " + result); //for testing
			
			main.setText(result);				
			 
		case 16: 			
			if (source == 16) 
			main.setText(firstNum = "0");			
		
		case 15: 
			if (source == 15) {
				if (result.length() > 0) {
					main.setText(result = "0");
					break;
				} 
				else if (isFirst) 
					main.setText(firstNum = "0");					
				else if (!isFirst)
					main.setText(secondNum = "");
				return;
			}
			
		case 1916: //same code on 19(=), 15(CE) and 16(C) C will be added later
			top.setText(""); 
			typeL.setText("");
			firstNum = "0";
			secondNum = "";
			isFirst = true;
			type = 0;
			return;									
		}								
		
	}	
}
		

