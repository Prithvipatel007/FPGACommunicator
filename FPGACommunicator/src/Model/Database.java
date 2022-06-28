package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Database {
	public String content;
	
	public Database(){
		
	}
	
	public void saveToFile(File file, String content) throws IOException {
		FileWriter fileWriter = new FileWriter(file.getPath());
		fileWriter.write(content);
		fileWriter.flush();
		fileWriter.close();
		content = null;
	}

	public void openFile(File file) {
		
		this.content = usingBufferedReader(file.getPath());
	}
	
	private static String usingBufferedReader(String filePath){
		StringBuilder contentBuilder = new StringBuilder();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			
			String sCurrentLine;
			while((sCurrentLine = br.readLine()) != null){
				contentBuilder.append(sCurrentLine).append("\n");
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return contentBuilder.toString();
	}

}
