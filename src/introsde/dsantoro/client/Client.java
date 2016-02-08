package introsde.dsantoro.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.json.JSONObject;

import introsde.dsantoro.dbws.Activity;
import introsde.dsantoro.dbws.Goal;
import introsde.dsantoro.dbws.Meal;
import introsde.dsantoro.dbws.Person;
import introsde.dsantoro.pcws.Pcws;

public class Client {

	Pcws pcws;
	Person person = null;
	Scanner scanner;

	private final String RET = "\n";
	private final String TAB = "\t";

	private static final String QUIT_MSG = "--> Quitting. Remember to eat healthy !!!";
	private static final String BACK_MSG = "--> Going back to previous menu";
	
	
	public Client(Pcws pcws) {
		this.pcws = pcws;		
		scanner = new Scanner(System.in);
		//person = pcws.readPerson(1L);
		dashboardMenu();		
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



	private void workOnPersonMenu() {
		int ch;
		boolean quit = false;
		
		workOnPersonMenuMsg();
		
		try {
			while ( ((ch = System.in.read()) != -1) && (quit == false) ) {
				if (ch != '\n' && ch != '\r') {                    
					switch((char)ch){
					case 's':
					case 'S':						
						searchMeals();
						break;
					case 'i':
					case 'I':
						if (person == null) {
							insertPerson();
						}
						insertInPersonMenu();
						break;
					case 'v':
					case 'V':
						viewInPersonMenu();
						break;
					case 'q':
					case 'Q':
						System.out.println(BACK_MSG);
						quit = true;						
						break;                    
					}
					if (!quit) workOnPersonMenuMsg();
				}
	
			}
		} catch (IOException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
	}



	private void insertInPersonMenu() {
		int ch;
		boolean quit = false;
		
		insertInPersonMenuMsg();
		
		try {
			while ( ((ch = System.in.read()) != -1) && (quit == false) ) {
				if (ch != '\n' && ch != '\r') {                    
					switch((char)ch){
					case 'm':
					case 'M':
						insertMeal();
						break;
					case 'g':
					case 'G':						
						insertGoal();
						break;
					case 'a':
					case 'A':
						insertActivity();
						break;
					case 'q':
					case 'Q':
						System.out.println(BACK_MSG);
						quit = true;
						break;                    
					}
					if (!quit) insertInPersonMenuMsg();
				}
	
			}
		} catch (IOException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
	
		
	}



	private void viewInPersonMenu() {
		int ch;
		boolean quit = false;
		
		viewInPersonMenuMsg();
		
		try {
			while ( ((ch = System.in.read()) != -1) && (quit == false) ) {
				if (ch != '\n' && ch != '\r') {                    
					switch((char)ch){
					case 'm':
					case 'M':
						viewMeals();
						break;
					case 'g':
					case 'G':						
						viewGoals();
						break;
					case 'a':
					case 'A':
						viewActivities();
						break;
					case 'd':
					case 'D':
						viewPerson();
						break;
					case 't':
					case 'T':
						viewTodayStatus();
						break;	
					case 'q':
					case 'Q':
						System.out.println(BACK_MSG);
						quit = true;
						break;                    
					}
					if (!quit) viewInPersonMenuMsg();
				}
	
			}
		} catch (IOException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}



	private String getPersonId() {
		return (person == null) ? "NOT YET SET" : person.getId().toString() + ", " + person.getFirstname();  
	}

	private void adminMenu() {
		int ch;
		boolean quit = false;
		
		adminMenuMsg();
		
		try {
			while ( ((ch = System.in.read()) != -1) && (quit == false) ) {
				if (ch != '\n' && ch != '\r') {                    
					switch((char)ch){
					case 'm':
					case 'M':
						viewAllMeals();
						break;
					case 'g':
					case 'G':						
						viewAllGoals();
						break;
					case 'a':
					case 'A':
						viewAllActivities();
						break;
					case 'p':
					case 'P':
						viewPeople();
						break;
					case 's':
					case 'S':
						switchPerson();
						break;
					case 'q':
					case 'Q':
						System.out.println(BACK_MSG);
						quit = true;
						break;                    
					}
					if (!quit) adminMenuMsg();
				}
	
			}
		} catch (IOException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
	
		
	}



	private void viewAllGoals() {
		Collection<Goal> goals = new ArrayList<Goal>();
		goals = pcws.readGoalList();
		if (goals.isEmpty()) {
			System.out.println("--> No goal present in the DB. Please create one first.");
		}
		else {
			Iterator<Goal> i = goals.iterator();
			System.out.println("--> Found "+goals.size()+" goals, printing:");
			while(i.hasNext()) {
				marshallObject(i.next());
			}
		}
	}



	private void viewAllActivities() {
		Collection<Activity> activities = new ArrayList<Activity>();
		activities = pcws.readActivityList();
		if (activities.isEmpty()) {
			System.out.println("--> No activity present in the DB. Please create one first.");
		}
		else {
			Iterator<Activity> i = activities.iterator();
			System.out.println("--> Found "+activities.size()+" activities, printing:");
			while(i.hasNext()) {
				marshallObject(i.next());
			}
		}
	}



	private void viewAllMeals() {
		Collection<Meal> meals = new ArrayList<Meal>();
		meals = pcws.readMealList();
		if (meals.isEmpty()) {
			System.out.println("--> No meal present in the DB. Please create one first.");
		}
		else {
			Iterator<Meal> i = meals.iterator();
			System.out.println("--> Found "+meals.size()+" meals, printing:");
			while(i.hasNext()) {
				marshallObject(i.next());
			}
		}
	}



	private void viewPeople() {
		Collection<Person> people = new ArrayList<Person>();
		people = pcws.readPersonList();
		if (people.isEmpty()) {
			System.out.println("--> No person present in the DB. Please create one first.");
		}
		else {
			Iterator<Person> i = people.iterator();
			System.out.println("--> Found "+people.size()+" people, printing:");
			while(i.hasNext()) {
				marshallObject(i.next());
			}
		}		
	}



	private void switchPerson() {
		try {			
			System.out.println("--> Please insert ID of person to bring into session:");
			System.out.println(TAB + "Person ID: ");
			scanner.nextLine();
			int newPersonId = scanner.nextInt();
			
			Person newPerson = pcws.readPerson(new Long(newPersonId));
			if (newPerson != null) {
				person = newPerson;
				System.out.println("--> Person in session switched. Printing details:");
				marshallObject(newPerson);
			}
			else {
				System.out.println("--> Person with ID: "+newPersonId+" not present.");
			}						
		} catch (InputMismatchException e) {
			System.err.println("--> Meal not created. Check last inserted value.");
		}
		
	}


	private void viewTodayStatus() {
		Person p = pcws.readPerson(person.getId());
		Calendar today = Calendar.getInstance();		
		today.setTime(new Date());
		System.out.println("--> Calories taken today in meals:");
		// Print Calories taken
		Iterator<Meal> im = p.getMeals().getMeal().iterator();	
		if (im.hasNext()) {
			while(im.hasNext()){
				Meal m = im.next();				
				if (sameDay(m.getDatetime(),today)){
					marshallObject(m);
				}
			}
		}
		else {
			System.out.println("--> This person ("+getPersonId()+"), does not have any meal associated for today.");
		}
		// Print Calories burned
		System.out.println("--> Calories burned today in activities:");
		Iterator<Activity> ia = p.getActivities().getActivity().iterator();	
		if (ia.hasNext()) {
			while(ia.hasNext()){
				Activity a = ia.next();				
				if (sameDay(a.getDatetime(),today)){
					marshallObject(a);
				}
			}
		}
		else {
			System.out.println("--> This person ("+getPersonId()+"), does not have any activity associated for today.");
		}
		System.out.println("--> Calories burned today as daily calorie needs:");
		System.out.println("Calories: " + p.getDaycalories());
		todayGoalCheck();
	}


	private boolean sameDay(XMLGregorianCalendar d1, Calendar d2) {
		return ( (d1.getYear() == d2.get(Calendar.YEAR)) && (d1.getMonth() == d2.get(Calendar.MONTH)+1) && (d1.getDay() == d2.get(Calendar.DAY_OF_MONTH)) );
	}



	private void viewPerson() {
		Person p = pcws.readPerson(person.getId());
		if (p != null) {
			System.out.println("--> Printing person details:");
			marshallObject(p);
			todayGoalCheck();
		}
		else {
			System.out.println("--> ERROR: Person not found.");
		}
	}


	private void viewActivities() {
		Person p = pcws.readPerson(person.getId());
		Iterator<Activity> i = p.getActivities().getActivity().iterator();	
		if (i.hasNext()) {
			while(i.hasNext()){
				marshallObject(i.next());
			}
		}
		else {
			System.out.println("--> This person ("+getPersonId()+"), does not have any activity associated.");
		}		
	}



	private void viewGoals() {
		Person p = pcws.readPerson(person.getId());
		Iterator<Goal> i = p.getGoals().getGoal().iterator();	
		if (i.hasNext()) {
			while(i.hasNext()){
				marshallObject(i.next());
			}
		}
		else {
			System.out.println("--> This person ("+getPersonId()+"), does not have any goal associated.");
		}
	}



	private void viewMeals() {
		Person p = pcws.readPerson(person.getId());
		Iterator<Meal> i = p.getMeals().getMeal().iterator();	
		if (i.hasNext()) {
			while(i.hasNext()){
				marshallObject(i.next());
			}
		}
		else {
			System.out.println("--> This person ("+getPersonId()+"), does not have any meal associated.");
		}
	}



	private void insertActivity() {
		try {
			Activity a = new Activity();
			System.out.println("--> Please insert Activity details:");
			System.out.println(TAB + "Name: ");			
			scanner.nextLine();
			a.setName(scanner.nextLine());			
			System.out.println(TAB + "Calories burned: ");
			a.setCalories(scanner.nextInt());			
			scanner.nextLine();
			a = pcws.createActivity(a, person);		
			if (a != null) {
				System.out.println("--> Activity created.");
				todayGoalCheck();
			}
			else {
				System.out.println("--> Activity NOT created, somthing went wrong.");
			}
			marshallObject(a);
		} catch (InputMismatchException e) {
			System.err.println("--> Activity not created. Check last inserted value.");
		}
	}



	private void insertMeal() {
		try {
			Meal m = new Meal();
			System.out.println("--> Please insert Meal details:");
			System.out.println(TAB + "Name: ");			
			scanner.nextLine();
			m.setName(scanner.nextLine());
			System.out.println(TAB + "Type (breackfast, lunch, dinner, snack): ");
			m.setType(scanner.nextLine());
			System.out.println(TAB + "Calories taken: ");
			m.setCalories(scanner.nextInt());			
			scanner.nextLine();
			m = pcws.createMeal(m, person);		
			if (m != null) {
				System.out.println("--> Meal created.");
				todayGoalCheck();
			}
			else {
				System.out.println("--> Meal NOT created, somthing went wrong.");
			}
			marshallObject(m);
		} catch (InputMismatchException e) {
			System.err.println("--> Meal not created. Check last inserted value.");
		}				
	}



	private void insertMeal(Meal meal) {
		Meal m = pcws.createMeal(meal, person);		
		if (m != null) {
			System.out.println("--> Meal created.");
			todayGoalCheck();
		}
		else {
			System.out.println("--> Meal NOT created, somthing went wrong.");
		}
		marshallObject(m);		
	}



	private void insertGoal() {
		try {
			Goal g = new Goal();
			System.out.println("--> Please insert Goal details:");
			System.out.println(TAB + "Name: ");			
			scanner.nextLine();			
			g.setName(scanner.nextLine());
			System.out.println(TAB + "Today calories limit: ");
			g.setCalories(scanner.nextInt());			
			scanner.nextLine();
			g = pcws.createGoal(g, person);		
			if (g != null) {
				System.out.println("--> Goal created.");
				todayGoalCheck();
			}
			else {
				System.out.println("--> Goal NOT created, somthing went wrong.");
			}
			marshallObject(g);
		} catch (InputMismatchException e) {
			System.err.println("--> Goal not created. Check last inserted value.");
		}		
	}


	private void insertPerson() {
		try {
			Person p = new Person();
			System.out.println("--> Please insert Person details:");
			System.out.println(TAB + "Firstname: ");
			scanner.nextLine();
			p.setFirstname(scanner.nextLine());
			System.out.println(TAB + "Lastname: ");
			p.setLastname(scanner.nextLine());			
			try {
				XMLGregorianCalendar randomDate = getRandomDate();
				p.setBirthday(randomDate);
				System.out.println(TAB + "Birthday: " + randomDate + " (automatically set)");
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(TAB + "email: ");
			p.setEmail(scanner.nextLine());
			System.out.println(TAB + "weight: ");
			p.setWeight(scanner.nextLine());
			System.out.println(TAB + "height: ");
			p.setHeight(scanner.nextLine());
			System.out.println(TAB + "Calories burned per day (depends on weight, heigh andtype of worka): ");
			p.setDaycalories(scanner.nextInt());
			scanner.nextLine();
			person = pcws.createPerson(p);		
			if (person != null) {
				System.out.println("--> Person created.");
			}
			else {
				System.out.println("--> Person NOT created, somthing went wrong.");
			}
			marshallObject(person);
		} catch (InputMismatchException e) {
			System.err.println("--> Person not created. Check last inserted value.");
		}
	}
	
	private void searchMeals() {
		System.out.println("--> This function search and filter meals from external sources: api.foodessentials.com");
		System.out.println("--> Please insert search criteria:");
		System.out.println(TAB + "Search phrase: ");
		scanner.nextLine();
		String searchKey = scanner.nextLine();		
		ArrayList<Meal> mealList = new ArrayList<Meal>();
		
		int s = 1;
		int n = 10;
		int page = 0;			
		Collection<Meal> meals = pcws.searchMeals(searchKey, s, n);
		if (!meals.isEmpty()){
			Iterator<Meal> it = meals.iterator();
			int i = 1+(page*n);
			while(it.hasNext()) {
				System.out.println("---> Meal ID: " + i);
				Meal m = it.next();
				mealList.add(m);
				marshallObject(m);
				i++;
			}
			page++;
		
		
			int ch;
			boolean quit = false;
			
			searchMealsMenuMsg();
			
			try {
				while ( ((ch = System.in.read()) != -1) && (quit == false) ) {
					if (ch != '\n' && ch != '\r') {                    
						switch((char)ch){
						case 'i':
						case 'I':
							scanner.nextLine();
							System.out.println(TAB + "Type the ID of the meal you want to insert: ");
							Integer mealId = scanner.nextInt();
							insertMeal(mealList.get(mealId-1));
							System.out.println("---> Press ENTER to proceed." + i);
							quit = true;
							break;
						case 'n':
						case 'N':
							s = 1+(page*n);
							meals = pcws.searchMeals(searchKey, s, n);
							if (!meals.isEmpty()){
								it = meals.iterator();
								i = 1+(page*n);
								while(it.hasNext()) {
									System.out.println("---> Meal ID: " + i);
									Meal m = it.next();
									mealList.add(m);
									marshallObject(m);
									i++;
								}
								page++;
							}
							break;					
						case 'q':
						case 'Q':
							System.out.println(BACK_MSG);
							quit = true;
							break;                    
						}
						if (!quit) searchMealsMenuMsg();
					}
		
				}
			} catch (IOException ex) {
				Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
			}
		
		}
		else {
			System.out.println("--> Your search key yealded no results. Try again !");
		}

	}



	private void marshallObject(Object o) {
		try {
			JAXBContext jc = JAXBContext.newInstance(o.getClass());
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal( (new JAXBElement<Object>(new QName("uri","local"), Object.class, o)), System.out);			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	private void dashboardMenuMsg() {
		System.out.println(
				RET + "--> Please tell me if you want to" + RET
				+ TAB + "[I]nsert a Person" + RET
				+ TAB + "[W]ork on Person in the session ("+ getPersonId() + ")" + RET
				+ TAB + "[A]dmin menu" + RET
				+ TAB + "[Q]uit" + RET
				);
	}



	private void insertInPersonMenuMsg() {
		System.out.println(
				RET + "--> Please tell me if you want to" + RET
				+ TAB + "Insert a new [M]eal on Person in the session ("+ getPersonId() + ")" + RET
				+ TAB + "Insert a new [G]oal on Person in the session ("+ getPersonId() + ")" + RET
				+ TAB + "Insert a new [A]ctivity on Person in the session ("+ getPersonId() + ")" + RET
				+ TAB + "[Q]uit: Go to previous menu" + RET
				);		
	}



	private void viewInPersonMenuMsg() {
		System.out.println(
				RET + "--> Please tell me if you want to" + RET
				+ TAB + "View [M]eals of Person in the session ("+ getPersonId() + ")" + RET
				+ TAB + "View [G]oals of Person in the session ("+ getPersonId() + ")" + RET
				+ TAB + "View [A]ctivities of Person in the session ("+ getPersonId() + ")" + RET
				+ TAB + "View [D]etails of Person in the session ("+ getPersonId() + ")" + RET
				+ TAB + "View [T]oday status for Person in the session ("+ getPersonId() + ")" + RET
				+ TAB + "[Q]uit: Go to previous menu" + RET
				);		
	}



	private void workOnPersonMenuMsg() {
		System.out.println(
				RET + "--> Please tell me if you want to" + RET
				+ TAB + "[S]earch meals from external sources" + RET
				+ TAB + "[I]sert Meal, Goal or Activity on Person in the session ("+ getPersonId() + ")" + RET
				+ TAB + "[V]iew Meals, Goals, Activities and others on Person in the session ("+ getPersonId() + ")" + RET
				+ TAB + "[Q]uit: Go to previous menu" + RET
				);		
	}
	
	private void searchMealsMenuMsg() {
		System.out.println(
				RET + "--> Please tell me if you want to" + RET
				+ TAB + "[I]insert in the Person in the session ("+ getPersonId() + ") one meal from the above list" + RET
				+ TAB + "Move to the [N]ext result page" + RET
				+ TAB + "[Q]uit: Go to previous menu" + RET
				);		
	}
	
	private void adminMenuMsg() {
		System.out.println(
				RET + "--> Please tell me if you want to" + RET
				+ TAB + "View all [P]eople in database" + RET
				+ TAB + "View all [M]eals in database" + RET
				+ TAB + "View all [G]oals in database" + RET
				+ TAB + "View all [A]ctivities in database" + RET
				+ TAB + "[S]witch Person in the session ("+ getPersonId() + ")" + RET
				+ TAB + "[Q]uit: Go to previous menu" + RET
				);		
	}



	private XMLGregorianCalendar getRandomDate() throws DatatypeConfigurationException {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR); 		// 1. get the current year
		int year = (int) Math.round(Math.random()*(currentYear-1950)+1950); // 2. generate a random year		
		int dayOfYear = (int) Math.round(Math.floor(Math.random()*365)+1);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
		Date randomDate = calendar.getTime();		
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(randomDate);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);		
	}



	private void todayGoalCheck() {
		String checkGoalResult = pcws.checkGoal(person.getId());
		JSONObject goalEval = new JSONObject(checkGoalResult);
		System.out.println(
				RET + "--> Today evaluation: (calcualted from remote service)" + RET
				+ TAB +"Evaluation message: " + goalEval.get("evalMsg") + RET
				+ TAB +"Goal satisfaction percentage: "+ goalEval.get("goalSatisfaction") + " %" + RET
				+ TAB +"Calories taken: " + goalEval.get("caloriesTaken") + RET
				);		
	}
}
