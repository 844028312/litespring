package org.liteSpring.core.io;

import java.io.IOException;
import java.io.InputStream;

public interface Resource {
	
	public InputStream getInputStreanm()  throws IOException;
	
	public String getDescription();
}
