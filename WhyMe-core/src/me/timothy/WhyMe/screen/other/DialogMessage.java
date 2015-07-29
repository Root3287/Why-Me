package me.timothy.WhyMe.screen.other;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class DialogMessage extends Dialog{
	private String content;
	
	public DialogMessage(String title, String content, Skin skin, String windowStyleName) {
		super(title, skin, windowStyleName);
		this.content = content;
	}

	public DialogMessage(String title, String content, Skin skin) {
		super(title, skin);
		this.content = content;
	}

	public DialogMessage(String title, String content,WindowStyle windowStyle) {
		super(title, windowStyle);
		this.content = content;
	}
	{
		text(this.content);
		button("Back", "back");
		key(Keys.ESCAPE, "back");
	}
	@Override
	protected void result(Object object) {
		if(object == "back"){
			hide();
			cancel();
			remove();
		}
	}
}