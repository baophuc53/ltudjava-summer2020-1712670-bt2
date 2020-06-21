package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pojo.Sinhvien;
import pojo.SinhvienDAO;
import pojo.SvMonhoc;
import pojo.SvMonhocDAO;
import javax.swing.JTextField;

public class UpdateSvMonhoc extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JComboBox comboBox1;
	private JTextField textField_mssv;
	private JTextField textField_gk;
	private JTextField textField_ck;
	private JTextField textField_khac;
	private JTextField textField_tong;
	private JPanel panel;
	private int mssv;
	private String lop;
	private String mon;
	private SvMonhoc svmh;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public UpdateSvMonhoc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(springLayout);
		JLabel lblNewLabel = new JLabel("Sửa điểm");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 120, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -120, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		String[] dsLop = SinhvienDAO.layDanhSachLop();
		comboBox = new JComboBox(dsLop);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 50, SpringLayout.NORTH, contentPane);
		contentPane.add(comboBox);
		
		String[] dsMon = SvMonhocDAO.layDanhSachMon();
		comboBox1 = new JComboBox(dsMon);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox1, 0, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, comboBox1, 30, SpringLayout.EAST, comboBox);
		contentPane.add(comboBox1);
		
		JLabel lblNewLabel_2 = new JLabel("Lớp");
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 21, SpringLayout.EAST, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lop = comboBox.getSelectedItem().toString();
				mon = comboBox1.getSelectedItem().toString();
				mssv = Integer.valueOf(textField_mssv.getText());
				svmh = SvMonhocDAO.layThongTinhSvMonhoc(mssv, mon);
				if (svmh != null && svmh.getMaLop().equals(lop)) {
					panel.setVisible(true);
					textField_gk.setText(String.valueOf(svmh.getGk()));
					textField_ck.setText(String.valueOf(svmh.getCk()));
					textField_khac.setText(String.valueOf(svmh.getDiemKhac()));
					textField_tong.setText(String.valueOf(svmh.getDiemTong()));
				} else {
					JOptionPane.showMessageDialog(contentPane, "Không tìm thấy");
				}
				
			}				
		});
		contentPane.add(btnTim);
		
		JLabel lblNewLabel_1 = new JLabel("MSSV");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 30, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		textField_mssv = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, btnTim, 0, SpringLayout.NORTH, textField_mssv);
		springLayout.putConstraint(SpringLayout.WEST, btnTim, 30, SpringLayout.EAST, textField_mssv);
		springLayout.putConstraint(SpringLayout.WEST, textField_mssv, 0, SpringLayout.WEST, comboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_mssv, 0, SpringLayout.SOUTH, lblNewLabel_1);
		contentPane.add(textField_mssv);
		textField_mssv.setColumns(10);
		
		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 26, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, contentPane);
		contentPane.add(panel);
		panel.setVisible(false);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel_3 = new JLabel("GK");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_3);
		
		textField_gk = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField_gk, 15, SpringLayout.EAST, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_gk, 0, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.EAST, textField_gk, 55, SpringLayout.EAST, lblNewLabel_3);
		panel.add(textField_gk);
		textField_gk.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CK");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 40, SpringLayout.EAST, textField_gk);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, 0, SpringLayout.SOUTH, lblNewLabel_3);
		panel.add(lblNewLabel_4);
		
		textField_ck = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField_ck, 15, SpringLayout.EAST, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_ck, 0, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.EAST, textField_ck, 55, SpringLayout.EAST, lblNewLabel_4);
		textField_ck.setColumns(10);
		panel.add(textField_ck);
		
		JLabel lblNewLabel_5 = new JLabel("Điểm khác");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_5, 40, SpringLayout.EAST, textField_ck);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 0, SpringLayout.SOUTH, lblNewLabel_3);
		panel.add(lblNewLabel_5);
		
		textField_khac = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField_khac, 15, SpringLayout.EAST, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_khac, 0, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.EAST, textField_khac, 55, SpringLayout.EAST, lblNewLabel_5);
		panel.add(textField_khac);
		textField_khac.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Điểm tổng");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_6, 40, SpringLayout.EAST, textField_khac);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, 0, SpringLayout.SOUTH, lblNewLabel_3);
		panel.add(lblNewLabel_6);
		
		textField_tong = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField_tong, 15, SpringLayout.EAST, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_tong, 0, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.EAST, textField_tong, 55, SpringLayout.EAST, lblNewLabel_6);
		panel.add(textField_tong);
		textField_tong.setColumns(10);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				svmh.setGk(Float.valueOf(textField_gk.getText()));
				svmh.setCk(Float.valueOf(textField_ck.getText()));
				svmh.setDiemKhac(Float.valueOf(textField_khac.getText()));
				svmh.setDiemTong(Float.valueOf(textField_tong.getText()));
				boolean check = SvMonhocDAO.capNhatSvMonhoc(svmh);
				if (check) 
					JOptionPane.showMessageDialog(contentPane, "Successful!");
				else
					JOptionPane.showMessageDialog(contentPane, "Fail!");		
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnSua, 25, SpringLayout.SOUTH, lblNewLabel_5);
		sl_panel.putConstraint(SpringLayout.WEST, btnSua, 240, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnSua, -240, SpringLayout.EAST, panel);
		panel.add(btnSua);
	}
}
