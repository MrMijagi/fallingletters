package com.mygdx.fallingletters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;

public class FallingLetters extends Game {
	SpriteBatch batch;
	Texture img;
	boolean isFullscreenMode;
	int windowedWidth;
	int windowedHeight;
	
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.png");
		isFullscreenMode = false;
		
		// Resolution of windowed mode
		windowedWidth = 800;
		windowedHeight = 600;
		
		this.setScreen(new MainMenuScreen(this));
	}

	public void render () {
		super.render();
	}
	
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	
	public void setFullscreenMode() {
		// Sets fullscreen mode and return false, if switching was unsuccesful
		DisplayMode displayMode = Gdx.graphics.getDisplayMode();
		Gdx.graphics.setFullscreenMode(displayMode);
	}
	
	public void setWindowedMode() {
		// Sets to window mode
		Gdx.graphics.setWindowedMode(this.windowedWidth, this.windowedHeight);
	}
}
