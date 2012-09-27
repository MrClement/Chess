package communicator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AIManager {

	private JFrame frmAiChessSimulation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AIManager window = new AIManager();
					window.frmAiChessSimulation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AIManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAiChessSimulation = new JFrame();
		frmAiChessSimulation.setTitle("AI Chess Simulation Board - listening on 0.0.0.0");
		frmAiChessSimulation.setBounds(100, 100, 635, 400);
		frmAiChessSimulation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 59, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmAiChessSimulation.getContentPane().setLayout(gridBagLayout);
		
		JButton button = new JButton("0");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 1;
		frmAiChessSimulation.getContentPane().add(button, gbc_button);
		
		JButton button_1 = new JButton("0");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 2;
		gbc_button_1.gridy = 1;
		frmAiChessSimulation.getContentPane().add(button_1, gbc_button_1);
		
		JButton button_2 = new JButton("0");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 3;
		gbc_button_2.gridy = 1;
		frmAiChessSimulation.getContentPane().add(button_2, gbc_button_2);
		
		JButton button_3 = new JButton("0");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 4;
		gbc_button_3.gridy = 1;
		frmAiChessSimulation.getContentPane().add(button_3, gbc_button_3);
		
		JButton button_4 = new JButton("0");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 5;
		gbc_button_4.gridy = 1;
		frmAiChessSimulation.getContentPane().add(button_4, gbc_button_4);
		
		JButton button_5 = new JButton("0");
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 6;
		gbc_button_5.gridy = 1;
		frmAiChessSimulation.getContentPane().add(button_5, gbc_button_5);
		
		JButton button_6 = new JButton("0");
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 7;
		gbc_button_6.gridy = 1;
		frmAiChessSimulation.getContentPane().add(button_6, gbc_button_6);
		
		JButton button_7 = new JButton("0");
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.insets = new Insets(0, 0, 5, 0);
		gbc_button_7.gridx = 8;
		gbc_button_7.gridy = 1;
		frmAiChessSimulation.getContentPane().add(button_7, gbc_button_7);
		
		JButton button_8 = new JButton("0");
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.insets = new Insets(0, 0, 5, 5);
		gbc_button_8.gridx = 1;
		gbc_button_8.gridy = 2;
		frmAiChessSimulation.getContentPane().add(button_8, gbc_button_8);
		
		JButton button_14 = new JButton("0");
		GridBagConstraints gbc_button_14 = new GridBagConstraints();
		gbc_button_14.insets = new Insets(0, 0, 5, 5);
		gbc_button_14.gridx = 2;
		gbc_button_14.gridy = 2;
		frmAiChessSimulation.getContentPane().add(button_14, gbc_button_14);
		
		JButton button_20 = new JButton("0");
		GridBagConstraints gbc_button_20 = new GridBagConstraints();
		gbc_button_20.insets = new Insets(0, 0, 5, 5);
		gbc_button_20.gridx = 3;
		gbc_button_20.gridy = 2;
		frmAiChessSimulation.getContentPane().add(button_20, gbc_button_20);
		
		JButton button_26 = new JButton("0");
		GridBagConstraints gbc_button_26 = new GridBagConstraints();
		gbc_button_26.insets = new Insets(0, 0, 5, 5);
		gbc_button_26.gridx = 4;
		gbc_button_26.gridy = 2;
		frmAiChessSimulation.getContentPane().add(button_26, gbc_button_26);
		
		JButton button_32 = new JButton("0");
		GridBagConstraints gbc_button_32 = new GridBagConstraints();
		gbc_button_32.insets = new Insets(0, 0, 5, 5);
		gbc_button_32.gridx = 5;
		gbc_button_32.gridy = 2;
		frmAiChessSimulation.getContentPane().add(button_32, gbc_button_32);
		
		JButton button_38 = new JButton("0");
		GridBagConstraints gbc_button_38 = new GridBagConstraints();
		gbc_button_38.insets = new Insets(0, 0, 5, 5);
		gbc_button_38.gridx = 6;
		gbc_button_38.gridy = 2;
		frmAiChessSimulation.getContentPane().add(button_38, gbc_button_38);
		
		JButton button_44 = new JButton("0");
		GridBagConstraints gbc_button_44 = new GridBagConstraints();
		gbc_button_44.insets = new Insets(0, 0, 5, 5);
		gbc_button_44.gridx = 7;
		gbc_button_44.gridy = 2;
		frmAiChessSimulation.getContentPane().add(button_44, gbc_button_44);
		
		JButton button_50 = new JButton("0");
		GridBagConstraints gbc_button_50 = new GridBagConstraints();
		gbc_button_50.insets = new Insets(0, 0, 5, 0);
		gbc_button_50.gridx = 8;
		gbc_button_50.gridy = 2;
		frmAiChessSimulation.getContentPane().add(button_50, gbc_button_50);
		
		JButton button_9 = new JButton("0");
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.insets = new Insets(0, 0, 5, 5);
		gbc_button_9.gridx = 1;
		gbc_button_9.gridy = 3;
		frmAiChessSimulation.getContentPane().add(button_9, gbc_button_9);
		
		JButton button_15 = new JButton("0");
		GridBagConstraints gbc_button_15 = new GridBagConstraints();
		gbc_button_15.insets = new Insets(0, 0, 5, 5);
		gbc_button_15.gridx = 2;
		gbc_button_15.gridy = 3;
		frmAiChessSimulation.getContentPane().add(button_15, gbc_button_15);
		
		JButton button_21 = new JButton("0");
		GridBagConstraints gbc_button_21 = new GridBagConstraints();
		gbc_button_21.insets = new Insets(0, 0, 5, 5);
		gbc_button_21.gridx = 3;
		gbc_button_21.gridy = 3;
		frmAiChessSimulation.getContentPane().add(button_21, gbc_button_21);
		
		JButton button_27 = new JButton("0");
		GridBagConstraints gbc_button_27 = new GridBagConstraints();
		gbc_button_27.insets = new Insets(0, 0, 5, 5);
		gbc_button_27.gridx = 4;
		gbc_button_27.gridy = 3;
		frmAiChessSimulation.getContentPane().add(button_27, gbc_button_27);
		
		JButton button_33 = new JButton("0");
		GridBagConstraints gbc_button_33 = new GridBagConstraints();
		gbc_button_33.insets = new Insets(0, 0, 5, 5);
		gbc_button_33.gridx = 5;
		gbc_button_33.gridy = 3;
		frmAiChessSimulation.getContentPane().add(button_33, gbc_button_33);
		
		JButton button_39 = new JButton("0");
		GridBagConstraints gbc_button_39 = new GridBagConstraints();
		gbc_button_39.insets = new Insets(0, 0, 5, 5);
		gbc_button_39.gridx = 6;
		gbc_button_39.gridy = 3;
		frmAiChessSimulation.getContentPane().add(button_39, gbc_button_39);
		
		JButton button_45 = new JButton("0");
		GridBagConstraints gbc_button_45 = new GridBagConstraints();
		gbc_button_45.insets = new Insets(0, 0, 5, 5);
		gbc_button_45.gridx = 7;
		gbc_button_45.gridy = 3;
		frmAiChessSimulation.getContentPane().add(button_45, gbc_button_45);
		
		JButton button_51 = new JButton("0");
		GridBagConstraints gbc_button_51 = new GridBagConstraints();
		gbc_button_51.insets = new Insets(0, 0, 5, 0);
		gbc_button_51.gridx = 8;
		gbc_button_51.gridy = 3;
		frmAiChessSimulation.getContentPane().add(button_51, gbc_button_51);
		
		JButton button_10 = new JButton("0");
		GridBagConstraints gbc_button_10 = new GridBagConstraints();
		gbc_button_10.insets = new Insets(0, 0, 5, 5);
		gbc_button_10.gridx = 1;
		gbc_button_10.gridy = 4;
		frmAiChessSimulation.getContentPane().add(button_10, gbc_button_10);
		
		JButton button_16 = new JButton("0");
		GridBagConstraints gbc_button_16 = new GridBagConstraints();
		gbc_button_16.insets = new Insets(0, 0, 5, 5);
		gbc_button_16.gridx = 2;
		gbc_button_16.gridy = 4;
		frmAiChessSimulation.getContentPane().add(button_16, gbc_button_16);
		
		JButton button_22 = new JButton("0");
		GridBagConstraints gbc_button_22 = new GridBagConstraints();
		gbc_button_22.insets = new Insets(0, 0, 5, 5);
		gbc_button_22.gridx = 3;
		gbc_button_22.gridy = 4;
		frmAiChessSimulation.getContentPane().add(button_22, gbc_button_22);
		
		JButton button_28 = new JButton("0");
		GridBagConstraints gbc_button_28 = new GridBagConstraints();
		gbc_button_28.insets = new Insets(0, 0, 5, 5);
		gbc_button_28.gridx = 4;
		gbc_button_28.gridy = 4;
		frmAiChessSimulation.getContentPane().add(button_28, gbc_button_28);
		
		JButton button_34 = new JButton("0");
		GridBagConstraints gbc_button_34 = new GridBagConstraints();
		gbc_button_34.insets = new Insets(0, 0, 5, 5);
		gbc_button_34.gridx = 5;
		gbc_button_34.gridy = 4;
		frmAiChessSimulation.getContentPane().add(button_34, gbc_button_34);
		
		JButton button_40 = new JButton("0");
		GridBagConstraints gbc_button_40 = new GridBagConstraints();
		gbc_button_40.insets = new Insets(0, 0, 5, 5);
		gbc_button_40.gridx = 6;
		gbc_button_40.gridy = 4;
		frmAiChessSimulation.getContentPane().add(button_40, gbc_button_40);
		
		JButton button_46 = new JButton("0");
		GridBagConstraints gbc_button_46 = new GridBagConstraints();
		gbc_button_46.insets = new Insets(0, 0, 5, 5);
		gbc_button_46.gridx = 7;
		gbc_button_46.gridy = 4;
		frmAiChessSimulation.getContentPane().add(button_46, gbc_button_46);
		
		JButton button_52 = new JButton("0");
		GridBagConstraints gbc_button_52 = new GridBagConstraints();
		gbc_button_52.insets = new Insets(0, 0, 5, 0);
		gbc_button_52.gridx = 8;
		gbc_button_52.gridy = 4;
		frmAiChessSimulation.getContentPane().add(button_52, gbc_button_52);
		
		JButton button_11 = new JButton("0");
		GridBagConstraints gbc_button_11 = new GridBagConstraints();
		gbc_button_11.insets = new Insets(0, 0, 5, 5);
		gbc_button_11.gridx = 1;
		gbc_button_11.gridy = 5;
		frmAiChessSimulation.getContentPane().add(button_11, gbc_button_11);
		
		JButton button_17 = new JButton("0");
		GridBagConstraints gbc_button_17 = new GridBagConstraints();
		gbc_button_17.insets = new Insets(0, 0, 5, 5);
		gbc_button_17.gridx = 2;
		gbc_button_17.gridy = 5;
		frmAiChessSimulation.getContentPane().add(button_17, gbc_button_17);
		
		JButton button_23 = new JButton("0");
		GridBagConstraints gbc_button_23 = new GridBagConstraints();
		gbc_button_23.insets = new Insets(0, 0, 5, 5);
		gbc_button_23.gridx = 3;
		gbc_button_23.gridy = 5;
		frmAiChessSimulation.getContentPane().add(button_23, gbc_button_23);
		
		JButton button_29 = new JButton("0");
		GridBagConstraints gbc_button_29 = new GridBagConstraints();
		gbc_button_29.insets = new Insets(0, 0, 5, 5);
		gbc_button_29.gridx = 4;
		gbc_button_29.gridy = 5;
		frmAiChessSimulation.getContentPane().add(button_29, gbc_button_29);
		
		JButton button_35 = new JButton("0");
		GridBagConstraints gbc_button_35 = new GridBagConstraints();
		gbc_button_35.insets = new Insets(0, 0, 5, 5);
		gbc_button_35.gridx = 5;
		gbc_button_35.gridy = 5;
		frmAiChessSimulation.getContentPane().add(button_35, gbc_button_35);
		
		JButton button_41 = new JButton("0");
		GridBagConstraints gbc_button_41 = new GridBagConstraints();
		gbc_button_41.insets = new Insets(0, 0, 5, 5);
		gbc_button_41.gridx = 6;
		gbc_button_41.gridy = 5;
		frmAiChessSimulation.getContentPane().add(button_41, gbc_button_41);
		
		JButton button_47 = new JButton("0");
		GridBagConstraints gbc_button_47 = new GridBagConstraints();
		gbc_button_47.insets = new Insets(0, 0, 5, 5);
		gbc_button_47.gridx = 7;
		gbc_button_47.gridy = 5;
		frmAiChessSimulation.getContentPane().add(button_47, gbc_button_47);
		
		JButton button_53 = new JButton("0");
		GridBagConstraints gbc_button_53 = new GridBagConstraints();
		gbc_button_53.insets = new Insets(0, 0, 5, 0);
		gbc_button_53.gridx = 8;
		gbc_button_53.gridy = 5;
		frmAiChessSimulation.getContentPane().add(button_53, gbc_button_53);
		
		JButton button_12 = new JButton("0");
		GridBagConstraints gbc_button_12 = new GridBagConstraints();
		gbc_button_12.insets = new Insets(0, 0, 5, 5);
		gbc_button_12.gridx = 1;
		gbc_button_12.gridy = 6;
		frmAiChessSimulation.getContentPane().add(button_12, gbc_button_12);
		
		JButton button_18 = new JButton("0");
		GridBagConstraints gbc_button_18 = new GridBagConstraints();
		gbc_button_18.insets = new Insets(0, 0, 5, 5);
		gbc_button_18.gridx = 2;
		gbc_button_18.gridy = 6;
		frmAiChessSimulation.getContentPane().add(button_18, gbc_button_18);
		
		JButton button_24 = new JButton("0");
		GridBagConstraints gbc_button_24 = new GridBagConstraints();
		gbc_button_24.insets = new Insets(0, 0, 5, 5);
		gbc_button_24.gridx = 3;
		gbc_button_24.gridy = 6;
		frmAiChessSimulation.getContentPane().add(button_24, gbc_button_24);
		
		JButton button_30 = new JButton("0");
		GridBagConstraints gbc_button_30 = new GridBagConstraints();
		gbc_button_30.insets = new Insets(0, 0, 5, 5);
		gbc_button_30.gridx = 4;
		gbc_button_30.gridy = 6;
		frmAiChessSimulation.getContentPane().add(button_30, gbc_button_30);
		
		JButton button_36 = new JButton("0");
		GridBagConstraints gbc_button_36 = new GridBagConstraints();
		gbc_button_36.insets = new Insets(0, 0, 5, 5);
		gbc_button_36.gridx = 5;
		gbc_button_36.gridy = 6;
		frmAiChessSimulation.getContentPane().add(button_36, gbc_button_36);
		
		JButton button_42 = new JButton("0");
		GridBagConstraints gbc_button_42 = new GridBagConstraints();
		gbc_button_42.insets = new Insets(0, 0, 5, 5);
		gbc_button_42.gridx = 6;
		gbc_button_42.gridy = 6;
		frmAiChessSimulation.getContentPane().add(button_42, gbc_button_42);
		
		JButton button_48 = new JButton("0");
		GridBagConstraints gbc_button_48 = new GridBagConstraints();
		gbc_button_48.insets = new Insets(0, 0, 5, 5);
		gbc_button_48.gridx = 7;
		gbc_button_48.gridy = 6;
		frmAiChessSimulation.getContentPane().add(button_48, gbc_button_48);
		
		JButton button_54 = new JButton("0");
		GridBagConstraints gbc_button_54 = new GridBagConstraints();
		gbc_button_54.insets = new Insets(0, 0, 5, 0);
		gbc_button_54.gridx = 8;
		gbc_button_54.gridy = 6;
		frmAiChessSimulation.getContentPane().add(button_54, gbc_button_54);
		
		JButton button_13 = new JButton("0");
		GridBagConstraints gbc_button_13 = new GridBagConstraints();
		gbc_button_13.insets = new Insets(0, 0, 5, 5);
		gbc_button_13.gridx = 1;
		gbc_button_13.gridy = 7;
		frmAiChessSimulation.getContentPane().add(button_13, gbc_button_13);
		
		JButton button_19 = new JButton("0");
		GridBagConstraints gbc_button_19 = new GridBagConstraints();
		gbc_button_19.insets = new Insets(0, 0, 5, 5);
		gbc_button_19.gridx = 2;
		gbc_button_19.gridy = 7;
		frmAiChessSimulation.getContentPane().add(button_19, gbc_button_19);
		
		JButton button_25 = new JButton("0");
		GridBagConstraints gbc_button_25 = new GridBagConstraints();
		gbc_button_25.insets = new Insets(0, 0, 5, 5);
		gbc_button_25.gridx = 3;
		gbc_button_25.gridy = 7;
		frmAiChessSimulation.getContentPane().add(button_25, gbc_button_25);
		
		JButton button_31 = new JButton("0");
		GridBagConstraints gbc_button_31 = new GridBagConstraints();
		gbc_button_31.insets = new Insets(0, 0, 5, 5);
		gbc_button_31.gridx = 4;
		gbc_button_31.gridy = 7;
		frmAiChessSimulation.getContentPane().add(button_31, gbc_button_31);
		
		JButton button_37 = new JButton("0");
		GridBagConstraints gbc_button_37 = new GridBagConstraints();
		gbc_button_37.insets = new Insets(0, 0, 5, 5);
		gbc_button_37.gridx = 5;
		gbc_button_37.gridy = 7;
		frmAiChessSimulation.getContentPane().add(button_37, gbc_button_37);
		
		JButton button_43 = new JButton("0");
		GridBagConstraints gbc_button_43 = new GridBagConstraints();
		gbc_button_43.insets = new Insets(0, 0, 5, 5);
		gbc_button_43.gridx = 6;
		gbc_button_43.gridy = 7;
		frmAiChessSimulation.getContentPane().add(button_43, gbc_button_43);
		
		JButton button_49 = new JButton("0");
		GridBagConstraints gbc_button_49 = new GridBagConstraints();
		gbc_button_49.insets = new Insets(0, 0, 5, 5);
		gbc_button_49.gridx = 7;
		gbc_button_49.gridy = 7;
		frmAiChessSimulation.getContentPane().add(button_49, gbc_button_49);
		
		JButton button_55 = new JButton("0");
		GridBagConstraints gbc_button_55 = new GridBagConstraints();
		gbc_button_55.insets = new Insets(0, 0, 5, 0);
		gbc_button_55.gridx = 8;
		gbc_button_55.gridy = 7;
		frmAiChessSimulation.getContentPane().add(button_55, gbc_button_55);
		
		JButton button_56 = new JButton("0");
		GridBagConstraints gbc_button_56 = new GridBagConstraints();
		gbc_button_56.insets = new Insets(0, 0, 0, 5);
		gbc_button_56.gridx = 1;
		gbc_button_56.gridy = 8;
		frmAiChessSimulation.getContentPane().add(button_56, gbc_button_56);
		
		JButton button_57 = new JButton("0");
		GridBagConstraints gbc_button_57 = new GridBagConstraints();
		gbc_button_57.insets = new Insets(0, 0, 0, 5);
		gbc_button_57.gridx = 2;
		gbc_button_57.gridy = 8;
		frmAiChessSimulation.getContentPane().add(button_57, gbc_button_57);
		
		JButton button_58 = new JButton("0");
		GridBagConstraints gbc_button_58 = new GridBagConstraints();
		gbc_button_58.insets = new Insets(0, 0, 0, 5);
		gbc_button_58.gridx = 3;
		gbc_button_58.gridy = 8;
		frmAiChessSimulation.getContentPane().add(button_58, gbc_button_58);
		
		JButton button_59 = new JButton("0");
		GridBagConstraints gbc_button_59 = new GridBagConstraints();
		gbc_button_59.insets = new Insets(0, 0, 0, 5);
		gbc_button_59.gridx = 4;
		gbc_button_59.gridy = 8;
		frmAiChessSimulation.getContentPane().add(button_59, gbc_button_59);
		
		JButton button_60 = new JButton("0");
		GridBagConstraints gbc_button_60 = new GridBagConstraints();
		gbc_button_60.insets = new Insets(0, 0, 0, 5);
		gbc_button_60.gridx = 5;
		gbc_button_60.gridy = 8;
		frmAiChessSimulation.getContentPane().add(button_60, gbc_button_60);
		
		JButton button_61 = new JButton("0");
		GridBagConstraints gbc_button_61 = new GridBagConstraints();
		gbc_button_61.insets = new Insets(0, 0, 0, 5);
		gbc_button_61.gridx = 6;
		gbc_button_61.gridy = 8;
		frmAiChessSimulation.getContentPane().add(button_61, gbc_button_61);
		
		JButton button_62 = new JButton("0");
		GridBagConstraints gbc_button_62 = new GridBagConstraints();
		gbc_button_62.insets = new Insets(0, 0, 0, 5);
		gbc_button_62.gridx = 7;
		gbc_button_62.gridy = 8;
		frmAiChessSimulation.getContentPane().add(button_62, gbc_button_62);
		
		JButton button_63 = new JButton("0");
		GridBagConstraints gbc_button_63 = new GridBagConstraints();
		gbc_button_63.gridx = 8;
		gbc_button_63.gridy = 8;
		frmAiChessSimulation.getContentPane().add(button_63, gbc_button_63);

	}
}
