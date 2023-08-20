package com.tiostitch.snowEssentials.listener;

import com.tiostitch.snowEssentials.NowEssentials;
import com.tiostitch.snowEssentials.utils.MessageUtils;
import org.apache.logging.log4j.message.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;

public class CommandBlocker implements Listener {

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage().toLowerCase();

        if (player == null) {
            return;
        }

        boolean blockEnabled = NowEssentials.plugin.getConfig().getBoolean("block-enabled");
        if (!blockEnabled) {
            return;
        }

        String bypassPermission = NowEssentials.plugin.getConfig().getString("block-bypass-permission");
        if (player.hasPermission(bypassPermission)) {
            return;
        }

        List<String> blockedCommands = NowEssentials.plugin.getConfig().getStringList("blocked-commands");
        if (blockedCommands.contains(command)) {
            event.setCancelled(true);
            boolean blockedMessage = NowEssentials.plugin.getConfig().getBoolean("blocked-message");
            if (blockedMessage) {
                String blockedCommandMessage = NowEssentials.plugin.getConfig().getString("blocked-command-message");
                MessageUtils.sendMessage(player, blockedCommandMessage);
            }
        }
    }
}