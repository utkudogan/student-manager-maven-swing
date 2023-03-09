package com.utkudogan.ui;

import javax.swing.JFrame;

import com.utkudogan.constants.NumberConstants;
import com.utkudogan.constants.StringConstants;

public class MainFrame extends JFrame {
	public MainFrame() {
		super(StringConstants.APP_NAME);
		
		// frame related settings
		setSize(NumberConstants.FRAME_WIDTH, NumberConstants.FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sağ üstte kırmız çarpı ile frame'nin kapanmasını sağlar
		setVisible(true);
	}
	
	
}
