package com.kamppi.testgame.states;
import java.awt.Color;
import java.awt.Graphics2D;

import com.kamppi.testgame.commands.SeedInputBox;
import com.kamppi.testgame.graphics.Sprite;
import com.kamppi.testgame.util.KeyHandler;
import com.kamppi.testgame.util.MouseHandler;
import com.kamppi.testgame.util.Vector2f;
import com.kamppi.testgame.world.World;

public class PlayState extends GameState {
	
	public World world = new SeedInputBox().getSeededWorld();;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void update() {
		world.update();
	}
	
	public void input(MouseHandler mouse, KeyHandler key) {
		world.input(mouse, key);
	}
	
	public void render(Graphics2D g, MouseHandler mouse) {
		world.render(g, font, mouse);
		Sprite.drawString(g, font, "Moikka!", new Color(255, 255, 255), new Color(63, 63, 63), new Vector2f(32, 32), 16, 16, 12, 0);
	}
}
