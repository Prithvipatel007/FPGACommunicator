package View;

import java.util.EventObject;


public class SaveSendParameterEvent extends EventObject {

	private String SportComboBox;
	private String SbaudRateComboBox;
	private String SstopbitsComboBox;
	private String SparityBitsComboBox;
	private String SdataBitsComboBox;

	public SaveSendParameterEvent(Object source,String SportComboBox ,String SbaudRateComboBox,
			String SstopbitsComboBox, String SparityBitsComboBox, String SdataBitsComboBox) {
		super(source);
		this.SportComboBox = SportComboBox;
		this.SbaudRateComboBox = SbaudRateComboBox;
		this.SstopbitsComboBox = SstopbitsComboBox;
		this.SparityBitsComboBox = SparityBitsComboBox;
		this.SdataBitsComboBox = SdataBitsComboBox;
	}

	public String getSportComboBox() {
		return SportComboBox;
	}

	public void setSportComboBox(String sportComboBox) {
		SportComboBox = sportComboBox;
	}

	public String getSbaudRateComboBox() {
		return SbaudRateComboBox;
	}

	public void setSbaudRateComboBox(String sbaudRateComboBox) {
		SbaudRateComboBox = sbaudRateComboBox;
	}

	public String getSstopbitsComboBox() {
		return SstopbitsComboBox;
	}

	public void setSstopbitsComboBox(String sstopbitsComboBox) {
		SstopbitsComboBox = sstopbitsComboBox;
	}

	public String getSparityBitsComboBox() {
		return SparityBitsComboBox;
	}

	public void setSparityBitsComboBox(String sparityBitsComboBox) {
		SparityBitsComboBox = sparityBitsComboBox;
	}

	public String getSdataBitsComboBox() {
		return SdataBitsComboBox;
	}

	public void setSdataBitsComboBox(String sdataBitsComboBox) {
		SdataBitsComboBox = sdataBitsComboBox;
	}
}
