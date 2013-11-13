package com.dejavu.tdarcade;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Polygon;

public class Player {

	private float curX, curY, jumpCount, g, v;
	private boolean facingRight;
	private Polygon playerPoly;
	private Input input;
	private Block entity;

	// SpriteSheets
	private SpriteSheet walkingSheet, walkingLeftSheet, idleSheet;
	private final int[] numFrames = { 1, 4, 0, 0 };

	// Animations
	private Animation walkingAnimation, walkingLeftAnimation, idleAnimation;

	// Actions
	private int action;
	private boolean jumping;
	private static final int IDLE = 0;
	private static final int WALKINGR = 1;
	private static final int WALKINGL = 2;
	private static final int JUMPING = 3;
	private static final int FALLING = 4;

	public Player(GameContainer gc) throws SlickException {
		facingRight = true;
		curX = 70;
		curY = 120;
		input = gc.getInput();
		action = IDLE;
		jumping = false;
		g = 0.25f;
		v = 2;

		// Load SpriteSheets
		try {
			walkingSheet = new SpriteSheet(
					"data/spritesheets/walking_spritesheet.png", 80, 150);
			walkingLeftSheet = new SpriteSheet(
					"data/spritesheets/walkingLeft_spritesheet.png", 80, 150);
			idleSheet = new SpriteSheet(
					"data/spritesheets/idle_spritesheet.png", 80, 150);
		} catch (Exception e) {
			e.printStackTrace();
		}

		walkingAnimation = new Animation(walkingSheet, 200);
		walkingLeftAnimation = new Animation(walkingLeftSheet, 200);
		idleAnimation = new Animation(idleSheet, 100);

		playerPoly = new Polygon(new float[] { curX, curY, curX + 80, curY,
				curX + 80, curY + 150, curX, curY + 150 });
	}

	public void update(GameContainer gc, int i) throws SlickException {
		if (jumping && jumpCount <= 30) {
			moveY(-v);
			playerPoly.setY(curY);
			idleAnimation.update(i);
			if (entityCollisionWith()) {
				curY += v;
				playerPoly.setY(curY);
				v = 2;
				jumping = false;
			}
			jumpCount++;
			v -= g;
		} else {
			jumping = false;
			curY += v;
			playerPoly.setY(curY);
			if (entityCollisionWith()) {
				curY -= v;
				playerPoly.setY(curY);
				v = 2;
			}
			v += g;
		}

		if (input.isKeyDown(Input.KEY_SPACE) && !jumping) {
			jumpCount = 0;
			jumping = true;
			v = 8;
		} else if (input.isKeyDown(Input.KEY_D)) {
			moveX(3);
			playerPoly.setX(curX);
			walkingAnimation.update(i);
			action = WALKINGR;
			if (entityCollisionWith()) {
				moveX(-3);
				playerPoly.setX(curX);
			}
		} else if (input.isKeyDown(Input.KEY_A)) {
			moveX(-3);
			playerPoly.setX(curX);
			walkingLeftAnimation.update(i);
			action = WALKINGL;
			if (entityCollisionWith()) {
				moveX(3);
				playerPoly.setX(curX);
			}

		} else if (!jumping) {
			idleAnimation.update(i);
			action = IDLE;
		}
	}

	public void moveX(float x) {
		curX += x;
	}

	public void moveY(float y) {
		curY += y;
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		System.out.println("Current Action: " + action);
		try {
			switch (action) {
			case IDLE:
				idleAnimation.draw(curX, curY);
				break;
			case JUMPING:
				idleAnimation.draw(curX, curY);
				break;
			case WALKINGR:
				walkingAnimation.draw(curX, curY);
				break;
			case WALKINGL:
				walkingLeftAnimation.draw(curX, curY);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//g.draw(playerPoly);
	}

	public boolean entityCollisionWith() throws SlickException {
		for (int i = 0; i < BlockMap.entities.size(); i++) {
			Block entity1 = (Block) BlockMap.entities.get(i);
			entity = entity1;
			if (playerPoly.intersects(entity1.poly)) {
				System.out.println("entity collide TRUE");
				return true;
			}
		}
		return false;
	}
}
