package me.timothy.whyme;

import com.badlogic.gdx.Game;

import me.timothy.whyme.screens.Splash;

public class whyme extends Game {

	@Override
	public void create() {
		setScreen(new Splash());
	}
	
}
