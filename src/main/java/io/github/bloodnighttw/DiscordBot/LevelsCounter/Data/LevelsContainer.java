package io.github.bloodnighttw.DiscordBot.LevelsCounter.Data;

public class LevelsContainer {

    private final long playerID;
    private long surplusXP;
    private int levels;

    public LevelsContainer(long playerID) {

        this.playerID = playerID;
        this.levels = 0;
    }

    public void addXP(long xp){
        surplusXP += xp;
        toLevels();
    }

    public void toLevels(){

        long upgradeLv = (levels+10)*(levels+10);

        while (surplusXP >= upgradeLv){
            surplusXP -= upgradeLv ;
            levels++ ;
            upgradeLv = (levels+4)*(levels+5);
        }
    }

    public void setLevels(int levels) {
        this.levels = levels;
        surplusXP = 0;
    }

    public void setSurplusXP(long surplusXP) {
        levels = 0 ;
        this.surplusXP = surplusXP;
        toLevels();
    }

    public long getPlayerID() {
        return playerID;
    }

    public long getSurplusXP() {
        return surplusXP;
    }

    public int getLevels() {
        return levels;
    }
}
