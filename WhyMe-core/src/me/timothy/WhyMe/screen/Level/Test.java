package me.timothy.WhyMe.screen.Level;

import me.timothy.WhyMe.entity.item.Gun;
import me.timothy.WhyMe.entity.player.Player;
import me.timothy.WhyMe.input.Keyboard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Test
  implements Screen
{
  OrthographicCamera camera;
  TiledMap map;
  MapProperties prop;
  OrthogonalTiledMapRenderer renderer;
  Texture filtertex;
  Sprite filter;
  Stage stage;
  Player p;
  int[] foreground = { 1 };
  int[] map_layer = new int[1];
  boolean refreash = false;
  Gun g,g2,g3,g4,g5,g6,g7,g8,g9;
  
  public void show()
  {
    this.camera = new OrthographicCamera();
    
    this.map = new TmxMapLoader().load("images/Level/TestLevel.tmx");
    this.renderer = new OrthogonalTiledMapRenderer(this.map);
    this.prop = this.map.getProperties();
    
    this.filtertex = new Texture(Gdx.files.internal("images/Screen.png"));
    this.filter = new Sprite(this.filtertex);
    if(!this.refreash){
    	this.p = new Player((TiledMapTileLayer)this.map.getLayers().get("Collision"));
    	this.p.setX(80.0F);
        this.p.setY(80.0F);
    }
    this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    System.out.println("W: 51 S: 47 A: 29 D: 32");
    
    Gdx.input.setInputProcessor(new Keyboard(this.p));
    
    this.camera.zoom = 0.3F;
    
    this.g = new Gun(this.p, 90,90);
    this.g2 = new Gun(this.p, 90,91);
    this.g3 = new Gun(this.p, 90,92);
    this.g4 = new Gun(this.p, 90,93);
    this.g5 = new Gun(this.p, 90,94);
    this.g6 = new Gun(this.p, 90,95);
    this.g7= new Gun(this.p, 90,96);
    this.g8 = new Gun(this.p, 90,97);
    this.g9 = new Gun(this.p, 90,98);
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
    this.g.render((SpriteBatch)this.renderer.getBatch());
    this.g2.render((SpriteBatch)this.renderer.getBatch());
    this.g3.render((SpriteBatch)this.renderer.getBatch());
    this.g4.render((SpriteBatch)this.renderer.getBatch());
    this.g5.render((SpriteBatch)this.renderer.getBatch());
    this.g6.render((SpriteBatch)this.renderer.getBatch());
    this.g7.render((SpriteBatch)this.renderer.getBatch());
    this.g8.render((SpriteBatch)this.renderer.getBatch());
    this.g9.render((SpriteBatch)this.renderer.getBatch());
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
