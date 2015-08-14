package me.timothy.WhyMe.entity.block.Blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import me.timothy.WhyMe.entity.block.Block;
import me.timothy.WhyMe.entity.mob.Mob;
import me.timothy.WhyMe.screen.other.DialogMessage;

public class Signs extends Block {
	Stage stage;
	Skin skin;
	Sprite sign;
	String content;
	public Signs(float x, float y, String content){
		super(x, y);
		tex = new Texture(Gdx.files.internal("images/textures/SpriteSheet.png"));
		sign = new Sprite(tex, 16*15, 0,16,16);
		this.content = content;
	}

	@Override
	public void draw(SpriteBatch batch) {
		update();
		batch.draw(sign, x,y);
		//System.out.println("Sign x:"+ x+" Sign Y:"+ y);
	}
	
	@Override
	public void update() {
		if(nearMe()){
			if(skin !=null && stage !=null){
				if(Gdx.input.isKeyJustPressed(Keys.X)){
					System.out.println("test");
					new DialogMessage("Sign", skin,"dialog"){
						{
							init("\n"+getContent(), "Back");
						}
					}.show(stage);
				}
			}
		}
	}
	
	public boolean nearMe(){
		float minX = Math.min(x, x-16);
		float maxX = Math.max(x, x+16);
		float minY = Math.min(y, y-16);
		float maxY = Math.max(y, y+16);
		//System.out.println("minx: "+ minX+" MinY: "+ minY+" maxX: "+maxX+" MaxY: "+maxY);
		if (p !=null && p instanceof Mob) { //TODO: make an algorithm for when the player stands near the sign
			if(p.getX()>=minX && p.getX()<=maxX){		
				if(p.getY()>=minY && p.getY()<=maxY){
					return true;
				}
			}
		}
		return false;
	}
	public void addSkin(Skin skin){this.skin = skin;}
	public void addStage(Stage stage){this.stage = stage;}
	public String getContent(){return content;}
}
