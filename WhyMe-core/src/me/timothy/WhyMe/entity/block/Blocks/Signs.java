package me.timothy.WhyMe.entity.block.Blocks;

import me.timothy.WhyMe.entity.block.Block;
import me.timothy.WhyMe.entity.mob.player.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Signs extends Block {
	Stage stage;
	Skin skin;
	Sprite sign;
	public Signs(Player p,float x, float y, String content, Stage stage,Skin skin) {
		super(p,x, y);
		this.stage = stage;
		this.skin = skin;
		this.tex = new Texture(Gdx.files.internal("images/textures/SpriteSheet.png"));
		sign = new Sprite(tex, 16*16, 0, 16, 16);
		instanceList.add(this);
	}

	@Override
	public void draw(SpriteBatch batch) {
		update();
		batch.draw(sign, x,y);
		System.out.println("Sign x:"+ x+" Sign Y:"+ y);
	}
	
	@Override
	public void update() {
		if (p.getX()>=x && p.getY()<=y) { // TODO: make an algorithm for when the player stands near the sign
			System.out.println("your on me");
		}
	}
}
