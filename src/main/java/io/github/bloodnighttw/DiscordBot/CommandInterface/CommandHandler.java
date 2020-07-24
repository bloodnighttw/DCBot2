package io.github.bloodnighttw.DiscordBot.CommandInterface;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class CommandHandler extends ListenerAdapter {

    private Map<String,ICommand> commandMap = new HashMap<String, ICommand>();
    private static CommandHandler INSTANCE = new CommandHandler();

    private CommandHandler(){};

    public static CommandHandler getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if(event.getAuthor().isBot())
            return;

        String[] args = event.getMessage().getContentRaw().split(" ");
        ICommand command = commandMap.get(args[0]);

        if(command == null)
            return;

        if(args.length == 1){
            command.onCommand(new String[]{},
                    event.getGuild(),
                    event.getChannel(),
                    event.getMember());
        }else
            command.onCommand(Arrays.copyOfRange(args,1,args.length),event.getGuild(),event.getChannel(),event.getMember());
    }

    public void addCommand(ICommand command){
        commandMap.put(command.getCommand(),command);
    }

    public void removeCommand(ICommand command){
        commandMap.put(command.getCommand(),null);
    }
}
