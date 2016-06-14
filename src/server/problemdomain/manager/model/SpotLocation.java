package server.problemdomain.manager.model;

import java.util.ArrayList;

public class SpotLocation{
	private ArrayList<Location> locationArray = new ArrayList<Location>();
	public SpotLocation(){
		int i = 0;
		int j = 0;
		int count = 0;
		while(i < 30&&j<30){
			
		
			if((count%3)==0){
				i = count/3;
				j = count/3;
				count++;
			}
			else if((count%3)==1){
				i = count/3+1;
				j = count/3;
				count++;
			}
			else if((count%3) == 2){
				i = count/3;
				j = count/3+1;
				count++;
			}
			locationArray.add(new Location(i*90,j*90));
		}
	}
	public ArrayList<Location> getLocationArray() {
		return locationArray;
	}
	public void setLocationArray(ArrayList<Location> locationArray) {
		this.locationArray = locationArray;
	}
}
