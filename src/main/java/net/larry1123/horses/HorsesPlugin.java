package net.larry1123.horses;

import net.canarymod.Canary;
import net.larry1123.horses.hooks.HorsesListeners;
import net.larry1123.util.plugin.UtilPlugin;

public class HorsesPlugin extends UtilPlugin {

    HorsesListeners listeners = new HorsesListeners();

    @Override
    public boolean enable() {
        Canary.hooks().registerListener(listeners, this);
        return true;
    }

    @Override
    public void disable() {
        Canary.hooks().unregisterPluginListeners(this);
    }
}
