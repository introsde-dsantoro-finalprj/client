package introsde.dsantoro.client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import introsde.dsantoro.dbws.Person;
import introsde.dsantoro.pcws.Pcws;

public class Client {

	Pcws pcws;
	Person person= null;

	private static final String RET = "\n";
	private static final String TAB = "\t";
	private static final String DASHBOARDMENU_MSG = "--> Please tell me if you want to" + RET
			+ TAB + "[I]nsert a Person" + RET
			+ TAB + "[W]ork on Person in the session" + RET
			+ TAB + "[A]dmin menu" + RET
			+ TAB + "[Q]uit" + RET;
	private static final String QUIT_MSG = "Quitting. Remember to eat healthy !!!";
	public Client(Pcws pcws) {
		this.pcws = pcws;
		dashboardMenu();
	}



	private void dashboardMenu() {
		int ch;
		boolean quit = false;
		
		System.out.println(DASHBOARDMENU_MSG);
		
		try {
			while ( ((ch = System.in.read()) != -1) && (quit == false) ) {                
				if (ch != '\n' && ch != '\r') {                    
					switch((char)ch){
					case 'i':
					case 'I':
						insertPerson();
						break;
					case 'w':
					case 'W':
						if (person == null) {
							insertPerson();
						}
						workOnPersonMenu();
						break;
					case 'a':
					case 'A':
						adminMenu();
						break;
					case 'q':
					case 'Q':
						System.out.println(QUIT_MSG);
						quit = true;
						break;                    
					}
					if (!quit) System.out.println(DASHBOARDMENU_MSG);
				}

			}
		} catch (IOException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}

	}



	private void adminMenu() {
		// TODO Auto-generated method stub

	}



	private void workOnPersonMenu() {
		// TODO Auto-generated method stub

	}



	private void insertPerson() {
		// TODO Auto-generated method stub

	}
}
