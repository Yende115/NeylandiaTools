package ch.yende.neylandiatools.commands;

import ch.yende.neylandiatools.NeylandiaTools;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandNews implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender,Command command, String label, String[] args) {

            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("set")) {

                    //Liste de caractères
                    List<String> text = new ArrayList<>();

                    //Boucle qui fait en sorte que "i" corresponde au nombre d'arguments de la commande
                    for (int i = 1; i < args.length; i++) {
                        text.add(args[i]);
                    }

                    String message = text.toString().replace(",", "");

                    String message1 = message.replace("[", "");
                    String message2 = message1.replace("]", "");

                    //Transforme la liste "news" en chaîne de caractères
                    NeylandiaTools.getInstance().getConfig().set("Messages.News", message2);

                    //("try" exécute le code dans celui-ci et "catch" s'exécute s'il y a une erreur dans le "try")

                    NeylandiaTools.getInstance().saveConfig();

                    sender.sendMessage(NeylandiaTools.prefix + "§2La news a été mise à jour");

                    return true;

                } else if (args[0] == "toggle") {

                    if (NeylandiaTools.getInstance().getConfig().get("Messages.Auto-message").equals(true)) {
                        NeylandiaTools.getInstance().getConfig().set("Messages.Auto-message", false);

                    } else {

                        NeylandiaTools.getInstance().getConfig().set("Messages.Auto-message", true);

                    }

                } else {

                    sender.sendMessage(NeylandiaTools.prefix + "§c/news set <news>");
                    return false;
                }

            }

            String news = NeylandiaTools.getInstance().getConfig().getString("Messages.News");
            String message = "§a================== §b§l[§r§7News de Neylandia§b§l] §r§a==================§r\n" + news;

            sender.sendMessage(message);

            return true;

    }
}
