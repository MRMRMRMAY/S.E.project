package controller.moder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MainApp;
public class MapPanel extends JPanel{
	private MainApp mainApp = new MainApp();
	private int c = 0;
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
	private JLabel distanceLabel;
	MapStart main;
	static ArrayList<Spot> SpotList = new ArrayList<Spot>();
	static ArrayList<Distance> distanceList = new ArrayList<Distance>();
	static Map map = new Map();
	public MapPanel(JFrame window){
		parentWindow = window;
		init();
	}
	public void init(){
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
		addButton.setText("Add");
		addButton.setHorizontalAlignment(addButton.CENTER);
		addButton.setVerticalAlignment(addButton.CENTER);
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int x = 0;
				int y = 0;
				int distance = 0;
				int to = 0;
				boolean exit = false;
				Spot spot = new Spot();
				
				
				System.out.println(0);
				try{
					x = Integer.parseInt(xInput.getText());
					y = Integer.parseInt(yInput.getText());
					to = Integer.parseInt(toNumberInput.getText());
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
					spot.setSpotName(nameInput.getText());
					spot.setSpotIndex(SpotList.size());
					SpotList.add(spot);
					Distance distanceE = new Distance();
					distanceE.addSpot(SpotList.get(to), distance);
					distanceList.add(spot.getSpotIndex(), distanceE);
					if(x>=0&&x<=400&&y>=0&&y<=700){
						main.addPoint(x,y,spot);
					}
					else{
						mainApp.showDialog("Input 0<=x<=400 and 0<=y<=700","InputError" );
					}
					
				}
				else{
					mainApp.showDialog("spot exited","spot exited" );
				}
			}
			});
		this.add(addButton);
		delet.setText("Del");
		delet.setHorizontalAlignment(delet.CENTER);
		delet.setVerticalAlignment(delet.CENTER);
		delet.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){	
				System.out.println(0);
				boolean exit = false;
				Spot spot = new Spot();
				
				if(!SpotList.isEmpty()){
					for(Spot item: SpotList){
						if(item.getSpotName().equals(nameInput.getText())){
							exit = true;
							spot = item;
							main.deletPoint(spot);
							SpotList.remove(item);
						}
					}
				}
				
			}
			});
		this.add(delet);
		edit.setText("Edit");
		edit.setHorizontalAlignment(edit.CENTER);
		edit.setVerticalAlignment(edit.CENTER);
		edit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){	
				int distance = 0;
				int to = 0;
				System.out.println(0);
				boolean exit = false;
				Spot spot = new Spot();
				try{
					to = Integer.parseInt(toNumberInput.getText());
				}
				catch(NumberFormatException exception){
					exception.printStackTrace();
				}
				
				if(!SpotList.isEmpty()){
					for(Spot item: SpotList){
						if(item.getSpotName().equals(nameInput.getText())){
							exit = true;
							spot = item;
							break;
						}
					}
				}
				if(exit){
					int index = spot.getSpotIndex();
					Distance distanceE = distanceList.get(index);
					Spot toSpot = SpotList.get(to);
					distanceE.getDistance().replace(toSpot, distance);
					distanceList.set(index, distanceE);
				}				
			}
			});
		this.add(edit);
		xLabel.setText("x : ");
		xLabel.setHorizontalAlignment(xLabel.CENTER);
		xLabel.setVerticalAlignment(xLabel.CENTER);
		this.add(xLabel);
		xInput.setHorizontalAlignment(xInput.CENTER);
		this.add(xInput);
		yLabel.setText("y : ");
		yLabel.setHorizontalAlignment(yLabel.CENTER);
		yLabel.setVerticalAlignment(yLabel.CENTER);
		this.add(yLabel);
		xInput.setHorizontalAlignment(yInput.CENTER);
		this.add(yInput);
		nameLabel.setText("name : ");
		nameLabel.setHorizontalAlignment(nameLabel.CENTER);
		nameLabel.setVerticalAlignment(nameLabel.CENTER);
		this.add(nameLabel);
		nameInput.setHorizontalAlignment(nameInput.CENTER);
		this.add(nameInput);
		
		toNumberLabel.setText("to : ");
		toNumberLabel.setHorizontalAlignment(toNumberLabel.CENTER);
		toNumberLabel.setVerticalAlignment(toNumberLabel.CENTER);
		this.add(toNumberLabel);
		toNumberInput.setHorizontalAlignment(toNumberInput.CENTER);
		this.add(toNumberInput);
		
		distanceLabel.setText("distanceInput : ");
		distanceLabel.setHorizontalAlignment(distanceLabel.CENTER);
		distanceLabel.setVerticalAlignment(distanceLabel.CENTER);
		this.add(distanceLabel);
		distanceInput.setHorizontalAlignment(distanceInput.CENTER);
		this.add(distanceInput);
		
	}
	
	public Dimension getMinimumSize(){
		return getPreferredSize();
	}
	public Dimension getPreferredSize(){
		return new Dimension(800,400);
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
