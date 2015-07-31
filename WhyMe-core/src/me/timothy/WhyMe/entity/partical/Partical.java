package me.timothy.WhyMe.entity.partical;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.timothy.WhyMe.entity.mob.Mob;

public abstract class Partical {
	protected float x,y,xa,ya;
	protected int life;
	protected Texture img;
	protected Sprite partical;
	protected Mob mob;
	public Partical(float x, float y, int life){
		this.x = x;
		this.y = y;
		this.life = life;
	}
	public abstract void render(SpriteBatch batch);
	protected abstract void update();
	public abstract void dispose();
	public void addMob(Mob mob){
		this.mob = mob;
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void setTexture(FileHandle file){
		this.img = new Texture(file);
	}
	public void setSprite(Texture texture, int x, int y, int width, int height){
		this.partical = new Sprite(texture,x, y, width, height);
	}
}