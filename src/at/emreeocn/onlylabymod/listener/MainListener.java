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

	private static ArrayList<UUID> labymodPlayers = new ArrayList<UUID>();
	
	/* Listener */
	@EventHandler
	public void onLabyModJoin(BukkitLabyModPlayerLoginEvent e) {
		labymodPlayers.add(e.getPlayer().getUniqueId());
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		if(labymodPlayers.contains(e.getPlayer().getUniqueId()))
			labymodPlayers.remove(e.getPlayer().getUniqueId());
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		if(!labymodPlayers.contains(e.getPlayer().getUniqueId())) {
			e.getPlayer().kickPlayer(Config.getKickMessage());
		}
	}
	
	/* Getters */
	public static ArrayList<UUID> getLabyModPlayers() {
		return labymodPlayers;
	}
	
}
