package me.NukerFall.SuperHub;


import org.bukkit.plugin.java.JavaPlugin;

import me.NukerFall.SuperHub.Listeners.AuthMeLogin;
import me.NukerFall.SuperHub.Listeners.ChatListener;
import me.NukerFall.SuperHub.Listeners.JoinListener;
import me.NukerFall.SuperHub.Listeners.LeaveListener;
import me.NukerFall.SuperHub.Listeners.ServPingListener;

public class Main extends JavaPlugin {
	public void onEnable() {
		getServer().getConsoleSender().sendMessage("Super Hub successfully enabled!");
		new JoinListener(this);
		new ServPingListener(this);
		new LeaveListener(this);
		new ChatListener(this);
		if (this.getServer().getPluginManager().isPluginEnabled("AuthMe")) {
		getServer().getConsoleSender().sendMessage("Super HubFound AuthMe.");
		getServer().getConsoleSender().sendMessage("Don't forget to enable hook in Super Hub plugin config.");
		new AuthMeLogin(this);
		}
		saveDefaultConfig();
	}
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("&7Super Hub Disabled");
		saveConfig();
	}
}
