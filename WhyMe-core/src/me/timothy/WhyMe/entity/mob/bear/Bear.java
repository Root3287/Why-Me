package me.timothy.WhyMe.entity.mob.bear;

import me.timothy.WhyMe.entity.mob.Mob;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Bear extends Mob{
	
	Sprite bear;
	Sprite stick;
	Sprite hat;
	
	public Bear(TiledMapTileLayer collision, boolean gravity, float x, float y) {
		super(collision, gravity, x, y);
		tex = new Texture(Gdx.files.internal("images/mob/Bear/Bear.png"));
		bear = new Sprite(tex, 0, 0,16,16);
		hat = new Sprite(tex, 16, 0, 16,16);
		stick = new Sprite(tex, 31,0,16,16);
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(bear,x,y,7*16,7*16);
		batch.draw(hat,x,y+5*16-8,7*16,7*16);
		batch.draw(stick,x-4*16,y,8*16,8*16);
	}

	@Override
	protected void update() {
		
	}

	@Override
	public void dispose() {
		tex.dispose();
	}

}
