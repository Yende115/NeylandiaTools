package ch.yende.neylandiatools.listeners;

import ch.yende.neylandiatools.NeylandiaTools;
import ch.yende.neylandiatools.commands.CommandNews;
import org.bukkit.Bukkit;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ListenerNews implements Listener {

    private NeylandiaTools plugin;
    public ListenerNews(NeylandiaTools neylandiaTools) {
        this.plugin = neylandiaTools;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        if (NeylandiaTools.getInstance().getConfig().get("Messages.Auto-message").equals(true)) {

            Player player = event.getPlayer();

            Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                @Override
                public void run() {
                    player.sendMessage(NeylandiaTools.message);
                }
            }, 100L);

        }
    }
}
