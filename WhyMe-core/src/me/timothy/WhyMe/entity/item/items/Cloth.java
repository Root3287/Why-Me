package me.timothy.WhyMe.entity.item.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.timothy.WhyMe.entity.item.Item;

public class Cloth extends Item{
	Sprite pill;
	public Cloth(float x, float y) {
		this.x = x;
		this.y = y;
		tex = new Texture(Gdx.files.internal("images/textures/items.png"));
		pill = new Sprite(tex, 6*16, 0, 16,16);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		update();
		batch.draw(pill, x, y);
	}	
	
	@Override
	public void update() {
		
	}
}