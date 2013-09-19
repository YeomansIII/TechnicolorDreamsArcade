package com.dejavu.tdarcade;

import java.util.logging.Level;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.sun.istack.internal.logging.Logger;

public class TechnicolorGame extends StateBasedGame {
	
	public TechnicolorGame(String title) {
		super(title);
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		addState(new Menu());
		addState(new Level1());
		gc.setTargetFrameRate(60);
	}

	
	public static void main(String...args) {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new TechnicolorGame("Technicolor Dreams Arcade"));
			appgc.setDisplayMode(1050, 825, false);
			appgc.start();
		}
		catch (SlickException ex) {
			Logger.getLogger(TechnicolorGame.class.getName(), com.dejavu.tdarcade.TechnicolorGame.class).log(Level.SEVERE,null,ex);
		}
	}


}
