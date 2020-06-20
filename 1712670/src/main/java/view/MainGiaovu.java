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

public class MainGiaovu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainGiaovu(final String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnNewButton = new JButton("Qu\u1EA3n l\u00FD m\u00F4n h\u1ECDc");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 180, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -180, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 15, SpringLayout.SOUTH, btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePassGv main = new ChangePassGv(username);
				main.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(null);
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, 15, SpringLayout.SOUTH, btnNewButton_1);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Qu\u1EA3n l\u00FD TKB");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGiaovuTkb main = new MainGiaovuTkb(username);
				main.setVisible(true);
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 15, SpringLayout.SOUTH, btnNewButton_3);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Qu\u1EA3n l\u00FD sinh vi\u00EAn");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGiaovuSv main = new MainGiaovuSv(username);
				main.setVisible(true);
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, btnNewButton_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, btnNewButton_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, btnNewButton_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, btnNewButton_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, btnNewButton_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, btnNewButton_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_3, 0, SpringLayout.WEST, btnNewButton_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_3, 0, SpringLayout.EAST, btnNewButton_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_4, 145, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_4, -145, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_3, 15, SpringLayout.SOUTH, btnNewButton_4);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_4, 22, SpringLayout.SOUTH, lblNewLabel);
		contentPane.add(btnNewButton_4);
	}

}
