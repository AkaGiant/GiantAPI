package me.akagiant.giantapi;

import me.akagiant.giantapi.util.Config;
import org.bukkit.plugin.java.JavaPlugin;

public final class GiantAPI extends JavaPlugin {

    static GiantAPI plugin;
    public static Config config, config1;

    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        config = new Config(plugin, "config");
        config1 = new Config(plugin, "config1", "test");

        Config.reloadAllConfigs();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
