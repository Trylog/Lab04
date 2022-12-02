package pkgMain;


import pkgModel.Maszyna;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Kanwa extends JPanel {
	public Maszyna m;

	public Kanwa(){
		this.setBounds(0,0,800,800);
		this.setLayout(null);
		m=new Maszyna(200,300,-240,50);

	}
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);

		if (m != null) {
			m.rysuj((Graphics2D) arg0);
		}
	}
}