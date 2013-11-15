package com.dejavu.tdarcade;

public class ViewPort {

	private int locX, locY;
	
	public ViewPort(int x, int y) {
		locX=x;
		locY=y; 
	}
	
	public int getX() {
		return locX;
	}
	
	public int getY() {
		return locY;
	}
	
	public int cordX() {
		return locX;
	}
	
	public int cordY() {
		return locY;
	}
	
	public void setX(int x) {
		locX+=x;
	}
	
	public void setY(int y) {
		locY+=y;
	}
}

