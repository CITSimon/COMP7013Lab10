package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.IWorldCupGUI;
import controller.WorldCupController;
import model.Player;
import model.Striker;

public class WorldCupFrame extends JFrame implements IWorldCupGUI
{
	//The "scope" of this variable is the entire
	//class. So other methods and inner classes can see it.
	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;
	private JButton okButton;
	private JButton cancelButton;
	private JButton saveButton;
	private JTable playerTable;
	private WorldCupTableModel tableModel;
	
	public WorldCupFrame(String title)
	{
		super(title);
		//This is what we are going to use as the 
		//content of our JFrame
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		//Call to method to create side panel
		JPanel sidePanel = createSideButtonPanel();		
		mainPanel.add(sidePanel, BorderLayout.EAST);

		//Call to method to create bottom panel
		JPanel bottomPanel = createBottomButtonPanel();
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		//Call to method to create table scroll pane
		JScrollPane tableScrollPane = createTableScrollPane();
		mainPanel.add(tableScrollPane, BorderLayout.CENTER);
		
		getContentPane().add(mainPanel);
	}
	
	public void refreshGUI()
	{
		//This "wakes up" the table model and tells it
		//that the data model it is connected to has changed.
		this.tableModel.fireTableDataChanged();
	}
	
	private JScrollPane createTableScrollPane()
	{
		playerTable = new JTable();
				
		//In future weeks we'll have a call to the 
		//controller here to get us the list of players which
		//it manages as data model objects
		tableModel = 
				new WorldCupTableModel(WorldCupController.getInstance().getDataModel().getPlayers());
		
		playerTable.setModel(tableModel);
		
		JScrollPane tableScrollPane = new JScrollPane(playerTable);
		//Can also be done this way
		//JScrollPane tableScrollPane = new JScrollPane();
		//tableScrollPane.add(playerTable)
		return tableScrollPane;
	}
	
	private JPanel createBottomButtonPanel()
	{
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		saveButton = new JButton("Save");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		buttonPanel.add(saveButton);
		
		saveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				WorldCupController.getInstance().save();
				JOptionPane.showMessageDialog(WorldCupFrame.this, "Country players saved");
			}
		});
		
		return buttonPanel;
	}
	
	private JPanel createSideButtonPanel()
	{
		addButton = new JButton("Add");
		editButton = new JButton("Edit");
		deleteButton = new JButton("Delete");
		
		//Create an instance of inner class
		//SideButtonsActionListener
		//When we create an instance of the inner class we pass
		//it a reference to its containing class.
		ButtonsActionListener buttonListener = 
				new ButtonsActionListener(this);
		
		addButton.addActionListener(buttonListener);
		editButton.addActionListener(buttonListener);
		deleteButton.addActionListener(buttonListener);
		
		JPanel sideButtonPanel = new JPanel();
		
		BoxLayout boxL = new BoxLayout(sideButtonPanel, BoxLayout.Y_AXIS);
		sideButtonPanel.setLayout(boxL);

// Can also be written like this in one line.
//		sideButtonPanel.setLayout(
//		new BoxLayout(sideButtonPanel, BoxLayout.X_AXIS));
		sideButtonPanel.add(addButton);
		sideButtonPanel.add(Box.createVerticalStrut(5));
		sideButtonPanel.add(editButton);
		sideButtonPanel.add(Box.createVerticalStrut(5));
		sideButtonPanel.add(deleteButton);
		
		return sideButtonPanel;
	}
	
	//Inner class implementation of ActionListener
	private class ButtonsActionListener implements ActionListener
	{
		//This is to allow this inner class to refer to its 
		//containing class (i.e. WorldCupFrame)
		private WorldCupFrame outerClass;
		
		public ButtonsActionListener(WorldCupFrame outerClass)
		{
			this.outerClass = outerClass;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			//We know that the source of any ActionEvent
			//in this program MUST be a JButton seeing as
			//we only added an instance of this listener to 
			//JButtons
			JButton sourceButton = (JButton)e.getSource();
			if(sourceButton.equals(addButton))
			{				
				PlayerType [] types = 
					{PlayerType.STRIKER, PlayerType.GOALKEEPER};
				
				//We supply in a list of PlayerType objects 
				//These will be displayed in a combo box in the 
				//JOptionPane dialog. Whichever one is chosen by 
				//the user before they click OK will be returned after OK is clicked.
				//showInputDialog method returns type Object. Because
				//we know PlayerType objects are all that went in 
				//as choices, then the selected choice must be a PlayerType.
				//Therefore we can cast the returned object to a PlayerType.
				
				PlayerType chosenPlayerType =   
						(PlayerType)
						JOptionPane.showInputDialog(
						outerClass,
						"Choose player type :",
						"Add A Player",
						JOptionPane.QUESTION_MESSAGE,
						null,
						types,
						types[0]);
				
						AddPlayerDialog addPlyrDlg = 
								new AddPlayerDialog(this.outerClass, "Add Player", chosenPlayerType);
						addPlyrDlg.setSize(500, 300);
						addPlyrDlg.setVisible(true);

			}
				
		
			else if(sourceButton.equals(editButton))
			{
				System.out.println("Edit button clicked");
			}
			//This is the code which responds to the delete button
			else 
			{
				//Check if row is selected
				if(playerTable.getSelectedRow() == -1)
				{
					JOptionPane.showMessageDialog
							(outerClass, 
							 "You need to select a row in the table", 
							 "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String message = "Are you sure you want to delete this player ?";
					int answer = 
							JOptionPane.showConfirmDialog(outerClass, message);
					if(answer == JOptionPane.YES_OPTION)
					{
						
					}
					else if (answer == JOptionPane.NO_OPTION)
					{
						
					}
					else
					{
						
					}
				}
			}
				
		}
	}
	
}
