package server.problemdomain.manager.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import server.problemdomain.manager.model.*;
import server.problemdomain.systemdata.Distance;
import server.problemdomain.systemdata.Map;
import server.problemdomain.systemdata.Spot;
import server.problemdomain.manager.MainApp;


public class MapPanel extends JPanel{
	private int c = 0;
	private String seleterText;
	
	private JFrame parentWindow;
	
	private JButton addButton ;
	private JButton delet;
	private JButton edit ;
	
	private JTextField xInput;
	private JTextField yInput;
	private JTextField nameInput;
	private JTextField toNumberInput;
	private JTextField distanceInput;
	
	private JLabel nameLabel;
	private JLabel xLabel;
	private JLabel yLabel;
	private JLabel toNumberLabel;
	private JLabel fromNumberLabel;
	private JLabel distanceLabel;
	
	private JPanel buttonPanel;
	private JPanel inputPanel;
	private JPanel listPanel;
	private JScrollPane scrollPane;
	private JList<String> fromSpotNamesList;
	private JList<String> toSpotNamesList;
	private DefaultListModel dlm = new DefaultListModel();
	
	MapStart main;
	private Map map;
	private ArrayList<Integer> count = new ArrayList<Integer>();
	private ArrayList<String> spotNames = new ArrayList<String>();
	private ArrayList<Spot> SpotList = new ArrayList<Spot>();
	//private ArrayList<Distance> distanceList = new ArrayList<Distance>();
	private HashMap<Integer,Distance> distanceList = new HashMap<Integer, Distance>();
	private int[][] distance2DArray;
	//private ArrayList<ArrayList<Integer>> distance2DArray;
	//private ArrayList<Integer>distance1DArray;
	
	
	public MapPanel(){
		map = new Map();
		distance2DArray = new int[10000][10000];
		//distance1DArray = new ArrayList<ArrayList>
		//distance2DArray =new ArrayList<ArrayList<Integer>>();
		//SpotList = map.getSpotList();
		//distanceList = map.getDistanceList();
		spotUpData();
		init();
	}
	public void init(){

		SpotList = map.getSpotList();
		//distanceList = map.getDistanceList();
		this.setLayout(new GridLayout(3,1));
		
		addButton = new JButton();
		delet = new JButton();
		edit = new JButton();
		xInput = new JTextField(5);
		yInput = new JTextField(5);
		xLabel = new JLabel();
		yLabel = new JLabel();
		nameInput = new JTextField(5);
		nameLabel = new JLabel();
		toNumberLabel = new JLabel();
		toNumberInput = new JTextField(5);
		distanceLabel = new JLabel();
		distanceInput = new JTextField(5);
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,50,30));
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,50));
		inputPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		listPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,5));
		listPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		addButton.setText("Add");
		addButton.setHorizontalAlignment(addButton.CENTER);
		addButton.setVerticalAlignment(addButton.CENTER);
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//int x = 0;
				//int y = 0;
				int distance = 0;
				int to = 0;
				boolean exit = false;
				Spot spot = new Spot();
				
				
				System.out.println(0);
				try{
				//	x = Integer.parseInt(xInput.getText());
				//	y = Integer.parseInt(yInput.getText());
					if(!fromSpotNamesList.isSelectionEmpty())
						to = fromSpotNamesList.getSelectedIndex();
					//fromSpotNamesList.getSelectedIndices();
					else
						to = -1;
//					try{
//						distance = Integer.parseInt(distanceInput.getText());
//					}catch(Exception e1){
//						JOptionPane.showMessageDialog(null, "Please input integer value","error",JOptionPane.ERROR_MESSAGE);
//						distance = -1;
//					}
				}
				catch(NumberFormatException exception){
					exception.printStackTrace();
				}
				if(!SpotList.isEmpty()){
					for(Spot item: SpotList){
						if(item.getSpotName().equals(nameInput.getText())){
							exit = true;
							break;
						}
					}
				}
				
				if(!exit){
					System.out.println(SpotList.size());
					spot.setSpotName(nameInput.getText());
//					if(count.isEmpty())
//						spot.setSpotIndex(SpotList.size());
//					else{
//						spot.setSpotIndex(count.get(0));
//						count.remove(0);
//						Collections.sort(count);
//						
//					}
					spot.setSpotIndex(SpotList.size());
					for(int i = 0; i<=SpotList.size();i++){
						distance2DArray[i][spot.getSpotIndex()] = -1;
						distance2DArray[spot.getSpotIndex()][i] = -1;
					
					}
					SpotList.add(spot.getSpotIndex(),spot);
					
					spotUpData();
/*					if(to != -1){
						Distance distanceE = new Distance();
						distanceE.addSpot(SpotList.get(to), distance);
						System.out.println("to : "+to+"name : "+spotNames.get(to)+"distance : "+distance);
						
						distanceList.put(spot.getSpotIndex(), distanceE);
						//distanceList.add(spot.getSpotIndex(), distanceE);
					}*/
		
					main.addPoint(SpotList.indexOf(spot),spot);
					
				}
				else{
					JOptionPane.showMessageDialog(MapPanel.this, "This spot has exited","error", JOptionPane.ERROR_MESSAGE, null);
				}
				
			}
			});
		//this.add(addButton);
		buttonPanel.add(addButton);
		delet.setText("Del");
		delet.setHorizontalAlignment(delet.CENTER);
		delet.setVerticalAlignment(delet.CENTER);
		delet.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){	
				System.out.println(seleterText);
				boolean exit = false;
				Spot spot = new Spot();
				
				if(!SpotList.isEmpty()){
					for(Spot item: SpotList){
						//if(item.getSpotName().equals(nameInput.getText())){
						if(item.getSpotName().equals(seleterText)){
							exit = true;
							spot = item;
							
							main.deletPoint(spot);
							
							
							distanceList.remove(SpotList.indexOf(spot));
							//for(Distance distance: distanceList){
							//	if(distance.getDistance().containsKey(item))
							//		distance.getDistance().remove(item);
							//}
							SpotList.remove(item);
							count.add(item.getSpotIndex());
							Collections.sort(count);
							spotUpData();
							//13.20
							//while(distanceList.)
							break;
						}
					}
				}
				
			}
			});
		//this.add(delet);
		buttonPanel.add(delet);
		edit.setText("Edit");
		edit.setHorizontalAlignment(edit.CENTER);
		edit.setVerticalAlignment(edit.CENTER);
		edit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){	
				int distance = 0;
				int from = 0;
				int[] to;
				System.out.println(0);
				boolean exit = false;
				Spot spot = new Spot();
				if(fromSpotNamesList.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "Please select a in the from table.","error",JOptionPane.ERROR_MESSAGE);
				}
				else if(toSpotNamesList.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "Please select a in the to table.","error",JOptionPane.ERROR_MESSAGE);
				}
				else if(toSpotNamesList.getSelectedIndex()==fromSpotNamesList.getSelectedIndex()){
					JOptionPane.showMessageDialog(null, "Please select difference in the to table.","error",JOptionPane.ERROR_MESSAGE);
				}
				else{
					try{
						//to = Integer.parseInt(toNumberInput.getText());
						from = fromSpotNamesList.getSelectedIndex();
						to = toSpotNamesList.getSelectedIndices();
						for(int i:to){
							distance2DArray[from][i] = Integer.parseInt(distanceInput.getText());
							distance2DArray[i][from] = Integer.parseInt(distanceInput.getText());
						
						}
						for(int i = 0; i<spotNames.size();i++){
							for(int j = 0; j<spotNames.size(); j++){
								System.out.printf("%d ",distance2DArray[i][j]);
							}
							System.out.println("");
						}
						
					}
					catch(NumberFormatException exception){
			
						exception.printStackTrace();
					}
				
					
				}
				
//				if(!SpotList.isEmpty()){
//					for(Spot item: SpotList){
//						//if(item.getSpotName().equals(nameInput.getText())){
//						if(item.getSpotName().equals(seleterText)){
//							
//							exit = true;
//							spot = item;
//							break;
//						}
//					}
//				}
//				if(exit){
//					int index = spot.getSpotIndex();
//					Distance distanceE = distanceList.get(index);
//					Spot toSpot = SpotList.get(to);
//					distanceE.getDistance().put(toSpot, distance);
//					distanceList.put(index, distanceE);
//					//distanceList.set(index, distanceE);
//				}				
			}
			});
		//this.add(edit);
		buttonPanel.add(edit);
		this.add(buttonPanel);
		xLabel.setText("x : ");
		xLabel.setHorizontalAlignment(xLabel.CENTER);
		xLabel.setVerticalAlignment(xLabel.CENTER);
		//this.add(xLabel);
		//inputPanel.add(xLabel);
		
		//xInput.setHorizontalAlignment(xInput.CENTER);
		//this.add(xInput);
		//yLabel.setText("y : ");
		//yLabel.setHorizontalAlignment(yLabel.CENTER);
		//yLabel.setVerticalAlignment(yLabel.CENTER);
		//this.add(yLabel);
		//xInput.setHorizontalAlignment(yInput.CENTER);
		//this.add(yInput);
		nameLabel.setText("name : ");
		nameLabel.setForeground(Color.white);
		nameLabel.setHorizontalAlignment(nameLabel.CENTER);
		nameLabel.setVerticalAlignment(nameLabel.CENTER);
		//this.add(nameLabel);
		inputPanel.add(nameLabel);
		nameInput.setHorizontalAlignment(nameInput.CENTER);
		//this.add(nameInput);
		inputPanel.add(nameInput);
		inputPanel.setBackground(Color.black);
		//toNumberLabel.setText("to : ");
		//toNumberLabel.setHorizontalAlignment(toNumberLabel.CENTER);
		//toNumberLabel.setVerticalAlignment(toNumberLabel.CENTER);
		//this.add(toNumberLabel);
		//toNumberInput.setHorizontalAlignment(toNumberInput.CENTER);
		//this.add(toNumberInput);
		
		distanceLabel.setText("distanceInput : ");
		distanceLabel.setHorizontalAlignment(distanceLabel.CENTER);
		distanceLabel.setVerticalAlignment(distanceLabel.CENTER);
		distanceLabel.setForeground(Color.white);
		//this.add(distanceLabel);
		inputPanel.add(distanceLabel);
		distanceInput.setHorizontalAlignment(distanceInput.CENTER);
		//this.add(distanceInput);
		inputPanel.add(distanceInput);
		this.add(inputPanel);
		fromNumberLabel= new JLabel();
		fromNumberLabel.setText("from : ");
		listPanel.add(fromNumberLabel);
		
		fromSpotNamesList = new JList<String>(dlm);
		fromSpotNamesList.setFixedCellWidth(140);
		fromSpotNamesList.setFixedCellHeight(13);
		fromSpotNamesList.setVisibleRowCount(5);
		fromSpotNamesList.addMouseListener(new ListMouseAdapter(this));
		fromSpotNamesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane = new JScrollPane(fromSpotNamesList);
		//scrollPane.setSize(new Dimension(200,75));
		listPanel.add(scrollPane);
		
		
		toNumberLabel = new JLabel();
		toNumberLabel.setText("to : ");
		listPanel.add(toNumberLabel);
		toSpotNamesList = new JList<String>(dlm);
		toSpotNamesList.setFixedCellWidth(140);
		toSpotNamesList.setFixedCellHeight(13);
		toSpotNamesList.setVisibleRowCount(5);
		toSpotNamesList.addMouseListener(new ListMouseAdapter(this));
		fromSpotNamesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listPanel.add(new JScrollPane(toSpotNamesList));
		
		
		this.add(listPanel);
		
	}
	public void spotUpData(){
		int count = 0;
		spotNames.clear();
		if(!dlm.isEmpty())
			dlm.removeAllElements();
		if(!SpotList.isEmpty()){
			for(Spot item : SpotList){
				spotNames.add(count,item.getSpotName());
				count++;
				dlm.addElement(item.getSpotName());
			}
			
			fromSpotNamesList.setModel(dlm);
			toSpotNamesList.setModel(dlm);
		}
		//map.setSpotList(SpotList);
		//fromSpotNamesList.removeAll();
		
	}
	
	
	public void listMouseClicked(MouseEvent e){
		seleterText = (String)fromSpotNamesList.getSelectedValue();
	}
	
	
	public Dimension getMinimumSize(){
		return getPreferredSize();
	}
	public Dimension getPreferredSize(){
		return new Dimension(200,600);
	}
	public void addComponent(JLabel item){
		this.add(item);
	}
	
	public void setMainFrame(MapStart map){
		this.main = map;
	}
	public void deletComponent(JLabel item){
		this.remove(item);
	}
	public void paintComponent(Graphics g){
//		super.paintComponent(g);
//		Graphics2D g2 = (Graphics2D) g;
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
//		for(int i = 1;i<3;i++){
//			Line2D lin = new Line2D.Float((float)( (i-1)*30),(float)((i-1)*30),(float)(i*30),(float)(i*30));
//			g2.draw(lin);
//		}
	}
	
}
class ListMouseAdapter extends MouseAdapter{
	public MapPanel atm;
	
	public ListMouseAdapter(MapPanel atm){
		this.atm = atm;
	}
	public void mouseClicked(MouseEvent e){
		atm.listMouseClicked(e);
	}
}