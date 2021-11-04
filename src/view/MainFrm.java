package view;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.APIController;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	public static JTextField txtURL;
	public static JLabel lblStatus;
	public static JTextArea textPane;

	
	public MainFrm() {
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setTitle("API Tester");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		lblStatus = new JLabel("API Status:");
		lblStatus.setForeground(SystemColor.control);
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblStatus);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("API URL");
		lblNewLabel.setForeground(SystemColor.control);
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel_1.add(lblNewLabel);
		
		txtURL = new JTextField();
		txtURL.setBounds(66, 8, 298, 20);
		panel_1.add(txtURL);
		txtURL.setColumns(10);

		textPane = new JTextArea();
		textPane.setBackground(SystemColor.control);
		textPane.setEditable(false);
		textPane.setBounds(10, 36, 354, 251);
		textPane.setLineWrap(true);
		textPane.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 36, 354, 251);
		panel_1.add(scrollPane);
		
		
		JButton btnNewButton = new JButton("Make request");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				APIController.setAPITest();
			}
		});
		btnNewButton.setForeground(SystemColor.control);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(10, 298, 354, 23);
		panel_1.add(btnNewButton);
	}
}
