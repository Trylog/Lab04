//Michał Bernacki-Janson 264021

package pkgMain;

import javax.swing.*;

public class Main {
	public static void main(String[] args){
		//menu();

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				MainFrame frame =new MainFrame();
				frame.animate();
			}
		});
	}
	static void menu(){
		JFrame menu = new JFrame();
		menu.setTitle("Parametry pocz\u0105tkowe");
		menu.setSize(200,300);
		menu.setResizable(false);

		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setLayout(null);

		JTextField tL1, tL2, tD, tH;
		tL1=new JTextField();
		tL1.setBounds(50,20,100, 20);
		//tL1.setText("Podaj L1");


		menu.add(tL1);
		menu.setVisible(true);

	}
}
