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
import Model.User;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ClientUI {

	private JFrame frame;
	private Client client;

	public static void main(String[] args) {

		ClientUI window = new ClientUI();
		window.frame.setVisible(true);
	}

	public ClientUI() {
		initialize();
	}

	private void connect() {
		client = new Client(txtIp.getText(), Integer.parseInt(txtPort.getText()), this);
	}

	public void display(Object obj) {
		textArea.append("Server: " + obj.toString() + "\n");
		ArrayList<User> arr = (ArrayList<User>) obj;
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (User u : arr) {
			textArea.append("Server: " + u.toString() + "\n");

			model.addRow(new Object[] { u.getId(), u.getUsername(), u.getPassword() });
		}

		table.setModel(model);

	}

	private final JDesktopPane desktopPane = new JDesktopPane();
	private final JTextPane txtIp = new JTextPane();
	private final JTextPane txtPort = new JTextPane();
	private final JButton btnConnect = new JButton("Connect");
	private final JTextArea textArea = new JTextArea();
	private JTextField txtReq;
	private final JTable table = new JTable();

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 544, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		desktopPane.setBackground(UIManager.getColor("CheckBox.light"));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);

		txtIp.setText("localhost");
		txtIp.setBounds(10, 11, 165, 26);
		desktopPane.add(txtIp);

		txtPort.setText("5000");
		txtPort.setBounds(10, 48, 165, 26);
		desktopPane.add(txtPort);

		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});

		btnConnect.setBounds(10, 84, 89, 23);
		desktopPane.add(btnConnect);
		textArea.setBounds(10, 307, 508, 96);

		desktopPane.add(textArea);

		txtReq = new JTextField();
		txtReq.setBounds(109, 85, 317, 22);
		desktopPane.add(txtReq);
		txtReq.setColumns(10);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Object response = client.sendToServer(txtReq.getText());
					textArea.append(response.toString());
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		btnSend.setBounds(436, 84, 82, 23);
		desktopPane.add(btnSend);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Username", "Password" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(10, 118, 508, 175);

		desktopPane.add(table);
	}
}
