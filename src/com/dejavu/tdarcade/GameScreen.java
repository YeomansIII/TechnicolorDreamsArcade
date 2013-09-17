package com.dejavu.tdarcade;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameScreen extends ScreenState{

	public static BlockMap map;
	Player player;
	ViewPort viewport;
	
	public GameScreen(GameContainer gc) throws SlickException {
		super(gc);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		viewport = new ViewPort(0, 0);
		map = new BlockMap("data/levels/test2.tmx");
		player = new Player();
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		BlockMap.tmap.render(-1*(viewport.getX()*15),-1*(viewport.getY()*15));
		player.render(gc, g);
	}

}
