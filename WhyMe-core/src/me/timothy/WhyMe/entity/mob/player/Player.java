package me.timothy.WhyMe.entity.mob.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import me.timothy.WhyMe.entity.item.Item;
import me.timothy.WhyMe.entity.mob.Mob;
import me.timothy.WhyMe.input.Keyboard;

public class Player extends Mob{
	private boolean paused;
  
	private int side = 0,anim;
  
	private Sprite SpriteFront, SpriteFront2, SpriteBack, SpriteBack2, SpriteLeft, SpriteLeft2, SpriteRight, SpriteRight2, current;
  
	//Still dont know why this is here but will keep it because it appearantly keep the code running...
	@SuppressWarnings("unused")
	private InputProcessor inputProcess;
  
	private Array<Item> inventory;
  
	public Player(TiledMapTileLayer collision, boolean gravity, float x, float y){
		super(collision, gravity, x, y);
		this.tex = new Texture(Gdx.files.internal("images/player/Player-A.png"));
		this.SpriteFront = new Sprite(this.tex, 0, 0, 16, 16);
		this.SpriteFront2 = new Sprite(this.tex, 0, 16, 16, 16);
		this.SpriteLeft = new Sprite(this.tex, 16, 0, 16, 16);
		this.SpriteLeft2 = new Sprite(this.tex, 16, 16, 16, 16);
		this.SpriteRight = new Sprite(this.tex, 32, 0, 16, 16);
		this.SpriteRight2 = new Sprite(this.tex, 32, 16, 16, 16);
		this.SpriteBack = new Sprite(this.tex, 48, 0, 16, 16);
		this.SpriteBack2 = new Sprite(this.tex, 48, 16, 16, 16);
		this.inputProcess = Gdx.input.getInputProcessor();
		this.collisionLayer = collision;
		this.speed = 2F;
		this.inventory = new Array<Item>();
		this.width = 16;
		this.height = 14;
		this.gravity = 1.8f;
		velocity = new Vector2();
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
		velocity.x = 0.0F;
		velocity.y = 0.0F;
		
		if (this.anim < 7500) {
			this.anim += 1;
		} else {
			this.anim = 0;
		}
		
		keyboard();
		
		move(velocity.x, velocity.y);
		//	System.out.println("X:" + this.x + " Y:" + this.y + " Gravity: " + this.hasGravity + " CanJump: " + this.canJump + " Delta: " + Gdx.graphics.getDeltaTime());
	}
	private void keyboard(){
		if (!this.hasGravity){
			if (Keyboard.up) {
				velocity.y = this.speed;
				this.side = 3;
			}
			if (Keyboard.down) {
				velocity.y = (-this.speed);
				this.side = 0;
			}
			if (Keyboard.right) {
				velocity.x = this.speed;
				this.side = 2;
			}
			if (Keyboard.left) {
				velocity.x = (-this.speed);
				this.side = 1;
			}
		}else{
			velocity.y = -gravity;
			
			if(velocity.y>gravity){
				velocity.y = gravity;
			}else if(velocity.y<-gravity){
				velocity.y = -gravity;
			}
			
			if(Keyboard.left){
				velocity.x = -(float) (speed);
				firstMove = true;
			}
			if(Keyboard.right){
				velocity.x = (float) (speed);
				firstMove = true;
			}
			if(Keyboard.jump && canJump){
				velocity.y = speed;
				firstMove = true;
				Timer.schedule(new Task(){
					@Override
					public void run() {
						canJump = false;
					}
				}, 0.2f);
			}
		}
	}
  
  public void canJump(boolean canJump){ this.canJump = canJump;}
  public boolean canJump(){return this.canJump;}
  
  public void removeItem(Item item){
	  if(inventory.contains(item, true)){
		  inventory.removeValue(item,true);
	  }
  }
  
  public boolean addItem(Item item){
	  if(!(inventory.size<=32)){
		  inventory.add(item);
		  return true;
	  }
	  return false;
  }
  public Array<Item> getInventroy(){return inventory;}

  @Override
  public void dispose(){tex.dispose();}
  public boolean isPaused(){return paused;}
  public void pause(boolean pause){this.paused = pause;}
  public int getSide(){return side;}
  public void setSide(int Side){this.side = Side;}
}