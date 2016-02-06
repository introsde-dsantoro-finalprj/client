
package introsde.dsantoro.dbws;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the introsde.dsantoro.dbws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: introsde.dsantoro.dbws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link Meal }
     * 
     */
    public Meal createMeal() {
        return new Meal();
    }

    /**
     * Create an instance of {@link Goal }
     * 
     */
    public Goal createGoal() {
        return new Goal();
    }

    /**
     * Create an instance of {@link Activity }
     * 
     */
    public Activity createActivity() {
        return new Activity();
    }

    /**
     * Create an instance of {@link Person.Activities }
     * 
     */
    public Person.Activities createPersonActivities() {
        return new Person.Activities();
    }

    /**
     * Create an instance of {@link Person.Goals }
     * 
     */
    public Person.Goals createPersonGoals() {
        return new Person.Goals();
    }

    /**
     * Create an instance of {@link Person.Meals }
     * 
     */
    public Person.Meals createPersonMeals() {
        return new Person.Meals();
    }

}
