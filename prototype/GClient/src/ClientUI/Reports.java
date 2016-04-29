package ClientUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class Reports extends JPanel {

	/**
	 * Create the panel.
	 */
	public Report() {
		setForeground(Color.DARK_GRAY);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(Color.WHITE);
		add(list);
		
		JLabel lblSelectReportType = new JLabel("Select Report Type :");
		lblSelectReportType.setVerticalAlignment(SwingConstants.BOTTOM);
		add(lblSelectReportType);

	}

}
