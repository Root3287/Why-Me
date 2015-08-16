package me.timothy.WhyMe.entity.mob.player;

import me.timothy.WhyMe.entity.mob.Mob;
import me.timothy.WhyMe.input.Keyboard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class PlayerGravity extends Mob{

	Sprite player;
	InputProcessor ip;
	
	public PlayerGravity(TiledMapTileLayer collision, boolean gravity, float x, float y) {
		super(collision, gravity, x, y);
		tex = new Texture(Gdx.files.internal("images/player/Player-A.png"));
		player = new Sprite(tex, 0,16,16,16);
		ip = Gdx.input.getInputProcessor();
		speed = 2;
		velocity = new Vector2();
		width = 16;
		height = 16;
	}

	@Override
	public void render(SpriteBatch batch) {
		update();
		batch.draw(player, x, y);
	}

	@Override
	protected void update() {
		velocity.y = -gravity;
		
		if(velocity.y>gravity){
			velocity.y = gravity;
		}else if(velocity.y<-gravity){
			velocity.y = -gravity;
		}
		
		keyboard();
		
		move(velocity.x, velocity.y);
		
		velocity.y = 0;
		velocity.x = 0;
	}

	private void keyboard(){
		if(Keyboard.left){
			velocity.x = -(float) (speed);
			firstMove = true;
		}
		if(Keyboard.right){
			velocity.x = (float) (speed);
			firstMove = true;
		}
		if(Keyboard.jump && canJump){
			velocity.y = speed;
			firstMove = true;
			Timer.schedule(new Task(){
				@Override
				public void run() {
					canJump = false;
				}
			}, 0.2f);	
		}
	}
	
	@Override
	public void dispose() {
		
	}
}
