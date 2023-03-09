package com.utkudogan.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.utkudogan.Student;
import com.utkudogan.constants.NumberConstants;
import com.utkudogan.constants.StringConstants;
import com.utkudogan.service.MainFrameService;
import com.utkudogan.service.impl.MainFrameServiceImpl;

public class MainFrame extends JFrame {
	
	private TablePanel tablePanel;
	private MainFrameService mainFrameService;
	
	public MainFrame() {
		super(StringConstants.APP_NAME);
		constructFrame();
		setJMenuBar(constructMenuBar());
		initializeVariables();
		constructLayout();
		update();
	}

	private void update() {
		List<Student> students = mainFrameService.getStudents();
		tablePanel.setTableModel(students);
		tablePanel.update();
	}

	private void constructLayout() {
		setLayout(new BorderLayout());
		add(tablePanel, BorderLayout.CENTER);
	}
	
	private void initializeVariables() {
		this.mainFrameService = new MainFrameServiceImpl();
		this.tablePanel = new TablePanel();
	}

	private JMenuBar constructMenuBar() {

		JMenuBar menuBar = new JMenuBar();

		// FILE MENU
		JMenu fileMenu = new JMenu(StringConstants.MENU_FILE);

		JMenuItem openItem = new JMenuItem(StringConstants.MENU_ITEM_OPEN);
		JMenuItem exitItem = new JMenuItem(StringConstants.MENU_ITEM_EXIT);

		fileMenu.add(openItem);
		fileMenu.add(exitItem);

		// EDIT MENU
		JMenu editMenu = new JMenu(StringConstants.MENU_EDIT);

		JMenuItem addStudentsItem = new JMenuItem(StringConstants.MENU_ITEM_ADD);
		JMenuItem removeStudentsItem = new JMenuItem(StringConstants.MENU_ITEM_REMOVE);

		editMenu.add(addStudentsItem);
		editMenu.add(removeStudentsItem);

		// add the menus to the bar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);

		// handling the click events
		addStudentsItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// addStudentForm.setVisible(true);
			}
		});

		removeStudentsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// removeStudentForm.loadData();
				// removeStudentForm.setVisible(true);
			}
		});

		// we have to close the application
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int action = JOptionPane.showConfirmDialog(MainFrame.this, StringConstants.EXIT_CONFIRM_TEXT,
						StringConstants.EXIT_CONFRIM_TITLE, JOptionPane.OK_CANCEL_OPTION);

				// close the application
				if (action == JOptionPane.OK_OPTION) {
					System.gc(); //garbage collector
					System.exit(0);
				}
			}
		});

		return menuBar;
	}

	// frame related settings
	private void constructFrame() {
		setSize(NumberConstants.FRAME_WIDTH, NumberConstants.FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sağ üstte kırmız çarpı ile frame'nin kapanmasını sağlar
		setLocationRelativeTo(null); // frame ekranın ortasında açılır
		setVisible(true);
	}
}
