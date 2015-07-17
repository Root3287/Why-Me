package me.timothy.WhyMe.entity.player;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.Array;

import me.timothy.WhyMe.input.Keyboard;
import me.timothy.WhyMe.screen.MainMenu;

public class Player
{
  private boolean hasGravity = false;
  private boolean canJump = false;
  private int side = 0;
  private int height = 14;
  private int width = 14;
  private Texture PlayerTex;
  private Sprite SpriteFront;
  private Sprite SpriteFront2;
  private Sprite SpriteBack;
  private Sprite SpriteBack2;
  private Sprite SpriteLeft;
  private Sprite SpriteLeft2;
  private Sprite SpriteRight;
  private Sprite SpriteRight2;
  private Sprite current;
  private int anim;
  private TiledMapTileLayer collisionLayer;
  private float x;
  private float y;
  private float xa;
  private float ya;
  private float speed;
  @SuppressWarnings("unused")
private InputProcessor inputProcess;
  private Array<String> inventory;
  
  public Player(TiledMapTileLayer collision)
  {
    this.PlayerTex = new Texture(Gdx.files.internal("images/player/Player-A.png"));
    this.PlayerTex.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
    this.SpriteFront = new Sprite(this.PlayerTex, 0, 0, 16, 16);
    this.SpriteFront2 = new Sprite(this.PlayerTex, 0, 16, 16, 16);
    this.SpriteLeft = new Sprite(this.PlayerTex, 16, 0, 16, 16);
    this.SpriteLeft2 = new Sprite(this.PlayerTex, 16, 16, 16, 16);
    this.SpriteRight = new Sprite(this.PlayerTex, 32, 0, 16, 16);
    this.SpriteRight2 = new Sprite(this.PlayerTex, 32, 16, 16, 16);
    this.SpriteBack = new Sprite(this.PlayerTex, 48, 0, 16, 16);
    this.SpriteBack2 = new Sprite(this.PlayerTex, 48, 16, 16, 16);
    this.hasGravity = false;
    this.inputProcess = Gdx.input.getInputProcessor();
    this.collisionLayer = collision;
    this.speed = 2F;
    this.inventory = new Array<String>();
    for(int i=0; i<=30; i++){
    	inventory.add("Knee"+i);
    	System.out.println("ADDED "+ inventory.get(i));
    }
  }
  
  public void render(SpriteBatch batch)
  {
    update();
    switch (this.side)
    {
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
    }
  }
  
  private void update()
  {
	if(Keyboard.exit)
		((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenu());
    this.xa = 0.0F;
    this.ya = 0.0F;
    if (this.anim < 7500) {
      this.anim += 1;
    } else {
      this.anim = 0;
    }
    if (!this.hasGravity)
    {
      if (Keyboard.up) {
        this.ya += this.speed;
      }
      if (Keyboard.down) {
        this.ya = (-this.speed);
      }
      if (Keyboard.right) {
        this.xa = this.speed;
      }
      if (Keyboard.left) {
        this.xa = (-this.speed);
      }
    }
    else
    {
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
      if ((Keyboard.jump) && 
        (this.canJump))
      {
        this.ya = (this.speed * 1.8F);
        this.canJump = false;
      }
    }
    if ((this.xa != 0.0F) || (this.ya != 0.0F))
    {
      move(this.xa, this.ya);
    }
    else
    {
    }
    if (Keyboard.toggle) {
      this.hasGravity = (!this.hasGravity);
    }
    System.out.println("X:" + this.x + " Y:" + this.y + " Gravity: " + this.hasGravity + " CanJump: " + this.canJump + " Delta: " + Gdx.graphics.getDeltaTime());
  }
  
  public void move(float xa, float ya)
  {
    if ((xa != 0.0F) && (ya != 0.0F))
    {
      move(xa, 0.0F);
      move(0.0F, ya);
      return;
    }
    float oldX = this.x;float oldY = this.y;float tileWidth = this.collisionLayer.getTileWidth();float tileHeight = this.collisionLayer.getTileHeight();
    boolean CollideX = false;boolean CollideY = false;
    
    this.x += xa;
    if (xa > 0.0F) {
      this.side = 2;
    }
    if (xa < 0.0F) {
      this.side = 1;
    }
    if (this.side == 2)
    {
      CollideX = isCellBlocked(this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)((getY() + this.height) / tileHeight)));
      if (!CollideX) {
        CollideX = isCellBlocked(this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)((getY() + this.height / 2) / tileHeight)));
      }
      if (!CollideX) {
        CollideX = isCellBlocked(this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)(getY() / tileHeight)));
      }
    }
    if (this.side == 1)
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
      this.side = 3;
    }
    if (ya < 0.0F) {
      this.side = 0;
    }
    if (this.side == 3)
    {
      CollideY = isCellBlocked(this.collisionLayer.getCell((int)(getX() / tileWidth), (int)((getY() + this.height) / tileHeight)));
      if (!CollideY) {
        CollideY = isCellBlocked(this.collisionLayer.getCell((int)((getX() + this.width / 2) / tileWidth), (int)((getY() + this.height) / tileHeight)));
      }
      if (!CollideY) {
        CollideY = isCellBlocked(this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)((getY() + this.height) / tileHeight)));
      }
    }
    if (this.side == 0)
    {
      CollideY = isCellBlocked(this.collisionLayer.getCell((int)(getX() / tileWidth), (int)(getY() / tileHeight)));
      if (!CollideY) {
        CollideY = isCellBlocked(this.collisionLayer.getCell((int)((getX() + this.width / 2) / tileWidth), (int)(getY() / tileHeight)));
      }
      if (!CollideY) {
        CollideY = isCellBlocked(this.collisionLayer.getCell((int)((getX() + this.width) / tileWidth), (int)(getY() / tileHeight)));
      }
    }
    if (this.hasGravity) {
      this.canJump = CollideY;
    }
    if (CollideY)
    {
      setY(oldY);
      ya = 0.0F;
    }
  }
  
  private boolean isCellBlocked(TiledMapTileLayer.Cell cell)
  {
    return (cell.getTile() != null) && (cell.getTile().getProperties().containsKey("Solid"));
  }
  
  public boolean hasGravity()
  {
    return this.hasGravity;
  }
  
  public void setGravity(boolean value)
  {
    this.hasGravity = value;
  }
  
  public float getX()
  {
    return this.x;
  }
  
  public float getY()
  {
    return this.y;
  }
  
  public void setX(float x)
  {
    this.x = x;
  }
  
  public void setY(float y)
  {
    this.y = y;
  }
  
  public void canJump(boolean canJump)
  {
    this.canJump = canJump;
  }
  
  public boolean canJump()
  {
    return this.canJump;
  }
  
  public void setYa(float ya)
  {
    this.ya = ya;
  }
  
  public float getYa()
  {
    return this.ya;
  }
  
  public void dispose() {
	  
  }
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
  public Array<String> getInventroy(){
	return inventory;
  }
}