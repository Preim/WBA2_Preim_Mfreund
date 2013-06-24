//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.06.21 um 12:26:52 PM CEST 
//


package restful.webservice.resources.topics;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Topic" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TopicID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="TopicName">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;pattern value="[a-zA-Z0-9]*"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TopicViewerCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "topic"
})
@XmlRootElement(name = "Topics")
public class Topics {

    @XmlElement(name = "Topic", required = true)
    protected List<Topics.Topic> topic;

    /**
     * Gets the value of the topic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the topic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTopic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Topics.Topic }
     * 
     * 
     */
    public List<Topics.Topic> getTopic() {
        if (topic == null) {
            topic = new ArrayList<Topics.Topic>();
        }
        return this.topic;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="TopicID" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="TopicName">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;pattern value="[a-zA-Z0-9]*"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TopicViewerCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "topicID",
        "topicName",
        "topicViewerCount"
    })
    public static class Topic {

        @XmlElement(name = "TopicID")
        protected int topicID;
        @XmlElement(name = "TopicName", required = true)
        protected String topicName;
        @XmlElement(name = "TopicViewerCount")
        protected int topicViewerCount;

        /**
         * Ruft den Wert der topicID-Eigenschaft ab.
         * 
         */
        public int getTopicID() {
            return topicID;
        }

        /**
         * Legt den Wert der topicID-Eigenschaft fest.
         * 
         */
        public void setTopicID(int value) {
            this.topicID = value;
        }

        /**
         * Ruft den Wert der topicName-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTopicName() {
            return topicName;
        }

        /**
         * Legt den Wert der topicName-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTopicName(String value) {
            this.topicName = value;
        }

        /**
         * Ruft den Wert der topicViewerCount-Eigenschaft ab.
         * 
         */
        public int getTopicViewerCount() {
            return topicViewerCount;
        }

        /**
         * Legt den Wert der topicViewerCount-Eigenschaft fest.
         * 
         */
        public void setTopicViewerCount(int value) {
            this.topicViewerCount = value;
        }

    }

}
