package ch.yende.neylandiatools;

import ch.yende.neylandiatools.commands.*;
import ch.yende.neylandiatools.commands.gm.CommandGmc;
import ch.yende.neylandiatools.commands.gm.CommandGmsp;
import ch.yende.neylandiatools.listeners.ListenerMinecartSpeed;
import ch.yende.neylandiatools.listeners.ListenerNews;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class NeylandiaTools extends JavaPlugin {

    private static NeylandiaTools instance;
    public static String message;

    public static String prefix;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("Bonjour !");
        Bukkit.getConsoleSender().sendMessage(
                "§2\n" + getDescription().getName() + " activé !\n" +
                        "§2[NeylandiaTools] Créé par §6" + getDescription().getAuthors() + "\n" +
                        "§2[NeylandiaTools] Version : " + getDescription().getVersion() + "\n" +
                        "§2[NeylandiaTools] " + getDescription().getDescription()
        );
        super.onEnable();

        GetCommand.GetCommand(this);

        getServer().getPluginManager().registerEvents(new ListenerNews(this),this);

        getServer().getPluginManager().registerEvents(new ListenerMinecartSpeed(this),this);

        File file = new File(this.getDataFolder(),"config.yml");
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        String news = this.getConfig().getString("Messages.News");

        message = "§a============== §b§l[§r§7News de Neylandia§b§l] §r§a==============§r\n" + news;

        prefix = "§b§l[§r§7NeylandiaTools§b§l]§r ";

        this.instance = this;

        try {
            configuration.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("À bientôt !");
    }

    public static NeylandiaTools getInstance() {
        return instance;
    }
}
