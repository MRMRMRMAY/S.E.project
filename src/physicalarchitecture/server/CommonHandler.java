/*
 * CommonHandler.java
 * 
 * It handles common function packet
*/

package physicalarchitecture.server;

import physicalarchitecture.Server;
import physicalarchitecture.common.Packet;

public class CommonHandler {
	private static CommonHandler commonHandler;
	private Server server;
	
	private CommonHandler(Server server)
	{
		this.server = server;
	}
	
	public static CommonHandler getInstance(Server server)
	{
		if ( commonHandler == null )
			commonHandler = new CommonHandler(server);
		return commonHandler;
	}
	
	public static CommonHandler getInstance()
	{
		if ( commonHandler == null )
			System.err.println("ERROR Initiate handler first!!");
		return commonHandler;
	}
	
	public void processPacket(Packet packet, ConnectionToClient client)
	{
/*		LOGIN, LOGOUT,
		REQUEST_MAP, REPLY_MAP,
		NOTICE, //(s->p)
		NONE,
		*/
		switch ( packet.getpacketType() )
		{
		case LOGIN:
			processLogin(packet, client);
			break;
		case LOGOUT:
			processLogout(packet, client);
			break;
		case REQUEST_MAP:
			processRequestMap(packet, client);
			break;
		case NOTICE:
			processNotice(packet, client);
			break;
		case NONE:
			processNone(packet, client);
			break;
		}
	}
	
	
	/*
	 * login
	 * 
	 * @param
	 * 	id: id
	 * 	pw: pw
	*/
	public void processLogin(Packet packet, ConnectionToClient client)
	{
		String id = (String)packet.getParms().get(0);
		String pw = (String)packet.getParms().get(0);
		
		// check already logined id
		
		// check validity of id/pw
		
		// error pckaume name
	}	
	
	public void processLogout(Packet packet, ConnectionToClient client)
	{
		
	}
	
	public void processRequestMap(Packet packet, ConnectionToClient client)
	{
		
	}
	
	public void processNotice(Packet packet, ConnectionToClient client)
	{
		
	}
	
	public void processNone(Packet packet, ConnectionToClient client)
	{
		
	}
}
