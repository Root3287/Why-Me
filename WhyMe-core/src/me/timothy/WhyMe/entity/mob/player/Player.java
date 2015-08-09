package me.timothy.WhyMe.entity.mob.player;

import me.timothy.WhyMe.entity.mob.Mob;
import me.timothy.WhyMe.input.Keyboard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.Array;

public class Player extends Mob{
	private boolean hasGravity = false, canJump = false, paused;
  
	private int side = 0,anim;
  
	private Sprite SpriteFront, SpriteFront2, SpriteBack, SpriteBack2, SpriteLeft, SpriteLeft2, SpriteRight, SpriteRight2, current;
  
	//Still dont know why this is here but will keep it because it appearantly keep the code running...
	@SuppressWarnings("unused")
	private InputProcessor inputProcess;
  
	private Array<String> inventory;
  
	public Player(TiledMapTileLayer collision, float x, float y){
		super(collision, false, x, y);
		this.tex = new Texture(Gdx.files.internal("images/player/Player-A.png"));
		this.SpriteFront = new Sprite(this.tex, 0, 0, 16, 16);
		this.SpriteFront2 = new Sprite(this.tex, 0, 16, 16, 16);
		this.SpriteLeft = new Sprite(this.tex, 16, 0, 16, 16);
		this.SpriteLeft2 = new Sprite(this.tex, 16, 16, 16, 16);
		this.SpriteRight = new Sprite(this.tex, 32, 0, 16, 16);
		this.SpriteRight2 = new Sprite(this.tex, 32, 16, 16, 16);
		this.SpriteBack = new Sprite(this.tex, 48, 0, 16, 16);
		this.SpriteBack2 = new Sprite(this.tex, 48, 16, 16, 16);
		this.hasGravity = false;
		this.inputProcess = Gdx.input.getInputProcessor();
		this.collisionLayer = collision;
		this.speed = 2F;
		this.inventory = new Array<String>();
		this.width = 16;
		this.height = 14;
	}
  
	public void render(SpriteBatch batch){
		update();
	    switch (this.side){
	    case 0: 
	    	this.current = this.SpriteFront;
	    	if (this.anim % 50 > 10) {
	    		this.current = this.SpriteFront;
	    	} else {
	    		this.current = this.SpriteFront2;
	    	}
	    	batch.draw(this.current, this.x, this.y, this.width, this.height);
	      break;
	    case 1: 
	    	this.current = this.SpriteLeft;
	    	if (this.anim % 50 > 10) {
	    		this.current = this.SpriteLeft;
	    	} else {
	    		this.current = this.SpriteLeft2;
	    	}
	    	batch.draw(this.current, this.x, this.y, this.width, this.height);
	      break;
	    case 2: 
	    	this.current = this.SpriteRight;
	    	if (this.anim % 50 > 10) {
	    		this.current = this.SpriteRight;
	    	} else {
	    		this.current = this.SpriteRight2;
	    	}
	    	batch.draw(this.current, this.x, this.y, this.width, this.height);
	      break;
	    case 3: 
	    	this.current = this.SpriteBack;
	    	if (this.anim % 50 > 10) {
	    		this.current = this.SpriteBack;
	    	} else {
	    		this.current = this.SpriteBack2;
	    	}
	    	batch.draw(this.current, this.x, this.y, this.width, this.height);
	    	break;
	    }
	  }
  
	protected void update(){
		this.xa = 0.0F;
		this.ya = 0.0F;
		if (this.anim < 7500) {
			this.anim += 1;
		} else {
			this.anim = 0;
		}
		if (!this.hasGravity){
			if (Keyboard.up) {
				this.ya = this.speed;
				this.side = 3;
			}
			if (Keyboard.down) {
				this.ya = (-this.speed);
				this.side = 0;
			}
			if (Keyboard.right) {
				this.xa = this.speed;
				this.side = 2;
			}
			if (Keyboard.left) {
				this.xa = (-this.speed);
				this.side = 1;
			}
		}else{
			this.ya -= this.speed / Gdx.graphics.getDeltaTime();
			if (this.ya > this.speed) {
				this.ya = this.speed;
			} else if (this.ya < -this.speed) {
				this.ya = (-this.speed);
			}
			if (Keyboard.left) {
				this.xa -= 1.0F;
			}
			if (Keyboard.right) {
				this.xa += 1.0F;
			}
			if ((Keyboard.jump) && (this.canJump)){
				this.ya = (this.speed * 1.8F);
				this.canJump = false;
			}	
		}
		if ((this.xa != 0.0F) || (this.ya != 0.0F)){
			move(this.xa, this.ya);
		}else{
		
		}
		if (Keyboard.toggle) {
			this.hasGravity = (!this.hasGravity);
		}
		System.out.println("X:" + this.x + " Y:" + this.y + " Gravity: " + this.hasGravity + " CanJump: " + this.canJump + " Delta: " + Gdx.graphics.getDeltaTime());
	}
  
  public void canJump(boolean canJump){ this.canJump = canJump;}
  public boolean canJump(){return this.canJump;}
  
  public void removeItem(String item){
	  if(inventory.contains(item, true)){
		  inventory.removeValue(item,true);
	  }
  }
  public boolean addItem(String item){
	  if(!(inventory.size<=32)){
		  inventory.add(item);
		  return true;
	  }
	  return false;
  }
  public Array<String> getInventroy(){return inventory;}

  @Override
  public void dispose(){tex.dispose();}
  public boolean isPaused(){return paused;}
  public void pause(boolean pause){this.paused = pause;}
}