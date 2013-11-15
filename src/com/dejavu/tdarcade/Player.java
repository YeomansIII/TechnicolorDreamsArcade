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
	private ViewPort viewport;

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

	public Player(GameContainer gc, ViewPort view) throws SlickException {
		facingRight = true;
		curX = 100;
		curY = 600;
		input = gc.getInput();
		viewport = view;
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
			idleAnimation.update(i);
			if (entityCollisionWith()) {
				moveY(v);
				v = 3;
				jumping = false;
			}
			jumpCount++;
			v -= g;
		} else {
			jumping = false;
			moveY(v);
			if (entityCollisionWith()) {
				moveY(-v);
				v = 3;
			}
			v += g;
		}

		if (input.isKeyDown(Input.KEY_SPACE) && !jumping) {
			jumpCount = 0;
			jumping = true;
			v = 8;
		} else if (input.isKeyDown(Input.KEY_D)) {
			moveX(3);
			walkingAnimation.update(i);
			action = WALKINGR;
			if (entityCollisionWith()) {
				moveX(-3);
			}
		} else if (input.isKeyDown(Input.KEY_A)) {
			moveX(-3);
			walkingLeftAnimation.update(i);
			action = WALKINGL;
			if (entityCollisionWith()) {
				moveX(3);
			}

		} else if (!jumping) {
			idleAnimation.update(i);
			action = IDLE; 
		}

		/*
		 * if (curX - viewport.cordX() > 526) { viewport.setX(-3); } else if
		 * (curX - viewport.cordX() < 524) { viewport.setX(3); }
		 */
		if (curX - viewport.cordX() > 520) {
			viewport.setX(2);
		} else if (curX - viewport.cordX() < 480) {
			viewport.setX(-2);
		}
	}

	public void moveX(float x) {
		curX += x;
		playerPoly.setX(curX);
	}

	public void moveY(float y) {
		curY += y;
		playerPoly.setY(curY);
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		// System.out.println("CurX-view: " + (curX - viewport.cordX())
		// + "  CurY-view: " + (curY - viewport.cordY()));
		 System.out.println("CurX: " + (curX) + "  CurY: " + (curY));
		System.out.println("Viewport  X: "+viewport.getX()+"  Y: "+viewport.getY());
		try {
			switch (action) {
			case IDLE:
				idleAnimation.draw(curX - viewport.cordX(),
						curY - viewport.cordY());
				break;
			case JUMPING:
				idleAnimation.draw(curX - viewport.cordX(),
						curY - viewport.cordY());
				break;
			case WALKINGR:
				walkingAnimation.draw(curX - viewport.cordX(),
						curY - viewport.cordY());
				break;
			case WALKINGL:
				walkingLeftAnimation.draw(curX - viewport.cordX(), curY
						- viewport.cordY());
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 g.drawRect(playerPoly.getX() - viewport.cordX(), playerPoly.getY()
		 - viewport.cordY(), 80, 150);
		//g.drawRect(playerPoly.getX(), playerPoly.getY(), 80, 150);
		;
	}

	public boolean entityCollisionWith() throws SlickException {
		// float pX = playerPoly.getX(); float pY = playerPoly.getY();
		for (int i = 0; i < BlockMap.entities.size(); i++) {
			Block entity1 = (Block) BlockMap.entities.get(i);
			entity = entity1;
			// System.out.println("Entity X: " + entity.poly.getX() + "  Y: "
			// + entity.poly.getY());
			// playerPoly.setX(pX+viewport.cordX());
			// playerPoly.setY(pY+viewport.cordY());
			if (playerPoly.intersects(entity1.poly)) {
				// playerPoly.setX(pX); playerPoly.setY(pY);
				return true;
			}
		}
		// playerPoly.setX(pX); playerPoly.setY(pY);
		return false;
	}
}
