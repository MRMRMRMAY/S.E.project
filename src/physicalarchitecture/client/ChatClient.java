package physicalarchitecture.client;
//This file contains material supporting section 3.7 of the textbook:

//"Object Oriented Software Engineering" and is issued under the open-source
//license found at www.lloseng.com 

import java.io.IOException;
import java.util.ArrayList;

import physicalarchitecture.common.ChatIF;
import physicalarchitecture.common.Packet;
import physicalarchitecture.common.Packet.PacketType;
import server.problemdomain.matching.Request;
import server.problemdomain.member.Passenger;
import server.problemdomain.member.Enum.TaxiState;
import server.problemdomain.systemdata.Map;
import server.problemdomain.systemdata.Spot;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient {
	// Instance variables **********************************************

	PacketType waitingType; // 응답을 기다리는 Type
	ArrayList<Packet> acceptedPacketList; // 서버로부터 받은 packet리스드
	// message처리시 여러개가 동시에 올 경우를 고려하여
	// ArrayList로 작성
	/**
	 * The interface type variable. It allows the implementation of the display
	 * method in the client.
	 */
	ChatIF clientUI;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the chat client.
	 *
	 * @param host
	 *            The server to connect to.
	 * @param port
	 *            The port number to connect on.
	 * @param clientUI
	 *            The interface type variable.
	 */

	public ChatClient(String host, int port, ChatIF clientUI) throws IOException {
		super(host, port); // Call the superclass constructor
		this.clientUI = clientUI;
		acceptedPacketList = new ArrayList<Packet>();
		openConnection();
	}

	// Instance methods ************************************************

	/**
	 * This method handles all data that comes in from the server.
	 *
	 * @param msg
	 *            The message from the server.
	 */
	// Instance methods ************************************************

	/**
	 * This method handles all data that comes in from the server.
	 * 
	 * @param msg
	 *            The message from the server.
	 */
	public void handleMessageFromServer(Object msg) {
		Packet packet = (Packet) msg;
		System.out.println(packet);
		synchronized (acceptedPacketList) {
			if (packet.getpacketType() == waitingType) {
				acceptedPacketList.add(packet);
			}
			// 기다리지 않는 잘못된 패킷이 전송될 경우 버림
			else {									
				System.out.println("Unexpected Packet");
			}
		}

	}

	/**
	 * This method handles all data coming from the UI
	 *
	 * @param message
	 *            The message from the UI.
	 */
	public void handleMessageFromClientUI(Packet packet) {
		try {
			// System.out.println(packet.getMessageType());

			sendToServer(packet);
		} catch (IOException e) {
//			ui.displayMessage(1, ("Could not send message to server.  Terminating client."));
			quit();
		}
	}

	/**
	 * This method terminates the client.
	 */
	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}
	
	// 패킷 생성하여 반환
	public Packet createPacket(Packet.PacketType type, Object... objs) {
		Packet packet = new Packet();

		packet.setPacketType(type);
		for (Object obj : objs) {
			// System.out.println(obj);
			// if (obj == null)
			// break;
			packet.addParammeter(obj);
		}

		return packet;
	}
	// Instance methods ************************************************

	/**
	 * This method handles all data that comes in from the server.
	 * 
	 * @param msg
	 *            The message from the server.
	 */
	// 패킷을 서버로 전달
	public void sendPacket(Packet.PacketType type, Object... objs) {


		// 기다리는 서버 응답의 type을 지정
		switch (type) {
		case P_REQUEST_MATCHING:
			waitingType = PacketType.P_REPLY_MATCHING;
			break;

		case REQUEST_MAP:
			waitingType = PacketType.REPLY_MAP;
			break;

		case LOGIN:
			waitingType = PacketType.REPLY_LOGIN;
			break;
		default:
			waitingType = PacketType.NONE;
			break;
	
		}
		handleMessageFromClientUI(createPacket(type, objs));
	}
	
	// 서버의 응답을 기다림
	public ArrayList<Object> getServerResponse() {
		ArrayList<Object> tmp;

		while (isConnected()) {
			synchronized (acceptedPacketList) {

				for (Packet packet : acceptedPacketList) {
					if (packet.getpacketType() == waitingType) {
						System.out.println("22");
						tmp = packet.getParms();
						acceptedPacketList.remove(packet);
						waitingType = PacketType.NONE; // 패킷을 처리하여 기다리는 것을 없게 함
						return tmp;
					}
				}
			}
		}
		return null;
	}	

	public boolean sendLogin(String id, String pw)
	{
		sendPacket(PacketType.LOGIN, id, pw);
		ArrayList<Object> res = getServerResponse();
		if ( (boolean)(res.get(0)) )
			return true;
		else
			return false;
	}
	
	public void sendLogout()
	{
		sendPacket(PacketType.LOGOUT );
	}
	
	public Map sendRequestMap()
	{
		sendPacket(PacketType.REQUEST_MAP);
		ArrayList<Object> res = getServerResponse();
		Map map = (Map)(res.get(0));
		
		return map;
	}
	
	public void sendPassengerSignIn(Passenger passenger )
	{
		sendPacket(PacketType.P_SIGNIN, passenger);
	}
	
	public void sendRequestMatching(Request request)
	{
		sendPacket(PacketType.P_REQUEST_MATCHING, request);
	}
	
	public void sendTaxiUpdateState(TaxiState state)
	{
		sendPacket(PacketType.T_UPDATE_TAXI_STATE, state);
	}
	
	public void sendTaxiUpdateLocation(Spot spot)
	{
		sendPacket(PacketType.T_UPDATE_TAXI_STATE, spot);
	}
}
// End of ChatClient class
