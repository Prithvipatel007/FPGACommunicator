package Communication;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.swing.JOptionPane;

import View.MainFrame;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class Communication {

	private String hexData;
	private char[] hexDataArray;
	private int[] hexIntArray;
	private int[] hexIntbit8Array;
	private ByteBuffer byteBuffer;
	private IntBuffer intBuffer;
	private byte[] byteArray;
	private String logStatements;
	private String[] readDataToString;
	private String[] formattedReadDataString;

	/*
	 * sending parameters
	 */
	private String Sport;
	private int SbaudRate;
	private int Sstopbits;
	private int Sparitybits;
	private int Sdatabits;

	/*
	 * Receiving parameters
	 */
	private String Rport;
	private int RbaudRate;
	private int Rstopbits;
	private int Rparitybits;
	private int Rdatabits;

	public Communication() {
	}

	public Communication(String hexData, String Sport, String sbaudrate,
			String Sstopbits, String SparityBits, String Sdatabits) {

		try {
			this.hexData = hexData;
			hexDataArray = this.hexData.replaceAll("\\s", "").toCharArray();
			hexIntArray = new int[hexDataArray.length];
			hexIntbit8Array = new int[hexIntArray.length / 2];
			this.Sport = Sport;
			this.SbaudRate = Integer.parseInt(sbaudrate);
			this.Sstopbits = Integer.parseInt(Sstopbits);
			this.Sparitybits = Integer.parseInt(SparityBits);
			this.Sdatabits = Integer.parseInt(Sdatabits);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"The default values has been set to the Parameters");
			this.Sport = "COM4";
			this.SbaudRate = 9600;
			this.Sstopbits = 1;
			this.Sparitybits = 0;
			this.Sdatabits = 8;
		}
		readDataFromSerialPort();

	}

	/*
	 * Writing data to COM port
	 */
	public void sendDataToComPort() throws IOException, InterruptedException {

		SerialPort serialPort = SerialPort.getCommPort(Sport); // device name
		System.out.println("Serial Com Port connected");
		/*
		 * This method is responsible for setting up the parameters :
		 * 
		 * serialPort.setComPortParameters( int newBaudRate, int newDataBits,
		 * int newStopbits, int newParity)
		 */
		serialPort.setComPortParameters(SbaudRate, Sdatabits, Sstopbits,
				Sparitybits);
		System.out.println("serial parameters has been set!!");

		/*
		 * This method sets the serial port read and write timeout parameters
		 * 
		 * serilPort.setComPortTimeout( int newTimeoutMode, int newReadTimeout,
		 * int newWriteTimeout)
		 * 
		 * it blocks until bytes can be written
		 */
		serialPort.setComPortTimeouts(serialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

		try {
			if (serialPort.openPort()) {
				System.out.println("Port is open ----------------------------");
				setLogStatements("\n Port is open ----------------------------");
			} else {
				System.out
						.println("Failed to open port!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				setLogStatements("\n Failed to open port!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("data transfer started!!!");
		long startTime = System.currentTimeMillis();

		for (Integer i = 0; i < byteArray.length; i++) {
			serialPort.getOutputStream().write(byteArray[i]);
			//System.out.println("Sending  : " + byteArray[i]);
			serialPort.getOutputStream().flush();
			// System.out.println("Send number: " + byteArray[i]);
			// setLogStatements("\n Send number: " + byteArray[i]);
			// Thread.sleep((long) 0.001);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("data transfer ended!!");
		long timeTaken = (endTime - startTime);
		long minutes = (timeTaken / 1000) / 60;
		int seconds = (int) ((timeTaken / 1000) % 60);
		System.out.println("\nData Transfer execution time : " + timeTaken
				+ " ms " + " :  " + minutes + " minutes " + seconds
				+ " seconds ");

		if (serialPort.closePort()) {
			System.out
					.println("Port is closed---------------------------------");
			setLogStatements("\n Port is closed---------------------------------");
		} else {
			System.out
					.println("Failed to close port!!!!!!!!!!!!!!!!!!!!!!!!!!");
			setLogStatements("\n Failed to close port!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}

		setLogStatements("\n All the data from the file data have been written to the COM port : "
				+ serialPort.getSystemPortName());
	}
	
	public void readDataFromSerialPort(){
		final SerialPort readPort = SerialPort.getCommPort("COM6");
		readPort.openPort();
		readPort.addDataListener(new SerialPortDataListener() {
			
			@Override
			public void serialEvent(SerialPortEvent event) {
				
				if(event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE){
					return;
				}
				byte[] hexData = new byte[readPort.bytesAvailable()];
				int numRead = readPort.readBytes(hexData, hexData.length);
				readDataToString = new String[hexData.length];
				formattedReadDataString = new String[hexData.length];
				for(int i=0; i<hexData.length; i++){
					readDataToString[i] = Integer.toHexString(hexData[i]);
					if(readDataToString[i].length() == 2 ){
						formattedReadDataString[i] = readDataToString[i];
						try{
							MainFrame mainFrame = new MainFrame(formattedReadDataString[i]);	
						}
						catch(Exception e){
							System.out.println("The mainframe second construction from communication diudn't work");
						}
						System.out.println(formattedReadDataString[i] + " from " + readDataToString[i]);
						
					}else if(readDataToString[i].length() == 8){
						formattedReadDataString[i] = readDataToString[i].substring(6);
						try{
							MainFrame mainFrame = new MainFrame(formattedReadDataString[i]);	
						}
						catch(Exception e){
							System.out.println("The mainframe second construction from communication diudn't work");
						}
						System.out.println(formattedReadDataString[i] + " from " + readDataToString[i]);
					}
				}
				
			}
			
			@Override
			public int getListeningEvents() {
				return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
			}
		});
	}
	
	public void setLogStatements(String string) {
		this.logStatements += string;
	}

	public String getLogStatements() {
		return this.logStatements;
	}

	public void convertIntByteArray() {
		System.out.println("Conversion from Integer to Bytes started");
		byteArray = new byte[hexIntbit8Array.length];
		for (int i = 0; i < hexIntbit8Array.length; i++) {
			byteArray[i] = (byte) hexIntbit8Array[i];
			// System.out.println(i + " : " + "Int Value : " +
			// hexIntbit8Array[i] + "  ->   Byte value : " + byteArray[i] );
			// setLogStatements("\n" + i + " : " +" Int Value : " +
			// hexIntbit8Array[i] + "  ->   Byte value : " + byteArray[i]);
		}

		System.out.println("conversion from Integer to Byes finished");
	}

	public void convertIntByteArray1() { // this methods was created just to
											// check all the byte values

		int i, aux;
		byte b;

		for (i = 0; i < 256; i++) {

			b = (byte) i;
			if (b < 0) {
				aux = 256 + b;
			} else {
				aux = b;
			}
			String s = String.format("%8s", Integer.toBinaryString(b & 0xFF))
					.replace(' ', '0');
			System.out.println("Original int value : " + i
					+ " casted to byte : " + b
					+ " converted integer from byte " + aux
					+ "Binary from byte : " + s);
		}

	}

	public void performCalcfor8bits() {
		int wrptr = 0;
		for (int i = 0; i < hexIntArray.length; i += 2) {

			int msb = hexIntArray[i];
			int lsb = hexIntArray[i + 1];
			int bit8 = (msb * 16) + lsb;
			// hexIntbit8Array[i] = bit8;
			hexIntbit8Array[wrptr] = bit8;
			wrptr++;
			// System.out.println(hexIntbit8Array[i]);
		}
	}

	public void countHexTest() {
		int count1 = 0;
		for (int i = 0; i < hexIntArray.length; i++) {
			// System.out.println(hexIntArray[i]);
			count1++;
		}
		System.out.println("Integer hex array : " + count1);

		int count2 = 0;
		for (int i = 0; i < hexDataArray.length; i++) {
			count2++;
		}
		System.out.println("Character Hex Array : " + count2);
	}

	public void convCharArraytoIntArray() {

		for (int i = 0; i < hexDataArray.length; i++) {

			if (hexDataArray[i] == '0') {
				hexIntArray[i] = 0;
			} else if (hexDataArray[i] == '1') {
				hexIntArray[i] = 1;
			} else if (hexDataArray[i] == '2') {
				hexIntArray[i] = 2;
			} else if (hexDataArray[i] == '3') {
				hexIntArray[i] = 3;
			} else if (hexDataArray[i] == '4') {
				hexIntArray[i] = 4;
			} else if (hexDataArray[i] == '5') {
				hexIntArray[i] = 5;
			} else if (hexDataArray[i] == '6') {
				hexIntArray[i] = 6;
			} else if (hexDataArray[i] == '7') {
				hexIntArray[i] = 7;
			} else if (hexDataArray[i] == '8') {
				hexIntArray[i] = 8;
			} else if (hexDataArray[i] == '9') {
				hexIntArray[i] = 9;
			} else if (hexDataArray[i] == 'A') {
				hexIntArray[i] = 10;
			} else if (hexDataArray[i] == 'B') {
				hexIntArray[i] = 11;
			} else if (hexDataArray[i] == 'C') {
				hexIntArray[i] = 12;
			} else if (hexDataArray[i] == 'D') {
				hexIntArray[i] = 13;
			} else if (hexDataArray[i] == 'E') {
				hexIntArray[i] = 14;
			} else if (hexDataArray[i] == 'F') {
				hexIntArray[i] = 15;
			} else {
				hexIntArray[i] = 200000;
			}
		}

	}

}
