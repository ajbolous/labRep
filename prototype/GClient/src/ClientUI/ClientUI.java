package ClientUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Client.Client;
import Client.Config;
import Model.User;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window.Type;

public class ClientUI {

	private JFrame frame;
	private final JButton btnNewButton = new JButton("Doctors");
	private final JButton btnLabs = new JButton("Labs");
	private final JButton btnUsers = new JButton("Users");
	private final JButton btnTests = new JButton("Reports");
	private final JLabel lblNewLabel = new JLabel("GHealth System");
	private final JLabel lblNewLabel_1 = new JLabel("");

	public ClientUI() {
		initialize();
		frame.setSize(792, 527);
		frame.setVisible(true);
		lblNewLabel_1.setBounds(0, 456, 473, 42);
		lblNewLabel_1.setText("Logged in as " + Config.getConfig().getUser().getUsername());
		
		JButton btnAppoitments = new JButton("Appoitments");
		btnAppoitments.setIcon(new ImageIcon("C:\\Users\\aj_pa\\Desktop\\labratory\\prototype\\GClient\\img\\appoitment.png"));
		btnAppoitments.setHorizontalAlignment(SwingConstants.LEFT);
		btnAppoitments.setForeground(Color.BLACK);
		btnAppoitments.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAppoitments.setBackground(Color.WHITE);
		btnAppoitments.setBounds(290, 264, 223, 68);
		frame.getContentPane().add(btnAppoitments);
		
		JButton btnTreatments = new JButton("Treatments");
		btnTreatments.setIcon(new ImageIcon("C:\\Users\\aj_pa\\Desktop\\labratory\\prototype\\GClient\\img\\treatment.png"));
		btnTreatments.setHorizontalAlignment(SwingConstants.LEFT);
		btnTreatments.setForeground(Color.BLACK);
		btnTreatments.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTreatments.setBackground(Color.WHITE);
		btnTreatments.setBounds(547, 264, 223, 68);
		frame.getContentPane().add(btnTreatments);
		
		JLabel lblManage = new JLabel("Manage");
		lblManage.setForeground(UIManager.getColor("Menu.selectionBackground"));
		lblManage.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblManage.setBounds(10, 97, 78, 22);
		frame.getContentPane().add(lblManage);
		
		JLabel lblView = new JLabel("View");
		lblView.setForeground(UIManager.getColor("Menu.selectionBackground"));
		lblView.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblView.setBounds(10, 223, 78, 14);
		frame.getContentPane().add(lblView);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		btnNewButton.setBounds(547, 133, 229, 65);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\aj_pa\\Desktop\\labratory\\prototype\\GClient\\img\\doctors.png"));
		
		frame.getContentPane().add(btnNewButton);
		btnLabs.setBounds(34, 133, 223, 65);
		btnLabs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLabs.setHorizontalAlignment(SwingConstants.LEFT);
		btnLabs.setForeground(Color.BLACK);
		btnLabs.setBackground(Color.WHITE);
		btnLabs.setIcon(new ImageIcon("C:\\Users\\aj_pa\\Desktop\\labratory\\prototype\\GClient\\img\\lab.png"));
		
		frame.getContentPane().add(btnLabs);
		btnUsers.setBounds(284, 131, 229, 68);
		btnUsers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUsers.setBackground(Color.WHITE);
		btnUsers.setHorizontalAlignment(SwingConstants.LEFT);
		btnUsers.setForeground(Color.BLACK);
		btnUsers.setIcon(new ImageIcon("C:\\Users\\aj_pa\\Desktop\\labratory\\prototype\\GClient\\img\\users.png"));
		
		frame.getContentPane().add(btnUsers);
		btnTests.setBounds(34, 264, 223, 68);
		btnTests.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTests.setBackground(Color.WHITE);
		btnTests.setHorizontalAlignment(SwingConstants.LEFT);
		btnTests.setForeground(Color.BLACK);
		btnTests.setIcon(new ImageIcon("C:\\Users\\aj_pa\\Desktop\\labratory\\prototype\\GClient\\img\\tests.png"));
		
		frame.getContentPane().add(btnTests);
		lblNewLabel.setBounds(0, 0, 786, 59);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\aj_pa\\Desktop\\labratory\\prototype\\GClient\\img\\logo.png"));
		
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\aj_pa\\Desktop\\labratory\\prototype\\GClient\\img\\info.png"));
		
		frame.getContentPane().add(lblNewLabel_1);
	}
}
