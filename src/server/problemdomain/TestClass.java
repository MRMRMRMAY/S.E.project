package server.problemdomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Timer;

import datamanagement.MapDataManager;
import datamanagement.PassengerDataManager;
import datamanagement.TaxiDataManager;
import physicalarchitecture.Server;
import server.problemdomain.matching.MatchingSystem;
import server.problemdomain.matching.Request;
import server.problemdomain.matching.Request.RequestState;
import server.problemdomain.member.Passenger;
import server.problemdomain.member.Taxi;
import server.problemdomain.systemdata.Map;
import server.problemdomain.systemdata.Spot;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		test1 �ð� �����ϱ�
		LocalDateTime start, end;
		start = LocalDateTime.now();
		System.out.println(start.toEpochSecond(ZoneOffset.UTC));

		System.out.println((new Long(start.toEpochSecond(ZoneOffset.UTC))).toString().length());
/*		int i = 0;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		*/
		

		

	/*	
		// set timer to request about TTL
		Passenger p1 = new Passenger();
		Passenger p2 = new Passenger();
		p1.setId("123"); p1.setName("test");
		p2.setId("456"); p2.setName("test2");
		Request r1 = new Request(p1, null, null, null, 3);
		Request r2 = new Request(p1, null, null, null, 5);
		MatchingSystem sys = new MatchingSystem();
		
		//t1.start();
		r1.addObserver(sys);
		r2.addObserver(sys);
		sys.addRequest(r1);
		sys.addRequest(r2);

		r1.start();
		r2.start();
		while(true)
		{
			
		}*/
		
	/*	HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1); list.add(2); list.add(3); list.add(4);
		if ( map.containsKey(0) )
		{
			
		}
		else
		{
			map.put(0, list);
		}
		list.add(5);
		
		System.out.println("outter");
		for ( int i : list )
		{
			System.out.printf("%d ", i);
		}
		System.out.println();
		
		System.out.println("map");
		for ( int i : map.get(0) )
		{
			if ( i == 1 )
			{
				i = 10;
				map.get(0).
			}
		}
		System.out.println();
		
		for ( int i : map.get(0) )
		{
			System.out.printf("%d ", i);
		}
		System.out.println();*/
		/*
		class A{
			public int a = 1;
		}
		class B{
			public ArrayList<A> list;
			
			public B()
			{
				list = new ArrayList<A>();
			}
			
			public void add(A a)
			{
				a.a = 2;
				list.add(a);
			}
		}
		A a = new A();
		B b = new B();
		b.add(a);
		System.out.printf("%d\n", a.a);
		System.out.printf("%d\n", b.list.get(0).a);
*/
/*		ArrayList<Integer> list = new ArrayList<Integer>(5);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		for ( int j : list )
			System.out.println(j);*/
/*		
		int arr[][] = {{1,2},{3,4}};
		
		System.out.println(arr.length);
		System.out.println(arr[0].length);*/
		ArrayList<Passenger> passengerData = new ArrayList<Passenger>();
		
		passengerData.add(new Passenger("Hans", "Muster"));
		passengerData.add(new Passenger("Ruth", "Mueller"));
		passengerData.add(new Passenger("Heinz", "Kurz"));
		passengerData.add(new Passenger("Cornelia", "Meier"));
		passengerData.add(new Passenger("Werner", "Meyer"));
		passengerData.add(new Passenger("Lydia", "Kunz"));
		passengerData.add(new Passenger("Anna", "Best"));
		passengerData.add(new Passenger("Stefan", "Meier"));
		passengerData.add(new Passenger("Martin", "Mueller"));
		
		ArrayList<Taxi> taxilist = new ArrayList<Taxi>();
		Taxi taxi, taxi1, taxi2, taxi3, taxi4;
		
		taxi = new Taxi();
		taxi.setId("user");
		taxi.setPw("pass");
		taxi.setDriverName("Sam");
		taxi.setCarModel("Car1");
		taxi.setContactNumber("0055");

		taxi1 = new Taxi();
		taxi1.setId("wang");
		taxi1.setPw("nan");
		taxi1.setDriverName("Amy");
		taxi1.setCarModel("Car2");
		taxi1.setContactNumber("6894");

		taxi2 = new Taxi();
		taxi2.setId("1234");
		taxi2.setPw("5678");
		taxi2.setDriverName("Ben");
		taxi2.setCarModel("Car3");
		taxi2.setContactNumber("1579");

		taxi3 = new Taxi();
		taxi3.setId("1111");
		taxi3.setPw("3333");
		taxi3.setDriverName("Kim");
		taxi3.setCarModel("Car4");
		taxi3.setContactNumber("7842");

		taxi4 = new Taxi();
		taxi4.setId("2222");
		taxi4.setPw("4444");
		taxi4.setDriverName("Jack");
		taxi4.setCarModel("Car5");
		taxi4.setContactNumber("1874");		
		taxilist.add(taxi);
		taxilist.add(taxi1);
		taxilist.add(taxi2);
		taxilist.add(taxi3);
		taxilist.add(taxi4);
		
		PassengerDataManager pdm = PassengerDataManager.getInstance();
		TaxiDataManager tdm = TaxiDataManager.getInstance();
		
		pdm.saveData(passengerData);
		tdm.saveData(taxilist);
		
		int test[] = new int[5];
		
		for ( int i : test)
			System.out.print(i + " ");
		System.out.println();
		
		int arr[][];
		Map map = null;
		
		try {
			File fin = new File("input.txt");
			Scanner scan;
			scan = new Scanner(fin);
			
			int size = scan.nextInt();
			arr = new int[size][size];
			for ( int i = 0; i < size; i++ )
			{
				for ( int j = 0 ; j < size; j++ )
				{
					arr[i][j] = Integer.parseInt(scan.next());
				}
			}
			
			for ( int i = 0; i < size; i++ )
			{
				for ( int j = 0; j < size; j++ )
				{
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			
			map = new Map();
			map.arrayToMap(arr);
			int arr2[][] = map.mapTo2DArray();
			
			ArrayList<Spot>spotList = map.getSpotList();
			for ( int i = 0; i < size; i++ )
			{
				spotList.get(i).setSpotName(scan.next());
			}
			
			for ( int i = 0; i < size; i++ )
			{
				for ( int j = 0; j < size; j++ )
				{
					System.out.print(arr2[i][j] + " ");
				}
				System.out.print(spotList.get(i).getSpotName());
				System.out.println();
			}
			map.setSpotList(spotList);
			

						
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		MapDataManager man = new MapDataManager();
		man.saveData(map);
		Server server = new Server(5555);
		

	//	Map map2 = man.loadData();
		
		ArrayList<Spot> spotList = map.getSpotList();
		Request request1 = new Request(new Passenger(), spotList.get(0), spotList.get(1), LocalDateTime.now(), 11);
		Request request2 = new Request(new Passenger(), spotList.get(0), spotList.get(1), LocalDateTime.now(), 5);
		Request request3 = new Request(new Passenger(), spotList.get(1), spotList.get(2), LocalDateTime.now(), 15);
		MatchingSystem sys = new MatchingSystem(server);
		MatchingSystem.RouteInfo info = sys.calculateDrivingRoute(spotList.get(0), spotList.get(1));
		System.out.println("dist : " + info.dist);
		for ( Spot i : info.route )
			System.out.print(i.getSpotIndex() + " ");
		System.out.println();
		sys.pushRequest(request1);
		sys.pushRequest(request2);
		sys.pushRequest(request3);
/*		for ( int i = 0)
		
		public Request(Passenger passenger, Spot from, Spot to, LocalDateTime requestedTime, long TTL) {
			super();
			this.passenger = passenger;
			this.from = from;
			this.to = to;
			this.requestedTime = requestedTime;
			this.TTL = TTL;
			this.state = RequestState.raw; // set default raw
			this.timer = new Timer(true);
		}*/
		while (true)
		{
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
//		end = LocalDateTime.now();
//		System.out.println(Duration.between(start, end).toMillis());	
	}

}
