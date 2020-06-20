package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import pojo.Sinhvien;
import pojo.SinhvienDAO;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddSinhvien extends JFrame{

	private JPanel contentPane;
	private JTextField textField_mssv;
	private JTextField textField_ten;
	private JTextField textField_cmnd;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public AddSinhvien() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Thêm sinh viên");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 150, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -150, SpringLayout.EAST, contentPane);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 l\u1EDBp");
		contentPane.add(lblNewLabel_1);
		
		textField_mssv = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_mssv, 110, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, textField_mssv, 90, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, textField_mssv, -69, SpringLayout.EAST, contentPane);
		contentPane.add(textField_mssv);
		textField_mssv.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("MSSV");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, textField_mssv);
		contentPane.add(lblNewLabel_2);
		
		textField_ten = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_ten, 20, SpringLayout.SOUTH, textField_mssv);
		springLayout.putConstraint(SpringLayout.WEST, textField_ten, 90, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, textField_ten, -69, SpringLayout.EAST, contentPane);
		contentPane.add(textField_ten);
		textField_ten.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 3, SpringLayout.NORTH, textField_ten);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gi\u1EDBi t\u00EDnh");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 26, SpringLayout.SOUTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_4);
		
		textField_cmnd = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_cmnd, 60, SpringLayout.SOUTH, textField_ten);
		springLayout.putConstraint(SpringLayout.WEST, textField_cmnd, 90, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, textField_cmnd, -69, SpringLayout.EAST, contentPane);
		contentPane.add(textField_cmnd);
		textField_cmnd.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("CMND");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 10, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 3, SpringLayout.NORTH, textField_cmnd);
		contentPane.add(lblNewLabel_5);
		
		String[] gioi = {"Nữ", "Nam"};
		final JComboBox comboBox_gioi = new JComboBox(gioi);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_gioi, -3, SpringLayout.NORTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_gioi, 90, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_gioi, 3, SpringLayout.SOUTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_gioi, -69, SpringLayout.EAST, contentPane);
		contentPane.add(comboBox_gioi);
		
		String[] lop = SinhvienDAO.layDanhSachLop();
		final JComboBox comboBox_maLop = new JComboBox(lop);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_maLop, 39, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_maLop, -23, SpringLayout.NORTH, textField_mssv);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, comboBox_maLop);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_maLop, 0, SpringLayout.WEST, textField_mssv);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_maLop, 0, SpringLayout.EAST, textField_mssv);
		contentPane.add(comboBox_maLop);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String maLop = (String) comboBox_maLop.getSelectedItem();
				int mssv = Integer.valueOf(textField_mssv.getText());
				String hoten = textField_ten.getText();
				int gioitinh = comboBox_gioi.getSelectedIndex();
				int cmnd = Integer.valueOf(textField_cmnd.getText());
				List<Sinhvien> sv = SinhvienDAO.layDanhSachSinhVienTheoLop(maLop);
				int stt = sv.size()+1;
				boolean check = SinhvienDAO.themSinhVien(new Sinhvien(mssv, stt, hoten, gioitinh, cmnd, maLop));
				if (check) 
					JOptionPane.showMessageDialog(contentPane, "Successful!");
				else
					JOptionPane.showMessageDialog(contentPane, "Fail!");
					
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnThem, 20, SpringLayout.SOUTH, textField_cmnd);
		springLayout.putConstraint(SpringLayout.WEST, btnThem, 70, SpringLayout.WEST, textField_mssv);
		springLayout.putConstraint(SpringLayout.SOUTH, btnThem, 43, SpringLayout.SOUTH, textField_cmnd);
		springLayout.putConstraint(SpringLayout.EAST, btnThem, -70, SpringLayout.EAST, textField_mssv);
		contentPane.add(btnThem);
	}
}
