package restful.webservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import restful.webservice.resources.topics.Topics;
import restful.webservice.resources.topics.Topics.Topic;
import restful.webservice.resources.users.Users;
import restful.webservice.resources.users.Users.User;
import restful.webservice.resources.users.Users.User.StreamChannel;
import restful.webservice.resources.users.Users.User.StreamChannel.ChannelComments;
import restful.webservice.resources.users.Users.User.StreamChannel.ChannelComments.ChannelComment;
import restful.webservice.resources.users.Users.User.StreamChannel.ChannelComments.ChannelComment.CommentData;
import restful.webservice.resources.users.Users.User.StreamChannel.ChannelDescription;

@Path("/Stream")
public class RestfulWebservices
{
	private static final String users_file = "xml/Users.xml";
	private static final String topics_file = "xml/Topics.xml";
	
	//****************************************************************************************************
	//
	//		Methoden für User-Profil
	//		- Alle User-Profile anzeigen	
	//		- User-Profil über den User-Namen suchen
	//		- User-Profil erstellen
	//		- User-Profil bearbeiten
	//		- User-Profil löschen
	//		- User-Profil Login-Passwort ändern
	//		- User-Profil Login-Passwort abfragen
	//		
	//****************************************************************************************************
	
	// Alle registrierten User-Profile anzeigen
	@GET
	@Path("/Users")
	@Produces(MediaType.TEXT_XML)
	public Users showAllUsers() throws FileNotFoundException, JAXBException
	{
		Users user = new Users();
		JAXBContext context;
		context = JAXBContext.newInstance(Users.class);
		Unmarshaller um = context.createUnmarshaller();
		user = (Users) um.unmarshal(new FileReader(users_file));

		return user;
	}
	
	// Ein neues User-Profil erstellen
	@POST
	@Path("/Users/User")
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
	public void createUser(Users file) throws JAXBException, FileNotFoundException
	{
		Users user = new Users();
		JAXBContext context = JAXBContext.newInstance(Users.class);
		Unmarshaller um = context.createUnmarshaller();
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		user = (Users) um.unmarshal(new FileReader(users_file));
		
		List<User> users = user.getUser();
		int size = users.size();
		int last_index = 0;
		
		if (size > 0)
		{
			last_index = users.get(size-1).getUserID();
		}
		
		file.getUser().get(0).setUserID(last_index+1);
		user.getUser().add(file.getUser().get(0));
	
		m.marshal(user, new File(users_file));
	}

	// Ein bestimmtes User-Profil bearbeiten
	@PUT
	@Path("/Users/User/{UserID}/Userprofile")
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
	public void updateProfile(Users file, @PathParam("UserID") int i) throws JAXBException, FileNotFoundException
	{
		Users user = new Users();
		JAXBContext context = JAXBContext.newInstance(Users.class);
		Unmarshaller um = context.createUnmarshaller();
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		user = (Users) um.unmarshal(new FileReader(users_file));
		
		int selectedUser = -1;
		
		for(int j = 0; j < user.getUser().size(); j++)
		{
			if(user.getUser().get(j).getUserID() == i)
			{
				selectedUser = j;
			}
		}
		
		user.getUser().get(selectedUser).getUserInformation().setFirstName(file.getUser().get(0).getUserInformation().getFirstName());
		user.getUser().get(selectedUser).getUserInformation().setLastName(file.getUser().get(0).getUserInformation().getLastName());
		user.getUser().get(selectedUser).getUserInformation().setBirthday(file.getUser().get(0).getUserInformation().getBirthday());
		user.getUser().get(selectedUser).getUserInformation().setCity(file.getUser().get(0).getUserInformation().getCity());
		user.getUser().get(selectedUser).getUserInformation().setCountry(file.getUser().get(0).getUserInformation().getCountry());
		m.marshal(user, new File(users_file));
	}
	
	// Ein bestimmtes User-Profil löschen
	@DELETE
	@Path("/Users/User/{UserID}")
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
	public void deleteUser(@PathParam("UserID") int i) throws JAXBException, FileNotFoundException
	{
		Users user = new Users();
		JAXBContext context = JAXBContext.newInstance(Users.class);
		Unmarshaller um = context.createUnmarshaller();
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		user = (Users) um.unmarshal(new FileReader(users_file));
		
		int selectedUser = 0;
		
		for(int j = 0; j < user.getUser().size(); j++)
		{
			if(user.getUser().get(j).getUserID() == i)
			{
				selectedUser = j;
			}
		}
		
		user.getUser().remove(selectedUser);
		m.marshal(user, new File(users_file));
	}
	
	// Ein bestimmtes User-Profil suchen
	@GET
	@Path("/Users/User/{UserName}")
	@Produces(MediaType.TEXT_XML)
	public Users showUserByName(@PathParam("UserName") String userStreamChannelName) throws FileNotFoundException, JAXBException
	{
		Users user = new Users();
		JAXBContext context = JAXBContext.newInstance(Users.class);
		Unmarshaller um = context.createUnmarshaller();
		user = (Users) um.unmarshal(new FileReader(users_file));
		
		Users selectedUserProfile = new Users();
		int selectedUser = -1;
		
		for(int j = 0; j < user.getUser().size(); j++)
		{
			if(user.getUser().get(j).getUserStreamChannelName().equalsIgnoreCase(userStreamChannelName))
			{
				selectedUser = j;
			}
		}
		
		if(selectedUser == -1)
		{
			return selectedUserProfile;
		}
		
		selectedUserProfile.getUser().add(user.getUser().get(selectedUser));
		return selectedUserProfile;
	}
	
	// Login-Passwort des User-Profils ändern
	@PUT
	@Path("/Users/User/{UserID}/Logindata")
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
	public void changePassword(Users file, @PathParam("UserID") int i) throws JAXBException, FileNotFoundException
	{
		Users user = new Users();
		JAXBContext context = JAXBContext.newInstance(Users.class);
		Unmarshaller um = context.createUnmarshaller();
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		user = (Users) um.unmarshal(new FileReader(users_file));
		
		int selectedUser = -1;
		
		for(int j = 0; j < user.getUser().size(); j++)
		{
			if(user.getUser().get(j).getUserID() == i)
			{
				selectedUser = j;
			}
		}
		
		user.getUser().get(selectedUser).getLogin().setLoginPassword(file.getUser().get(0).getLogin().getLoginPassword());
		m.marshal(user, new File(users_file));
	}
	
	// Login-Passwort des User-Profils abfragen
	@GET
	@Path("/Users/User/{UserName}/Logindata/Loginpassword")
	@Produces(MediaType.TEXT_XML)
	public String showPassword(@PathParam("UserName") String userStreamChannelName) throws JAXBException, FileNotFoundException
	{
		Users user = new Users();
		JAXBContext context = JAXBContext.newInstance(Users.class);
		Unmarshaller um = context.createUnmarshaller();
		user = (Users) um.unmarshal(new FileReader(users_file));
		
		int selectedUser = -1;
		
		for(int j = 0; j < user.getUser().size(); j++)
		{
			if(user.getUser().get(j).getUserStreamChannelName().equalsIgnoreCase(userStreamChannelName))
			{
				selectedUser = j;
			}
		}
		
		if(selectedUser == -1)
		{
			return null;
		}
		
		return user.getUser().get(selectedUser).getLogin().getLoginPassword();
	}
	
	//****************************************************************************************************
	//
	//		Methoden für Streamchannel
	//		- Streamchannel anzeigen
	//		- Streamchannel erstellen
	//		- Streamchannel bearbeiten
	//		- Streamchannel löschen
	//		
	//****************************************************************************************************
	
	// Einen bestimmten Streamchannel anzeigen
	@GET
	@Path("/Users/User/{UserID}/Streamchannel")
	@Produces(MediaType.TEXT_XML)
	public Users showStreamchannel(@PathParam("UserID") int i) throws JAXBException, FileNotFoundException
	{
		Users user = new Users();
		JAXBContext context = JAXBContext.newInstance(Users.class);
		Unmarshaller um = context.createUnmarshaller();
		user = (Users) um.unmarshal(new FileReader(users_file));
		
		Users newUsers = new Users();
		User newUser = new User();
		
		int selectedUser = -1;
		
		for(int j = 0; j < user.getUser().size(); j++)
		{
			if(user.getUser().get(j).getUserID() == i)
			{
				selectedUser = j;
			}
		}
		
		if(user.getUser().get(selectedUser).getStreamChannel() == null)
		{
			newUsers.getUser().add(newUser);
			newUsers.getUser().get(0).setStreamChannel(new StreamChannel());
			return newUsers;
		}
		
		newUsers.getUser().add(newUser);
		newUsers.getUser().get(0).setStreamChannel(user.getUser().get(selectedUser).getStreamChannel());
		return newUsers;
	}
	
	// Einen Streamchannel erstellen
	@POST
	@Path("/Users/User/{UserID}/Streamchannel")
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
	public void createStreamchannel(Users file, @PathParam("UserID") int i) throws JAXBException, FileNotFoundException
	{
		Users user = new Users();
		JAXBContext context = JAXBContext.newInstance(Users.class);
		Unmarshaller um = context.createUnmarshaller();
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		user = (Users) um.unmarshal(new FileReader(users_file));
		
		int selectedUser = -1;
		
		for(int j = 0; j < user.getUser().size(); j++)
		{
			if(user.getUser().get(j).getUserID() == i)
			{
				selectedUser = j;
			}
		}
		
		StreamChannel newStreamChannel = new StreamChannel();
		ChannelDescription newChannelDescription = new ChannelDescription();
		user.getUser().get(selectedUser).setStreamChannel(newStreamChannel);
		user.getUser().get(selectedUser).getStreamChannel().setChannelDescription(newChannelDescription);
		user.getUser().get(selectedUser).getStreamChannel().setChannelTopic(file.getUser().get(0).getStreamChannel().getChannelTopic());
		user.getUser().get(selectedUser).getStreamChannel().getChannelDescription().setChannelHeadline(file.getUser().get(0).getStreamChannel().getChannelDescription().getChannelHeadline());
		user.getUser().get(selectedUser).getStreamChannel().getChannelDescription().setChannelInformation(file.getUser().get(0).getStreamChannel().getChannelDescription().getChannelInformation());
		user.getUser().get(selectedUser).getStreamChannel().setChannelComments(file.getUser().get(0).getStreamChannel().getChannelComments());
		m.marshal(user, new File(users_file));
	}

	// Einen Streamchannel bearbeiten
	@PUT
	@Path("/Users/User/{UserID}/Streamchannel")
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
	public void updateStreamchannel(Users file, @PathParam("UserID") int i) throws JAXBException, FileNotFoundException
	{
		Users user = new Users();
		JAXBContext context = JAXBContext.newInstance(Users.class);
		Unmarshaller um = context.createUnmarshaller();
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		user = (Users) um.unmarshal(new FileReader(users_file));
		
		int selectedUser = -1;
		
		for(int j = 0; j < user.getUser().size(); j++)
		{
			if(user.getUser().get(j).getUserID() == i)
			{
				selectedUser = j;
			}
		}
		
		user.getUser().get(selectedUser).getStreamChannel().setChannelTopic(file.getUser().get(0).getStreamChannel().getChannelTopic());
		user.getUser().get(selectedUser).getStreamChannel().getChannelDescription().setChannelHeadline(file.getUser().get(0).getStreamChannel().getChannelDescription().getChannelHeadline());
		user.getUser().get(selectedUser).getStreamChannel().getChannelDescription().setChannelInformation(file.getUser().get(0).getStreamChannel().getChannelDescription().getChannelInformation());
		m.marshal(user, new File(users_file));
	}
	
	// Einen Streamchannel löschen
	@DELETE
	@Path("/Users/User/{UserID}/Streamchannel")
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
	public void deleteStreamchannel(@PathParam("UserID") int i) throws JAXBException, FileNotFoundException
	{
		Users user = new Users();
		JAXBContext context = JAXBContext.newInstance(Users.class);
		Unmarshaller um = context.createUnmarshaller();
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		user = (Users) um.unmarshal(new FileReader(users_file));
		
		int selectedUser = -1;
		
		for(int j = 0; j < user.getUser().size(); j++)
		{
			if(user.getUser().get(j).getUserID() == i)
			{
				selectedUser = j;
			}
		}
		
		user.getUser().get(selectedUser).setStreamChannel(new StreamChannel());
		m.marshal(user, new File(users_file));
	}
	
	
	//****************************************************************************************************
	//
	//		Methoden für Kommentare eines Streamchannels
	//		- Kommentare anzeigen
	//		- Kommentar erstellen
	//		- Kommentar löschen
	//		
	//****************************************************************************************************
	
	// Kommentare eines Streamchannels anzeigen
	@GET
	@Path("/Users/User/{UserID}/Streamchannel/Channelcomments")
	@Produces(MediaType.TEXT_XML)
	public Users showStreamchannelComments(@PathParam("UserID") int i) throws JAXBException, FileNotFoundException
	{
		Users user = new Users();
		JAXBContext context = JAXBContext.newInstance(Users.class);
		Unmarshaller um = context.createUnmarshaller();
		user = (Users) um.unmarshal(new FileReader(users_file));
		
		int selectedUser = -1;
		
		for(int j = 0; j < user.getUser().size(); j++)
		{
			if(user.getUser().get(j).getUserID() == i)
			{
				selectedUser = j;
			}
		}
		
		List<ChannelComment> channelComment = user.getUser().get(selectedUser).getStreamChannel().getChannelComments().getChannelComment();
		
		Users newUsers = new Users();
		User newUser = new User();
		StreamChannel newStreamchannel = new StreamChannel();
		ChannelComments newChannelcomments = new ChannelComments();
		
		newStreamchannel.setChannelComments(newChannelcomments);
		newUser.setStreamChannel(newStreamchannel);
		newUsers.getUser().add(newUser);
		
		for(ChannelComment cc : channelComment)
		{
			newUsers.getUser().get(selectedUser).getStreamChannel().getChannelComments().getChannelComment().add(cc);
		}
		
		return newUsers;
	}
	
	// Einen neuen Kommentar für einen Streamchannel erstellen
	@POST
	@Path("/Users/User/{UserID}/Streamchannel/Channelcomments")
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
 	public void createStreamComment(Users file, @PathParam("UserID") int i) throws JAXBException, FileNotFoundException, DatatypeConfigurationException
	{
		Users user = new Users();
		JAXBContext context = JAXBContext.newInstance(Users.class);
		Unmarshaller um = context.createUnmarshaller();
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		user = (Users) um.unmarshal(new FileReader(users_file));
		
		int selectedUser = -1;
		
		for(int j = 0; j < user.getUser().size(); j++)
		{
			if(user.getUser().get(j).getUserID() == i)
			{
				selectedUser = j;
			}
		}
		
		List<ChannelComment> channelComments = user.getUser().get(selectedUser).getStreamChannel().getChannelComments().getChannelComment();
		int commentSize = channelComments.size();
		int lastComment = 0;
		
		if(commentSize > 0)
		{
			lastComment = channelComments.get(commentSize-1).getCommentID();
		}
		
		ChannelComment newChannelComment = new ChannelComment();
		CommentData newCommentData = new CommentData();
		
		newChannelComment.setCommentID(lastComment+1);
		newChannelComment.setCommentDate(file.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(0).getCommentDate());
		newChannelComment.setCommentData(newCommentData);
		newCommentData.setCommentHeadline(file.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(0).getCommentData().getCommentHeadline());
		newCommentData.setCommentText(file.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(0).getCommentData().getCommentText());
		
		user.getUser().get(selectedUser).getStreamChannel().getChannelComments().getChannelComment().add(newChannelComment);
		m.marshal(user, new File(users_file));
	}
	
	// Einen Kommentar eines Streamchannels löschen
	@DELETE
	@Path("/Users/User/{UserID}/Streamchannel/Channelcomments/Comment/{CommentID}")
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
	public void deleteStreamComment(@PathParam("UserID")int i, @PathParam("CommentID") int j) throws JAXBException, FileNotFoundException
	{
		Users user = new Users();
		JAXBContext context = JAXBContext.newInstance(Users.class);
		Unmarshaller um = context.createUnmarshaller();
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		user = (Users) um.unmarshal(new FileReader(users_file));
		
		int selectedUser = -1;
		
		for(int x = 0; x < user.getUser().size(); x++)
		{
			if(user.getUser().get(x).getUserID() == i)
			{
				selectedUser = x;
			}
		}
		
		int selectedComment = -1;
		
		for(int x = 0; x < user.getUser().get(selectedUser).getStreamChannel().getChannelComments().getChannelComment().size(); x++)
		{
			if(user.getUser().get(selectedUser).getStreamChannel().getChannelComments().getChannelComment().get(x).getCommentID() == j)
			{
				selectedComment = x;
			}
		}
		
		user.getUser().get(selectedUser).getStreamChannel().getChannelComments().getChannelComment().remove(selectedComment);
		m.marshal(user, new File(users_file));
	}
	
	//****************************************************************************************************
	//
	//		Methoden für Topics
	//		- Alle Topics anzeigen
	//		- Ein Topic anzeigen
	//		- Topic erstellen
	//		
	//****************************************************************************************************
	
	// Alle Topics anzeigen
	@GET
	@Path("/Topics")
	@Produces(MediaType.TEXT_XML)
	public Topics showAllTopics() throws JAXBException, FileNotFoundException
	{
		JAXBContext context = JAXBContext.newInstance(Topics.class);
		Unmarshaller um = context.createUnmarshaller();
		Topics topic = (Topics) um.unmarshal(new FileReader(topics_file));
		
		return topic;
	}
	
	// Ein bestimmtes Topic anzeigen
	@GET
	@Path("/Topics/Topic/{TopicName}")
	@Produces(MediaType.TEXT_XML)
	public Topics showTopicByName(@PathParam("TopicName") String topicName) throws JAXBException, FileNotFoundException
	{
		Topics topic = new Topics();
		JAXBContext context = JAXBContext.newInstance(Topics.class);
		Unmarshaller um = context.createUnmarshaller();
		topic = (Topics) um.unmarshal(new FileReader(topics_file));
		
		int selectedTopic = -1;
		
		for(int j = 0; j < topic.getTopic().size(); j++)
		{
			if(topic.getTopic().get(j).getTopicName().equalsIgnoreCase(topicName))
			{
				selectedTopic = j;
			}
		}
		
		if(selectedTopic == -1)
		{
			Topics selectedTopicName = new Topics();
			return selectedTopicName;
		}
		
		Topics selectedTopicName = new Topics();
		selectedTopicName.getTopic().add(topic.getTopic().get(selectedTopic));
			
		return selectedTopicName;
	}
	
	// Ein neues Topic erstellen
	@POST
	@Path("/Topics/Topic")
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
	public void createTopic(Topics file) throws JAXBException, FileNotFoundException
	{
		JAXBContext context = JAXBContext.newInstance(Topics.class);
		Unmarshaller um = context.createUnmarshaller();
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		Topics topic = (Topics) um.unmarshal(new FileReader(topics_file));
		
		List<Topic> topics = topic.getTopic();
		int size = topics.size();
		int last_index = 0;
		
		if (size > 0)
		{
			last_index = topics.get(size-1).getTopicID();
		}
		
		file.getTopic().get(0).setTopicID(last_index+1);
		topic.getTopic().add(file.getTopic().get(0));
	
		m.marshal(topic, new File(topics_file));
	}
}