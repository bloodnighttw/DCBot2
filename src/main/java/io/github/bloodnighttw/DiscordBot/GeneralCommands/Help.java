package io.github.bloodnighttw.DiscordBot.GeneralCommands;

import io.github.bloodnighttw.DiscordBot.CommandInterface.Description;
import io.github.bloodnighttw.DiscordBot.CommandInterface.ICommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

public class Help implements ICommand {
    @Override
    public String getCommand() {
        return "!help";
    }

    @Override
    public Description getDescription() {
        Description description = new Description();
        description.setCommand("!help");
        description.setCommandName("Help Command");
        description.setDescription("A Help Command");
        return description;
    }

    @Override
    public void onCommand(String[] args, Guild guild, TextChannel channel, Member member) {
        channel.sendMessage("This Function Hasn't Done!").queue();
    }
}
