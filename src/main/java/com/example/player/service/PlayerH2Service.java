package com.example.player.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.player.repository.PlayerRepository;
import java.util.*;
import com.example.player.model.PlayerRowMapper;
import com.example.player.model.Player;
@Service
public class PlayerH2Service implements PlayerRepository{
    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Player> getPlayer(){
        List<Player> playerList =db.query("select * from team", new PlayerRowMapper());
        ArrayList<Player> player = new ArrayList<>(playerList);
        return player;
    }
    @Override
    public Player getPlayerById(int playerId){
        Player byid= db.queryForObject("select * from team where playerId=?", new PlayerRowMapper(), playerId);
        return byid;

    }
@Override
public Player addPlayer(Player player){
    db.update("insert into team(playerName, jerseyNumber, role) values(?,?,?)", new PlayerRowMapper(), player.getPlayerName(), player.getJerseyNumber, player.getRole());
    Player addedplayer=db.queryForObject("select * from team where playerName=?, jerseyNumber=? and role=?", new PlayerRowMapper(), player.getPlayerName(), player.getJerseyNumber(), player.getRole());
    return addedplayer;

}
    
 @Override
 public Player updatePlayer(int playerId, Player player){
    if(player.getPlayerName()!= null){
        db.update("update team set playerName=? where playerId=?", player.getPlayerName(), playerId);
    }
    if(player.getJerseyNumber()!= 0){
        db.update("update team set jerseyNumber=? where palyerId=?", player.getJerseyNumber(), playerId);
    }
    if(player.getRole()!= null){
        db.update("update team set role=? where playerId=?", player.getRole(), playerId);

    }
    return getPlayerById(playerId);
 } 
 @Override
 public void deletePlayer(int playerId){
    db.update("delete from team where playerId=?", playerId);
 }  

}