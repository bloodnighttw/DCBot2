package io.github.bloodnighttw.DiscordBot.LevelsCounter.Data;


import io.github.bloodnighttw.DiscordBot.Data.JsonDataManager;
import net.dv8tion.jda.api.entities.Guild;

import java.util.HashMap;
import java.util.Map;

public class GuildLevelsController<VALUE> {

    private final Map<Guild, LVJsonDataManager> guildIDataManagerMap = new HashMap<>();

    public LVJsonDataManager getDataManager(Guild guild){
        LVJsonDataManager iDataManager = guildIDataManagerMap.get(guild);

        if(iDataManager == null){
            iDataManager = new LVJsonDataManager(guild,600);
            iDataManager = new LVJsonDataManager(guild,600);
            guildIDataManagerMap.put(guild,iDataManager);
        }



        return iDataManager;

    }




}
