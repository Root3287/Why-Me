package me.timothy.WhyMe.screen.Level;

import com.badlogic.gdx.Gdx;
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

import me.timothy.WhyMe.entity.mob.player.Player;
import me.timothy.WhyMe.input.Keyboard;
import me.timothy.WhyMe.screen.Notifcation;
import me.timothy.WhyMe.screen.other.DialogMessage;

public class School
  implements Screen
{
  OrthographicCamera camera;
  TiledMap map;
  MapProperties prop;
  OrthogonalTiledMapRenderer renderer;
  Player p;
  int[] foreground = { 1 };
  int[] map_layer = new int[1];
  boolean refreash = false;
  Notifcation pause;
  Stage stage;
  DialogMessage welcome;
  Skin skin;
  
  public School(){
	  show();
	  this.p = new Player((TiledMapTileLayer)this.map.getLayers().get("Collision"), 1320,800,Levels.SCHOOL);
  }
  public School(float x, float y) {
	  //1320 800
	  this.p = new Player((TiledMapTileLayer)this.map.getLayers().get("Collision"), x,y,Levels.SCHOOL);
  }
  public void show()
  {
	this.stage = new Stage();
	this.skin = new Skin(Gdx.files.internal("ui/Menu.json"), new TextureAtlas("ui/Buttons.pack"));
    this.camera = new OrthographicCamera();
    
    this.map = new TmxMapLoader().load("images/Level/School.tmx");
    this.renderer = new OrthogonalTiledMapRenderer(this.map);
    this.prop = this.map.getProperties();
    
    this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    System.out.println("W: 51 S: 47 A: 29 D: 32");

    InputMultiplexer im = new InputMultiplexer();
    im.addProcessor(stage);
    im.addProcessor(new Keyboard(this.p));
    
    Gdx.input.setInputProcessor(im);
    
    this.camera.zoom = 0.3F;
    
   
    this.welcome = new DialogMessage("Welcome", "Why this place?", skin);
    this.welcome.show(stage);
  }
  
  public void render(float delta)
  {
    Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
    Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    
    this.camera.position.x = (int) this.p.getX();
    this.camera.position.y = (int) this.p.getY();
    this.camera.update();
    
    this.renderer.setView(this.camera);
    
    this.renderer.render(this.map_layer);
    stage.act();stage.draw();
    this.renderer.getBatch().begin();
    this.p.render((SpriteBatch)this.renderer.getBatch());
    this.renderer.getBatch().end();
    
    this.renderer.render(this.foreground);
  }
  
  public void resize(int width, int height)
  {
    dispose();
    this.refreash = true;
    show();
    this.refreash = false;
  }
  
  public void pause() {}
  
  public void resume() {}
  
  public void hide() {
	  dispose();
  }
  
  public void dispose()
  {
    this.map.dispose();
    this.p.dispose();
    this.renderer.dispose();
  }
}