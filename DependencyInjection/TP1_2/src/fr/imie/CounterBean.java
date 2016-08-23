package fr.imie;

import java.io.Serializable;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;


@SessionScoped
@Named("test")
public class CounterBean implements Serializable, CounterBeanInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3199257064255841995L;
	
	private Integer count =0;
	

	@Override
	public Integer getCount() {
		return count;
	}

	@Override
	public void increment() {
		count++;
		
	}
	
}
