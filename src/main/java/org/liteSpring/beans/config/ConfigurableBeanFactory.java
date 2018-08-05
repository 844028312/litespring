package org.liteSpring.beans.config;

import org.liteSpring.beans.BeanFactory;

public interface ConfigurableBeanFactory extends BeanFactory{

	public ClassLoader getClassLoader();
	
	public void setClassLoader(ClassLoader loader);
}
