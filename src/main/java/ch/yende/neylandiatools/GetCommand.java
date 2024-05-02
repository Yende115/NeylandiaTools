package ch.yende.neylandiatools;

import ch.yende.neylandiatools.commands.*;
import ch.yende.neylandiatools.commands.gm.CommandGmc;
import ch.yende.neylandiatools.commands.gm.CommandGmsp;
import org.bukkit.plugin.java.JavaPlugin;

public class GetCommand {
    public static void GetCommand(JavaPlugin plugin) {
        plugin.getCommand("broadcast").setExecutor(new CommandBroadcast());
        plugin.getCommand("youtube").setExecutor(new CommandYoutube());
        plugin.getCommand("news").setExecutor(new CommandNews());
        plugin.getCommand("ping").setExecutor(new CommandPing());
        plugin.getCommand("gmc").setExecutor(new CommandGmc());
        plugin.getCommand("speed").setExecutor(new CommandSpeed());
        plugin.getCommand("gmsp").setExecutor(new CommandGmsp());
        plugin.getCommand("hat").setExecutor(new CommandHat());
    }
}
