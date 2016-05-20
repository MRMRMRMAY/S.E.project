package C.M;
import java.util.ArrayList;
public class Path {
	private ArrayList<Graph>[] graph = new ArrayList[]<Graph>();
	public Path(int from, int to, int weight){
		try{
			graph[from].add(new Graph(to,weight));
		}
		catch(Exception ex){
			
		}
	}
	public Graph getGraph(){
		Graph graph;
		return graph;
	}
}
class Point{

}
class Graph{
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