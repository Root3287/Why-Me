 package me.timothy.WhyMe.screen.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import me.timothy.WhyMe.entity.block.Blocks.Signs;
import me.timothy.WhyMe.entity.mob.player.Player;
import me.timothy.WhyMe.input.Keyboard;
import me.timothy.WhyMe.other.DialogMessage;

public class School implements Screen{
	OrthographicCamera camera;
	TiledMap map;
	MapProperties prop;
	OrthogonalTiledMapRenderer renderer;
	Player p;
	int[] foreground = { 0 };
	int[] map_layer = {1};
	boolean refreash = false;
	Stage stage;
	DialogMessage welcome,pause;
	Skin skin;
	Signs s;
  
	public void show(){
		this.stage = new Stage();
		this.skin = new Skin(Gdx.files.internal("ui/Menu.json"), new TextureAtlas("ui/Buttons.pack"));
		this.camera = new OrthographicCamera();
    
		this.map = new TmxMapLoader().load("images/Level/School.tmx");
		this.renderer = new OrthogonalTiledMapRenderer(this.map);
		this.prop = this.map.getProperties();
    
		this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		InputMultiplexer im = new InputMultiplexer();
		im.addProcessor(stage);
		im.addProcessor(new Keyboard(this.p));
    
		Gdx.input.setInputProcessor(im);
    
		this.camera.zoom = 0.3F;
    
		this.p = new Player((TiledMapTileLayer)this.map.getLayers().get("Collision"), 1320,800);
		this.p.addStage(stage);
		this.p.addSkin(skin);
    
		this.s = new Signs(1321, 810, "Some content");
		this.s.addSkin(skin);
		this.s.addStage(stage);
		this.s.addPlayer(p);
	}
  
	public void render(float delta){
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    
		this.camera.position.x = (int) this.p.getX();
		this.camera.position.y = (int) this.p.getY();
		this.camera.update();
    
		this.renderer.setView(this.camera);
    
		if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)){
			new DialogMessage("Pause", skin, "dialog"){
				{
					init("You have been paused","Ok");
				}
			}.show(stage);
		}

		this.renderer.render(this.foreground); // Place code around here to make it lined
    
		this.renderer.getBatch().begin();
			this.s.draw((SpriteBatch)this.renderer.getBatch());
			this.p.render((SpriteBatch)this.renderer.getBatch());
		this.renderer.getBatch().end();
    
		this.renderer.render(this.map_layer);// Set code under here to make it not lined
    
		stage.act();
		stage.draw();
	}
  
  public void resize(int width, int height){
	  camera.viewportWidth = width;
	  camera.viewportHeight = height;
	  camera.update();
	  this.stage.getViewport().setScreenSize(width, height);
	  
  }
  
  public void pause() {
	  
  }
  
  public void resume() {
	  
  }
  
  public void hide() {
	  dispose();
  }
  
  public void dispose()
  {
    this.map.dispose();
    this.p.dispose();
    this.renderer.dispose();
    this.stage.dispose();
    this.skin.dispose();
  }
}