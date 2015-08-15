package me.timothy.WhyMe.other;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.timothy.WhyMe.WhyMe;
import me.timothy.WhyMe.entity.mob.Mob;

public class Debug {
	BitmapFont font;
	Mob player;
	public Debug(){
		font = new BitmapFont(Gdx.files.internal("font/White-8.fnt"));
	}
	public void render(SpriteBatch batch){
		if(WhyMe.isDebug()){
		font.draw(batch, "DEBUG\nX: "+ this.player.getX()+"\nY: "+this.player.getY(), 0, Gdx.graphics.getHeight());
		}
	}
	public void addPlayer(Mob p){
		this.player = p;
	}
}
