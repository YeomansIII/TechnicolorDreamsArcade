package com.dejavu.tdarcade;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Menu extends BasicGameState{
	
	private StateBasedGame game;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		this.game = game;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.drawString("Technicolor Dreams", 30, 50);
		
		g.drawString("1. Level One", 30, 110);
		g.drawString("2. Score", 30, 130);
		g.drawString("3. Quit", 30, 150);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void keyReleased(int key, char c) {
		switch(key) {
		case Input.KEY_1:
			game.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			break;
		case Input.KEY_2:
			// TODO Scores Screan?
			break;
		case Input.KEY_3:
			// TODO Quit...
			break;
		}
		
	}

}
