package at.emreeocn.onlylabymod.listener;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import at.emreeocn.onlylabymod.util.Config;
import net.labymod.serverapi.bukkit.event.BukkitLabyModPlayerLoginEvent;

public class MainListener implements Listener {

	private static ArrayList<UUID> labyModPlayers = new ArrayList<UUID>();
	
	/* Listener */
	@EventHandler
	public void onLabyModJoin(BukkitLabyModPlayerLoginEvent e) {
		labyModPlayers.add(e.getPlayer().getUniqueId());
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		if(labyModPlayers.contains(e.getPlayer().getUniqueId()))
			labyModPlayers.remove(e.getPlayer().getUniqueId());
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		if(!labyModPlayers.contains(e.getPlayer().getUniqueId())) {
			e.getPlayer().kickPlayer(Config.getKickMessage());
		}
	}
	
	public static ArrayList<UUID> getLabyModPlayers() {
		return labyModPlayers;
	}
	
}
