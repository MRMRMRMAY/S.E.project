package server.problemdomain.manager.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import com.sun.javafx.scene.traversal.WeightedClosestCorner;

import server.problemdomain.manager.model.MapStart;
import server.problemdomain.manager.model.SpotLocation;
import server.problemdomain.systemdata.Spot;



public class SpotPanel extends JPanel{
	private Color[] color = {Color.black,Color.red,Color.green,Color.blue,Color.magenta,Color.yellow,Color.orange};
	private SpotLocation location = new SpotLocation();
	private JLabel[][] labels = new JLabel[100][100];
	//private String[][] information = new String[100][100];
	private int[][] distance2DArray = null;
	private DistanceInformationView distancePanel;
	private String [][] distanceInformation = new String[100][100];
	private ArrayList<String> spotNames = new ArrayList<String>();
	
	private JList<String> distanceList;
	private DefaultListModel dlm;
	
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
		if(distance2DArray!=null){
			if(!dlm.isEmpty())
				dlm.removeAllElements();
		for(int i = 0; i<distance2DArray.length;i++)
		{
			for(int j = i; j < distance2DArray[i].length;j++){
				if(distance2DArray[i][j]>0){
					Line2D lin = new Line2D.Float((float)location.getLocationArray().get(i).getX()+15,(float)location.getLocationArray().get(i).getY()+25,(float)location.getLocationArray().get(j).getX()+15,(float)location.getLocationArray().get(j).getY()+25);
					//if(labels[i][j] == null)
					//	labels[i][j] = new JLabel();
					//labels[i][j].setText(String.format("from %d to %d dist:%d",i+1,j+1,distance2DArray[i][j]));
					//labels[i][j].reshape((location.getLocationArray().get(i).getX()+location.getLocationArray().get(j).getX())/2+i,
					//		(location.getLocationArray().get(i).getY()+location.getLocationArray().get(j).getY())/2+9*i,150,50);
					//(location.getLocationArray().get(i).getY()+location.getLocationArray().get(j).getY())/2+5
					//this.add(labels[i][j]);
					
					distanceInformation[i][j] = String.format("from %s to %s dist:%d",spotNames.get(i),spotNames.get(j),distance2DArray[i][j]);
					dlm.addElement(distanceInformation[i][j]);
					g2.setColor(color[i%color.length]);
					g2.draw(lin);
				}
			}
			}
			
		}
		distanceList.setModel(dlm);
		
	}
	
	
	public int[][] getDistance2DArray() {
		return this.distance2DArray;
	}
	public void setDistance2DArray(int[][] distance2DArray) {
		this.distance2DArray = distance2DArray;
	}
	public DistanceInformationView getDistancePanel() {
		return distancePanel;
	}
	public void setDistancePanel(DistanceInformationView distancePanel) {
		this.distancePanel = distancePanel;
	}
	
	
	public ArrayList<String> getSpotNames() {
		return spotNames;
	}
	public void setSpotNames(ArrayList<String> spotNames) {
		this.spotNames = spotNames;
	}
	
	
	public JList<String> getDistanceList() {
		return distanceList;
	}
	public void setDistanceList(JList<String> distanceList) {
		this.distanceList = distanceList;
	}
	
	
	public DefaultListModel getDlm() {
		return dlm;
	}
	public void setDlm(DefaultListModel dlm) {
		this.dlm = dlm;
	}
	
}
