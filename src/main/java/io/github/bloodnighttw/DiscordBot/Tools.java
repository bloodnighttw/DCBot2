package io.github.bloodnighttw.DiscordBot;

public class Tools {

    public static char getDictonarySeparator(){

        char system;
        system = '/';
        //windows 'c:\\xxxxxx\xxxxx' or posix '/home/xxxxxxx/xxxxx'
        if(System.getProperty("os.name").equals("Windows")) {
            system = '\\';
        }

        return system;
    }

    public static String getWorkingDirectory(){
        return System.getProperty("user.dir");
    }


}
