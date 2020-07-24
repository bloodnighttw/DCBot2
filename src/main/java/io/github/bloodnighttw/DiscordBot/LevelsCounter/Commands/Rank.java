package io.github.bloodnighttw.DiscordBot.LevelsCounter.Commands;

import io.github.bloodnighttw.DiscordBot.CommandInterface.Description;
import io.github.bloodnighttw.DiscordBot.CommandInterface.ICommand;
import io.github.bloodnighttw.DiscordBot.LevelsCounter.Data.GuildLevelsController;
import io.github.bloodnighttw.DiscordBot.LevelsCounter.LevelsCounterLoader;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

public class Rank implements ICommand {

    GuildLevelsController<LevelsCounterLoader> guildLevelsController = LevelsCounterLoader.getGuildLevelsControllerINSTANCE();

    @Override
    public String getCommand() {
        return "!rank";
    }

    @Override
    public Description getDescription() {
        Description description = new Description();
        description.setDescription("A Rank Command");
        description.setCommand("!rank");
        description.setCommandName("Rank Command");

        return description;
    }

    @Override
    public void onCommand(String[] args, Guild guild, TextChannel textChannel, Member member) {
        int lv = guildLevelsController.getDataManager(guild)
                .findData(member.getId())
                .getLevels();
        long xp = guildLevelsController.getDataManager(guild)
                .findData(member.getId())
                .getSurplusXP();

        textChannel.sendMessage("Your Lv:"+lv+"\nYour XP:"+ xp+"\nYou need "+((lv+10)*(lv+10)-xp)+" XP to upgrade your lv").queue();

    }
}
