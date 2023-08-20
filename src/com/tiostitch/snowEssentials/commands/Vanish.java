package com.tiostitch.snowEssentials.commands;

import com.tiostitch.snowEssentials.NowEssentials;
import com.tiostitch.snowEssentials.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class Vanish implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            String serverVersion = Bukkit.getServer().getVersion();
            boolean versaoantiga = false;

            if (serverVersion.contains("1.8")) {
                if (serverVersion.contains("1.8.") || serverVersion.contains("1.7.") || serverVersion.contains("1.6.") || serverVersion.contains("1.5.") || serverVersion.contains("1.4.") || serverVersion.contains("1.3.") || serverVersion.contains("1.2.") || serverVersion.contains("1.1.") || serverVersion.contains("1.0.")) {
                    versaoantiga = true;
                }
            } else if (serverVersion.contains("1.7") || serverVersion.contains("1.6") || serverVersion.contains("1.5") || serverVersion.contains("1.4") || serverVersion.contains("1.3") || serverVersion.contains("1.2") || serverVersion.contains("1.1") || serverVersion.contains("1.0")) {
                versaoantiga = true;
            }


            if (player.hasPermission(NowEssentials.plugin.getConfig().getString("messages.vanish-permission"))) {

                    if (args.length >= 1) {
                        MessageUtils.sendMessage(player, NowEssentials.plugin.getConfig().getString("messages.vanish-usage"));
                        return false;
                    }

                    if (args.length == 0) {
                        if (versaoantiga) {
                            boolean isVisible = player.hasPotionEffect(PotionEffectType.INVISIBILITY);
                            if (isVisible) {
                                MessageUtils.sendMessage(player, NowEssentials.plugin.getConfig().getString("messages.desativo-vanish"));
                                player.removePotionEffect(PotionEffectType.INVISIBILITY);
                            } else {
                                MessageUtils.sendMessage(player, NowEssentials.plugin.getConfig().getString("messages.ativo-vanish"));
                                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 255));
                            }
                        } else {
                            boolean isVisible = player.canSee(player);
                            if (isVisible) {
                                MessageUtils.sendMessage(player, NowEssentials.plugin.getConfig().getString("messages.desativo-vanish"));
                                player.spigot().setCollidesWithEntities(false);
                            } else {
                                MessageUtils.sendMessage(player, NowEssentials.plugin.getConfig().getString("messages.ativo-vanish"));
                                player.spigot().setCollidesWithEntities(true);
                            }
                        return true;
                    }
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