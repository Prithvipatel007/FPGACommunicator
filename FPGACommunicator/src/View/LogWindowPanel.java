package View;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LogWindowPanel  extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea logTextArea;
	public LogWindowPanel(){
		
		setLayout(new BorderLayout());
		
		logTextArea = new JTextArea(10, 10);
		logTextArea.setEditable(false);
		logTextArea.setBackground(Color.BLACK);
		logTextArea.setForeground(Color.GREEN);
		logTextArea.append("Airbus Defence and space : FPGA Communicator and Debugger");
		
		
		JScrollPane scrollPane = new JScrollPane(logTextArea);
		
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	public void setStringToLogWindow(String string){
		logTextArea.append("\n" + string);
	}
}
