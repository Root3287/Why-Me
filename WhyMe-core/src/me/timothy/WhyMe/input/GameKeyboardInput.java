package me.timothy.WhyMe.input;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class GameKeyboardInput extends InputAdapter{
	public boolean keyDown(int k){
		if(k == Keys.ESCAPE){
			GameKeys.setKey(k, true);
		}
		return true;
		
	}
	public boolean keyUp(int k){
		if(k == Keys.ESCAPE){
			GameKeys.setKey(k, false);
		}
		return true;
	}
}
