package com.mygdx.fallingletters;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen implements Screen {
	final FallingLetters game;
	OrthographicCamera camera;
	Rectangle imgRect;
	
	// Game logic variables
	ArrayList<Character> allLetters;
	ArrayList<Double> timesToPass;
	ArrayList<Character> letters;
	ArrayList<Rectangle> height;
	int timeSinceLastLetter;
	
	public GameScreen(final FallingLetters game) {
		this.game = game;
		
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, game.windowedWidth, game.windowedHeight);
		
		imgRect = new Rectangle(0, 176, game.windowedWidth/10, game.windowedWidth/10);
		
		// Game logic
		letters = new ArrayList<> ();
		timesToPass = new ArrayList<> ();
		//loadLetters();
		timeSinceLastLetter = 0;
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		
		game.batch.setProjectionMatrix(camera.combined);
		
		game.batch.begin();
		game.batch.draw(game.img, imgRect.x, imgRect.y);
		game.batch.end();
		
		// Add new letter to list if enough time passed
		//timeSinceLastLetter += delta;
		//if (timeSinceLastLetter > timesToPass.get(0)) {
			
		//}
		
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			System.out.println("TOOO");
			imgRect.x -= delta * 50;
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			imgRect.x += delta * 50;
		}
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			System.out.println("TOOO");
			imgRect.y -= delta * 50;
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			imgRect.y += delta * 50;
		}
		// Close the game
		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			Gdx.app.exit();
		}

		// Switching between windowed and fullscreen mode
		if (Gdx.input.isKeyPressed(Keys.F12)) {
			game.setFullscreenMode();
		}
		if (Gdx.input.isKeyPressed(Keys.F11)) {
			game.setWindowedMode();
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public void loadLetters() {
		// loads letters with times at which should they appear
		
		FileHandle file = Gdx.files.internal("letters.txt");
		String string = file.readString();
		double last = 0;
		
		String[] strings = string.split("\r\n");
		for (String s: strings) {
			String[] line = s.split("\t");
			letters.add(line[0].charAt(0));
			timesToPass.add(Double.parseDouble(line[1])-last);
			last = Double.parseDouble(line[1]);
		}
	}

}
