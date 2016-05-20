package tempP.model;

public class Passenger {

	private String id;
	private String password;
	private String name;
	private String contact;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	
	public boolean isValidID(String id) {
		char chr;
		
		if(id.length() == 0) {
			System.out.println("필수항목입니다.");
			return false;
		}
		
		for(int i=0; i<id.length(); i++) {
			chr = id.charAt(i);
			
			if((chr>='\u0061') && (chr<='\u007A') || (chr>='\u0030') && (chr<='\u0039'))
			// [a(0061)~z(007A), 0(0030)~9(0039)] 만 입력 가능
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
	
	
	public boolean isValidContact(String contact) {
		char chr;
		
		for(int i = 0; i<contact.length(); i++) {
		chr = contact.charAt(i);
		
			if((contact.charAt(i)<'\u0030') && (contact.charAt(i)>'\u0039')) {
				return true;
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
