package me.timothy.WhyMe.input;

import me.timothy.WhyMe.entity.mob.Mob;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class Keyboard implements InputProcessor{
	private boolean[] keys = new boolean[255];
	public static boolean up;
	public static boolean down;
	public static boolean left;
	public static boolean right;
	public static boolean jump;
	public static boolean toggle;
	public static boolean exit;
	private Mob p = null;
  
	public Keyboard(Mob p){
		up = this.keys[Keys.W];
		down = this.keys[Keys.S];
		left = this.keys[Keys.A];
		right = this.keys[Keys.D];
		jump = this.keys[Keys.SPACE];
		toggle = this.keys[Keys.X];
		exit = this.keys[Keys.ESCAPE];
		this.p = p;
	}

	public boolean keyDown(int keycode){
		this.keys[keycode] = true;
		switch (keycode){
			case Keys.W: 
				up = true;
				break;
			case Keys.S: 
				down = true;
				break;
			case Keys.A: 
				left = true;
				break;
			case Keys.D: 
				right = true;
				break;
			case Keys.SPACE: 
				if ((p.isCanJump()) && (this.p.hasGravity())) {
					jump = true;
				}
				break;
			case Keys.X: 
				toggle = true;
				break;
			case Keys.ESCAPE:
				exit = true;
				break;
			}
		return true;
	}
  
	public boolean keyUp(int keycode){
		switch (keycode){
		case Keys.W: 
			up = false;
			break;
		case Keys.S: 
			down = false;
			break;
		case Keys.A: 
			left = false;
			break;
		case Keys.D: 
			right = false;
			break;
		case Keys.SPACE: 
			jump = false;
			break;
		case Keys.X: 
			toggle = false;
			break;
		case Keys.ESCAPE:
			exit = false;
			break;
		}
		return true;
	}
  
  public boolean keyTyped(char character){
    return false;
  }
  
  public boolean touchDown(int screenX, int screenY, int pointer, int button){
    return false;
  }
  
  public boolean touchUp(int screenX, int screenY, int pointer, int button){
    return false;
  }
  
  public boolean touchDragged(int screenX, int screenY, int pointer){
    return false;
  }
  
  public boolean mouseMoved(int screenX, int screenY){
    return false;
  }
  
  public boolean scrolled(int amount){
    return false;
  }
}
