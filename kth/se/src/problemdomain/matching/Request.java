/*
 * Request.java
 * it represents request from passenger who request matching.
*/
package problemdomain.matching;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import problemdomain.member.Passenger;
import problemdomain.systemdata.Spot;

public class Request extends Observable {
	private Passenger passenger; // requesting passenger
	private Spot from; // requesting point of departure
	private Spot to; // requesting destination
	private LocalDateTime requestedTime; // time when requested
	private long TTL; // time to live( sec )
	private RequestState state; // request state

	private Timer timer; // timer to stop waiting for matching when time expired
	
	
	private MatchingQueueEntry matchingQueue; // queue for matching

	// enum type for request status
	public enum RequestState {
		raw, waiting, matched, expired;
	}

	// default constructor
	public Request(Passenger passenger, Spot from, Spot to, LocalDateTime requestedTime, long TTL) {
		super();
		this.passenger = passenger;
		this.from = from;
		this.to = to;
		this.requestedTime = requestedTime;
		this.TTL = TTL;
		this.state = RequestState.raw; // set default raw
		this.timer = new Timer(true);
	}

	// @Override
	// public void run() {
	// // TODO Auto-generated method stub
	// while ( TTL >= 0 )
	// TTL -= 1;
	// }

	// start timer
	public synchronized void start() {
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				TTL -= 1; // decrease TTL
				System.out.println(TTL);
				if (TTL <= 0) {
					// notify to observer
					setChanged();
					notifyObservers(MatchingSystem.signalType.REQUEST_EXPIRED);
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
			state = RequestState.expired; // set expired
			timer.cancel();
		}
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public Spot getFrom() {
		return from;
	}

	public Spot getTo() {
		return to;
	}

	public LocalDateTime getRequestedTime() {
		return requestedTime;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public void setFrom(Spot from) {
		this.from = from;
	}

	public void setTo(Spot to) {
		this.to = to;
	}

	public void setRequestedTime() {
		this.requestedTime = LocalDateTime.now(); // set current time
	}

	public RequestState getState() {
		return state;
	}

	public void setState(RequestState state) {
		this.state = state;
	}

	public long getTTL() {
		return TTL;
	}

	public MatchingQueueEntry getMatchingQueue() {
		return matchingQueue;
	}

	public void setRequestedTime(LocalDateTime requestedTime) {
		this.requestedTime = requestedTime;
	}

	public void setTTL(long tTL) {
		TTL = tTL;
	}

	public void setMatchingQueue(MatchingQueueEntry matchingQueue) {
		this.matchingQueue = matchingQueue;
	}
}
