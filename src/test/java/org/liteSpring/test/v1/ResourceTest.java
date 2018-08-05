package org.liteSpring.test.v1;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.liteSpring.core.io.ClassPathResource;
import org.liteSpring.core.io.Resource;
import org.liteSpring.core.io.FileSystemResource;

public class ResourceTest {
	
	@Test
	public void classPathResource(){
		Resource resource=new ClassPathResource("petStore_v1.xml");
		
		try {
			Assert.assertNotNull(resource.getInputStreanm());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void FileSystemResource(){
		Resource resource=new FileSystemResource("E:\\dev\\petStore_v1.xml");
		
		try {
			Assert.assertNotNull(resource.getInputStreanm());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
