package SimonAnna;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import gui.ClickableScreen;
import gui.components.Action;
import gui.components.TextLabel;
import gui.components.Visible;
import partnerCodeInHerePlease.ButtonMakinoon;
import partnerCodeInHerePlease.MoveMakinoon;
import partnerCodeInHerePlease.ProgressMakinoon;

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
		Thread app = new Thread(this);
		app.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		a.setText("");
	    nextRound();
	}

	private void nextRound() {
		// TODO Auto-generated method stub
		acceptingInput = false;
		roundNumber ++;
		c.setRound(roundNumber);
		d.add(randomMove());
		c.setSequenceLength(d.size());
		changeText("Simon's turn");
		a.setText("");
		playSequence();
		changeText("Your turn");
		a.setText("");
		acceptingInput = true;
		sequenceIndex = 0;
		
	}

	private void playSequence() {
		// TODO Auto-generated method stub
		ButtonInterfaceAnna b = null;
		for(MoveInterfaceAnna m: d){
			if(b!=null){
				b.dim();
			}
			b = m.getButton();
			b.highlight();
			try {
				Thread.sleep((long)(2000*(2.0/(roundNumber+2))));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}

	private void changeText(String string) {
		// TODO Auto-generated method stub
		try{
			a.setText(string);
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
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
		for(int i = 0; i< b.length; i++){
			viewObjects.add(b[i]);
		}
		viewObjects.add(c);
		viewObjects.add(a);
	}
	
	private MoveInterfaceAnna randomMove() {
		int x = (int)(Math.random()*b.length);
		while(x == lastSelectedButton){
			x = (int) (Math.random()*b.length);
		}
		lastSelectedButton = x;
		return new MoveMakinoon(b[x]);
	}

	//Placeholder until partner finishes implementation of ProgressInterface
	private ProgressInterfaceAnna getProgress() {
		// TODO Auto-generated method stub
		return new ProgressMakinoon();
	}
	
	private ButtonInterfaceAnna getButton() {
		// TODO Auto-generated method stub
		return new ButtonMakinoon();
	}

	private void addButtons() {
		// TODO Auto-generated method stub
		int numberOfButtons = 4;
		Color[] colors = {Color.red, Color.blue, Color.yellow, Color.pink};
		 b = new ButtonInterfaceAnna[numberOfButtons];
		 
			for (int i = 0; i < colors.length; i++){ 
				final ButtonInterfaceAnna bu = getButton();
				b[i] = bu;
			
				bu.setColor(colors[i]);
				bu.setX();
				bu.setY();
				bu.setAction(new Action(){

					public void act(){
						System.out.println("clicked");
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

	
	
	public void gameOver() {
		c.gameOver();
	}

}