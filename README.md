`NowEssentials é um plugin com comandos especiais, assim como o Essentials, System e muitos outros, a diferença e particularidade do NowEssentials
está em sua composição que permite que você customize os comandos do plugin e a forma que eles agem de forma livre.`

**O que torna o NowEssentials especial ?**

 ``O simples fato de termos uma API para sincronizar os eventos,
 assim você pode ter um controle maior de como o plugin funciona
 ou até mesmo um debug disto.``

![Link](https://imgur.com/XTAqGHq.png)
 
 **Recursos da API**
 - FlyToggleEvent
 - FlyUntoggleEvent
 - VanishToggleEvent
 - VanishUntoggleEvent
 - ...Outros olhe o Wiki

**Ativadores de Comando**
Usando um método de ``Reflections`` foi criado uma forma de
adicionar ou remover comandos do plugin sem tanto trabalho.

**Código do acionador**
``
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
``
