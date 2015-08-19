package me.timothy.WhyMe.other;


public class Time {
	long time;
	long minutes;
	EnumTime timeOfDay;
		
	public Time(){		
	}
	public Time(long time){
		this.time = time;
	}
	public void update(){
		if(time>=2900000){ // 2900000
			time = 0;
			minutes++;
		}else{
			time++;
		}
		if(minutes == 0){
			timeOfDay = EnumTime.DAY;
		}
		if(minutes == 5){
			timeOfDay = EnumTime.NIGHT;
		}
		if(minutes>=10){
			minutes = 0;
		}
	}
	public long getTime() {return time;}
	public void setTime(long time) {this.time = time;}
	public void addTime(long time) {this.time += time;}
	public void removeTime(long time) {this.time -= time;}
	public long getMinutes(){return minutes;}
	public EnumTime getTimeOfDay(){return timeOfDay;}
	public static enum EnumTime{
		DAY, NIGHT
	}
}