package me.timothy.WhyMe.input;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;

import me.timothy.WhyMe.entity.block.Block;

public class OtherKeyboardInput implements InputProcessor{

	Block b = null;
	
	private boolean[] keys = new boolean[255];
	public static boolean x;
	
	public OtherKeyboardInput() {
		 x = keys[Keys.X];
	}
	
	@Override
	public boolean keyDown(int keycode) {
		keys[keycode] = true;
		switch (keycode) {
		case Keys.X:
			x = true;
			break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		keys[keycode] = false;
		switch (keycode) {
		case Keys.X:
			x = false;
			break;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	public Block getBlock() {
		return b;
	}

	public void setBlock(Block b) {
		this.b = b;
	}
	public OtherKeyboardInput getInstance(){
		return this;
	}
}
