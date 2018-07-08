package org.liteSpring.beans.support;

import org.liteSpring.beans.BeansException;

public class BeanCreationException extends BeansException{

	public BeanCreationException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeanCreationException(String message) {
		super(message);
	}
}
