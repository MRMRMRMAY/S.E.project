package physicalarchitecture;

//This file contains material supporting section 3.7 of the textbook:
//"Object Oriented Software Engineering" and is issued under the open-source
//license found at www.lloseng.com 

import java.io.*;
import java.util.ArrayList;

import datamanagement.MapDataManager;
import datamanagement.PassengerDataManager;
import datamanagement.TaxiDataManager;
import physicalarchitecture.common.Packet;
import physicalarchitecture.server.*;
import server.problemdomain.matching.MatchingSystem;
import server.problemdomain.member.Passenger;
import server.problemdomain.member.Taxi;
import server.problemdomain.systemdata.Map;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class Server extends AbstractServer {
	// Class variables *************************************************

	/**
	 * The default port to listen on.
	 */
	final public static int DEFAULT_PORT = 5555;
	
	private Map map; // map data
	
	// data manager
	private ArrayList<Passenger> passengerList;
	private ArrayList<Taxi> taxiList;

	// packet handler
	private PassengerHandler passengerHandler;
	private TaxiHandler taxiHandler;
	
	// matching system
	private MatchingSystem matchingSystem;
	
	// fare rate
	private int fareRate;
	private final int defaultFareRate = 300;
	
	
	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port
	 *            The port number to connect on.
	 */
	public Server(int port) {
		super(port);
		
		// load data
		map = MapDataManager.getInstance().loadData();
		passengerList = PassengerDataManager.getInstance().loadData();
		taxiList = TaxiDataManager.getInstance().loadData();
		System.out.println("load Data Success");
		
		passengerHandler = PassengerHandler.getInstance(this);
		taxiHandler = TaxiHandler.getInstance(this);		
		
		matchingSystem = new MatchingSystem(this);
		
		fareRate = defaultFareRate; // default value
	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg
	 *            The message received from the client.
	 * @param client
	 *            The connection from which the message originated.
	 */
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {
		System.out.println("Message received: " + msg + " from " + client);
		this.sendToAllClients(msg);
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * stops listening for connections.
	 */
	protected void serverStopped() {
		// save data
		MapDataManager.getInstance().saveData(map);
		PassengerDataManager.getInstance().saveData(passengerList);
		TaxiDataManager.getInstance().saveData(taxiList);
		
		System.out.println("Server has stopped listening for connections.");
		System.out.println("System data was saved");
	}

	// Class methods ***************************************************

	/**
	 * This method is responsible for the creation of the server instance (there
	 * is no UI in this phase).
	 *
	 * @param args[0]
	 *            The port number to listen on. Defaults to 5555 if no argument
	 *            is entered.
	 */
	public static void main(String[] args) {
		int port = 0; // Port to listen on

		try {
			port = Integer.parseInt(args[0]); // Get port from command line
		} catch (Throwable t) {
			port = DEFAULT_PORT; // Set port to 5555
		}

		Server sv = new Server(port);

		try {
			sv.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
	}

	public Map getMap() {
		return map;
	}

	public ArrayList<Passenger> getPassengerList() {
		return passengerList;
	}

	public ArrayList<Taxi> getTaxi() {
		return taxiList;
	}
	
	// 패킷 생성하여 반환
	public Packet createPacket(Packet.PacketType type, Object... objs) {
		Packet packet = new Packet();

		packet.setPacketType(type);
		for (Object obj : objs) {
			// if (obj == null)
			// break;
			packet.addParammeter(obj);
		}

		return packet;
	}

	public MatchingSystem getMatchingSystem() {
		return matchingSystem;
	}

	public int getFareRate() {
		return fareRate;
	}

	public void setFareRate(int fareRate) {
		this.fareRate = fareRate;
	}	
}
// End of EchoServer class
