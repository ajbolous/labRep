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
import Client.Resources;
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
	private final JLabel lblNewLabel_2 = new JLabel("Views and Reports");
	private final JButton button = new JButton("Users");
	private final JButton button_1 = new JButton("Doctors");
	private final JLabel lblManage = new JLabel("Managment");

	public ClientUI() {
		initialize();
		frame.setSize(784, 449);
		frame.setVisible(true);
		lblNewLabel_1.setBounds(0, 366, 473, 42);
		lblNewLabel_1.setText("Logged in as " + Config.getConfig().getUser().getUsername());

	}

	private void initialize(){
		Resources res = new Resources();
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
		btnNewButton.setIcon(res.getIcon("doctors.png"));
		
		frame.getContentPane().add(btnNewButton);
		btnLabs.setBounds(34, 133, 223, 65);
		btnLabs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLabs.setHorizontalAlignment(SwingConstants.LEFT);
		btnLabs.setForeground(Color.BLACK);
		btnLabs.setBackground(Color.WHITE);
		btnLabs.setIcon(res.getIcon("lab.png"));
		
		frame.getContentPane().add(btnLabs);
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Users users = new Users();
				
			}
		});
		btnUsers.setBounds(284, 131, 229, 68);
		btnUsers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUsers.setBackground(Color.WHITE);
		btnUsers.setHorizontalAlignment(SwingConstants.LEFT);
		btnUsers.setForeground(Color.BLACK);
		btnUsers.setIcon(res.getIcon("users.png"));
		
		frame.getContentPane().add(btnUsers);
		btnTests.setBounds(34, 264, 223, 68);
		btnTests.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTests.setBackground(Color.WHITE);
		btnTests.setHorizontalAlignment(SwingConstants.LEFT);
		btnTests.setForeground(Color.BLACK);
		btnTests.setIcon(res.getIcon("tests.png"));
		
		frame.getContentPane().add(btnTests);
		lblNewLabel.setBounds(0, 0, 786, 59);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setIcon(res.getIcon("logo.png"));
		
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel_1.setIcon(res.getIcon("info.png"));
		
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 228, 193, 22);
		
		frame.getContentPane().add(lblNewLabel_2);
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBackground(Color.WHITE);
		button.setBounds(284, 264, 229, 68);
		
		frame.getContentPane().add(button);
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(547, 266, 229, 65);
		
		frame.getContentPane().add(button_1);
		lblManage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblManage.setBounds(10, 100, 111, 22);
		
		frame.getContentPane().add(lblManage);
		
		
		
	}
}
