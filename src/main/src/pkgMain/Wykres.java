package pkgMain;

import pkgUtil.Kontener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Wykres extends JPanel {
	ArrayList<Kontener>tab;
	boolean xy;
	Wykres(ArrayList<Kontener> tab, boolean xy, int wysokość){
		this.setBounds(820,wysokość,360,150);

		this.setBackground(Color.cyan);
		this.setLayout(null);
		this.xy=xy;
		this.tab=tab;
	}
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);

		rysuj((Graphics2D) arg0);

	}
	void rysuj(Graphics2D wyk){
		this.setLayout(null);
		AffineTransform obraz =new AffineTransform();
		obraz.scale(1.25,1.25);
		obraz.translate(0,150);
		wyk.setTransform(obraz);
		//wyk.drawOval(20,0,20,20);
		if(tab.size()>0){
			int a=0;
			if(tab.size()>361)a=tab.size()/360;
			int b=0;
			for (int i =a*360;i<tab.size()-1;i++){
				if (xy){
					wyk.drawLine(b,0,b,-Math.abs(tab.get(i).a-tab.get(i+1).a)*5);
				}else{
					wyk.drawLine(b,0,b,-Math.abs(tab.get(i).b-tab.get(i+1).b)*5);
				}
				b++;
				if(b>360)b-=360;
			}
		}

	}
}
