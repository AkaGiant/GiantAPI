package me.akagiant.giantapi.util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Config {

    private static Plugin plugin;
    private final String fileName;
    private FileConfiguration config;
    private File file;

    @SuppressWarnings("ConstantConditions")
    public Config(Plugin plugin, String fileName) {
        Config.plugin = plugin;
        this.fileName = fileName;
        file = new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + fileName + ".yml");
        saveDefaultConfig();
        config = YamlConfiguration.loadConfiguration(file);
    }

    @SuppressWarnings("ConstantConditions")
    public Config(Plugin plugin, String fileName, String subFolder) {
        this.fileName = fileName;
        Config.plugin = plugin;
        file = new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + subFolder + File.separator + fileName + ".yml");
        saveDefaultConfig(subFolder);
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

    public static FileConfiguration getConfig(String configName, String subFolder) {
        File file = getFile(configName, subFolder);
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


    @SuppressWarnings("ConstantConditions")
    static File getFile(String fileName, String subFolder) {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + subFolder + File.separator + fileName + ".yml");
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

    @SuppressWarnings("ConstantConditions")
    public void saveDefaultConfig(String subDirectory) {
        if (file == null)
            file = new File(Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder(), File.separator + subDirectory + File.separator + fileName + ".yml");

        if (!file.exists()) {
            plugin.saveResource(subDirectory + File.separator + fileName + ".yml", false);
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

    public static List<File> getAllConfigurationFiles(Plugin plugin) {
        return listf(plugin.getDataFolder().getAbsolutePath());
    }

    private static List<File> listf(String directoryName) {
        File directory = new File(directoryName);

        List<File> resultList = new ArrayList<File>();

        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                resultList.add(file);
            } else if (file.isDirectory()) {
                resultList.addAll(listf(file.getAbsolutePath()));
            }
        }
        //System.out.println(fList);
        return resultList;
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
