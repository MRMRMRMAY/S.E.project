package server.problemdomain.manager.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpotPanel extends JPanel{
	
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
}
