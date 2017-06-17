import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class Frog extends JPanel implements KeyListener{
	private int x,y,w,h;
	private Rectangle frog;

	Frog(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		frog=new Rectangle(x,y,w,h);
	}
	public void render(Graphics g){
		Graphics2D g2d=(Graphics2D)g;
		g2d.fill(frog);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();

		if (key==KeyEvent.VK_RIGHT) {
			if(frog.getMaxX()+1*Display.GRID<Display.WIDTH)
				x=x+1*Display.GRID;
			frog.setLocation(x, y);
		}
		else if(key==KeyEvent.VK_LEFT) {
			if(frog.getMaxX()-1*Display.GRID>0)
				x=x-1*Display.GRID;
			frog.setLocation(x, y);
		}
		else if(key==KeyEvent.VK_UP) {
			if(frog.getMaxY()-1*Display.GRID>0)
			y=y-1*Display.GRID;
			frog.setLocation(x, y);
		}
		else if(key==KeyEvent.VK_DOWN) {
			if(frog.getMaxY()+1*Display.GRID<Display.HEIGHT)
			y=y+1*Display.GRID;
			frog.setLocation(x, y);
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
}
