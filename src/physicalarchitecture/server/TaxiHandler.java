/*
 * TaxiHandler.java
 * 
 * It handles taxi related communication
*/

package physicalarchitecture.server;

import physicalarchitecture.Server;
import physicalarchitecture.common.Packet;
import server.problemdomain.member.Enum.TaxiState;
import server.problemdomain.systemdata.Spot;

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
			processUpdateState(packet, client);
			break;
		case T_UPDATE_TAXI_LOCATION:
			processUpdateLocation(packet, client);
			break;
		}
	}
	
	// update taxi state
	public void processUpdateState(Packet packet, ConnectionToClient client)
	{
		TaxiState state = (TaxiState)packet.getParms().get(0);
		
		client.setInfo("state", state);
	}
	
	
	// update taxi location
	public void processUpdateLocation(Packet packet, ConnectionToClient client)
	{
		Spot currentLocation = (Spot)packet.getParms().get(0);
		
		client.setInfo("location", currentLocation);
	}
}
