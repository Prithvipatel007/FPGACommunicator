package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class DataWindowPanel extends JPanel{

	
	private static final long serialVersionUID = 1L;
	
	// Initializing the components
	private JLabel fileDataLabel;
	private JButton clearfileButton;
	private JTextArea fileDataTextArea;
	private JLabel hexLabel;
	private JTextField hexTextField;
	private JLabel dataWindowLabel;
	private JButton sendFileButton;
	private JButton sendHexButton;
	private JLabel comMessageLabel;
	private JButton clearComMessageButton;
	public JTextArea comMessageTextArea;
	private String content;
	private SendHexFileEvent sendHexFileEvent;
	private JLabel receiveLabel;
	//private ToggleSwitch toggleSwitch;
	private JToggleButton receiveToggle;
	private SendHexFileListener sendHexFileListener;
//	public String content1;
	
	public DataWindowPanel(int i){
		
	}
	
	public DataWindowPanel() {

		
		// Declaring the components
		fileDataLabel = new JLabel("File Data :");
		clearfileButton = new JButton("Clear File Data");
		fileDataTextArea = new JTextArea(30, 30);
		fileDataTextArea.setEditable(true);
		//fileDataTextArea.setLineWrap(true);
		hexLabel = new JLabel("HEX Value: ");
		receiveLabel = new JLabel("Receive : ");
		hexTextField = new JTextField(10);
		dataWindowLabel = new JLabel("Data Window");
		sendFileButton = new JButton("Send File");
		sendHexButton = new JButton("Send Hex");
		//toggleSwitch = new ToggleSwitch();
		receiveToggle = new JToggleButton(" Receive ", false);
		comMessageLabel = new JLabel("COM Messages - received");
		clearComMessageButton = new JButton("Clear COM Panel");
		comMessageTextArea = new JTextArea(30, 30);
		setLayoutComponents();
		
		clearfileButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				fileDataTextArea.setText("");
			}
		});
		
		clearComMessageButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				comMessageTextArea.setText("");
				
			}
		});
		
		sendFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				
				String content = fileDataTextArea.getText();
				sendHexFileEvent = new SendHexFileEvent(event, content);
				if(sendHexFileListener != null){
					sendHexFileListener.sendHexFileActionPerformed(sendHexFileEvent);
				}
			}
		});
	}
	
	
	public void setReadString(String readContent){
		comMessageTextArea.append(readContent + "\n");
	}
	
	public String getComMessagesTextArea(){

		return comMessageTextArea.getText();
	}
	
	public void setDataToTextArea(String content){
		this.content = content;
		fileDataTextArea.append(this.content);
	}

	public void setLayoutComponents() {

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// First Row - First Column
		gc.gridy = 0;
		gc.gridx = 0;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(fileDataLabel, gc);

		// First Row - third Column
		gc.gridy = 0;
		gc.gridx = 4;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.01;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		add(clearfileButton, gc);

		// Second Row - 1/2/3 Columns because it's a text Area and it requires
		// to consume almost 3 columns
		gc.gridy = 1;
		gc.gridx = 0;
		gc.gridwidth = 5;
		gc.gridheight = 3;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(new JScrollPane(fileDataTextArea), gc);
		
		// third row - first column
		gc.gridy = 4;
		gc.gridx = 0;
		gc.gridwidth = 5;
		gc.gridheight = 3;
		gc.weightx = 1;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(hexLabel, gc);
		
		// third row - first to fifth column
		gc.gridy = 4;
		gc.gridx = 1;
		gc.gridwidth = 5;
		gc.gridheight = 3;
		gc.weightx = 3;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(hexTextField, gc);
		
		// first row - 6th column - Data window Label
		gc.gridy = 1;
		gc.gridx = 6;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(dataWindowLabel, gc);
		
		// third row - sixth column  - send file button
		gc.gridy = 3;
		gc.gridx = 6;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		add(sendFileButton, gc);
		
		// fourth row - sixth column - send hex file 
		gc.gridy = 4;
		gc.gridx = 6;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.PAGE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		add(sendHexButton, gc);
		
		// 0th row, 9th column - com message label
		gc.gridy = 0;
		gc.gridx = 8;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(comMessageLabel, gc);
		
		// 1st row - 9th column - com message text area
		gc.gridy = 1;
		gc.gridx = 8;
		gc.gridwidth = 3;
		gc.gridheight = 3;
		gc.weightx = 1;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(new JScrollPane(comMessageTextArea), gc);
		
		//// 2nd row - 8th Column - start/Stop receiving button
		gc.gridy = 4;
		gc.gridx = 8;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 0.00000001;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(5, 5, 5, 5);
		add(receiveToggle, gc);
		
		// 0th row - 10th column
		gc.gridy = 0;
		gc.gridx = 10;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 0.001;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(5, 5, 5, 5);
		add(clearComMessageButton, gc);
		
	}
	public void setClearFile(){
		clearfileButton.setText("");
	}
	
	public void setHexFileListener(SendHexFileListener sendHexFileListener){
		this.sendHexFileListener = sendHexFileListener;
	}
}
