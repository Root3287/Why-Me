package me.timothy.WhyMe.other;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

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
	
	public DialogMessage(String title, Skin skin, String windowStyleName, float x, float y) {
		super(title, skin, windowStyleName);
		pack();
		setPosition(x, y);
	}

	public DialogMessage(String title, Skin skin, float x, float y) {
		super(title, skin);
		pack();
		setPosition(x, y);
	}

	public DialogMessage(String title,WindowStyle windowStyle, float x, float y) {
		super(title, windowStyle);
		pack();
		setPosition(x, y);
	}
	
	@Override
	protected void result(Object object) {
		if(object == "back"){
			hide();
			cancel();
			remove();
			System.out.println("Hello"); 
		}
	}
	public void init(String Line,String ButtonText){
		Label text = new Label(Line, getSkin(), "dialog");
		TextButton button = new TextButton(ButtonText, getSkin(), "dialog");
		text(text);
		button(button);
		key(Keys.ESCAPE, "back");
	}
}