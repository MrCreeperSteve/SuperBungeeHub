package me.NukerFall.SuperBungeeHub.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import me.NukerFall.SuperBungeeHub.Main;

public class ServPingListener implements Listener {
	private Main plugin;
	public ServPingListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	  public void onServerPing(ServerListPingEvent e)
	  {
		if (plugin.getConfig().getBoolean("Server_MoTD.enabled") == true) {
	    String motd1 = plugin.getConfig().getString("Server_MoTD.Line-1");
	    String motd2 = plugin.getConfig().getString("Server_MoTD.Line-2");
	    motd1 = motd1.replace("&", "§");
	    motd2 = motd2.replace("&", "§");
	    e.setMotd(motd1 + "\n" + motd2);
		}
	}
}
