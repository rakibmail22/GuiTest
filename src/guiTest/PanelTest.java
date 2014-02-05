package guiTest;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelTest {
	JFrame frame;
	JPanel panel1, panel2;
	JButton button1, button2;
	JTextField one, two[];
	int number;
	public PanelTest(){
		frame = new JFrame();
		panel1= new JPanel();
		panel2 = new JPanel();
		button1 = new JButton("1");
		button2 = new JButton("2");
		one = new JTextField(2);
	}
	public void workPanel1(){
		panel1.add(button1);
		panel1.add(one);
		frame.add(panel1);
		frame.setVisible(true);
		frame.pack();
		button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ButtonActionPerformed(evt);
            }
        });
		
	}
	public void button1ButtonActionPerformed(java.awt.event.ActionEvent evt){
		number = Integer.parseInt(one.getText());
		panel1.setVisible(false);
		panel1.removeAll();
		two = new JTextField[number];
		for (int i=0; i<two.length; ++i){
			two[i]= new JTextField(2);
			panel1.add(two[i]);
		}
		panel1.add(button2);
		panel1.setVisible(true);
		frame.pack();
	}
	public static void createAndShowGUI(PanelTest p ){
		p.workPanel1();
		
	}
	
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createAndShowGUI(new PanelTest());
			}
			
		});
	}

}
