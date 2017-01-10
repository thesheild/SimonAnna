package SimonAnna;

public class Move implements MoveInterfaceAnna {

	private ButtonInterfaceAnna b; 
	
	public Move(ButtonInterfaceAnna b) {
		this.b = b;
	}

	public ButtonInterfaceAnna getButton() {
		return b;
	}
}
