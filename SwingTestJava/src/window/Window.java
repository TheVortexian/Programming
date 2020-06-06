package window;

import javax.swing.*;
public class Window {
	
	// window
	private JFrame window;
	private String title;
	private int width, height;
	
	// constructor
	public Window(String name, int width, int height) {
		title = name;
		this.width = width;
		this.height = height;
		
		window = new JFrame(title);
		window.setSize(this.width, this.height);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null); // center of screen
	}
	
	// show window
	public void create() {
		window.setVisible(true);
	}
	
}
