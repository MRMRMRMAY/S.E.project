/*
 * MatchingSystem.java
 * control matching and manage request
*/

package server.problemdomain.matching;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.PriorityQueue;

import javax.management.Query;
import javax.naming.spi.DirStateFactory.Result;

import physicalarchitecture.Server;
import physicalarchitecture.common.Packet.PacketType;
import physicalarchitecture.server.ConnectionToClient;
import server.problemdomain.matching.Request.RequestState;
import server.problemdomain.member.Enum.MemberType;
import server.problemdomain.member.Enum.TaxiState;
import server.problemdomain.member.Taxi;
import server.problemdomain.systemdata.Map;
import server.problemdomain.systemdata.Spot;

public class MatchingSystem implements Observer {
	// private ArrayList<Request> requestList; // queue for request
	private HashMap<Spot, ArrayList<MatchingQueueEntry>> matchingQueue; // queue
																		// for
																		// matching

	// test attr
	// private Map map;

	private Server server;

	/*
	 * public MatchingSystem() { // requestList = new ArrayList<Request>();
	 * matchingQueue = new HashMap<Spot, ArrayList<MatchingQueueEntry>>(); }
	 */

	public MatchingSystem(Server server) {
		// requestList = new ArrayList<Request>();
		this.server = server;
		matchingQueue = new HashMap<Spot, ArrayList<MatchingQueueEntry>>();
	}

	public synchronized void pushRequest(Request request) {
		// requestList.add(request);
		request.addObserver(this); // add observer

		if (matchingQueue.containsKey(request.getFrom())) {
			ArrayList<MatchingQueueEntry> list = matchingQueue.get(request.getFrom());

			for (MatchingQueueEntry entry : list) {
				// input already existed queue
				if (entry.isRouteCoincide(request) && entry.isAvailable()) {
					System.out.println("request pushed");
					entry.pushRequest(request);
					break;
				}
			}

			// if not included anywhere make new entry;
			if (request.getState() == RequestState.raw) {
				System.out.println("new queue entry and request pushed");
				MatchingQueueEntry entry = new MatchingQueueEntry();
				entry.addObserver(this); // attach observer
				entry.pushRequest(request); // add request
				list.add(entry);
			}
		}
		// initial case
		else {
			System.out.println("new queue entry and request pushed");
			ArrayList<MatchingQueueEntry> list = new ArrayList<MatchingQueueEntry>();
			MatchingQueueEntry entry = new MatchingQueueEntry();
			entry.addObserver(this); // attach observer
			entry.pushRequest(request); // add request
			list.add(entry);

			matchingQueue.put(request.getFrom(), list); // add to map
		}
	}

	/*
	 * public synchronized void removeRequest(Request request) { //
	 * requestList.remove(request); // request가 expired되면 mathcing을 시켜야할듯 매칭을
	 * 시키고나서 리퀘스트 목록에서 제거 // 왜냐하면 매칭이 안되면 혼자타기 때문에 }
	 */
	@Override
	// get signal from queueentry or request
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		MatchingQueueEntry entry = null;
		MatchingResult result = null;
		ConnectionToClient taxiClient;

		// 일단은 request 제거하는 거만
		switch ((signalType) arg) {
		case MATCHING_COMPLETED: // waiting time was expired or full party
			// step1. stop request ttl timer
			// entry timer
			System.out.println("signal input from entry");
			entry = (MatchingQueueEntry) o;
			if (entry == null)
				System.out.println("entry null");
			else
				System.out.println("entry not null");
			matchingQueue.get(entry.getFrom()).remove(entry); // remove from
																// queue
			stopRequestTimer(entry); // stop request timer
			System.out.println("party gathered");
			// 이다음에 result set을 생성
			break;

		// 아마 2개가 같을 듯 함
		case REQUEST_EXPIRED: // request TTL was expired
								// only invoked by request maybe.
			// requestList.remove(arg);
			System.out.println("signal input from entry");
			entry = ((Request) o).getMatchingQueue(); // get entry queue
			matchingQueue.get(entry.getFrom()).remove(entry);
			stopRequestTimer(entry);
			System.out.println("party gathered");
			break;
		}

		taxiClient = getAvailableTaxi();
		result = makeResultData(entry, taxiClient);
		returnResult(entry, taxiClient, result);

	}

	// stop request's timer
	public void stopRequestTimer(MatchingQueueEntry entry) {
		for (Request request : entry.getPassengers()) {
			request.stop();
		}

	}

	public void returnResult(MatchingQueueEntry entry, ConnectionToClient taxiClient, MatchingResult result) {

		try {
			for (Request request : entry.getRequests())
				request.getClient().sendToClient(server.createPacket(PacketType.P_REPLY_MATCHING, result));
			taxiClient.sendToClient(server.createPacket(PacketType.T_NEW_MATCHING, result));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public enum signalType {
		REQUEST_EXPIRED, MATCHING_COMPLETED;
	}

	// make matching class

	// send matching result

	//

	// class for route info
	public class RouteInfo {
		public int dist;
		public Spot route[];

		public RouteInfo() {
			// TODO Auto-generated constructor stub
		}

		public RouteInfo(int dist, Spot route[]) {
			this.dist = dist;
			this.route = route;
		}
	}

	// class for process route
	class Node implements Comparable<Node> {

		public int index;
		public int dist;

		Node() {
		}

		Node(int index, int dist) {
			this.index = index;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return dist - o.dist;
		}
	}

	// functions for matching result
	// calculate drivingRoute
	public RouteInfo calculateDrivingRoute(Spot start, Spot end) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>(); // priority queue
		RouteInfo result = null; // return obj

		int startIndex = start.getSpotIndex();
		int endIndex = end.getSpotIndex();
		int graph[][] = server.getMap().mapTo2DArray();
		int size = server.getMap().getSpotList().size();

		int dist;
		Spot route[];

		// initialize
		int d[] = new int[size];
		int p[] = new int[size];
		boolean flag[] = new boolean[size];
		for (int i = 0; i < d.length; i++) {
			d[i] = Integer.MAX_VALUE;
			p[i] = -1;
		}

		d[startIndex] = 0;

		queue.add(new Node(startIndex, d[startIndex]));

		int u = -1;
		while (!queue.isEmpty() && u != endIndex) {
			u = queue.poll().index;
			System.out.println("pop index: " + u);
			if (!flag[u]) {
				for (int v = 0; v < size; v++) {
					if (graph[u][v] >= 0) // have edge
					{
						if (!flag[v] && d[v] > d[u] + graph[u][v]) {
							p[v] = u;
							d[v] = d[u] + graph[u][v];
							queue.add(new Node(v, d[v]));
						}
						flag[v] = true;
					}
				}
			}
		}

		dist = d[endIndex];
		ArrayList<Integer> list = new ArrayList<Integer>();
		int index = endIndex;
		while (index != startIndex) {
			list.add(index);
			index = p[index];
		}
		list.add(index);

		route = new Spot[list.size()];
		for (int i = list.size() - 1; i >= 0; i--) {
			route[list.size() - 1 - i] = server.getMap().getSpotList().get(list.get(i));
			// System.out.println(i);
		}

		result = new RouteInfo(dist, route);

		return result;
	}

	public MatchingResult makeResultData(MatchingQueueEntry entry, ConnectionToClient taxiClient) {
		MatchingResult result = null;
		if (entry == null) {
			System.err.println("Return matching result was failed!");
		} else {
			result = new MatchingResult();
			// set passenger list
			for (Request request : entry.getRequests())
				result.addPassenger(request.getPassenger());

			// set from & to
			result.setFrom(entry.getFrom());
			result.setTo(entry.getTo());

			// set num of passenger
			result.setNumOfPassenger(entry.getRequests().size());
			System.out.println("Complete setting info from entry");

			RouteInfo routeInfo = calculateDrivingRoute(entry.getFrom(), entry.getTo());
			result.setDrivingRoute(routeInfo.route);
			result.setDistance(routeInfo.dist);
			result.setFare(result.getDistance() * server.getFareRate());
			System.out.println("Complete setting info from route Info");

			result.setTaxi((Taxi) (taxiClient.getInfo("data")));
			System.out.println("Taxi was selected");

			// RouteInfo routeInfo = calculateDrivingRoute(start, end)
		}

		return result;
	}

	public ConnectionToClient getAvailableTaxi() {
		Thread[] clientThreadList = server.getClientConnections();
		ConnectionToClient client;
		for (int i = 0; i < clientThreadList.length; i++) {
			client = (ConnectionToClient) clientThreadList[i];
			if (client.getInfo("type") == MemberType.TAXI) {
				if (client.getInfo("state") == TaxiState.FREE)
					client.setInfo("state", TaxiState.DRIVING); // select taxi
				return client;
			}
		}

		return null;
	}
}
