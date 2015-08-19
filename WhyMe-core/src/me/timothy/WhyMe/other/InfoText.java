package me.timothy.WhyMe.other;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.timothy.WhyMe.entity.mob.Mob;

public class InfoText {
	private Mob mob;
	private BitmapFont font;
	private String content;
	private float xOffset, yOffset;
	public InfoText(Mob mob, String content, float xOffset, float yOffset){
		this.mob = mob;
		this.font = new BitmapFont(Gdx.files.internal("font/White-14-Native.fnt"));
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.content = content;
	}
	
	public void draw(SpriteBatch batch){
		if(this.mob !=null){
			if(!mob.isFirstMove()){
				font.draw(batch, "\n"+this.content, mob.getX()+xOffset, mob.getY()+yOffset,4*16,0,true);
			}
		}
	}
	
	public void dispose(){
		font.dispose();
	}
}
