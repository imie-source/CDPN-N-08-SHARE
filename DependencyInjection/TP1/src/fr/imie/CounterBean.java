package fr.imie;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CounterBean implements CounterBeanInterface {
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
