package falling.letters.game;

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
	ArrayList<LetterMeta> lettersMeta;
	ArrayList<Letter> letters;
	long startTime;
	
	public GameScreen(final FallingLetters game) {
		this.game = game;
		
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, game.windowedWidth, game.windowedHeight);
		
		imgRect = new Rectangle(0, 176, game.windowedWidth/10, game.windowedWidth/10);
		
		// Game logic
		this.lettersMeta = new ArrayList<LetterMeta>();
		loadLetters("letters.txt", lettersMeta);
		this.letters = new ArrayList<Letter>();
		this.startTime = System.nanoTime();
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
		if (System.nanoTime() - this.startTime > lettersMeta.get(0).getTime()) {
			
		}
		
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
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
	
	public void loadLetters(String filename, ArrayList<LetterMeta> array) {
		// loads letters meta (key, time)
		
		FileHandle file = Gdx.files.internal(filename);
		String string = file.readString();
		
		String[] strings = string.split("\r\n");
		for (String s: strings) {
			String[] line = s.split("\t");
			array.add(new LetterMeta(line[0].charAt(0), Long.parseLong(line[1])));
		}
	}

}
