/* Packet.java
 * ����-Ŭ���̾�Ʈ ���� ��ſ� ���Ǵ� ��ü�� ����� ������ �Ķ���� ������Ʈ�� ������.
 * ��������
 * Ŭ���̾�Ʈ->����
 * 
 * -����
 * --�α��� ����
 * ---LOGIN @PARAMS ( ID, PW )
 * --��û �� �����κ����� ����type : RETURN_LOGIN_RESULT
 * ---LOGOUT @PARAMS null
 * 
 * --�������� ��û(������, ����� ���, �� �ʿ��ϳ�?)
 * ---REQUEST_MAP_INFO 
 * ---��û �� �����κ����� ����type : RETURN_MAP_INFO
 * 
 * -�°�->����
 * --����
 * ---CHECK_DUPLICATED_ID @PARAMS 1.ID
 * ---��û �� �����κ����� ����type : RETURN_ISDUPLICATED_ID
 * ---ADD_NEW_PASSENGER @PARAMS 1.PASSENGER
 * 
 * --��Ī��û
 * ---REQUEST_MATHCING @PARAMS 1. ��Ī����(�����, ������, �ִ��Ī�ð�)
 * 
 * -�ý�->����
 * --��ġ����
 * ---SEND_LOCATION @PARAMS 1. ��ġ����(������ ���� �� )
 * 
 * --��Ī���� ����
 * ---SEND_MATHCING_STATUS @PARAMS 1. ��Ī�� id�� �ο��ؼ� ������ �� �� - ���� ��Ī���� enum�� �ʿ�
 * 
 * -���� ����
 * --��Ī���
 * ---RETURN_MATHCING_RESULT @PARAMS 1. ��Ī Ŭ����, null�̸� �����Ѱɷ�
 * 
 * --������
 * ---RETURN_FARE @PARAMS 1. ���
 * 
 * --��Ī���� 
 * ---UPDATE_MATHCING_STATUS @PARAMS ��ĪŬ���� ��ü�� �Ѱ����� ���¸� �Ѱ����� ���ؾ� ��
*/

package physicalarchitecture.common;

import java.io.Serializable;
import java.util.ArrayList;

public class Packet implements Serializable {
	PacketType messageType; // ������ ��û�� ��û������ ��Ÿ���� ����
	ArrayList<Object> params; // �Ķ���͸� �����ϱ� ���� ArrayList

	public Packet() {
		params = new ArrayList<Object>();
	}

	public enum PacketType {
		// ������ ��û//////////////////////////////////
		// �α��� ����
		LOGIN, LOGOUT,
		// �������� ��û
		REQUEST_MAP_INFO, RETURN_MAP_INFO,
		// ����
		CHECK_DUPLICATED_ID, ADD_NEW_PASSENGER,		
		// ��Ī��û
		REQUEST_MATHCING,
		// ��ġ����
		SEND_LOCATION,
		// ��Ī���� ����
		SEND_MATHCING_STATUS,
		// ��Ī���
		RETURN_MATCHING_RESULT,
		// ������
		RETURN_FARE,
		// ��Ī����
		UDDATE_MATHCING_STATUS,
		// null ����
		NONE;
	}

	public PacketType getMessageType() {
		return messageType;
	}

	public ArrayList<Object> getParms() {
		return params;
	}

	public void setMessageType(PacketType messageType) {
		this.messageType = messageType;
	}

	public void addParammeter(Object obj) {
		params.add(obj);
	}

}

