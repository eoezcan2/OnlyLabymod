package at.emreeocn.onlylabymod.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import at.emreeocn.onlylabymod.listener.MainListener;

public class Main extends JavaPlugin {

	private static Main pl;
	
	public void onEnable() {
		pl = this;
		
		getConfig().options().copyDefaults();
		saveDefaultConfig();
		
		Bukkit.getPluginManager().registerEvents(new MainListener(), this);
	}

	public static Main getInstance() {
		return pl;
	}
	
}
