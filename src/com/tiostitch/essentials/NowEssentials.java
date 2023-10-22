package com.tiostitch.essentials;

import com.tiostitch.essentials.commands.CMDManager;
import org.apache.commons.lang3.time.StopWatch;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class NowEssentials extends JavaPlugin {

    public static NowEssentials plugin;

    @Override
    public void onEnable() {
        plugin = this;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        saveDefaultConfig();
        CMDManager.loadCommands();
        try {
            CommandManager.registerCommands();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        stopWatch.stop();
        long time = stopWatch.getTime(); // Tempo decorrido em milissegundos
        Bukkit.getConsoleSender().sendMessage("§6[SnowEssentials] §aInicializado com sucesso! (" + time + " ms)");
    }
}
