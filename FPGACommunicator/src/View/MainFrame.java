package View;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import Communication.Communication;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import Controller.Controller;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu settingsMenu;
	private JMenu windowMenu;
	private JMenuItem save_message_File;
	private JMenuItem openBinFile;
	private JMenuItem exitMenuItem;
	private JMenuItem Configurations;
	private JFileChooser fileChooser;
	private JMenuItem HelpManual;
	private JMenuItem aboutMenuItem;
	private Controller controller;
	private DataWindowPanel dataWindowPanel;
	private LogWindowPanel logWindowPanel;
	private String content;
	private Communication communication;
	private AboutDialogBox aboutDialog;
	private ConfigurationDialogBox configurationDialogBox;
	
	
	/*
	 * 
	 * sending parameters
	 */
	private String Sport;
	private String Sbaudrate;
	private String Sstopbits;
	private String Sparitybits;
	private String Sdatabits;
	
	public MainFrame(String readDataContent){
		dataWindowPanel = new DataWindowPanel(1);
		dataWindowPanel.setReadString(readDataContent);
	}
	
	public MainFrame() {

		// Initialize the main frame
		super("FPGA Communicator and Debugger");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(new Dimension(1000, 650));
		setLocation(new Point(300, 250));

		setMinimumSize(new Dimension(1000, 650));

		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new BinaryFileFilter());

		controller = new Controller();

		// setMaximumSize(new Dimension(850,750));

		setJMenuBar(createMenuBar());

		dataWindowPanel = new DataWindowPanel();
		logWindowPanel = new LogWindowPanel();

		add(dataWindowPanel, BorderLayout.CENTER);
		add(logWindowPanel, BorderLayout.SOUTH);
		
		//communication = new Communication();
		//communication.readDataFromSerialPort();
		
		dataWindowPanel.setHexFileListener(new SendHexFileListener() {
			@SuppressWarnings("unused")
			@Override
			public void sendHexFileActionPerformed(
					SendHexFileEvent sendHexFileEvent) {

				String content = sendHexFileEvent.getContent();
				controller.setTextForCommunication(content);
				communication = new Communication(content, Sport, Sbaudrate,
						Sstopbits, Sparitybits, Sdatabits);
				
				communication.convCharArraytoIntArray(); // conversion from char array to int
														// array is performed
				
				communication.countHexTest(); 			// just to test the number of characters
				
				communication.performCalcfor8bits(); 	// combining 1st and 2nd hex value in each
														// line and making it as 8bits or 1 byte
				
				communication.convertIntByteArray(); // converting the integer into bytes
				
				try {
					communication.sendDataToComPort();		// function to send the Hex Data
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				logWindowPanel.setStringToLogWindow(communication
						.getLogStatements());
			}
		});
		
		
		
	}

	private JMenuBar createMenuBar() {

		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		settingsMenu = new JMenu("Settings");
		windowMenu = new JMenu("Window");

		// Inside file menu
		save_message_File = new JMenuItem("Save Message File");
		openBinFile = new JMenuItem("Open Binary File");
		exitMenuItem = new JMenuItem("Exit");

		// Inside Setting menu
		Configurations = new JMenuItem("Configurations");

		// Inside Window Menu
		HelpManual = new JMenuItem("Help");
		aboutMenuItem = new JMenuItem("About");

		fileMenu.add(save_message_File);
		fileMenu.add(openBinFile);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);

		settingsMenu.add(Configurations);

		windowMenu.add(HelpManual);
		windowMenu.add(aboutMenuItem);

		menuBar.add(fileMenu);
		menuBar.add(settingsMenu);
		menuBar.add(windowMenu);
		configurationDialogBox = new ConfigurationDialogBox(MainFrame.this,
				"Configurations");

		performMenuItemActionListeners();

		return menuBar;
	}

	public void performMenuItemActionListeners() {

		// exit Action Listener and Accelerator key

		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));

		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int action = JOptionPane
						.showConfirmDialog(
								MainFrame.this,
								"Do you really want to Exit? \n \n Note : Make sure "
										+ "you save the data. It will be gone once you exits! \n ",
								"Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}

			}
		});

		// save COM Message file

		save_message_File.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));

		save_message_File.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						// System.out.println(dataWindowPanel.getComMessagesTextArea());
						controller.saveFileDataToFile(
								fileChooser.getSelectedFile(),
								dataWindowPanel.getComMessagesTextArea());

					} catch (IOException e) {
						JOptionPane.showMessageDialog(MainFrame.this,
								"Could not save data to file", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});

		// load a binary file
		openBinFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));

		openBinFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						controller.openFile(fileChooser.getSelectedFile());
						content = controller.getDataFromController();
						dataWindowPanel.setDataToTextArea(content);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(MainFrame.this,
								"Could not load data from file", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		// about dialog box
		aboutMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				try {
					aboutDialog = new AboutDialogBox();
					aboutDialog.setVisible(true);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"There is some problem in the about "
									+ "menu ActionEvent Listeners");
				}

			}
		});

		Configurations.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				configurationDialogBox.setVisible(true);
			}
		});

		// Save sending parameters button
		configurationDialogBox.setSaveSendEventListener(new SaveSendListener() {

			@Override
			public void saveSendEventOccured(SaveSendParameterEvent event) {

				Sport = event.getSportComboBox();
				Sbaudrate = event.getSbaudRateComboBox();
				Sstopbits = event.getSstopbitsComboBox();
				Sparitybits = event.getSparityBitsComboBox();
				Sdatabits = event.getSdataBitsComboBox();

			}
		});

	}
}