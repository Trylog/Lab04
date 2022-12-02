package pkgModel;


import pkgUtil.Kontener;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;

public class Maszyna{

	public int l1, l2, d, h, wielkość;
	public ArrayList<Kontener> tablica;
	public double alfa;

	public Maszyna(int l1, int l2, int d, int h){
		tablica =new ArrayList<>();
		this.l1=l1;
		this.l2=l2;
		this.d=d;
		this.h=h;
	}
	public void rysuj(Graphics2D g){
		Graphics2D obraz = g;
		//int sX = obraz.getClipBounds().width/2;
		//int sY =obraz.getClipBounds().height/2;


		AffineTransform układ = new AffineTransform();
		układ.scale(1.25,1.25);
		//System.out.println(układ.getScaleX());
		układ.translate(400,400);
		AffineTransform start=układ;
		układ.rotate(-alfa);

		obraz.setStroke(new BasicStroke(2));

		obraz.setTransform(układ);

		//obraz.drawOval(0,0,5,5);
		obraz.drawLine(0,0,l1,0);
		układ.translate(l1,0);
		//układ.rotate(alfa);
		obraz.setTransform(układ);
		Point2D pkt=new Point2D.Double(d,-h);
		Point2D out =new Point2D.Double();

		AffineTransform ramięT =new AffineTransform();

		ramięT.translate(-l1,0);
		ramięT.rotate(alfa);
		ramięT.transform(pkt,out);
		//obraz.setTransform(start);

		double p = Math.sqrt((out.getX()*out.getX())+(out.getY()*out.getY()));
		double s= l2/p;
		//System.out.println(s);
		//System.out.println(out.getX());
		//System.out.println(out.getY());


		obraz.drawLine((int)(out.getX()*s),(int)(out.getY()*s),0,0);
		obraz.setStroke(new BasicStroke(6));
		obraz.drawOval((int)(out.getX()-5), (int)(out.getY()-5),10,10);

		AffineTransform pozAbslT = new AffineTransform();
		Point2D pozZal=new Point2D.Double(out.getX()*s,out.getY()*s);
		Point2D pozAbsl=new Point2D.Double();
		pozAbslT.rotate(-alfa);
		pozAbslT.translate(l1,0);

		pozAbslT.transform(pozZal,pozAbsl);
		System.out.println(pozAbsl.getX());
		System.out.println(pozAbsl.getY());
		tablica.add(new Kontener((int)Math.round(pozAbsl.getX()), (int)Math.round(pozAbsl.getY())));

	}
	public void obróć(){
		alfa +=Math.PI/180;
	}

}
