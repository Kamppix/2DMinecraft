package com.github.kamppix.twodminecraft;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	public Window() {
		ImageIcon img = new ImageIcon(getClass().getResource("/textures/block/crafting_table_front.png"));
		setIconImage(img.getImage());
		setTitle("2D Minecraft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new GamePanel(1280, 720));
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

}
