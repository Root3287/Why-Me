package me.timothy.WhyMe.entity.partical;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.timothy.WhyMe.entity.player.Player;

public abstract class Partical {
	protected float x,y,xa,ya;
	protected Texture img;
	protected Sprite partical;
	// THIS IS JUST AN HOLDER... IT WILL EXTENDS MOB
	protected Player p;
	public abstract void show();
	public abstract void render(SpriteBatch batch);
	public abstract void update();
	public abstract void dispose();
	public abstract void resize(int width, int height);
	
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
}
