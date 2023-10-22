package com.tiostitch.essentials.commands.visuais;

import com.tiostitch.essentials.api.fly.FlyToggleEvent;
import com.tiostitch.essentials.api.fly.FlyUntoggleEvent;
import com.tiostitch.essentials.commands.CMDManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage("[DEBUG] Apenas jogadores podem fazer isto!");
            return false;
        }

        Player player = (Player) sender;
        if (!player.hasPermission(CMDManager.getCommandPermission("fly"))) {
            player.sendMessage(CMDManager.getNoPermMessage("fly"));
            return false;
        }

        if (args.length >= 1) {
            player.sendMessage(CMDManager.getIncorrectUsage("fly"));
            return false;
        }

        boolean isFlying = player.getAllowFlight();

        if (isFlying) {
            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendMessage(CMDManager.getDesactiveCommand("fly"));
            Bukkit.getPluginManager().callEvent(new FlyUntoggleEvent(player));
            return false;
        }

        player.setAllowFlight(true);
        player.setFlying(true);
        Bukkit.getPluginManager().callEvent(new FlyToggleEvent(player));
        player.sendMessage(CMDManager.getActiveCommand("fly"));

        return false;
    }
}
