package partnerCodeInHerePlease;
import SimonAnna.ButtonInterfaceAnna;
import SimonAnna.MoveInterfaceAnna;

public class Move implements MoveInterfaceAnna{
	private ButtonInterfaceAnna x;
	
	public Move(ButtonInterfaceAnna x) {
		this.x = x; 
		
	}
	public ButtonInterfaceAnna getButton(){
		return x; 
	}

}
