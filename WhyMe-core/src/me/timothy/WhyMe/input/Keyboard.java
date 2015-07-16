package me.timothy.WhyMe.input;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

import me.timothy.WhyMe.entity.player.Player;

public class Keyboard
  implements InputProcessor
{
  private boolean[] keys = new boolean[255];
  public static boolean up;
  public static boolean down;
  public static boolean left;
  public static boolean right;
  public static boolean jump;
  public static boolean toggle;
  private Player p;
  
  public Keyboard(Player p)
  {
    up = this.keys[Keys.W];
    down = this.keys[Keys.S];
    left = this.keys[Keys.A];
    right = this.keys[Keys.D];
    jump = this.keys[Keys.SPACE];
    toggle = this.keys[Keys.ESCAPE];
    this.p = p;
  }
  
  public boolean keyDown(int keycode)
  {
    this.keys[keycode] = true;
    switch (keycode)
    {
    case 51: 
      up = true;
      break;
    case 47: 
      down = true;
      break;
    case 29: 
      left = true;
      break;
    case 32: 
      right = true;
      break;
    case 62: 
      if ((this.p.canJump()) && (this.p.hasGravity())) {
        jump = true;
      }
      break;
    case 251: 
      toggle = true;
    }
    return true;
  }
  
  public boolean keyUp(int keycode)
  {
    switch (keycode)
    {
    case 51: 
      up = false;
      break;
    case 47: 
      down = false;
      break;
    case 29: 
      left = false;
      break;
    case 32: 
      right = false;
      break;
    case 62: 
      jump = false;
      break;
    case 251: 
      toggle = false;
    }
    return true;
  }
  
  public boolean keyTyped(char character)
  {
    return false;
  }
  
  public boolean touchDown(int screenX, int screenY, int pointer, int button)
  {
    return false;
  }
  
  public boolean touchUp(int screenX, int screenY, int pointer, int button)
  {
    return false;
  }
  
  public boolean touchDragged(int screenX, int screenY, int pointer)
  {
    return false;
  }
  
  public boolean mouseMoved(int screenX, int screenY)
  {
    return false;
  }
  
  public boolean scrolled(int amount)
  {
    return false;
  }
}
