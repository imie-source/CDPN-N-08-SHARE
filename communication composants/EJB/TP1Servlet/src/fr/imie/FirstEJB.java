package fr.imie;

import java.util.Properties;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Session Bean implementation class FirstEJB
 */
@Stateless
public class FirstEJB implements FirstEJBLocal {

    /**
     * Default constructor. 
     */
    public FirstEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String getHelloMessage() {
		Properties jndiProps = new Properties();
		jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		jndiProps.put(Context.PROVIDER_URL,"http-remoting://192.168.1.49:4447");
		// username
		jndiProps.put(Context.SECURITY_PRINCIPAL, "imieDev");
		// password
		jndiProps.put(Context.SECURITY_CREDENTIALS, "imieDev");
		// create a context passing these properties
		Context ctx = null;
		HelloWorldServiceRemote helloWorldService= null;
		try {
			ctx = new InitialContext(jndiProps);
			helloWorldService  = (HelloWorldServiceRemote) ctx.lookup("java:global/TP1BeanEAR/TP1Bean/HelloWorldService!fr.imie.HelloWorldServiceRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return helloWorldService.getHelloMessage();
		

    
	}

}
