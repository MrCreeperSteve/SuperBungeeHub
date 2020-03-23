package me.NukerFall.SuperBungeeHub.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.NukerFall.SuperBungeeHub.Main;
import me.NukerFall.SuperBungeeHub.Utils.ChatUtils;

public class LeaveListener implements Listener {
	private Main plugin;
	public LeaveListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void PlayerLeave(PlayerQuitEvent e) {
		e.setQuitMessage(plugin.getConfig().getBoolean("BroadcastedLeaveMessage.enabled") ? ChatUtils.chat(plugin.getConfig().getString("BroadcastedLeaveMessage.LeaveMsg").replaceAll("%player%", e.getPlayer().getDisplayName())) : null);
		}
	}
