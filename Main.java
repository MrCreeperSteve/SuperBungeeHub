package me.NukerFall.SuperHub;

import org.bukkit.plugin.java.JavaPlugin;
import me.NukerFall.SuperHub.Listeners.JoinListener;
import me.NukerFall.SuperHub.Listeners.LeaveListener;
import me.NukerFall.SuperHub.Listeners.ServPingListener;

public class Main extends JavaPlugin {
	public void onEnable() {
		getServer().getConsoleSender().sendMessage("SuperHub successfully enabled!");
		new JoinListener(this);
		new ServPingListener(this);
		new LeaveListener(this);
		saveDefaultConfig();
	}
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("&7SuperHub Disabled");
		saveConfig();
	}
}
