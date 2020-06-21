package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pojo.Sinhvien;
import pojo.SinhvienDAO;
import pojo.SvMonhoc;
import pojo.SvMonhocDAO;

public class DelSvMonhoc extends JFrame {

	private JPanel contentPane;
	private JTextField textField_mssv;
	private JTextField textField_maMon;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DelSvMonhoc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Xóa sinh viên - môn học");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 100, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -100, SpringLayout.EAST, contentPane);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		textField_mssv = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_mssv, 42, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, textField_mssv, 90, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, textField_mssv, -69, SpringLayout.EAST, contentPane);
		contentPane.add(textField_mssv);
		textField_mssv.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("MSSV");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, textField_mssv);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);
		
		textField_maMon = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_maMon, 20, SpringLayout.SOUTH, textField_mssv);
		springLayout.putConstraint(SpringLayout.WEST, textField_maMon, 90, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, textField_maMon, 0, SpringLayout.EAST, textField_mssv);
		contentPane.add(textField_maMon);
		textField_maMon.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mã lớp");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 3, SpringLayout.NORTH, textField_maMon);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_3);
		
		JButton btnThem = new JButton("Xóa");
		springLayout.putConstraint(SpringLayout.NORTH, btnThem, 21, SpringLayout.SOUTH, textField_maMon);
		springLayout.putConstraint(SpringLayout.WEST, btnThem, 170, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, btnThem, -170, SpringLayout.EAST, contentPane);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int mssv = Integer.valueOf(textField_mssv.getText().toString());
				String maMon = textField_maMon.getText().toString();
				boolean check;
				SvMonhoc sv = SvMonhocDAO.layThongTinhSvMonhoc(mssv, maMon);
				if (sv != null)
					check = true;
				else
					check = false;
				if (check) {
					boolean check1 = SvMonhocDAO.xoaSvMonhoc(sv);
					if (check1)
						JOptionPane.showMessageDialog(contentPane, "Successful!");
				} else
					JOptionPane.showMessageDialog(contentPane, "Fail!");
					
			}
		});
		contentPane.add(btnThem);
	}

}
