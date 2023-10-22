package com.tiostitch.essentials.commands.visuais;

import com.tiostitch.essentials.api.VanishToggleEvent;
import com.tiostitch.essentials.api.VanishUntoggleEvent;
import com.tiostitch.essentials.api.fly.FlyToggleEvent;
import com.tiostitch.essentials.api.fly.FlyUntoggleEvent;
import com.tiostitch.essentials.commands.CMDManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Vanish implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage("[DEBUG] Apenas jogadores podem fazer isto!");
            return false;
        }

        Player player = (Player) sender;
        if (!player.hasPermission(CMDManager.getCommandPermission("vanish"))) {
            player.sendMessage(CMDManager.getNoPermMessage("vanish"));
            return false;
        }

        if (args.length >= 1) {
            player.sendMessage(CMDManager.getIncorrectUsage("vanish"));
            return false;
        }

        boolean isInvisible = player.hasPotionEffect(PotionEffectType.INVISIBILITY);

        if (isInvisible) {
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
            player.sendMessage(CMDManager.getDesactiveCommand("vanish"));
            Bukkit.getPluginManager().callEvent(new VanishUntoggleEvent(player));
            return false;
        }

        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 255, false));
        player.sendMessage(CMDManager.getActiveCommand("vanish"));
        Bukkit.getPluginManager().callEvent(new VanishToggleEvent(player));

        return false;
    }
}
