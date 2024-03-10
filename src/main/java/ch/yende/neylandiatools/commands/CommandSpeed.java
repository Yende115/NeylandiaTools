package ch.yende.neylandiatools.commands;

import ch.yende.neylandiatools.NeylandiaTools;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandSpeed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            //Si l'émetteur n'est pas un joueur
            NeylandiaTools.getInstance().getLogger().severe("Cette commande est réservée aux joueurs");

            return true;
        }

        Player player = (Player) sender;

        if (args.length >= 2) {

            player.sendMessage(NeylandiaTools.prefix + "§c/speed <nombre>");

            return true;
        }

        if (args.length == 0) {
            player.setFlySpeed(0.5f);
            player.sendMessage(NeylandiaTools.prefix + "§2Application d'un effet de vitesse de 5");

            return true;
        }

        if (args[0].equalsIgnoreCase("stop") || args[0].equalsIgnoreCase("reset") || args[0].equalsIgnoreCase("r")) {

            player.setFlySpeed(0.12f);
            player.sendMessage(NeylandiaTools.prefix + "§2Annulation de l'effet de vitesse");

            return true;
        }

        try {
            int speed = Integer.parseInt(args[0]);

            if (speed > 10) {
                player.sendMessage(NeylandiaTools.prefix + "§cLa valeur ne peut pas être supérieure à 10 !");

                return true;
            }

            if (speed <= 0) {
                player.sendMessage(NeylandiaTools.prefix + "§cLa valeur ne peut pas être négative ou égale à 0 !");

                return true;
            }

            player.setFlySpeed((float) speed / 10);
            player.setWalkSpeed((float) speed / 10);

            player.sendMessage(NeylandiaTools.prefix + "§2Application d'un effet de vitesse de " + speed);

            return true;
        } catch (NumberFormatException e) {
            // Si la conversion échoue, envoyer un message au joueur
            player.sendMessage(NeylandiaTools.prefix + "§cL'argument doit être un chiffre");

            return false;
        }
    }
}