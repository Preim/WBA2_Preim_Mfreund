//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.06.22 um 08:23:53 PM CEST 
//


package restful.webservice.resources.users;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the restful.webservice.resources.users package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: restful.webservice.resources.users
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Users }
     * 
     */
    public Users createUsers() {
        return new Users();
    }

    /**
     * Create an instance of {@link Users.User }
     * 
     */
    public Users.User createUsersUser() {
        return new Users.User();
    }

    /**
     * Create an instance of {@link Users.User.StreamChannel }
     * 
     */
    public Users.User.StreamChannel createUsersUserStreamChannel() {
        return new Users.User.StreamChannel();
    }

    /**
     * Create an instance of {@link Users.User.StreamChannel.ChannelComments }
     * 
     */
    public Users.User.StreamChannel.ChannelComments createUsersUserStreamChannelChannelComments() {
        return new Users.User.StreamChannel.ChannelComments();
    }

    /**
     * Create an instance of {@link Users.User.StreamChannel.ChannelComments.ChannelComment }
     * 
     */
    public Users.User.StreamChannel.ChannelComments.ChannelComment createUsersUserStreamChannelChannelCommentsChannelComment() {
        return new Users.User.StreamChannel.ChannelComments.ChannelComment();
    }

    /**
     * Create an instance of {@link Users.User.Login }
     * 
     */
    public Users.User.Login createUsersUserLogin() {
        return new Users.User.Login();
    }

    /**
     * Create an instance of {@link Users.User.UserInformation }
     * 
     */
    public Users.User.UserInformation createUsersUserUserInformation() {
        return new Users.User.UserInformation();
    }

    /**
     * Create an instance of {@link Users.User.StreamChannel.ChannelDescription }
     * 
     */
    public Users.User.StreamChannel.ChannelDescription createUsersUserStreamChannelChannelDescription() {
        return new Users.User.StreamChannel.ChannelDescription();
    }

    /**
     * Create an instance of {@link Users.User.StreamChannel.ChannelComments.ChannelComment.CommentData }
     * 
     */
    public Users.User.StreamChannel.ChannelComments.ChannelComment.CommentData createUsersUserStreamChannelChannelCommentsChannelCommentCommentData() {
        return new Users.User.StreamChannel.ChannelComments.ChannelComment.CommentData();
    }

}