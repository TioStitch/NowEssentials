package com.tiostitch.snowEssentials.commands;

import com.tiostitch.snowEssentials.NowEssentials;
import com.tiostitch.snowEssentials.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Fly implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            boolean isFlight = player.getAllowFlight();

            if (player.hasPermission(NowEssentials.plugin.getConfig().getString("messages.flight-permission"))) {

                    if (args.length >= 1) {
                        MessageUtils.sendMessage(player, NowEssentials.plugin.getConfig().getString("messages.flight-usage"));
                        return false;
                    }

                    if (args.length == 0) {
                        if (isFlight) {
                            MessageUtils.sendMessage(player, NowEssentials.plugin.getConfig().getString("messages.desativo-flight"));
                            player.setAllowFlight(false);
                        } else {
                            MessageUtils.sendMessage(player, NowEssentials.plugin.getConfig().getString("messages.ativo-flight"));
                            player.setAllowFlight(true);
                        }
                        return true;
                    }
            } else {
                MessageUtils.sendMessage(player, NowEssentials.plugin.getConfig().getString("messages.sem-permissao"));
            }
        } else {
            sender.sendMessage("§cApenas jogadores podem executar este comando!");
        }

        return false;
    }
}
