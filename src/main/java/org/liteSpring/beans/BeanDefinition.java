package org.liteSpring.beans;

public interface BeanDefinition {
	public static final String SCOPE="scope";
	public static final String SCOPE_SINGLETON="singleton";
	
	public static final String SCOPE_PROTOTYPR="prototype";
	
	public static final String SCOPE_DEFAULT="";
	
	public String getBeanClassName();
	
	public void  setScope(String scope);
	
	public String  getScope();
	
	public boolean isSingleton();
	
	public boolean isPrototype();
}
