package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MainSinhvien extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public MainSinhvien(final int mssv) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnNewButton = new JButton("Xem \u0111i\u1EC3m");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 50, SpringLayout.NORTH, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowDiemSinhvien sv = new ShowDiemSinhvien(mssv);
				sv.setVisible(true);
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 165, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -165, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 180, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -180, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePassSv main = new ChangePassSv(mssv);
				main.setVisible(true);
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 15, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 155, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -155, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(null);
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 165, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_2, -165, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, 15, SpringLayout.SOUTH, btnNewButton_1);
		contentPane.add(btnNewButton_2);
	}
}
