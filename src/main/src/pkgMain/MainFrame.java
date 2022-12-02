package pkgMain;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ChangeListener {
	Kanwa maszyna;
	Wykres w1,w2;
	JButton przycisk1;
	JLabel napisX, napisY, napisL1, napisL2, tytuł, napisW1, napisW2;
	JSlider suwakX, suwakY, suwakL1, suwakL2;
	MainFrame(){

		przycisk1=new JButton();
		przycisk1.setBounds(900,100,200,75);
		przycisk1.setText("Przycisk");
		przycisk1.setFocusable(false);

		tytuł=new JLabel("Maszyna");
		tytuł.setBounds(940,25,130,50);
		tytuł.setFont(new Font("Calibri", Font.PLAIN, 30));

		napisX =new JLabel("Współrzędna n");
		napisX.setBounds(950,100,100,25);
		suwakX =new JSlider(-400,400,0);
		suwakX.setBounds(850,125,300,50);
		suwakX.setPaintTicks(true);;
		suwakX.setPaintTrack(true);
		suwakX.setPaintLabels(true);
		suwakX.setMajorTickSpacing(100);
		suwakX.setMinorTickSpacing(25);
		suwakX.addChangeListener(this);

		napisY =new JLabel("Współrzędna h");
		napisY.setBounds(950,175,100,25);
		suwakY =new JSlider(-400,400,0);
		suwakY.setBounds(850,200,300,50);
		suwakY.setPaintTicks(true);;
		suwakY.setPaintTrack(true);
		suwakY.setPaintLabels(true);
		suwakY.setMajorTickSpacing(100);
		suwakY.setMinorTickSpacing(25);
		suwakY.addChangeListener(this);

		napisL1 =new JLabel("Długość L1");
		napisL1.setBounds(965,250,100,25);
		suwakL1 =new JSlider(0,800,0);
		suwakL1.setBounds(850,275,300,50);
		suwakL1.setPaintTicks(true);;
		suwakL1.setPaintTrack(true);
		suwakL1.setPaintLabels(true);
		suwakL1.setMajorTickSpacing(100);
		suwakL1.setMinorTickSpacing(25);
		suwakL1.addChangeListener(this);

		napisL2 =new JLabel("Długość L2");
		napisL2.setBounds(965,325,100,25);
		suwakL2 =new JSlider(0,800,0);
		suwakL2.setBounds(850,350,300,50);
		suwakL2.setPaintTicks(true);;
		suwakL2.setPaintTrack(true);
		suwakL2.setPaintLabels(true);
		suwakL2.setMajorTickSpacing(100);
		suwakL2.setMinorTickSpacing(25);
		suwakL2.addChangeListener(this);

		maszyna =new Kanwa();

		napisW1=new JLabel("Wykres X:");
		napisW1.setBounds(965,400,100,25);
		w1=new Wykres(maszyna.m.tablica,true,425);

		napisW2=new JLabel("Wykres Y:");
		napisW2.setBounds(965,575,100,25);
		w2=new Wykres(maszyna.m.tablica,false,600);

		this.setSize(new Dimension(1200,800));
		this.setTitle("Maszyna");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(maszyna);
		this.add(w1);
		this.add(w2);
		//this.pack();
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		//this.add(przycisk1);
		this.add(tytuł);
		this.add(napisX);
		this.add(suwakX);
		this.add(napisY);
		this.add(suwakY);
		this.add(napisL1);
		this.add(suwakL1);
		this.add(napisL2);
		this.add(suwakL2);
		this.add(napisW1);
		this.add(napisW2);

	}
	public void animate() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				while (true){
				int i = 360;
				while (i>0) {
					maszyna.m.obróć();
					maszyna.repaint();
					w1.repaint();
					w2.repaint();
					i--;
					try {
						Thread.sleep(20);
					} catch (Exception e) {
					}
				}
				System.out.println("Animation stopped");}
			}
		});
		t.start();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==suwakX){
			maszyna.m.d=suwakX.getValue();
		}
		if(e.getSource()==suwakY){
			maszyna.m.h=suwakY.getValue();
		}
		if(e.getSource()==suwakL1){
			maszyna.m.l1=suwakL1.getValue();
		}
		if(e.getSource()==suwakL2){
			maszyna.m.l2=suwakL2.getValue();
		}
	}
}
