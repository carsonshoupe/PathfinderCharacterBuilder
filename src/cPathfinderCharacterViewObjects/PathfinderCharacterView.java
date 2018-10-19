package cPathfinderCharacterViewObjects;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import cPathfinderCharacterObjects.PathfinderCharacter;

public class PathfinderCharacterView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PathfinderCharacterView window = new PathfinderCharacterView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PathfinderCharacterView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PathfinderCharacter jim = new PathfinderCharacter(); 
		jim.setCharacterName("jim");
		
		JLabel lblPathfinderCharacter = new JLabel("Pathfinder Character" + " -- " + jim.getCharacterName());
		lblPathfinderCharacter.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblPathfinderCharacter, BorderLayout.NORTH);
	}

}
