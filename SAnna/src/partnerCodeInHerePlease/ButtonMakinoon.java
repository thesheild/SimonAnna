package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import SimonAnna.ButtonInterfaceAnna;
import gui.components.Action;
import gui.components.Component;

public class ButtonMakinoon extends Component implements ButtonInterfaceAnna {
	private Action action;
	private Color c;
	private boolean highlighted;
	
	public ButtonMakinoon(int x, int y) {
		super(x,y,50,50);
	}

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return ((x>this.getX() && x<(this.getX()+this.getWidth())) 
				&& (y>this.getY() && y<(this.getY()+this.getHeight())));
	}

	@Override
	public void act() {
		this.action.act(); 

	}
	public void setAction(Action a){ 
		this.action = a; 
	}
	public void setColor(Color c){ 
		this.c = c; 
		
	}
	public void dim(){ 
		highlighted = false; 
		update(); 
	}
	
	public void highlight(){ 
		highlighted = true; 
		update();
	}
	public void update() {
		// TODO Auto-generated method stub

	}

	
	public void update(Graphics2D g) {
		g = clear(); 
		
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(highlighted) 
		{
			g.setColor(this.c);
		}
			else{
				g.setColor(Color.GRAY);
			}
		g.fillOval(0, 0, 50, 50);
		g.setColor(Color.BLACK);
		g.drawOval(0, 0, 50, 50);
		
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setX() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY() {
		// TODO Auto-generated method stub
		
	}

}
