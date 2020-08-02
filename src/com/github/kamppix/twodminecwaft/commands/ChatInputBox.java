package com.github.kamppix.twodminecwaft.commands;

import javax.swing.*;

import com.github.kamppix.twodminecwaft.Player;
import com.github.kamppix.twodminecwaft.world.World;

public class ChatInputBox {
	
	JTextField chatInput;
    
    public ChatInputBox(World world, Player player) {
    	Command command = new Command(world, player);
    	
    	chatInput = new JTextField();
        JOptionPane.showMessageDialog(null, chatInput, "Chat Input", JOptionPane.PLAIN_MESSAGE);
        command.handle(chatInput.getText());
    }
}
