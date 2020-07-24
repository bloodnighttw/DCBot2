package io.github.bloodnighttw.DiscordBot.CommandInterface;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

public interface ICommand {

    public String getCommand();
    public Description getDescription();
    public void onCommand(String[] args, Guild guild, TextChannel textChannel, Member member);

    public default String[] getAlternative(){
        return null;
    }

}
