package ClientUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JTextField;

import Client.Client;
import Client.Config;
import Client.Resources;
import Users.User;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Window.Type;
import java.awt.Font;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;

public class Settings {

	private JFrame frame;
	private JButton btnCancel;
	private JTextField txtHost;
	private JTextField txtPort;
	private JTextField textField_2;
	private JTextField textField_3;

	public Settings() {
		initialize();
		frame.setVisible(true);
		Config cfg = Config.getConfig();

		txtHost.setText(cfg.getHost());
		txtPort.setText(""+cfg.getPort());
		
	}


	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 304, 295);

		frame.getContentPane().setLayout(null);

		Resources res = new Resources();

		JButton btnLogin = new JButton("Save");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Config cfg = Config.getConfig();
				cfg.setHost(txtHost.getText());
				cfg.setPort(Integer.parseInt(txtPort.getText()));
				Application.connect();
				frame.dispose();
			}
		});
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.WHITE);

		btnLogin.setBounds(117, 223, 79, 20);
		frame.getContentPane().add(btnLogin);

		JLabel lblWelcomeToGhealth = new JLabel("Settings");
		lblWelcomeToGhealth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomeToGhealth.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomeToGhealth.setIcon(res.getIcon("logo.png"));
		lblWelcomeToGhealth.setBounds(0, 0, 365, 61);
		frame.getContentPane().add(lblWelcomeToGhealth);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(205, 223, 79, 20);
		frame.getContentPane().add(btnCancel);
		
		txtHost = new JTextField();
		txtHost.setBounds(78, 72, 206, 20);
		frame.getContentPane().add(txtHost);
		txtHost.setColumns(10);
		
		txtPort = new JTextField();
		txtPort.setColumns(10);
		txtPort.setBounds(78, 103, 206, 20);
		frame.getContentPane().add(txtPort);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(78, 134, 206, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(78, 170, 206, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNewLabel = new JLabel("Host:");
		lblNewLabel.setBounds(22, 75, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(22, 106, 46, 14);
		frame.getContentPane().add(lblPort);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(22, 137, 46, 14);
		frame.getContentPane().add(lblDate);
		
		JLabel lblColors = new JLabel("Colors:");
		lblColors.setBounds(22, 173, 46, 14);
		frame.getContentPane().add(lblColors);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnLogin, frame.getContentPane(), lblWelcomeToGhealth}));
	}
}
