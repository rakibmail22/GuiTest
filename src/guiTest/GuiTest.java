package guiTest;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiTest {
	private JButton teamNumberEnterButton, teamNameEnterButton;
	private JTextField teamNumberField;
	private JLabel teamNumberLabel;
	private JTextField[] teamNameField;
	private JLabel[] teamMessageLabel;
	private JPanel[] teamNamePanel;
	private JPanel teamsPanel;
	private JPanel teamNumberPanel;
	public static int teamNumberValue;
	static JFrame frame;
	
	public void addComponentsToFrame(Container frame){
		frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
		processTeamNumberPanels();
		frame.add(teamNumberPanel);
		
	}
	private void processTeamNumberPanels(){
		teamNumberPanel = new JPanel();
		teamNumberField = new JTextField(2);
		teamNumberLabel = new JLabel("Enter Team Number ");
		teamNumberEnterButton  = new JButton("Enter");
		teamNumberPanel.add(teamNumberLabel);
		teamNumberPanel.add(teamNumberField);
		teamNumberPanel.add(teamNumberEnterButton);
		teamNumberEnterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamNumberEnterButtonActionPerformed(evt);
            }
        });
		
		
	}
	private void teamNumberEnterButtonActionPerformed(java.awt.event.ActionEvent evt){
		teamNumberValue = Integer.parseInt(teamNumberField.getText());
		frame.dispose();
		TeamInfoFrame.createAndShowGUI(new TeamInfoFrame());
	}

	private void processTeamNamePanels() {
		teamsPanel = new JPanel();
		teamNamePanel = new JPanel[teamNumberValue];
		teamMessageLabel = new JLabel[teamNumberValue];
		teamNameField = new JTextField[teamNumberValue];
		teamNameEnterButton = new JButton("Done");
		teamsPanel.setLayout(new BoxLayout(teamsPanel, BoxLayout.Y_AXIS));
		
		for (int i=0; i<teamNamePanel.length; ++i){
			//teamNamePanel[i].setLayout(new FlowLayout());
			teamNamePanel[i]= new JPanel();
			teamMessageLabel[i] =  new JLabel("Enter Team "+ (i+1));
			teamNameField[i] = new JTextField(5);
			teamNamePanel[i].add(teamMessageLabel[i]);
			teamNamePanel[i].add(teamNameField[i]);
			teamsPanel.add(teamNamePanel[i]);
		}
		//teamNameEnterButton.setPreferredSize(new Dimension(40, 40));
		teamsPanel.add(teamNameEnterButton);
		//teamsPanel.setVisible(false);
		
	}

	
	
	public static void createAndShowGUI(GuiTest test) {
		frame = new JFrame("Team Information");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.addComponentsToFrame(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				createAndShowGUI(new GuiTest());
			}
			
		});
	}
	
}