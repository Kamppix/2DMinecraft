package com.kamppi.testgame.commands;

import javax.swing.*;

import com.kamppi.testgame.Player;
import com.kamppi.testgame.world.World;

public class ChatInputBox {
	
	JTextField chatInput;
    
    public ChatInputBox(World world, Player player) {
    	Command command = new Command(world, player);
    	
    	chatInput = new JTextField();
        JOptionPane.showMessageDialog(null, chatInput, "Chat Input", JOptionPane.PLAIN_MESSAGE);
        command.handle(chatInput.getText());
    }
}
