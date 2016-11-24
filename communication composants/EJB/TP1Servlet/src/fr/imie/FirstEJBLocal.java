package fr.imie;

import javax.ejb.Local;

@Local
public interface FirstEJBLocal {
	String getHelloMessage();
}
