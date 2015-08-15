package me.timothy.WhyMe.entity.item.items;

import me.timothy.WhyMe.entity.item.Item;
import me.timothy.WhyMe.entity.mob.player.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gun extends Item{
	private Sprite sp;
	private Player p;
	public Gun(Player p,int x, int y){
		this.tex = new Texture(Gdx.files.internal("images/textures/items.png"));
		this.sp = new Sprite(this.tex,4*16,0,16,16);
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