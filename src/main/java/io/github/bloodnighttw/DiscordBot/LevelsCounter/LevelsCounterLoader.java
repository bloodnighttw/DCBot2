package io.github.bloodnighttw.DiscordBot.LevelsCounter;

import io.github.bloodnighttw.DiscordBot.CommandInterface.CommandHandler;
import io.github.bloodnighttw.DiscordBot.LevelsCounter.Commands.Rank;
import io.github.bloodnighttw.DiscordBot.LevelsCounter.Data.GuildLevelsController;
import io.github.bloodnighttw.DiscordBot.LevelsCounter.Listener.MessengeReceiver;
import io.github.bloodnighttw.DiscordBot.Main;
import net.dv8tion.jda.api.JDA;



public class LevelsCounterLoader {

    public static GuildLevelsController<LevelsCounterLoader> guildLevelsControllerINSTANCE = new GuildLevelsController<>();


    public static GuildLevelsController<LevelsCounterLoader> getGuildLevelsControllerINSTANCE() {
        return guildLevelsControllerINSTANCE;
    }

    public static void load(){
        loadCommands(CommandHandler.getINSTANCE());
        loadEventListener(Main.getJda());
    }

    private static void loadCommands(CommandHandler instance){
        instance.addCommand(new Rank());
    }

    private static void loadEventListener(JDA jda){
        jda.addEventListener(new MessengeReceiver());
    }

}
