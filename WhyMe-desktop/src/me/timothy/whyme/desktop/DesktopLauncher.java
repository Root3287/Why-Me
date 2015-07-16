package me.timothy.whyme.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import me.timothy.WhyMe.WhyMe;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width= 900;
		config.height = config.width/16*9;
		config.resizable = true;
		config.addIcon("images/icon.png", FileType.Internal);
		new LwjglApplication(new WhyMe(), config);
	}
}
