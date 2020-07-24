package io.github.bloodnighttw.DiscordBot.GeneralCommands;

import io.github.bloodnighttw.DiscordBot.CommandInterface.Description;
import io.github.bloodnighttw.DiscordBot.CommandInterface.ICommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

public class Ping implements ICommand {
    @Override
    public String getCommand() {
        return "!ping";
    }

    @Override
    public Description getDescription() {

        Description description = new Description();
        description.setCommandName("Ping Pong");
        description.setCommand("!ping");
        description.setCommand("A Ping Pong Test");

        return description;
    }

    @Override
    public void onCommand(String[] args, Guild guild, TextChannel textChannel, Member member) {
        textChannel.sendMessage("Pong!").queue();
    }
}
