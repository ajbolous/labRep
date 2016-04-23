package ClientUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;

import Client.Client;
import Model.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField txtUser;
	private JTextField txtPass;

	public static void main(String[] args) {
		Login window = new Login();
		window.frame.setVisible(true);
	}

	public Login() {
		initialize();
	}

	public void login(){
		Client c = new Client("localhost",5000);
		User u = (User)c.Request("users/id?" + txtUser.getText());
		if(u.getPassword().equals(txtPass.getText())){
			txtUser.setText(u.getUsername());
		}
		c.close();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 223, 138);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(75, 11, 125, 20);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		btnLogin.setBounds(10, 66, 190, 20);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(10, 14, 60, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 39, 60, 14);
		frame.getContentPane().add(lblPassword);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(75, 36, 125, 20);
		frame.getContentPane().add(txtPass);
	}
}
