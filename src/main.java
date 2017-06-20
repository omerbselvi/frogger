import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		JFrame frame= new JFrame();
		Display game= new Display();	
		frame.add(game);
		frame.setSize(game.WIDTH, game.HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
