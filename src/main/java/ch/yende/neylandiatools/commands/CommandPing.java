package ch.yende.neylandiatools.commands;

import ch.yende.neylandiatools.NeylandiaTools;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPing implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            if (args.length >= 2) {
                player.sendMessage(NeylandiaTools.prefix + "§c/ping <joueur>§r");
                return false;
            }

            if (args.length == 0) {
                int ping = player.getPing();
                player.sendMessage(NeylandiaTools.prefix + "§2Votre ping est de " + ping + "§r§2 !");
                return true;
            }

            Player message = Bukkit.getPlayer(args[0]);

            if (message == null) {
                player.sendMessage(NeylandiaTools.prefix + "§cCe joueur n'est pas connecté !§r");
                return false;
            }

            int ping = message.getPing();
            player.sendMessage( NeylandiaTools.prefix + "§2Le ping de " + message.getName() + " est de "+ ping + " !");
            return true;
        }
        return false;
    }
}
