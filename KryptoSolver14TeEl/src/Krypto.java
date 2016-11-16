import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class Krypto extends JPanel implements KeyListener{

	private static final long serialVersionUID = 1L;

	int Grid[][] = new int[][]{
		{1,2,3,3,3},
		{2,3,4,5,1},
		{3,4,5,1,2},
		{4,5,1,2,3},
		{5,1,2,3,4}};
	
	char[] Key = new char[] {'K','O','L','A',' ',' '};

	int width= 50, height=50;	
	int fontSizeSmall = 17;
	int fontSizeLarge = 26;
		
	public static void main(String[] args){		
		JFrame frame = new JFrame();
		frame.setSize(600,700);
		frame.setLocation(50, 50);
//		frame.setFocusable(true);
		frame.setDefaultCloseOperation(3);
		frame.setTitle("Hello!");
		frame.add(new Krypto());
		frame.setResizable(true);
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		for (int y=0; y<5; y++){
			for (int x=0; x<5; x++){
				g.drawRect(x*width,y*height, width, height);
				g.drawRect(x*width+1,y*height+1, width-2, height-2);
				g.setFont(new Font("",0,fontSizeSmall));
				g.drawString(String.valueOf(Grid[y][x]), x*width+3, (y)*height+fontSizeSmall);
				
				g.setFont(new Font("",0,fontSizeLarge));
		        g.drawString(String.valueOf(  Key[Grid[y][x]]  ), x*width + width/2-fontSizeLarge /2,y*height+height-3);
			}
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'w'){
			Grid[1][1] = 0;
		}
		if(e.getKeyChar() == 's'){
			Grid[1][1] = 2;
		}
		System.out.println("eee");
	}

	public void keyReleased(KeyEvent e) {
		repaint();
	} 
}
	

		
		

