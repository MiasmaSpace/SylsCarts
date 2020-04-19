package me.rhapso.sylscarts;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Rail;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.vehicle.VehicleEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.event.vehicle.VehicleUpdateEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;

public class cartListener implements Listener {

    @EventHandler
    public void onExitVehicle(VehicleExitEvent e){
        if(e.getVehicle().getType().equals(EntityType.MINECART)){
            Entity cart = e.getVehicle();
            cart.getWorld().dropItem(cart.getLocation(), new ItemStack(Material.MINECART));
            cart.remove();
        }

    }

    @EventHandler
    public void onVehicleUpdate(VehicleUpdateEvent e){
        if(e.getVehicle().getVelocity().length()!=0.0){
            if(e.getVehicle().getWorld().getBlockAt(e.getVehicle().getLocation()).getType().name().contains("RAIL")){
                e.getVehicle().setVelocity(e.getVehicle().getVelocity().normalize().multiply(0.25));

            }
        }
    }
}
