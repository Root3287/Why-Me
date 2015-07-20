package me.timothy.WhyMe.entity.partical;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.timothy.WhyMe.entity.player.Player;

public class Blood extends Partical{
	Random r;
	public Blood(Player p){
		this.p = p;
		show();
		r= new Random();
	}
	
	@Override
	public void show() {
		img = new Texture(Gdx.files.internal("images/textures/SpriteSheet.png"));
		partical = new Sprite(img, 230, 4, 7,4);
		x = this.p.getX();
		y = this.p.getY();
		xa = (r.nextBoolean())? 3:-3;
		ya = -3;
	}

	@Override
	public void render(SpriteBatch batch) {
		update();
		
		System.out.println("y:"+ y+"x: "+x);
		batch.draw(partical, x, y);
	}

	@Override
	public void update(){
		ya =
		x += xa;
		y += ya;
	}

	@Override
	public void dispose() {
		img.dispose();
	}

	@Override
	public void resize(int width, int height) {
	}

}
