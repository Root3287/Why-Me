package me.timothy.WhyMe.screen.Level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import me.timothy.WhyMe.entity.mob.player.Player;
import me.timothy.WhyMe.input.Keyboard;

public class Test
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
  
  public void show()
  {
    this.camera = new OrthographicCamera();
    
    this.map = new TmxMapLoader().load("images/Level/School.tmx");
    this.renderer = new OrthogonalTiledMapRenderer(this.map);
    this.prop = this.map.getProperties();
    
    if(!this.refreash){
    	//this.p = new Player((TiledMapTileLayer)this.map.getLayers().get("Collision"));
    	this.p.setX(1317.0F);
        this.p.setY(800.0F);
    }
    this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    System.out.println("W: 51 S: 47 A: 29 D: 32");
    
    Gdx.input.setInputProcessor(new Keyboard(this.p));
    
    this.camera.zoom = 0.3F;
  }
  
  public void render(float delta)
  {
    Gdx.gl.glClear(16384);
    Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    
    this.camera.position.x = this.p.getX();
    this.camera.position.y = this.p.getY();
    this.camera.update();
    
    this.renderer.setView(this.camera);
    
    this.renderer.render(this.map_layer);
    
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
  
  public void hide() {}
  
  public void dispose()
  {
    this.map.dispose();
    this.p.dispose();
    this.renderer.dispose();
  }
}
