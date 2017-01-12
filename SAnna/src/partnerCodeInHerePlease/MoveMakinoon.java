package partnerCodeInHerePlease;
import SimonAnna.ButtonInterfaceAnna;
import SimonAnna.MoveInterfaceAnna;
//
public class MoveMakinoon implements MoveInterfaceAnna{
	private ButtonInterfaceAnna x;
	
	public MoveMakinoon(ButtonInterfaceAnna x) {
		this.x = x; 
		
	}
	public ButtonInterfaceAnna getButton(){
		return this.x; 
	}

}
