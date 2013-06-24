package restful.webservice;

import java.io.FileNotFoundException;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.XMLGregorianCalendar;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import restful.webservice.resources.topics.Topics;
import restful.webservice.resources.topics.Topics.Topic;
import restful.webservice.resources.users.Users;
import restful.webservice.resources.users.Users.User;
import restful.webservice.resources.users.Users.User.Login;
import restful.webservice.resources.users.Users.User.StreamChannel;
import restful.webservice.resources.users.Users.User.StreamChannel.ChannelComments.ChannelComment;
import restful.webservice.resources.users.Users.User.StreamChannel.ChannelComments.ChannelComment.CommentData;
import restful.webservice.resources.users.Users.User.UserInformation;
import restful.webservice.resources.users.Users.User.StreamChannel.ChannelComments;
import restful.webservice.resources.users.Users.User.StreamChannel.ChannelDescription;

public class RestfulWebservicesSchnittstellen
{
	static String webURI = "http://localhost:8080/Stream";
	
	// Userprofile Schnittstellen
	public Users showAllUsers()
	{
		String url = webURI + "/Users";
		WebResource wrs = Client.create().resource(url);
		Users text = wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).get(Users.class);
		return text;
	}
	
	public void createUserProfile(String newLoginName, String newLoginPassword, String newFirstName, String newLastName, XMLGregorianCalendar newBirthday, String newCity, String newCountry) throws FileNotFoundException, JAXBException
	{
		User registeredUser = new User();
		Users users = new Users();
		Login login = new Login();
		registeredUser.setLogin(login);
		registeredUser.getLogin().setLoginName(newLoginName);
		registeredUser.getLogin().setLoginPassword(newLoginPassword);
		registeredUser.setUserStreamChannelName(newLoginName);
		UserInformation userInformation = new UserInformation();
		StreamChannel newStreamChannel = new StreamChannel();
		registeredUser.setUserInformation(userInformation);
		registeredUser.setStreamChannel(newStreamChannel);
		registeredUser.getUserInformation().setFirstName(newFirstName);
		registeredUser.getUserInformation().setLastName(newLastName);
		registeredUser.getUserInformation().setBirthday(newBirthday);
		registeredUser.getUserInformation().setCity(newCity);
		registeredUser.getUserInformation().setCountry(newCountry);
		users.getUser().add(registeredUser);
		
		String url = webURI + "/Users/User/";
		WebResource wrs = Client.create().resource(url);
		wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).post(users);
	}
	
	public Users showUserProfile(String userName) throws FileNotFoundException, JAXBException
	{	
		String url = webURI + "/Users/User/" + userName;
		WebResource wrs = Client.create().resource(url);
		Users text = wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).get(Users.class);
		return text;
	}
	
	public boolean checkUserExists(String userName) throws FileNotFoundException, JAXBException
	{
		String url = webURI + "/Users/User/" + userName;
		WebResource wrs = Client.create().resource(url);
		Users text = wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).get(Users.class);
		
		if(text.getUser().size() == 0)
		{
			return false;
		}
		
		return true;
	}
	
	public void updateUserProfile(int userID, String newFirstName, String newLastName, XMLGregorianCalendar newBirthday, String newCity, String newCountry) throws FileNotFoundException, JAXBException
	{
		User changedUser = new User();
		Users users = new Users();
		UserInformation userInformation = new UserInformation();
		changedUser.setUserInformation(userInformation);
		changedUser.getUserInformation().setFirstName(newFirstName);
		changedUser.getUserInformation().setLastName(newLastName);
		changedUser.getUserInformation().setBirthday(newBirthday);
		changedUser.getUserInformation().setCity(newCity);
		changedUser.getUserInformation().setCountry(newCountry);
		users.getUser().add(changedUser);
		
		String url = webURI + "/Users/User/" + userID + "/Userprofile";
		WebResource wrs = Client.create().resource(url);
		wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).put(users);
	}
	
	public void deleteUserProfile(String userName) throws FileNotFoundException, JAXBException
	{
		int userID = getUserID(userName);
		String url = webURI + "/Users/User/" + userID;
		WebResource wrs = Client.create().resource(url);
		wrs.delete();
	}
	
	public void setNewPassword(int userID, String newPassword) throws FileNotFoundException, JAXBException
	{
		User changedUser = new User();
		Users user = new Users();
		Login login = new Login();
		changedUser.setLogin(login);
		changedUser.getLogin().setLoginPassword(newPassword);
		user.getUser().add(changedUser);
		
		String url = webURI + "/Users/User/" + userID + "/Logindata";
		WebResource wrs = Client.create().resource(url);
		wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).put(user);
	}
	
	public boolean compareUsers(String userName) throws FileNotFoundException, JAXBException
	{
		String url = webURI + "/Users/User/" + userName;
		WebResource wrs = Client.create().resource(url);
		Users text = wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).get(Users.class);
		
		if(text.getUser().size() == 0)
		{
			return false;
		}
		
		return true;
	}

	public boolean comparePasswords(String userName, String userPassword) throws FileNotFoundException, JAXBException
	{
		String url = webURI + "/Users/User/" + userName + "/Logindata/Loginpassword";
		WebResource wrs = Client.create().resource(url);
		String text = wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).get(String.class);
		
		if(text.equals(userPassword))
		{
			return true;
		}
		
		return false;
	}

	public int getUserID(String userName) throws FileNotFoundException, JAXBException
	{
		String url = webURI + "/Users/User/" + userName;
		WebResource wrs = Client.create().resource(url);
		Users text = wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).get(Users.class);
		int userID = text.getUser().get(0).getUserID();
		return userID;
	}
	
	public Users showAllUsersWithStreamChannelCreated() throws FileNotFoundException, JAXBException
	{
		Users user = new Users();
		Users text = showAllUsers();
		
		for(int i = 0; i < text.getUser().size(); i++)
		{
			int userID = getUserID(text.getUser().get(i).getUserStreamChannelName());
			
			if(checkStreamchannelExists(userID))
			{
				user.getUser().add(text.getUser().get(i));
			}
		}
		
		return user;
	}
	// Userprofile Schnittstellen
	
	// Topic Schnittstellen
	public boolean searchTopic(String topicName) throws FileNotFoundException, JAXBException
	{
		String url = webURI + "/Topics/Topic/" + topicName;
		WebResource wrs = Client.create().resource(url);
		Topics text = wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).get(Topics.class);
		
		if(text.getTopic().size() == 0)
		{
			return false;
		}
		
		return true;
	}
	
	public void createTopic(String newTopicName) throws FileNotFoundException, JAXBException
	{
		Topic newTopic = new Topic();
		Topics topics = new Topics();
		newTopic.setTopicName(newTopicName);
		newTopic.setTopicViewerCount(0);
		topics.getTopic().add(newTopic);
		
		String url = webURI + "/Topics/Topic";
		WebResource wrs = Client.create().resource(url);
		wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).post(topics);
	}
	
	public Users showStreamerUsingTopic(String topicName) throws FileNotFoundException, JAXBException
	{
		Users allUsers = showAllUsersWithStreamChannelCreated();
		Topics allTopics = showAllTopics();
		Users users = new Users();
		
		for(int i = 0; i < allUsers.getUser().size(); i++)
		{
			for(int j = 0; j < allTopics.getTopic().size(); j++)
			{
				if(allUsers.getUser().get(i).getStreamChannel().getChannelTopic().equalsIgnoreCase(allTopics.getTopic().get(j).getTopicName()))
				{
					User user = new User();
					user.setUserStreamChannelName(allUsers.getUser().get(i).getUserStreamChannelName());
					users.getUser().add(user);
				}
			}
		}

		return users;
	}
	
	public Topics showAllTopics()
	{
		String url = webURI + "/Topics";
		WebResource wrs = Client.create().resource(url);
		Topics text = wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).get(Topics.class);
		return text;
	}
	// Topic Schnittstellen
	
	// Streamchannel Schnittstellen
	public boolean checkStreamchannelExists(int userID) throws FileNotFoundException, JAXBException
	{
		String url = webURI + "/Users/User/" + userID + "/Streamchannel";
		WebResource wrs = Client.create().resource(url);
		Users text = wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).get(Users.class);
		
		if(text.getUser().get(0).getStreamChannel().getChannelDescription() == null)
		{
			return false;
		}
		
		return true;
	}
	
	public void updateStreamchannel(int userID, String newTopic, String newHeadline, String newInformation) throws FileNotFoundException, JAXBException
	{
		Users users = new Users();
	    User user = new User();
	    StreamChannel changedStreamChannel = new StreamChannel();
	    ChannelDescription channelDescription = new ChannelDescription();
	    user.setStreamChannel(changedStreamChannel);
	    changedStreamChannel.setChannelDescription(channelDescription);
	    channelDescription.setChannelHeadline(newHeadline);
	    channelDescription.setChannelInformation(newInformation);
	    changedStreamChannel.setChannelTopic(newTopic);
	    users.getUser().add(user);
	    
	    String url = webURI + "/Users/User/" + userID + "/Streamchannel";
		WebResource wrs = Client.create().resource(url);
		wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).put(users);
	}
	
	public void createStreamchannel(int userID, String newTopic, String newHeadline, String newInformation) throws FileNotFoundException, JAXBException
	{
		Users users = new Users();
	    User user = new User();
	    ChannelComments newChannelComments = new ChannelComments();
	    StreamChannel newStreamChannel = new StreamChannel();
	    ChannelDescription newChannelDescription = new ChannelDescription();
	    user.setStreamChannel(newStreamChannel);
	    newStreamChannel.setChannelDescription(newChannelDescription);
	    newStreamChannel.setChannelComments(newChannelComments);
	    newChannelDescription.setChannelHeadline(newHeadline);
	    newChannelDescription.setChannelInformation(newInformation);
	    newStreamChannel.setChannelTopic(newTopic);
	    users.getUser().add(user);
	    
	    String url = webURI + "/Users/User/" + userID + "/Streamchannel";
		WebResource wrs = Client.create().resource(url);
		wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).post(users);
	}
	
	public void deleteStreamchannel(int userID) throws FileNotFoundException, JAXBException
	{
		String url = webURI + "/Users/User/" + userID + "/Streamchannel";
		WebResource wrs = Client.create().resource(url);
		wrs.delete();
	}
	

	public Users showStreamchannel(int userID)
	{
		String url = webURI + "/Users/User/" + userID + "/Streamchannel";
		WebResource wrs = Client.create().resource(url);
		Users text = wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).get(Users.class);
		return text;
	}
	
	// Kommentar Schnittstellen
	public Users showStreamchannelComments(String userName) throws FileNotFoundException, JAXBException
	{
		int userID = getUserID(userName);
		String url = webURI + "/Users/User/" + userID + "/Streamchannel/Channelcomments";
		WebResource wrs = Client.create().resource(url);
		Users text = wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).get(Users.class);
		return text;
	}
	
	public int getNumberOfStreamchannelComments(String userName) throws FileNotFoundException, JAXBException
	{
		int userID = getUserID(userName);
		String url = webURI + "/Users/User/" + userID + "/Streamchannel/Channelcomments";
		WebResource wrs = Client.create().resource(url);
		Users text = wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).get(Users.class);
		int numberOfComments = text.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().size();
		return numberOfComments;
	}
	
	public void createStreamchannelComment(String userName, XMLGregorianCalendar newCommentDate, String newCommentHeadline, String newText) throws FileNotFoundException, JAXBException
	{
		int userID = getUserID(userName);
		Users users = new Users();
	    User user = new User();
	    ChannelComments newChannelComments = new ChannelComments();
	    CommentData newCommentData = new CommentData();
	    StreamChannel newStreamChannel = new StreamChannel();
	    ChannelComment newChannelComment = new ChannelComment();
	    user.setStreamChannel(newStreamChannel);
	    newStreamChannel.setChannelComments(newChannelComments);
	    newChannelComments.getChannelComment().add(newChannelComment);
	    newChannelComment.setCommentDate(newCommentDate);
	    newChannelComment.setCommentData(newCommentData);
	    newChannelComment.getCommentData().setCommentHeadline(newCommentHeadline);
	    newChannelComment.getCommentData().setCommentText(newText);
	    users.getUser().add(user);
	    
	    String url = webURI + "/Users/User/" + userID + "/Streamchannel/Channelcomments";
		WebResource wrs = Client.create().resource(url);
		wrs.type(MediaType.TEXT_XML).accept(MediaType.TEXT_XML).post(users);
	}
	
	public void deleteStreamchannelComment(String userName, int commentID) throws FileNotFoundException, JAXBException
	{
		int userID = getUserID(userName);
		String url = webURI + "/Users/User/" + userID + "/Streamchannel/Channelcomments/Comment/" + commentID;
		WebResource wrs = Client.create().resource(url);
		wrs.delete();
	}
	// Kommentar Schnittstellen
}