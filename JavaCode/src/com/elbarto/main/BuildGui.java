package com.elbarto.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class BuildGui extends JFrame {
	private JTextField addressBar;
	private JEditorPane displayContent;

	public BuildGui() {
		super("Test Browser Window");
		addressBar = new JTextField("Enter URL here");
		addressBar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadWebPage(arg0.getActionCommand());
			}

		});
		add(addressBar);
	}

}
