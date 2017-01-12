package SimonAnna;

public class MoveAnna implements MoveInterfaceAnna {

	private ButtonInterfaceAnna b; 
	
	public MoveAnna(ButtonInterfaceAnna b) {
		this.b = b;
	}

	public ButtonInterfaceAnna getButton() {
		return b;
	}
}
