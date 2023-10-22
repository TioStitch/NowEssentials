package com.tiostitch.essentials.commands.visuais;

import com.tiostitch.essentials.api.enderchest.EnderChestOpenEvent;
import com.tiostitch.essentials.api.enderchest.EnderChestOtherOpenEvent;
import com.tiostitch.essentials.api.fly.FlyToggleEvent;
import com.tiostitch.essentials.api.fly.FlyUntoggleEvent;
import com.tiostitch.essentials.commands.CMDManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage("[DEBUG] Apenas jogadores podem fazer isto!");
            return false;
        }

        Player player = (Player) sender;
        if (!player.hasPermission(CMDManager.getCommandPermission("enderchest"))) {
            player.sendMessage(CMDManager.getNoPermMessage("enderchest"));
            return false;
        }

        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                player.openInventory(target.getEnderChest());
                player.sendMessage(CMDManager.getDesactiveCommand("enderchest"));
                Bukkit.getPluginManager().callEvent(new EnderChestOtherOpenEvent(player, target));
                return false;
            }
            return false;
        }

        player.openInventory(player.getEnderChest());
        Bukkit.getPluginManager().callEvent(new EnderChestOpenEvent(player));
        player.sendMessage(CMDManager.getActiveCommand("enderchest"));

        return false;
    }
}
