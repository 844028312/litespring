package org.liteSpring.beans.support;

import org.liteSpring.beans.BeanDefination;

public class GenericBeanDefinition implements BeanDefination{
	
	private String id;
	
	private String name;
	

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
