import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Frog extends JPanel implements KeyListener{
	private int x,y,w,h;
	private Rectangle frog;
	private BufferedImage image;
	private String sprite;
	

	Frog(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		frog=new Rectangle(x,y,w,h);
		changeSprite("/frog.png");
		
	}
	public void render(Graphics g){
		Graphics2D g2d=(Graphics2D)g;
		//g2d.fill(frog);
		g2d.drawImage(image,frog.x,frog.y,null);
	}
	public void mover(int speed){
		frog.x=frog.x+speed;
	}
	public void stopMove(){
		mover(0);
	}
	public int roundTo(int number){
		return number - (number%50);
	}
	
	public void changeSprite(String sprite){
		this.sprite=sprite;
		try {
			image= ImageIO.read(getClass().getResourceAsStream(sprite));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public boolean state(){
		return Display.state==Display.STATE.GAME;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(state()){
			int key=e.getKeyCode();
			if (key==KeyEvent.VK_RIGHT) {
				if(frog.getMaxX()+1*Display.GRID<Display.WIDTH&&sprite=="/frog_right.png"){
					frog.x=frog.x+1*Display.GRID;
					frog.setLocation(frog.x, frog.y);			
				}
				else{
					changeSprite("/frog_right.png");
				}
			}
			else if(key==KeyEvent.VK_LEFT) {
				if(frog.getMaxX()-1*Display.GRID>0&&sprite=="/frog_left.png"){
					frog.x=frog.x-1*Display.GRID;
					frog.setLocation(frog.x, frog.y);
				}
				else{
					changeSprite("/frog_left.png");
				}
			}
			else if(key==KeyEvent.VK_UP) {
				if(frog.getMaxY()-1*Display.GRID>0){
					frog.y=frog.y-1*Display.GRID;
					if(frog.x%50==0)
						frog.setLocation(frog.x, frog.y);
					else{
						frog.setLocation(roundTo(frog.x), frog.y);
					}
					changeSprite("/frog.png");
				}
			}
			else if(key==KeyEvent.VK_DOWN) {
				if(frog.getMaxY()+1*Display.GRID<Display.HEIGHT){
					frog.y=frog.y+1*Display.GRID;
					if(frog.x%50==0)
						frog.setLocation(frog.x, frog.y);
					else{
						frog.setLocation(roundTo(frog.x), frog.y);
					}
					changeSprite("/frog_front.png");
				}
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public Rectangle getFrog() {
		return frog;
	}
	public void setFrog(Rectangle frog) {
		this.frog = frog;
	}
	
}
