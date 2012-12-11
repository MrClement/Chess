package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;

public class BoardGUIDevelopment {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardGUIDevelopment window = new BoardGUIDevelopment();
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
	public BoardGUIDevelopment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout steven = new GridLayout(8,8);
		
		
		
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
	}

}
