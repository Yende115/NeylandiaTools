package ch.yende.neylandiatools.commands;

import ch.yende.neylandiatools.NeylandiaTools;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandYoutube implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length >= 1) {
                String lien = "https://youtube.com/c/" + args[0];
                TextComponent msg = new TextComponent(NeylandiaTools.prefix + "§2Le lien a été créé !");
                msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§2Cliquez pour ouvrir le lien").create()));
                msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, lien));

                player.spigot().sendMessage(msg);
            } else {
                player.sendMessage(NeylandiaTools.prefix + "§c/" + label + " <Chaine YouTube>");
                return false;
            }
        } else {
            //si l'émetteur du message n'est pas un joueur
            if (args.length >= 1) {
                String lien = "https://youtube.com/c/" + args[0];
                sender.sendMessage(lien);
            } else {
                sender.sendMessage(NeylandiaTools.prefix + "§c/" + label + " <Chaine YouTube>");
                return false;
            }

        }

        return false;
    }
}
