import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Display extends JPanel implements ActionListener{
	public static int GRID=50;
	public static int ERRORY=10;
	public static int ERRORX=16;
	public static int WIDTH=500+ERRORX;
	public static int HEIGHT=500-ERRORY;
	Frog frog;
	Cars cars1[];
	Cars cars2[];
	Display(){
		Timer timer= new Timer(16,this);
		frog= new Frog(200,HEIGHT-90,50,50);
		cars1= new Cars[2];
		for(int i=0;i<cars1.length;i++){
			cars1[i]= new Cars(0+i*290,HEIGHT-140,100,50,4);
		}
		cars2= new Cars[3];
		for(int i=0;i<cars2.length;i++){
			cars2[i]= new Cars(0+i*270,HEIGHT-190,100,50,-3);
		}
			
		
		this.addKeyListener(frog);
		setFocusable(true);
		timer.start();
	}
	public void didIntersectCar(){
		for(Cars car:cars1){
			if(frog.getFrog().getBounds().intersects(car.getCar().getBounds())){
				frog.getFrog().x=200;
				frog.getFrog().y=HEIGHT-90;
			}
		}
		for(Cars car:cars2){
			if(frog.getFrog().getBounds().intersects(car.getCar().getBounds())){
				frog.getFrog().x=200;
				frog.getFrog().y=HEIGHT-90;
			}
		}

	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.red);
		frog.render(g);
		for(Cars car: cars1)
			car.render(g);
		for(Cars car: cars2)
			car.render(g);
		didIntersectCar();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		repaint();
	}
}
