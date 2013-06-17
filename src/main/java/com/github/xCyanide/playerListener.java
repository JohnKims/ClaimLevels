package com.github.xCyanide;

import org.bukkit.event.Listener;
import java.io.File;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class playerListener implements Listener {
	
	//Sponsored by Starlite Hosting - http://starlite-hosting.com

	private ClaimLevels plugin;
	
	public playerListener(ClaimLevels plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		File playerDat = new File("world/players/"+ player.getName() + ".dat");
		if(!playerDat.exists()) {
			String playerName = player.getName().toLowerCase();
			int startupAmount = plugin.getConfig().getInt("startAmount");
			if(startupAmount == 0) {
				//do nothing if startupAmount is 0
			} else {
				plugin.getConfig().set(playerName.toLowerCase() + ".credits", startupAmount);
				plugin.saveConfig();
			}
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		int levels = plugin.getConfig().getInt(player.getName().toLowerCase() + ".credits");
		if(levels == 0) {
			//do nothing!
		} else {
			//do nothing
		}
	}

}

