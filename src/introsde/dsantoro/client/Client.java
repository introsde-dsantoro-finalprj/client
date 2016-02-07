package introsde.dsantoro.client;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import introsde.dsantoro.dbws.Person;
import introsde.dsantoro.pcws.Pcws;

public class Client {

	Pcws pcws;
	Person person = null;
	Scanner scanner;

	private final String RET = "\n";
	private final String TAB = "\t";

	private static final String QUIT_MSG = "Quitting. Remember to eat healthy !!!";
	
	
	public Client(Pcws pcws) {
		this.pcws = pcws;
		scanner = new Scanner(System.in);
		dashboardMenu();
	}



	private String getPersonId() {
		return (person == null) ? "NOT YET SET" : person.getId().toString();  
	}

	private void dashboardMenu() {
		int ch;
		boolean quit = false;
		
		dashboardMenuMsg();
		
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
						scanner.close();
						break;                    
					}
					if (!quit) dashboardMenuMsg();
				}

			}
		} catch (IOException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}

	}



	private void dashboardMenuMsg() {
		System.out.println(
				"--> Please tell me if you want to" + RET
				+ TAB + "[I]nsert a Person" + RET
				+ TAB + "[W]ork on Person in the session ("+ getPersonId() + ")" + RET
				+ TAB + "[A]dmin menu" + RET
				+ TAB + "[Q]uit" + RET
				);
	}



	private void adminMenu() {
		// TODO Auto-generated method stub

	}



	private void workOnPersonMenu() {
		// TODO Auto-generated method stub

	}



	private void insertPerson() {		
		try {
			Person p = new Person();
			System.out.println("--> Please inser Person details:");
			System.out.println(TAB + "Firstname: ");		
			p.setFirstname(scanner.next());
			System.out.println(TAB + "Lastname: ");
			p.setLastname(scanner.next());
			//System.out.println(TAB + "Birthday: ");
			//p.setBirthday(scanner.next());
			System.out.println(TAB + "email: ");
			p.setEmail(scanner.next());
			System.out.println(TAB + "weight: ");
			p.setWeight(scanner.next());
			System.out.println(TAB + "height: ");
			p.setHeight(scanner.next());
			System.out.println(TAB + "Calories burned per day: ");
			p.setDaycalories(scanner.nextInt());		
			person = pcws.createPerson(p);		
			System.out.println("--> Person created.");	
		} catch (InputMismatchException e) {
			System.err.println("--> Person not created. Check last inserted value.");
		}
		
		
	}
}
