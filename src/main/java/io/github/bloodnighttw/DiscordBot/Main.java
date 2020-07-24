package io.github.bloodnighttw.DiscordBot;

import com.google.gson.Gson;
import io.github.bloodnighttw.DiscordBot.CommandInterface.CommandHandler;
import io.github.bloodnighttw.DiscordBot.GeneralCommands.Help;
import io.github.bloodnighttw.DiscordBot.GeneralCommands.Ping;
import io.github.bloodnighttw.DiscordBot.LevelsCounter.LevelsCounterLoader;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.io.*;
import java.util.Scanner;

import static io.github.bloodnighttw.DiscordBot.Tools.getWorkingDirectory;

public class Main {

    private static JDA jda;
    
    public static void main(String[] args) throws LoginException {
        Configs configs = getConfig();
        jda = JDABuilder.createDefault(configs.getToken()).build();
        addListener();
        addCommand();
        LevelsCounterLoader.load();
    }

    public static JDA getJda() {
        return jda;
    }

    private static Configs getConfig(){
        Gson gson = new Gson();
        char system = Tools.getDictonarySeparator();

        Configs configs = null;
        File configsFile = new File(getWorkingDirectory()+system+"configs.json");

        System.out.println(configsFile.toPath());

        try {
            FileReader fileReader = new FileReader(configsFile);
            configs = gson.fromJson(readFile(fileReader),Configs.class);
        }catch (IOException e) {

            try {
                System.out.println("Please Add Bot Token in \'configs.json\'");
                configsFile.createNewFile();
                FileWriter fileWriter = new FileWriter(configsFile);
                fileWriter.write(gson.toJson(new Configs("replace your token here")));
                fileWriter.close();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            System.exit(0);
        }

        return configs;
    }

    private static String readFile(FileReader fileReader){
        Scanner sc = new Scanner(fileReader);
        StringBuffer stringBuffer = new StringBuffer(100);
        while (sc.hasNextLine()){
            stringBuffer.append(sc.nextLine()).append("\n");
        }

        sc.close();
        return stringBuffer.toString();
    }



    private static void addListener(){
        jda.addEventListener(CommandHandler.getINSTANCE());
    }

    private static void addCommand(){
        CommandHandler instance = CommandHandler.getINSTANCE();
        instance.addCommand(new Ping());
        instance.addCommand(new Help());
    }

}
