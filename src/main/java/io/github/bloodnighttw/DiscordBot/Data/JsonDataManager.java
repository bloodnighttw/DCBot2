package io.github.bloodnighttw.DiscordBot.Data;

import io.github.bloodnighttw.DiscordBot.Tools;
import net.dv8tion.jda.api.entities.Guild;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class JsonDataManager<Value> implements IDataManager<String,Value> {

    private Map<String,Value> map = new HashMap<>();

    /*  TODO-LIST
     *  1. ADD Save Schedule
     *  2. Implement DataWriteNow
     *
     */


    public JsonDataManager(Guild guild,long timeToSave) {
        char system = Tools.getDictonarySeparator();
        String workingDict = Tools.getWorkingDirectory()+system+"data"+system+guild.getId();

        File file = new File(workingDict);
        if(!file.exists() || !file.isDirectory()){
            file.mkdir();
        }

    }

    @Override
    public void dataSave(String fileName, Value value) {
        map.put(fileName,value);
    }

    @Override
    public Value findData(String fileName) {
        return map.get(fileName);
    }

    @Override
    protected void finalize() throws Throwable {
        dataWriteNow();
    }

    //Save Map to Json file when call this method.
    public void dataWriteNow(){

    }

    private String getWorkingDictonary(){
        return System.getProperty("user.dir");
    }

}
