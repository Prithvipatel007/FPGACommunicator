package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class AboutDialogBox extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea dialogTextArea;
	
	public AboutDialogBox(){
		super();
		setTitle("About");
		setTitle("About");
		setSize(new Dimension(350, 150));
		setLocation(new Point(700, 450));
		
		setLayout(new BorderLayout());
		
		dialogTextArea = new JTextArea(20, 20);
		dialogTextArea.setEditable(false);
		dialogTextArea.setWrapStyleWord(true);
		dialogTextArea.setText(	"\n FPGA Communicator and debugger Tool \n \n \n " +
								"This tool is responsible for the communication and \n" +
								"debugging the FPGA via USB or Virtual COM port ");
		
		add(dialogTextArea, BorderLayout.CENTER);
	}
}
