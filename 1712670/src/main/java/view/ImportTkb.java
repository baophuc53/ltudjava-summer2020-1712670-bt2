package view;

import java.awt.EventQueue;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import pojo.Sinhvien;
import pojo.SinhvienDAO;
import pojo.SvMonhoc;
import pojo.SvMonhocDAO;
import pojo.Tkb;
import pojo.TkbDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;

public class ImportTkb extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String pathfile;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportTkb frame = new ImportTkb();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ImportTkb() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Choose file");
		lblNewLabel.setLabelFor(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooseFile = new JFileChooser();
				chooseFile.addChoosableFileFilter(new FileNameExtensionFilter("*.csv", "csv"));
				chooseFile.showOpenDialog(null);
				File f = chooseFile.getSelectedFile();
				pathfile = f.getAbsolutePath();
				lblNewLabel.setText(pathfile);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Import to database");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(pathfile));
					String line;
					line = br.readLine();
					String[] value = line.split(",");
					String maLop = value[0];
					br.readLine();
					List<Tkb> listTkb = new ArrayList<>();
					List<Tkb> curTkb = TkbDAO.layDanhSachTkb();
					int last = curTkb.get(curTkb.size()-1).getStt();
					while ((line = br.readLine())!=null) {
						String UTF8Str = new String(line.getBytes(),"UTF-8");
						String[] v = UTF8Str.split(",");
						int stt = Integer.valueOf(v[0]);
						String maMon = v[1];
						String tenMon = v[2];
						String phong = v[3];
						listTkb.add(new Tkb(stt+last, maLop, maMon, tenMon, phong));
					}
					boolean check = TkbDAO.themDanhSachTkb(listTkb);
					br.close();
					if (check) {
						List<SvMonhoc> listSvmh = new ArrayList<>();
						List<Sinhvien> listSv= SinhvienDAO.layDanhSachSinhVienTheoLop(maLop);
						List<SvMonhoc> curSvmh = SvMonhocDAO.layDanhSachSinhVienMonHoc();
						int lastSvmh = curSvmh.get(curSvmh.size()-1).getStt();
						int i = 1;
						float f = 0;
						for	(Tkb tkb: listTkb) {
							for	(Sinhvien sv: listSv) {
								listSvmh.add(new SvMonhoc(lastSvmh + i, sv.getMssv(), maLop, tkb.getMaMon(), f, f, f, f));
								i++;
							}
						}
						boolean check1 = SvMonhocDAO.themDanhSachSvMonhoc(listSvmh);
						if (check1)
							JOptionPane.showMessageDialog(contentPane, "Successful!");
					}
					else
						JOptionPane.showMessageDialog(contentPane, "Fail!");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, "Fail!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, "Fail!");
				}
			}
		});
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 90, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -90, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 140, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -140, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 150, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -150, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 90, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 104, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 131, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 61, SpringLayout.NORTH, contentPane);
		contentPane.setLayout(sl_contentPane);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(lblNewLabel);
		
		
	}
}
