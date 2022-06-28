package View;

import java.util.EventObject;

public class SaveReceiveParameterEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	
	private String RportComboBox;
	private String RbaudRateComboBox;
	private String RstopbitsComboBox;
	private String RparityBitsComboBox;
	private String RdataBitsComboBox;
	
	public SaveReceiveParameterEvent(Object source, String RportComboBox,
			String RbaudRateComboBox, String RstopbitsComboBox,
			String RparityBitsComboBox, String RdataBitsComboBox) {
		
		super(source);
		this.RportComboBox = RportComboBox;
		this.RbaudRateComboBox = RbaudRateComboBox;
		this.RstopbitsComboBox = RstopbitsComboBox;
		this.RparityBitsComboBox = RparityBitsComboBox;
		this.RdataBitsComboBox = RdataBitsComboBox;
	}

	public String getRportComboBox() {
		return RportComboBox;
	}

	public void setRportComboBox(String rportComboBox) {
		RportComboBox = rportComboBox;
	}

	public String getRbaudRateComboBox() {
		return RbaudRateComboBox;
	}

	public void setRbaudRateComboBox(String rbaudRateComboBox) {
		RbaudRateComboBox = rbaudRateComboBox;
	}

	public String getRstopbitsComboBox() {
		return RstopbitsComboBox;
	}

	public void setRstopbitsComboBox(String rstopbitsComboBox) {
		RstopbitsComboBox = rstopbitsComboBox;
	}

	public String getRparityBitsComboBox() {
		return RparityBitsComboBox;
	}

	public void setRparityBitsComboBox(String rparityBitsComboBox) {
		RparityBitsComboBox = rparityBitsComboBox;
	}

	public String getRdataBitsComboBox() {
		return RdataBitsComboBox;
	}

	public void setRdataBitsComboBox(String rdataBitsComboBox) {
		RdataBitsComboBox = rdataBitsComboBox;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
