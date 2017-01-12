package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import SimonAnna.ProgressInterfaceAnna;
import gui.components.Component;

public class ProgressMakinoon extends Component implements ProgressInterfaceAnna{
	private boolean gameOver;
	private int roundNumber; 
	private int sequenceLength; 
	
	//	public Progress() {
	//		// TODO Auto-generated constructor stub
	//	}
	//
	public ProgressMakinoon(int x, int y, int w, int h) {
		super(500, 100, 300, 100);
		gameOver = false; 
		
	}
	public void gameOver() {
		gameOver = true;
		update();
		
	}

	@Override
	public void setsequenceLength(int length) {
		this.sequenceLength = length;
		update();
		
	}

	@Override
	public void setRound(int round) {
		this.roundNumber = round;
		update();
//	}
//	public int getHeight() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public BufferedImage getImage() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int getWidth() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int getX() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int getY() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public boolean isAnimated() {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public void update(Graphics2D g) {
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setFont(new Font("Calibri",Font.PLAIN,16));
			if(gameOver){
				g.setColor(Color.red);
				g.fillRoundRect(0, 0, 198, 98, 20, 20);
				g.setColor(Color.black);
				g.drawRoundRect(0,0,198,98,20,20);	
				g.drawString("Game Over!",5,35);
				
			}
			else{
				g.setColor(Color.gray);
				g.fillRoundRect(0, 0, 198, 98, 20, 20);
				g.setColor(Color.black);
				g.drawRoundRect(0,0,198,98,20,20);	
			}
			g.drawString("Round: "+roundNumber,5,55);
			g.drawString("Sequence Length: "+sequenceLength,5,75);
	}



}
