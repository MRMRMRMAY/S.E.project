package server.problemdomain.manager.model;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import server.problemdomain.manager.MainApp;
import server.problemdomain.manager.view.MapPanel;
import server.problemdomain.manager.view.SpotPanel;
import server.problemdomain.systemdata.Spot;
public class MapStart extends JFrame{
	private static MapPanel mapPanle;
	private static HashMap<Spot, JLabel>point = new HashMap<Spot,JLabel>();
	private static boolean flag = true;
	private static JFrame frame;
	private static SpotPanel spotPanel;
	private static SpotLocation spotLocation = new SpotLocation();
	private int[][] map;
	//private JLabel[][] labels = new JLabel[100][100];

	public MapStart(){
		frame = new JFrame();
		mapPanle = new MapPanel();
		spotPanel = new SpotPanel();
		//frame.setSize(800, 600);
		frame.setSize(new Dimension(800,600));
		frame.add(spotPanel,BorderLayout.EAST);
		frame.add(mapPanle,BorderLayout.WEST);
		mapPanle.setMainFrame(this);
		frame.pack();
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		
		frame.setResizable(false);
		frame.setVisible(true);
	}
	public void addPoint(int index, Spot name){
		JLabel item = new JLabel();
		item.setIcon(new ImageIcon(getClass().getResource("Point.png")));
		//item.setBounds(200+spotLocation.getLocationArray().get(index).getX(), spotLocation.getLocationArray().get(index).getY(),50, 50);
		item.setText(name.getSpotName());
		point.put(name, item);
	//	frame.add(item);
	//	frame.repaint();
		spotPanel.addSpotPanel(item);
		item.reshape(spotLocation.getLocationArray().get(index).getX(), spotLocation.getLocationArray().get(index).getY(),50, 50);
	}
	
	
	
	public static SpotPanel getSpotPanel() {
		return spotPanel;
	}
	public static void setSpotPanel(SpotPanel spotPanel) {
		MapStart.spotPanel = spotPanel;
	}
	public void deletPoint(Spot name){
		if(flag){
			JLabel item = point.get(name);
			item.setVisible(false);
			spotPanel.deletPoint(item);
		}
	}
	public int[][] getMap() {
		return map;
	}
	public void setMap(int[][] map) {
		this.map = map;
		
		spotPanel.setDistance2DArray(map);
		spotPanel.repaint();
/*		for(int i = 0; i<map.length;i++)
		{
			for(int j = i; j < map[i].length;j++){
				if(map[i][j]>0){
					labels[i][j] = new JLabel();
					labels[i][j].setText(String.format("%d to %d distance:%d",i,j,map[i][j]));
					labels[i][j].reshape((spotLocation.getLocationArray().get(i).getX()+spotLocation.getLocationArray().get(j).getX())/2,
							(spotLocation.getLocationArray().get(i).getY()+spotLocation.getLocationArray().get(j).getY())/2,WIDTH,HEIGHT);
					this.add(labels[i][j]);
				}
			}
		}
*/	}
	public class myMouseMotion extends MouseAdapter{
		@Override
		public void mouseMoved(MouseEvent e){
	
			
		}
	}
}
