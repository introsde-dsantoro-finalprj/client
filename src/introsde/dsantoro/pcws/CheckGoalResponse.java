
package introsde.dsantoro.pcws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkGoalResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkGoalResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="goalEvalJson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkGoalResponse", propOrder = {
    "goalEvalJson"
})
public class CheckGoalResponse {

    protected String goalEvalJson;

    /**
     * Gets the value of the goalEvalJson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoalEvalJson() {
        return goalEvalJson;
    }

    /**
     * Sets the value of the goalEvalJson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoalEvalJson(String value) {
        this.goalEvalJson = value;
    }

}
