/*
 * UserMessage
 * matching message
 * 
 * wangnan
 * */

package application;

public class UserMess 
{
	//phone number
	private String num1 = "010-1234-5678";
	private String num2 = "010-6542-8621";
	
	//start
	private String start = "경북대학교";
	//arrive
	private String arrive = "대구역";
	
	/*
	 * Num 
	 * 
	 * */
	public String getNum1() 
	{
		return num1;
	}
	public void setNum(String num1) 
	{
		this.num1 = num1;
	}
	
	public String getNum2() 
	{
		return num2;
	}
	public void setNum2(String num2) 
	{
		this.num2 = num2;
	}
	/*
	 * Start
	 * 
	 * */
	public String getStart() 
	{
		return start;
	}
	public void setStart(String start) 
	{
		this.start = start;
	}
	
	/*
	 * Arrive
	 * 
	 * */
	public String getArrive() 
	{
		return arrive;
	}
	public void setArrive(String arrive) 
	{
		this.arrive = arrive;
	}
}
