package partnerCodeInHerePlease;

import java.awt.Color;


import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import SimonAnna.ButtonInterfaceAnna;
import gui.components.Action;
import gui.components.Component;

public class ButtonMakinoon extends Component implements ButtonInterfaceAnna {
	private Color color;
	private Color currentColor;
	private boolean highlight;
	private Action action;
	private static int width = 50;
	private static int height = 50;
	private static int count;
	
	public ButtonMakinoon() {
		super(5+ 55*count, 300, 50,50);
		count++;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		update();
	}

	@Override
	public void highlight() {
		highlight = true;
		currentColor = color;
		update();
	}

	@Override
	public void dim() {
		currentColor = Color.lightGray;
		highlight = false;
		update();
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		
		return (x>this.getX() && x<(this.getX()+this.getWidth())) && (y>this.getY() && y<(this.getY()+this.getHeight()));
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(currentColor != null){
			g.setColor(currentColor);
		}
		else{
			g.setColor(Color.lightGray);
		}
		g.fillOval(0, 0, width, height);
		g.setColor(Color.black);
		g.drawOval(0, 0, width, height);
		
	}//

	@Override
	public void setAction(Action action) {
		this.action = action;
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
