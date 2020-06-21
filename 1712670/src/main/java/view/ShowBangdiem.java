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

public class ShowBangdiem extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JComboBox comboBox1;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ShowBangdiem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout springLayout = new SpringLayout();
		contentPane.setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Xem bảng điểm");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 120, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -120, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		String[] lop = SinhvienDAO.layDanhSachLop();
		comboBox = new JComboBox(lop);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 50, SpringLayout.NORTH, contentPane);
		contentPane.add(comboBox);
		
		String[] mon = SvMonhocDAO.layDanhSachMon();
		comboBox1 = new JComboBox(mon);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox1, 0, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, comboBox1, 30, SpringLayout.EAST, comboBox);
		contentPane.add(comboBox1);
		
		JLabel lblNewLabel_2 = new JLabel("Lớp");
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 21, SpringLayout.EAST, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 3, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);
		String[] columnNames = {"STT", "MSSV", "Họ và tên", "Điểm GK", "Điểm CK", "Điểm khác", "Điểm tổng", "Kết quả"};
		String[][] data = {{}};
		DefaultTableModel modelEmpty = new DefaultTableModel(data, columnNames);
		final JTable table = new JTable(modelEmpty);
		JScrollPane scrollPane = new JScrollPane(table);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 31, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, contentPane);
		JButton btnNewButton = new JButton("Show");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 30, SpringLayout.EAST, comboBox1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				String lop = comboBox.getSelectedItem().toString();
				String mon = comboBox1.getSelectedItem().toString();
				int stt = 1;
				List<SvMonhoc> sv= SvMonhocDAO.layDanhSachSinhVienMonHocTheoLop(lop, mon);
				for	(SvMonhoc i: sv) {
					String kq = (i.getDiemTong()>=5) ? "Đậu" : "Rớt";
					Sinhvien t = SinhvienDAO.layThongTinSinhVien(i.getMssv());
					String[] temp = {String.valueOf(stt), String.valueOf(t.getMssv()), t.getHoTen(),  String.valueOf(i.getGk()), 
							String.valueOf(i.getCk()), String.valueOf(i.getDiemKhac()), String.valueOf(i.getDiemTong()), kq};
					model.addRow(temp);
					stt++;
				}
			}				
		});
		contentPane.add(btnNewButton);
		contentPane.add(scrollPane);
		
		JButton btnNewButton_1 = new JButton("Thống kê");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String lop = comboBox.getSelectedItem().toString();
				String mon = comboBox1.getSelectedItem().toString();
				List<SvMonhoc> sv= SvMonhocDAO.layDanhSachSinhVienMonHocTheoLop(lop, mon);
				int n = sv.size();
				int f = 0;
				for	(SvMonhoc i: sv) {
					if (i.getDiemTong()>=5)
						f++;
				}
				Thongke tk = new Thongke(f, n);
				tk.setVisible(true);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 30, SpringLayout.EAST, btnNewButton);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 0, SpringLayout.SOUTH, btnNewButton);
		contentPane.add(btnNewButton_1);
	}
}
