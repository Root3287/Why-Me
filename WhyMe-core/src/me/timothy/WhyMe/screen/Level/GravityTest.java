package me.timothy.WhyMe.screen.Level;

import me.timothy.WhyMe.entity.mob.player.PlayerGravity;
import me.timothy.WhyMe.input.Keyboard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GravityTest implements Screen {

	PlayerGravity p;
	TiledMap map;
	OrthogonalTiledMapRenderer renderer;
	OrthographicCamera camera;
	
	@Override
	public void show() {
		map = new TmxMapLoader().load("images/Level/Parkour.tmx");
		p = new PlayerGravity((TiledMapTileLayer)map.getLayers().get(0), true, 100, 100);
		renderer = new OrthogonalTiledMapRenderer(map);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.zoom = 0.3f;
		Gdx.input.setInputProcessor(new Keyboard(p));
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0.25f, 0.25f,0.25f, 1f);
		
		camera.position.x = p.getX();
		camera.position.y = p.getY();
		camera.update();
		
		renderer.setView(camera);
		
		int[] bg = {0};
		
		renderer.render(bg);
		
		renderer.getBatch().begin();
			p.render((SpriteBatch)renderer.getBatch());
		renderer.getBatch().end();
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
