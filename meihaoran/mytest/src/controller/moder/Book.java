package controller.moder;

public enum Book {
	user1("wang",123),user2("hha",1234);
	private String id;
	private int password;
	private Book(String id, int password){
		this.id = id;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	
}
