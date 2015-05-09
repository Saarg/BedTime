package me.saarg.Plugin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PluginListener implements Listener {

    private Plugin p = null;

    public PluginListener(Plugin p) {
	this.p = p;
    }

    @EventHandler
    public void onPlayerBedEnterEvent(final PlayerBedEnterEvent ev) {
	if(p.isEn())
	    this.p.addOnePlayerOnBed();
    }
    
    @EventHandler
    public void onPlayerBedLeaveEvent(final PlayerBedLeaveEvent ev) {
	if(p.isEn())
	    this.p.removeOnePlayerOnBed();
    }

    @EventHandler
    public void onPlayerQuitEvent(final PlayerQuitEvent ev) {
	
    }

}
