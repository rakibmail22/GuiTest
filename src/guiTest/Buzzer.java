package guiTest;
 
/*
* KeyEventDemo
*/
 
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
 
public class Buzzer extends JFrame
        implements KeyListener,
        ActionListener
{
	static int [] check;
    JTextArea displayArea;
    JTextField typingArea;
    static final String newline = System.getProperty("line.separator");
     
   static void createAndShowGUI() {
	   check = new int[GuiTest.teamNumberValue];
        //Create and set up the window.
        Buzzer frame = new Buzzer("Buzzer");
        //frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Set up the content pane.
        frame.addComponentsToPane();
         
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    private void addComponentsToPane() {
         
        JButton button = new JButton("Clear");
        button.addActionListener(this);
         
        typingArea = new JTextField(20);
        typingArea.addKeyListener(this);
         
        //Uncomment this if you wish to turn off focus
        //traversal.  The focus subsystem consumes
        //focus traversal keys, such as Tab and Shift Tab.
        //If you uncomment the following line of code, this
        //disables focus traversal and the Tab events will
        //become available to the key event listener.
        //typingArea.setFocusTraversalKeysEnabled(false);
         
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setPreferredSize(new Dimension(375, 125));
         
        getContentPane().add(typingArea, BorderLayout.PAGE_START);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(button, BorderLayout.PAGE_END);
    }
     
    public Buzzer(String name) {
        super(name);
    }
     
     
    /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
    	
        displayInfo(e, "KEY TYPED: ");
    }
     
    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
      //  displayInfo(e, "KEY PRESSED: ");
    }
     
    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {
       // displayInfo(e, "KEY RELEASED: ");
    }
     
    /** Handle the button click. */
    public void actionPerformed(ActionEvent e) {
        //Clear the text components.
    	check = null;
    	check= new int[GuiTest.teamNumberValue];
        displayArea.setText("");
        typingArea.setText("");
         
        //Return the focus to the typing area.
        typingArea.requestFocusInWindow();
    }
    private static boolean alreadyPressed(char c){
    	if (check[c-'a']>=1)
    		return true;
    	return false;
    }
     
    /*
     * We have to jump through some hoops to avoid
     * trying to print non-printing characters
     * such as Shift.  (Not only do they not print,
     * but if you put them in a String, the characters
     * afterward won't show up in the text area.)
     */
    private void displayInfo(KeyEvent e, String keyStatus){
         
        //You should only rely on the key char if the event
        //is a key typed event.
    	
        int id = e.getID();
        String keyString;
        char c = e.getKeyChar();
        if (alreadyPressed(c)){
        	return;
        }
        
        check[c-'a']++;
        keyString = Character.toString(c);
        
         
       
       
         
       
         
        displayArea.append(keyString +newline);
        displayArea.setCaretPosition(displayArea.getDocument().getLength());
    }
}