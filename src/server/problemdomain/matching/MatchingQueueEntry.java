/*
 * MatchingQueueEntry.java
 * it represents matching queue
 * it contains information about matching process
*/

package server.problemdomain.matching;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import server.problemdomain.matching.Request.RequestState;
import server.problemdomain.systemdata.Spot;

public class MatchingQueueEntry extends Observable {
	private final long defaultWaitingTime = 30;
	
	private boolean isRunning;
	private Spot from; // point of departure
	private Spot to; // destination
	private ArrayList<Request> requests;
	private long waitingTime; // time for waiting from second passenger sec unit
									// enter this queue
	// if it expires, this queue will be converted to Matching obj
	// give default value to 30 sec
	private int maxPassengerNum = 4; // maximun passenger number
	private Timer timer; // timer

	public MatchingQueueEntry() {
		// TODO Auto-generated constructor stub
		this.timer = new Timer(true);
		this.requests = new ArrayList<Request>(4);
		this.isRunning = false;
		this.waitingTime = defaultWaitingTime;
	}

	// @Override
	// public void run() {
	// // TODO Auto-generated method stub
	//
	// }

	// Add request
	public void pushRequest(Request request) {
		request.setState(RequestState.waiting); // change state
		requests.add(request);
		request.setMatchingQueue(this); // set matching queue
		request.start(); // start request timer

		
		// initial state, set info
		if ( requests.size() == 1 )
		{
			setFrom(request.getFrom());
			setTo(request.getTo());
		}
		
		
		if (requests.size() == 2) {
			start(); // start waiting timer
		}
		// full party
		if (requests.size() == 4)
		{
			stop(); // stop timer
			System.out.println("get full party");
			notifyObservers(MatchingSystem.signalType.MATCHING_COMPLETED);			
		}		


		
		updateWaitingTime();
		// update minimun waiting time
	}

	// check request was belonged to this entry
	public int checkIsRequestBelongedTo(Request request) {
		return requests.indexOf(request);
	}

	// check more passenger acceptable
	public boolean isAvailable() {
		return requests.size() <= maxPassengerNum ? true : false;
	}

	// check route is corresponed
	public boolean isRouteCoincide(Request request) {
		if (request.getTo() == getTo() && request.getFrom() == getFrom())
			return true;
		else
			return false;
	}
	
	// update waiting time to minimum 
	public void updateWaitingTime()
	{
		if ( requests.get(requests.size()-1).getTTL() < waitingTime )
		{
			requests.get(requests.size()-1).stop(); // stop request's timer
			waitingTime = requests.get(requests.size()-1).getTTL(); // replace smaller time
			System.out.println("time update " + waitingTime);
			if ( !isRunning )
				start();
		}
	}

	// start timer
	public synchronized void start() {
		isRunning = true;
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				waitingTime -= 1; // decrease TTL
				System.out.println(waitingTime);
				if (waitingTime <= 0) {
					// notify to observer
					setChanged();
					notifyObservers(MatchingSystem.signalType.MATCHING_COMPLETED);
					stop(); // stop timer
					System.out.println("timer stopped");
				}
			}
		}, 0, 1000); // run at 1 sec period
	}

	// stop timer
	public synchronized void stop() {
		if (timer != null)
		{
			isRunning = false;
			timer.cancel();
		}
	}

	public Spot getFrom() {
		return from;
	}

	public Spot getTo() {
		return to;
	}

	public ArrayList<Request> getPassengers() {
		return requests;
	}

	public long getWaitingTime() {
		return waitingTime;
	}


	public void setFrom(Spot from) {
		this.from = from;
	}

	public void setTo(Spot to) {
		this.to = to;
	}

	public void setPassengers(ArrayList<Request> passengers) {
		this.requests = passengers;
	}

	public void setWaitingTime(long waitingTime) {
		this.waitingTime = waitingTime;
	}

	public ArrayList<Request> getRequests() {
		return requests;
	}

}
