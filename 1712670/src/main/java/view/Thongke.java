package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pojo.SvMonhoc;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Thongke extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Thongke dialog = new Thongke(1, 1);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Thongke(int f, int n) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		
		JLabel lblNewLabel = new JLabel("S\u1ED1 sv \u0111\u1EADu");
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPanel);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Th\u1ED1ng k\u00EA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 150, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -150, SpringLayout.EAST, contentPanel);
		contentPanel.add(lblNewLabel_1);
		
		JTextField countDau = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.WEST, countDau, 30, SpringLayout.EAST, lblNewLabel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, countDau, 0, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, countDau, 75, SpringLayout.EAST, lblNewLabel);
		contentPanel.add(countDau);
		
		JLabel lblNewLabel_2 = new JLabel("S\u1ED1 sv r\u1EDBt");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 150, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -41, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		contentPanel.add(lblNewLabel_2);
		
		JTextField countRot = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.WEST, countRot, 0, SpringLayout.WEST, countDau);
		sl_contentPanel.putConstraint(SpringLayout.EAST, countRot, 45, SpringLayout.WEST, countDau);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, countRot, 0, SpringLayout.SOUTH, lblNewLabel_2);
		contentPanel.add(countRot);
		
		JLabel lblNewLabel_3 = new JLabel("T\u1EF7 l\u1EC7");
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 60, SpringLayout.EAST, countDau);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 0, SpringLayout.SOUTH, lblNewLabel);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("T\u1EF7 l\u1EC7");
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel_3);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, 0, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPanel.putConstraint(SpringLayout.EAST, lblNewLabel_4, 0, SpringLayout.EAST, lblNewLabel_3);
		contentPanel.add(lblNewLabel_4);
		
		JTextField pDau = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.WEST, pDau, 30, SpringLayout.EAST, lblNewLabel_3);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, pDau, 0, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, pDau, 95, SpringLayout.EAST, lblNewLabel_3);
		contentPanel.add(pDau);
		
		JTextField pRot = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.WEST, pRot, 0, SpringLayout.WEST, pDau);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, pRot, 0, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPanel.putConstraint(SpringLayout.EAST, pRot, 95, SpringLayout.EAST, lblNewLabel_4);
		contentPanel.add(pRot);
		
		JLabel lblNewLabel_5 = new JLabel("T\u1ED5ng s\u1ED1");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -30, SpringLayout.NORTH, lblNewLabel);
		contentPanel.add(lblNewLabel_5);
		
		total = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.WEST, total, 0, SpringLayout.WEST, countDau);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, total, 0, SpringLayout.SOUTH, lblNewLabel_5);
		sl_contentPanel.putConstraint(SpringLayout.EAST, total, 45, SpringLayout.WEST, countDau);
		contentPanel.add(total);
		total.setColumns(10);
		
		countDau.setText(String.valueOf(f));
		countRot.setText(String.valueOf(n-f));
		pDau.setText(String.valueOf(f*100.0/n) + "%");
		pRot.setText(String.valueOf((n-f)*100.0/n) + "%");
		total.setText(String.valueOf(n));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
