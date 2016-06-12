/*
 * PassengerDataManager.java
 * 
 * Control data I/O by file
 * It save and load passenger data
*/


package datamanagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import server.problemdomain.member.Passenger;
import server.problemdomain.systemdata.Map;

public class PassengerDataManager {
	private static PassengerDataManager passengerDataManager; // singleton obj
	
	private FileInputStream fin;
	private FileOutputStream fout;
	private ObjectInputStream ofin;
	private ObjectOutputStream ofout;
	
	public static PassengerDataManager getInstance()
	{
		if ( passengerDataManager == null )
			passengerDataManager = new PassengerDataManager();
		return passengerDataManager;
	}
	
	public ArrayList<Passenger> loadData()
	{
		ArrayList<Passenger> passengerList = null;
		
		try {
			fin = new FileInputStream("passenger.dat");
			ofin = new ObjectInputStream(fin);
			
			// error
			if ( ofin == null )
				System.err.println("passenger.dat was invalid");
			else
				passengerList = (ArrayList<Passenger>)ofin.readObject();
			
			ofin.close();
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return passengerList;
		}
	}
	
	public void saveData(ArrayList<Passenger> passengerList)
	{
		try {
			fout = new FileOutputStream("passenger.dat");
			ofout = new ObjectOutputStream(fout);
			
			ofout.writeObject(passengerList);
			
			ofout.close();
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
