package controller.moder;
import java.util.ArrayList;
public class MapData {
	static ArrayList<Point> point = new ArrayList<Point>();
	private ArrayList<Integer> to = new ArrayList<Integer>();
	public MapData(){
		to.add(2);
		point.add(new Point(to,12,23));
		to.clear();
		to.add(1);
		point.add(new Point(to,40,123));
	}
	public static ArrayList<Point> getPoint() {
		return point;
	}
	public static void setPoint(ArrayList<Point> point) {
		MapData.point = point;
	}
	public ArrayList<Integer> getTo() {
		return to;
	}
	public void setTo(ArrayList<Integer> to) {
		this.to = to;
	}
}
class Point{
	private ArrayList<Integer> to = new ArrayList<Integer>();
	private int x;
	private int y;
	private String place = new String();
	public Point(ArrayList<Integer> to,int x, int y){
		this.to.addAll(to);
		this.x = x;
		this.y = y;
	}
	public ArrayList<Integer> getTo() {
		return to;
	}
	public void setTo(ArrayList<Integer> to) {
		this.to = to;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
}
class PointLine{
	

}