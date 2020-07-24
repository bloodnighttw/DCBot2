package io.github.bloodnighttw.DiscordBot.Data;

public interface IDataManager<ID,Value> {
    // T -> id
    public void dataSave(ID id,Value value);
    public Value findData(ID id);

}
