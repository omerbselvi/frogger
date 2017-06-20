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

	Frog(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		frog=new Rectangle(x,y,w,h);
		try {
			image= ImageIO.read(getClass().getResourceAsStream("/frog.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void render(Graphics g){
		Graphics2D g2d=(Graphics2D)g;
		//g2d.fill(frog);
		g2d.drawImage(image,frog.x,frog.y,null);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();

		if (key==KeyEvent.VK_RIGHT) {
			if(frog.getMaxX()+1*Display.GRID<Display.WIDTH)
				frog.x=frog.x+1*Display.GRID;
			frog.setLocation(frog.x, frog.y);
			try {
				image= ImageIO.read(getClass().getResourceAsStream("/frog_right.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(key==KeyEvent.VK_LEFT) {
			if(frog.getMaxX()-1*Display.GRID>0)
				frog.x=frog.x-1*Display.GRID;
			frog.setLocation(frog.x, frog.y);
			try {
				image= ImageIO.read(getClass().getResourceAsStream("/frog_left.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(key==KeyEvent.VK_UP) {
			if(frog.getMaxY()-1*Display.GRID>0)
				frog.y=frog.y-1*Display.GRID;
			frog.setLocation(frog.x, frog.y);
			try {
				image= ImageIO.read(getClass().getResourceAsStream("/frog.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(key==KeyEvent.VK_DOWN) {
			if(frog.getMaxY()+1*Display.GRID<Display.HEIGHT)
				frog.y=frog.y+1*Display.GRID;
			frog.setLocation(frog.x, frog.y);
			try {
				image= ImageIO.read(getClass().getResourceAsStream("/frog_front.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
