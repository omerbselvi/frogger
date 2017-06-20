import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Logs {
	private int x,y,w,h,speed;
	private Rectangle log;
	Logs(int x,int y,int w,int h,int speed){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.speed=speed;
		log=new Rectangle(x,y,w,h);
	}
	
	public void render(Graphics g){
		Graphics2D g2d= (Graphics2D)g;
		g2d.fill(log);
		move();
		if(isOut()){
			if(log.x>=Display.WIDTH/2)
				log.x=-150;
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
	
}
