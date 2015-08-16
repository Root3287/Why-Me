package me.timothy.WhyMe.entity.item.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.timothy.WhyMe.entity.item.Item;

public class Gun extends Item{
	private Sprite sp;
	public Gun(int x, int y){
		this.tex = new Texture(Gdx.files.internal("images/textures/items.png"));
		this.sp = new Sprite(this.tex,4*16,0,16,16);
		this.x = x;
		this.y = y;
	}
	public void render(SpriteBatch b){
		update();
		b.draw(this.sp, this.x, this.y);
	}
	public void update(){
		// Save the following line of code for later use ;)
		//if((int)p.getX() >= this.x && p.getY() >= this.y && !inInv){
	}
}