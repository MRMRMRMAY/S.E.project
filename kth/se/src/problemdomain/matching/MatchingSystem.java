/*
 * MatchingSystem.java
 * control matching and manage request
*/

package problemdomain.matching;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class MatchingSystem implements Observer{
	private ArrayList<Request> requestList; // queue for request

	public MatchingSystem() {
		requestList = new ArrayList<Request>();
	}
	
	public void addRequest(Request request)
	{
		requestList.add(request);
	}
	
	public synchronized void removeRequest(Request request)
	{
		requestList.remove(request);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		// 일단은 request 제거하는 거만
		requestList.remove(arg);
		System.out.println(((Request)o).getPassenger().getName() +  " request was removed");
		
	}

	
	
	
	// make matching class
	
	// send matching result
	
	// 

}
