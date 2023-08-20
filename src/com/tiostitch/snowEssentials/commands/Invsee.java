package com.tiostitch.snowEssentials.commands;

import com.tiostitch.snowEssentials.NowEssentials;
import com.tiostitch.snowEssentials.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Invsee implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem executar este comando!");
            return false;
        }

        Player player = (Player) sender;
        if (!player.hasPermission(NowEssentials.plugin.getConfig().getString("messages.invsee-permission"))) {
            MessageUtils.sendMessage(player, NowEssentials.plugin.getConfig().getString("messages.sem-permissao"));
            return false;
        }

        if (args.length == 0) {
            MessageUtils.sendMessage(player, NowEssentials.plugin.getConfig().getString("messages.invsee-usage"));
            return false;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);

        if (targetPlayer == null) {
            player.sendMessage("§cO jogador desejado está offline!");
            return false;
        }

        if (args[0].equalsIgnoreCase(targetPlayer.getName())) {
            MessageUtils.sendMessage(player, NowEssentials.plugin.getConfig().getString("messages.invsee-glitch"));
            return false;
        }

        player.openInventory(targetPlayer.getInventory());
        return true;
    }
}