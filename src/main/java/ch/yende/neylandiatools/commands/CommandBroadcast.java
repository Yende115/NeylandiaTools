package ch.yende.neylandiatools.commands;

import ch.yende.neylandiatools.NeylandiaTools;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandBroadcast implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            sender.sendMessage(NeylandiaTools.prefix + "§cLe message ne peut pas être vide !§r");
            return false;
        }

        String message = String.join(" ", args);
        message = ChatColor.translateAlternateColorCodes('&', message);

        Bukkit.broadcastMessage(NeylandiaTools.prefix + message);

        return false;
    }
}
