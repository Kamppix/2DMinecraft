package com.github.kamppix.twodminecraft.commands;

import javax.swing.*;

import com.github.kamppix.twodminecraft.Player;
import com.github.kamppix.twodminecraft.world.World;

public class ChatInputBox {
	
	JTextField chatInput;
    
    public ChatInputBox(World world, Player player) {
    	Command command = new Command(world, player);
    	
    	chatInput = new JTextField();
        JOptionPane.showMessageDialog(null, chatInput, "Chat Input", JOptionPane.PLAIN_MESSAGE);
        command.handle(chatInput.getText());
    }
}
