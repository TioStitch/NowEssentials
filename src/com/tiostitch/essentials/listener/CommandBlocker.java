package com.tiostitch.essentials.listener;

import com.tiostitch.essentials.NowEssentials;
import com.tiostitch.essentials.utils.MessageUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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