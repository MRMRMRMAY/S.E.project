/* Packet.java
 * 
 * It declares packet that transmitted between server and client
 * packet's type indicates what data transmitted and it's purpose
 * data means real data
*/

package physicalarchitecture.common;

import java.io.Serializable;
import java.util.ArrayList;

public class Packet implements Serializable {
	PacketType packetType; // indicate what information packet contains
	ArrayList<Object> params; // data

	public Packet() {
		params = new ArrayList<Object>();
	}

	public enum PacketType {
		// common
		LOGIN, LOGOUT,
		REQUEST_MAP, REPLY_MAP,
		NOTICE, //(s->p)
		NONE,
		
		// between passenger and server
		// Reuqest(p->s)
		P_SIGNIN,
		P_REQUEST_MATCHING,
		// Reply(s->p)
		P_REPLY_MATCHING,
		
		// between taxi and server
		// Request(t->s)
		T_UPDATE_TAXI_STATE,
		
		// Reply(s->t)
		T_NEW_MATCHING;
	}

	public PacketType getpacketType() {
		return packetType;
	}

	public ArrayList<Object> getParms() {
		return params;
	}

	public void setpacketType(PacketType packetType) {
		this.packetType = packetType;
	}

	public void addParammeter(Object obj) {
		params.add(obj);
	}

}

