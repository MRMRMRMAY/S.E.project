package controller.moder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class MapPanel extends JPanel{
	private int c = 0;
	private JFrame parentWindow;
	private JButton add ;
	private JButton delet;
	private JButton edit ;
	private JTextField selet;
	public MapPanel(JFrame window){
		parentWindow = window;
		init();
	}
	public void init(){
		JButton add = new JButton();
		JButton delet = new JButton();
		JButton edit = new JButton();
		add.setText("Add");
		add.setHorizontalAlignment(add.CENTER);
		add.setVerticalAlignment(add.CENTER);
		this.add(add);
		delet.setText("Del");
		delet.setHorizontalAlignment(delet.CENTER);
		delet.setVerticalAlignment(delet.CENTER);
		this.add(delet);
		edit.setText("Edit");
		edit.setHorizontalAlignment(edit.CENTER);
		edit.setVerticalAlignment(edit.CENTER);
		this.add(edit);
		selet = new JTextField(10);
		selet.setText("No.place");
		this.add(selet);
		
	}
	public Dimension getMinimumSize(){
		return getPreferredSize();
	}
	public Dimension getPreferredSize(){
		return new Dimension(600,300);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		MapData data = new MapData();
		if(!data.point.isEmpty())
		for(Point item:data.point){
			g.setColor(Color.blue);
			g.fillOval(item.getX(),item.getY(),10,10);
			if(!item.getTo().isEmpty()){
				for(int toNum: item.getTo()){
					Line2D line = new Line2D.Float((float)(item.getX()),(float)(item.getY()),
							(float)(data.point.get(toNum-1).getX()),(float)(data.point.get(toNum-1).getY()));
					g2.draw(line);
				}
			}
		}
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
