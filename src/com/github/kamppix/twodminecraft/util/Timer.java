package com.github.kamppix.twodminecraft.util;

public class Timer {

	private float startTime;
	public float time;
	private int startTimes;
	public int times;
	public boolean doneTime;
	private boolean gotDone = true;
	
	public void setTime(int updates, int times) {
		gotDone = false;
		startTime = updates;
		time = updates;
		startTimes = times;
		this.times = times;
	}
	
	public void setTime(float timeS, int times) {
		gotDone = false;
		startTime = timeS * 60f;
		time = timeS * 60f;
		startTimes = times;
		this.times = times;
	}

	public void reset() {
		gotDone = true;
		startTime = 0;
		time = 0;
		startTimes = 0;
		time = 0;
	}
	
	public void update() {
		
		if (time == 0 && times > 0) {
			times--;
			time = startTime;
		}
		
		if (time > 0) time--;
		
		if (time < 0) {
			time = 0;
		}

		if (time != 0 && gotDone) {
			gotDone = false;
		}
		
		if (time == 0 && !gotDone) {
			doneTime = true;
		} else doneTime = false;
	}
	
	public boolean isDoneTime() {
		if (doneTime && !gotDone) {
			gotDone = true;
			return true;
		} else return false;
	}
	
	public boolean isDone() {
		if (doneTime && times == 0) {
			return true;
		} else return false;
	}
	
	public float getProgress() {
		return time * (times + 1f) / startTime * (startTimes + 1f);
	}
}
