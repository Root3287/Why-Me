package me.timothy.WhyMe;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import me.timothy.WhyMe.screen.Splash;

public class WhyMe extends Game{

	@Override
	public void create() {
		setScreen(new Splash());
	}
	@Override
	public void render() {
		super.render();
		if(Gdx.input.isKeyJustPressed(Keys.R)){
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
