package server.problemdomain.manager.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import driver.model.Location;

public class SpotPanel extends JPanel{
	private ArrayList<Location> locationArray = new ArrayList<Location>();
	public SpotPanel(){
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
//		for(int i = 0; i<100; i++){
//			JPanel p = new JPanel();
//			p.setBorder(BorderFactory.createLineBorder(Color.gray));
//			p.add(new JLabel(new ImageIcon("D:/SE/project/mytest/src/controller/moder/Point.png")));
//			this.add(p);
//		}
	}
	public void addSpotPanel(JLabel item){
		this.add(item);
	}
	public void deletPoint(JLabel item){
		this.remove(item);
	}
	public Dimension getMinimumSize(){
		return getPreferredSize();
	}
	public Dimension getPreferredSize(){
		return new Dimension(600,600);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
//		MapData data = new MapData();
//		if(!data.point.isEmpty())
//		for(Point item:data.point){
//			g.setColor(Color.blue);
//			g.fillOval(item.getX()+100,item.getY()+100,10,10);
//			if(!item.getTo().isEmpty()){
//				for(int toNum: item.getTo()){
//					Line2D line = new Line2D.Float((float)(item.getX()+100),(float)(item.getY()+100),
//							(float)(data.point.get(toNum-1).getX()+100),(float)(data.point.get(toNum-1).getY()+100));
//					g2.draw(line);
//				}
//			}
//		}
//		for(int i = 0;i<3;i++){
//			g.setColor(Color.blue);
//			g.fillOval(i*30, i*30, 20, 20);
//		}
		for(Location location:locationArray){
			for(int i = 1;i<3;i++){
				Line2D lin = new Line2D.Float((float)( (i-1)*30),(float)((i-1)*30),(float)(i*30),(float)(i*30));
				g2.draw(lin);
			}
		}
	}
	public ArrayList<Location> getLocationArray() {
		return locationArray;
	}
	public void setLocationArray(ArrayList<Location> locationArray) {
		this.locationArray = locationArray;
	}
}
