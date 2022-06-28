package Controller;

import java.io.File;
import java.io.IOException;

import Model.Database;


public class Controller {
	
	private String hexData;
	
	public Controller(){
	}
	Database db = new Database();
	
	public void saveFileDataToFile(File file, String content) throws IOException{
		db.saveToFile(file, content);
	}
	
	public void openFile(File file) throws Exception{
		db.openFile(file);
	}
	
	public String getDataFromController(){
		return db.content;
	}
	
	public void setTextForCommunication(String hexData){
		this.hexData = hexData;
	}
	
	public String getTextForCommunication(){
		return this.hexData;
	}
}
