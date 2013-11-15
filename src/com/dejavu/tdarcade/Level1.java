package com.dejavu.tdarcade;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Level1 extends BasicGameState{

	public static BlockMap map;
	Player player;
	ViewPort viewport;
	Input input;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		viewport = new ViewPort(0, 0);
		map = new BlockMap("data/levels/tutorial.tmx");
		player = new Player(gc,viewport);
		input = new Input(0);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		player.update(gc, delta);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		BlockMap.tmap.render(-1*(viewport.getX()),-1*(viewport.getY()));
		player.render(gc, g);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	/* public void keyPressed(int key, char c) {
		switch(key) {
		case Input.KEY_D:
			player.moveX(1);
			break;
		case Input.KEY_2:
			// TODO Scores Screan?
			break;
		case Input.KEY_3:
			// TODO Quit...
			break;
		}
		
	} */

}
