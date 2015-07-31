package me.timothy.WhyMe.screen.Level;

import me.timothy.WhyMe.entity.mob.bear.Bear;
import me.timothy.WhyMe.screen.MainMenu;
import me.timothy.WhyMe.screen.other.DialogMessage;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Welcome implements Screen{
	private Stage stage;
	private Skin skin;
	private SpriteBatch batch;
	private Bear b;
	private Image screen;
	@Override
	public void show() {
		skin = new Skin(Gdx.files.internal("ui/Menu.json"), new TextureAtlas("ui/Buttons.pack"));
		stage = new Stage();
		batch = new SpriteBatch();
		b = new Bear(null,false,Gdx.graphics.getWidth()/2 - 4*16,Gdx.graphics.getHeight()/2 - 4*16);
		screen = new Image(new Texture(Gdx.files.internal("images/Screen.png")));
		screen.setFillParent(true);
		stage.addActor(screen);
		Gdx.input.setInputProcessor(stage);
		TextButton next = new TextButton("Continue", skin);
		next.setPosition(Gdx.graphics.getWidth()/2, 0);
		next.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game)Gdx.app.getApplicationListener()).setScreen(new School());
			}
		});
		stage.addActor(next);
		new DialogMessage("Welcome", skin, "dialog invisablebg"){
			{
				init("So you did this?","Next");
			}
			protected void result(Object object) {
				super.result(object);
				new DialogMessage("Welcome", skin, "dialog invisablebg"){
					{
						init("Why did you do this?","Next");
					}
					protected void result(Object object) {
						super.result(object);
						new DialogMessage("Welcome", skin, "dialog invisablebg"){
							{
								init("Why you keep comeing back?","Next");
							}
							protected void result(Object object) {
								super.result(object);
							}
						}.show(stage);
					}
				}.show(stage);
			}
		}.show(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0.09F, 0.09F, 0.09F, 0.5F);
		
		batch.begin();
		b.render(batch);
		batch.end();
		
		stage.act();
		stage.draw();
		
		if(Gdx.input.isKeyJustPressed(Keys.J)){
			((Game)Gdx.app.getApplicationListener()).setScreen(new Welcome());
		}else if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)){
			((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenu());
		}
	}

	@Override
	public void resize(int width, int height) {
		screen.invalidateHierarchy();
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
		b.dispose();
		batch.dispose();
		skin.dispose();
		stage.dispose();
	}

}
