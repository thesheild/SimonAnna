package SimonAnna;

import gui.GuiApplication;

public class SimonGameAnna extends GuiApplication {

	public SimonGameAnna(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreenAnna ssa = new SimonScreenAnna (getWidth(), getHeight());
		setScreen(ssa);
	}

	public static void main(String[] args) {
		SimonGameAnna sga = new SimonGameAnna(800,500);
		Thread game = new Thread(sga);
		game.start();
	}

}
