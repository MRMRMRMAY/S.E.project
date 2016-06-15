package passenger.model;

public class Passenger {

	private String id;
	private String password;
	private String name;
	private String passenger_contact;
	
	// 승객 id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	// 승객 password
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	// 승객 이름
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 승객 연락처
	public String getpassenger_contact() {
		return passenger_contact;
	}

	public void setpassenger_contact(String passenger_contact) {
		this.passenger_contact = passenger_contact;
	}
	public Passenger(String id,String pw){
		this.id = id;
		this.password = pw;
	}
	
	//
	public Passenger(String id, String pw, String name, String pc) {
		this.id = id;
		this.password = pw;
		this.name = name;
		this.passenger_contact = pc;
	}

	
	// id 유효성
	public boolean isValidID(String id) {
		char chr;
		
		if(id.length() == 0) {
			System.out.println("필수항목입니다.");
			return false;
		}
		
		for(int i=0; i<id.length(); i++) {
			chr = id.charAt(i);
			
			if((chr>='\u0061') && (chr<='\u007A') || (chr>='\u0030') && (chr<='\u0039'))
			// [a(0061)~z(007A) and 0(0030)~9(0039)] 만 입력 가능
				{
				if(id.length() < 4 || id.length() > 8) {
					System.out.println("id는 4~8자리입니다.");
					return false;
				}
			} else {
				System.out.println("알파벳 소문자와 숫자만 입력 가능합니다.");
				return false;
			}
		}
		return true;
	}
	
	
	// 연락처 유효성
	public boolean isValidpassenger_contact(String passenger_contact) {
		char chr;
				
		for(int i = 0; i<passenger_contact.length(); i++) {
			chr = passenger_contact.charAt(i);
		
			if((chr>='\u0030') && (chr<= '\u0039')) {
			} else {
				System.out.println("'-'없이 숫자만 입력해주세요.");
				return false;
				}
		}
				
		return true;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
