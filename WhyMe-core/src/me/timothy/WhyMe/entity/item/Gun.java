package me.timothy.WhyMe.entity.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gun {
	private Texture tex;
	private Sprite sp;
	private int x =0, y= 0;
	public Gun(){
		this.tex = new Texture(Gdx.files.internal("images/textures/items.png"));
		this.sp = new Sprite(this.tex,80,16,16,16)
	}
	public void render(SpriteBatch b){
		update();
		b.draw(this.sp, this.x, this.y);
	}
	public void update(){
		
	}
}
