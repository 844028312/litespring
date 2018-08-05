package org.liteSpring.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.liteSpring.util.Assert;

public class FileSystemResource implements Resource{
	
	private File file;
	public FileSystemResource(String fileName){
		Assert.notNull(fileName, "path must not be null");
		file=new File(fileName);
	}

	public InputStream getInputStreanm() throws IOException {
		
		return new FileInputStream(file);
		
		
	}

	public String getDescription() {
		
		return "fileName:"+file.getAbsolutePath();
	}

}
