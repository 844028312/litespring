package org.liteSpring.beans.support;

import org.liteSpring.beans.BeanDefinition;

public class GenericBeanDefinition implements BeanDefinition{
	
	
	private String id;
	
	private String name;
	
	private String scope=SCOPE_DEFAULT;
	
	private boolean isSingleton=true;
	
	private boolean isPrototype=false;
	
	public GenericBeanDefinition(String id,String name){
		this.id=id;
		this.name=name;
	}
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
		isSingleton=SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
		isPrototype=SCOPE_PROTOTYPR.equals(scope);
	}
	public String getBeanClassName(){
		return name;
	}
	
	public boolean isSingleton() {
	
		return isSingleton;
	}
	public boolean isPrototype() {
		
		return isPrototype;
	}
}
