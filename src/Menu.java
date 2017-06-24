import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;




public class Menu implements MouseMotionListener,MouseListener,KeyListener{
	private Rectangle playButton;
	private Rectangle helpButton;
	private Rectangle helpBackButton;
	private Rectangle quitButton;
	private BufferedImage image[];
	private BufferedImage map;
	private Color playButtonColor;
	private Color helpButtonColor;
	private Color helpBackButtonColor;
	private Color quitButtonColor;
	private Font font;
	private Font font2;
	private int randX[];
	private int randY[];
	private int randRadian[];
	Menu(){
		playButton= new Rectangle(235, 110, 119, 55);
		helpButton= new Rectangle(240, 210, 110, 55);
		quitButton= new Rectangle(240, 310, 110, 55);
		helpBackButton= new Rectangle(215, 290, 135, 55);
		image= new BufferedImage[10];
		menuFaces();
		loadMap();
		randX= new int[10];
		randY= new int[10];
		randRadian= new int[10];
		randomNumbers();
	}
	public void randomNumbers(){
		Random rand= new Random();
		for (int i = 0; i < 10; i++) {
			randRadian[i]=rand.nextInt(360);
			randX[i]=rand.nextInt(450);
			randY[i]=rand.nextInt(400);
		}
	}
	public void menuFaces(){
		try {
			for (int i = 0; i < image.length; i++) {
				image[i]= ImageIO.read(getClass().getResourceAsStream("/frog_face.png"));
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void drawFaces(Graphics2D g2d){		
		for (int i = 0; i < image.length; i++) {
			AffineTransform at = AffineTransform.getTranslateInstance(randX[i], randY[i]);
			if(i%2==0)
				at.rotate(Math.toRadians(randRadian[i]++),image[i].getWidth()/2,image[i].getHeight()/2);
			else
				at.rotate(Math.toRadians(randRadian[i]--),image[i].getWidth()/2,image[i].getHeight()/2);
			g2d.drawImage(image[i], at, null);
			if(randRadian[i]==360||randRadian[i]==-360)
				randRadian[i]=0;
		}
	}
	public void render(Graphics g){
		Graphics2D g2d= (Graphics2D)g;
		if(Display.state==Display.STATE.MENU){
			font= new Font("Century Gothic",Font.BOLD,50);
			g2d.setFont(font);
			g2d.drawImage(map, 0, 0, null);
			drawFaces(g2d);
			
			g2d.setColor(playButtonColor);
			g2d.draw(playButton);
			g2d.drawString("PLAY", playButton.x, playButton.y+47);

			g2d.setColor(helpButtonColor);
			g2d.draw(helpButton);
			g2d.drawString("HELP", helpButton.x, helpButton.y+47);

			g2d.setColor(quitButtonColor);
			g2d.draw(quitButton);
			g2d.drawString("QUIT", quitButton.x, quitButton.y+47);
		}
		if(Display.state==Display.STATE.HELP){
			g2d.drawImage(map, 0, 0, null);
			drawFaces(g2d);
			g2d.setColor(Color.RED);
			font2= new Font("Century Gothic",Font.BOLD,20);
			g2d.setFont(font2);
			g2d.drawString("USE ARROW KEYS TO PLAY,ESC TO QUIT", 110, helpButton.y);
			g2d.setColor(helpBackButtonColor);
			g2d.draw(helpBackButton);
			g2d.setFont(font);
			g2d.drawString("BACK", helpBackButton.x, helpBackButton.y+47);
		}		
	}
	public void loadMap(){
		try {
			map= ImageIO.read(getClass().getResourceAsStream("/menu.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public boolean isInsideRect(Rectangle button,int x,int y){
		return ( x >= button.getMinX() && x <= button.getMaxX() ) && ( y >= button.getMinY() && y <= button.getMaxY());
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int mouseX=e.getX();
		int mouseY=e.getY();
		if(isInsideRect(playButton,mouseX,mouseY)&&Display.state==Display.STATE.MENU){
			Display.state=Display.STATE.GAME;
		}
		else if(isInsideRect(helpButton,mouseX,mouseY)&&Display.state==Display.STATE.MENU){
			Display.state=Display.STATE.HELP;
		}
		else if(isInsideRect(quitButton, mouseX, mouseY)&&Display.state==Display.STATE.MENU){
			System.exit(1);
		}
		
		
		if(Display.state==Display.STATE.HELP&&isInsideRect(helpBackButton, mouseX, mouseY)){
			Display.state=Display.STATE.MENU;
		}
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
		int mouseX=e.getX();
		int mouseY=e.getY();
		
		if(isInsideRect(playButton,mouseX,mouseY)){
			playButtonColor=Color.RED;
		}
		else{
			playButtonColor=Color.BLACK;
		}
		if(isInsideRect(helpButton, mouseX, mouseY)){
			helpButtonColor=Color.ORANGE;
		}
		else{
			helpButtonColor=Color.BLACK;
		}
		if(isInsideRect(quitButton, mouseX, mouseY)){
			quitButtonColor=Color.GREEN;
		}
		else{
			quitButtonColor=Color.BLACK;
		}
		if(isInsideRect(helpBackButton, mouseX, mouseY)){
			helpBackButtonColor=Color.PINK;
		}
		else{
			helpBackButtonColor=Color.BLACK;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keycode=e.getKeyCode();
		if(keycode == KeyEvent.VK_ESCAPE)
		    {
			 	System.exit(1);
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
