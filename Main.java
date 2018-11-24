package me.NukerFall.SuperBungeeHub;


import org.bukkit.plugin.java.JavaPlugin;

import me.NukerFall.SuperBungeeHub.Listeners.AuthMeLogin;
import me.NukerFall.SuperBungeeHub.Listeners.ChatListener;
import me.NukerFall.SuperBungeeHub.Listeners.JoinListener;
import me.NukerFall.SuperBungeeHub.Listeners.LeaveListener;
import me.NukerFall.SuperBungeeHub.Listeners.ServPingListener;

public class Main extends JavaPlugin {
	public void onEnable() {
		getServer().getConsoleSender().sendMessage("SuperBungeeHub successfully enabled!");
		new JoinListener(this);
		new ServPingListener(this);
		new LeaveListener(this);
		new ChatListener(this);
		if (this.getServer().getPluginManager().isPluginEnabled("AuthMe")) {
		getServer().getConsoleSender().sendMessage("SuperBungeeHub found AuthMe.");
		getServer().getConsoleSender().sendMessage("Don't forget to enable hook in SuperBungeeHub plugin config.");
		new AuthMeLogin(this);
		}
		saveDefaultConfig();
	}
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("&7SuperBungeeHub Disabled");
		saveConfig();
	}
}
