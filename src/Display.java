import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	Display(){
		Timer timer= new Timer(20,this);
		frog= new Frog(0,HEIGHT-90,50,50);
		this.addKeyListener(frog);
		setFocusable(true);
		timer.start();
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.red);
		frog.render(g);

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		repaint();
	}
}
