import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Display extends JPanel implements ActionListener{
	public static int GRID=50;
	public static int ERRORY=10;
	public static int ERRORX=16;
	public static int WIDTH=600+ERRORX;
	public static int HEIGHT=500-ERRORY;
	private Frog frog;
	private Cars cars1[];
	private Cars cars2[];
	private Logs logs1[];
	private Logs logs2[];
	private Logs logs3[];
	private int deaths=0;
	private int score=0;
	Display(){
		Timer timer= new Timer(16,this);
		frog= new Frog(250,HEIGHT-90,50,50);
		cars1= new Cars[2];
		cars2= new Cars[3];
		logs1= new Logs[2];
		logs2= new Logs[2];
		logs3= new Logs[2];
		for(int i=0;i<cars1.length;i++){
			cars1[i]= new Cars(0+i*290,HEIGHT-140,100,50,3);
		}
		for(int i=0;i<cars2.length;i++){
			cars2[i]= new Cars(0+i*270,HEIGHT-190,100,50,-2);
		}
		for(int i=0;i<logs1.length;i++){
			logs1[i]= new Logs(0+i*250,HEIGHT-290,150,50,+1);
		}
		for(int i=0;i<logs2.length;i++){
			logs2[i]= new Logs(0+i*300,HEIGHT-340,150,50,-3);
		}
		for(int i=0;i<logs3.length;i++){
		logs3[i]= new Logs(0+i*350,HEIGHT-390,150,50,+2);
		}
			
		
		this.addKeyListener(frog);
		setFocusable(true);
		timer.start();
	}
	public void didIntersectCar(){
		for(Cars car:cars1){
			if(frog.getFrog().getBounds().intersects(car.getCar().getBounds())){
				reset();
			}
		}
		for(Cars car:cars2){
			if(frog.getFrog().getBounds().intersects(car.getCar().getBounds())){
				reset();
			}
		}
	}
	public void isInsideLog(){
		if(frog.getFrog().getCenterY()<HEIGHT-240&&frog.getFrog().getCenterY()>HEIGHT-290){

				if(frog.getFrog().getMinX()>logs1[0].getLog().getMinX()&&frog.getFrog().getMaxX()<logs1[0].getLog().getMaxX()){
					
				}
				else if(frog.getFrog().getMinX()>logs1[1].getLog().getMinX()&&frog.getFrog().getMaxX()<logs1[1].getLog().getMaxX()){
					
				}
				else{
					reset();
				}
			
		}
		if(frog.getFrog().getCenterY()<HEIGHT-290&&frog.getFrog().getCenterY()>HEIGHT-340){

			if(frog.getFrog().getMinX()>logs2[0].getLog().getMinX()&&frog.getFrog().getMaxX()<logs2[0].getLog().getMaxX()){

			}
			else if(frog.getFrog().getMinX()>logs2[1].getLog().getMinX()&&frog.getFrog().getMaxX()<logs2[1].getLog().getMaxX()){

			}
			else{
				reset();
			}

		}
		if(frog.getFrog().getCenterY()<HEIGHT-340&&frog.getFrog().getCenterY()>HEIGHT-390){

			if(frog.getFrog().getMinX()>logs3[0].getLog().getMinX()&&frog.getFrog().getMaxX()<logs3[0].getLog().getMaxX()){

			}
			else if(frog.getFrog().getMinX()>logs3[1].getLog().getMinX()&&frog.getFrog().getMaxX()<logs3[1].getLog().getMaxX()){

			}
			else{
				reset();
			}

		}

	}
	public void score(){
		if(frog.getFrog().getCenterY()<HEIGHT-390){
			score++;
			deaths--;
			reset();
		}
	}
	public void showInfo(Graphics g){
		Graphics2D g2d= (Graphics2D)g;
		g.setColor(Color.BLACK);
		g2d.drawString("Deaths:"+Integer.toString(deaths), 15, 15);
		g2d.drawString("Score"+Integer.toString(score), 25, 25);
	}
	public void reset(){
		deaths++;
		frog.getFrog().x=250;
		frog.getFrog().y=HEIGHT-90;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.red);
		for(Cars car: cars1)
			car.render(g);
		for(Cars car: cars2)
			car.render(g);
		g.setColor(Color.ORANGE);
		for(Logs log: logs1)
			log.render(g);
		for(Logs log: logs2)
			log.render(g);
		for(Logs log: logs3)
			log.render(g);
		g.setColor(Color.GRAY);
		frog.render(g);
		score();
		showInfo(g);
		didIntersectCar();
		isInsideLog();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		repaint();
	}
}
