package view;

import java.awt.EventQueue;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import pojo.Sinhvien;
import pojo.SinhvienDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ImportSinhvien extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String pathfile;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ImportSinhvien() {
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
					BufferedReader br =new BufferedReader(new FileReader(pathfile));
					String line;
					line = br.readLine();
					String[] value = line.split(",");
					String maLop = value[0];
					br.readLine();
					List<Sinhvien> list = new ArrayList<>();
					while ((line = br.readLine())!=null) {
						String UTF8Str = new String(line.getBytes(),"UTF-8");
						String[] v = UTF8Str.split(",");
						int stt = Integer.valueOf(v[0]);
						int mssv = Integer.valueOf(v[1]);
						String ten = v[2];
						int gioi = (v[3].equals("Nam")) ? 1 : 0;
						int cmnd = Integer.valueOf(v[4]);
						list.add(new Sinhvien(mssv, stt, ten, gioi, cmnd, maLop));
					}
					boolean check = SinhvienDAO.themDanhSachSinhVien(list);
					br.close();
					if (check) 
						JOptionPane.showMessageDialog(contentPane, "Successful!");
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
