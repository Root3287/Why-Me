package me.timothy.WhyMe.entity.mob;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public abstract class Mob {
	protected float x, y ,ya,xa,speed;
	protected int width, height;
	protected Texture tex;
	protected TiledMapTileLayer collisionLayer;
	protected boolean hasGravity;
	
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
	    boolean CollideX = false;boolean CollideY = false;
	    
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
	      CollideX = isCellBlocked(this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)((getY() + this.height) / tileHeight)));
	      if (!CollideX) {
	        CollideX = isCellBlocked(this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)((getY() + this.height / 2) / tileHeight)));
	      }
	      if (!CollideX) {
	        CollideX = isCellBlocked(this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)(getY() / tileHeight)));
	      }
	    }
	    if (side == 1)
	    {
	      CollideX = isCellBlocked(this.collisionLayer.getCell((int)(getX() / tileWidth), (int)((getY() + this.height) / tileHeight)));
	      if (!CollideX) {
	        CollideX = isCellBlocked(this.collisionLayer.getCell((int)(getX() / tileWidth), (int)((getY() + this.height / 2) / tileHeight)));
	      }
	      if (!CollideX) {
	        CollideX = isCellBlocked(this.collisionLayer.getCell((int)(getX() / tileWidth), (int)(getY() / tileHeight)));
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
	      CollideY = isCellBlocked(this.collisionLayer.getCell((int)(getX() / tileWidth), (int)((getY() + this.height) / tileHeight)));
	      if (!CollideY) {
	        CollideY = isCellBlocked(this.collisionLayer.getCell((int)((getX() + this.width / 2) / tileWidth), (int)((getY() + this.height) / tileHeight)));
	      }
	      if (!CollideY) {
	        CollideY = isCellBlocked(this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)((getY() + this.height) / tileHeight)));
	      }
	    }
	    if (side == 0)
	    {
	      CollideY = isCellBlocked(this.collisionLayer.getCell((int)(getX() / tileWidth), (int)(getY() / tileHeight)));
	      if (!CollideY) {
	        CollideY = isCellBlocked(this.collisionLayer.getCell((int)((getX() + this.width / 2) / tileWidth), (int)(getY() / tileHeight)));
	      }
	      if (!CollideY) {
	        CollideY = isCellBlocked(this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)(getY() / tileHeight)));
	      }
	    }
	    if (CollideY)
	    {
	      setY(oldY);
	      ya = 0.0F;
	    }
	  }
	
	protected boolean isCellBlocked(TiledMapTileLayer.Cell cell){ return (cell.getTile() != null) && (cell.getTile().getProperties().containsKey("Solid"));}
	
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
}
