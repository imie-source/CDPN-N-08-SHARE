package fr.imie;


import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorldService
 */
@Stateless
@Remote(HelloWorldServiceRemote.class)
public class HelloWorldService implements HelloWorldServiceRemote {

    /**
     * Default constructor. 
     */
    public HelloWorldService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String getHelloMessage() {
		return "Hello World";
	}
	

}
