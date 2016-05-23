/* Packet.java
 * 서버-클라이언트 간의 통신에 사용되는 객체로 명령의 종류와 파라미터 오브젝트를 가진다.
 * 프로토콜
 * 클라이언트->서버
 * 
 * -공통
 * --로그인 관련
 * ---LOGIN @PARAMS ( ID, PW )
 * --요청 후 서버로부터의 응답type : RETURN_LOGIN_RESULT
 * ---LOGOUT @PARAMS null
 * 
 * --지도정보 요청(목적지, 출발지 목록, 더 필요하나?)
 * ---REQUEST_MAP_INFO 
 * ---요청 후 서버로부터의 응답type : RETURN_MAP_INFO
 * 
 * -승객->서버
 * --가입
 * ---CHECK_DUPLICATED_ID @PARAMS 1.ID
 * ---요청 후 서버로부터의 응답type : RETURN_ISDUPLICATED_ID
 * ---ADD_NEW_PASSENGER @PARAMS 1.PASSENGER
 * 
 * --매칭요청
 * ---REQUEST_MATHCING @PARAMS 1. 매칭정보(출발지, 목적지, 최대매칭시간)
 * 
 * -택시->서버
 * --위치전송
 * ---SEND_LOCATION @PARAMS 1. 위치정보(지도의 지점 중 )
 * 
 * --매칭상태 전송
 * ---SEND_MATHCING_STATUS @PARAMS 1. 매칭에 id를 부여해서 보내면 될 듯 - 관련 매칭상태 enum도 필요
 * 
 * -서버 리턴
 * --매칭결과
 * ---RETURN_MATHCING_RESULT @PARAMS 1. 매칭 클래스, null이면 실패한걸로
 * 
 * --운행요금
 * ---RETURN_FARE @PARAMS 1. 요금
 * 
 * --매칭상태 
 * ---UPDATE_MATHCING_STATUS @PARAMS 매칭클래스 전체를 넘겨줄지 상태만 넘겨줄지 정해야 함
*/

package physicalarchitecture.common;

import java.io.Serializable;
import java.util.ArrayList;

public class Packet implements Serializable {
	PacketType messageType; // 서버에 요청한 요청종류를 나타내는 변수
	ArrayList<Object> params; // 파라미터를 저장하기 위한 ArrayList

	public Packet() {
		params = new ArrayList<Object>();
	}

	public enum PacketType {
		// 서버로 요청//////////////////////////////////
		// 로그인 관련
		LOGIN, LOGOUT,
		// 지도정보 요청
		REQUEST_MAP_INFO, RETURN_MAP_INFO,
		// 가입
		CHECK_DUPLICATED_ID, ADD_NEW_PASSENGER,		
		// 매칭요청
		REQUEST_MATHCING,
		// 위치전송
		SEND_LOCATION,
		// 매칭상태 전송
		SEND_MATHCING_STATUS,
		// 매칭결과
		RETURN_MATCHING_RESULT,
		// 운행요금
		RETURN_FARE,
		// 매칭상태
		UDDATE_MATHCING_STATUS,
		// null 변수
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

