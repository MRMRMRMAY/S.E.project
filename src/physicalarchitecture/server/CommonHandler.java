/*
 * CommonHandler.java
 * 
 * It handles common function packet
*/

package physicalarchitecture.server;

import java.io.IOException;

import physicalarchitecture.Server;
import physicalarchitecture.common.Packet;
import physicalarchitecture.common.Packet.PacketType;
import server.problemdomain.member.Passenger;
import server.problemdomain.member.Taxi;

public class CommonHandler {
	private static CommonHandler commonHandler;
	private Server server;

	private CommonHandler(Server server) {
		this.server = server;
	}

	public static CommonHandler getInstance(Server server) {
		if (commonHandler == null)
			commonHandler = new CommonHandler(server);
		return commonHandler;
	}

	public static CommonHandler getInstance() {
		if (commonHandler == null)
			System.err.println("ERROR Initiate handler first!!");
		return commonHandler;
	}

	public void processPacket(Packet packet, ConnectionToClient client) {
		/*
		 * LOGIN, LOGOUT, REQUEST_MAP, REPLY_MAP, NOTICE, //(s->p) NONE,
		 */
		switch (packet.getpacketType()) {
		case LOGIN:
			processLogin(packet, client);
			break;
		case LOGOUT:
			processLogout(packet, client);
			break;
		case REQUEST_MAP:
			processRequestMap(packet, client);
			break;
/*		case NOTICE:
			processNotice(packet, client);
			break;*/
		case NONE:
			processNone(packet, client);
			break;
		}
	}

	/*
	 * login
	 * 
	 * @param id: id pw: pw
	 */
	public void processLogin(Packet packet, ConnectionToClient client) {
		boolean isSuccess = false;

		String id = (String) packet.getParms().get(0);
		String pw = (String) packet.getParms().get(1);

		for (Passenger passenger : server.getPassengerList()) {
			if (passenger.getId().equals(id) && passenger.getPw().equals(pw)) {
				isSuccess = true;
				break;
			}
		}
		if (!isSuccess) {
			for (Taxi taxi : server.getTaxi()) {
				if (taxi.getId().equals(id) && taxi.getPw().equals(pw)) {
					isSuccess = false;
					break;
				}
			}
		}

		try {
			if (isSuccess)
				client.sendToClient(server.createPacket(PacketType.REPLY_LOGIN, true));
			else
				client.sendToClient(server.createPacket(PacketType.REPLY_LOGIN, false));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// check already logined id

		// check validity of id/pw

		// error pckaume name
	}

	public void processLogout(Packet packet, ConnectionToClient client) {
		System.out.println("Logout");
	}

	public void processRequestMap(Packet packet, ConnectionToClient client) {
		try {
			client.sendToClient(server.createPacket(PacketType.REPLY_MAP, server.getMap()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/*	public void processNotice(Packet packet, ConnectionToClient client) {

	}*/

	public void processNone(Packet packet, ConnectionToClient client) {

	}
}
