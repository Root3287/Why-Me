package me.timothy.WhyMe.screen.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import me.timothy.WhyMe.entity.block.Blocks.Signs;
import me.timothy.WhyMe.entity.mob.player.Player;
import me.timothy.WhyMe.input.Keyboard;

public class BlockTest implements Screen{
	Signs s;
	Player p;
	OrthogonalTiledMapRenderer renderer;
	OrthographicCamera camera;
	TiledMap map;
	Stage stage;
	Skin skin;
	@Override
	public void show() {
		stage = new Stage();
		skin = new Skin(Gdx.files.internal("ui/Menu.json"), new TextureAtlas("ui/Buttons.pack"));
		map = new TmxMapLoader().load("images/Level/TestLevel.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
		p = new Player((TiledMapTileLayer)map.getLayers().get(0),false,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		s = new Signs(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2,"qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm");
		s.addPlayer(p);
		s.addSkin(skin);
		s.addStage(stage);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.zoom = 0.3f;
		
		InputMultiplexer im= new InputMultiplexer();
		im.addProcessor(stage);
		im.addProcessor(new Keyboard(p));
		
		Gdx.input.setInputProcessor(im);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.0f, 0.0f);
		
		camera.update();
		renderer.setView(camera);
		
		renderer.render();
		
		renderer.getBatch().begin();
			p.render((SpriteBatch)renderer.getBatch());
			s.draw((SpriteBatch)renderer.getBatch());
		renderer.getBatch().end();
		
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().setScreenSize(width, height);
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
