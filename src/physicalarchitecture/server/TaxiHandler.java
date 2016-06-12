/*
 * TaxiHandler.java
 * 
 * It handles taxi related communication
*/

package physicalarchitecture.server;

import physicalarchitecture.Server;
import physicalarchitecture.common.Packet;

public class TaxiHandler {
	private static TaxiHandler taxiHandler;
	private Server server;
	
	private TaxiHandler(Server server)
	{
		this.server = server;
	}
	
	public static TaxiHandler getInstance(Server server)
	{
		if ( taxiHandler == null )
			taxiHandler = new TaxiHandler(server);
		return taxiHandler;
	}
	
	public static TaxiHandler getInstance()
	{
		if ( taxiHandler == null )
			System.err.println("ERROR Initiate handler first!!");
		return taxiHandler;
	}
	
	public void processPacket(Packet packet, ConnectionToClient client)
	{
		switch ( packet.getpacketType() )
		{
		case T_UPDATE_TAXI_STATE:
			break;
		}
	}
	
	public void processUpdateState(Packet packet, ConnectionToClient client)
	{
		
	}
}
