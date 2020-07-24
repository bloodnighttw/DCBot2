package io.github.bloodnighttw.DiscordBot.LevelsCounter.Listener;

import io.github.bloodnighttw.DiscordBot.LevelsCounter.Data.GuildLevelsController;
import io.github.bloodnighttw.DiscordBot.LevelsCounter.LevelsCounterLoader;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class MessengeReceiver extends ListenerAdapter {

    GuildLevelsController<LevelsCounterLoader> guildLevelsController = LevelsCounterLoader.getGuildLevelsControllerINSTANCE();

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if (event.getAuthor().isBot() || event.getMessage().getContentRaw().contains("!rank"))
            return;

        int lvBefore = guildLevelsController.getDataManager(event.getGuild())
                .findData(event.getMember().getId())
                .getLevels();

        guildLevelsController.getDataManager(event.getGuild())
                .findData(event.getMember().getId())
                .addXP(event.getMessage().getContentRaw().length());

        int lvAfter = guildLevelsController.getDataManager(event.getGuild())
                .findData(event.getMember().getId())
                .getLevels();

        if(lvAfter!=lvBefore)
            event.getChannel().sendMessage("your lv is upgrade to "+lvAfter).queue();



    }
}
