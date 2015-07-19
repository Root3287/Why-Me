package me.timothy.WhyMe.input;

public class GameKeys {
	private static boolean[] keys;
	private static boolean[] pressed;
	private static int NUM_KEYS = 1; 
	public static int paused = 0;
	
	static{
		keys = new boolean[NUM_KEYS];
		pressed = new boolean[NUM_KEYS];
	}
	
	public static void update(){
		for(int i= 0; i<NUM_KEYS; i++){
			pressed[i] = keys[i];
		}
	}
	public static void setKey(int k, boolean b){
		keys[k] = b;
	}
	
	public static boolean isDown(int k){
		return keys[k];
	}
	public static boolean isPress(int k){
		return keys[k] && !pressed[k];
	}
}
