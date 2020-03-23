package me.NukerFall.SuperBungeeHub.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import me.NukerFall.SuperBungeeHub.Main;
import me.NukerFall.SuperBungeeHub.Utils.ChatUtils;

@SuppressWarnings("deprecation")
public class ChatListener implements Listener {
	private Main plugin;
	public ChatListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onChatWrite(PlayerChatEvent e) {
		if (plugin.getConfig().getBoolean("ChatFormatting.enabled") == true) {
		e.setFormat(ChatUtils.chat(plugin.getConfig().getString("ChatFormatting.ChatPrefix")
		+ e.getPlayer().getDisplayName() + ChatUtils.chat(plugin.getConfig().getString("ChatFormatting.ChatDivision"))
		+ plugin.getConfig().getString("ChatFormatting.ChatColor") + e.getMessage()));
		}
   }
}