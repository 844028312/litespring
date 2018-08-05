package org.liteSpring.beans.support;

import org.liteSpring.beans.BeanDefinition;

public class GenericBeanDefinition implements BeanDefinition{
	
	
	private String id;
	
	private String name;
	

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


	public String getBeanClassName(){
		return name;
	}
}
