package com.dejavu.tdarcade;

import java.util.logging.Level;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.sun.istack.internal.logging.Logger;

public class TechnicolorGame extends BasicGame {

	public TechnicolorGame(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.drawString("Helo World!", 10, 40);
	}
	
	public static void main(String...args) {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new TechnicolorGame("Technicolor Dreams Arcade"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		}
		catch (SlickException ex) {
			Logger.getLogger(TechnicolorGame.class.getName(), com.dejavu.tdarcade.TechnicolorGame.class).log(Level.SEVERE,null,ex);
		}
	}
}
