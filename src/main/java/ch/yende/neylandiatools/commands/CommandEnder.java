package ch.yende.neylandiatools.commands;

import ch.yende.neylandiatools.NeylandiaTools;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandEnder implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length >= 2) {
                sender.sendMessage(NeylandiaTools.prefix + "§c/ec [Joueur]");

                return false;
            }

            if (args.length == 0) {
                player.openInventory(player.getEnderChest());

                return true;
            } else {
                Player playerEnderchest = Bukkit.getPlayer(args[0]);

                if (playerEnderchest == null) {
                    player.sendMessage(NeylandiaTools.prefix + "§cCe joueur n'est pas connecté !");

                    return false;
                }

                player.openInventory(playerEnderchest.getEnderChest());

                return true;
            }
        }
        return false;
    }

}
