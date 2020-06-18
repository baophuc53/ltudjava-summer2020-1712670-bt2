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
import pojo.Tkb;
import pojo.TkbDAO;

public class ShowDiemSinhvien extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ShowDiemSinhvien(int mssv) {
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
		String[] columnNames = { "STT", "Mã môn", "Tên môn", "Điểm GK", "Điểm CK", "Điểm khác", "Điểm tổng",
				"Kết quả" };
		String[][] data = { {} };
		DefaultTableModel modelEmpty = new DefaultTableModel(data, columnNames);
		final JTable table = new JTable(modelEmpty);
		JScrollPane scrollPane = new JScrollPane(table);
		List<SvMonhoc> sv = SvMonhocDAO.layDanhSachSinhVienMonHocTheoSv(mssv);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int stt = 1;
		model.setRowCount(0);
		for (SvMonhoc i : sv) {
			Tkb tkb = TkbDAO.layThongTinhTkb(i.getMaLop(), i.getMaMon());
			String kq = (i.getDiemTong() >= 5) ? "Đậu" : "Rớt";
			String[] temp = { String.valueOf(stt), i.getMaMon(), tkb.getTenMon(), String.valueOf(i.getGk()),
					String.valueOf(i.getCk()), String.valueOf(i.getDiemKhac()), String.valueOf(i.getDiemTong()), kq };
			model.addRow(temp);
			stt++;
		}
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 30, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, contentPane);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane);
	}
}
