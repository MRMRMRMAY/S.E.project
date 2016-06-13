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

import com.sun.javafx.scene.traversal.WeightedClosestCorner;

import server.problemdomain.manager.model.SpotLocation;



public class SpotPanel extends JPanel{
	private Color[] color = {Color.black,Color.red,Color.green,Color.blue,Color.magenta,Color.yellow,Color.orange};
	private SpotLocation location = new SpotLocation();
	private JLabel[][] labels = new JLabel[100][100];
	private int[][] distance2DArray = null;
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
		if(distance2DArray!=null)
		for(int i = 0; i<distance2DArray.length;i++)
		{
			for(int j = i; j < distance2DArray[i].length;j++){
				if(distance2DArray[i][j]>0){
					Line2D lin = new Line2D.Float((float)location.getLocationArray().get(i).getX()+15,(float)location.getLocationArray().get(i).getY()+25,(float)location.getLocationArray().get(j).getX()+15,(float)location.getLocationArray().get(j).getY()+25);
					labels[i][j] = new JLabel();
					labels[i][j].setText(String.format("dist:%d",distance2DArray[i][j]));
					labels[i][j].reshape((location.getLocationArray().get(i).getX()+location.getLocationArray().get(j).getX())/2,
							(location.getLocationArray().get(i).getY()+location.getLocationArray().get(j).getY())/2+5,150,50);
					this.add(labels[i][j]);
					g2.setColor(color[i%color.length]);
					g2.draw(lin);
				}
			}
		}
	}
	public int[][] getDistance2DArray() {
		return this.distance2DArray;
	}
	public void setDistance2DArray(int[][] distance2DArray) {
		this.distance2DArray = distance2DArray;
	}
}
