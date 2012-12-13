package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class IntegratedGUI {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntegratedGUI window = new IntegratedGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IntegratedGUI() {

	}

}
