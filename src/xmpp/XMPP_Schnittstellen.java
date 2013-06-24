package xmpp;

import java.util.List;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.AccessModel;
import org.jivesoftware.smackx.pubsub.ConfigureForm;
import org.jivesoftware.smackx.pubsub.FormType;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.PublishModel;
import org.jivesoftware.smackx.pubsub.Subscription;

public class XMPP_Schnittstellen
{
	private PubSubManager mgr;
	private XMPPConnection con;
	private String username;
	private String pw;
	
	public XMPP_Schnittstellen(String username, String pw)
	{
		this.username = username;
		this.pw = pw;
	}
	
	public void login (String res) throws XMPPException
	{
		ConnectionConfiguration config = new ConnectionConfiguration("localhost" , 5222, res);
		con = new XMPPConnection(config);
		con.connect();
		con.login(username, pw);
		mgr = new PubSubManager(con);
	}
	
	public void disconnect()
	{
		con.disconnect();
	}
	
	public void erzeugeNode(String name) throws XMPPException
	{
		LeafNode leaf = mgr.createNode(name);
		ConfigureForm form = new ConfigureForm(FormType.submit);
		form.setAccessModel(AccessModel.open);
	    form.setDeliverPayloads(false);
	    form.setNotifyRetract(true);
	    form.setPersistentItems(true);
	    form.setPublishModel(PublishModel.open);
	    leaf.sendConfigurationForm(form);
	}
	
	public void loescheNode(String nameNode) throws XMPPException
	{
		mgr.deleteNode(nameNode);
	}
	
	public void publishNode(String nameNode, String kommentar) throws XMPPException
	{
		LeafNode node = mgr.getNode(nameNode);
		node.publish(new Item("Channel" + kommentar));
	}
	
	public void subscribeNode(String node) throws XMPPException
	{
		LeafNode beitrag = null;
		try
		{
			beitrag = mgr.getNode(node);
		}
		catch (XMPPException e)
		{
			System.out.println("Node konnte nicht subscribed werden");
		}
		beitrag.subscribe(username +"@localhost");
		System.out.println("User " + username + " aboniert " + node);
	}
	
	public void unsubscribeNode(String node) throws XMPPException
	{
		LeafNode beitrag = null;
		beitrag = mgr.getNode(node);
		beitrag.unsubscribe(username +"@localhost");
		System.out.println("User " + username + " unsbuscribed " + node);
	}
	
	public List<Subscription> getSubscriber(String title) throws XMPPException
	{
		PubSubManager mgr = new PubSubManager(con);
		LeafNode node = mgr.getNode(title);
		node.addItemEventListener(new ItemEventCoordinator());
		return node.getSubscriptions();
	}
	
	public void nodeAusgeben(String name) throws Exception
	{
		LeafNode node = mgr.getNode(name);
		System.out.println(node.getId());
	}
	public List<Item> getItems(String name) throws Exception
	{
		LeafNode node = mgr.getNode(name);
		return node.getItems();
	}
	
	public void listenerAnmelden(String name)throws Exception
	{
		mgr.getNode(name).addItemEventListener(new ItemEventCoordinator());
	}
}