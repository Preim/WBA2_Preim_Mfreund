package restful.webservice;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyServerFactory;

public class GrizzleyServerConfig
{
	public static String hostname = "http://localhost";
	public static int port = 8080;
	public static String url = hostname + ":" + port;

	public static void main(String[] args) throws Exception
	{
		SelectorThread srv = GrizzlyServerFactory.create(url);
		System.out.println("URL: " + url);
		Thread.sleep(1000*60*360);
		srv.stopEndpoint();
	}
}