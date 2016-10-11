import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel {

	Ball ball = new Ball(this);
	Racket racket = new Racket(this);
	
	public Game(){
		addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
				racket.keyPressed(e);
			}
			
			public void keyPressed(KeyEvent e) {
				racket.keyReleased(e);
			}

			public void keyReleased(KeyEvent e) {
			}
		});
		setFocusable(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
 		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racket.paint(g2d);
	}
	
	public void gameOver(){
		JOptionPane.showMessageDialog(this, "Game Over","Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	private void move() {
		ball.moveBall ();
		racket.move ();
	}
	
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		Game game = new Game();
		frame.setSize(600,700);
		frame.setLocation(50, 50);
		frame.setDefaultCloseOperation(3);
		frame.add(game);
		frame.setTitle("Hello!");
		frame.setResizable(true);
		frame.setVisible(true);
		
		while(true) {
			Toolkit.getDefaultToolkit().sync();
			game.move();
			game.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}