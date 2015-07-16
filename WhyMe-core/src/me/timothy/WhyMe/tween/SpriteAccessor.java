package me.timothy.WhyMe.tween;

import com.badlogic.gdx.graphics.g2d.Sprite;

import aurelienribon.tweenengine.TweenAccessor;

public class SpriteAccessor
  implements TweenAccessor<Sprite>
{
  public static final int ALPHA = 0;
  
  public int getValues(Sprite target, int tweenType, float[] returnValues)
  {
    switch (tweenType)
    {
    case 0: 
      returnValues[0] = target.getColor().a;
      return 1;
    default:
   	 assert false;
       return -1;
    }
  }
  
  public void setValues(Sprite target, int tweenType, float[] newValues)
  {
    switch (tweenType)
    {
    case 0: 
      target.setColor(target.getColor().r, target.getColor().g, target.getColor().b, newValues[0]);
      break;
    default: 
    	assert false;
      break;
    }
  }
}
