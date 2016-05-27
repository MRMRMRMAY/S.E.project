import java.time.Duration;
import java.time.LocalDateTime;

import problemdomain.matching.MatchingSystem;
import problemdomain.matching.Request;
import problemdomain.member.Passenger;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		test1 시간 측정하기
		/*LocalDateTime start, end;
		start = LocalDateTime.now();
		int i = 0;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		end = LocalDateTime.now();
		
		System.out.println(Duration.between(start, end).toMillis());
*/		

		
		// set timer to request about TTL
		Passenger p1 = new Passenger();
		p1.setId("123"); p1.setName("test");
		Request r1 = new Request(p1, null, null, null, 3);
		MatchingSystem sys = new MatchingSystem();
		
		//t1.start();
		r1.addObserver(sys);
		sys.addRequest(r1);

		r1.start();
		while(true)
		{
			
		}

		
	}

}
