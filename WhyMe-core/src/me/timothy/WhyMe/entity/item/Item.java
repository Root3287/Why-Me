package me.timothy.WhyMe.entity.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Item {
	protected Texture tex;
	protected float x =0, y= 0;
	protected boolean inInv = false;
	
	public abstract void render(SpriteBatch b);
	public abstract void update();
	
	public Texture getTex() {return tex;}
	public void setTex(Texture tex) {this.tex = tex;}
	public float getX() {return x;}
	public void setX(int x) {this.x = x;}
	public float getY() {return y;}
	public void setY(int y) {this.y = y;}
	public boolean isInInv() {return inInv;}
	public void setInInv(boolean inInv) {this.inInv = inInv;}
}