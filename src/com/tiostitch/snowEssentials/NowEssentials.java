package com.tiostitch.snowEssentials;

import com.google.common.base.Stopwatch;
import com.tiostitch.snowEssentials.listener.CommandBlocker;
import org.apache.commons.lang3.time.StopWatch;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.TimeUnit;

public class NowEssentials extends JavaPlugin {

    public static NowEssentials plugin;

    @Override
    public void onEnable() {
        plugin = this;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        saveDefaultConfig();
        CommandManager.registerCommands();

        stopWatch.stop();
        long time = stopWatch.getTime(); // Tempo decorrido em milissegundos
        Bukkit.getConsoleSender().sendMessage("§6[SnowEssentials] §aInicializado com sucesso! (" + time + " ms)");
    }
}
