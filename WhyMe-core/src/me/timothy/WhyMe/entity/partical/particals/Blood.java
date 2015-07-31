package me.timothy.WhyMe.entity.partical.particals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.timothy.WhyMe.entity.partical.Partical;

public class Blood extends Partical{
	

	public Blood(float x, float y, int life) {
		super(x, y, life);
		setTexture(Gdx.files.internal("images/textures/SpriteSheet.png"));
		setSprite(this.img,225,5, 7,5);
	}

	@Override
	public void render(SpriteBatch batch) {
		update();
		batch.draw(this.partical, x, y);
	}

	@Override
	public void update() {
		xa= 0; ya=0;
			xa = 2;
			ya = (float) (7*Math.sqrt(1.5*x)-x);
			x+=xa;
			y+=ya;
		try {
			Thread.sleep(1000/16);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("x"+x+"y"+y);
	}

	@Override
	public void dispose() {
	}
}