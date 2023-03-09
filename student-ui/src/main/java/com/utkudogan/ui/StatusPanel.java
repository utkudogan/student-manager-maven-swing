package com.utkudogan.ui;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JPanel;

import com.utkudogan.constants.StringConstants;

public class StatusPanel extends JPanel {

	private JLabel label;
	private JLabel timeLabel;
	private Timer timer;
	
	public StatusPanel() {
		initializeVariables();
		initializeLayout();
		startTimer();
	}

	private void startTimer() {
		timer.start();
	}
	
	public void stopTimer() {
		timer.setRunning(false);
	}

	private void initializeLayout() {
		setLayout(new FlowLayout());
		add(label);
		add(timeLabel);
	}

	private void initializeVariables() {
		this.label = new JLabel();
		this.timeLabel = new JLabel();
		this.timer = new Timer(timeLabel);
		this.label.setText(StringConstants.STATUS_PANEL_TEXT);
	}
}
