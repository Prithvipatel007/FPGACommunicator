package View;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class BinaryFileFilter extends FileFilter {

	@Override
	public boolean accept(File file) {
		
		String name = file.getName();
		
		if(file.isDirectory()){return true;}
		
		String extension = Utils.getFileExtension(name);
		
		if(extension == null){
			return false;
		}
		
		if(extension.equals("bin")){
			return true;
		}
		
		return false;
	}

	@Override
	public String getDescription() {
		return "Binary File (*.bin)";
	}

}
