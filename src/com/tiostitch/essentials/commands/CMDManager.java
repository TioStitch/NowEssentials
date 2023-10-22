package com.tiostitch.essentials.commands;

import com.tiostitch.essentials.NowEssentials;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class CMDManager {

    public static List<String> commands = new ArrayList<>();

    public static void loadCommands() {
        int addToCount = 0;
        List<String> lista_comandos = NowEssentials.plugin.getConfig().getStringList("settings.comandos-ativos");
        Bukkit.getConsoleSender().sendMessage("§fComandos carregados com sucesso!");
        Bukkit.getConsoleSender().sendMessage("§fComandos carregados: §a" + lista_comandos.size());
        for (String comando : lista_comandos) {
            if (comando.split(":")[1].equals("true")) {
                commands.add(comando.split(":")[0]);
                addToCount++;
            }
        }
        Bukkit.getConsoleSender().sendMessage("§fComandos carregados: §a" + addToCount);
    }

    public static String getNoPermMessage(String command) {
        String no_permission = NowEssentials.plugin.getConfig().getString("messages." + command + "-no-permission");
        String prefixo = NowEssentials.plugin.getConfig().getString("messages.prefixo");
        return no_permission.replace("%prefixo%", prefixo);
    }

    public static String getCommandPermission(String command) {
        String no_permission = NowEssentials.plugin.getConfig().getString("messages." + command + "-permission");
        String prefixo = NowEssentials.plugin.getConfig().getString("messages.prefixo");
        return no_permission.replace("%prefixo%", prefixo);
    }

    public static String getIncorrectUsage(String command) {
        String no_permission = NowEssentials.plugin.getConfig().getString("messages." + command + "-incorrect-usage");
        String prefixo = NowEssentials.plugin.getConfig().getString("messages.prefixo");
        return no_permission.replace("%prefixo%", prefixo);
    }

    public static String getActiveCommand(String command) {
        String no_permission = NowEssentials.plugin.getConfig().getString("messages." + command + "-active");
        String prefixo = NowEssentials.plugin.getConfig().getString("messages.prefixo");
        return no_permission.replace("%prefixo%", prefixo);
    }

    public static String getDesactiveCommand(String command) {
        String no_permission = NowEssentials.plugin.getConfig().getString("messages." + command + "-desactive");
        String prefixo = NowEssentials.plugin.getConfig().getString("messages.prefixo");
        return no_permission.replace("%prefixo%", prefixo);
    }
}
