package com.javaminecraft;

import java.util.logging.Logger;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.plugin.java.JavaPlugin;

public class PetWolf extends JavaPlugin {
	public static final Logger LOG = Logger.getLogger("Minecraft");
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, 
			String label,  String[] arguments){
		if( label.equalsIgnoreCase("petwolf")) {
			if( sender instanceof Player) {
				Player me = (Player) sender;
				Location spot = me.getLocation();
				World world = me.getWorld();
				Wolf wolfie = world.spawn(spot, Wolf.class);
				wolfie.setCollarColor(DyeColor.PINK);
				wolfie.setOwner(me);
				LOG.info("[Petwolf] Howl");
				return true;
			}
		}
		return false;
	}
}
