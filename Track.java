package Kaws;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Track extends JPanel implements ActionListener, Runnable {
	
	Timer mainTimer = new Timer(20, this);
	
	Player p = new Player();
	
	//Image img = new ImageIcon("Res/Track.png").getImage();
	Image img = new ImageIcon("Res/Track.png").getImage();
	
	Thread BotSpawner = new Thread(this);
	
	Thread Audio = new Thread(new Audio());
	
	List<Bot> Bots = new ArrayList<Bot>();
	
	double x=0;
	double y=0;
	
	int[] Lanes ={55, 200, 345, 490};
	
	public Track(){
		mainTimer.start();
		BotSpawner.start();
		Audio.start();
		addKeyListener(new MyKeyAdapter());
		setFocusable(true);
	}
	
	private class MyKeyAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			p.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e) {
			p.keyReleased(e);
		}
	}
	
	public void paint(Graphics g){
		g=(Graphics2D) g;
		g.drawImage(img, 0, (int)p.y, null);
		g.drawImage(img, 0, (int)p.y2, null);
		g.drawImage(p.img, (int)p.x, 700, null);
		
		g.setColor(Color.RED);
		Font fnt = new Font("Arial", Font.ITALIC, 18);
		g.setFont(fnt);
		g.drawString("Speed:"+(int)(p.vy*4)+"km/h", 30, 800);
		
		Iterator<Bot> i= Bots.iterator();
		while(i.hasNext()) {
			Bot b= i.next();
			if(b.y <=-2400){
				i.remove();
			} 
			else {
				b.Accelerate(p.vy);
				g.drawImage(b.img, (int)b.x,  (int)b.y,  null);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		p.Accelerate();
		repaint();
		CheckCollision();
	}
	
	public void CheckCollision(){
		Iterator<Bot> i= Bots.iterator();
		while(i.hasNext()) {
			Bot b=i.next();
			if(p.getRectangle().intersects(b.getRectangle()))
				p.FullStop((int)p.s);
		}
	}
	
	public void run() {
		while(true) {
			Random rand = new Random();
			try {
				Thread.sleep(rand.nextInt(1500));
				Bots.add(new Bot(Lanes[rand.nextInt(4)], -500, (double)rand.nextInt(30)));
			}
			catch (InterruptedException e){
				e.printStackTrace();
				
				//
			}
		}
	}
}
