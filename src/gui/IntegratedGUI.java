package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import sharedfiles.Board;
import sharedfiles.Piece;

import communicator.AIServerInstance;

public class IntegratedGUI {

	private JFrame frame;
	private String selected1;
	private String selected2;
	private String[][] pieces;
	private JList<String> list_1;
	private JList<String> list;
	private AIServerInstance server;

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
		frame = new JFrame();
		frame.setSize(425, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		initialize();

	}

	private void initialize() {
		frame.getContentPane().setLayout(null);

		JLabel lblVs = new JLabel("VS");
		lblVs.setBounds(210, 106, 29, 25);
		frame.getContentPane().add(lblVs);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setActionCommand("Submit");
		btnNewButton.setBounds(161, 198, 112, 23);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selected1 = list_1.getSelectedValue();
				selected2 = list.getSelectedValue();
				frame.getContentPane().removeAll();
				Board b = new Board();
				server = new AIServerInstance(b);
				Thread t = new Thread(server);
				t.start();
				while (t.isAlive()) {
					initializeBoard(b);
					frame.getContentPane().validate();
					frame.getContentPane().repaint();
				}

			}
		});
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Checkers");
		lblNewLabel.setBounds(192, 32, 81, 25);
		frame.getContentPane().add(lblNewLabel);

		list_1 = new JList<String>();
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

		list = new JList<String>();
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

	private void readBoard(Board board) {
		Piece[][] temp = board.getBoardArray();
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				pieces[i][j] = temp[i][j].toString();
			}
		}
	}

	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL url = getClass().getResource(path);
		if (url != null) {
			return new ImageIcon(url, description);
		} else {
			System.err.println("DERPYFILE COULDN'T BE LOCATED: " + path);
			return null;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initializeBoard(Board b) {
		// b.randomize();
		readBoard(b);

		int i = 8;
		int j = 8;

		GridLayout steven = new GridLayout(i, j);
		steven.setHgap(2);
		steven.setVgap(2);

		JPanel[][] panelHolder = new JPanel[i][j];
		frame.setLayout(steven);

		for (int m = 0; m < i; m++) {
			for (int n = 0; n < j; n++) {
				panelHolder[m][n] = new JPanel();
				panelHolder[m][n].setSize(60, 60);
				if ((n % 2 + m % 2) % 2 == 0)
					panelHolder[m][n].setBackground(Color.WHITE);
				else
					panelHolder[m][n].setBackground(Color.GRAY);
				frame.add(panelHolder[m][n]);
			}
		}

		for (int m = 0; m < i; m++) {
			for (int n = 0; n < j; n++) {

				String pieceType = pieces[n][m];
				String tempResourceName = "" + Character.toLowerCase(pieceType.charAt(0));
				switch (pieceType.charAt(1)) {
					case 'X':
						tempResourceName = "Blank";
						break;
					case 'B':
						tempResourceName = tempResourceName.concat("Bishop");
						break;
					case 'R':
						tempResourceName = tempResourceName.concat("Rook");
						break;
					case 'P':
						tempResourceName = tempResourceName.concat("Pawn");
						break;
					case 'Q':
						tempResourceName = tempResourceName.concat("Queen");
						break;
					case 'K':
						tempResourceName = tempResourceName.concat("King");
						break;
					case 'N':
						tempResourceName = tempResourceName.concat("Knight");
						break;
					default:
						System.out.println("Reached default case in piece string array of BoardGUIDevelopment");
						System.out.println("Exiting");
						System.exit(1);
						break;
				}

				tempResourceName = tempResourceName.concat(".png");

				ImageIcon icon = createImageIcon(tempResourceName, "Derpy Spot");

				JLabel label = new JLabel();
				label.setIcon(icon);
				panelHolder[m][n].add(label);
			}
		}

		frame.getContentPane().setLayout(steven);
	}

}
