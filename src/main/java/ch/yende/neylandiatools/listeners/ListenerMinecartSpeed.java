package ch.yende.neylandiatools.listeners;

import ch.yende.neylandiatools.NeylandiaTools;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
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

        //Si le véhicule est un minecart
        if (event.getVehicle() instanceof Minecart) {

            //Création des variables
            Minecart minecart = (Minecart) event.getVehicle();
            Block blockUnder = minecart.getLocation().getBlock().getRelative(0, 0, 0);

            //Si le bloc en-dessous du minecart est un rail
            if (blockUnder.getType() == Material.POWERED_RAIL) {
                Vector currentVelocity = minecart.getVelocity();
                double speedMultiplier = 1.2;

                Vector newVelocity = currentVelocity.multiply(speedMultiplier);
                minecart.setVelocity(newVelocity);
            }
        }
    }
}
