
package introsde.dsantoro.pcws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import introsde.dsantoro.dbws.Activity;
import introsde.dsantoro.dbws.Goal;
import introsde.dsantoro.dbws.Meal;
import introsde.dsantoro.dbws.Person;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Pcws", targetNamespace = "http://pcws.dsantoro.introsde/")
@XmlSeeAlso({
    introsde.dsantoro.dbws.ObjectFactory.class,
    introsde.dsantoro.pcws.ObjectFactory.class
})
public interface Pcws {


    /**
     * 
     * @param personId
     * @return
     *     returns introsde.dsantoro.dbws.Person
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "")
    @RequestWrapper(localName = "readPerson", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadPerson")
    @ResponseWrapper(localName = "readPersonResponse", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadPersonResponse")
    @Action(input = "http://pcws.dsantoro.introsde/Pcws/readPersonRequest", output = "http://pcws.dsantoro.introsde/Pcws/readPersonResponse")
    public Person readPerson(
        @WebParam(name = "personId", targetNamespace = "")
        Long personId);

    /**
     * 
     * @return
     *     returns java.util.List<introsde.dsantoro.dbws.Activity>
     */
    @WebMethod
    @WebResult(name = "activity", targetNamespace = "")
    @RequestWrapper(localName = "readActivityList", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadActivityList")
    @ResponseWrapper(localName = "readActivityListResponse", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadActivityListResponse")
    @Action(input = "http://pcws.dsantoro.introsde/Pcws/readActivityListRequest", output = "http://pcws.dsantoro.introsde/Pcws/readActivityListResponse")
    public List<Activity> readActivityList();

    /**
     * 
     * @param person
     * @param activityRqst
     * @return
     *     returns introsde.dsantoro.dbws.Activity
     */
    @WebMethod
    @WebResult(name = "activity", targetNamespace = "")
    @RequestWrapper(localName = "createActivity", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.CreateActivity")
    @ResponseWrapper(localName = "createActivityResponse", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.CreateActivityResponse")
    @Action(input = "http://pcws.dsantoro.introsde/Pcws/createActivityRequest", output = "http://pcws.dsantoro.introsde/Pcws/createActivityResponse")
    public Activity createActivity(
        @WebParam(name = "activityRqst", targetNamespace = "")
        Activity activityRqst,
        @WebParam(name = "person", targetNamespace = "")
        Person person);

    /**
     * 
     * @param goalId
     * @return
     *     returns introsde.dsantoro.dbws.Goal
     */
    @WebMethod
    @WebResult(name = "goal", targetNamespace = "")
    @RequestWrapper(localName = "readGoal", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadGoal")
    @ResponseWrapper(localName = "readGoalResponse", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadGoalResponse")
    @Action(input = "http://pcws.dsantoro.introsde/Pcws/readGoalRequest", output = "http://pcws.dsantoro.introsde/Pcws/readGoalResponse")
    public Goal readGoal(
        @WebParam(name = "goalId", targetNamespace = "")
        Long goalId);

    /**
     * 
     * @return
     *     returns java.util.List<introsde.dsantoro.dbws.Goal>
     */
    @WebMethod
    @WebResult(name = "goal", targetNamespace = "")
    @RequestWrapper(localName = "readGoalList", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadGoalList")
    @ResponseWrapper(localName = "readGoalListResponse", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadGoalListResponse")
    @Action(input = "http://pcws.dsantoro.introsde/Pcws/readGoalListRequest", output = "http://pcws.dsantoro.introsde/Pcws/readGoalListResponse")
    public List<Goal> readGoalList();

    /**
     * 
     * @param person
     * @param goalRqst
     * @return
     *     returns introsde.dsantoro.dbws.Goal
     */
    @WebMethod
    @WebResult(name = "goal", targetNamespace = "")
    @RequestWrapper(localName = "createGoal", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.CreateGoal")
    @ResponseWrapper(localName = "createGoalResponse", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.CreateGoalResponse")
    @Action(input = "http://pcws.dsantoro.introsde/Pcws/createGoalRequest", output = "http://pcws.dsantoro.introsde/Pcws/createGoalResponse")
    public Goal createGoal(
        @WebParam(name = "goalRqst", targetNamespace = "")
        Goal goalRqst,
        @WebParam(name = "person", targetNamespace = "")
        Person person);

    /**
     * 
     * @return
     *     returns java.util.List<introsde.dsantoro.dbws.Person>
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "")
    @RequestWrapper(localName = "readPersonList", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadPersonList")
    @ResponseWrapper(localName = "readPersonListResponse", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadPersonListResponse")
    @Action(input = "http://pcws.dsantoro.introsde/Pcws/readPersonListRequest", output = "http://pcws.dsantoro.introsde/Pcws/readPersonListResponse")
    public List<Person> readPersonList();

    /**
     * 
     * @param personRqst
     * @return
     *     returns introsde.dsantoro.dbws.Person
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "")
    @RequestWrapper(localName = "createPerson", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.CreatePerson")
    @ResponseWrapper(localName = "createPersonResponse", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.CreatePersonResponse")
    @Action(input = "http://pcws.dsantoro.introsde/Pcws/createPersonRequest", output = "http://pcws.dsantoro.introsde/Pcws/createPersonResponse")
    public Person createPerson(
        @WebParam(name = "personRqst", targetNamespace = "")
        Person personRqst);

    /**
     * 
     * @param mealId
     * @return
     *     returns introsde.dsantoro.dbws.Meal
     */
    @WebMethod
    @WebResult(name = "meal", targetNamespace = "")
    @RequestWrapper(localName = "readMeal", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadMeal")
    @ResponseWrapper(localName = "readMealResponse", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadMealResponse")
    @Action(input = "http://pcws.dsantoro.introsde/Pcws/readMealRequest", output = "http://pcws.dsantoro.introsde/Pcws/readMealResponse")
    public Meal readMeal(
        @WebParam(name = "mealId", targetNamespace = "")
        Long mealId);

    /**
     * 
     * @return
     *     returns java.util.List<introsde.dsantoro.dbws.Meal>
     */
    @WebMethod
    @WebResult(name = "meal", targetNamespace = "")
    @RequestWrapper(localName = "readMealList", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadMealList")
    @ResponseWrapper(localName = "readMealListResponse", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadMealListResponse")
    @Action(input = "http://pcws.dsantoro.introsde/Pcws/readMealListRequest", output = "http://pcws.dsantoro.introsde/Pcws/readMealListResponse")
    public List<Meal> readMealList();

    /**
     * 
     * @param person
     * @param mealRqst
     * @return
     *     returns introsde.dsantoro.dbws.Meal
     */
    @WebMethod
    @WebResult(name = "meal", targetNamespace = "")
    @RequestWrapper(localName = "createMeal", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.CreateMeal")
    @ResponseWrapper(localName = "createMealResponse", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.CreateMealResponse")
    @Action(input = "http://pcws.dsantoro.introsde/Pcws/createMealRequest", output = "http://pcws.dsantoro.introsde/Pcws/createMealResponse")
    public Meal createMeal(
        @WebParam(name = "mealRqst", targetNamespace = "")
        Meal mealRqst,
        @WebParam(name = "person", targetNamespace = "")
        Person person);

    /**
     * 
     * @param activityId
     * @return
     *     returns introsde.dsantoro.dbws.Activity
     */
    @WebMethod
    @WebResult(name = "activity", targetNamespace = "")
    @RequestWrapper(localName = "readActivity", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadActivity")
    @ResponseWrapper(localName = "readActivityResponse", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.ReadActivityResponse")
    @Action(input = "http://pcws.dsantoro.introsde/Pcws/readActivityRequest", output = "http://pcws.dsantoro.introsde/Pcws/readActivityResponse")
    public Activity readActivity(
        @WebParam(name = "activityId", targetNamespace = "")
        Long activityId);

    /**
     * 
     * @param quantity
     * @param start
     * @param searchKey
     * @return
     *     returns java.util.List<introsde.dsantoro.dbws.Meal>
     */
    @WebMethod
    @WebResult(name = "meal", targetNamespace = "")
    @RequestWrapper(localName = "searchMeals", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.SearchMeals")
    @ResponseWrapper(localName = "searchMealsResponse", targetNamespace = "http://pcws.dsantoro.introsde/", className = "introsde.dsantoro.pcws.SearchMealsResponse")
    @Action(input = "http://pcws.dsantoro.introsde/Pcws/searchMealsRequest", output = "http://pcws.dsantoro.introsde/Pcws/searchMealsResponse")
    public List<Meal> searchMeals(
        @WebParam(name = "searchKey", targetNamespace = "")
        String searchKey,
        @WebParam(name = "start", targetNamespace = "")
        int start,
        @WebParam(name = "quantity", targetNamespace = "")
        int quantity);

}
