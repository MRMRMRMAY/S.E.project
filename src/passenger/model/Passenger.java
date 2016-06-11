package passenger.model;

public class Passenger {

	private String id;
	private String password;
	private String name;
	private String passenger_contact;
	
	// �°� id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	// �°� password
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	// �°� �̸�
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// �°� ����ó
	public String getpassenger_contact() {
		return passenger_contact;
	}

	public void setpassenger_contact(String passenger_contact) {
		this.passenger_contact = passenger_contact;
	}
	
	
	//
	public Passenger(String id, String pw, String name, String pc) {
		this.id = id;
		this.password = pw;
		this.name = name;
		this.passenger_contact = pc;
	}

	
	// id ��ȿ��
	public boolean isValidID(String id) {
		char chr;
		
		if(id.length() == 0) {
			System.out.println("�ʼ��׸��Դϴ�.");
			return false;
		}
		
		for(int i=0; i<id.length(); i++) {
			chr = id.charAt(i);
			
			if((chr>='\u0061') && (chr<='\u007A') || (chr>='\u0030') && (chr<='\u0039'))
			// [a(0061)~z(007A) and 0(0030)~9(0039)] �� �Է� ����
				{
				if(id.length() < 4 || id.length() > 8) {
					System.out.println("id�� 4~8�ڸ��Դϴ�.");
					return false;
				}
			} else {
				System.out.println("���ĺ� �ҹ��ڿ� ���ڸ� �Է� �����մϴ�.");
				return false;
			}
		}
		return true;
	}
	
	
	// ����ó ��ȿ��
	public boolean isValidpassenger_contact(String passenger_contact) {
		char chr;
				
		for(int i = 0; i<passenger_contact.length(); i++) {
			chr = passenger_contact.charAt(i);
		
			if((chr>='\u0030') && (chr<= '\u0039')) {
			} else {
				System.out.println("'-'���� ���ڸ� �Է����ּ���.");
				return false;
				}
		}
				
		return true;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
