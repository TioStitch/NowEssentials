package com.tiostitch.snowEssentials;

import com.tiostitch.snowEssentials.commands.Fly;
import com.tiostitch.snowEssentials.commands.Help;
import com.tiostitch.snowEssentials.commands.Invsee;
import com.tiostitch.snowEssentials.commands.Vanish;
import org.bukkit.Bukkit;

public class CommandManager {

    public static void registerCommands() {

        Bukkit.getPluginCommand("fly").setExecutor(new Fly());
        Bukkit.getPluginCommand("help").setExecutor(new Help());
        Bukkit.getPluginCommand("vanish").setExecutor(new Vanish());
        Bukkit.getPluginCommand("invsee").setExecutor(new Invsee());


        Bukkit.getConsoleSender().sendMessage("§a[V] Comandos carregados com sucesso!");
    }
}
