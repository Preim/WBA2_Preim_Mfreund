package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.jivesoftware.smack.XMPPException;

import restful.webservice.RestfulWebservicesSchnittstellen;
import restful.webservice.resources.users.Users;
import restful.webservice.resources.users.Users.User;
import restful.webservice.resources.users.Users.User.StreamChannel;
import restful.webservice.resources.users.Users.User.StreamChannel.ChannelComments;
import restful.webservice.resources.users.Users.User.StreamChannel.ChannelComments.ChannelComment;
import xmpp.ItemEventCoordinator;
import xmpp.XMPP_Schnittstellen;

public class GuiClient
{
	RestfulWebservicesSchnittstellen rwS = new RestfulWebservicesSchnittstellen();
	public XMPP_Schnittstellen xmpp;
	public ItemEventCoordinator iec;
	String foundUser = "";
	String loggedInUser = "";

    public static void main(String[] args) throws XMPPException
    {    
        new GuiClient();
    }
    
    public GuiClient()
    {
    	//####################################################################################################
	    //####################################################################################################
    	// Suche-Screen
	    	//================================================================================================
			//================================================================================================
    		// Topic Suche Buttons
    			JPanel resultTopicListshowStreamchannelButtons = new JPanel();
		    	final JButton resultTopicListshowStreamchannel1Button = new JButton("Streamchannel besuchen");
		    	final JButton resultTopicListshowStreamchannel2Button = new JButton("Streamchannel besuchen");
		    	final JButton resultTopicListshowStreamchannel3Button = new JButton("Streamchannel besuchen");
		    	final JButton resultTopicListshowStreamchannel4Button = new JButton("Streamchannel besuchen");
		    	final JButton resultTopicListshowStreamchannel5Button = new JButton("Streamchannel besuchen");
				
				resultTopicListshowStreamchannelButtons.setBounds(300, 150, 250, 250);
				resultTopicListshowStreamchannelButtons.setLayout(new GridLayout(5, 1));
				resultTopicListshowStreamchannelButtons.add(resultTopicListshowStreamchannel1Button);
				resultTopicListshowStreamchannelButtons.add(resultTopicListshowStreamchannel2Button);
				resultTopicListshowStreamchannelButtons.add(resultTopicListshowStreamchannel3Button);
				resultTopicListshowStreamchannelButtons.add(resultTopicListshowStreamchannel4Button);
				resultTopicListshowStreamchannelButtons.add(resultTopicListshowStreamchannel5Button);
			// Topic Suche Buttons
			//================================================================================================
			//================================================================================================
    		// Topic Suche
    			JLabel resultTopicText = new JLabel();
    			final JLabel resultTopicNameSearchedText = new JLabel();
    			JLabel resultTopicText2 = new JLabel();
    			JPanel resultTopicHead = new JPanel();
    			JPanel resultTopicList = new JPanel();
    			final JLabel resultTopicListItem1 = new JLabel();
    			final JLabel resultTopicListItem2 = new JLabel();
    			final JLabel resultTopicListItem3 = new JLabel();
    			final JLabel resultTopicListItem4 = new JLabel();
    			final JLabel resultTopicListItem5 = new JLabel();
    			final JLabel resultTopicListItem6 = new JLabel();

    			resultTopicText.setText("Ergebnisse der Themensuche");
    			resultTopicText2.setText("Gefundene Streamer");
    			resultTopicHead.setLayout(new GridLayout(2, 1));
    			resultTopicHead.setBounds(100, 100, 824, 50);
    			resultTopicHead.add(resultTopicText);
    			resultTopicHead.add(resultTopicNameSearchedText);  			
    			resultTopicText2.setBounds(50, 0, 300, 50);
    			resultTopicListItem1.setBounds(50, 50, 300, 50);
    			resultTopicListItem2.setBounds(50, 100, 300, 50);
    			resultTopicListItem3.setBounds(50, 150, 300, 50);
    			resultTopicListItem4.setBounds(50, 200, 300, 50);
    			resultTopicListItem5.setBounds(50, 250, 300, 50);
    			resultTopicListItem6.setBounds(50, 300, 300, 50);
    			resultTopicListItem6.setText("Es gibt keine Streamer zu Ihrem Thema!");
    			resultTopicListItem6.setVisible(false);
    			resultTopicList.setBounds(100, 100, 824, 518);
    			resultTopicList.setLayout(null);
    			resultTopicList.add(resultTopicText2);
    			resultTopicList.add(resultTopicListItem1);
    			resultTopicList.add(resultTopicListItem2);
    			resultTopicList.add(resultTopicListItem3);
    			resultTopicList.add(resultTopicListItem4);
    			resultTopicList.add(resultTopicListItem5);
    			resultTopicList.add(resultTopicListItem6);
    		// Topic Suche
    		//================================================================================================
			//================================================================================================
	    	final JPanel searchScreenTopic = new JPanel();
	    	
	    	searchScreenTopic.setBounds(0, 0, 1024, 768);
	    	searchScreenTopic.setBackground(Color.white);
	    	searchScreenTopic.setVisible(false);
	    	searchScreenTopic.setLayout(null);
	    	searchScreenTopic.add(resultTopicHead);
	    	searchScreenTopic.add(resultTopicList);
	    	searchScreenTopic.add(resultTopicListshowStreamchannelButtons);
    	// Suche-Screen
    	//####################################################################################################
	    //####################################################################################################
        // Register-Screen
	    	//================================================================================================
			//================================================================================================
		    // Register-InputFelder-Panel
		        final JTextField registerLoginNameTextField = new JTextField();
		        final JTextField registerLoginPasswordTextField = new JTextField();
		        final JTextField registerFirstNameTextField = new JTextField();
		        final JTextField registerLastNameTextField = new JTextField();
		        final JTextField registerBirthdayTextField = new JTextField();
		        final JTextField registerCityTextField = new JTextField();
		        final JTextField registerCountryTextField = new JTextField();
		        JLabel registerLoginNameText = new JLabel();
		        JLabel registerLoginPasswordText = new JLabel();
		        JLabel registerFirstNameText = new JLabel();
		        JLabel registerLastNameText = new JLabel();
		        JLabel registerBirthdayText = new JLabel();
		        JLabel registerCityText = new JLabel();
		        JLabel registerCountryText = new JLabel();
		        JLabel registerText = new JLabel();
		        JPanel registerInputFields = new JPanel();
		         
		        registerLoginNameText.setBounds(0, 0, 300, 50);
		        registerLoginNameText.setText("Username");
		        registerLoginNameTextField.setBounds(300, 0, 100, 50);
		        registerLoginPasswordText.setText("Password");
		        registerFirstNameText.setText("Vorname");
		        registerLastNameText.setText("Nachname");
		        registerCityText.setText("Stadt");
		        registerCountryText.setText("Land");
		        registerBirthdayText.setText("Geburtstag (MM/dd/yyyy hh:mm)");
		        registerInputFields.setLayout(new GridLayout(7, 2));
		        registerInputFields.setBounds(200, 100, 400, 500);
		        registerInputFields.setBackground(Color.LIGHT_GRAY);
		        registerInputFields.add(registerLoginNameText);
		        registerInputFields.add(registerLoginNameTextField);
		        registerInputFields.add(registerLoginPasswordText);
		        registerInputFields.add(registerLoginPasswordTextField);
		        registerInputFields.add(registerFirstNameText);
		        registerInputFields.add(registerFirstNameTextField);
		        registerInputFields.add(registerLastNameText);
		        registerInputFields.add(registerLastNameTextField);
		        registerInputFields.add(registerBirthdayText);
		        registerInputFields.add(registerBirthdayTextField);
		        registerInputFields.add(registerCityText);
		        registerInputFields.add(registerCityTextField);
		        registerInputFields.add(registerCountryText);
		        registerInputFields.add(registerCountryTextField);
		    // Register-InputFelder-Panel
			//================================================================================================
		    //================================================================================================
			// Register-Buttons
		        JPanel registerButtons = new JPanel();
		        JButton registerSubmitButton = new JButton("Registrieren");
		        JButton registerCancelButton = new JButton("Abbrechen");
		        
		        registerButtons.setLayout(new GridLayout(1, 1));
		        registerButtons.setVisible(true);
		        registerButtons.setBounds(200, 600, 400, 50);
		        registerButtons.add(registerCancelButton);
		        registerButtons.add(registerSubmitButton);
		    // Register-Buttons
		    //================================================================================================
			//================================================================================================
		    // Register-Text
		        registerText.setText("Registrierung");
		        registerText.setBounds(300, 50, 300, 50);
		    // Register-Text
	        //================================================================================================
		    //================================================================================================
		    final JPanel registerScreen = new JPanel();
		    
		    registerScreen.setBounds(0, 0, 1024, 768);
		    registerScreen.setBackground(Color.white);
		    registerScreen.setVisible(false);
		    registerScreen.setLayout(null);
		    registerScreen.add(registerText);
		    registerScreen.add(registerButtons);
		    registerScreen.add(registerInputFields);
        // Register-Screen
        //####################################################################################################		    
        //####################################################################################################
		// Streamchannel-Screen
		    //================================================================================================
			//================================================================================================
			// Streamchannel von anderen Usern
				// Streamchannel von anderen Usern-Buttons
			        JButton streamchannelOtherUsersCommentsPostCommentButton = new JButton("Kommentar erstellen");
			        JButton streamchannelOtherUsersSubscribeChannelButton = new JButton("Subscribe Channel");
			        JButton streamchannelOtherUsersUnscribeChannelButton = new JButton("Unscribe Channel");
			        JButton streamchannelOtherUsersLeaveChannelButton = new JButton("Streamchannel verlassen");
			    // Streamchannel von anderen Usern-Buttons
			//================================================================================================
			//================================================================================================
			    // Streamchannel von anderen Usern-InputFelder-Panel
				    JPanel streamchannelOtherUsersOutputFields = new JPanel();
			    	final JLabel streamchannelOtherUsersTopicText = new JLabel();
			        final JLabel streamchannelOtherUsersHeadlineText = new JLabel();
			        final JLabel streamchannelOtherUsersInformationText = new JLabel();
			        final JLabel streamchannelOtherUsersText_Info = new JLabel();
			        final JTextField streamchannelOtherUsersCommentHeadlineValue = new JTextField();
			        final JTextField streamchannelOtherUsersCommentTextValue = new JTextField();
			        JLabel streamchannelOtherUsersCommentHeadlineText = new JLabel();
			        JLabel streamchannelOtherUsersCommentText = new JLabel();
			        JPanel streamchannelOtherUsersCommentsCommentsCreateComments = new JPanel();
			        
			        streamchannelOtherUsersCommentHeadlineText.setText("Kommentarüberschrift");
			        streamchannelOtherUsersCommentText.setText("Kommentartext");
			        
			        streamchannelOtherUsersCommentsCommentsCreateComments.setVisible(true);
			        streamchannelOtherUsersCommentsCommentsCreateComments.setBounds(0, 0, 300, 640);
			        streamchannelOtherUsersCommentsCommentsCreateComments.setLayout(new GridLayout(3, 2));
			        streamchannelOtherUsersCommentsCommentsCreateComments.add(streamchannelOtherUsersCommentHeadlineText);
			        streamchannelOtherUsersCommentsCommentsCreateComments.add(streamchannelOtherUsersCommentHeadlineValue);
			        streamchannelOtherUsersCommentsCommentsCreateComments.add(streamchannelOtherUsersCommentText);
			        streamchannelOtherUsersCommentsCommentsCreateComments.add(streamchannelOtherUsersCommentTextValue);
			        streamchannelOtherUsersCommentsCommentsCreateComments.add(streamchannelOtherUsersCommentsPostCommentButton);
			        
			        streamchannelOtherUsersHeadlineText.setFont(new Font("Serif", Font.PLAIN, 25));
			        streamchannelOtherUsersHeadlineText.setBounds(0, 0, 640, 25);
			        streamchannelOtherUsersText_Info.setBounds(0, 25, 640, 25);
			        streamchannelOtherUsersInformationText.setBounds(0, 25, 640, 90);
			        streamchannelOtherUsersTopicText.setBounds(50, 25, 640, 25);
			        streamchannelOtherUsersOutputFields.setBounds(50, 540, 640, 150);
			        streamchannelOtherUsersOutputFields.setLayout(null);
			        streamchannelOtherUsersOutputFields.setBackground(Color.LIGHT_GRAY);
			        streamchannelOtherUsersOutputFields.add(streamchannelOtherUsersHeadlineText);
			        streamchannelOtherUsersOutputFields.add(streamchannelOtherUsersText_Info);
			        streamchannelOtherUsersOutputFields.add(streamchannelOtherUsersInformationText);
			    // Streamchannel von anderen Usern-InputFelder-Panel
			    //================================================================================================
				//================================================================================================
			    // Streamchannel von anderen Usern-Streamframe
			        JPanel streamchannelOtherUsersStreamFrame = new JPanel();
			        streamchannelOtherUsersStreamFrame.setBounds(50, 50, 640, 480);
			        streamchannelOtherUsersStreamFrame.add(streamchannelOtherUsersSubscribeChannelButton);
			        streamchannelOtherUsersStreamFrame.add(streamchannelOtherUsersUnscribeChannelButton);
			        streamchannelOtherUsersStreamFrame.add(streamchannelOtherUsersLeaveChannelButton);
			    // Streamchannel von anderen Usern-Streamframe
			    //================================================================================================
				//================================================================================================
			    // Streamchannel von anderen Usern-Comments
			        final JPanel streamchannelOtherUsersCommentsComment1 = new JPanel();
			        final JPanel streamchannelOtherUsersCommentsComment2 = new JPanel();
			        final JPanel streamchannelOtherUsersCommentsComment3 = new JPanel();
			        JPanel streamchannelOtherUsersComments = new JPanel();
			        final JLabel streamchannelOtherUsersCommentsComment1DateText = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment2DateText = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment3DateText = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment1DateValue = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment2DateValue = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment3DateValue = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment1HeadlineText = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment2HeadlineText = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment3HeadlineText = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment1HeadlineValue = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment2HeadlineValue = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment3HeadlineValue = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment1CommentText = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment2CommentText = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment3CommentText = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment1CommentValue = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment2CommentValue = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsComment3CommentValue = new JLabel();
			        final JLabel streamchannelOtherUsersCommentsCommentsNoComments = new JLabel();
			        
			        streamchannelOtherUsersCommentsComment1DateText.setText("Datum:");
			        streamchannelOtherUsersCommentsComment1HeadlineText.setText("Überschrift:");
			        streamchannelOtherUsersCommentsComment1CommentText.setText("Kommentar:");
			        streamchannelOtherUsersCommentsComment1.setLayout(new GridLayout(3, 2));
			        streamchannelOtherUsersCommentsComment1.setVisible(false);
			        streamchannelOtherUsersCommentsComment1.setBounds(5, 5, 300, 640);
			        streamchannelOtherUsersCommentsComment1.add(streamchannelOtherUsersCommentsComment1DateText);
			        streamchannelOtherUsersCommentsComment1.add(streamchannelOtherUsersCommentsComment1DateValue);
			        streamchannelOtherUsersCommentsComment1.add(streamchannelOtherUsersCommentsComment1HeadlineText);
			        streamchannelOtherUsersCommentsComment1.add(streamchannelOtherUsersCommentsComment1HeadlineValue);
			        streamchannelOtherUsersCommentsComment1.add(streamchannelOtherUsersCommentsComment1CommentText);
			        streamchannelOtherUsersCommentsComment1.add(streamchannelOtherUsersCommentsComment1CommentValue);
			        
			        streamchannelOtherUsersCommentsComment2DateText.setText("Datum:");
			        streamchannelOtherUsersCommentsComment2HeadlineText.setText("Überschrift:");
			        streamchannelOtherUsersCommentsComment2CommentText.setText("Kommentar:");
			        streamchannelOtherUsersCommentsComment2.setLayout(new GridLayout(3, 2));
			        streamchannelOtherUsersCommentsComment2.setVisible(false);
			        streamchannelOtherUsersCommentsComment2.setBounds(5, 105, 300, 640);
			        streamchannelOtherUsersCommentsComment2.add(streamchannelOtherUsersCommentsComment2DateText);
			        streamchannelOtherUsersCommentsComment2.add(streamchannelOtherUsersCommentsComment2DateValue);
			        streamchannelOtherUsersCommentsComment2.add(streamchannelOtherUsersCommentsComment2HeadlineText);
			        streamchannelOtherUsersCommentsComment2.add(streamchannelOtherUsersCommentsComment2HeadlineValue);
			        streamchannelOtherUsersCommentsComment2.add(streamchannelOtherUsersCommentsComment2CommentText);
			        streamchannelOtherUsersCommentsComment2.add(streamchannelOtherUsersCommentsComment2CommentValue);
			        
			        streamchannelOtherUsersCommentsComment3DateText.setText("Datum:");
			        streamchannelOtherUsersCommentsComment3HeadlineText.setText("Überschrift:");
			        streamchannelOtherUsersCommentsComment3CommentText.setText("Kommentar:");
			        streamchannelOtherUsersCommentsComment3.setLayout(new GridLayout(3, 2));
			        streamchannelOtherUsersCommentsComment3.setVisible(false);
			        streamchannelOtherUsersCommentsComment3.setBounds(5, 205, 300, 640);
			        streamchannelOtherUsersCommentsComment3.add(streamchannelOtherUsersCommentsComment3DateText);
			        streamchannelOtherUsersCommentsComment3.add(streamchannelOtherUsersCommentsComment3DateValue);
			        streamchannelOtherUsersCommentsComment3.add(streamchannelOtherUsersCommentsComment3HeadlineText);
			        streamchannelOtherUsersCommentsComment3.add(streamchannelOtherUsersCommentsComment3HeadlineValue);
			        streamchannelOtherUsersCommentsComment3.add(streamchannelOtherUsersCommentsComment3CommentText);
			        streamchannelOtherUsersCommentsComment3.add(streamchannelOtherUsersCommentsComment3CommentValue);
			        
			        streamchannelOtherUsersComments.setLayout(new GridLayout(5, 1));
			        streamchannelOtherUsersComments.setVisible(true);
			        streamchannelOtherUsersComments.setBounds(700, 50, 300, 640);
			        streamchannelOtherUsersComments.add(streamchannelOtherUsersCommentsComment1);
			        streamchannelOtherUsersComments.add(streamchannelOtherUsersCommentsComment2);
			        streamchannelOtherUsersComments.add(streamchannelOtherUsersCommentsComment3);
			        streamchannelOtherUsersComments.add(streamchannelOtherUsersCommentsCommentsNoComments);
			        streamchannelOtherUsersComments.add(streamchannelOtherUsersCommentsCommentsCreateComments);
			    // Streamchannel von anderen Usern-Comments
			    //================================================================================================
				//================================================================================================
			    // Streamchannel von anderen Usern-Text
			        final JLabel streamchannelOtherUsersText = new JLabel();
			        streamchannelOtherUsersText.setBounds(50, 0, 640, 25);
			    // Streamchannel von anderen Usern-Text
			    //================================================================================================
			    //================================================================================================
			    final JPanel streamchannelOtherUsers = new JPanel();
			    
			    streamchannelOtherUsers.setBounds(0, 0, 1024, 768);
			    streamchannelOtherUsers.setBackground(Color.white);
			    streamchannelOtherUsers.setVisible(false);
			    streamchannelOtherUsers.setLayout(null);
			    streamchannelOtherUsers.add(streamchannelOtherUsersText);
			    streamchannelOtherUsers.add(streamchannelOtherUsersTopicText);
			    streamchannelOtherUsers.add(streamchannelOtherUsersStreamFrame);
			    streamchannelOtherUsers.add(streamchannelOtherUsersOutputFields);
			    streamchannelOtherUsers.add(streamchannelOtherUsersComments);
		    // Streamchannel von anderen Usern
			//================================================================================================
			//================================================================================================
			 // streamchannelScreenUserIsLoggedIn-OutputFelder-Panel
		    	JPanel streamchannelScreenUserIsLoggedInOutputFields = new JPanel();
		    	final JLabel streamchannelScreenUserIsLoggedInTopicText = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInHeadlineText = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInInformationText = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInText_Info = new JLabel();
		        
		        streamchannelScreenUserIsLoggedInHeadlineText.setFont(new Font("Serif", Font.PLAIN, 25));
		        streamchannelScreenUserIsLoggedInHeadlineText.setBounds(0, 0, 640, 25);
		        streamchannelScreenUserIsLoggedInText_Info.setBounds(0, 25, 640, 25);
		        streamchannelScreenUserIsLoggedInInformationText.setBounds(0, 25, 640, 90);
		        streamchannelScreenUserIsLoggedInTopicText.setBounds(50, 25, 640, 25);
		        streamchannelScreenUserIsLoggedInOutputFields.setBounds(50, 540, 640, 150);
		        streamchannelScreenUserIsLoggedInOutputFields.setLayout(null);
		        streamchannelScreenUserIsLoggedInOutputFields.setBackground(Color.LIGHT_GRAY);
		        streamchannelScreenUserIsLoggedInOutputFields.add(streamchannelScreenUserIsLoggedInHeadlineText);
		        streamchannelScreenUserIsLoggedInOutputFields.add(streamchannelScreenUserIsLoggedInText_Info);
		        streamchannelScreenUserIsLoggedInOutputFields.add(streamchannelScreenUserIsLoggedInInformationText);
		    // streamchannelScreenUserIsLoggedIn-InputFelder-Panel
		    //================================================================================================
		    //================================================================================================    
			// streamchannelScreenUserIsLoggedIn-Buttons
		        JButton streamchannelScreenUserIsLoggedInCommentsComment1DeleteCommentButton = new JButton("Kommentar löschen");
		        JButton streamchannelScreenUserIsLoggedInCommentsComment2DeleteCommentButton = new JButton("Kommentar löschen");
		        JButton streamchannelScreenUserIsLoggedInCommentsComment3DeleteCommentButton = new JButton("Kommentar löschen");
		        JButton streamchannelScreenUserIsLoggedInStartStreamButton = new JButton("Start Stream");
		        JButton streamchannelScreenUserIsLoggedInStopStreamButton = new JButton("Stop Stream");
		        JButton streamchannelScreenUserIsLoggedInLeaveStreamButton = new JButton("Stream verlassen");
		    // streamchannelScreenUserIsLoggedIn-Buttons
		    //================================================================================================
			//================================================================================================
		    // streamchannelScreenUserIsLoggedIn-Streamframe
		        JPanel streamchannelScreenUserIsLoggedInStreamFrame = new JPanel();
		        streamchannelScreenUserIsLoggedInStreamFrame.setBounds(50, 50, 640, 480);
		        streamchannelScreenUserIsLoggedInStreamFrame.add(streamchannelScreenUserIsLoggedInStartStreamButton);
		        streamchannelScreenUserIsLoggedInStreamFrame.add(streamchannelScreenUserIsLoggedInStopStreamButton);
		        streamchannelScreenUserIsLoggedInStreamFrame.add(streamchannelScreenUserIsLoggedInLeaveStreamButton);
		    // streamchannelScreenUserIsLoggedIn-Streamframe
		    //================================================================================================
			//================================================================================================
		    // streamchannelScreenUserIsLoggedIn-Comments
		        final JPanel streamchannelScreenUserIsLoggedInCommentsComment1 = new JPanel();
		        final JPanel streamchannelScreenUserIsLoggedInCommentsComment2 = new JPanel();
		        final JPanel streamchannelScreenUserIsLoggedInCommentsComment3 = new JPanel();
		        JPanel streamchannelScreenUserIsLoggedInComments = new JPanel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment1DateText = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment2DateText = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment3DateText = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment1DateValue = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment2DateValue = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment3DateValue = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment1HeadlineText = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment2HeadlineText = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment3HeadlineText = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment1HeadlineValue = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment2HeadlineValue = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment3HeadlineValue = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment1CommentText = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment2CommentText = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment3CommentText = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment1CommentValue = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment2CommentValue = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsComment3CommentValue = new JLabel();
		        final JLabel streamchannelScreenUserIsLoggedInCommentsCommentsNoComments = new JLabel();
		        
		        streamchannelScreenUserIsLoggedInCommentsComment1DateText.setText("Datum:");
		        streamchannelScreenUserIsLoggedInCommentsComment1HeadlineText.setText("Überschrift:");
		        streamchannelScreenUserIsLoggedInCommentsComment1CommentText.setText("Kommentar:");
		        streamchannelScreenUserIsLoggedInCommentsComment1.setLayout(new GridLayout(4, 2));
		        streamchannelScreenUserIsLoggedInCommentsComment1.setVisible(false);
		        streamchannelScreenUserIsLoggedInCommentsComment1.setBounds(5, 5, 300, 640);
		        streamchannelScreenUserIsLoggedInCommentsComment1.add(streamchannelScreenUserIsLoggedInCommentsComment1DateText);
		        streamchannelScreenUserIsLoggedInCommentsComment1.add(streamchannelScreenUserIsLoggedInCommentsComment1DateValue);
		        streamchannelScreenUserIsLoggedInCommentsComment1.add(streamchannelScreenUserIsLoggedInCommentsComment1HeadlineText);
		        streamchannelScreenUserIsLoggedInCommentsComment1.add(streamchannelScreenUserIsLoggedInCommentsComment1HeadlineValue);
		        streamchannelScreenUserIsLoggedInCommentsComment1.add(streamchannelScreenUserIsLoggedInCommentsComment1CommentText);
		        streamchannelScreenUserIsLoggedInCommentsComment1.add(streamchannelScreenUserIsLoggedInCommentsComment1CommentValue);
		        streamchannelScreenUserIsLoggedInCommentsComment1.add(streamchannelScreenUserIsLoggedInCommentsComment1DeleteCommentButton);
		        
		        streamchannelScreenUserIsLoggedInCommentsComment2DateText.setText("Datum:");
		        streamchannelScreenUserIsLoggedInCommentsComment2HeadlineText.setText("Überschrift:");
		        streamchannelScreenUserIsLoggedInCommentsComment2CommentText.setText("Kommentar:");
		        streamchannelScreenUserIsLoggedInCommentsComment2.setLayout(new GridLayout(4, 2));
		        streamchannelScreenUserIsLoggedInCommentsComment2.setVisible(false);
		        streamchannelScreenUserIsLoggedInCommentsComment2.setBounds(5, 105, 300, 640);
		        streamchannelScreenUserIsLoggedInCommentsComment2.add(streamchannelScreenUserIsLoggedInCommentsComment2DateText);
		        streamchannelScreenUserIsLoggedInCommentsComment2.add(streamchannelScreenUserIsLoggedInCommentsComment2DateValue);
		        streamchannelScreenUserIsLoggedInCommentsComment2.add(streamchannelScreenUserIsLoggedInCommentsComment2HeadlineText);
		        streamchannelScreenUserIsLoggedInCommentsComment2.add(streamchannelScreenUserIsLoggedInCommentsComment2HeadlineValue);
		        streamchannelScreenUserIsLoggedInCommentsComment2.add(streamchannelScreenUserIsLoggedInCommentsComment2CommentText);
		        streamchannelScreenUserIsLoggedInCommentsComment2.add(streamchannelScreenUserIsLoggedInCommentsComment2CommentValue);
		        streamchannelScreenUserIsLoggedInCommentsComment2.add(streamchannelScreenUserIsLoggedInCommentsComment2DeleteCommentButton);
		        
		        streamchannelScreenUserIsLoggedInCommentsComment3DateText.setText("Datum:");
		        streamchannelScreenUserIsLoggedInCommentsComment3HeadlineText.setText("Überschrift:");
		        streamchannelScreenUserIsLoggedInCommentsComment3CommentText.setText("Kommentar:");
		        streamchannelScreenUserIsLoggedInCommentsComment3.setLayout(new GridLayout(4, 2));
		        streamchannelScreenUserIsLoggedInCommentsComment3.setVisible(false);
		        streamchannelScreenUserIsLoggedInCommentsComment3.setBounds(5, 205, 300, 640);
		        streamchannelScreenUserIsLoggedInCommentsComment3.add(streamchannelScreenUserIsLoggedInCommentsComment3DateText);
		        streamchannelScreenUserIsLoggedInCommentsComment3.add(streamchannelScreenUserIsLoggedInCommentsComment3DateValue);
		        streamchannelScreenUserIsLoggedInCommentsComment3.add(streamchannelScreenUserIsLoggedInCommentsComment3HeadlineText);
		        streamchannelScreenUserIsLoggedInCommentsComment3.add(streamchannelScreenUserIsLoggedInCommentsComment3HeadlineValue);
		        streamchannelScreenUserIsLoggedInCommentsComment3.add(streamchannelScreenUserIsLoggedInCommentsComment3CommentText);
		        streamchannelScreenUserIsLoggedInCommentsComment3.add(streamchannelScreenUserIsLoggedInCommentsComment3CommentValue);
		        streamchannelScreenUserIsLoggedInCommentsComment3.add(streamchannelScreenUserIsLoggedInCommentsComment3DeleteCommentButton);
		        
		        streamchannelScreenUserIsLoggedInComments.setLayout(new GridLayout(4, 1));
		        streamchannelScreenUserIsLoggedInComments.setVisible(true);
		        streamchannelScreenUserIsLoggedInComments.setBounds(700, 50, 300, 640);
		        streamchannelScreenUserIsLoggedInComments.add(streamchannelScreenUserIsLoggedInCommentsComment1);
		        streamchannelScreenUserIsLoggedInComments.add(streamchannelScreenUserIsLoggedInCommentsComment2);
		        streamchannelScreenUserIsLoggedInComments.add(streamchannelScreenUserIsLoggedInCommentsComment3);
		        streamchannelScreenUserIsLoggedInComments.add(streamchannelScreenUserIsLoggedInCommentsCommentsNoComments);
		    // streamchannelOtherUsers-Comments
		    //================================================================================================
			//================================================================================================
		    // streamchannelOtherUsers-Text
		        final JLabel streamchannelScreenUserIsLoggedInText = new JLabel();
		        streamchannelScreenUserIsLoggedInText.setBounds(50, 0, 640, 25);
		    // streamchannelOtherUsers-Text
		    //================================================================================================
		    //================================================================================================
		    final JPanel streamchannelScreenUserIsLoggedIn = new JPanel();
		    
		    streamchannelScreenUserIsLoggedIn.setBounds(0, 0, 1024, 768);
		    streamchannelScreenUserIsLoggedIn.setBackground(Color.white);
		    streamchannelScreenUserIsLoggedIn.setVisible(false);
		    streamchannelScreenUserIsLoggedIn.setLayout(null);
		    streamchannelScreenUserIsLoggedIn.add(streamchannelScreenUserIsLoggedInText);
		    streamchannelScreenUserIsLoggedIn.add(streamchannelScreenUserIsLoggedInTopicText);
		    streamchannelScreenUserIsLoggedIn.add(streamchannelScreenUserIsLoggedInStreamFrame);
		    streamchannelScreenUserIsLoggedIn.add(streamchannelScreenUserIsLoggedInOutputFields);
			streamchannelScreenUserIsLoggedIn.add(streamchannelScreenUserIsLoggedInComments);
		// Streamchannel-Screen
		//####################################################################################################
	    //####################################################################################################
        // Profil-Screen userIsLoggedIn
		    //================================================================================================
			//================================================================================================
			// Profil-InputFelder-Panel
		    	final JTextField profileLoginPasswordTextField = new JTextField();
		        final JTextField profileFirstNameTextField = new JTextField();
		        final JTextField profileLastNameTextField = new JTextField();
		        final JTextField profileCityTextField = new JTextField();
		        final JTextField profileCountryTextField = new JTextField();
		        final JTextField profileBirthdayTextField = new JTextField();
		        final JLabel profileLoginNameText_Value = new JLabel();
		        JLabel profileLoginNameText = new JLabel();
		        JLabel profileLoginPasswordText = new JLabel();
		        JLabel profileFirstNameText = new JLabel();
		        JLabel profileLastNameText = new JLabel();
		        JLabel profileBirthdayText = new JLabel();
		        JLabel profileCityText = new JLabel();
		        JLabel profileCountryText = new JLabel();
		        JLabel profileText = new JLabel();
		        JLabel emptyPanelprofile = new JLabel();
		        JLabel emptyPanelprofile2 = new JLabel();
		        JPanel profileInputFields = new JPanel();
		         
		        profileLoginNameText.setBounds(0, 0, 300, 50);
		        profileLoginNameText.setText("Username");
		        profileLoginNameText_Value.setBounds(300, 0, 100, 50);
		        profileLoginPasswordText.setText("Password");
		        profileFirstNameText.setText("Vorname");
		        profileLastNameText.setText("Nachname");
		        profileCityText.setText("Stadt");
		        profileCountryText.setText("Land");
		        profileBirthdayText.setText("Geburtstag (MM/dd/yyyy hh:mm)");
		        profileInputFields.setLayout(new GridLayout(11, 2));
		        profileInputFields.setBounds(200, 100, 400, 500);
		        profileInputFields.setBackground(Color.LIGHT_GRAY);
		        profileInputFields.add(profileLoginNameText);
		        profileInputFields.add(profileLoginNameText_Value);
		        profileInputFields.add(profileLoginPasswordText);
		        profileInputFields.add(profileLoginPasswordTextField);
		        profileInputFields.add(emptyPanelprofile);
		        profileInputFields.add(emptyPanelprofile2);
		        profileInputFields.add(profileFirstNameText);
		        profileInputFields.add(profileFirstNameTextField);
		        profileInputFields.add(profileLastNameText);
		        profileInputFields.add(profileLastNameTextField);
		        profileInputFields.add(profileBirthdayText);
		        profileInputFields.add(profileBirthdayText);
		        profileInputFields.add(profileBirthdayTextField);
		        profileInputFields.add(profileCityText);
		        profileInputFields.add(profileCityTextField);
		        profileInputFields.add(profileCountryText);
		        profileInputFields.add(profileCountryTextField);
		    // Profil-InputFelder-Panel
			//================================================================================================
		    //================================================================================================
			// Profil-Buttons
		        JPanel profileButtons = new JPanel();
		        final JButton profileCreateStreamchannelButton = new JButton("Streamchannel erstellen");
		        final JButton profileDeleteStreamchannelButton = new JButton("Streamchannel löschen");
		        JButton profileChangePasswordButton = new JButton("Passwort ändern");
		        JButton profileChangeProfileButton = new JButton("Profile barbeiten");
		        JButton profileDeleteProfileButton = new JButton("Profil löschen");
		        JButton profileLeaveButton = new JButton("Profil verlassen");
		        final JButton profileChangeStreamchannelButton = new JButton("Streamchannel bearbeiten");
		        
		        profileChangeStreamchannelButton.setVisible(false);
		        profileDeleteStreamchannelButton.setVisible(false);
		        profileButtons.setLayout(new GridLayout(7, 1));
		        profileButtons.setVisible(true);
		        profileButtons.setBounds(700, 200, 300, 300);
		        profileButtons.add(profileChangeProfileButton);
		        profileButtons.add(profileDeleteProfileButton);
		        profileButtons.add(profileChangePasswordButton);
		        profileButtons.add(profileLeaveButton);
		        profileButtons.add(profileCreateStreamchannelButton);
		        profileButtons.add(profileChangeStreamchannelButton);
		        profileButtons.add(profileDeleteStreamchannelButton);
		    // Profil-Buttons
		    //================================================================================================
			//================================================================================================
		    // Profil-Text
		        profileText.setText("Profil");
		        profileText.setBounds(300, 50, 300, 50);
		    // Profil-Text
		    //================================================================================================
		    //================================================================================================
		    final JPanel profileScreenUserIsLoggedIn = new JPanel();    
		    
		    profileScreenUserIsLoggedIn.setBounds(0, 0, 1024, 768);
		    profileScreenUserIsLoggedIn.setBackground(Color.white);
		    profileScreenUserIsLoggedIn.setVisible(false);
		    profileScreenUserIsLoggedIn.setLayout(null);
		    profileScreenUserIsLoggedIn.add(profileText);
		    profileScreenUserIsLoggedIn.add(profileInputFields);
		    profileScreenUserIsLoggedIn.add(profileButtons);
        // Profil-Screen
        //####################################################################################################
        //####################################################################################################
		// UserIsLoggedIn-Screen
		    //================================================================================================
			//================================================================================================
		    //Streamchannel erstellen-Screen
		    	//********************************************************************************************
	    		//********************************************************************************************
		    	// Streamchannel erstellen-InputFelder-Panel
			        final JTextField createStreamchannelTopicTextField = new JTextField();
			        final JTextField createStreamchannelHeadlineTextField = new JTextField();
			        final JTextField createStreamchannelInformationTextField = new JTextField();
			        JLabel createStreamchannelTopicText = new JLabel();
			        JLabel createStreamchannelHeadlineText = new JLabel();
			        JLabel createStreamchannelInformationText = new JLabel();
			        JLabel createStreamchannelText = new JLabel();
			        JPanel createStreamchannelInputFields = new JPanel();
			        
			        createStreamchannelTopicText.setBounds(0, 0, 300, 50);
			        createStreamchannelTopicText.setText("Streamthema");
			        createStreamchannelTopicTextField.setBounds(300, 0, 100, 50);
			        createStreamchannelHeadlineText.setText("Streamueberschrift");
			        createStreamchannelInformationText.setText("Streambeschreibung");
			        createStreamchannelInputFields.setLayout(new GridLayout(3, 2));
			        createStreamchannelInputFields.setBounds(200, 100, 400, 150);
			        createStreamchannelInputFields.setBackground(Color.LIGHT_GRAY);
			        createStreamchannelInputFields.add(createStreamchannelTopicText);
			        createStreamchannelInputFields.add(createStreamchannelTopicTextField);
			        createStreamchannelInputFields.add(createStreamchannelHeadlineText);
			        createStreamchannelInputFields.add(createStreamchannelHeadlineTextField);
			        createStreamchannelInputFields.add(createStreamchannelInformationText);
			        createStreamchannelInputFields.add(createStreamchannelInformationTextField);
			    // Streamchannel erstellen-InputFelder-Panel
			    //********************************************************************************************
		    	//********************************************************************************************
				// Streamchannel erstellen-Buttons
			        JPanel createStreamchannelButtons = new JPanel();
			        final JButton createStreamchannelSubmitButton = new JButton("Streamchannel erstellen");
			        final JButton createStreamchannelChangeStreamchannelButton = new JButton("Streamchannel bearbeiten");
			        JButton createStreamchannelCancelButton = new JButton("Abbrechen");
			        createStreamchannelChangeStreamchannelButton.setVisible(false);
			        createStreamchannelButtons.setLayout(new GridLayout(3, 1));
			        createStreamchannelButtons.setVisible(true);
			        createStreamchannelButtons.setBounds(200, 250, 400, 50);
			        createStreamchannelButtons.add(createStreamchannelCancelButton);
			        createStreamchannelButtons.add(createStreamchannelSubmitButton);
			        createStreamchannelButtons.add(createStreamchannelChangeStreamchannelButton);
			    // Streamchannel erstellen-Buttons
			    //********************************************************************************************
			    //********************************************************************************************
			    // Streamchannel erstellen-Text
			        createStreamchannelText.setText("Streamchannel erstellen");
			        createStreamchannelText.setBounds(300, 50, 300, 50);
			    // Streamchannel erstellen-Text
			    //********************************************************************************************
			    //********************************************************************************************
			    final JPanel createStreamchannelScreen = new JPanel();
			    
			    createStreamchannelScreen.setBounds(0, 0, 1024, 768);
			    createStreamchannelScreen.setBackground(Color.white);
			    createStreamchannelScreen.setVisible(false);
			    createStreamchannelScreen.setLayout(null);
			    createStreamchannelScreen.add(createStreamchannelText);
			    createStreamchannelScreen.add(createStreamchannelButtons);
			    createStreamchannelScreen.add(createStreamchannelInputFields);
				//********************************************************************************************
	    		//********************************************************************************************
		    // Streamchannel erstellen-Screen
		    final JPanel userIsLoggedIn = new JPanel();
		    final JLabel userIsLoggedInText = new JLabel();
		    JButton userIsLoggedInProfilButton = new JButton("Profil");
	        JButton userLogoutButton = new JButton("Logout");
		    
		    userIsLoggedInText.setText("ss");
		    userIsLoggedIn.setBounds(824, 0, 200, 60);
		    userIsLoggedIn.setBackground(Color.LIGHT_GRAY);
		    userIsLoggedIn.setVisible(false);
		    userIsLoggedIn.add(userIsLoggedInText);
		    userIsLoggedIn.add(userIsLoggedInProfilButton);
		    userIsLoggedIn.add(userLogoutButton);
		    // Streamchannel erstellen-Screen
		    //================================================================================================
		    //================================================================================================
		    // userIsLoggedInshowUserStreamchannel-Menu nach Login
			    final JPanel userIsLoggedInshowUserStreamchannel =  new JPanel();
			    JButton UserIsLoggedInStreamchannelButton = new JButton("Streamchannel");
			    
			    userIsLoggedInshowUserStreamchannel.setBounds(824, 100, 200, 60);
			    userIsLoggedInshowUserStreamchannel.setBackground(Color.LIGHT_GRAY);
			    userIsLoggedInshowUserStreamchannel.setVisible(false);
			    userIsLoggedInshowUserStreamchannel.add(UserIsLoggedInStreamchannelButton);
			// userIsLoggedInshowUserStreamchannel-Menu nach Login
			//================================================================================================
			//================================================================================================
		// UserIsLoggedIn-Screen
		//####################################################################################################
		//####################################################################################################
		// Start-Screen
		    //================================================================================================
		    //================================================================================================
	    	// Suchfelder-Panel
    			//********************************************************************************************
    			//********************************************************************************************
    			// Suchfeld Users
				    JPanel searchUsers = new JPanel();
				    JLabel searchUsersText = new JLabel();
				    final JTextField searchUsersTextField = new JTextField();
				    JButton searchUsersButton = new JButton("Benutzer suchen");
				    
				    searchUsersText.setText("Benutzersuche");
				    searchUsers.setBounds(0, 0, 400, 25);
				    searchUsers.setLayout(new GridLayout(1, 1));
				    searchUsers.setVisible(true);
				    searchUsers.add(searchUsersText);
				    searchUsers.add(searchUsersTextField);
				    searchUsers.add(searchUsersButton);
				// Suchfeld User
				//********************************************************************************************
	    		//********************************************************************************************
				// Suchfeld Topics
				    JPanel searchTopics = new JPanel();
				    JLabel searchTopicsText = new JLabel();
				    final JTextField searchTopicsTextField = new JTextField();
				    JButton searchTopicsButton = new JButton("Thema suchen");
				    
				    searchTopicsText.setText("Themensuche");
				    searchTopics.setBounds(0, 100, 400, 25);
				    searchTopics.setLayout(new GridLayout(1, 1));
				    searchTopics.setVisible(true);
				    searchTopics.setBackground(Color.LIGHT_GRAY);
				    searchTopics.add(searchTopicsText);
				    searchTopics.add(searchTopicsTextField);
				    searchTopics.add(searchTopicsButton);
				// Suchfeld Topics
				//********************************************************************************************
		    	//********************************************************************************************
				JPanel search = new JPanel();
				
				search.setBounds(0, 0, 400, 50);
				search.setBackground(Color.orange);
				search.setLayout(new GridLayout(2, 1));
				search.setVisible(true);
				search.add(searchUsers);
				search.add(searchTopics);
		    // Suchfelder-Panel
		    //================================================================================================
		    //================================================================================================
	    	// Login-Panel
		    	final JPanel login = new JPanel();
		        JLabel loginText = new JLabel();
		        JLabel loginUsernameText = new JLabel();
		        JLabel loginUserpasswordText = new JLabel();
		        JLabel emptyPanelLogin = new JLabel();
		        final JTextField loginUsernameTextField = new JTextField();
		        final JTextField loginUserpasswordTextField = new JTextField();
		        JButton loginButton = new JButton("Login");
		        
		        emptyPanelLogin.setBounds(15, 15, 100, 10);
		        loginText.setText("Login");
		        loginUsernameText.setText("Benutzername");
		        loginUsernameText.setBounds(15, 15, 100, 10);
		        loginUserpasswordText.setText("Passwort");
		        loginUserpasswordText.setBounds(150, 150, 100, 10);
		        login.setLayout(new GridLayout(4, 2));
		        login.setBounds(824, 0, 200, 60);
		        login.setVisible(true);
		        login.setBackground(Color.LIGHT_GRAY);
		        login.add(loginText);
		        login.add(emptyPanelLogin);
		        login.add(loginUsernameText);
		        login.add(loginUsernameTextField);
		        login.add(loginUserpasswordText);
		        login.add(loginUserpasswordTextField);
		        login.add(loginButton);
	        // Login-Panel
	        //================================================================================================
	        //================================================================================================
	        // Register-Panel
		        final JPanel register = new JPanel();
		        JButton registerUserButton = new JButton("Registrieren");
		        
		        register.setBounds(824, 70, 200, 40);
		        register.setVisible(true);
		        register.setBackground(Color.LIGHT_GRAY);
		        register.add(registerUserButton);
		    // Register-Panel
		    //================================================================================================
		    //================================================================================================
		    final JPanel startScreen = new JPanel();
		    
			startScreen.setBounds(0, 0, 1024, 768);
			startScreen.setBackground(Color.white);
			startScreen.setVisible(true);
			startScreen.setLayout(null);
			startScreen.add(login);
			startScreen.add(register);
			startScreen.add(search);
			startScreen.add(userIsLoggedIn);
			startScreen.add(userIsLoggedInshowUserStreamchannel);
        // Start-Screen
        //####################################################################################################
        //####################################################################################################
        // Client-Frame
	        JFrame clientFrame = new JFrame();
	        
	        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        clientFrame.setLayout(null);
	        clientFrame.setTitle("Streaming Client");
	        clientFrame.setSize(1024, 768);
	        clientFrame.setVisible(true);
	        clientFrame.setResizable(false);
	        clientFrame.setLocationRelativeTo(null);
	        clientFrame.add(startScreen);
	        clientFrame.add(registerScreen);
	        clientFrame.add(profileScreenUserIsLoggedIn);
	        clientFrame.add(createStreamchannelScreen);
	        clientFrame.add(streamchannelScreenUserIsLoggedIn);
	        clientFrame.add(streamchannelOtherUsers);
	        clientFrame.add(searchScreenTopic);
        // Client-Frame
        //####################################################################################################
        //####################################################################################################
        // Eventlistener für Buttons
        // Start-Screen Registrieren-Button
        registerUserButton.addActionListener(new ActionListener()
        {
			@Override
            public void actionPerformed(ActionEvent event)
            {
            	startScreen.setVisible(false);
            	registerScreen.setVisible(true);
            }
        });
        
        // Start-Screen Login-Button
        loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
            	String loginUsernameTextValue = loginUsernameTextField.getText();
            	loginUsernameTextValue = loginUsernameTextValue.replaceAll("\\s", "");
                String loginUserpasswordTextValue = loginUserpasswordTextField.getText();
                loginUserpasswordTextValue = loginUserpasswordTextValue.replaceAll("\\s", "");
                
				if(loginUsernameTextValue.isEmpty() || loginUserpasswordTextValue.isEmpty())
				{
					String message = "Unbekannter Benutzername oder das Passwort ist nicht korrekt!";
		            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{ 
					try
					{
						if(rwS.compareUsers(loginUsernameTextValue) && rwS.comparePasswords(loginUsernameTextValue, loginUserpasswordTextValue))
						{
							userIsLoggedIn.setVisible(true);
							register.setVisible(false);
							login.setVisible(false);
							userIsLoggedInText.setText("Hallo " + loginUsernameTextValue);
							
							xmpplogin(loginUsernameTextValue, loginUserpasswordTextValue);
							loggedInUser = loginUsernameTextValue;
		                	
		                	if(rwS.checkStreamchannelExists(rwS.getUserID(loginUsernameTextValue)))
		                	{
		                		userIsLoggedInshowUserStreamchannel.setVisible(true);
		                		profileChangeStreamchannelButton.setVisible(true);
		        		        profileDeleteStreamchannelButton.setVisible(true);
		                		profileCreateStreamchannelButton.setVisible(false);
		                	}
		                	else
		                	{
		                		userIsLoggedInshowUserStreamchannel.setVisible(false);
		                	}
						}
						else
						{
							String message = "Unbekannter Benutzername oder das Passwort ist nicht korrekt!";
							JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					catch(FileNotFoundException e)
	                {
						e.printStackTrace();
					}
	                catch(JAXBException e)
	                {
	                	e.printStackTrace();
	                }
					catch (XMPPException e)
	                {
						e.printStackTrace();
					}
				}
            }
        });
        
        // Start-Screen Benutzersuche-Button
        searchUsersButton.addActionListener(new ActionListener()
        {
			@Override
            public void actionPerformed(ActionEvent event)
            {
				String searchUsersTextValue = searchUsersTextField.getText();
				searchUsersTextValue = searchUsersTextValue.replaceAll("\\s", "");
				
				if(searchUsersTextValue.isEmpty())
				{
					String message = "Bitte geben Sie einen Benutzernamen in das Suchfeld ein!";
		            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					try
					{
						if(rwS.checkUserExists(searchUsersTextValue))
						{
		                	showStreamchannel(searchUsersTextValue,
		                					  streamchannelOtherUsersCommentsComment1CommentText, 
		                					  streamchannelOtherUsersCommentsComment2CommentText, 
		                					  streamchannelOtherUsersCommentsComment3CommentText, 
											  streamchannelOtherUsersCommentsComment1, 
											  streamchannelOtherUsersCommentsComment2, 
											  streamchannelOtherUsersCommentsComment3, 
											  streamchannelOtherUsersCommentsComment1DateValue,
											  streamchannelOtherUsersCommentsComment2DateValue, 
											  streamchannelOtherUsersCommentsComment3DateValue, 
											  streamchannelOtherUsersCommentsComment1CommentValue, 
											  streamchannelOtherUsersCommentsComment2CommentValue, 
											  streamchannelOtherUsersCommentsComment3CommentValue, 
											  streamchannelOtherUsersCommentsComment1HeadlineValue, 
											  streamchannelOtherUsersCommentsComment2HeadlineValue, 
											  streamchannelOtherUsersCommentsComment3HeadlineValue, 
											  streamchannelOtherUsersCommentsCommentsNoComments, 
											  streamchannelOtherUsersText,
											  streamchannelOtherUsersTopicText, 
											  streamchannelOtherUsersHeadlineText, 
											  streamchannelOtherUsersInformationText, 
											  streamchannelOtherUsersText_Info, 
											  streamchannelOtherUsers,
											  startScreen);
		                	
		                	startScreen.setVisible(false);
		                	streamchannelOtherUsers.setVisible(true);
		                	
		                	foundUser = searchUsersTextValue;
						}
						else
						{
							String message = "Unbekannter Benutzername!";
		                	JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					catch(FileNotFoundException e)
	                {
						e.printStackTrace();
					}
	                catch(JAXBException e)
	                {
	                	e.printStackTrace();
	                }
				}
            }
        });
        
        // Start-Screen Themensuche-Button
        searchTopicsButton.addActionListener(new ActionListener()
        {
			@Override
            public void actionPerformed(ActionEvent event)
            {
				String searchTopicsTextValue = searchTopicsTextField.getText();
				
				searchTopicsTextValue = searchTopicsTextValue.replaceAll("\\s", "");
				
				if(searchTopicsTextValue.isEmpty())
				{
					String message = "Bitte geben Sie ein Thema in das Suchfeld ein!";
		            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					try
					{
						if(rwS.searchTopic(searchTopicsTextValue))
						{
							searchScreenTopic.setVisible(true);
							startScreen.setVisible(false);
							
							Users user = rwS.showStreamerUsingTopic(searchTopicsTextValue);
							
							resultTopicNameSearchedText.setText("Gesuchtes Thema: " + searchTopicsTextValue);
							
							if(user.getUser().size() >= 5)
							{
								resultTopicListItem1.setText(user.getUser().get(0).getUserStreamChannelName());
								resultTopicListItem2.setText(user.getUser().get(1).getUserStreamChannelName());
								resultTopicListItem3.setText(user.getUser().get(2).getUserStreamChannelName());
								resultTopicListItem4.setText(user.getUser().get(3).getUserStreamChannelName());
								resultTopicListItem5.setText(user.getUser().get(4).getUserStreamChannelName());
							}
							else
							{
								if(user.getUser().size() == 4)
								{
									resultTopicListItem1.setText(user.getUser().get(0).getUserStreamChannelName());
									resultTopicListItem2.setText(user.getUser().get(1).getUserStreamChannelName());
									resultTopicListItem3.setText(user.getUser().get(2).getUserStreamChannelName());
									resultTopicListItem4.setText(user.getUser().get(3).getUserStreamChannelName());
									resultTopicListshowStreamchannel5Button.setVisible(false);
								}
								else
								{
									if(user.getUser().size() == 3)
									{
										resultTopicListItem1.setText(user.getUser().get(0).getUserStreamChannelName());
										resultTopicListItem2.setText(user.getUser().get(1).getUserStreamChannelName());
										resultTopicListItem3.setText(user.getUser().get(2).getUserStreamChannelName());
										resultTopicListshowStreamchannel4Button.setVisible(false);
										resultTopicListshowStreamchannel5Button.setVisible(false);
									}
									else
									{
										if(user.getUser().size() == 2)
										{
											resultTopicListItem1.setText(user.getUser().get(0).getUserStreamChannelName());
											resultTopicListItem2.setText(user.getUser().get(1).getUserStreamChannelName());
											resultTopicListshowStreamchannel3Button.setVisible(false);
											resultTopicListshowStreamchannel4Button.setVisible(false);
											resultTopicListshowStreamchannel5Button.setVisible(false);
										}
										else
										{
											if(user.getUser().size() == 1)
											{
												resultTopicListItem1.setText(user.getUser().get(0).getUserStreamChannelName());
												resultTopicListshowStreamchannel2Button.setVisible(false);
												resultTopicListshowStreamchannel3Button.setVisible(false);
												resultTopicListshowStreamchannel4Button.setVisible(false);
												resultTopicListshowStreamchannel5Button.setVisible(false);
											}
											else
											{
												if(user.getUser().size() == 0)
												{
													resultTopicListItem6.setVisible(true);
													resultTopicListshowStreamchannel1Button.setVisible(false);
													resultTopicListshowStreamchannel2Button.setVisible(false);
													resultTopicListshowStreamchannel3Button.setVisible(false);
													resultTopicListshowStreamchannel4Button.setVisible(false);
													resultTopicListshowStreamchannel5Button.setVisible(false);
												}
											}
										}
									}
								}
							}
						}
						else
						{
							String message = "Unbekanntes Thema!";
		                	JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					catch(FileNotFoundException e)
	                {
						e.printStackTrace();
					}
	                catch(JAXBException e)
	                {
	                	e.printStackTrace();
	                }
                }
            }
        });
        
        // Start-Screen User-Profil anzeigen-Button
        userIsLoggedInProfilButton.addActionListener(new ActionListener()
        {
			@Override
            public void actionPerformed(ActionEvent event)
            {
				Users text = new Users();
				try
				{
					text = rwS.showUserProfile((loginUsernameTextField.getText()).replaceAll("\\s", ""));
				}
				catch (FileNotFoundException | JAXBException e)
				{
					e.printStackTrace();
				}
				
				XMLGregorianCalendar date = text.getUser().get(0).getUserInformation().getBirthday();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm");
                GregorianCalendar gc = date.toGregorianCalendar();
                String registerBirthday = sdf.format(gc.getTime());

                profileLoginNameText_Value.setText(text.getUser().get(0).getUserStreamChannelName());
				profileLoginPasswordTextField.setText(text.getUser().get(0).getLogin().getLoginPassword());
		        profileFirstNameTextField.setText(text.getUser().get(0).getUserInformation().getFirstName());
		        profileLastNameTextField.setText(text.getUser().get(0).getUserInformation().getLastName());
		        profileBirthdayTextField.setText(registerBirthday);
		        profileCityTextField.setText(text.getUser().get(0).getUserInformation().getCity());
		        profileCountryTextField.setText(text.getUser().get(0).getUserInformation().getCountry());

				startScreen.setVisible(false);
				profileScreenUserIsLoggedIn.setVisible(true);
            }
        });
        
        // Start-Screen User-Streamchannel anzeigen-Button
        UserIsLoggedInStreamchannelButton.addActionListener(new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				showStreamchannelOfUser(loginUsernameTextField, 
										streamchannelScreenUserIsLoggedInCommentsComment1, 
										streamchannelScreenUserIsLoggedInCommentsComment2, 
										streamchannelScreenUserIsLoggedInCommentsComment3, 
										streamchannelScreenUserIsLoggedInCommentsComment1DateValue,
										streamchannelScreenUserIsLoggedInCommentsComment2DateValue, 
										streamchannelScreenUserIsLoggedInCommentsComment3DateValue, 
										streamchannelScreenUserIsLoggedInCommentsComment1CommentValue, 
										streamchannelScreenUserIsLoggedInCommentsComment2CommentValue, 
										streamchannelScreenUserIsLoggedInCommentsComment3CommentValue, 
										streamchannelScreenUserIsLoggedInCommentsComment1HeadlineValue, 
										streamchannelScreenUserIsLoggedInCommentsComment2HeadlineValue, 
										streamchannelScreenUserIsLoggedInCommentsComment3HeadlineValue, 
										streamchannelScreenUserIsLoggedInCommentsCommentsNoComments, 
										streamchannelScreenUserIsLoggedInText,
										streamchannelScreenUserIsLoggedInTopicText, 
										streamchannelScreenUserIsLoggedInHeadlineText, 
										streamchannelScreenUserIsLoggedInInformationText, 
										streamchannelScreenUserIsLoggedInText_Info, 
										streamchannelScreenUserIsLoggedIn, 
										startScreen);
			}
        });
        
        // Register-Screen abbrechen-Button
        registerCancelButton.addActionListener(new ActionListener()
        {
			@Override
            public void actionPerformed(ActionEvent event)
            {
            	startScreen.setVisible(true);
            	registerScreen.setVisible(false);
            }
        });
        
        // Register-Screen Registrieren-Button        
        registerSubmitButton.addActionListener(new ActionListener()
        {
			@Override
            public void actionPerformed(ActionEvent event)
            {
				String registerLoginNameTextValue = registerLoginNameTextField.getText();	
				registerLoginNameTextValue = registerLoginNameTextValue.replaceAll("\\s", "");
                String registerLoginPasswordTextValue = registerLoginPasswordTextField.getText();
                String registerFirstNameTextValue = registerFirstNameTextField.getText();
                String registerLastNameTextValue = registerLastNameTextField.getText();
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
        		DatatypeFactory datatypeFactory = null;
        		
				try
				{
					datatypeFactory = DatatypeFactory.newInstance();
				}
				catch (DatatypeConfigurationException e2)
				{
					e2.printStackTrace();
				}
				
        		XMLGregorianCalendar registerBirthday = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
                
                String registerCityTextValue = registerCityTextField.getText();
                String registerCountryTextValue = registerCountryTextField.getText(); 
        		
                if(registerLoginNameTextValue.isEmpty() ||
                   registerLoginPasswordTextValue.isEmpty() ||
                   registerFirstNameTextValue.isEmpty() ||
                   registerLastNameTextValue.isEmpty() ||
                   registerBirthday == null ||
                   registerCityTextValue.isEmpty() ||
                   registerCountryTextValue.isEmpty())
                {
                	String message = "Bitte füllen Sie alle Felder aus!";
                	JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                	try
            		{
    					if(rwS.compareUsers(registerLoginNameTextValue))
    					{
    						String message = "Username ist bereits vergeben, bitte wählen Sie einen anderen!";
    	                	JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
    					}
    					else
    					{
    						try
    		                {
    							rwS.createUserProfile(registerLoginNameTextValue, 
    													registerLoginPasswordTextValue, 
    													registerFirstNameTextValue, 
    													registerLastNameTextValue, 
    													registerBirthday,
    													registerCityTextValue, 
    													registerCountryTextValue);
//    							xmpp.erzeugeNode(registerLoginNameTextValue);
    						}
    						catch(FileNotFoundException e)
    		                {
    							e.printStackTrace();
    						}
    		                catch(JAXBException e)
    		                {
    		                	e.printStackTrace();
    		                }
//    						catch (XMPPException e)
//    						{
//								e.printStackTrace();
//							}
    						
    						startScreen.setVisible(true);
    		            	registerScreen.setVisible(false);
    					}
    				}
                	catch(FileNotFoundException e1)
                    {
    					e1.printStackTrace();
    				}
                    catch(JAXBException e1)
                    {
                    	e1.printStackTrace();
                    }
                }	
            }
        });
        
        // Profil-Screen Profil verlassen-Button
        profileLeaveButton.addActionListener(new ActionListener()
        {
			@Override
            public void actionPerformed(ActionEvent event)
            {
				startScreen.setVisible(true);
				profileScreenUserIsLoggedIn.setVisible(false);
				userIsLoggedIn.setVisible(true);
				
				try
				{
					if(rwS.checkStreamchannelExists(rwS.getUserID(loginUsernameTextField.getText().replaceAll("\\s", ""))))
					{
						userIsLoggedInshowUserStreamchannel.setVisible(true);
					}
					else
					{
						userIsLoggedInshowUserStreamchannel.setVisible(false);
					}
				}
				catch(FileNotFoundException e)
                {
					e.printStackTrace();
				}
                catch(JAXBException e)
                {
                	e.printStackTrace();
                }
            }
        });
        
        // Profil-Screen Profil löschen-Button
        profileDeleteProfileButton.addActionListener(new ActionListener()
        {
			@Override
            public void actionPerformed(ActionEvent event)
            {	
				try
				{
					rwS.deleteUserProfile(loginUsernameTextField.getText().replaceAll("\\s", ""));
					startScreen.setVisible(true);
					profileScreenUserIsLoggedIn.setVisible(false);
					userIsLoggedIn.setVisible(false);
					register.setVisible(true);
					login.setVisible(true);
				}
				catch(FileNotFoundException e)
                {
					e.printStackTrace();
				}
                catch(JAXBException e)
                {
                	e.printStackTrace();
                }
				
            }
        });
        
        // Profil-Screen Passwort ändern-Button
        profileChangePasswordButton.addActionListener(new ActionListener()
        {
			@Override
            public void actionPerformed(ActionEvent event)
            {	
				if((loginUserpasswordTextField.getText().replaceAll("\\s", "")).equals(profileLoginPasswordTextField.getText().replaceAll("\\s", "")))
				{
					String message = "Bitte gib ein neues Passwort ein!";
		            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					try
					{
						rwS.setNewPassword(rwS.getUserID(loginUsernameTextField.getText().replaceAll("\\s", "")), profileLoginPasswordTextField.getText().replaceAll("\\s", ""));
					}
					catch (FileNotFoundException | JAXBException e)
					{
						e.printStackTrace();
					}
					
			        String message = "Passwort wurde geändert!";
			        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
			        startScreen.setVisible(true);
					profileScreenUserIsLoggedIn.setVisible(false);
					userIsLoggedIn.setVisible(false);
					register.setVisible(true);
					login.setVisible(true);
				}
            }
        });
        
        // Profil-Screen Streamchannel erstellen-Button
        profileCreateStreamchannelButton.addActionListener(new ActionListener()
        {
			@Override
            public void actionPerformed(ActionEvent event)
			{
				profileScreenUserIsLoggedIn.setVisible(false);
				createStreamchannelScreen.setVisible(true);
            }
        });
        
        // Profil-Screen Profil bearbeiten-Button
        profileChangeProfileButton.addActionListener(new ActionListener()
        {
			@Override
            public void actionPerformed(ActionEvent event)
            {	
				XMLGregorianCalendar profileNewBirthday = null;
				Date date = null;
				SimpleDateFormat simpleDateFormat;
				GregorianCalendar gregorianCalendar;
				simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
				
				try
				{
					date = simpleDateFormat.parse(profileBirthdayTextField.getText());
				}
				catch (ParseException e3)
				{
					e3.printStackTrace();
				}     
				
				gregorianCalendar = (GregorianCalendar)GregorianCalendar.getInstance();
				gregorianCalendar.setTime(date);
				
				try
				{
					profileNewBirthday = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
				}
				catch (DatatypeConfigurationException e2)
				{
					e2.printStackTrace();
				}
				
				if(profileFirstNameTextField.getText().isEmpty() ||
				   profileLastNameTextField.getText().isEmpty() ||
				   profileNewBirthday == null ||
				   profileCityTextField.getText().isEmpty() ||
				   profileCountryTextField.getText().isEmpty())
		        {
					String message = "Bitte füllen Sie alle Felder aus!";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
		        }
				else
				{
					try
					{
						rwS.updateUserProfile(rwS.getUserID(loginUsernameTextField.getText().replaceAll("\\s", "")),  
											 profileFirstNameTextField.getText(), 
											 profileLastNameTextField.getText(),  
											 profileNewBirthday, 
											 profileCityTextField.getText(), 
											 profileCountryTextField.getText());
					}
					catch (FileNotFoundException | JAXBException e1)
					{
						e1.printStackTrace();
					}
					
					String message = "Das Profil wurde geändert!";
				    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
				}
            }
        });
        
        // Profil-Screen Streamchannel bearbeiten-Button
        profileChangeStreamchannelButton.addActionListener(new ActionListener()
        {
			@Override
            public void actionPerformed(ActionEvent event)
            {
				Users text = new Users();
				try
				{
					text = rwS.showStreamchannel(rwS.getUserID(loginUsernameTextField.getText().replaceAll("\\s", "")));
				}
				catch (FileNotFoundException | JAXBException e)
				{
					e.printStackTrace();
				}
		        
				createStreamchannelTopicTextField.setText(text.getUser().get(0).getStreamChannel().getChannelTopic());
				createStreamchannelHeadlineTextField.setText(text.getUser().get(0).getStreamChannel().getChannelDescription().getChannelHeadline());
				createStreamchannelInformationTextField.setText(text.getUser().get(0).getStreamChannel().getChannelDescription().getChannelInformation());
				
				createStreamchannelScreen.setVisible(true);
				createStreamchannelChangeStreamchannelButton.setVisible(true);
				createStreamchannelSubmitButton.setVisible(false);
				profileScreenUserIsLoggedIn.setVisible(false);
            }
        });
        
        // Profil-Screen Streamchannel löschen-Button
        profileDeleteStreamchannelButton.addActionListener(new ActionListener()
        {
			@Override
            public void actionPerformed(ActionEvent event)
            {	
				try
				{
					rwS.deleteStreamchannel(rwS.getUserID(loginUsernameTextField.getText().replaceAll("\\s", "")));
				}
				catch(FileNotFoundException e)
                {
					e.printStackTrace();
				}
                catch(JAXBException e)
                {
                	e.printStackTrace();
                }
				profileCreateStreamchannelButton.setVisible(true);
				profileDeleteStreamchannelButton.setVisible(false);
				profileChangeStreamchannelButton.setVisible(false);
				createStreamchannelChangeStreamchannelButton.setVisible(false);
				createStreamchannelSubmitButton.setVisible(true);
            }
        });
        
        // Streamchannel erstellen-Screen Streamchannel erstellen-Button
        createStreamchannelSubmitButton.addActionListener(new ActionListener()
        {
			@Override
            public void actionPerformed(ActionEvent event)
            {
				String createStreamchannelTopicTextValue = createStreamchannelTopicTextField.getText();
                String createStreamchannelHeadlineTextValue = createStreamchannelHeadlineTextField.getText();
                String createStreamchannelInformationTextValue = createStreamchannelInformationTextField.getText();
                createStreamchannelTopicTextValue = createStreamchannelTopicTextValue.replaceAll("\\s", "");
                
                if(createStreamchannelTopicTextValue.isEmpty() ||
                   createStreamchannelHeadlineTextValue.isEmpty() ||
                   createStreamchannelInformationTextValue.isEmpty())
                {
                	String message = "Bitte füllen Sie alle Felder aus!";
                	JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                	try
                	{
						if(!rwS.searchTopic(createStreamchannelTopicTextValue))
						{
							rwS.createTopic(createStreamchannelTopicTextValue);
						}
						
						try
						{
							rwS.createStreamchannel(rwS.getUserID(loginUsernameTextField.getText().replaceAll("\\s", "")), 
												   createStreamchannelTopicTextValue, 
												   createStreamchannelHeadlineTextValue, 
												   createStreamchannelInformationTextValue);
							
							xmpp.erzeugeNode(loginUsernameTextField.getText().replaceAll("\\s", ""));
						}
						catch(FileNotFoundException e)
						{
							e.printStackTrace();
						}
						catch(JAXBException e)
						{
							e.printStackTrace();
						}
						catch (XMPPException e)
						{
							e.printStackTrace();
						}
					}
                	catch(FileNotFoundException e)
					{
						e.printStackTrace();
					}
					catch(JAXBException e)
					{
						e.printStackTrace();
					}
    						
    				createStreamchannelScreen.setVisible(false);
    				//streamchannelScreenUserIsLoggedIn.visible(true);
    				profileScreenUserIsLoggedIn.setVisible(true);
    				profileCreateStreamchannelButton.setVisible(false);
    				profileDeleteStreamchannelButton.setVisible(true);
    				profileChangeStreamchannelButton.setVisible(true);
                }
            }
        });
        
        // Streamchannel erstellen-Screen Streamchannel bearbeiten-Button
        createStreamchannelChangeStreamchannelButton.addActionListener(new ActionListener()
        {
			@Override
            public void actionPerformed(ActionEvent event)
            {
                if(createStreamchannelTopicTextField.getText().isEmpty() ||
                   createStreamchannelHeadlineTextField.getText().isEmpty() ||
                   createStreamchannelInformationTextField.getText().isEmpty())
                {
                	String message = "Bitte füllen Sie alle Felder aus!";
                	JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                	try
    				{
    					rwS.updateStreamchannel(rwS.getUserID(loginUsernameTextField.getText().replaceAll("\\s", "")),  
    										 createStreamchannelTopicTextField.getText(), 
    										 createStreamchannelHeadlineTextField.getText(), 
    										 createStreamchannelInformationTextField.getText());
    				}
    				catch (FileNotFoundException | JAXBException e1)
    				{
    					e1.printStackTrace();
    				}
    				
    			    String message = "Der Streamchannel wurde geändert!";
    			    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
    						
    				createStreamchannelScreen.setVisible(false);
    				createStreamchannelSubmitButton.setVisible(false);
    				//streamchannelScreenUserIsLoggedIn.visible(true);
    				profileScreenUserIsLoggedIn.setVisible(true);
                }
            }
        });
        
        // Streamchannel erstellen-Screen abbrechen-Button
        createStreamchannelCancelButton.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent event)
            {
        		profileScreenUserIsLoggedIn.setVisible(true);
				createStreamchannelScreen.setVisible(false);
            }
        });
        
        // Streamchannel-Screen UserIsLoggedIn Kommentar 1 löschen-Button
        streamchannelScreenUserIsLoggedInCommentsComment1DeleteCommentButton.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent event)
            {
        		Users streamchannel = new Users();
				Users comments = new Users();
				User newUser = new User();
				
				int numberOfChannelComments = 0;
                
                try
                {
                	numberOfChannelComments = rwS.getNumberOfStreamchannelComments(loginUsernameTextField.getText().replaceAll("\\s", ""));
                	
				}
                catch (FileNotFoundException | JAXBException e)
                {
					e.printStackTrace();
				}
				
				try
				{
					streamchannel = rwS.showStreamchannel(rwS.getUserID(loginUsernameTextField.getText().replaceAll("\\s", "")));
				}
				catch (FileNotFoundException | JAXBException e1)
				{
					e1.printStackTrace();
				}
                
        		try
        		{
        			comments = rwS.showStreamchannelComments(loginUsernameTextField.getText().replaceAll("\\s", ""));
        		}
        		catch (FileNotFoundException | JAXBException e1)
        		{
        			e1.printStackTrace();
        		}
        		
        		int commentID = comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentID();
				
        		List<ChannelComment> channelComments = streamchannel.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment();
        		StreamChannel newStreamchannel = new StreamChannel();
        		ChannelComments newChannelcomments = new ChannelComments();
        		
        		newStreamchannel.setChannelComments(newChannelcomments);
        		newUser.setStreamChannel(newStreamchannel);
        		comments.getUser().add(newUser);
        		
        		for(ChannelComment cc : channelComments)
        		{
        			comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().add(cc);
        		}
        		
        		try
        		{
					rwS.deleteStreamchannelComment(loginUsernameTextField.getText().replaceAll("\\s", ""), commentID);
				}
        		catch (FileNotFoundException | JAXBException e)
        		{
					e.printStackTrace();
				}
        		
        		streamchannelScreenUserIsLoggedIn.setVisible(false);
        		startScreen.setVisible(true);
        		
        		showStreamchannelOfUser(loginUsernameTextField, 
				        				streamchannelScreenUserIsLoggedInCommentsComment1, 
				        				streamchannelScreenUserIsLoggedInCommentsComment2, 
				        				streamchannelScreenUserIsLoggedInCommentsComment3, 
				        				streamchannelScreenUserIsLoggedInCommentsComment1DateValue,
				        				streamchannelScreenUserIsLoggedInCommentsComment2DateValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment3DateValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment1CommentValue, 
										streamchannelScreenUserIsLoggedInCommentsComment2CommentValue, 
										streamchannelScreenUserIsLoggedInCommentsComment3CommentValue, 
										streamchannelScreenUserIsLoggedInCommentsComment1HeadlineValue, 
										streamchannelScreenUserIsLoggedInCommentsComment2HeadlineValue, 
										streamchannelScreenUserIsLoggedInCommentsComment3HeadlineValue, 
										streamchannelScreenUserIsLoggedInCommentsCommentsNoComments, 
										streamchannelScreenUserIsLoggedInText,
										streamchannelScreenUserIsLoggedInTopicText, 
										streamchannelScreenUserIsLoggedInHeadlineText, 
										streamchannelScreenUserIsLoggedInInformationText, 
										streamchannelScreenUserIsLoggedInText_Info, 
									    streamchannelScreenUserIsLoggedIn,
								    	startScreen);
            }
        });
        
        // Streamchannel-Screen UserIsLoggedIn Kommentar 2 löschen-Button
        streamchannelScreenUserIsLoggedInCommentsComment2DeleteCommentButton.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent event)
            {
        		Users streamchannel = new Users();
				Users comments = new Users();
				User newUser = new User();
				
				int numberOfChannelComments = 0;
                
                try
                {
                	numberOfChannelComments = rwS.getNumberOfStreamchannelComments(loginUsernameTextField.getText().replaceAll("\\s", ""));
                	
				}
                catch (FileNotFoundException | JAXBException e)
                {
					e.printStackTrace();
				}
				
				try
				{
					streamchannel = rwS.showStreamchannel(rwS.getUserID(loginUsernameTextField.getText().replaceAll("\\s", "")));
				}
				catch (FileNotFoundException | JAXBException e1)
				{
					e1.printStackTrace();
				}
                
        		try
        		{
        			comments = rwS.showStreamchannelComments(loginUsernameTextField.getText().replaceAll("\\s", ""));
        		}
        		catch (FileNotFoundException | JAXBException e1)
        		{
        			e1.printStackTrace();
        		}
        		
        		int commentID = comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-2).getCommentID();
				
        		List<ChannelComment> channelComments = streamchannel.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment();
        		StreamChannel newStreamchannel = new StreamChannel();
        		ChannelComments newChannelcomments = new ChannelComments();
        		
        		newStreamchannel.setChannelComments(newChannelcomments);
        		newUser.setStreamChannel(newStreamchannel);
        		comments.getUser().add(newUser);
        		
        		for(ChannelComment cc : channelComments)
        		{
        			comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().add(cc);
        		}
        		
        		try
        		{
					rwS.deleteStreamchannelComment(loginUsernameTextField.getText().replaceAll("\\s", ""), commentID);
				}
        		catch (FileNotFoundException | JAXBException e)
        		{
					e.printStackTrace();
				}
        		
        		streamchannelScreenUserIsLoggedIn.setVisible(false);
        		startScreen.setVisible(true);
        		
        		showStreamchannelOfUser(loginUsernameTextField, 
				        				streamchannelScreenUserIsLoggedInCommentsComment1, 
				        				streamchannelScreenUserIsLoggedInCommentsComment2, 
				        				streamchannelScreenUserIsLoggedInCommentsComment3, 
				        				streamchannelScreenUserIsLoggedInCommentsComment1DateValue,
				        				streamchannelScreenUserIsLoggedInCommentsComment2DateValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment3DateValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment1CommentValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment2CommentValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment3CommentValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment1HeadlineValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment2HeadlineValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment3HeadlineValue, 
				        				streamchannelScreenUserIsLoggedInCommentsCommentsNoComments, 
				        				streamchannelScreenUserIsLoggedInText,
				        				streamchannelScreenUserIsLoggedInTopicText, 
				        				streamchannelScreenUserIsLoggedInHeadlineText, 
				        				streamchannelScreenUserIsLoggedInInformationText, 
				        				streamchannelScreenUserIsLoggedInText_Info, 
									    streamchannelScreenUserIsLoggedIn,
								    	startScreen);
            }
        });
        
        // Streamchannel-Screen UserIsLoggedIn Kommentar 3 löschen-Button
        streamchannelScreenUserIsLoggedInCommentsComment3DeleteCommentButton.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent event)
            {
        		Users streamchannel = new Users();
				Users comments = new Users();
				User newUser = new User();
				
				int numberOfChannelComments = 0;
                
                try
                {
                	numberOfChannelComments = rwS.getNumberOfStreamchannelComments(loginUsernameTextField.getText().replaceAll("\\s", ""));
                	
				}
                catch (FileNotFoundException | JAXBException e)
                {
					e.printStackTrace();
				}
				
				try
				{
					streamchannel = rwS.showStreamchannel(rwS.getUserID(loginUsernameTextField.getText().replaceAll("\\s", "")));
				}
				catch (FileNotFoundException | JAXBException e1)
				{
					e1.printStackTrace();
				}
                
        		try
        		{
        			comments = rwS.showStreamchannelComments(loginUsernameTextField.getText().replaceAll("\\s", ""));
        		}
        		catch (FileNotFoundException | JAXBException e1)
        		{
        			e1.printStackTrace();
        		}
        		
        		int commentID = comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-3).getCommentID();
				
        		List<ChannelComment> channelComments = streamchannel.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment();
        		StreamChannel newStreamchannel = new StreamChannel();
        		ChannelComments newChannelcomments = new ChannelComments();
        		
        		newStreamchannel.setChannelComments(newChannelcomments);
        		newUser.setStreamChannel(newStreamchannel);
        		comments.getUser().add(newUser);
        		
        		for(ChannelComment cc : channelComments)
        		{
        			comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().add(cc);
        		}
        		
        		try
        		{
					rwS.deleteStreamchannelComment(loginUsernameTextField.getText().replaceAll("\\s", ""), commentID);
				}
        		catch (FileNotFoundException | JAXBException e)
        		{
					e.printStackTrace();
				}
        		
        		streamchannelScreenUserIsLoggedIn.setVisible(false);
        		startScreen.setVisible(true);
        		
        		showStreamchannelOfUser(loginUsernameTextField, 
				        				streamchannelScreenUserIsLoggedInCommentsComment1, 
				        				streamchannelScreenUserIsLoggedInCommentsComment2, 
				        				streamchannelScreenUserIsLoggedInCommentsComment3, 
				        				streamchannelScreenUserIsLoggedInCommentsComment1DateValue,
				        				streamchannelScreenUserIsLoggedInCommentsComment2DateValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment3DateValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment1CommentValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment2CommentValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment3CommentValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment1HeadlineValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment2HeadlineValue, 
				        				streamchannelScreenUserIsLoggedInCommentsComment3HeadlineValue, 
				        				streamchannelScreenUserIsLoggedInCommentsCommentsNoComments, 
				        				streamchannelScreenUserIsLoggedInText,
				        				streamchannelScreenUserIsLoggedInTopicText, 
				        				streamchannelScreenUserIsLoggedInHeadlineText, 
				        				streamchannelScreenUserIsLoggedInInformationText, 
				        				streamchannelScreenUserIsLoggedInText_Info, 
									    streamchannelScreenUserIsLoggedIn,
								    	startScreen);
            }
        });
        
        // Streamchannel-Screen UserIsLoggedIn Stream verlassen-Button
        streamchannelScreenUserIsLoggedInLeaveStreamButton.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent event)
            {
				startScreen.setVisible(true);
				streamchannelScreenUserIsLoggedIn.setVisible(false);
				userIsLoggedIn.setVisible(true);
				userIsLoggedInshowUserStreamchannel.setVisible(true);
            }
        });
	        
	    // Streamchannel-Screen UserIsLoggedIn Stream starten-Button
        streamchannelScreenUserIsLoggedInStartStreamButton.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent event)
        	{
        		try
        		{
					xmpp.publishNode(loginUsernameTextField.getText().replaceAll("\\s", ""), "Ich streame wieder!");
				}
        		catch (Exception e)
        		{
					e.printStackTrace();
				}
        	}
        });
	        
        // Streamchannel-Screen UserIsLoggedIn Stream stoppen-Button
        streamchannelScreenUserIsLoggedInStopStreamButton.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent event)
        	{
        		xmpp.disconnect();
        	}
        });
        
        // Logout User
        userLogoutButton.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent event)
        	{
        		register.setVisible(true);
        		login.setVisible(true);
        		userIsLoggedIn.setVisible(false);
        		userIsLoggedInshowUserStreamchannel.setVisible(false);
        		try
        		{
					xmpplogout();
        		}
				catch (XMPPException e)
				{
					e.printStackTrace();
				}
        	}
        });
        
        // Topicsuche Streamchannel eines bestimmten Users anzeigen
        resultTopicListshowStreamchannel1Button.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent event)
            {
        		String searchTopicsTextValue = searchTopicsTextField.getText();
				searchTopicsTextValue = searchTopicsTextValue.replaceAll("\\s", "");
        		
        		Users user = new Users();
        		
				try
				{
					user = rwS.showStreamerUsingTopic(searchTopicsTextValue);
				}
				catch (FileNotFoundException | JAXBException e1)
				{
					e1.printStackTrace();
				}
        		
        		foundUser = user.getUser().get(0).getUserStreamChannelName();
        		
        		try
        		{
					showStreamchannel(foundUser, 
									  streamchannelOtherUsersCommentsComment1CommentText, 
									  streamchannelOtherUsersCommentsComment2CommentText, 
									  streamchannelOtherUsersCommentsComment3CommentText, 
									  streamchannelOtherUsersCommentsComment1, 
									  streamchannelOtherUsersCommentsComment2, 
									  streamchannelOtherUsersCommentsComment3, 
									  streamchannelOtherUsersCommentsComment1DateValue,
									  streamchannelOtherUsersCommentsComment2DateValue, 
									  streamchannelOtherUsersCommentsComment3DateValue, 
									  streamchannelOtherUsersCommentsComment1CommentValue, 
									  streamchannelOtherUsersCommentsComment2CommentValue, 
									  streamchannelOtherUsersCommentsComment3CommentValue, 
									  streamchannelOtherUsersCommentsComment1HeadlineValue, 
									  streamchannelOtherUsersCommentsComment2HeadlineValue, 
									  streamchannelOtherUsersCommentsComment3HeadlineValue, 
									  streamchannelOtherUsersCommentsCommentsNoComments, 
									  streamchannelOtherUsersText,
									  streamchannelOtherUsersTopicText, 
									  streamchannelOtherUsersHeadlineText, 
									  streamchannelOtherUsersInformationText, 
									  streamchannelOtherUsersText_Info, 
									  streamchannelOtherUsers,
									  startScreen);
				}
        		catch (FileNotFoundException | JAXBException e)
        		{
					e.printStackTrace();
				}
        		
        		searchScreenTopic.setVisible(false);
        		streamchannelOtherUsers.setVisible(true);
            }
        });
        
        // Topicsuche Streamchannel eines bestimmten Users anzeigen
        resultTopicListshowStreamchannel2Button.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent event)
            {
        		String searchTopicsTextValue = searchTopicsTextField.getText();
				searchTopicsTextValue = searchTopicsTextValue.replaceAll("\\s", "");
        		
        		Users user = new Users();
        		
				try
				{
					user = rwS.showStreamerUsingTopic(searchTopicsTextValue);
				}
				catch (FileNotFoundException | JAXBException e1)
				{
					e1.printStackTrace();
				}
        		
        		foundUser = user.getUser().get(1).getUserStreamChannelName();
        		
        		try
        		{
					showStreamchannel(foundUser, 
									  streamchannelOtherUsersCommentsComment1CommentText, 
									  streamchannelOtherUsersCommentsComment2CommentText, 
									  streamchannelOtherUsersCommentsComment3CommentText, 
									  streamchannelOtherUsersCommentsComment1, 
									  streamchannelOtherUsersCommentsComment2, 
									  streamchannelOtherUsersCommentsComment3, 
									  streamchannelOtherUsersCommentsComment1DateValue,
									  streamchannelOtherUsersCommentsComment2DateValue, 
									  streamchannelOtherUsersCommentsComment3DateValue, 
									  streamchannelOtherUsersCommentsComment1CommentValue, 
									  streamchannelOtherUsersCommentsComment2CommentValue, 
									  streamchannelOtherUsersCommentsComment3CommentValue, 
									  streamchannelOtherUsersCommentsComment1HeadlineValue, 
									  streamchannelOtherUsersCommentsComment2HeadlineValue, 
									  streamchannelOtherUsersCommentsComment3HeadlineValue, 
									  streamchannelOtherUsersCommentsCommentsNoComments, 
									  streamchannelOtherUsersText,
									  streamchannelOtherUsersTopicText, 
									  streamchannelOtherUsersHeadlineText, 
									  streamchannelOtherUsersInformationText, 
									  streamchannelOtherUsersText_Info, 
									  streamchannelOtherUsers,
									  startScreen);
				}
        		catch (FileNotFoundException | JAXBException e)
        		{
					e.printStackTrace();
				}
        		
        		searchScreenTopic.setVisible(false);
        		streamchannelOtherUsers.setVisible(true);
            }
        });
        
        // Topicsuche Streamchannel eines bestimmten Users anzeigen
        resultTopicListshowStreamchannel3Button.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent event)
        	{
        		String searchTopicsTextValue = searchTopicsTextField.getText();
				searchTopicsTextValue = searchTopicsTextValue.replaceAll("\\s", "");
        		
        		Users user = new Users();
        		
				try
				{
					user = rwS.showStreamerUsingTopic(searchTopicsTextValue);
				}
				catch (FileNotFoundException | JAXBException e1)
				{
					e1.printStackTrace();
				}
        		
        		foundUser = user.getUser().get(2).getUserStreamChannelName();
        		
        		try
        		{
					showStreamchannel(foundUser, 
									  streamchannelOtherUsersCommentsComment1CommentText, 
									  streamchannelOtherUsersCommentsComment2CommentText, 
									  streamchannelOtherUsersCommentsComment3CommentText, 
									  streamchannelOtherUsersCommentsComment1, 
									  streamchannelOtherUsersCommentsComment2, 
									  streamchannelOtherUsersCommentsComment3, 
									  streamchannelOtherUsersCommentsComment1DateValue,
									  streamchannelOtherUsersCommentsComment2DateValue, 
									  streamchannelOtherUsersCommentsComment3DateValue, 
									  streamchannelOtherUsersCommentsComment1CommentValue, 
									  streamchannelOtherUsersCommentsComment2CommentValue, 
									  streamchannelOtherUsersCommentsComment3CommentValue, 
									  streamchannelOtherUsersCommentsComment1HeadlineValue, 
									  streamchannelOtherUsersCommentsComment2HeadlineValue, 
									  streamchannelOtherUsersCommentsComment3HeadlineValue, 
									  streamchannelOtherUsersCommentsCommentsNoComments, 
									  streamchannelOtherUsersText,
									  streamchannelOtherUsersTopicText, 
									  streamchannelOtherUsersHeadlineText, 
									  streamchannelOtherUsersInformationText, 
									  streamchannelOtherUsersText_Info, 
									  streamchannelOtherUsers,
									  startScreen);
				}
        		catch (FileNotFoundException | JAXBException e)
        		{
					e.printStackTrace();
				}
        		
        		searchScreenTopic.setVisible(false);
        		streamchannelOtherUsers.setVisible(true);
            }
        });
        
        // Topicsuche Streamchannel eines bestimmten Users anzeigen
        resultTopicListshowStreamchannel4Button.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent event)
        	{
        		String searchTopicsTextValue = searchTopicsTextField.getText();
				searchTopicsTextValue = searchTopicsTextValue.replaceAll("\\s", "");
        		
        		Users user = new Users();
				try
				{
					user = rwS.showStreamerUsingTopic(searchTopicsTextValue);
				}
				catch (FileNotFoundException | JAXBException e1)
				{
					e1.printStackTrace();
				}
        		
        		foundUser = user.getUser().get(1).getUserStreamChannelName();
        		
        		try
        		{
					showStreamchannel(foundUser, 
									  streamchannelOtherUsersCommentsComment1CommentText, 
									  streamchannelOtherUsersCommentsComment2CommentText, 
									  streamchannelOtherUsersCommentsComment3CommentText, 
									  streamchannelOtherUsersCommentsComment1, 
									  streamchannelOtherUsersCommentsComment2, 
									  streamchannelOtherUsersCommentsComment3, 
									  streamchannelOtherUsersCommentsComment1DateValue,
									  streamchannelOtherUsersCommentsComment2DateValue, 
									  streamchannelOtherUsersCommentsComment3DateValue, 
									  streamchannelOtherUsersCommentsComment1CommentValue, 
									  streamchannelOtherUsersCommentsComment2CommentValue, 
									  streamchannelOtherUsersCommentsComment3CommentValue, 
									  streamchannelOtherUsersCommentsComment1HeadlineValue, 
									  streamchannelOtherUsersCommentsComment2HeadlineValue, 
									  streamchannelOtherUsersCommentsComment3HeadlineValue, 
									  streamchannelOtherUsersCommentsCommentsNoComments, 
									  streamchannelOtherUsersText,
									  streamchannelOtherUsersTopicText, 
									  streamchannelOtherUsersHeadlineText, 
									  streamchannelOtherUsersInformationText, 
									  streamchannelOtherUsersText_Info, 
									  streamchannelOtherUsers,
									  startScreen);
				}
        		catch (FileNotFoundException | JAXBException e)
        		{
					e.printStackTrace();
				}
        		
        		searchScreenTopic.setVisible(false);
        		streamchannelOtherUsers.setVisible(true);
            }
        });
        
        // Topicsuche Streamchannel eines bestimmten Users anzeigen
        resultTopicListshowStreamchannel5Button.addActionListener(new ActionListener()
        {
        	@Override
            public void actionPerformed(ActionEvent event)
        	{
        		String searchTopicsTextValue = searchTopicsTextField.getText();
				searchTopicsTextValue = searchTopicsTextValue.replaceAll("\\s", "");
        		
        		Users user = new Users();
        		
				try
				{
					user = rwS.showStreamerUsingTopic(searchTopicsTextValue);
				}
				catch (FileNotFoundException | JAXBException e1)
				{
					e1.printStackTrace();
				}
        		
        		foundUser = user.getUser().get(3).getUserStreamChannelName();
        		
        		try
        		{
					showStreamchannel(foundUser, 
									  streamchannelOtherUsersCommentsComment1CommentText, 
									  streamchannelOtherUsersCommentsComment2CommentText, 
									  streamchannelOtherUsersCommentsComment3CommentText, 
									  streamchannelOtherUsersCommentsComment1, 
									  streamchannelOtherUsersCommentsComment2, 
									  streamchannelOtherUsersCommentsComment3, 
									  streamchannelOtherUsersCommentsComment1DateValue,
									  streamchannelOtherUsersCommentsComment2DateValue, 
									  streamchannelOtherUsersCommentsComment3DateValue, 
									  streamchannelOtherUsersCommentsComment1CommentValue, 
									  streamchannelOtherUsersCommentsComment2CommentValue, 
									  streamchannelOtherUsersCommentsComment3CommentValue, 
									  streamchannelOtherUsersCommentsComment1HeadlineValue, 
									  streamchannelOtherUsersCommentsComment2HeadlineValue, 
									  streamchannelOtherUsersCommentsComment3HeadlineValue, 
									  streamchannelOtherUsersCommentsCommentsNoComments, 
									  streamchannelOtherUsersText,
									  streamchannelOtherUsersTopicText, 
									  streamchannelOtherUsersHeadlineText, 
									  streamchannelOtherUsersInformationText, 
									  streamchannelOtherUsersText_Info, 
									  streamchannelOtherUsers,
									  startScreen);
				}
        		catch (FileNotFoundException | JAXBException e)
        		{
					e.printStackTrace();
				}
        		
        		searchScreenTopic.setVisible(false);
        		streamchannelOtherUsers.setVisible(true);
            }
        });
        
        // Streamchannel other Users - Kommentar posten
        streamchannelOtherUsersCommentsPostCommentButton.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent event)
        	{
        		String searchTopicsTextValue = searchTopicsTextField.getText();
				searchTopicsTextValue = searchTopicsTextValue.replaceAll("\\s", "");
        		        		
        		GregorianCalendar gregorianCalendar = new GregorianCalendar();
        		DatatypeFactory datatypeFactory = null;
        		
				try
				{
					datatypeFactory = DatatypeFactory.newInstance();
				}
				catch (DatatypeConfigurationException e)
				{
					e.printStackTrace();
				}
        		XMLGregorianCalendar now = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        		
        		String newCommentHeadline = streamchannelOtherUsersCommentTextValue.getText();
        		String newCommentText = streamchannelOtherUsersCommentHeadlineValue.getText();
        		
        		if(newCommentHeadline.isEmpty() || newCommentText.isEmpty())
        		{
                     String message = "Bitte füllen Sie alle Felder aus!";
                     JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                	try
                	{
						rwS.createStreamchannelComment(foundUser, now, newCommentHeadline, newCommentText);
					}
                	catch (FileNotFoundException | JAXBException e)
					{
						e.printStackTrace();
					}
                }
        	}
        });
        
        // Subscribe Streamchannel-Button
        streamchannelOtherUsersSubscribeChannelButton.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent event)
        	{
        		System.out.println(loggedInUser);
        		
        		try
        		{
					if(loggedInUser.isEmpty())
					{
						String message = "Bitte einloggen!";
				        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						xmpp.subscribeNode(foundUser);
						xmpp.listenerAnmelden(foundUser);
					}
				}
        		catch (XMPPException e)
        		{
					e.printStackTrace();
				}
        		catch (Exception e)
        		{
					e.printStackTrace();
				}
			}
		});
        
        // Unscribe Streamchannel-Button
        streamchannelOtherUsersUnscribeChannelButton.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent event)
        	{
        		System.out.println(loggedInUser);
        		
        		try
        		{
					if(loggedInUser.isEmpty())
					{
						String message = "Bitte einloggen!";
				        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						xmpp.unsubscribeNode(foundUser);
						xmpp.listenerAnmelden(foundUser);
					}
				}
        		catch (XMPPException e)
        		{
					e.printStackTrace();
				}
        		catch (Exception e)
        		{
					e.printStackTrace();
				}
			}
		});
        
        // streamchannelOtherUsersLeaveChannelButton
        streamchannelOtherUsersLeaveChannelButton.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent event)
        	{
        		startScreen.setVisible(true);
        		streamchannelOtherUsers.setVisible(false);
			}
		});
        
        // Eventlistener für Buttons
    }

	protected void xmpplogin(String loginUsernameTextValue, String loginUserpasswordTextValue) throws XMPPException
    {
    	xmpp = new XMPP_Schnittstellen(loginUsernameTextValue, loginUserpasswordTextValue);
		xmpp.login("go");
	}
    
    protected void xmpplogout() throws XMPPException
    {
    	xmpp.disconnect();
	}
    
	// Streamchannel des eingeloggten Benutzers anzeigen
	protected void showStreamchannelOfUser(JTextField loginUsernameTextField, 
										   JPanel streamchannelScreenUserIsLoggedInCommentsComment1, 
										   JPanel streamchannelScreenUserIsLoggedInCommentsComment2, 
										   JPanel streamchannelScreenUserIsLoggedInCommentsComment3, 
										   JLabel streamchannelScreenUserIsLoggedInCommentsComment1DateValue,
										   JLabel streamchannelScreenUserIsLoggedInCommentsComment2DateValue, 
										   JLabel streamchannelScreenUserIsLoggedInCommentsComment3DateValue, 
										   JLabel streamchannelScreenUserIsLoggedInCommentsComment1CommentValue, 
										   JLabel streamchannelScreenUserIsLoggedInCommentsComment2CommentValue, 
										   JLabel streamchannelScreenUserIsLoggedInCommentsComment3CommentValue, 
										   JLabel streamchannelScreenUserIsLoggedInCommentsComment1HeadlineValue, 
										   JLabel streamchannelScreenUserIsLoggedInCommentsComment2HeadlineValue, 
										   JLabel streamchannelScreenUserIsLoggedInCommentsComment3HeadlineValue, 
										   JLabel streamchannelScreenUserIsLoggedInCommentsCommentsNoComments, 
										   JLabel streamchannelScreenUserIsLoggedInText,
										   JLabel streamchannelScreenUserIsLoggedInTopicText, 
										   JLabel streamchannelScreenUserIsLoggedInHeadlineText, 
										   JLabel streamchannelScreenUserIsLoggedInInformationText, 
										   JLabel streamchannelScreenUserIsLoggedInText_Info, 
										   JPanel streamchannelScreenUserIsLoggedIn,
										   JPanel startScreen)
	{
		Users streamchannel = new Users();
		Users comments = new Users();
		User newUser = new User();
		
		int numberOfChannelComments = 0;
		
		try
		{
			numberOfChannelComments = rwS.getNumberOfStreamchannelComments(loginUsernameTextField.getText().replaceAll("\\s", ""));
		}
		catch (FileNotFoundException | JAXBException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			streamchannel = rwS.showStreamchannel(rwS.getUserID(loginUsernameTextField.getText().replaceAll("\\s", "")));
		}
		catch (FileNotFoundException | JAXBException e1)
		{
			e1.printStackTrace();
		}
		
		try
		{
			comments = rwS.showStreamchannelComments(loginUsernameTextField.getText().replaceAll("\\s", ""));
		}
		catch (FileNotFoundException | JAXBException e1)
		{
			e1.printStackTrace();
		}
		
		List<ChannelComment> channelComments = streamchannel.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment();
		StreamChannel newStreamchannel = new StreamChannel();
		ChannelComments newChannelcomments = new ChannelComments();
		
		newStreamchannel.setChannelComments(newChannelcomments);
		newUser.setStreamChannel(newStreamchannel);
		comments.getUser().add(newUser);
		
		for(ChannelComment cc : channelComments)
		{
			comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().add(cc);
		}
		
		streamchannelScreenUserIsLoggedInCommentsComment1.setVisible(true);
		streamchannelScreenUserIsLoggedInCommentsComment2.setVisible(true);
		streamchannelScreenUserIsLoggedInCommentsComment3.setVisible(true);
		streamchannelScreenUserIsLoggedInCommentsCommentsNoComments.setVisible(false);
		
		if(numberOfChannelComments >= 3)
		{
			XMLGregorianCalendar date3 = comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-3).getCommentDate();
			SimpleDateFormat sdf3 = new SimpleDateFormat("MM/dd/yyyy hh:mm");
			GregorianCalendar gc3 = date3.toGregorianCalendar();
			String DateValue3 = sdf3.format(gc3.getTime());
			
			XMLGregorianCalendar date2 = comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-2).getCommentDate();
			SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy hh:mm");
			GregorianCalendar gc2 = date2.toGregorianCalendar();
			String DateValue2 = sdf2.format(gc2.getTime());
			
			XMLGregorianCalendar date1 = comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentDate();
			SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy hh:mm");
			GregorianCalendar gc1 = date1.toGregorianCalendar();
			String DateValue1 = sdf1.format(gc1.getTime());
			
			streamchannelScreenUserIsLoggedInCommentsComment1.setVisible(true);
			streamchannelScreenUserIsLoggedInCommentsComment2.setVisible(true);
			streamchannelScreenUserIsLoggedInCommentsComment3.setVisible(true);
			
			streamchannelScreenUserIsLoggedInCommentsComment1DateValue.setText(DateValue1);
			streamchannelScreenUserIsLoggedInCommentsComment1HeadlineValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentData().getCommentHeadline());
			streamchannelScreenUserIsLoggedInCommentsComment1CommentValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentData().getCommentText());
			
			streamchannelScreenUserIsLoggedInCommentsComment2DateValue.setText(DateValue2);
			streamchannelScreenUserIsLoggedInCommentsComment2HeadlineValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-2).getCommentData().getCommentHeadline());
			streamchannelScreenUserIsLoggedInCommentsComment2CommentValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-2).getCommentData().getCommentText());
			
			streamchannelScreenUserIsLoggedInCommentsComment3DateValue.setText(DateValue3);
			streamchannelScreenUserIsLoggedInCommentsComment3HeadlineValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-3).getCommentData().getCommentHeadline());
			streamchannelScreenUserIsLoggedInCommentsComment3CommentValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-3).getCommentData().getCommentText());
		}
		else
		{
			if(numberOfChannelComments == 2)
			{
				XMLGregorianCalendar date2 = comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-2).getCommentDate();
				SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy hh:mm");
				GregorianCalendar gc2 = date2.toGregorianCalendar();
				String DateValue2 = sdf2.format(gc2.getTime());
				
				XMLGregorianCalendar date1 = comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentDate();
				SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy hh:mm");
				GregorianCalendar gc1 = date1.toGregorianCalendar();
				String DateValue1 = sdf1.format(gc1.getTime());
				
				streamchannelScreenUserIsLoggedInCommentsComment1.setVisible(true);
				streamchannelScreenUserIsLoggedInCommentsComment2.setVisible(true);
				streamchannelScreenUserIsLoggedInCommentsComment3.setVisible(false);
				
				streamchannelScreenUserIsLoggedInCommentsComment1DateValue.setText(DateValue1);
				streamchannelScreenUserIsLoggedInCommentsComment1HeadlineValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentData().getCommentHeadline());
				streamchannelScreenUserIsLoggedInCommentsComment1CommentValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentData().getCommentText());
				
				streamchannelScreenUserIsLoggedInCommentsComment2DateValue.setText(DateValue2);
				streamchannelScreenUserIsLoggedInCommentsComment2HeadlineValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-2).getCommentData().getCommentHeadline());
				streamchannelScreenUserIsLoggedInCommentsComment2CommentValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-2).getCommentData().getCommentText());
				}
			else
			{
				if(numberOfChannelComments == 1)
				{
					XMLGregorianCalendar date1 = comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentDate();
					SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy hh:mm");
					GregorianCalendar gc1 = date1.toGregorianCalendar();
					String DateValue1 = sdf1.format(gc1.getTime());
					
					streamchannelScreenUserIsLoggedInCommentsComment1.setVisible(true);
					streamchannelScreenUserIsLoggedInCommentsComment2.setVisible(false);
					streamchannelScreenUserIsLoggedInCommentsComment3.setVisible(false);
					
					streamchannelScreenUserIsLoggedInCommentsComment1DateValue.setText(DateValue1);
					streamchannelScreenUserIsLoggedInCommentsComment1HeadlineValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentData().getCommentHeadline());
					streamchannelScreenUserIsLoggedInCommentsComment1CommentValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentData().getCommentText());
				}
				else
				{
					if(numberOfChannelComments == 0)
					{
						streamchannelScreenUserIsLoggedInCommentsComment1.setVisible(false);
						streamchannelScreenUserIsLoggedInCommentsComment2.setVisible(false);
						streamchannelScreenUserIsLoggedInCommentsComment3.setVisible(false);
						streamchannelScreenUserIsLoggedInCommentsCommentsNoComments.setVisible(true);
						streamchannelScreenUserIsLoggedInCommentsCommentsNoComments.setText("Ihr Streamchannel wurde noch nicht kommentiert!");
					}
				}
			}
		}
		
		streamchannelScreenUserIsLoggedInText.setText("Streamchannel von " + (loginUsernameTextField.getText().replaceAll("\\s", "")));
		streamchannelScreenUserIsLoggedInTopicText.setText("Thema des Streams: " + streamchannel.getUser().get(0).getStreamChannel().getChannelTopic());
		streamchannelScreenUserIsLoggedInHeadlineText.setText(streamchannel.getUser().get(0).getStreamChannel().getChannelDescription().getChannelHeadline());
		streamchannelScreenUserIsLoggedInText_Info.setText("Informationen zum Stream");
		streamchannelScreenUserIsLoggedInInformationText.setText(streamchannel.getUser().get(0).getStreamChannel().getChannelDescription().getChannelInformation());
		streamchannelScreenUserIsLoggedIn.setVisible(true);
		startScreen.setVisible(false);
	}
	
	protected void showStreamchannel(String searchUsersTextValue, 
									 JLabel streamchannelOtherUsersCommentsComment1CommentText, 
									 JLabel streamchannelOtherUsersCommentsComment2CommentText, 
									 JLabel streamchannelOtherUsersCommentsComment3CommentText, 
									 JPanel streamchannelOtherUsersCommentsComment1, 
									 JPanel streamchannelOtherUsersCommentsComment2, 
									 JPanel streamchannelOtherUsersCommentsComment3, 
									 JLabel streamchannelOtherUsersCommentsComment1DateValue, 
									 JLabel streamchannelOtherUsersCommentsComment2DateValue, 
									 JLabel streamchannelOtherUsersCommentsComment3DateValue, 
									 JLabel streamchannelOtherUsersCommentsComment1HeadlineValue, 
									 JLabel streamchannelOtherUsersCommentsComment2HeadlineValue, 
									 JLabel streamchannelOtherUsersCommentsComment3HeadlineValue, 
									 JLabel streamchannelOtherUsersCommentsComment1CommentValue, 
									 JLabel streamchannelOtherUsersCommentsComment2CommentValue, 
									 JLabel streamchannelOtherUsersCommentsComment3CommentValue, 
									 JLabel streamchannelOtherUsersCommentsCommentsNoComments,
									 JLabel streamchannelOtherUsersText, 
									 JLabel streamchannelOtherUsersTopicText, 
									 JLabel streamchannelOtherUsersHeadlineText, 
									 JLabel streamchannelOtherUsersText_Info, 
									 JLabel streamchannelOtherUsersInformationText, 
									 JPanel streamchannelOtherUsers, 
									 JPanel startScreen) throws FileNotFoundException, JAXBException
	{
		Users streamchannel = new Users();
		Users comments = new Users();
		User newUser = new User();
		
		int numberOfChannelComments = 0;
		
		try
		{
			numberOfChannelComments = rwS.getNumberOfStreamchannelComments(searchUsersTextValue);
		}
		catch (FileNotFoundException | JAXBException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			streamchannel = rwS.showStreamchannel(rwS.getUserID(searchUsersTextValue));
		}
		catch (FileNotFoundException | JAXBException e1)
		{
			e1.printStackTrace();
		}
		
		try
		{
			comments = rwS.showStreamchannelComments(searchUsersTextValue);
		}
		catch (FileNotFoundException | JAXBException e1)
		{
			e1.printStackTrace();
		}
		
		List<ChannelComment> channelComments = streamchannel.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment();
		StreamChannel newStreamchannel = new StreamChannel();
		ChannelComments newChannelcomments = new ChannelComments();
		
		newStreamchannel.setChannelComments(newChannelcomments);
		newUser.setStreamChannel(newStreamchannel);
		comments.getUser().add(newUser);
		
		for(ChannelComment cc : channelComments)
		{
			comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().add(cc);
		}
		
		streamchannelOtherUsersCommentsComment1.setVisible(true);
		streamchannelOtherUsersCommentsComment2.setVisible(true);
		streamchannelOtherUsersCommentsComment3.setVisible(true);
		streamchannelOtherUsersCommentsCommentsNoComments.setVisible(false);
		
		if(numberOfChannelComments >= 3)
		{
			XMLGregorianCalendar date3 = comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-3).getCommentDate();
			SimpleDateFormat sdf3 = new SimpleDateFormat("MM/dd/yyyy hh:mm");
			GregorianCalendar gc3 = date3.toGregorianCalendar();
			String DateValue3 = sdf3.format(gc3.getTime());
			
			XMLGregorianCalendar date2 = comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-2).getCommentDate();
			SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy hh:mm");
			GregorianCalendar gc2 = date2.toGregorianCalendar();
			String DateValue2 = sdf2.format(gc2.getTime());
			
			XMLGregorianCalendar date1 = comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentDate();
			SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy hh:mm");
			GregorianCalendar gc1 = date1.toGregorianCalendar();
			String DateValue1 = sdf1.format(gc1.getTime());
			
			streamchannelOtherUsersCommentsComment1.setVisible(true);
			streamchannelOtherUsersCommentsComment2.setVisible(true);
			streamchannelOtherUsersCommentsComment3.setVisible(true);
			
			streamchannelOtherUsersCommentsComment1DateValue.setText(DateValue1);
			streamchannelOtherUsersCommentsComment1HeadlineValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentData().getCommentHeadline());
			streamchannelOtherUsersCommentsComment1CommentValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentData().getCommentText());
			
			streamchannelOtherUsersCommentsComment2DateValue.setText(DateValue2);
			streamchannelOtherUsersCommentsComment2HeadlineValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-2).getCommentData().getCommentHeadline());
			streamchannelOtherUsersCommentsComment2CommentValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-2).getCommentData().getCommentText());
			
			streamchannelOtherUsersCommentsComment3DateValue.setText(DateValue3);
			streamchannelOtherUsersCommentsComment3HeadlineValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-3).getCommentData().getCommentHeadline());
			streamchannelOtherUsersCommentsComment3CommentValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-3).getCommentData().getCommentText());
		}
		else
		{
			if(numberOfChannelComments == 2)
			{
				XMLGregorianCalendar date2 = comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-2).getCommentDate();
				SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy hh:mm");
				GregorianCalendar gc2 = date2.toGregorianCalendar();
				String DateValue2 = sdf2.format(gc2.getTime());
				
				XMLGregorianCalendar date1 = comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentDate();
				SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy hh:mm");
				GregorianCalendar gc1 = date1.toGregorianCalendar();
				String DateValue1 = sdf1.format(gc1.getTime());
				
				streamchannelOtherUsersCommentsComment1.setVisible(true);
				streamchannelOtherUsersCommentsComment2.setVisible(true);
				streamchannelOtherUsersCommentsComment3.setVisible(false);
				
				streamchannelOtherUsersCommentsComment1DateValue.setText(DateValue1);
				streamchannelOtherUsersCommentsComment1HeadlineValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentData().getCommentHeadline());
				streamchannelOtherUsersCommentsComment1CommentValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentData().getCommentText());
				
				streamchannelOtherUsersCommentsComment2DateValue.setText(DateValue2);
				streamchannelOtherUsersCommentsComment2HeadlineValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-2).getCommentData().getCommentHeadline());
				streamchannelOtherUsersCommentsComment2CommentValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-2).getCommentData().getCommentText());
				}
			else
			{
				if(numberOfChannelComments == 1)
				{
					XMLGregorianCalendar date1 = comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentDate();
					SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy hh:mm");
					GregorianCalendar gc1 = date1.toGregorianCalendar();
					String DateValue1 = sdf1.format(gc1.getTime());
					
					streamchannelOtherUsersCommentsComment1.setVisible(true);
					streamchannelOtherUsersCommentsComment2.setVisible(false);
					streamchannelOtherUsersCommentsComment3.setVisible(false);
					
					streamchannelOtherUsersCommentsComment1DateValue.setText(DateValue1);
					streamchannelOtherUsersCommentsComment1HeadlineValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentData().getCommentHeadline());
					streamchannelOtherUsersCommentsComment1CommentValue.setText(comments.getUser().get(0).getStreamChannel().getChannelComments().getChannelComment().get(numberOfChannelComments-1).getCommentData().getCommentText());
				}
				else
				{
					if(numberOfChannelComments == 0)
					{
						streamchannelOtherUsersCommentsComment1.setVisible(false);
						streamchannelOtherUsersCommentsComment2.setVisible(false);
						streamchannelOtherUsersCommentsComment3.setVisible(false);
						streamchannelOtherUsersCommentsCommentsNoComments.setVisible(true);
						streamchannelOtherUsersCommentsCommentsNoComments.setText("Ihr Streamchannel wurde noch nicht kommentiert!");
					}
				}
			}
		}
		
		streamchannelOtherUsersText.setText("Streamchannel von " + searchUsersTextValue);
		streamchannelOtherUsersTopicText.setText("Thema des Streams: " + streamchannel.getUser().get(0).getStreamChannel().getChannelTopic());
		streamchannelOtherUsersHeadlineText.setText(streamchannel.getUser().get(0).getStreamChannel().getChannelDescription().getChannelHeadline());
		streamchannelOtherUsersText_Info.setText("Informationen zum Stream");
		streamchannelOtherUsersInformationText.setText(streamchannel.getUser().get(0).getStreamChannel().getChannelDescription().getChannelInformation());
		streamchannelOtherUsers.setVisible(true);
		startScreen.setVisible(false);
	}
}