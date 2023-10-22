package com.tiostitch.essentials;

import com.tiostitch.essentials.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;

public class CommandManager {

    public static void registerCommands() throws ClassNotFoundException {

        for (String comandos : CMDManager.commands) {
            try {
                // Obtém a classe com base no nome
                Class<?> classe = Class.forName("com.tiostitch.essentials.commands.visuais." + comandos); // Substitua o caminho do pacote

                // Crie uma instância da classe
                Object instanciaDaClasse = classe.newInstance();

                // Registre o comando e defina o executor com a instância da classe
                Bukkit.getPluginCommand(comandos).setExecutor((CommandExecutor) instanciaDaClasse);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }

        Bukkit.getConsoleSender().sendMessage("§a[V] Comandos carregados com sucesso!");
    }
}
