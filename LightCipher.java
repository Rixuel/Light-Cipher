/*
 * Light Cipher
 * Send coded messages to your friends.
 * It lightly codes your messages. Messages can be decoded too.
 * 
 * @author Lord Rixuel
 * @since 2015-03-16
 */

package code;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.*;

public class LightCipher {
	
	private static String softwareName = "Light Cipher";
	private static JTextArea input;
	private static JTextArea output;
	private static int level = 0;
	
    public static void main(String[] args)
    {
    	GUI();
    }
    
    private static void GUI() 
    {
    	// Detect User's Screen size
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
    	
        // Frame creation.
    	JFrame frame = new JFrame(softwareName);
    	frame.setSize(794, 371); // Width, Height
    	frame.setLayout(null);
    	frame.setResizable(false);
    	frame.setUndecorated(true);
    	
    	// Frame will appear at the middle of the screen.
        frame.setLocation(width/2-frame.getSize().width/2, height/2-frame.getSize().height/2); // Frame to middle screen.
    	//frame.setLocationRelativeTo(null); // Frame to middle screen.
        frame.add(panelTitle(frame));

    	Container container = frame.getContentPane();
    	container.setBackground(new Color(0, 0, 0));
    	
    	// Adding textareas with JScrollPane.
    	JTextArea inArea = inputArea();
    	container.add(textInput(inArea));
    	JTextArea outArea = outputArea();
    	container.add(textOutput(outArea));
        
        frame.add(panelFooter(frame));
        
        
    	// Show it.
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
    
    
    /*
     * Panel of the top side.
     * @param jf This uses the JFrame so MotionPanel can make undecorated frame move.
     */
    private static JPanel panelTitle(JFrame jf)
    {
    	JPanel paneltitle = new MotionPanel(jf); // MotionPanel allows you to move undecorated JFrame.
        paneltitle.setLayout(null);//(new GridBagLayout());//new FlowLayout());
        paneltitle.setBounds(2, 2, 790, 70);
        paneltitle.setBorder(BorderFactory.createLineBorder(new Color(60, 65, 70)));
        paneltitle.setBackground(new Color(60, 65, 70));
        
        // Options.
        paneltitle.add(closeButton(jf));
        paneltitle.add(miniButton(jf));
        
        paneltitle.add(title());
        paneltitle.add(titleLine());
        paneltitle.add(liteSpeak());
        paneltitle.add(tyhudSpeak());
        paneltitle.add(copySelectAll());
        paneltitle.add(toCode());
        
        return paneltitle;
    }
    private static JLabel title()
    {
    	JLabel title = new JLabel(softwareName);
        title.setFont(new Font("Verdana", Font.PLAIN, 30));
        title.setForeground(new Color(255, 255, 255));
        title.setBounds(8, 2, 320, 40);
        
        return title;
    }
    private static JLabel titleLine()
    {
    	JLabel title = new JLabel("Send coded messages to your friends -- Lord Rixuel");
        title.setFont(new Font("Consolas", Font.PLAIN, 12));
        title.setForeground(new Color(190, 255, 0));
        title.setBounds(10, 32, 420, 40);
        
        return title;
    }
    
    
    
    
    private static JTextArea inputArea()
    {
    	input = new JTextArea();
    	//input.setEditable(false);
    	input.setLineWrap(true); // Text return to line, so no horizontal scrollbar
    	input.setForeground(Color.WHITE);
    	input.setBackground(Color.BLACK);
    	input.setMargin( new Insets(10,10,10,10) ); // Margin
    	input.setFont(new Font("Consolas", Font.PLAIN, 14));
    	        
        return input;
    }
    private static JScrollPane textInput(final JTextArea area)
    { 	
    	JScrollPane scrollPane = new JScrollPane(area);
    	scrollPane.setBounds(2, 75, 394, 252);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        scrollPane.getVerticalScrollBar().setBackground(Color.BLACK);
        
        return scrollPane;
    }
    
    private static JTextArea outputArea()
    {
    	output = new JTextArea();
    	output.setEditable(false);
    	output.setLineWrap(true); // Text return to line, so no horizontal scrollbar
    	output.setForeground(Color.WHITE);
    	output.setBackground(Color.BLACK);
    	output.setMargin( new Insets(10,10,10,10) ); // Margin
    	output.setFont(new Font("Consolas", Font.PLAIN, 14));
    	
    	return output;
    }
    private static JScrollPane textOutput(final JTextArea area)
    {
    	JScrollPane scrollPane2 = new JScrollPane(area);
    	scrollPane2.setBounds(398, 75, 394, 252);
        scrollPane2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        scrollPane2.getVerticalScrollBar().setBackground(Color.BLACK);
        
        return scrollPane2;
    }
     
    
    private static JButton liteSpeak()
    {
    	JButton lsbtn = new JButton("1337 Speak");
    	lsbtn.setMnemonic('l'); // Shortcut: Alt + L
    	lsbtn.setFont(new Font("Verdana", Font.PLAIN, 11));
    	lsbtn.setForeground(new Color(255, 255, 255));
    	lsbtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    	lsbtn.setBackground(new Color(38, 40, 44));
    	lsbtn.setBounds(446, 10, 100, 24);
        
    	lsbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                //action listener here     	
            	output.setText( liteSpeakText(output.getText()) );
            }
        });
        
        return lsbtn;
    }
    private static String liteSpeakText(String str)
    {
    	StringBuilder sb = new StringBuilder(str);

    	for(int i=0; i<sb.length(); i++)
    	{
    		// Every character of StringBuilder to a char variable.
    		char value = sb.charAt(i);
    		
    		if( (value>='A'&&value<='Z') || (value>='a'&&value<='z') )
    		{
    			char newValue = liteSpeakList(value);
	    		
	    		// Set changed value.
	    		sb.setCharAt(i, newValue);
    		}
    		else
    		{
    			// Keep value.
    			sb.setCharAt(i, value);
    		}
    	}
    	
    	return sb.toString();
    }
    private static char liteSpeakList(char letter)
    {
		if(letter=='A' || letter=='a'){letter='4';}
		else if(letter=='B' || letter=='b'){letter='8';}
		else if(letter=='C' || letter=='c'){letter='(';}
		else if(letter=='E' || letter=='e'){letter='3';}
		else if(letter=='G' || letter=='g'){letter='6';}
		else if(letter=='I' || letter=='i'){letter='1';}
		else if(letter=='O' || letter=='o'){letter='0';}
		else if(letter=='Q' || letter=='q'){letter='9';}
		else if(letter=='S'){letter='$';}
		else if(letter=='s'){letter='5';}
		else if(letter=='T' || letter=='t'){letter='7';}
		else if(letter=='X' || letter=='x'){letter='%';}
		else if(letter=='Z' || letter=='z'){letter='2';}
    	
    	return letter;
    }
    
    
    private static JButton tyhudSpeak()
    {
    	JButton tyhudbtn = new JButton("Upside Down");
    	tyhudbtn.setMnemonic('t'); // Shortcut: Alt + T
    	tyhudbtn.setFont(new Font("Verdana", Font.PLAIN, 11));
    	tyhudbtn.setForeground(new Color(255, 255, 255));
    	tyhudbtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    	tyhudbtn.setBackground(new Color(38, 40, 44));
    	tyhudbtn.setBounds(446, 36, 100, 24);
        
    	tyhudbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                //action listener here     	
            	String reverse = new StringBuffer(output.getText()).reverse().toString();
            	output.setText( tyhudText(reverse) );
            }
        });
        
        return tyhudbtn;
    }    
    private static String tyhudText(String str)
    {
    	StringBuilder sb = new StringBuilder(str);

    	for(int i=0; i<sb.length(); i++)
    	{
    		// Every character of StringBuilder to a char variable.
    		char value = sb.charAt(i);
    		
    		if( (value>=' '&&value<='~') )
    		{
    			char newValue = tyhudList(value);
	    		
	    		// Set changed value.
	    		sb.setCharAt(i, newValue);
    		}
    		else
    		{
    			// Keep value.
    			sb.setCharAt(i, value);
    		}
    	}
    	
    	return sb.toString();
    }
    private static char tyhudList(char letter)
    {
		if(letter=='A'){letter='V';}
		else if(letter=='a'){letter='v';}
		else if(letter=='B'){letter='8';}
		else if(letter=='b'){letter='q';}
		else if(letter=='C'){letter=')';}
		else if(letter=='c'){letter='>';}
		else if(letter=='D'){letter='p';}
		else if(letter=='d'){letter='P';}
		else if(letter=='E' || letter=='e'){letter='3';}
		else if(letter=='F' || letter=='f'){letter='J';}
		else if(letter=='G'){letter='g';}
		else if(letter=='g'){letter='G';}
		else if(letter=='h'){letter='y';}
		else if(letter=='i'){letter='!';}
		else if(letter=='J' || letter=='j'){letter='r';}
		else if(letter=='L' || letter=='l'){letter='7';}
		else if(letter=='M'){letter='W';}
		else if(letter=='m'){letter='w';}
		else if(letter=='n'){letter='u';}
		else if(letter=='P' || letter=='p'){letter='d';}
		else if(letter=='q'){letter='b';}
		else if(letter=='r'){letter='J';}
		else if(letter=='T' || letter=='t'){letter='L';}
		else if(letter=='U' || letter=='u'){letter='n';}
		else if(letter=='V' || letter=='v'){letter='A';}
		else if(letter=='W'){letter='M';}
		else if(letter=='w'){letter='m';}
		else if(letter=='Y' || letter=='y'){letter='h';}
		
		else if(letter=='3'){letter='E';}
		else if(letter=='5'){letter='S';}
		else if(letter=='6'){letter='9';}
		else if(letter=='7'){letter='L';}
		else if(letter=='9'){letter='6';}
		
		else if(letter==','){letter='`';}
		else if(letter=='`'){letter=',';}
		else if(letter=='!'){letter='i';}
		else if(letter=='^'){letter='v';}

		else if(letter=='('){letter=')';}
		else if(letter==')'){letter='(';}
		else if(letter=='{'){letter='}';}
		else if(letter=='}'){letter='{';}
		else if(letter=='['){letter=']';}
		else if(letter==']'){letter='[';}
		else if(letter=='<'){letter='>';}
		else if(letter=='>'){letter='<';}
		
		else if(letter=='\"'){letter='.';}
		else if(letter=='.'){letter='\'';}
		else if(letter=='\''){letter='.';}
		else if(letter=='_'){letter='-';}
		
    	return letter;
    }
    
    
    
    
    private static JButton copySelectAll()
    {
    	JButton csab = new JButton("Copy Select All");
    	csab.setMnemonic('c'); // Shortcut: Alt + C
    	csab.setFont(new Font("Verdana", Font.PLAIN, 11));
    	csab.setForeground(new Color(255, 255, 255));
    	csab.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    	csab.setBackground(new Color(38, 40, 44));
    	csab.setBounds(550, 10, 100, 50);
        
    	csab.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                //action listener here     	
            	output.selectAll();
                output.copy();
            }
        });
        
        return csab;
    }
    
    private static JButton toCode()
    {
    	JButton enbutton = new JButton("Code On!");
    	enbutton.setMnemonic(KeyEvent.VK_ENTER); // Shortcut: Alt + Enter
    	enbutton.setFont(new Font("Verdana", Font.BOLD, 11));
    	enbutton.setForeground(new Color(255, 255, 255));
    	enbutton.setBorder(BorderFactory.createLineBorder(new Color(80, 255, 0)));
    	enbutton.setBackground(new Color(82, 104, 18));
    	enbutton.setBounds(656, 10, 100, 50);
        
    	enbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                //action listener here
            	output.setText(codeText( input.getText() ));
            }
        });
        
        return enbutton;
    }
    private static String codeText(String str)
    {
    	StringBuilder sb = new StringBuilder(str);

    	for(int i=0; i<sb.length(); i++)
    	{
    		// Coding. ASCII value changing.
    		char value = sb.charAt(i);
    		int nextValue = (int)value + level;
    		char enValue = (char)nextValue;
    		
    		// Set changed value.
    		sb.setCharAt(i, enValue);
    	}
    	
    	return sb.toString();
    }
    
    private static JButton closeButton(final JFrame jf)
    {
    	JButton xbtn = new JButton("X");
    	xbtn.setFont(new Font("Verdana", Font.PLAIN, 11));
    	xbtn.setForeground(new Color(255, 255, 255));
    	xbtn.setBorder(BorderFactory.createLineBorder(new Color(100, 0, 0)));
    	xbtn.setBackground(new Color(200, 0, 0));
    	xbtn.setBounds(761, 10, 24, 24);
        
    	xbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                // Close program frame.
            	jf.dispose();
            }
        });
        
        return xbtn;
    }
    
    private static JButton miniButton(final JFrame jf)
    {
    	JButton minbtn = new JButton("_");
    	minbtn.setFont(new Font("Verdana", Font.BOLD, 11));
    	minbtn.setForeground(new Color(255, 255, 255));
    	minbtn.setBorder(BorderFactory.createLineBorder(new Color(20, 20, 20)));
    	minbtn.setBackground(new Color(40, 40, 40));
    	minbtn.setBounds(761, 36, 24, 24);
        
    	minbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                // Minimize frame program.
            	jf.setState(Frame.ICONIFIED);
            }
        });
        
        return minbtn;
    }
    
    /*
     * Panel of the bottom side.
     * @param jf This uses the JFrame so MotionPanel can make undecorated frame move.
     */
    private static JPanel panelFooter(JFrame jf)
    {
    	JPanel panelfooter = new MotionPanel(jf);
    	panelfooter.setLayout(null);//(new GridBagLayout());//new FlowLayout());
    	panelfooter.setBounds(2,329, 790, 40);
    	panelfooter.setBorder(BorderFactory.createLineBorder(new Color(60, 65, 70)));
    	panelfooter.setBackground(new Color(60, 65, 70));
    	
    	// Options.
    	panelfooter.add(help());
    	panelfooter.add(labelLvl());
    	panelfooter.add(dropDownMenu());
    	panelfooter.add(swap());
    	panelfooter.add(reverseOpt());
    	panelfooter.add(saveToTxt());
    	panelfooter.add(clearText());
        
        return panelfooter;
    }
    
    private static JButton help()
    {
    	JButton testbutton = new JButton("?");
        testbutton.setMnemonic('h'); // Shortcut: Alt + H
        testbutton.setFont(new Font("Verdana", Font.PLAIN, 14));
        testbutton.setForeground(new Color(255, 255, 255));
        testbutton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        testbutton.setBackground(new Color(38, 40, 44));
        testbutton.setBounds(2, 2, 36, 36);
        
        testbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                //action listener here
            	input.setText
            	(
            		softwareName + "\n" +
            		"Author: Lord Rixuel\n"	+
            		"\nShortcuts:\n" +
            		" Alt+C - Copy Select All\n" +
            		" Alt+H - Open this Help message\n" +
            		" Alt+L - 1337 Speak\n" +
            		" Alt+R - Reverse!\n" +
            		" Alt+S - Swap textboxes\n" +
            		" Alt+T - TurnYourHeadUpsideDown Speak\n" +
            		" Alt+Enter - Code On!\n"
            	);
            	
            	output.setText
            	(
            		"Result will show up in this text box...\n" +
    				"\nHow to use Code Level?\n" +
            		" Unsoft to decode Soft message.\n" +
            		" Soft to decode Unsoft message.\n" +
            		" etc.\n"
            	);
            }
        });
        
        return testbutton;
    }
    
    private static JLabel labelLvl()
    {
    	JLabel lbl = new JLabel("Code Level:");
    	lbl.setFont(new Font("Consolas", Font.PLAIN, 12));
        lbl.setForeground(new Color(255, 255, 255));
        lbl.setBounds(50, 2, 120, 36);
        
        return lbl;
    }
    
    private static JComboBox<String> dropDownMenu()
    {
    	String[] choices = { 
    			"No Coding",
    			"Soft", 
    			"Strong",
    			"Extreme",
    			"Unsoft",
    			"Unstrong",
    			"Unextreme"
    			};
    	
        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setFont(new Font("Verdana", Font.PLAIN, 12));
        cb.setForeground(new Color(190, 255, 0));
        cb.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        cb.setBackground(new Color(38, 40, 44));
        cb.setBounds(160, 5, 120, 30);
        cb.setVisible(true);
        
        cb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
		        if(cb.getSelectedItem() == "No Coding")
		        {
		        	level = 0;
		        }
		        else if (cb.getSelectedItem() == "Soft")
		        {
		        	level = 1;
		        }
		        else if (cb.getSelectedItem() == "Unsoft")
		        {
		        	level = -1;
		        }
		        else if (cb.getSelectedItem() == "Strong")
		        {
		        	level = 8;
		        }
		        else if (cb.getSelectedItem() == "Unstrong")
		        {
		        	level = -8;
		        }
		        else if (cb.getSelectedItem() == "Extreme")
		        {
		        	level = 32;
		        }
		        else if (cb.getSelectedItem() == "Unextreme")
		        {
		        	level = -32;
		        }
		        else
		        {
		        	level = 0;
		        }
            }
        });
        
        return cb;
    }
    
    
    
    private static JButton swap()
    {
     	JButton swapbtn = new JButton("<=>");
     	swapbtn.setMnemonic('s'); // Shortcut: Alt + S
     	swapbtn.setFont(new Font("Verdana", Font.PLAIN, 11));
     	swapbtn.setForeground(new Color(255, 255, 255));
     	swapbtn.setBorder(BorderFactory.createLineBorder(new Color(0, 80, 255)));
     	swapbtn.setBackground(new Color(38, 40, 44));
     	swapbtn.setBounds(365, 2, 60, 36);
         
     	swapbtn.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e)
             {
                 //action listener here
            	 String temp1 = input.getText();
            	 String temp2 = output.getText();
            	 
            	 input.setText(temp2);
            	 output.setText(temp1);
             }
         });
         
         return swapbtn;
     }
    
    
	private static JButton reverseOpt()
	{
	 	JButton revbtn = new JButton("Reverse!");
	 	revbtn.setMnemonic('r'); // Shortcut: Alt + R
	 	revbtn.setFont(new Font("Verdana", Font.PLAIN, 11));
	 	revbtn.setForeground(new Color(255, 255, 255));
	 	revbtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	 	revbtn.setBackground(new Color(38, 40, 44));
	 	revbtn.setBounds(520, 2, 100, 36);
	     
	 	revbtn.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent e)
	         {
	        	 //action listener here
	        	 String reverse = new StringBuffer(output.getText()).reverse().toString();
	        	 output.setText(reverse);
	         }
	     });
	     
	     return revbtn;
	}


    private static JButton saveToTxt()
   	{
    	JButton savebtn = new JButton("Save to .txt File");
    	savebtn.setFont(new Font("Verdana", Font.PLAIN, 11));
    	savebtn.setForeground(new Color(255, 255, 255));
    	savebtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    	savebtn.setBackground(new Color(38, 40, 44));
    	savebtn.setBounds(624, 2, 100, 36);
        
    	savebtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                //action listener here
            	String fileStr = "codedText.txt";
            	
            	try 
            	{
            		JOptionPane.showMessageDialog(null, 
            			"\"" + fileStr + "\"" + 
            			" will be saved in the same directory as the program."
            			);
            		
            		// Write to a txt file.
            		String content = output.getText();
                    content = content.replaceAll("(?!\\r)\\n", "\r\n"); // For windows notepad.

                    PrintWriter out = new PrintWriter(fileStr);
                    out.println(content);
                    out.close();
            	}
            	catch (FileNotFoundException e1) 
            	{
            		e1.printStackTrace();
            		System.exit(1);
            	}

            }
        });
        
        return savebtn;
    }
    
    
    
    private static JButton clearText()
    {
    	JButton cbtn = new JButton("Clear");
    	cbtn.setFont(new Font("Arial", Font.PLAIN, 11));
    	cbtn.setForeground(new Color(255, 255, 255));
    	cbtn.setBorder(BorderFactory.createLineBorder(Color.RED));
    	cbtn.setBackground(new Color(44, 40, 38)); //244, 240, 238
    	cbtn.setBounds(728, 2, 60, 36);

    	cbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
            	//action listener here
            	input.setText("");
            	output.setText("");
            }
        });
        
        return cbtn;
    }
    
    
}



