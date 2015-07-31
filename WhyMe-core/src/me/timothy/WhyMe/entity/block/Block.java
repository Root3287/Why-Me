package me.timothy.WhyMe.entity.block;

import me.timothy.WhyMe.entity.mob.player.Player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public abstract class Block {
	protected Array<Block> instanceList;
	protected float x,y;
	protected Texture tex;
	protected Player p;
	
	public Block(Player p, float x, float y){
		this.x = x;
		this.y = y;
		this.p = p;
		this.instanceList = new Array<Block>();
	}
	
	public abstract void draw(SpriteBatch batch);
	public void update(){}
	
	public Array<Block> getInstanceList() {
		return instanceList;
	}
	public void setinstanceList(Array<Block> itemList) {
		this.instanceList = itemList;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public Texture getTex() {
		return tex;
	}
	public void setTex(Texture tex) {
		this.tex = tex;
	}
}
