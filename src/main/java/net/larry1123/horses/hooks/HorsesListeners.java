package net.larry1123.horses.hooks;

import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.EntityType;
import net.canarymod.api.entity.living.animal.Horse;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.EntityRightClickHook;
import net.canarymod.plugin.PluginListener;

public class HorsesListeners implements PluginListener {

    @HookHandler
    public void entityClicked(EntityRightClickHook hook) {
        Entity enity = hook.getEntity();
        Player player = hook.getPlayer();
        if (enity.getEntityType().equals(EntityType.SKELETONHORSE)) {
            Horse horse = (Horse) enity;
            horse.setRider(player);
        }
    }

}
