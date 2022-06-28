package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ConfigurationDialogBox extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel sendingPanel;
	private JPanel receivingPanel;
	private JTabbedPane tabbedPane;
	private SaveSendListener saveSendListener;
	/*
	 * Sending stuffs
	 */
	private JLabel SportLabel;
	private JLabel SbaudRateLabel;
	private JLabel SstopBitsLabel;
	private JLabel SparityBitsLabel;
	private JLabel SdataBitsLabel;
	private JLabel SportDescription;
	private JLabel SbaudRateDescription;
	private JLabel SstopBitsDescription;
	private JLabel SparityBitsDescription;
	private JLabel SdataBitsDescription;
	private JButton SsaveSendingButton;
	private JComboBox SportComboBox;
	private JComboBox SbaudRateComboBox;
	private JComboBox SstopbitsComboBox;
	private JComboBox SparityBitsComboBox;
	private JComboBox SdataBitsComboBox;

	/*
	 * 
	 * Receiving Stuffs
	 */
	private JLabel RportLabel;
	private JLabel RbaudRateLabel;
	private JLabel RstopBitsLabel;
	private JLabel RparityBitsLabel;
	private JLabel RdataBitsLabel;
	private JLabel RportDescription;
	private JLabel RbaudRateDescription;
	private JLabel RstopBitsDescription;
	private JLabel RparityBitsDescription;
	private JLabel RdataBitsDescription;
	private JButton RsaveReceivingButton;
	private JComboBox RportComboBox;
	private JComboBox RbaudRateComboBox;
	private JComboBox RstopbitsComboBox;
	private JComboBox RparityBitsComboBox;
	private JComboBox RdataBitsComboBox;

	public ConfigurationDialogBox(JFrame parent, String title) {
		super(parent, title);
		setLayout(new BorderLayout());
		setSize(new Dimension(700, 350));
		setLocation(new Point(350, 350));
		/*
		 * Sending labels initialized
		 */
		SportLabel = new JLabel("Port");
		SbaudRateLabel = new JLabel("Baud Rate");
		SstopBitsLabel = new JLabel("Stop bits");
		SparityBitsLabel = new JLabel("Parity");
		SdataBitsLabel = new JLabel("Data Bits");
		SsaveSendingButton = new JButton("Save Sending Parameters");

		/*
		 * Receiving labels initialized
		 */
		RportLabel = new JLabel("Port");
		RbaudRateLabel = new JLabel("Baud Rate");
		RstopBitsLabel = new JLabel("Stop bits");
		RparityBitsLabel = new JLabel("Parity");
		RdataBitsLabel = new JLabel("Data Bits");
		RsaveReceivingButton = new JButton("Save Receiving Parameters");

		// port list - Sending
		String SportList[] = { "COM3", "COM4", "COM6", "COM11" };
		SportComboBox = new JComboBox(SportList);
		SportComboBox.setEditable(true);
		SportComboBox.setSelectedIndex(1);
		SportComboBox.setPreferredSize(new Dimension(115, 17));

		// port list - Receiving
		String RportList[] = { "COM3", "COM4", "COM6", "COM11" };
		RportComboBox = new JComboBox(RportList);
		RportComboBox.setEditable(true);
		RportComboBox.setSelectedIndex(2);
		RportComboBox.setPreferredSize(new Dimension(115, 17));

		// BaudRateList - Sending
		String SbaudRateList[] = { "300", "600", "1200", "1800", "2400",
				"4800", "7200", "9600", "14400", "19200", "38400", "57600",
				"115200", "230400", "460800", "921600" };
		SbaudRateComboBox = new JComboBox(SbaudRateList);
		SbaudRateComboBox.setEditable(true);
		SbaudRateComboBox.setSelectedIndex(7);
		SbaudRateComboBox.setPreferredSize(new Dimension(115, 17));

		// BaudRateList - Receiving
		String RbaudRateList[] = { "300", "600", "1200", "1800", "2400",
				"4800", "7200", "9600", "14400", "19200", "38400", "57600",
				"115200", "230400", "460800", "921600" };
		RbaudRateComboBox = new JComboBox(RbaudRateList);
		RbaudRateComboBox.setEditable(true);
		RbaudRateComboBox.setSelectedIndex(7);
		RbaudRateComboBox.setPreferredSize(new Dimension(115, 17));

		// Stop bits Combo Box - sending
		String SstopbitsList[] = { "0", "1", "2" };
		SstopbitsComboBox = new JComboBox(SstopbitsList);
		SstopbitsComboBox.setEditable(false);
		SstopbitsComboBox.setSelectedIndex(1);
		SstopbitsComboBox.setPreferredSize(new Dimension(115, 17));

		// Stop bits Combo Box - Receiving
		String RstopbitsList[] = { "0", "1", "2" };
		RstopbitsComboBox = new JComboBox(RstopbitsList);
		RstopbitsComboBox.setEditable(false);
		RstopbitsComboBox.setSelectedIndex(1);
		RstopbitsComboBox.setPreferredSize(new Dimension(115, 17));

		// Parity bits Combo box - Sending
		String SparityBitsList[] = { "0", "1" };
		SparityBitsComboBox = new JComboBox(SparityBitsList);
		SparityBitsComboBox.setEditable(false);
		SparityBitsComboBox.setSelectedIndex(0);
		SparityBitsComboBox.setPreferredSize(new Dimension(115, 17));

		// Parity bits Combo box - Receiving
		String RparityBitsList[] = { "0", "1" };
		RparityBitsComboBox = new JComboBox(RparityBitsList);
		RparityBitsComboBox.setEditable(false);
		RparityBitsComboBox.setSelectedIndex(0);
		RparityBitsComboBox.setPreferredSize(new Dimension(115, 17));

		// Data bits combo box - Sending
		String SdataBitsList[] = { "5", "6", "7", "8" };
		SdataBitsComboBox = new JComboBox(SdataBitsList);
		SdataBitsComboBox.setEditable(false);
		SdataBitsComboBox.setSelectedIndex(3);
		SdataBitsComboBox.setPreferredSize(new Dimension(115, 17));

		// Data bits combo box - Receiving
		String RdataBitsList[] = { "5", "6", "7", "8" };
		RdataBitsComboBox = new JComboBox(RdataBitsList);
		RdataBitsComboBox.setEditable(false);
		RdataBitsComboBox.setSelectedIndex(3);
		RdataBitsComboBox.setPreferredSize(new Dimension(115, 17));

		// Descriptions - Sending
		SportDescription = new JLabel("All the available COM ports");
		SbaudRateDescription = new JLabel(
				"Set the required baudrate. If not in the list, type the baudRate");
		SstopBitsDescription = new JLabel("Set the Stop bits");
		SparityBitsDescription = new JLabel("Set the Parity Bit");
		SdataBitsDescription = new JLabel("Set the data bits to transfer");

		// Descriptions - Sending
		RportDescription = new JLabel("All the available COM ports");
		RbaudRateDescription = new JLabel(
				"Set the required baudrate. If not in the list, type the baudRate");
		RstopBitsDescription = new JLabel("Set the Stop bits");
		RparityBitsDescription = new JLabel("Set the Parity Bit");
		RdataBitsDescription = new JLabel("Set the data bits to receive");

		tabbedPane = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);
		sendingTabbedPanel();
		receivingTabbedPanel();
		add(tabbedPane);

		SsaveSendingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				String port = (String) SportComboBox.getSelectedItem();
				String baudrate = (String) SbaudRateComboBox.getSelectedItem();
				String stopbits = (String) SstopbitsComboBox.getSelectedItem();
				String paritybits = (String) SparityBitsComboBox
						.getSelectedItem();
				String databits = (String) SdataBitsComboBox.getSelectedItem();

				SaveSendParameterEvent event = new SaveSendParameterEvent(
						this, port, baudrate,
						stopbits, paritybits,
						databits);
				
				if(saveSendListener != null){
					saveSendListener.saveSendEventOccured(event);
				}

			}
		});

	}
	
	public void sendingTabbedPanel() {

		sendingPanel = new JPanel(new GridBagLayout());

		sendinglayoutComponents();

		tabbedPane.addTab("Sending Parameters", sendingPanel);

	}

	public void receivingTabbedPanel() {
		receivingPanel = new JPanel(new GridBagLayout());

		receivingLayoutComponents();

		tabbedPane.addTab("Receiving Parameters", receivingPanel);
	}

	/*
	 * This part consists of all the GridBag layout stuffs
	 */
	public void sendinglayoutComponents() {

		GridBagConstraints gc = new GridBagConstraints();

		// First Row - First column
		gc.gridy = 0; // Row
		gc.gridx = 0; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SportLabel, gc);

		// First Row - Second column
		gc.gridy = 0; // Row
		gc.gridx = 1; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SportComboBox, gc);
		// First Row - third column
		gc.gridy = 0; // Row
		gc.gridx = 2; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SportDescription, gc);
		// Second Row - First Column
		gc.gridy = 1; // Row
		gc.gridx = 0; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SbaudRateLabel, gc);

		// Second Row - Second Column
		gc.gridy = 1; // Row
		gc.gridx = 1; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SbaudRateComboBox, gc);

		// Second Row - Third Column
		gc.gridy = 1; // Row
		gc.gridx = 2; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SbaudRateDescription, gc);

		// Third Row - First Column
		gc.gridy = 2; // Row
		gc.gridx = 0; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SstopBitsLabel, gc);
		// Third Row - Second Column
		gc.gridy = 2; // Row
		gc.gridx = 1; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SstopbitsComboBox, gc);

		// Third Row - third Column
		gc.gridy = 2; // Row
		gc.gridx = 2; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SstopBitsDescription, gc);

		// Fourth Row - First Column
		gc.gridy = 3; // Row
		gc.gridx = 0; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SparityBitsLabel, gc);

		// Fourth Row - Second Column
		gc.gridy = 3; // Row
		gc.gridx = 1; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SparityBitsComboBox, gc);

		// Fourth Row - third Column
		gc.gridy = 3; // Row
		gc.gridx = 2; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SparityBitsDescription, gc);

		// Fifth Row - First Column
		gc.gridy = 4; // Row
		gc.gridx = 0; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.01;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SdataBitsLabel, gc);

		// Fifth Row - Second Column
		gc.gridy = 4; // Row
		gc.gridx = 1; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.01;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SdataBitsComboBox, gc);

		// Fifth Row - third Column
		gc.gridy = 4; // Row
		gc.gridx = 2; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.002;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SdataBitsDescription, gc);

		// Sixth Row - First Column
		gc.gridy = 5; // Row
		gc.gridx = 0; // Column
		gc.gridwidth = 3;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		sendingPanel.add(SsaveSendingButton, gc);
	}

	public void receivingLayoutComponents() {

		GridBagConstraints gc = new GridBagConstraints();

		// First Row - First column
		gc.gridy = 0; // Row
		gc.gridx = 0; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RportLabel, gc);

		// First Row - Second column
		gc.gridy = 0; // Row
		gc.gridx = 1; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RportComboBox, gc);
		// First Row - third column
		gc.gridy = 0; // Row
		gc.gridx = 2; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RportDescription, gc);
		// Second Row - First Column
		gc.gridy = 1; // Row
		gc.gridx = 0; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RbaudRateLabel, gc);

		// Second Row - Second Column
		gc.gridy = 1; // Row
		gc.gridx = 1; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RbaudRateComboBox, gc);

		// Second Row - Third Column
		gc.gridy = 1; // Row
		gc.gridx = 2; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RbaudRateDescription, gc);

		// Third Row - First Column
		gc.gridy = 2; // Row
		gc.gridx = 0; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RstopBitsLabel, gc);
		// Third Row - Second Column
		gc.gridy = 2; // Row
		gc.gridx = 1; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RstopbitsComboBox, gc);

		// Third Row - third Column
		gc.gridy = 2; // Row
		gc.gridx = 2; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RstopBitsDescription, gc);

		// Fourth Row - First Column
		gc.gridy = 3; // Row
		gc.gridx = 0; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RparityBitsLabel, gc);

		// Fourth Row - Second Column
		gc.gridy = 3; // Row
		gc.gridx = 1; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RparityBitsComboBox, gc);

		// Fourth Row - third Column
		gc.gridy = 3; // Row
		gc.gridx = 2; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RparityBitsDescription, gc);

		// Fifth Row - First Column
		gc.gridy = 4; // Row
		gc.gridx = 0; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.01;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RdataBitsLabel, gc);

		// Fifth Row - Second Column
		gc.gridy = 4; // Row
		gc.gridx = 1; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.01;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RdataBitsComboBox, gc);

		// Fifth Row - third Column
		gc.gridy = 4; // Row
		gc.gridx = 2; // Column
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.002;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RdataBitsDescription, gc);

		// Sixth Row - First Column
		gc.gridy = 5; // Row
		gc.gridx = 0; // Column
		gc.gridwidth = 3;
		gc.gridheight = 1;
		gc.weightx = 1.0;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		receivingPanel.add(RsaveReceivingButton, gc);
	}
	
	public void setSaveSendEventListener(SaveSendListener listener){
		this.saveSendListener = listener;
	}
}
