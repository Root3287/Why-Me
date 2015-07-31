package me.timothy.WhyMe.screen;

import me.timothy.WhyMe.tween.SpriteAccessor;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Splash
  implements Screen
{
  private TweenManager tweenManager;
  SpriteBatch batch;
  OrthographicCamera camera;
  Texture splashimg;
  Sprite splash;
  
  public void show()
  {
    this.tweenManager = new TweenManager();
    Tween.registerAccessor(Sprite.class, new SpriteAccessor());
    
    this.batch = new SpriteBatch();
    this.camera = new OrthographicCamera();
    this.camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    
    this.splashimg = new Texture(Gdx.files.internal("images/Splash.png"));
    this.splashimg.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    this.splash = new Sprite(this.splashimg);
    this.splash.flip(false, true);
    
    Tween.set(this.splash, 0).target(0.0F).start(this.tweenManager);
    Tween.to(this.splash, 0, 0.125F).target(1.0F).start(this.tweenManager);
    ((Tween)Tween.to(this.splash, 0, 0.125F).target(0.0F).setCallback(new TweenCallback()
    {
      public void onEvent(int arg0, BaseTween<?> arg1)
      {
        ((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenu());
      }
    })).start(this.tweenManager);
    
    Sound sound = Gdx.audio.newSound(Gdx.files.internal("sound/Select/Select.wav"));
    sound.play();
  }
  
  public void render(float delta)
  {
    Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    Gdx.gl.glClear(16384);
    
    this.tweenManager.update(delta);
    this.camera.update();
    
    this.batch.setProjectionMatrix(this.camera.combined);
    
    this.batch.begin();
    this.batch.draw(this.splash, this.camera.viewportWidth / 20.0F, this.camera.viewportHeight / 35.0F);
    this.batch.end();
  }
  
  public void resize(int width, int height)
  {
    this.camera.setToOrtho(true, width, height);
    this.camera.update();
  }
  
  public void pause() {}
  
  public void resume() {}
  
  public void hide() {}
  
  public void dispose()
  {
    this.batch.dispose();
    this.splashimg.dispose();
  }
}
