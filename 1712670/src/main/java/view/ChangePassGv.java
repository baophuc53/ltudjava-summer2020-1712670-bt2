package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import pojo.User;
import pojo.UserDAO;

public class ChangePassGv extends JFrame {

	private JPanel contentPane;
	private JPasswordField textField;
	private JLabel lblNewLabel_1;
	private JPasswordField textField_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ChangePassGv(final String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("M\u1EADt kh\u1EA9u m\u1EDBi");
		contentPane.add(lblNewLabel);
		
		textField = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 31, SpringLayout.EAST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -92, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, textField);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 52, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 102, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, -35, SpringLayout.NORTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("X\u00E1c nh\u1EADn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass = new String(textField.getPassword());
				String pass1 = new String(textField_1.getPassword());
				if (pass.equals(pass1)) {
					User user = new User(username, pass, 0);
					boolean check = UserDAO.updateThongTinUser(user);
					if (check) {
						JOptionPane.showMessageDialog(contentPane, "Successful!");
						MainGiaovu main = new MainGiaovu(user.getUsername());
						main.setVisible(true);
						dispose();
					}
					else
						JOptionPane.showMessageDialog(contentPane, "Fail!");
				} else 
					JOptionPane.showMessageDialog(contentPane, "Invalid password!");
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 30, SpringLayout.SOUTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 160, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -160, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("< Back");
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
