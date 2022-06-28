/*
 *  This Program is basically responsible for communication with FPGAs via COM port as well as USB-port
 *  which allows user to fill up the FPGA's DDR RAM over a Virtual COM-port as well as USB port.
 */


package View;

import javax.swing.SwingUtilities;

public class FPGACommunicatorApp {
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {		
			
			@Override
			public void run() {	
				
				MainFrame mainFrame = new MainFrame();		// Initialize the main frame of the GUI
				mainFrame.setVisible(true);
			}
		});
	}
	
}
