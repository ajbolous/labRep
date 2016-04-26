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

public class Users {

	private JFrame frame;
	private JTextField txtUser;
	private JTable table;

	public Users() {
		initialize();
		frame.setVisible(true);
		loadData("");
	}

	private void loadData(String filter) {
		ArrayList<User> users = (ArrayList<User>) Application.client.Request(new Request("users/all"));

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (User u : users) {
			model.addRow(new Object[] { u.getId(), u.getUsername(), u.getPassword() });
		}
		table.setModel(model);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 472, 508);

		frame.getContentPane().setLayout(null);
		txtUser = new JTextField();
		txtUser.setBounds(0, 64, 357, 20);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);

		Resources res = new Resources();

		JButton btnLogin = new JButton("Search");
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(Color.WHITE);

		btnLogin.setBounds(367, 64, 79, 20);
		frame.getContentPane().add(btnLogin);

		JLabel lblWelcomeToGhealth = new JLabel("Users manager");
		lblWelcomeToGhealth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomeToGhealth.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomeToGhealth.setIcon(res.getIcon("logo.png"));
		lblWelcomeToGhealth.setBounds(0, 0, 365, 61);
		frame.getContentPane().add(lblWelcomeToGhealth);

		table = new JTable();
		table.setBorder(new CompoundBorder());
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Username", "Password" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(10, 95, 436, 363);
		frame.getContentPane().add(table);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { txtUser, btnLogin, frame.getContentPane(), lblWelcomeToGhealth }));
	}
}
