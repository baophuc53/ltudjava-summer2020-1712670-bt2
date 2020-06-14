package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import pojo.Sinhvien;
import pojo.SinhvienDAO;
import pojo.SvMonhoc;
import pojo.SvMonhocDAO;

public class ImportBangdiem extends JFrame {

	private JPanel contentPane;
	private String pathfile;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportBangdiem frame = new ImportBangdiem();
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
	public ImportBangdiem() {
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
					String maMon = value[1];
					br.readLine();
					while ((line = br.readLine())!=null) {
						String UTF8Str = new String(line.getBytes(),"UTF-8");
						String[] v = UTF8Str.split(",");
						int mssv = Integer.valueOf(v[1]);
						float gk = Float.valueOf(v[3]);
						float ck = Float.valueOf(v[4]);
						float khac = Float.valueOf(v[5]);
						float tong = Float.valueOf(v[6]);
						SvMonhoc sv = SvMonhocDAO.layThongTinhSvMonhoc(mssv, maMon);
						sv.setGk(gk);
						sv.setCk(ck);
						sv.setDiemKhac(khac);
						sv.setDiemTong(tong);
						boolean check = SvMonhocDAO.capNhatSvMonhoc(sv);
						if (check == false) {
							JOptionPane.showMessageDialog(contentPane, "Fail!");
							break;
						}
					}
					
					br.close();
					JOptionPane.showMessageDialog(contentPane, "Successful!");
						
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
