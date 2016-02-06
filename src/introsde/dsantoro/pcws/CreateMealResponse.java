
package introsde.dsantoro.pcws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import introsde.dsantoro.dbws.Meal;


/**
 * <p>Java class for createMealResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createMealResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meal" type="{http://dbws.dsantoro.introsde/}meal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createMealResponse", propOrder = {
    "meal"
})
public class CreateMealResponse {

    protected Meal meal;

    /**
     * Gets the value of the meal property.
     * 
     * @return
     *     possible object is
     *     {@link Meal }
     *     
     */
    public Meal getMeal() {
        return meal;
    }

    /**
     * Sets the value of the meal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Meal }
     *     
     */
    public void setMeal(Meal value) {
        this.meal = value;
    }

}
