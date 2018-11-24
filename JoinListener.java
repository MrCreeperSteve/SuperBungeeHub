package me.NukerFall.SuperBungeeHub.Listeners;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.NukerFall.SuperBungeeHub.Main;
import me.NukerFall.SuperBungeeHub.Utils.ChatUtils;

public class JoinListener implements Listener {
	private Main plugin;
	public JoinListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void JoinEvent(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		if (plugin.getConfig().getBoolean("TitleMessage.enabled") == true) {
			player.sendTitle(ChatUtils.chat(plugin.getConfig().getString("TitleMessage.Title")), ChatUtils.chat(plugin.getConfig().getString("TitleMessage.Subtitle")), 1, 200, 1);
		}
		if (plugin.getConfig().getBoolean("BroadcastedJoinMessage.enabled") == true) {
		e.setJoinMessage(ChatUtils.chat(plugin.getConfig().getString("BroadcastedJoinMessage.JoinMsg").replaceAll("%player%", e.getPlayer().getDisplayName())));
		}
		else {
			e.setJoinMessage(null);
		}
		player.setGameMode(GameMode.ADVENTURE);
		if (plugin.getConfig().getBoolean("WelcomeMsg.enabled") == true) {
			List<String> msgs = plugin.getConfig().getStringList("WelcomeMsg.MessageList");
		for (String msg1 : msgs) {
		player.sendMessage(ChatUtils.chat(msg1).replaceAll("%player%", e.getPlayer().getDisplayName()));
		}
		return;
		}
        for(Player p : Bukkit.getOnlinePlayers()) {
            p.hidePlayer(player);
            player.hidePlayer(p);
            }
        }
	}
