package com.github.xCyanide;

import org.bukkit.event.Listener;
import java.io.File;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import com.github.xCyanide.Utils.DataManager;

public class playerListener implements Listener {

	@SuppressWarnings("unused")
	private ClaimLevels plugin;
	DataManager dm = DataManager.getInstance();
	
	public playerListener(ClaimLevels plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		File playerDat = new File("world/players/"+ player.getName() + ".dat");
		if(!playerDat.exists()) {
			String playerName = player.getName().toLowerCase();
			int startupAmount = dm.getData().getInt("startAmount");
			if(startupAmount == 0) {
				dm.getData().set(playerName.toLowerCase() + ".credits", 0);
			} else {
				dm.getData().set(playerName.toLowerCase() + ".credits", startupAmount);
				dm.saveData();
			}
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		int levels = dm.getData().getInt(player.getName().toLowerCase() + ".credits");
		if(levels == 0) {
			//do nothing!
		} else {
			//do nothing
		}
	}

}

