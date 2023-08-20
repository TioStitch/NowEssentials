package com.tiostitch.snowEssentials.commands;

import com.tiostitch.snowEssentials.NowEssentials;
import com.tiostitch.snowEssentials.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Help implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission(NowEssentials.plugin.getConfig().getString("messages.help-permission"))) {

                    if (args.length >= 1) {
                        MessageUtils.sendMessage(player, NowEssentials.plugin.getConfig().getString("messages.help-usage"));
                        return false;
                    }


                    if (args.length == 0) {
                        player.sendMessage("");
                        player.sendMessage("   §bNowEssentials §f- §av1.0");
                        player.sendMessage("");
                        player.sendMessage(" §eComandos:");
                        player.sendMessage("  §a/voar §f- permissão: §c" + getPermissionNode("flight-permission"));
                        player.sendMessage("  §a/verInv §f- permissão: §c" + getPermissionNode("invsee-permission"));
                        player.sendMessage("  §a/invi §f- permissão: §c" + getPermissionNode("vanish-permission"));
                        player.sendMessage("  §a/cores §f- permissão: §c" + getPermissionNode("colorChat-permission"));
                        player.sendMessage("");
                        player.sendMessage(" §a/ajuda §f- permissão: §c" + getPermissionNode("messages.help-permission"));
                        player.sendMessage("");
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

    public static String getPermissionNode(String permission) {
        return NowEssentials.plugin.getConfig().getString("messages." + permission);
    }
}

