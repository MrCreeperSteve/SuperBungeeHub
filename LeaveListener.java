package me.NukerFall.SuperHub.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.NukerFall.SuperHub.Main;
import me.NukerFall.SuperHub.Utils.ChatUtils;

public class LeaveListener implements Listener {
	private Main plugin;
	public LeaveListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void PlayerLeave(PlayerQuitEvent e) {
		if (plugin.getConfig().getBoolean("BroadcastedLeaveMessage.enabled") == true) {
		e.setQuitMessage(ChatUtils.chat(plugin.getConfig().getString("BroadcastedLeaveMessage.LeaveMsg").replaceAll("%player%", e.getPlayer().getDisplayName())));
		} else {
			e.setQuitMessage(null);
		}
	}

}
