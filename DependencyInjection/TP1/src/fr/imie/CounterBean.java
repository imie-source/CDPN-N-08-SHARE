package fr.imie;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CounterBean implements CounterBeanInterface {
	private Integer count =3;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}
