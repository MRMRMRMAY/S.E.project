package C.M;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
public class Map{          
	
	private ArrayList<HashMap<Spot,Integer>> map = new ArrayList<HashMap<Spot,Integer>>();
	public Map(ArrayList<HashMap<Spot,Integer>> map){
		try{
			this.map = map;
		}
		catch(Exception ex){
			ex.getStackTrace();
		}
		for(HashMap<Spot,Integer>item:map){
			item.get(1);
		}
	}
//	public Graph getGraph(){
//		Graph graph;
//		return graph;
//	}
}
class Point{
	HashMap<String, Integer>map = new HashMap<String,Integer>();
	public Point() {
		// TODO Auto-generated constructor stu
	}
}
class Graph{
	private HashMap<String,Integer> book = new HashMap<String,Integer>();
	private int to;
	private int weight;
	public Graph(){
		this(0,0,0);
	}
	public Graph(int from,int to,int weight){
		
		this.to = to;
		this.weight = weight;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public int getWeight(){
		return weight;
	}
	public void setWeight(int weight){
		this.weight = weight;
	}
}