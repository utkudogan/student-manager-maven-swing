package com.utkudogan.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.utkudogan.Student;
import com.utkudogan.callbacks.AddStudentCallback;
import com.utkudogan.constants.NumberConstants;
import com.utkudogan.constants.StringConstants;
import com.utkudogan.service.AddStudentFormService;
import com.utkudogan.service.impl.AddStudentFormServiceImpl;

public class AddStudentForm extends JDialog implements ActionListener{
	private AddStudentFormService addStudentFormService;
	private JButton saveButton;
	private JButton cancelButton;
	private JLabel nameLabel;
	private JLabel ageLabel;
	private JLabel countryLabel;
	private JLabel zipLabel;
	private JTextField nameField;
	private JTextField ageField;
	private JTextField countryField;
	private JTextField zipField;
	private AddStudentCallback callback;
	
	public AddStudentForm(JFrame parentFrame) {
		super(parentFrame, StringConstants.ADD_STUDENT_FORM_TITLE, false);
		initializeVariables();
		constructLayout();
		setWindow(parentFrame);
	}
	
	public void setCallback(AddStudentCallback callback) {
		this.callback = callback;
	}
	
	private void constructLayout() {
		
		JPanel studentInfoPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();

		Border spaceBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15); //padding
		Border titleBorder = BorderFactory.createTitledBorder(StringConstants.STUDENT_FORM_SUBTITLE);

		studentInfoPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
		studentInfoPanel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridy = 0; //first row of gridlayout

		Insets rightPadding = new Insets(0, 0, 0, 15);
		Insets noPadding = new Insets(0, 0, 0, 0);

		// first row
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		studentInfoPanel.add(nameLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		studentInfoPanel.add(nameField, gc);

		// next row
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		studentInfoPanel.add(ageLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		studentInfoPanel.add(ageField, gc);

		// next row
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		studentInfoPanel.add(countryLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		studentInfoPanel.add(countryField, gc);

		// next row

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		studentInfoPanel.add(zipLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		studentInfoPanel.add(zipField, gc);

		// buttons panel
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(saveButton);
		buttonsPanel.add(cancelButton);

		Dimension btnSize = cancelButton.getPreferredSize();
		saveButton.setPreferredSize(btnSize);

		// add sub-panels to dialog
		setLayout(new BorderLayout());
		add(studentInfoPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	private void initializeVariables() {

		addStudentFormService = new AddStudentFormServiceImpl();
		
		saveButton = new JButton(StringConstants.SAVE_BUTTON);
		cancelButton = new JButton(StringConstants.CANCEL_BUTTON);
		
		saveButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		nameLabel = new JLabel(StringConstants.NAME_LABEL);
		ageLabel = new JLabel(StringConstants.AGE_LABEL);
		countryLabel = new JLabel(StringConstants.COUNTRY_LABEL);
		zipLabel = new JLabel(StringConstants.ZIP_LABEL);
		nameField = new JTextField(15); //
		countryField = new JTextField(15);
		ageField = new JTextField(15);
		zipField = new JTextField(15);
	}

	
	private void setWindow(JFrame parentFrame) {
		setSize(NumberConstants.STUDENT_FORM_WIDTH, 
				NumberConstants.STUDENT_FORM_HEIGHT);
		setLocationRelativeTo(parentFrame); //locates in the center of parent frame
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == saveButton) {
			
			// get the values from the fields
			String name = nameField.getText();
			String country = countryField.getText();
			int age = Integer.parseInt(ageField.getText());
			int zip = Integer.parseInt(zipField.getText());
			
			Student student = new Student(1, age, zip, name,country);
			addStudentFormService.insert(student);
			callback.studentSaved();
			setVisible(false);
		} else if(e.getSource() == cancelButton) {
			setVisible(false);
		}	
		
	}
	
	
}
