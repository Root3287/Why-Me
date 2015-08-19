package me.timothy.WhyMe.screen.Level;

import me.timothy.WhyMe.entity.block.Blocks.Signs;
import me.timothy.WhyMe.entity.item.items.PillBottle;
import me.timothy.WhyMe.entity.mob.player.Player;
import me.timothy.WhyMe.input.Keyboard;
import me.timothy.WhyMe.other.Debug;
import me.timothy.WhyMe.other.InfoText;
import me.timothy.WhyMe.other.Time;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GravityTest implements Screen {

	Time t;
	Player p;
	TiledMap map;
	OrthogonalTiledMapRenderer renderer;
	OrthographicCamera camera;
	Signs s;
	Stage stage,debug;
	Skin skin;
	InfoText it;
	Debug d;
	PillBottle pill;
	BitmapFont font;
	SpriteBatch batch;
	
	@Override
	public void show() {
		this.stage = new Stage();
		this.skin = new Skin(Gdx.files.internal("ui/Menu.json"), new TextureAtlas("ui/Buttons.pack"));
		map = new TmxMapLoader().load("images/Level/Parkour.tmx");
		s = new Signs(3*16, 1*16,"Welcome this is the gravity test!\nPress F3 once for Debug and R to reset the map!\nWSAD to move. X for action.");
		p = new Player((TiledMapTileLayer)map.getLayers().get(0), true, 16, 100);
		renderer = new OrthogonalTiledMapRenderer(map);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.zoom = 0.3f;
		it = new InfoText(p, "S A X\nSPACE", -(2*16+9), 4*16);
		pill = new PillBottle(110, 16);
		t = new Time();
		font = new BitmapFont(Gdx.files.internal("font/Black-8.fnt"));
		
		s.addPlayer(p);
		s.addSkin(skin);
		s.addStage(stage);
		InputMultiplexer im = new InputMultiplexer();
		im.addProcessor(stage);
		im.addProcessor(new Keyboard(p));
		Gdx.input.setInputProcessor(im);
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
			//pill.render((SpriteBatch) renderer.getBatch());
			it.draw((SpriteBatch) renderer.getBatch());
			p.render((SpriteBatch)renderer.getBatch());
			s.draw((SpriteBatch)renderer.getBatch());	
		renderer.getBatch().end();
		
		t.update();
		
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
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