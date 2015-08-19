package me.timothy.WhyMe;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import me.timothy.WhyMe.screen.Splash;

public class WhyMe extends Game{

	public static boolean debug =false;
	
	@Override
	public void create() {
		setScreen(new Splash());
		//System.out.println("Copyright (c) Timothy Gibbons(Root3287) 2015 \n The player sprite is not under this copyright.");
	}
	
	@Override
	public void render() {
		super.render();
		if(Gdx.input.isKeyJustPressed(Keys.F3)){
			if(debug){
				debug = false;
			}else{
				debug = true;
			}
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.R)){
			if(debug){
				try {
					setScreen(getScreen().getClass().newInstance());
				} catch(InstantiationException e) {
					e.printStackTrace();
				} catch(IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static boolean isDebug(){
		return debug;
	}
}