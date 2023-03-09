package com.utkudogan.app;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.utkudogan.ui.MainFrame;

public class App {

	public static void main(String[] args) {
		
		//that our application will inherit the Operating System
		//related look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//We will run the application on a distinct
		//thread (event dispatch thread - EDT)
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MainFrame();	
			}
		});
	}

}
