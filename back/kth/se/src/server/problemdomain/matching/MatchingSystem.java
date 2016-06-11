/*
 * MatchingSystem.java
 * control matching and manage request
*/

package server.problemdomain.matching;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import server.problemdomain.matching.Request.RequestState;
import server.problemdomain.systemdata.Spot;

public class MatchingSystem implements Observer {
//	private ArrayList<Request> requestList; // queue for request
	private HashMap<Spot, ArrayList<MatchingQueueEntry>> matchingQueue; // queue for matching 

	public MatchingSystem() {
//		requestList = new ArrayList<Request>();
		matchingQueue = new HashMap<Spot, ArrayList<MatchingQueueEntry>>();
	}

	public synchronized void pushRequest(Request request) {
//		requestList.add(request);
		request.addObserver(this); // add observer
		
		if ( matchingQueue.containsKey(request.getFrom()) )
		{
			ArrayList<MatchingQueueEntry> list = matchingQueue.get(request.getFrom());
			
			for ( MatchingQueueEntry entry : list )
			{
				// input already existed queue
				if ( entry.isRouteCoincide(request) && entry.isAvailable() )
				{
					entry.pushRequest(request);
					break;
				}
			}
			
			// if not included anywhere make new entry;
			if ( request.getState() == RequestState.raw )
			{
				MatchingQueueEntry entry = new MatchingQueueEntry();
				entry.pushRequest(request); // add request
				list.add(entry);					
			}
		}
		// initial case
		else
		{
			ArrayList<MatchingQueueEntry> list = new ArrayList<MatchingQueueEntry>();
			MatchingQueueEntry entry = new MatchingQueueEntry();
			entry.pushRequest(request); // add request
			list.add(entry);
			
			matchingQueue.put(request.getFrom(), list); // add to map	
		}
	}

/*	public synchronized void removeRequest(Request request) {
//		requestList.remove(request);
		// request��  expired�Ǹ� mathcin�� ���Ѿ��ҵ� ��Ī�� ��Ű���� ������Ʈ ��Ͽ��� ����
		// �ֳ��ϸ� ��Ī�� �ȵǸ� ȥ��Ÿ�� ������
	}
*/
	@Override
	// get signal from queueentry or request
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		MatchingQueueEntry entry;
		
		// �ϴ��� request �����ϴ� �Ÿ�
		switch ((signalType) arg) {
		case MATCHING_COMPLETED: // waiting time was expired or full party
			// step1. stop request ttl timer
			//				entry timer
			entry = (MatchingQueueEntry)o;
			matchingQueue.get(entry.getFrom()).remove(entry); // remove from queue
			stopRequestTimer(entry); // stop request timer
			
			
			
			// �̴����� result set�� ����
			break;
			
			// �Ƹ� 2���� ���� �� ��
		case REQUEST_EXPIRED: // request TTL was expired
							// only invoked by request maybe.
//			requestList.remove(arg);
			entry = ((Request)o).getMatchingQueue(); // get entry queue
			matchingQueue.get(entry.getFrom()).remove(entry);
			stopRequestTimer(entry);
			
			
			break;
		}

	}
	
	// stop request's timer
	public void stopRequestTimer(MatchingQueueEntry entry ){
		for ( Request request : entry.getPassengers() )
		{
			request.stop();
		}
		
	}
	
	public void returnResult(MatchingQueueEntry entry )
	{
		MatchingResult result = new MatchingResult();
		
		
	}

	public enum signalType {
		REQUEST_EXPIRED, MATCHING_COMPLETED;
	}

	// make matching class

	// send matching result

	//

}
