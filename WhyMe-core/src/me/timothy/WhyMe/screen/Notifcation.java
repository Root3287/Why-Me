package me.timothy.WhyMe.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import me.timothy.WhyMe.screen.Level.Levels;
import me.timothy.WhyMe.screen.Level.School;

public class Notifcation implements Screen{

	private static Levels Return_Scr;
	private String title, content;
	private Stage stage;
	private Window window;
	private TextureAtlas atlas;
	private Skin skin;
	
	public Notifcation(String title, String content, Levels Return) {
		this.title = title;
		this.content = content;
		Return_Scr = Return;
		
	}

	@Override
	public void show() {
		this.atlas = new TextureAtlas("ui/Buttons.pack");
		this.skin = new Skin(Gdx.files.internal("ui/Menu.json"),this.atlas);
		
		this.stage = new Stage();
		Gdx.input.setInputProcessor(this.stage);
		
		final TextButton back =new TextButton("Back", skin);
		back.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				switch(Notifcation.Return_Scr){
				case SCHOOL:
					((Game)Gdx.app.getApplicationListener()).setScreen(new School());
					break;
				}
			}
		});
		this.window = new Window(this.title, this.skin);
		this.window.add(this.content).row();
		this.window.add(back);
		this.window.setMovable(true);
		this.window.pack();
		this.window.center();
		this.stage.addActor(window);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void pause() {
		
		
	}

	@Override
	public void resume() {
		
		
	}

	@Override
	public void hide() {
		
		
	}

	@Override
	public void dispose() {
		
		
	}

}
