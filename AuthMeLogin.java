package me.NukerFall.SuperHub.Listeners;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import fr.xephi.authme.events.AuthMeAsyncPreLoginEvent;
import me.NukerFall.SuperHub.Main;
import me.NukerFall.SuperHub.Utils.ChatUtils;

public class AuthMeLogin implements Listener {
	private Main plugin;
	public AuthMeLogin(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
@EventHandler
public void onPreLogin(AuthMeAsyncPreLoginEvent e) {
	if (plugin.getConfig().getBoolean("AuthMe.enabled") == true) {
		if (plugin.getConfig().getBoolean("AuthMe.Title.enabled")) {
		e.getPlayer().sendTitle(ChatUtils.chat(plugin.getConfig().getString("AuthMe.Title.Title")), ChatUtils.chat(plugin.getConfig().getString("AuthMe.Title.Subtitle")), 0, 200, 0);
		    }
		if (plugin.getConfig().getBoolean("AuthMe.Message.enabled")) {
			e.getPlayer().sendMessage(ChatUtils.chat(plugin.getConfig().getString("AuthMe.Message.Message")));
		}
		}
	}
}
