package com.tiostitch.essentials.utils;

import com.tiostitch.essentials.NowEssentials;
import org.bukkit.entity.Player;

public class MessageUtils {

    public static void sendMessage(Player player, String mensagem) {
        player.sendMessage(mensagem.replace("&", "§")
                .replace("%prefixo%", NowEssentials.plugin.getConfig().getString("messages.prefixo")
                        .replace("&", "§")));
    }
}
