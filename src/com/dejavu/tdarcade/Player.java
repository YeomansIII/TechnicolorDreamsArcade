package com.dejavu.tdarcade;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;

public class Player {

	private int curX, curY;
	private boolean facingRight;
	private Polygon playerPoly;
	private Input input;

	// SpriteSheets
	private SpriteSheet walkingSheet;
	private SpriteSheet idleSheet;
	private final int[] numFrames = { 1, 4, 0, 0 };

	// Animations
	private Animation walkingAnimation;
	private Animation idleAnimation;

	// Actions
	private int action;
	private static final int IDLE = 0;
	private static final int WALKINGR = 1;
	private static final int WALKINGL = 2;
	private static final int JUMPING = 3;
	private static final int FALLING = 4;

	public Player(GameContainer gc) throws SlickException {
		facingRight = true;
		curX = 120;
		curY = 150;
		input = gc.getInput();
		action = IDLE;

		// Load SpriteSheets
		try {
			walkingSheet = new SpriteSheet(
					"data/spritesheets/walking_spritesheet.png", 80, 150);
			idleSheet = new SpriteSheet(
					"data/spritesheets/idle_spritesheet.png", 80, 150);
		} catch (Exception e) {
			e.printStackTrace();
		}

		walkingAnimation = new Animation(walkingSheet, 200);
		idleAnimation = new Animation(idleSheet, 100);

		playerPoly = new Polygon(new float[] { curX, curY, curX + 80, curY,
				curX + 80, curY + 150, curX, curY + 150 });
	}

	public void update(GameContainer gc, int i) throws SlickException {
		// TODO Auto-generated method stub
		if (input.isKeyDown(Input.KEY_D)) {
			moveX(2);
			walkingAnimation.update(i);
			action = WALKINGR;
		} else if (input.isKeyDown(Input.KEY_A)) {
			moveX(-2);
			walkingAnimation.update(i);
			action = WALKINGR;
		} else {
			idleAnimation.update(i);
			action = IDLE;
		}
	}

	public void moveX(int x) {
		curX += x;
	}

	public void setY(int y) {
		curX = y;
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
	try {
		switch (action) {
		case IDLE:
			idleAnimation.draw(curX, curY);
			break;
		case WALKINGR:
			walkingAnimation.draw(curX, curY);
			break;
		case WALKINGL:
			walkingAnimation.draw(curX, curY);
			break;
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
	}
}
