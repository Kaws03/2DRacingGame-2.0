package Kaws;

import java.awt.FlowLayout;
import javax.swing.*;

public class Main {	
	public static void main(String[] args) {
		JFrame f=new JFrame("2DRacingGame");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(615, 900);
		f.add(new Track());
		f.setVisible(true);
	}

}
