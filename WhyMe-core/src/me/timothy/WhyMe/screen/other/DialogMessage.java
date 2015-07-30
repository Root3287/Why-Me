package me.timothy.WhyMe.screen.other;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class DialogMessage extends Dialog{
	
	public DialogMessage(String title, Skin skin, String windowStyleName) {
		super(title, skin, windowStyleName);
	}

	public DialogMessage(String title, Skin skin) {
		super(title, skin);
	}

	public DialogMessage(String title,WindowStyle windowStyle) {
		super(title, windowStyle);
	}
	@Override
	protected void result(Object object) {
		if(object == "back"){
			hide();
			cancel();
			remove();
		}
	}
	public void init(String Line){
		Label text = new Label(Line, getSkin(), "dialog");
		TextButton button = new TextButton("button", getSkin(), "dialog");
		Button b = new Button();
		text(text);
		button(button);
		key(Keys.ESCAPE, "back");
	}
}