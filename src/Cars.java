import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cars {
	private Rectangle car;
	private int speed,x,y,w,h;
	private BufferedImage image;
	
	Cars(int x,int y,int w,int h,int speed){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.speed=speed;
		if(speed>0){
			changeSprite("/car_right.png");
		}else{
			changeSprite("/car_left.png");
		}
		car=new Rectangle(x,y,w,h);
	}
	public void changeSprite(String sprite){
		try {
			image= ImageIO.read(getClass().getResourceAsStream(sprite));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void render(Graphics g){
		Graphics2D g2d= (Graphics2D)g;
		g2d.drawImage(image, car.x, car.y, null);
		//g2d.fill(car);
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
