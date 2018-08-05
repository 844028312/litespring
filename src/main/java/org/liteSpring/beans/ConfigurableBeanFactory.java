package org.liteSpring.beans;

public interface ConfigurableBeanFactory extends BeanFactory{

	public ClassLoader getClassLoader();
	
	public void setClassLoader(ClassLoader loader);
}
