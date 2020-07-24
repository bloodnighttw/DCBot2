package io.github.bloodnighttw.DiscordBot.LevelsCounter.Data;

import io.github.bloodnighttw.DiscordBot.Data.JsonDataManager;
import net.dv8tion.jda.api.entities.Guild;

public class LVJsonDataManager extends JsonDataManager<LevelsContainer> {
    public LVJsonDataManager(Guild guild, long timeToSave) {
        super(guild, timeToSave);
    }

    @Override
    public LevelsContainer findData(String fileName) {
        //file name == playerID
        LevelsContainer lvc = super.findData(fileName);
        if(lvc == null) {
            super.dataSave(fileName, new LevelsContainer(Long.parseLong(fileName)));
            lvc = super.findData(fileName);
        }


        return lvc;
    }
}
