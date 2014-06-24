package Kaws;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Bot extends Car {
	public Bot(double x, double y, double vy){
		img = new ImageIcon("Res/Car.png").getImage();
		this.x=x;
		this.y=y;
		this.vy=vy;
		
		
	}
	
	public void Accelerate(double PlayerV){
		if(x<Middle){
			y+=PlayerV+vy;
			img = new ImageIcon("Res/CarReverse.png").getImage();
		}
		else
			y+=PlayerV-vy;
	}
	
	
}
