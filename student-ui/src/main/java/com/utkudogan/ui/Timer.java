package com.utkudogan.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;

public class Timer extends Thread {

	private boolean isRunning;
	private JLabel timeLabel;
	private SimpleDateFormat dateFormat;
	
	public Timer(JLabel timeLabel) {
		initializeVariables(timeLabel);
	}
	
	private void initializeVariables(JLabel timeLabel) {
		this.timeLabel = timeLabel;
		this.dateFormat = new SimpleDateFormat("hh:mm:ss");
		this.isRunning = true;
	}

	@Override
	public void run() {
		
		while(isRunning) {
			Calendar calendar = Calendar.getInstance();
			Date date = calendar.getTime();
			timeLabel.setText(dateFormat.format(date));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
}
