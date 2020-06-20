package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainGiaovuMonhoc extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public MainGiaovuMonhoc(final String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnNewButton = new JButton("Import b\u1EA3ng \u0111i\u1EC3m");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 135, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -135, SpringLayout.EAST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImportBangdiem main = new ImportBangdiem();
				main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				main.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Qu\u1EA3n l\u00FD m\u00F4n h\u1ECDc");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 100, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -100, SpringLayout.EAST, contentPane);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Th\u00EAm sinh vi\u00EAn - m\u00F4n h\u1ECDc");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_3, 0, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_3, 0, SpringLayout.EAST, btnNewButton);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSvMonhoc main = new AddSvMonhoc();
				main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 15, SpringLayout.SOUTH, btnNewButton_3);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Xem danh s\u00E1ch l\u1EDBp - m\u00F4n h\u1ECDc");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_4, 0, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_4, 0, SpringLayout.EAST, btnNewButton);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowSvMonhoc main = new ShowSvMonhoc();
				main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_3, 15, SpringLayout.SOUTH, btnNewButton_4);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_4, 22, SpringLayout.SOUTH, lblNewLabel);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("< Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGiaovu main = new MainGiaovu(username);
				main.setVisible(true);
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, contentPane);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("C\u1EADp nh\u1EADt \u0111i\u1EC3m sinh vi\u00EAn");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateSvMonhoc main = new UpdateSvMonhoc();
				main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, btnNewButton);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("Xem b\u1EA3ng \u0111i\u1EC3m");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowBangdiem main = new ShowBangdiem();
				main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				main.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, 15, SpringLayout.SOUTH, btnNewButton_5);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_5, 15, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_5, 0, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_5, 0, SpringLayout.EAST, btnNewButton);
		contentPane.add(btnNewButton_5);
	}

}
