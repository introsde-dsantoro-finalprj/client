
package introsde.dsantoro.pcws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import introsde.dsantoro.dbws.Meal;
import introsde.dsantoro.dbws.Person;


/**
 * <p>Java class for createMeal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createMeal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mealRqst" type="{http://dbws.dsantoro.introsde/}meal" minOccurs="0"/>
 *         &lt;element name="person" type="{http://dbws.dsantoro.introsde/}person" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createMeal", propOrder = {
    "mealRqst",
    "person"
})
public class CreateMeal {

    protected Meal mealRqst;
    protected Person person;

    /**
     * Gets the value of the mealRqst property.
     * 
     * @return
     *     possible object is
     *     {@link Meal }
     *     
     */
    public Meal getMealRqst() {
        return mealRqst;
    }

    /**
     * Sets the value of the mealRqst property.
     * 
     * @param value
     *     allowed object is
     *     {@link Meal }
     *     
     */
    public void setMealRqst(Meal value) {
        this.mealRqst = value;
    }

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setPerson(Person value) {
        this.person = value;
    }

}
