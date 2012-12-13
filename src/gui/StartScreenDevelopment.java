package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class StartScreenDevelopment implements ActionListener {

	private JFrame frame;
	private Object selected1;
	private Object selected2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreenDevelopment window = new StartScreenDevelopment();
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
	public StartScreenDevelopment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblVs = new JLabel("VS");
		lblVs.setBounds(210, 106, 29, 25);
		frame.getContentPane().add(lblVs);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setActionCommand("Submit");
		btnNewButton.setBounds(161, 198, 112, 23);
		btnNewButton.addActionListener(this);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Checkers");
		lblNewLabel.setBounds(192, 32, 81, 25);
		frame.getContentPane().add(lblNewLabel);

		JList<String> list_1 = new JList<String>();
		list_1.setModel(new AbstractListModel<String>() {
			String[] values = new String[] { "Hal", "Derpy", "Octo", "Bobby" };

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setBounds(273, 78, 89, 75);

		frame.getContentPane().add(list_1);

		JList<String> list = new JList<String>();
		list.setModel(new AbstractListModel<String>() {
			String[] values = new String[] { "Hal", "Derpy", "Octo", "Bobby" };

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(72, 78, 89, 75);
		frame.getContentPane().add(list);
		selected1 = list_1.getSelectedValue();
		selected2 = list.getSelectedValue();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Submit".equals(e.getActionCommand())) {
			if (selected1 != null && selected2 != null) {

			}
		}
	}
}