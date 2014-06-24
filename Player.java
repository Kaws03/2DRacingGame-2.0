package Kaws;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player extends Car {
	
	public Player(){
		img_l = new ImageIcon("Res/CarLeft.png").getImage();
		img_c = new ImageIcon("Res/Car.png").getImage();
		img_r = new ImageIcon("Res/CarRight.png").getImage();
		
		img = img_c;
		x=345;
		y=0;
		y2=-1200;
	}
	
	double MaxV=50;
	

	public void Accelerate() {
		vx+=dx;
		vy+=dy;
		
		x+=vx;
		y+=vy;
		y2+=vy;
		
		s+=vy;
		
		if(vy<0){
			vy=0;
			dy=0;
		}
		
		if(y2>=0){
			y=0;
			y2=-1200;
		}
		
		vx*=0.95;
		vy*=0.995;
		
		if(vx>=5)
			vx=5;

		if(vx<=-5)
			vx=-5;
		
		if(vy>=MaxV)
			vy=MaxV;
		
		if(this.x>=RightPoint)
			FullStop((int)s/100);
		if(this.x<=LeftPoint)
			FullStop((int)s/100);
	}
	
	
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		if(key == KeyEvent.VK_UP)
			dy+=0.07;
		if(key == KeyEvent.VK_DOWN)
			dy-=0.09;
		if(key == KeyEvent.VK_LEFT){
			if(vx>0)
				vx=0;
			dx-=0.3;
			ChangeTex(0);
		}
		if(key == KeyEvent.VK_RIGHT){
			if(vx<0)
				vx=0;
			dx+=0.3;
			ChangeTex(2);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		if(key == KeyEvent.VK_UP)
			dy=0;
		if(key == KeyEvent.VK_DOWN)
			dy=0;
		if(key == KeyEvent.VK_LEFT||key == KeyEvent.VK_RIGHT){
			dx=0;
			ChangeTex(1);
		}
		
		
	}
}
