package at.emreeocn.onlylabymod.main;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import at.emreeocn.onlylabymod.util.Config;
import net.labymod.serverapi.bukkit.event.LabyModPlayerJoinEvent;

public class Main extends JavaPlugin implements Listener {

	private static ArrayList<UUID> labyModPlayers = new ArrayList<UUID>();
	private static Main pl;
	
	public void onEnable() {
		pl = this;
		
		getConfig().options().copyDefaults();
		saveDefaultConfig();
		
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	/* Listener */
	@EventHandler
	public void onLabyModJoin(LabyModPlayerJoinEvent e) {
		labyModPlayers.add(e.getPlayer().getUniqueId());
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		if(labyModPlayers.contains(e.getPlayer().getUniqueId()))
			labyModPlayers.remove(e.getPlayer().getUniqueId());
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Bukkit.getScheduler().runTaskLater(this, new Runnable() {
			@Override
			public void run() {
				if(!labyModPlayers.contains(e.getPlayer().getUniqueId())) {
					e.getPlayer().kickPlayer(Config.kickMessage());
				}
			}
		}, 2);
	}
	
	/* Getter */

	public static ArrayList<UUID> getLabyModPlayers() {
		return labyModPlayers;
	}

	public static Main getInstance() {
		return pl;
	}
	
}
