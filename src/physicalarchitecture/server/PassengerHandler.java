/*
 * PassengerHandler.java
 * 
 * It handles passenger related communication
*/
package physicalarchitecture.server;

import physicalarchitecture.Server;
import physicalarchitecture.common.Packet;

public class PassengerHandler {
	private static PassengerHandler passengerHandler;
	private Server server;
	
	private PassengerHandler(Server server)
	{
		this.server = server;
	}
	
	public static PassengerHandler getInstance(Server server)
	{
		if ( passengerHandler == null )
			passengerHandler = new PassengerHandler(server);
		return passengerHandler;
	}
	
	public static PassengerHandler getInstance()
	{
		if ( passengerHandler == null )
			System.err.println("ERROR Initiate handler first!!");
		return passengerHandler;
	}
	
	public void processPacket(Packet packet, ConnectionToClient client)
	{
		switch ( packet.getpacketType() )
		{
		case P_SIGNIN:
			break;
		case P_REQUEST_MATCHING:
			break;
		}
	}
	
	public void processSignIn(Packet packet, ConnectionToClient client)
	{
		
	}
	
	public void processRequestMatching(Packet packet, ConnectionToClient client )
	{
		
	}
}
