/*
 * CommonHandler.java
 * 
 * It handles common function packet
*/

package physicalarchitecture.server;

import java.io.IOException;
import java.util.HashMap;

import physicalarchitecture.Server;
import physicalarchitecture.common.Packet;
import physicalarchitecture.common.Packet.PacketType;
import server.problemdomain.member.Enum.MemberType;
import server.problemdomain.member.Passenger;
import server.problemdomain.member.Taxi;
import server.problemdomain.systemdata.Spot;

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
	 * @param id: id pw: pw, spot(opt if taxi)
	 */
	public void processLogin(Packet packet, ConnectionToClient client) {
		boolean isSuccess = false;

		String id = (String) packet.getParms().get(0);
		String pw = (String) packet.getParms().get(1);
		System.out.println("id, pw  "  + id + "  "+ pw);
		System.out.println(server.getPassengerList().size());
		for (Passenger passenger : server.getPassengerList()) {
			System.out.println(passenger.getId() + " " + passenger.getPw());
			
//			if (passenger.getId() == id.equals(anObject) && passenger.getPw() == pw) {
			if (id.equals(passenger.getId()) && pw.equals(passenger.getPw()) ) {
				isSuccess = true;
				client.setInfo("type", MemberType.PASSENGER); // set member type
				client.setInfo("id", id); // set id
				break;
			}
			System.out.println("111");
		}
		System.out.println("222");
		if (!isSuccess) {
			for (Taxi taxi : server.getTaxi()) {
				if (taxi.getId().equals(id) && taxi.getPw().equals(pw)) {
					isSuccess = true;
					client.setInfo("type", MemberType.TAXI); // set member type
					client.setInfo("data", taxi); // set id
					break;
				}
			}
		}

		try {
			if (isSuccess)
			{
				System.out.println("suc");
				client.sendToClient(server.createPacket(PacketType.REPLY_LOGIN, true));
				System.out.println("suc");
			}
			else
			{System.out.println("fail");
				client.sendToClient(server.createPacket(PacketType.REPLY_LOGIN, false));
				System.out.println("fail");
			}
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
		client.setSavedInfo(new HashMap(10));
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
