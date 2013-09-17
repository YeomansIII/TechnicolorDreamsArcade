package com.dejavu.tdarcade;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Player {

	private int curX, curY;
	private SpriteSheet walkingSheet;
	private Animation walkingAnimation;
	
	public Player() throws SlickException {
		curX=120;
		curY=150;
		walkingSheet = new SpriteSheet("data/spritesheets/walking_spritesheet.png", 80, 150);
		walkingAnimation = new Animation(walkingSheet, 100);
	}
	
	public void update(GameContainer gc, int i) throws SlickException {
		// TODO Auto-generated method stub
		walkingAnimation.update(i);
	}
	
	public void render(GameContainer gc, Graphics g) throws SlickException {
		walkingAnimation.draw(curX, curY);
	}
}
