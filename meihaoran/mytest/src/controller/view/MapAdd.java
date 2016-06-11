package controller.view;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.moder.MapStart;

public class MapAdd extends JPanel{
	private ArrayList<MapStart> map = new ArrayList<MapStart>();
	public void addMap(MapStart e){
		if(!map.isEmpty())
			map.clear();
		map.add(e);
	}
}
