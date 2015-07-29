package me.timothy.WhyMe.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import me.timothy.WhyMe.screen.Level.School;

public class MainMenu
  implements Screen
{
  OrthographicCamera camera;
  SpriteBatch batch;
  private Stage stage;
  private Skin skin;
  private Table table;
  private TextButton buttonPlay;
  private TextButton buttonExit;
  private Label heading;
  private Image finalWall;
  private boolean refreash = false;
  Texture wall;
  Music bg;
  
  public void show()
  {
    if (!this.refreash)
    {
      this.bg = Gdx.audio.newMusic(Gdx.files.internal("sound/Music/Menu/DreamsBecomeReal.mp3"));
      this.bg.setLooping(true);
      this.bg.play();
    }
    this.skin = new Skin(Gdx.files.internal("ui/Menu.json"), new TextureAtlas("ui/Buttons.pack"));
    
    this.stage = new Stage();
    Gdx.input.setInputProcessor(this.stage);
    
    this.table = new Table(this.skin);
    this.table.setFillParent(true);
    
    this.heading = new Label("Why Me?", this.skin);
    
    this.buttonPlay = new TextButton("Play", this.skin);
    this.buttonExit = new TextButton("Exit", this.skin);
    
    this.buttonPlay.pad(10.0F);
    this.buttonPlay.addListener(new ClickListener()
    {
      public void clicked(InputEvent event, float x, float y)
      {
        ((Game)Gdx.app.getApplicationListener()).setScreen(new School());
      }
    });
    this.buttonExit.pad(10.0F);
    this.buttonExit.addListener(new ClickListener()
    {
      public void clicked(InputEvent event, float x, float y)
      {
        Gdx.app.exit();
      }
    });
    this.wall = new Texture(Gdx.files.internal("images/MainMenu.png"));
    this.finalWall = new Image(this.wall);
    
    this.table.row().align(Align.left);
    this.table.add(this.heading);
    this.table.getCell(this.heading).spaceBottom(10.0F);
    this.table.row();
    this.table.add(this.finalWall);
    
    this.table.align(Align.right);
    this.table.add(this.buttonPlay);
    this.table.add(this.buttonExit);
    this.stage.addActor(this.table);
  }
  
  public void render(float delta)
  {
    Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    Gdx.gl.glClear(16384);
    
    this.stage.act();
    this.stage.draw();
  }
  
  public void resize(int width, int height)
  {
   this.stage.getViewport().setScreenSize(width, height);
   this.table.invalidateHierarchy();
  }
  
  public void pause() {}
  
  public void resume() {}
  
  public void hide()
  {
    dispose();
  }
  
  public void dispose()
  {
    this.stage.dispose();
    this.bg.dispose();
  }
}