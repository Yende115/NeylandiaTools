package ch.yende.neylandiatools.commands;

import ch.yende.neylandiatools.NeylandiaTools;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CommandHat implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;
            Inventory playerInventory = player.getInventory();

            if (args.length >= 2) {
                sender.sendMessage(NeylandiaTools.prefix + "§c/hat [Joueur]");

                return false;
            }

            ItemStack itemHand = player.getInventory().getItemInMainHand();

            if (args.length == 1) {
                Player playerSetHat = Bukkit.getPlayer(args[0]);

                if (playerSetHat == null) {
                    player.sendMessage(NeylandiaTools.prefix + "§cCe joueur n'est pas connecté !");
                }
                ItemStack itemHead = playerSetHat.getInventory().getHelmet();

                playerSetHat.getInventory().setHelmet(itemHand);
                player.getInventory().setItemInMainHand(itemHead);
            }

            ItemStack itemHead = player.getInventory().getHelmet();

            player.getInventory().setHelmet(itemHand);
            player.getInventory().setItemInMainHand(itemHead);

            player.sendMessage(NeylandiaTools.prefix + "§2Votre nouveau chapeau est désormais un " + itemHand.toString() + " !");
        }
        return true;
    }
}
