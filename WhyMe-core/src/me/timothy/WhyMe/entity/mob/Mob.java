package me.timothy.WhyMe.entity.mob;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public abstract class Mob {
	protected float x, y ,ya,xa,speed;
	protected int width, height;
	protected Texture tex;
	protected TiledMapTileLayer collisionLayer;
	protected boolean hasGravity=false, canJump = false;
	private Stage stage;
	private Skin skin;
	protected Vector2 velocity;
	
	public Mob(TiledMapTileLayer collision, boolean gravity, float x, float y) {
		this.collisionLayer = collision;
		this.hasGravity = gravity;
		this.x = x;
		this.y = y;
	}
	
	public abstract void render(SpriteBatch batch);
	protected abstract void update();
	public abstract void dispose();
	
	protected void move(float xa, float ya){
		if ((xa != 0.0F) && (ya != 0.0F)){
			move(xa, 0.0F);
			move(0.0F, ya);
			return;
	    }
		
	    float oldX = this.x;float oldY = this.y;float tileWidth = this.collisionLayer.getTileWidth();float tileHeight = this.collisionLayer.getTileHeight();
	    boolean CollideX = false;boolean CollideY = false;boolean hasMessage = false;
	    
	    int side = 0;
	    
	    this.x += xa;
	    
	    if (xa > 0.0F) {
	      side = 2; // Right
	    }
	    if (xa < 0.0F) {
	      side = 1; // Left
	    }
	    
	    if (side == 2){  // Right
	    	TiledMapTileLayer.Cell cellX = this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)((getY() + this.height) / tileHeight));
	    	CollideX = isCellBlocked(cellX);
	    	if (!CollideX) {
	    		TiledMapTileLayer.Cell cellXX = this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)((getY() + this.height / 2) / tileHeight));
	    		CollideX = isCellBlocked(cellXX);
	    	}
	    	if (!CollideX) {
	    		TiledMapTileLayer.Cell cellXXX=this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)(getY() / tileHeight));
	    		CollideX = isCellBlocked(cellXXX);
	    	}
	    }
	    if (side == 1){
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
	    
	   if (CollideX){
		   setX(oldX);
		   xa = 0.0F;
	   }
	   
	   this.y += ya;
	   
	   if (ya > 0.0F) {
		   side = 3; // Up
	   }
	   if (ya < 0.0F) {
		   side = 0; // DOWN
	   }
	    
	   if (side == 3){ // up
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
	  if (side == 0){
		  TiledMapTileLayer.Cell cell2Y =this.collisionLayer.getCell((int)(getX() / tileWidth), (int)(getY() / tileHeight)); 
	      CollideY = isCellBlocked(cell2Y);
	      if (!CollideY) {
	    	  TiledMapTileLayer.Cell cell2YY = this.collisionLayer.getCell((int)((getX() + this.width / 2) / tileWidth), (int)(getY() / tileHeight));
	    	  CollideY = isCellBlocked(cell2YY);
	      }
	      if (!CollideY) {
	    	  TiledMapTileLayer.Cell cell2YYY = this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)(getY() / tileHeight));
	    	  CollideY = isCellBlocked(cell2YYY);
	      }
	      canJump = CollideY;
	 }
	 if (CollideY){
		 setY(oldY);
		 ya = 0.0F;
	 }
	 if(hasMessage){ /*Just a filler to turn off warnings... */}
	 System.out.println("X: "+x+"; Y: "+y+";");
	}
	
	protected boolean isCellBlocked(TiledMapTileLayer.Cell cell){ 
		if(cell.getTile() !=null){
			return cell.getTile().getProperties().containsKey("Solid");
		}
		return false;
	}
	
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
	public boolean isCanJump() {return canJump;}
	public void setCanJump(boolean canJump) {this.canJump = canJump;}
}