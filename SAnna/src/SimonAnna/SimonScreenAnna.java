package SimonAnna;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import gui.ClickableScreen;
import gui.components.Action;
import gui.components.TextLabel;
import gui.components.Visible;

public class SimonScreenAnna extends ClickableScreen implements Runnable {

	private TextLabel a;
	private ButtonInterfaceAnna[] b;
	private ProgressInterfaceAnna c;
	private ArrayList<MoveInterfaceAnna> d;
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	public SimonScreenAnna(int width, int height) {
		super(width, height);
//		super(); maybe??
		Thread app = new Thread(this);
		app.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		a.setText("");
//	    nextRound();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		addButtons();
		c = getProgress();
		a = new TextLabel(130,230,300,40,"Let's play Simon!");
		d = new ArrayList<MoveInterfaceAnna>();
		//add 2 moves to start
		lastSelectedButton = -1;
		d.add(randomMove());
		d.add(randomMove());
		roundNumber = 0;
		viewObjects.add(c);
		viewObjects.add(a);
	}
	
	private MoveInterfaceAnna randomMove() {
		int x = (int)(Math.random()*b.length);
		while(x == lastSelectedButton){
			x = (int) (Math.random()*b.length);
		}
		lastSelectedButton = x;
		return new MoveAnna(b[x]);
	}

	//Placeholder until partner finishes implementation of ProgressInterface
	private ProgressInterfaceAnna getProgress() {
		// TODO Auto-generated method stub
		return new ProgressAnna();
	}

	private void addButtons() {
		// TODO Auto-generated method stub
		int numberOfButtons = 4;
		Color[] colors = {Color.red, Color.blue, Color.yellow, Color.pink};
		 b = new ButtonInterfaceAnna[numberOfButtons];
		 
			for (int i = 0; i < colors.length; i++){ 
				b[i] = getButton();
				final ButtonInterfaceAnna bu = getButton();
			
				b[i].setColor(colors[i]);
				b[i].setX();
				b[i].setY();
				b[i].setAction(new Action(){

					public void act(){
						 if(acceptingInput){
							 Thread click = new Thread(new Runnable(){

								 public void run(){
									 bu.highlight(); 
									 try {
										Thread.sleep(600);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									 bu.dim();
									 
								 } 

							});
							 click.start();
							 
							 if(bu == d.get(sequenceIndex).getButton()){
			                      sequenceIndex++;
			                  }else{
			                      gameOver();
			                      return;
			                  }
			                  if(sequenceIndex == d.size()){
			                      Thread nextRound = new Thread(SimonScreenAnna.this);
			                      nextRound.start();
			                  }
						 }
					}

					});
			}
	}

	private ButtonInterfaceAnna getButton() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void gameOver() {
		c.gameOver();
	}

}
