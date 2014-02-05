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

public class TeamInfoFrame {
	private JButton teamNameEnterButton;
	private JTextField[] teamNameField;
	private JLabel[] teamMessageLabel;
	private JPanel[] teamNamePanel;
	private JPanel teamsPanel;
	private static int teamNumberValue;
	private static JFrame frame;
	static String team [];
	
	
	public void addComponentsToFrame(Container frame){
		frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
		processTeamNamePanels();
		frame.add(teamsPanel);
		
	}

	private void processTeamNamePanels() {
		teamNumberValue = GuiTest.teamNumberValue;
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
		teamsPanel.add(teamNameEnterButton);
		teamNameEnterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	teamNameEnterButtonActionPerformed(evt);
            }
        });
		
	}
	
	private void teamNameEnterButtonActionPerformed(java.awt.event.ActionEvent evt){
		team = new String[teamNumberValue];
		
		for (int i=0; i<teamNumberValue; ++i){
			team[i]= teamNameField[i].getText();
		}
		DataList data = new DataList(teamNumberValue, team);
		frame.dispose();
		Buzzer.createAndShowGUI();
	}

	
	
	public static void createAndShowGUI(TeamInfoFrame test) {
		frame = new JFrame("Team Information");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.addComponentsToFrame(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
	
}