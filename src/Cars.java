import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Cars {
	private Rectangle car;
	private int speed,x,y,w,h;
	
	Cars(int x,int y,int w,int h,int speed){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.speed=speed;
		car=new Rectangle(x,y,w,h);
	}
	public void render(Graphics g){
		Graphics2D g2d= (Graphics2D)g;
		g2d.fill(car);
		move();
		if(isOut()){
			if(car.x>500)
				car.x=-100;
			else if(car.x<500)
				car.x=Display.WIDTH;
		}
	}
	public void move(){
		car.x=car.x+speed;
	}
	public boolean isOut(){
		return car.getMinX()>=Display.WIDTH||car.getMaxX()<=0;
	}
	public Rectangle getCar() {
		return car;
	}
	public void setCar(Rectangle car) {
		this.car = car;
	}
	
}
