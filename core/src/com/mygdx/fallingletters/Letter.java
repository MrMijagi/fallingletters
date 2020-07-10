package com.mygdx.fallingletters;

import com.badlogic.gdx.utils.Pool;

public class Letter implements Pool.Poolable {
	private int posX, posY;
	
	public Letter() {
		this.posX = 0;
		this.posY = 0;
	}
	
	public void init(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public int getPosX() {return this.posX;}
	public int getPosY() {return this.posY;}
	
	public void update(int deltaX, int deltaY) {
		this.posX += deltaX;
		this.posY += deltaY;
	}

	@Override
	public void reset() {
		this.posX = 0;
		this.posY = 0;
	}
}
