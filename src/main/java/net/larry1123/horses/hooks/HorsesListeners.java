package net.larry1123.horses.hooks;

import net.canarymod.Canary;
import net.canarymod.api.entity.Entity;
import net.canarymod.api.entity.EntityType;
import net.canarymod.api.entity.living.animal.Horse;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.entity.living.monster.Zombie;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.entity.EntityMountHook;
import net.canarymod.hook.entity.EntitySpawnHook;
import net.canarymod.hook.player.EntityRightClickHook;
import net.canarymod.plugin.PluginListener;

public class HorsesListeners implements PluginListener {

    @HookHandler
    public void entityClicked(EntityRightClickHook hook) {
        Entity enity = hook.getEntity();
        Player player = hook.getPlayer();
        if (enity.getEntityType().equals(EntityType.SKELETONHORSE)) {
            Horse horse = (Horse) enity;
            EntityMountHook mountHook = new EntityMountHook(horse, player);
            if (mountHook.isCanceled()) {
                // TODO Give Line for Not being allowed to mount This Horse
            } else {
                horse.setRider(player);
            }
        }
        if (enity.getEntityType().equals(EntityType.ZOMBIEHORSE)) {
            Horse horse = (Horse) enity;
            EntityMountHook mountHook = new EntityMountHook(horse, player);
            if (mountHook.isCanceled()) {
                // TODO Give Line for Not being allowed to mount This Horse
            } else {
                horse.setRider(player);
            }
        }
    }

    @HookHandler
    public void entityMounted(EntityMountHook hook) {
        // TODO
    }

    public void entitySpawn(EntitySpawnHook hook) {
        Entity entity = hook.getEntity();
        if (entity.getEntityType().equals(EntityType.ZOMBIE)) {
            Zombie zombie = (Zombie) entity;
            Horse horse = (Horse) Canary.factory().getEntityFactory().newEntity(EntityType.ZOMBIEHORSE, zombie.getLocation());
            horse.setRider(zombie);
        }
    }

}
