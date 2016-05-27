package controller.moder;
import javax.swing.JFrame;
public class MapStart extends JFrame{
	private final MapPanel mapPanle;
	public MapStart(){
		mapPanle = new MapPanel(this);
		add(mapPanle);
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
