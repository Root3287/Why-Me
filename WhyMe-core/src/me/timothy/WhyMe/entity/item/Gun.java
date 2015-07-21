package me.timothy.WhyMe.entity.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.timothy.WhyMe.entity.mob.player.Player;

public class Gun {
	private Texture tex;
	private Sprite sp;
	private int x =0, y= 0;
	private boolean inInv = false;
	private Player p;
	public Gun(Player p,int x, int y){
		this.tex = new Texture(Gdx.files.internal("images/textures/items.png"));
		this.sp = new Sprite(this.tex,64,0,16,16);
		this.x = x;
		this.y = y;
		this.p = p;
	}
	public void render(SpriteBatch b){
		update();
		if(!inInv){
			b.draw(this.sp, this.x, this.y);
		}
	}
	public void update(){
		if((int)p.getX() >= this.x && p.getY() >= this.y && !inInv){
			inInv = true;
			if(p.addItem("Gun")){
				System.out.println("Add gun! inventory size"+ p.getInventroy().size);	
			}else{
				 System.out.println("INVENTORY FULL");
			}
		}
	}
}
