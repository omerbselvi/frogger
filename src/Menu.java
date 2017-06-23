import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;



public class Menu implements MouseMotionListener,MouseListener{
	private Rectangle playButton;
	private Rectangle helpButton;
	private Rectangle quitButton;
	private BufferedImage image;

	Menu(){
		playButton= new Rectangle(240, 250, 100, 50);
		
		
		try {
			image= ImageIO.read(getClass().getResourceAsStream("/frog_front.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

//	int i=0;
	public void render(Graphics g){
		Graphics2D g2d= (Graphics2D)g;
		g2d.draw(playButton);
//		AffineTransform at = AffineTransform.getTranslateInstance(100, 100);
//		at.rotate(Math.toRadians(i++),image.getWidth()/2,image.getHeight()/2);
//		g2d.drawImage(image, at, null);
//		System.out.println(i);

	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Display.state=Display.STATE.GAME;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
