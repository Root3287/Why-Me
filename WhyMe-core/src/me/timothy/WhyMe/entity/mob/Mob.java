package me.timothy.WhyMe.entity.mob;

import me.timothy.WhyMe.entity.mob.player.Player;
import me.timothy.WhyMe.screen.other.DialogMessage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public abstract class Mob {
	protected float x, y ,ya,xa,speed;
	protected int width, height;
	protected Texture tex;
	protected TiledMapTileLayer collisionLayer;
	protected boolean hasGravity;
	private Stage stage;
	private Skin skin;

	public Mob(TiledMapTileLayer collision, boolean gravity, float x, float y) {
		this.collisionLayer = collision;
		this.hasGravity = gravity;
		this.x = x;
		this.y = y;
	}
	
	public abstract void render(SpriteBatch batch);
	protected abstract void update();
	public abstract void dispose();
	
	protected void move(float xa, float ya)
	  {
	    if ((xa != 0.0F) && (ya != 0.0F))
	    {
	      move(xa, 0.0F);
	      move(0.0F, ya);
	      return;
	    }
	    float oldX = this.x;float oldY = this.y;float tileWidth = this.collisionLayer.getTileWidth();float tileHeight = this.collisionLayer.getTileHeight();
	    boolean CollideX = false;boolean CollideY = false;boolean hasMessage = false;
	    
	    int side = 0;
	    
	    this.x += xa;
	    
	    if (xa > 0.0F) {
	      side = 2;
	    }
	    if (xa < 0.0F) {
	      side = 1;
	    }
	    
	    if (side == 2)
	    {
	    	TiledMapTileLayer.Cell cellX = this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)((getY() + this.height) / tileHeight));
	      CollideX = isCellBlocked(cellX);
	      if (!CollideX) {
	    	 TiledMapTileLayer.Cell cellXX = this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)((getY() + this.height / 2) / tileHeight));
	        CollideX = isCellBlocked(cellXX);
	        hasMessage = isCellMessage(cellXX);
	      }
	      if (!CollideX) {
	    	  TiledMapTileLayer.Cell cellXXX=this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)(getY() / tileHeight));
	        CollideX = isCellBlocked(cellXXX);
	      }
	    }
	    if (side == 1)
	    {
	    	TiledMapTileLayer.Cell cell2X = this.collisionLayer.getCell((int)(getX() / tileWidth), (int)((getY() + this.height) / tileHeight));
	      CollideX = isCellBlocked(cell2X);
	      if (!CollideX) {
	    	  TiledMapTileLayer.Cell cell2XX = this.collisionLayer.getCell((int)(getX() / tileWidth), (int)((getY() + this.height / 2) / tileHeight));
	        CollideX = isCellBlocked(cell2XX);
	      }
	      if (!CollideX) {
	    	  TiledMapTileLayer.Cell cell2XXX = this.collisionLayer.getCell((int)(getX() / tileWidth), (int)(getY() / tileHeight));
	        CollideX = isCellBlocked(cell2XXX);
	      }
	    }
	    if (CollideX)
	    {
	      setX(oldX);
	      xa = 0.0F;
	    }
	    this.y += ya;
	    if (ya > 0.0F) {
	      side = 3;
	    }
	    if (ya < 0.0F) {
	      side = 0;
	    }
	    if (side == 3)
	    {
	    	TiledMapTileLayer.Cell cellY = this.collisionLayer.getCell((int)(getX() / tileWidth), (int)((getY() + this.height) / tileHeight));
	      CollideY = isCellBlocked(cellY);
	      if (!CollideY) {
	    	  TiledMapTileLayer.Cell cellYY = this.collisionLayer.getCell((int)((getX() + this.width / 2) / tileWidth), (int)((getY() + this.height) / tileHeight)); 
	        CollideY = isCellBlocked(cellYY);
	      }
	      if (!CollideY) {
	    	  TiledMapTileLayer.Cell cellYYY = this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)((getY() + this.height) / tileHeight));
	        CollideY = isCellBlocked(cellYYY);
	      }
	    }
	    if (side == 0)
	    {
	    	TiledMapTileLayer.Cell cell2Y =this.collisionLayer.getCell((int)(getX() / tileWidth), (int)(getY() / tileHeight)); 
	      CollideY = isCellBlocked(cell2Y);
	      hasMessage = isCellMessage(cell2Y);
	      if (!CollideY) {
	    	  TiledMapTileLayer.Cell cell2YY = this.collisionLayer.getCell((int)((getX() + this.width / 2) / tileWidth), (int)(getY() / tileHeight));
	        CollideY = isCellBlocked(cell2YY);
	        hasMessage = isCellMessage(cell2YY);
	      }
	      if (!CollideY) {
	    	  TiledMapTileLayer.Cell cell2YYY = this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)(getY() / tileHeight));
	        CollideY = isCellBlocked(cell2YYY);
	        hasMessage = isCellMessage(cell2YYY);
	      }
	    }
	    if (CollideY)
	    {
	      setY(oldY);
	      ya = 0.0F;
	    }
	    
	    
	  }
	
	protected void processMessage(TiledMapTileLayer.Cell cell, boolean hasMessage){
		final TiledMapTileLayer.Cell processingCell = cell;
		if((this instanceof Player) && (hasMessage) && getStage() !=null && getSkin() !=null && processingCell !=null && Gdx.input.isKeyJustPressed(Keys.R)){
	    	new DialogMessage("Sign", getSkin(), "dialog"){
	    		{
	    			init(getCellMessage(processingCell), "Back");
	    			
	    		}
	    	}.show(stage);
	    }
	}
	
	protected boolean isCellBlocked(TiledMapTileLayer.Cell cell){ return (cell.getTile() != null) && (cell.getTile().getProperties().containsKey("Solid"));}
	protected boolean isCellMessage(TiledMapTileLayer.Cell cell){ return (cell.getTile() !=null) && (cell.getTile()).getProperties().containsKey("Message");}
	
	protected String getCellMessage(TiledMapTileLayer.Cell cell){if(cell !=null){return (String) cell.getTile().getProperties().get("Message");}return null;}
	
	public float getX(){ return this.x;}
	public float getY(){return this.y;}
	public float getSpeed(){return this.speed;}
	public int getWidth(){ return this.width;}
	public int getHeight(){return this.height;}
	public boolean hasGravity(){return this.hasGravity;}
	public void setX(float x){ this.x = x;}
	public void setY(float y){ this.y = y;}
	public void setSpeed(float speed){this.speed = speed;}
	public void setGravity(boolean gravity){this.hasGravity = gravity;}
	public Stage getStage() {return stage;}
	public void addStage(Stage stage) {this.stage = stage;}
	public Skin getSkin() {return skin;}
	public void addSkin(Skin skin) {this.skin = skin;}
}