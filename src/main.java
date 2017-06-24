import javax.swing.JFrame;

public class main {
	
	
	public static void main(String[] args) {		
		JFrame frame= new JFrame("Pepe the Frogger");
		Display game= new Display();	
		frame.add(game);
		frame.setSize(600,480);
        frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
