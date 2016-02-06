package introsde.dsantoro.client;

import java.net.MalformedURLException;
import java.net.URL;

import introsde.dsantoro.pcws.Pcws;
import introsde.dsantoro.pcws.PcwsService;

public class ClientStarter {

	public static void main(String[] args) throws MalformedURLException {
		final String PCWS_ENDPOINT = System.getenv("PCWS_ENDPOINT");
		final String PCWS_PORT = System.getenv("PCWS_PORT");
		
		if ( (PCWS_ENDPOINT != null) && (PCWS_PORT != null) ) {
        	// Proceed with connection to Process Centric service
			String pcwsURL = "http://"+PCWS_ENDPOINT+":"+PCWS_PORT+"/ws/pcws?wsdl";
			System.out.println("Pcws config: Got a valid endpoint: " + pcwsURL);
			PcwsService pcwsService = new PcwsService(new URL(pcwsURL));		
			Pcws pcws = pcwsService.getPcwsImplPort();			
			System.out.println("--> Connected. Starting client...");
			new Client(pcws);
        }
        else {
        	// Variables not set: cannot connect to Process Centric service
        	System.out.println("--> ERROR: Endpoint not set. Check the following env variables:");
        	System.out.println("----> PCWS_ENDPOINT: " + PCWS_ENDPOINT); 
        	System.out.println("----> PCWS_PORT: " + PCWS_PORT);
        }
				
	}

}
