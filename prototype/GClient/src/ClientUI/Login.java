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
import Model.User;
import Utils.Request;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField txtUser;
	private JPasswordField txtPass;


	public Login() {
		initialize();
		frame.setVisible(true);

	}

	public void login(){
		Request r = new Request("users/byName");
		r.addParam("name", txtUser.getText());
		User u = (User)Application.client.Request(r);
		if(u.getPassword().equals(txtPass.getText())){
			frame.setVisible(false);
			Config.getConfig().setUser(u);
			ClientUI ci = new ClientUI();
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 391, 160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		txtUser = new JTextField();
		txtUser.setBounds(75, 64, 178, 20);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		Resources res = new Resources();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		btnLogin.setBounds(285, 90, 79, 20);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(10, 67, 60, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 92, 60, 14);
		frame.getContentPane().add(lblPassword);
		
		txtPass = new JPasswordField();
		txtPass.setColumns(10);
		txtPass.setBounds(75, 89, 178, 20);
		frame.getContentPane().add(txtPass);
		
		JLabel lblWelcomeToGhealth = new JLabel("GHealth System");
		lblWelcomeToGhealth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomeToGhealth.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomeToGhealth.setIcon(res.getIcon("logo.png"));
		lblWelcomeToGhealth.setBounds(0, 0, 365, 61);
		frame.getContentPane().add(lblWelcomeToGhealth);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(285, 64, 79, 20);
		frame.getContentPane().add(btnCancel);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtUser, txtPass, btnLogin, btnCancel, frame.getContentPane(), lblNewLabel, lblPassword, lblWelcomeToGhealth}));
	}
}
