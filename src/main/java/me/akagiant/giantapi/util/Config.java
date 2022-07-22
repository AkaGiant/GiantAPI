package me.akagiant.giantapi.util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Config {

    private static Plugin plugin;
    private String fileName;
    private FileConfiguration config;
    private File file;

    @SuppressWarnings("ConstantConditions")
    public Config(Plugin plugin, String fileName) {
        this.fileName = fileName;
        file = new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + fileName + ".yml");
        saveDefaultConfig();
        config = YamlConfiguration.loadConfiguration(file);
    }


    public FileConfiguration getConfig() {
        return config;
    }

    public static FileConfiguration getConfig(String configName) {
        File file = getFile(configName);
        if (file == null) return null;
        return YamlConfiguration.loadConfiguration(file);
    }



    public File getFile() {
        return file;
    }

    @SuppressWarnings("ConstantConditions")
    static File getFile(String fileName) {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + fileName + ".yml");
        if (file.exists()) return file;
        return null;
    }

    public boolean exists() {
        return file.exists();
    }

    static boolean exists(File file) {
        return file.exists();
    }

    public void saveConfig() {
        try {
            this.getConfig().save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("ConstantConditions")
    private void saveDefaultConfig() {
        if (file == null)
            file = new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + fileName + ".yml");

        if (!file.exists()) {
            plugin.saveResource(fileName + ".yml", false);
        }
    }


    public void reloadConfig() {
        if (!exists()) {
            Bukkit.getLogger().severe(fileName + ".yml does not exists!");
            return;
        }
        config = YamlConfiguration.loadConfiguration(file);
        InputStream stream = plugin.getResource(fileName);
        if (stream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(stream));
            config.setDefaults(defaultConfig);
        }
    }

    public static void reloadConfig(File file) {
        if (!exists(file)) {
            Bukkit.getLogger().severe(file.getName() + ".yml does not exists!");
            return;
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        InputStream stream = plugin.getResource(file.getName());
        if (stream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(stream));
            config.setDefaults(defaultConfig);
        }
    }
}
