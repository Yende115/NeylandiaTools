package ch.yende.neylandiatools.commands.gm;

import ch.yende.neylandiatools.NeylandiaTools;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandGmc implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Si l'émetteur de la commande est un joueur
        if (sender instanceof Player) {

            //Création d'une variable "player" qui est égal au "sender"
            Player player = (Player) sender;

            if (args.length >= 2){
                player.sendMessage(NeylandiaTools.prefix + "§c/gmc <joueur>");
                return false;
            }

            if (args.length == 0){
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(NeylandiaTools.prefix + "§2Changement de votre mode de jeu pour créatif");
                return true;
            }

            Player message = Bukkit.getPlayer(args[0]);

            if (message == null){
                player.sendMessage(NeylandiaTools.prefix + "§cCe joueur n'est pas connecté");
                return false;
            } else {
                if (message.getGameMode() == GameMode.CREATIVE) {
                    player.sendMessage(NeylandiaTools.prefix + "§cCe joueur est déjà en créatif");
                    return false;
                }
                player.setGameMode(GameMode.CREATIVE);
            }
            //Exécute la commande dans la console
            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode creative " + message);
            message.setGameMode(GameMode.CREATIVE);

        }
        return true;
    }
}
