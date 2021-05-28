package at.emreeocn.onlylabymod.util;

import org.bukkit.ChatColor;

import at.emreeocn.onlylabymod.main.Main;

public class Config {

	public static String kickMessage() {
		try {
			return ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("kick-message"));
					
		} catch(IllegalArgumentException | NullPointerException ex) {
			return "Please install LabyMod";
		}
	}
	
}
