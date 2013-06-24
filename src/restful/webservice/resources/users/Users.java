//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.06.22 um 08:23:53 PM CEST 
//


package restful.webservice.resources.users;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="User" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Login">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="LoginName">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;pattern value="[a-zA-Z0-9]*"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="LoginPassword">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;minLength value="3"/>
 *                                   &lt;maxLength value="15"/>
 *                                   &lt;pattern value="[a-zA-Z0-9]*"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="UserStreamChannelName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="UserInformation">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="FirstName">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;pattern value="[a-zA-Z]*"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="LastName">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;pattern value="[a-zA-Z]*"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Birthday" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="City">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;pattern value="[a-zA-Z]*"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Country">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;pattern value="[a-zA-Z]*"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="StreamChannel">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ChannelTopic">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;pattern value="[a-zA-Z0-9]*"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="ChannelDescription">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="ChannelHeadline" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="ChannelInformation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="ChannelComments">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="ChannelComment" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="CommentID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                                 &lt;element name="CommentDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                                 &lt;element name="CommentData">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;choice>
 *                                                           &lt;element name="CommentHeadline" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="CommentText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/choice>
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="TotalViewerCount">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
    "user"
})
@XmlRootElement(name = "Users")
public class Users {

    @XmlElement(name = "User", required = true)
    protected List<Users.User> user;

    /**
     * Gets the value of the user property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the user property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUser().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Users.User }
     * 
     * 
     */
    public List<Users.User> getUser() {
        if (user == null) {
            user = new ArrayList<Users.User>();
        }
        return this.user;
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
     *         &lt;element name="Login">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="LoginName">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;pattern value="[a-zA-Z0-9]*"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="LoginPassword">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="3"/>
     *                         &lt;maxLength value="15"/>
     *                         &lt;pattern value="[a-zA-Z0-9]*"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="UserStreamChannelName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="UserInformation">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="FirstName">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;pattern value="[a-zA-Z]*"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="LastName">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;pattern value="[a-zA-Z]*"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Birthday" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="City">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;pattern value="[a-zA-Z]*"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Country">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;pattern value="[a-zA-Z]*"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="StreamChannel">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ChannelTopic">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;pattern value="[a-zA-Z0-9]*"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="ChannelDescription">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="ChannelHeadline" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="ChannelInformation" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="ChannelComments">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="ChannelComment" maxOccurs="unbounded">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="CommentID" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                                       &lt;element name="CommentDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                                       &lt;element name="CommentData">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;choice>
     *                                                 &lt;element name="CommentHeadline" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="CommentText" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                               &lt;/choice>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="TotalViewerCount">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
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
        "login",
        "userID",
        "userStreamChannelName",
        "userInformation",
        "streamChannel"
    })
    public static class User {

        @XmlElement(name = "Login", required = true)
        protected Users.User.Login login;
        @XmlElement(name = "UserID")
        protected int userID;
        @XmlElement(name = "UserStreamChannelName", required = true)
        protected String userStreamChannelName;
        @XmlElement(name = "UserInformation", required = true)
        protected Users.User.UserInformation userInformation;
        @XmlElement(name = "StreamChannel", required = true)
        protected Users.User.StreamChannel streamChannel;

        /**
         * Ruft den Wert der login-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Users.User.Login }
         *     
         */
        public Users.User.Login getLogin() {
            return login;
        }

        /**
         * Legt den Wert der login-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Users.User.Login }
         *     
         */
        public void setLogin(Users.User.Login value) {
            this.login = value;
        }

        /**
         * Ruft den Wert der userID-Eigenschaft ab.
         * 
         */
        public int getUserID() {
            return userID;
        }

        /**
         * Legt den Wert der userID-Eigenschaft fest.
         * 
         */
        public void setUserID(int value) {
            this.userID = value;
        }

        /**
         * Ruft den Wert der userStreamChannelName-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUserStreamChannelName() {
            return userStreamChannelName;
        }

        /**
         * Legt den Wert der userStreamChannelName-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUserStreamChannelName(String value) {
            this.userStreamChannelName = value;
        }

        /**
         * Ruft den Wert der userInformation-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Users.User.UserInformation }
         *     
         */
        public Users.User.UserInformation getUserInformation() {
            return userInformation;
        }

        /**
         * Legt den Wert der userInformation-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Users.User.UserInformation }
         *     
         */
        public void setUserInformation(Users.User.UserInformation value) {
            this.userInformation = value;
        }

        /**
         * Ruft den Wert der streamChannel-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Users.User.StreamChannel }
         *     
         */
        public Users.User.StreamChannel getStreamChannel() {
            return streamChannel;
        }

        /**
         * Legt den Wert der streamChannel-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Users.User.StreamChannel }
         *     
         */
        public void setStreamChannel(Users.User.StreamChannel value) {
            this.streamChannel = value;
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
         *         &lt;element name="LoginName">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;pattern value="[a-zA-Z0-9]*"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="LoginPassword">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="3"/>
         *               &lt;maxLength value="15"/>
         *               &lt;pattern value="[a-zA-Z0-9]*"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
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
            "loginName",
            "loginPassword"
        })
        public static class Login {

            @XmlElement(name = "LoginName", required = true)
            protected String loginName;
            @XmlElement(name = "LoginPassword", required = true)
            protected String loginPassword;

            /**
             * Ruft den Wert der loginName-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLoginName() {
                return loginName;
            }

            /**
             * Legt den Wert der loginName-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLoginName(String value) {
                this.loginName = value;
            }

            /**
             * Ruft den Wert der loginPassword-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLoginPassword() {
                return loginPassword;
            }

            /**
             * Legt den Wert der loginPassword-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLoginPassword(String value) {
                this.loginPassword = value;
            }

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
         *         &lt;element name="ChannelTopic">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;pattern value="[a-zA-Z0-9]*"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ChannelDescription">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="ChannelHeadline" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="ChannelInformation" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="ChannelComments">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="ChannelComment" maxOccurs="unbounded">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="CommentID" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                             &lt;element name="CommentDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                             &lt;element name="CommentData">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;choice>
         *                                       &lt;element name="CommentHeadline" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="CommentText" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                     &lt;/choice>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="TotalViewerCount">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
         *             &lt;/restriction>
         *           &lt;/simpleType>
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
            "channelTopic",
            "channelDescription",
            "channelComments",
            "totalViewerCount"
        })
        public static class StreamChannel {

            @XmlElement(name = "ChannelTopic", required = true)
            protected String channelTopic;
            @XmlElement(name = "ChannelDescription", required = true)
            protected Users.User.StreamChannel.ChannelDescription channelDescription;
            @XmlElement(name = "ChannelComments", required = true)
            protected Users.User.StreamChannel.ChannelComments channelComments;
            @XmlElement(name = "TotalViewerCount")
            protected int totalViewerCount;

            /**
             * Ruft den Wert der channelTopic-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getChannelTopic() {
                return channelTopic;
            }

            /**
             * Legt den Wert der channelTopic-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setChannelTopic(String value) {
                this.channelTopic = value;
            }

            /**
             * Ruft den Wert der channelDescription-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Users.User.StreamChannel.ChannelDescription }
             *     
             */
            public Users.User.StreamChannel.ChannelDescription getChannelDescription() {
                return channelDescription;
            }

            /**
             * Legt den Wert der channelDescription-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Users.User.StreamChannel.ChannelDescription }
             *     
             */
            public void setChannelDescription(Users.User.StreamChannel.ChannelDescription value) {
                this.channelDescription = value;
            }

            /**
             * Ruft den Wert der channelComments-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Users.User.StreamChannel.ChannelComments }
             *     
             */
            public Users.User.StreamChannel.ChannelComments getChannelComments() {
                return channelComments;
            }

            /**
             * Legt den Wert der channelComments-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Users.User.StreamChannel.ChannelComments }
             *     
             */
            public void setChannelComments(Users.User.StreamChannel.ChannelComments value) {
                this.channelComments = value;
            }

            /**
             * Ruft den Wert der totalViewerCount-Eigenschaft ab.
             * 
             */
            public int getTotalViewerCount() {
                return totalViewerCount;
            }

            /**
             * Legt den Wert der totalViewerCount-Eigenschaft fest.
             * 
             */
            public void setTotalViewerCount(int value) {
                this.totalViewerCount = value;
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
             *         &lt;element name="ChannelComment" maxOccurs="unbounded">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="CommentID" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *                   &lt;element name="CommentDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *                   &lt;element name="CommentData">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;choice>
             *                             &lt;element name="CommentHeadline" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="CommentText" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                           &lt;/choice>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
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
                "channelComment"
            })
            public static class ChannelComments {

                @XmlElement(name = "ChannelComment", required = true)
                protected List<Users.User.StreamChannel.ChannelComments.ChannelComment> channelComment;

                /**
                 * Gets the value of the channelComment property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the channelComment property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getChannelComment().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Users.User.StreamChannel.ChannelComments.ChannelComment }
                 * 
                 * 
                 */
                public List<Users.User.StreamChannel.ChannelComments.ChannelComment> getChannelComment() {
                    if (channelComment == null) {
                        channelComment = new ArrayList<Users.User.StreamChannel.ChannelComments.ChannelComment>();
                    }
                    return this.channelComment;
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
                 *         &lt;element name="CommentID" type="{http://www.w3.org/2001/XMLSchema}int"/>
                 *         &lt;element name="CommentDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
                 *         &lt;element name="CommentData">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;choice>
                 *                   &lt;element name="CommentHeadline" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="CommentText" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                 &lt;/choice>
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
                    "commentID",
                    "commentDate",
                    "commentData"
                })
                public static class ChannelComment {

                    @XmlElement(name = "CommentID")
                    protected int commentID;
                    @XmlElement(name = "CommentDate", required = true)
                    @XmlSchemaType(name = "date")
                    protected XMLGregorianCalendar commentDate;
                    @XmlElement(name = "CommentData", required = true)
                    protected Users.User.StreamChannel.ChannelComments.ChannelComment.CommentData commentData;

                    /**
                     * Ruft den Wert der commentID-Eigenschaft ab.
                     * 
                     */
                    public int getCommentID() {
                        return commentID;
                    }

                    /**
                     * Legt den Wert der commentID-Eigenschaft fest.
                     * 
                     */
                    public void setCommentID(int value) {
                        this.commentID = value;
                    }

                    /**
                     * Ruft den Wert der commentDate-Eigenschaft ab.
                     * 
                     * @return
                     *     possible object is
                     *     {@link XMLGregorianCalendar }
                     *     
                     */
                    public XMLGregorianCalendar getCommentDate() {
                        return commentDate;
                    }

                    /**
                     * Legt den Wert der commentDate-Eigenschaft fest.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link XMLGregorianCalendar }
                     *     
                     */
                    public void setCommentDate(XMLGregorianCalendar value) {
                        this.commentDate = value;
                    }

                    /**
                     * Ruft den Wert der commentData-Eigenschaft ab.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Users.User.StreamChannel.ChannelComments.ChannelComment.CommentData }
                     *     
                     */
                    public Users.User.StreamChannel.ChannelComments.ChannelComment.CommentData getCommentData() {
                        return commentData;
                    }

                    /**
                     * Legt den Wert der commentData-Eigenschaft fest.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Users.User.StreamChannel.ChannelComments.ChannelComment.CommentData }
                     *     
                     */
                    public void setCommentData(Users.User.StreamChannel.ChannelComments.ChannelComment.CommentData value) {
                        this.commentData = value;
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
                     *       &lt;choice>
                     *         &lt;element name="CommentHeadline" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="CommentText" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *       &lt;/choice>
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "commentHeadline",
                        "commentText"
                    })
                    public static class CommentData {

                        @XmlElement(name = "CommentHeadline")
                        protected String commentHeadline;
                        @XmlElement(name = "CommentText")
                        protected String commentText;

                        /**
                         * Ruft den Wert der commentHeadline-Eigenschaft ab.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getCommentHeadline() {
                            return commentHeadline;
                        }

                        /**
                         * Legt den Wert der commentHeadline-Eigenschaft fest.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setCommentHeadline(String value) {
                            this.commentHeadline = value;
                        }

                        /**
                         * Ruft den Wert der commentText-Eigenschaft ab.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getCommentText() {
                            return commentText;
                        }

                        /**
                         * Legt den Wert der commentText-Eigenschaft fest.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setCommentText(String value) {
                            this.commentText = value;
                        }

                    }

                }

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
             *         &lt;element name="ChannelHeadline" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ChannelInformation" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
                "channelHeadline",
                "channelInformation"
            })
            public static class ChannelDescription {

                @XmlElement(name = "ChannelHeadline", required = true)
                protected String channelHeadline;
                @XmlElement(name = "ChannelInformation", required = true)
                protected String channelInformation;

                /**
                 * Ruft den Wert der channelHeadline-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getChannelHeadline() {
                    return channelHeadline;
                }

                /**
                 * Legt den Wert der channelHeadline-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setChannelHeadline(String value) {
                    this.channelHeadline = value;
                }

                /**
                 * Ruft den Wert der channelInformation-Eigenschaft ab.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getChannelInformation() {
                    return channelInformation;
                }

                /**
                 * Legt den Wert der channelInformation-Eigenschaft fest.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setChannelInformation(String value) {
                    this.channelInformation = value;
                }

            }

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
         *         &lt;element name="FirstName">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;pattern value="[a-zA-Z]*"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="LastName">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;pattern value="[a-zA-Z]*"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Birthday" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="City">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;pattern value="[a-zA-Z]*"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Country">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;pattern value="[a-zA-Z]*"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
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
            "firstName",
            "lastName",
            "birthday",
            "city",
            "country"
        })
        public static class UserInformation {

            @XmlElement(name = "FirstName", required = true)
            protected String firstName;
            @XmlElement(name = "LastName", required = true)
            protected String lastName;
            @XmlElement(name = "Birthday", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar birthday;
            @XmlElement(name = "City", required = true)
            protected String city;
            @XmlElement(name = "Country", required = true)
            protected String country;

            /**
             * Ruft den Wert der firstName-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFirstName() {
                return firstName;
            }

            /**
             * Legt den Wert der firstName-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFirstName(String value) {
                this.firstName = value;
            }

            /**
             * Ruft den Wert der lastName-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLastName() {
                return lastName;
            }

            /**
             * Legt den Wert der lastName-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLastName(String value) {
                this.lastName = value;
            }

            /**
             * Ruft den Wert der birthday-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getBirthday() {
                return birthday;
            }

            /**
             * Legt den Wert der birthday-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setBirthday(XMLGregorianCalendar value) {
                this.birthday = value;
            }

            /**
             * Ruft den Wert der city-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCity() {
                return city;
            }

            /**
             * Legt den Wert der city-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCity(String value) {
                this.city = value;
            }

            /**
             * Ruft den Wert der country-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCountry() {
                return country;
            }

            /**
             * Legt den Wert der country-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCountry(String value) {
                this.country = value;
            }

        }

    }

}
