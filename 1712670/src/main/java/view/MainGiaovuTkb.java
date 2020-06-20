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

public class MainGiaovuTkb extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainGiaovuTkb(final String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnNewButton = new JButton("Import danh s\u00E1ch tkb");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 135, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -135, SpringLayout.EAST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImportTkb main = new ImportTkb();
				main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				main.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Qu\u1EA3n l\u00FD th\u1EDDi kh\u00F3a bi\u1EC3u");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 100, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -100, SpringLayout.EAST, contentPane);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("Xem danh s\u00E1ch tkb");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 15, SpringLayout.SOUTH, btnNewButton_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_4, 0, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_4, 0, SpringLayout.EAST, btnNewButton);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowTkb main = new ShowTkb();
				main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				main.setVisible(true);
			}
		});
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
	}

}
