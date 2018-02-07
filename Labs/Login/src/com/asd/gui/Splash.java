package com.asd.gui;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;


public class Splash extends JWindow {

	// duration is integer value in milliseconds for how long the Splash screen
	// is visible
	private final int duration;

	/**
	 * Constructor
	 * 
	 * @param dur
	 *            : The duration of the splash screen
	 */
	public Splash(int dur) {
		duration = dur;
	}

	/**
	 * A method to show a title screen in the center of the screen for the
	 * amount of time given in the constructor
	 */
	public void showSplash() {
		JPanel content = (JPanel) getContentPane();
		content.setBackground(Color.DARK_GRAY);

		// Set the window's bounds, centering the window
		int width = 550;
		int height = 250;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);

		// Build the splash screen
		JLabel label = new JLabel(new ImageIcon(
				"src/com/asd/gui/splashImage.jpg"));
		JLabel copyrt = new JLabel(
				"Copyright programing CS143 project.,Spring 2016, Dansa Cafe Dancers Database",
				SwingConstants.CENTER);
		copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		content.add(label, BorderLayout.CENTER);
		content.add(copyrt, BorderLayout.SOUTH);
		Color border = new Color(50, 20, 20, 55);
		content.setBorder(BorderFactory.createLineBorder(border, 10));

		// Display it
		setVisible(true);

		// Wait a little while, maybe while loading resources
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
		}

		this.dispose();
	}
}