package frogger;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Logs {
	private int x,y,w,h,speed;
	private Rectangle log;
	private BufferedImage image;
	
	Logs(int x,int y,int w,int h,int speed){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.speed=speed;
		try {
			image= ImageIO.read(getClass().getResourceAsStream("img/log.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log=new Rectangle(x,y,w,h);
	}
	
	public void render(Graphics g){
		Graphics2D g2d= (Graphics2D)g;
		//g2d.fill(log);
		g2d.drawImage(image, log.x, log.y,w,h, null);
		move();
		if(isOut()){
			if(log.x>=Display.WIDTH/2)
				log.x=-170;
			else if(log.x<Display.WIDTH/2)
				log.x=Display.WIDTH;
		}
	}
	public boolean isOut(){
		return log.getMinX()>=Display.WIDTH||log.getMaxX()<=0;
	}
	public void move(){
		log.x=log.x+speed;
	}
	public Rectangle getLog() {
		return log;
	}
	public void setLog(Rectangle log) {
		this.log = log;
	}
	public int getSpeed() {
		return speed;
	}

}
