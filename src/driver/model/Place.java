package driver.model;

public class Place
{
	private String place;
	private int time;


	public Place(String place, int time)
	{
		this.place = place;
		this.time = time;
	}

	public String getPlace()
	{
		return place;
	}

	public void setPlace(String place)
	{
		this.place = place;
	}

	public int getTime()
	{
		return time;
	}

	public void setTime(int time)
	{
		this.time = time;
	}

	public int getTim()
	{
		while(time >= 0)
	       {
	    	   //System.out.println(time);
	    	   /*if(time ==0)
	    	   {
	               System.out.println("도착합니다.");
	    	   }
	    	   */
	           try 
	           {
	               Thread.sleep(2000);
	           } 
	           catch (Exception e) 
	           {
	            // TODO: handle exception
	           }
	           time--;
	       }
		return time;
	}

}
