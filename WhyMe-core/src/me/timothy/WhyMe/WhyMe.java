package me.timothy.WhyMe;

import com.badlogic.gdx.Game;

import me.timothy.WhyMe.screen.Splash;

public class WhyMe extends Game{

	@Override
	public void create() {
		setScreen(new Splash());
	}

}
