package falling.letters.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenuScreen implements Screen {
	
	final FallingLettersGame game;
	OrthographicCamera camera;
	
	public MainMenuScreen(final FallingLettersGame game, String errorMsg) {
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, game.windowedWidth, game.windowedHeight);
	}
	
	public MainMenuScreen(final FallingLettersGame game) {this(game, "");}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,  0,  0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		game.batch.begin();
		game.batch.draw(game.img, 0 ,0);
		game.batch.end();
		
		// Start the game
		if (Gdx.input.isKeyPressed(Keys.ENTER)) {
			game.setScreen(new GameScreen(game));
			dispose();
		}
		
		// Close the game
		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) Gdx.app.exit();
		
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
}
