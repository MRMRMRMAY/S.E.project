package controller.moder;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class MapStart extends JFrame{
	private static MapPanel mapPanle;
	private static HashMap<Spot, JLabel>point = new HashMap<Spot,JLabel>();
	private static boolean flag = true;
	private static JFrame frame;
	public MapStart(){
		frame = new JFrame();
		mapPanle = new MapPanel(frame);
		frame.add(mapPanle);
		mapPanle.setMainFrame(this);
		frame.pack();
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	public static void addPoint(int x, int y, Spot name){
		JLabel item = new JLabel();
		item.setIcon(new ImageIcon("D:/SE/project/mytest/src/controller/moder/Point.png"));
		item.setBounds(x, y,100, 100);
		item.setText(name.getSpotName());
		point.put(name, item);
		frame.add(item);
		frame.repaint();
	}
	public void deletPoint(Spot name){
		if(flag){
			JLabel item = point.get(name);
			frame.remove(item);
			frame.repaint();
		}
	}
	
}
