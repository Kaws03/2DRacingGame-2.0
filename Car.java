package Kaws;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class Car {
	Image img, img_l, img_c, img_r;
	double x, y, y2;
	double vx, vy=10;
	double dx, dy;
	double s;
	double LeftPoint=10, RightPoint=530, Middle=270;
	
	public Rectangle getRectangle(){
		return new Rectangle((int)x, (int)y, 28, 53);
	}
	
	public void ChangeTex(int Direction){
		if(Direction==0)
			img=img_l;
		if(Direction==1)
			img=img_c;
		if(Direction==2)
			img=img_r;
		
	}
	
	public void FullStop(int Score){
		vy=0;
		vx=0;
		dy=0;
		dx=0;
		JOptionPane.showMessageDialog(null, "You loose :(\n"+"Your score:"+Score);
		System.exit(1);
	}
}
