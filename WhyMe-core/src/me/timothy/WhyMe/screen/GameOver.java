package me.timothy.WhyMe.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver implements Screen{
	BitmapFont white;
	SpriteBatch batch;
	@Override
	public void show() {
		white = new BitmapFont(Gdx.files.internal("font/White-16.fnt"));
		batch = new SpriteBatch();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		
		batch.begin();
			white.draw(batch, "Why Me?", 32, 25, 64, 0, false);
		batch.end();
		
		if(Gdx.input.isKeyJustPressed(Keys.ENTER)){
			((Game)Gdx.app.getApplicationListener()).setScreen(new GameOver());
		}
	}

	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void pause() {
		
		
	}

	@Override
	public void resume() {
		
		
	}

	@Override
	public void hide() {
		
		
	}

	@Override
	public void dispose() {
		
		
	}

}
