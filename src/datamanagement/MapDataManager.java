/*
 * MapDataManager.java
 * 
 * Control data I/O by file
 * It save and load map data
*/


package datamanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import server.problemdomain.systemdata.Map;

public class MapDataManager {
	private static MapDataManager mapDataManager; // singleton obj
	
	private FileInputStream fin;
	private FileOutputStream fout;
	private ObjectInputStream ofin;
	private ObjectOutputStream ofout;
	
	public static MapDataManager getInstance()
	{
		if ( mapDataManager == null )
			mapDataManager = new MapDataManager();
		return mapDataManager;
	}
	
	
	public Map loadData()
	{
		Map map = null;
		
		try {
			fin = new FileInputStream(new File("map.dat"));
			ofin = new ObjectInputStream(fin);
			
			// error
			if ( ofin == null )
				System.err.println("map.dat was invalid");
			else
				map = (Map)ofin.readObject();
			
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
			return map;
		}
	}
	
	public void saveData(Map map)
	{
		try {
			fout = new FileOutputStream("map.dat");
			ofout = new ObjectOutputStream(fout);
			
			ofout.writeObject(map);
			
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
