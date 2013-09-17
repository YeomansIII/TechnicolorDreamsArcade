package com.dejavu.tdarcade;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public abstract class ScreenState {

	public ScreenState(GameContainer gc) throws SlickException {
		init(gc);
	}
	
	public abstract void init(GameContainer gc) throws SlickException;

	public abstract void update(GameContainer gc, int i) throws SlickException;

	public abstract void render(GameContainer gc, Graphics g) throws SlickException;
}
