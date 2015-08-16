package me.timothy.WhyMe.entity.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.timothy.WhyMe.entity.mob.player.Player;

public abstract class Item {
	protected Texture tex;
	protected float x =0, y= 0;
	protected boolean inInv = false;
	protected Player p;
	
	public abstract void render(SpriteBatch b);
	public abstract void update();
	
	public void addItemUpdate(Item item){
		if(p !=null){
			if(p.getX() >= x && p.getY() >= y){
				if(p.getInventroy().size <= 32){
					  p.getInventroy().add(item);
					  inInv = true;
				}
			}
		}
	}
	public void releaseItemUpdate(){
		if(p !=null){
			p.getInventroy().removeIndex(0);
			inInv = false;
		}
	}
	
	
	public Player getPlayer() {return p;}
	public void addPlayer(Player p) {this.p = p;}
	public Texture getTex() {return tex;}
	public void setTex(Texture tex) {this.tex = tex;}
	public float getX() {return x;}
	public void setX(int x) {this.x = x;}
	public float getY() {return y;}
	public void setY(int y) {this.y = y;}
	public boolean isInInv() {return inInv;}
	public void setInInv(boolean inInv) {this.inInv = inInv;}
}