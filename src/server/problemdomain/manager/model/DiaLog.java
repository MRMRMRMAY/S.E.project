package server.problemdomain.manager.model;

public class DiaLog {
	private String message;
	public DiaLog(){
		this("");
	}
	public DiaLog(String message){
		this.message = message;
	}
	public void setMessage(String message){
		this.message = message;
	}
	public String getMessage(){
		return message;
	}
}
