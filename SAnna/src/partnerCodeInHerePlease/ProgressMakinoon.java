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
	public ProgressMakinoon() {
		super(250, 40, 150, 80);
		gameOver = false; 
		
	}
	public void gameOver() {
		gameOver = true;
		update();
		
	}

	public void setSequenceLength(int length) {
		this.sequenceLength = length;
		update();
		
	}

	@Override
	public void setRound(int round) {
		this.roundNumber = round;
		update();
}

	@Override
	public void update(Graphics2D g) {
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setFont(new Font("Calibri",Font.PLAIN,16));
			
			if(gameOver){
				g.setColor(Color.red);
				g.fillRect(0, 0, 200,100);
				g.setColor(Color.black);
				g.drawRect(0,0, 200, 100);	
				g.drawString("Game Over!",5,35);
				
			}
			else{
				g.setColor(Color.gray);
				g.fillRect(0, 0,200, 100);
				g.setColor(Color.black);
				g.drawRect(0,0,200, 100 );	
			}
			g.drawString("Round #: "+roundNumber,5,20);
			g.drawString("Sequence Length: "+sequenceLength,5,40);
	} 



}
