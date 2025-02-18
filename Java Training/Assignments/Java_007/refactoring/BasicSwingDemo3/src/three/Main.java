package three;

//A simple Swing Program

import javax.swing.*;
public class Main {
	
	/*
	 * Replaced some of the functions with lambda blocks
	 */
	
	//this function sets the frame size
	static Center size = (JFrame frm, int width, int height) -> {
		// set the size of the frame to half in width and height
		frm.setSize(width/2, height/2);
		// here's the part where the JFrame gets actually centered
		frm.setLocationRelativeTo(null);
	};
	// this is how we can create a pseudo-dynamic array
	// at run time based on enums
	static Set frame = (JFrame frm) -> {
		int labelsEnumLength = LabelsEnum.values().length;
		int count = 0;
		JLabel myLabels[] = new JLabel[labelsEnumLength];
		MyLabel tempLabel;
		for(LabelsEnum le : LabelsEnum.values()) {
			tempLabel = new MyLabel();
			myLabels[count] = tempLabel.setLabel(le.get.function(), le.pos.function(), frm);
			count++;
		}
	};
	
	static Frame set = (JFrame frm, int onExit, int width, int height) -> {
		// this will center and size the JFrame on screen
		// it will have a height and width of half the screen
		size.function(frm, 400, 400);
		frm.setDefaultCloseOperation(onExit);
		frame.function(frm);
		return frm;
	};
	
	public static void main(String args[]) {

		SwingUtilities.invokeLater(new Runnable() {
			SwingDemo demo;
			JFrame frm;
			
			public void run() {
				demo = new SwingDemo("Centered JFrame 400 by 200 with 5 labels");
				frm = demo.get.function(); //lambda block replaces this function
				frm = set.function(frm, JFrame.EXIT_ON_CLOSE, 400, 200); //lambda block replaces this function
				frm.setVisible(true);
			}
		});
	}
}