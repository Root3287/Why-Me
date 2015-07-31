package me.timothy.WhyMe.entity.player;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class GlitchedPlayer
{
  //private boolean col = false;
  private boolean walking = false;
  private boolean onGround = true;
  private boolean hasGravity = false;
  private int side = 0;
  private Vector2 velocity;
  private Texture PlayerTex;
  private Sprite SpriteFront;
  private Sprite SpriteFront2;
  private Sprite SpriteBack;
  private Sprite SpriteBack2;
  private Sprite SpriteLeft;
  private Sprite SpriteLeft2;
  private Sprite SpriteRight;
  private Sprite SpriteRight2;
  private Sprite SpriteFront_1;
  private Sprite SpriteFront2_1;
  //private Sprite SpriteBack_1;
  //private Sprite SpriteBack2_1;
  private Sprite SpriteLeft_1;
  private Sprite SpriteLeft2_1;
  private Sprite SpriteRight_1;
  private Sprite SpriteRight2_1;
  private Sprite SpriteFront_2;
  private Sprite SpriteFront2_2;
  //private Sprite SpriteBack_2;
  //private Sprite SpriteBack2_2;
  private Sprite SpriteLeft_2;
  private Sprite SpriteLeft2_2;
  private Sprite SpriteRight_2;
  private Sprite SpriteRight2_2;
  private Sprite SpriteFront_3;
  private Sprite SpriteFront2_3;
  //private Sprite SpriteBack_3;
  //private Sprite SpriteBack2_3;
  private Sprite SpriteLeft_3;
  private Sprite SpriteLeft2_3;
  private Sprite SpriteRight_3;
  private Sprite SpriteRight2_3;
  private Sprite current;
  private int anim;
  private TiledMapTileLayer collisionLayer;
  
  public GlitchedPlayer(TiledMapTileLayer collision)
  {
    this.velocity = new Vector2();
    this.PlayerTex = new Texture(Gdx.files.internal("images/player/Player-Glitched.png"));
    this.PlayerTex.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
    
    this.SpriteFront = new Sprite(this.PlayerTex, 0, 0, 16, 16);
    this.SpriteFront2 = new Sprite(this.PlayerTex, 0, 16, 16, 16);
    this.SpriteLeft = new Sprite(this.PlayerTex, 16, 0, 16, 16);
    this.SpriteLeft2 = new Sprite(this.PlayerTex, 16, 16, 16, 16);
    this.SpriteRight = new Sprite(this.PlayerTex, 32, 0, 16, 16);
    this.SpriteRight2 = new Sprite(this.PlayerTex, 32, 16, 16, 16);
    this.SpriteBack = new Sprite(this.PlayerTex, 48, 0, 16, 16);
    this.SpriteBack2 = new Sprite(this.PlayerTex, 48, 16, 16, 16);
    
    this.SpriteFront_1 = new Sprite(this.PlayerTex, 64, 0, 16, 16);
    this.SpriteFront2_1 = new Sprite(this.PlayerTex, 64, 16, 16, 16);
    this.SpriteLeft_1 = new Sprite(this.PlayerTex, 80, 0, 16, 16);
    this.SpriteLeft2_1 = new Sprite(this.PlayerTex, 80, 16, 16, 16);
    this.SpriteRight_1 = new Sprite(this.PlayerTex, 96, 0, 16, 16);
    this.SpriteRight2_1 = new Sprite(this.PlayerTex, 96, 16, 16, 16);
    //this.SpriteBack_1 = new Sprite(this.PlayerTex, 112, 0, 16, 16);
    //this.SpriteBack2_1 = new Sprite(this.PlayerTex, 112, 16, 16, 16);
    
    this.SpriteFront_2 = new Sprite(this.PlayerTex, 128, 0, 16, 16);
    this.SpriteFront2_2 = new Sprite(this.PlayerTex, 128, 16, 16, 16);
    this.SpriteLeft_2 = new Sprite(this.PlayerTex, 144, 0, 16, 16);
    this.SpriteLeft2_2 = new Sprite(this.PlayerTex, 144, 16, 16, 16);
    this.SpriteRight_2 = new Sprite(this.PlayerTex, 160, 0, 16, 16);
    this.SpriteRight2_2 = new Sprite(this.PlayerTex, 160, 16, 16, 16);
    //this.SpriteBack_2 = new Sprite(this.PlayerTex, 176, 0, 16, 16);
    //this.SpriteBack2_2 = new Sprite(this.PlayerTex, 176, 16, 16, 16);
    
    this.SpriteFront_3 = new Sprite(this.PlayerTex, 192, 0, 16, 16);
    this.SpriteFront2_3 = new Sprite(this.PlayerTex, 192, 16, 16, 16);
    this.SpriteLeft_3 = new Sprite(this.PlayerTex, 208, 0, 16, 16);
    this.SpriteLeft2_3 = new Sprite(this.PlayerTex, 208, 16, 16, 16);
    this.SpriteRight_3 = new Sprite(this.PlayerTex, 224, 0, 16, 16);
    this.SpriteRight2_3 = new Sprite(this.PlayerTex, 224, 16, 16, 16);
    //this.SpriteBack_3 = new Sprite(this.PlayerTex, 240, 0, 16, 16);
    //this.SpriteBack2_3 = new Sprite(this.PlayerTex, 240, 16, 16, 16);
    
    this.hasGravity = false;
    this.onGround = false;
    
    this.collisionLayer = collision;
  }
  
  public void render(SpriteBatch batch)
  {
    update();
    Random rand = new Random(2126655576L);
    switch (this.side)
    {
    case 0: 
      this.current = this.SpriteFront;
      if (this.walking) {
        if (this.anim % 20 > 2.5D) {
          this.current = this.SpriteFront;
        } else if (this.anim % 20 > 5) {
          this.current = this.SpriteFront_1;
        } else if (this.anim % 20 > 7.5D) {
          this.current = this.SpriteFront_2;
        } else if (this.anim % 20 > 10) {
          this.current = this.SpriteFront_3;
        } else if (rand.nextInt(345) % 50 < 10) {
          this.current = this.SpriteFront2;
        } else if (rand.nextInt(345) % 50 > 20) {
          this.current = this.SpriteFront2_1;
        } else if (rand.nextInt(345) % 50 > 30) {
          this.current = this.SpriteFront2_2;
        } else if (rand.nextInt(345) % 50 < 40) {
          this.current = this.SpriteFront2_3;
        } else if (rand.nextInt(345) % 50 < 10) {
          this.current = this.SpriteFront2;
        } else if (rand.nextInt(345) % 50 > 20) {
          this.current = this.SpriteFront2_1;
        } else if (rand.nextInt(345) % 50 > 30) {
          this.current = this.SpriteFront2_2;
        } else if (rand.nextInt(345) % 50 < 45) {
          this.current = this.SpriteFront2_3;
        }
      }
      batch.draw(this.current, this.velocity.x, this.velocity.y, 48.0F, 48.0F);
      break;
    case 1: 
      this.current = this.SpriteLeft;
      if (this.walking) {
        if (this.anim % 20 > 2.5D) {
          this.current = this.SpriteLeft;
        } else if (this.anim % 20 > 5) {
          this.current = this.SpriteLeft_1;
        } else if (this.anim % 20 > 7.5D) {
          this.current = this.SpriteLeft_2;
        } else if (this.anim % 20 > 10) {
          this.current = this.SpriteLeft_3;
        } else if (rand.nextInt(345) % 20 > 2.5D) {
          this.current = this.SpriteLeft2;
        } else if (rand.nextInt(345) % 20 > 5) {
          this.current = this.SpriteLeft2_1;
        } else if (rand.nextInt(345) % 20 > 7.5D) {
          this.current = this.SpriteLeft2_2;
        } else if (rand.nextInt(345) % 20 > 10) {
          this.current = this.SpriteLeft2_3;
        }
      }
      batch.draw(this.current, this.velocity.x, this.velocity.y, 48.0F, 48.0F);
      break;
    case 2: 
      this.current = this.SpriteRight;
      if (this.walking) {
        if (this.anim % 20 > 2.5D) {
          this.current = this.SpriteRight;
        } else if (this.anim % 20 > 5) {
          this.current = this.SpriteRight_1;
        } else if (this.anim % 20 > 7.5D) {
          this.current = this.SpriteRight_2;
        } else if (this.anim % 20 > 10) {
          this.current = this.SpriteRight_3;
        } else if (rand.nextInt(345) % 20 > 2.5D) {
          this.current = this.SpriteRight2;
        } else if (rand.nextInt(345) % 20 > 5) {
          this.current = this.SpriteRight2_1;
        } else if (rand.nextInt(345) % 20 > 7.5D) {
          this.current = this.SpriteRight2_2;
        } else if (rand.nextInt(345) % 20 > 10) {
          this.current = this.SpriteRight2_3;
        }
      }
      batch.draw(this.current, this.velocity.x, this.velocity.y, 48.0F, 48.0F);
      break;
    case 3: 
      this.current = this.SpriteBack;
      if (this.walking) {
        if (this.anim % 20 > 10) {
          this.current = this.SpriteBack;
        } else {
          this.current = this.SpriteBack2;
        }
      }
      batch.draw(this.current, this.velocity.x, this.velocity.y, 48.0F, 48.0F);
    }
  }
  
  private void update()
  {
    if (this.anim < 9999999) {
      this.anim += 1;
    } else {
      this.anim = 0;
    }
    Keyboard();
    System.out.println("X:" + this.velocity.x + " Y:" + this.velocity.y + "Gravity: " + this.hasGravity);
  }
  
  private void Keyboard()
  {
    this.walking = false;
    if (this.hasGravity)
    {
      if (!this.onGround)
      {
        this.velocity.y -= 5.0F;
        if (this.velocity.y <= 0.0F) {
          this.onGround = true;
        } else {
          this.onGround = false;
        }
      }
      if (Gdx.input.isKeyPressed(29))
      {
        this.velocity.x -= 5.0F;
        this.side = 1;
        this.walking = true;
      }
      if (Gdx.input.isKeyPressed(32))
      {
        this.velocity.x += 5.0F;
        this.side = 2;
        this.walking = true;
      }
      if ((Gdx.input.isKeyPressed(62)) && 
        (this.onGround))
      {
        this.velocity.y += 20.0F;
        this.onGround = false;
      }
    }
    else
    {
      if (Gdx.input.isKeyPressed(51)) {
        moveUp();
      }
      if (Gdx.input.isKeyPressed(47)) {
        moveDown();
      }
      if (Gdx.input.isKeyPressed(29)) {
        moveLeft();
      }
      if (Gdx.input.isKeyPressed(32)) {
        moveRight();
      }
    }
  }
  
  private boolean collisionDetection(float x, float y)
  {
    TiledMapTileLayer.Cell cell = this.collisionLayer.getCell((int)(x / this.collisionLayer.getTileWidth()), (int)(y / this.collisionLayer.getTileHeight()));
    return (cell != null) && (cell.getTile() != null) && (cell.getTile().getProperties().containsKey("Solid"));
  }
  
  private void moveDown()
  {
    float oldX = this.velocity.x;float oldY = this.velocity.y;
    if (!collisionDetection(this.velocity.x, this.velocity.y))
    {
      this.velocity.y -= 5.0F;
      this.side = 0;
      this.walking = true;
    }
    else
    {
      setXY(oldX, oldY + 16.0F);
    }
  }
  
  private void moveUp()
  {
    float oldX = this.velocity.x;float oldY = this.velocity.y;
    if (!collisionDetection(this.velocity.x, this.velocity.y))
    {
      this.velocity.y += 5.0F;
      this.side = 3;
      this.walking = true;
    }
    else
    {
      setXY(oldX, oldY - 16.0F);
    }
  }
  
  private void moveLeft()
  {
    float oldX = this.velocity.x;float oldY = this.velocity.y;
    if (!collisionDetection(this.velocity.x, this.velocity.y))
    {
      this.velocity.x -= 5.0F;
      this.side = 1;
      this.walking = true;
    }
    else
    {
      setXY(oldX + 16.0F, oldY);
    }
  }
  
  private void moveRight()
  {
    float oldX = this.velocity.x;float oldY = this.velocity.y;
    if (!collisionDetection(this.velocity.x, this.velocity.y))
    {
      this.velocity.x += 5.0F;
      this.side = 2;
      this.walking = true;
    }
    else
    {
      setXY(oldX - 16.0F, oldY);
    }
  }
  
  public boolean hasGravity()
  {
    return this.hasGravity;
  }
  
  public void setGravity(boolean value)
  {
    this.hasGravity = value;
  }
  
  public boolean onGround()
  {
    return this.onGround;
  }
  
  public void setGrounded(boolean value)
  {
    this.onGround = value;
  }
  
  public float getX()
  {
    return this.velocity.x;
  }
  
  public float getY()
  {
    return this.velocity.y;
  }
  
  public void setXY(float x, float y)
  {
    this.velocity.x = x;
    this.velocity.y = y;
  }
}
