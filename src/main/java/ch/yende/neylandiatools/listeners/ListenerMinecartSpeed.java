package ch.yende.neylandiatools.listeners;

import ch.yende.neylandiatools.NeylandiaTools;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Minecart;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.util.Vector;

public class ListenerMinecartSpeed implements Listener {

    private NeylandiaTools plugin;

    public ListenerMinecartSpeed(NeylandiaTools neylandiaTools) {
        this.plugin = neylandiaTools;
    }

    @EventHandler
    public void onVehicleMove(VehicleMoveEvent event) {
        if (event.getVehicle() instanceof Minecart) {
            Minecart minecart = (Minecart) event.getVehicle();
            Block blockUnder = minecart.getLocation().getBlock().getRelative(0, -1, 0);

            if (blockUnder.getType() == Material.RAIL) {
                Vector currentVelocity = minecart.getVelocity();
                double speedMultiplier = 1.2;

                Vector newVelocity = currentVelocity.multiply(speedMultiplier);
                minecart.setVelocity(newVelocity);
            }
        }
    }
}
