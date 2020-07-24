package io.github.bloodnighttw.DiscordBot.CommandInterface;

public class Description {

    private String command;
    private String commandName;
    private String howToUse;
    private String Description;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommandName() {
        return commandName;
    }

    public String getHowToUse() {
        return howToUse;
    }

    public String getDescription() {
        return Description;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public void setHowToUse(String howToUse) {
        this.howToUse = howToUse;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
