package me.saarg.Plugin;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {
    
    private Logger logger = null;
    private boolean enable = true;
    private int percent = 50;

    private int playerOnBed = 0;

    public void addOnePlayerOnBed() {
	playerOnBed += 1;

	if(enable) {
	    Player[] ps = Bukkit.getServer().getOnlinePlayers();
	    for (Player pp : ps) {
		pp.sendMessage(ChatColor.YELLOW+"BEDTIME: "+ChatColor.ITALIC+" "+Integer.toString(playerOnBed)+"/"+Integer.toString(Bukkit.getOnlinePlayers().length)+" joueurs sont dans leur lit.");
	    }

	    if((float)(playerOnBed)/Bukkit.getOnlinePlayers().length >= (float)(percent/100.0)) {
		Bukkit.getServer().getWorlds().get(0).setTime(0);
		playerOnBed = 0;
	    }
	}
    }

    public void removeOnePlayerOnBed() {
	if(playerOnBed > 0)
	    playerOnBed -= 1;
    }

    @Override
    public void onEnable() {
	logger = Bukkit.getLogger();
	logger.info("BedTime plugin loaded");

	getServer().getPluginManager().registerEvents(new PluginListener(this), this);
    }

    @Override
    public void onDisable() {
	logger.info("BedTime plugin unloaded");
    }

    public boolean onCommand(final CommandSender s, Command c, String l, String[] a) {
	if (c.getName().equalsIgnoreCase("bedtime")) {
	    if (!(s instanceof Player)) {
		s.sendMessage(ChatColor.RED+"Vous devez être un joueur");
		return true;
	    }
	    Player pl = (Player)s;
	    if (!pl.isOp()) {
		pl.sendMessage(ChatColor.RED+"Lolnope.");
		return true;
	    }
	    if (a.length == 0) {
		pl.sendMessage("Usage : /bedtime <enable|percent|disable>");
		return true;
	    }

	    if(a[0].equalsIgnoreCase("enable")) {
		enable = true;
	    } else if(a[0].equalsIgnoreCase("disable")) {
		enable = false;
	    } else if(a[0].equalsIgnoreCase("percent")) {
		percent = Integer.parseInt(a[1]);
		return true;
	    } else if(a[0].equalsIgnoreCase("reset")) {
		playerOnBed = 0;
		return true;
	    }
	}
	return false;
    }
}
