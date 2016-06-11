package server.problemdomain.manager.model;

import java.util.ArrayList;

public class SpotLocation{
	private ArrayList<Location> locationArray = new ArrayList<Location>();
	public SpotLocation(){
		for(int i = 0; i < 30; i++){
			for(int j = 0; j < 30; j++){
				locationArray.add(new Location(i*50,j*50));
			}
		}
	}
	public ArrayList<Location> getLocationArray() {
		return locationArray;
	}
	public void setLocationArray(ArrayList<Location> locationArray) {
		this.locationArray = locationArray;
	}
}
class Location{
	private int x;
	private int y;
	public Location(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}