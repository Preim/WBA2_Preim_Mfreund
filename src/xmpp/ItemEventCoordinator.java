package xmpp;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jivesoftware.smackx.pubsub.ItemPublishEvent;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;

public class ItemEventCoordinator implements ItemEventListener
{
    @Override
    public void handlePublishedItems(ItemPublishEvent items)
    {
    	String message = "Streamer streamt jetzt!";
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",JOptionPane.INFORMATION_MESSAGE);
	}
}