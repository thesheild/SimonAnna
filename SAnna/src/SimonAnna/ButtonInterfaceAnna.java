package SimonAnna;

import java.awt.Color;

import gui.components.Action;
import gui.components.Clickable;

public interface ButtonInterfaceAnna extends Clickable {
	void setColor(Color color);


	void highlight();

	void dim();

	void setAction(Action action);
	
	void setName(String name);
	
	void setX();
	
	void setY();
	
	
}
