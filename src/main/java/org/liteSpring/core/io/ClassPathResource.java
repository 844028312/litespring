package org.liteSpring.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.liteSpring.util.ClassUtils;

public class ClassPathResource implements Resource{
	
	private ClassLoader loader;
	
	private String path;
	
	public ClassPathResource(String path){
		this(path,null);
	}
	
	public ClassPathResource(String path,ClassLoader loader){
		this.loader=loader==null?ClassUtils.getDefaultClassload():loader;
		this.path=path;
	}

	
	public InputStream getInputStreanm() throws IOException {
		
		InputStream is= loader.getResourceAsStream(path);
		
		if(is==null){
			throw new FileNotFoundException(path+"cannot be opened");
		}
		return is;
	}

	public String getDescription() {
		
		return "classPath:"+path;
	}

}
