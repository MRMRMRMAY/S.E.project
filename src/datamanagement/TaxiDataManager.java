/*
 * TaxiDataManager.java
 * 
 * Control data I/O by file
 * It save and load taxi data
*/

package datamanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import server.problemdomain.member.Taxi;



public class TaxiDataManager {
	private static TaxiDataManager taxiDataManager; // singleton obj
	
	private FileInputStream fin;
	private FileOutputStream fout;
	private ObjectInputStream ofin;
	private ObjectOutputStream ofout;
	
	public static TaxiDataManager getInstance()
	{
		if ( taxiDataManager == null )
			taxiDataManager = new TaxiDataManager();
		return taxiDataManager;
	}
	
	public ArrayList<Taxi> loadData()
	{
		ArrayList<Taxi> taxiList = null;
		
		try {
			fin = new FileInputStream("taxi.dat");
			ofin = new ObjectInputStream(fin);
			
			// error
			if ( ofin == null )
				System.err.println("taxi.dat was invalid");
			else
				taxiList = (ArrayList<Taxi>)ofin.readObject();
			
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
			return taxiList;
		}
	}
	
	public void saveData(ArrayList<Taxi> taxiList)
	{
		try {
			fout = new FileOutputStream("taxi.dat");
			ofout = new ObjectOutputStream(fout);
			
			ofout.writeObject(taxiList);
			
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
