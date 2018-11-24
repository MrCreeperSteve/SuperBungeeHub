package me.NukerFall.SuperHub.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import me.NukerFall.SuperHub.Main;
import me.NukerFall.SuperHub.Utils.ChatUtils;

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
		if (plugin.getConfig().getBoolean("ChatBlock.enabled") == true) {
		if (plugin.getConfig().getBoolean("ChatBlock.permission") == true) {
		if (!e.getPlayer().hasPermission("superhub.chat.write")) {
		if (!e.getMessage().contains("/")) {
		e.setCancelled(true);
    	e.getPlayer().sendMessage(ChatUtils.chat(plugin.getConfig().getString("ChatBlock.message")));
		}
		    }
		} else {
			if (!e.getMessage().contains("/")) {
				e.setCancelled(true);
		    	e.getPlayer().sendMessage(ChatUtils.chat(plugin.getConfig().getString("ChatBlock.message")));
		       }
		    }
	     } 
      }
   }
}