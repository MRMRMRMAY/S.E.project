package server.problemdomain.manager.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import server.problemdomain.manager.model.MapStart;
import server.problemdomain.systemdata.Spot;

public class DistanceInformationView extends JPanel{
	private JList<String> distanceList = new JList<String>();
	private DefaultListModel dlm = new DefaultListModel();
	private MapStart mapStart;
	private JLabel distanceLabel;
	//private JLabel[][] labels = new JLabel[100][100];
	//private String[][] distanceInformation; //= new String[100][100];
	private JScrollPane scrollPane;
	private ArrayList<Spot> spotList;
	public DistanceInformationView(){
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		distanceLabel = new JLabel();
		distanceLabel.setText("Distance List :");
		distanceList = new JList<String>(dlm);
		distanceList.setFixedCellWidth(1000);
		distanceList.setFixedCellHeight(13);
		distanceList.setVisibleRowCount(7);
		scrollPane = new JScrollPane(distanceList);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setSize(new Dimension(1000,170));
		this.add(distanceLabel);
		this.add(scrollPane);
	}
/*	public void distanceUpData(int[][]map,String[][] distanceInformation){
		int count = 0;
		
		if(!dlm.isEmpty())
			dlm.removeAllElements();
		for(int i = 0; i<map.length;i++)
		{
			for(int j = i; j < map[i].length;j++){
				if(distanceInformation[i][j]!=null)
					dlm.addElement(distanceInformation[i][j]);
			}
		}
		distanceList.setModel(dlm);
		//map.setSpotList(SpotList);
		//fromSpotNamesList.removeAll();
		
	}*/
	public Dimension getMinimumSize(){
		return getPreferredSize();
	}
	public Dimension getPreferredSize(){
		return new Dimension(1000,180);
	}
	public MapStart getMapStart() {
		return mapStart;
	}
	public void setMapStart(MapStart mapStart) {
		this.mapStart = mapStart;
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
