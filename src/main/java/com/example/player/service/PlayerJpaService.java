package com.example.player.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.player.model.Player;
import com.example.player.repository.*;
import java.util.*;


@Service 
public class PlayerJpaService implements PlayerRepository{
    @Autowired
    private PlayerJpaRepository playerRepo;
    @Override
    public ArrayList<Player> getPlayer(){
    List<Player> playerList = playerRepo.findAll();
    ArrayList<Player> players= new ArrayList<>(playerList);
    return players;

    } 
    @Override
    public Player getPlayerById(int playerId){
        try{
             Player player=playerRepo.findById(playerId).get();
        return player;

        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
       
    }
    @Override
    public Player addPlayer(Player player){
        playerRepo.save(player);
        return player;

    }
    @Override
    public Player updatePlayer(int playerId, Player player){
        try{
            Player newPlayer= playerRepo.findById(playerId).get();
            if(player.getPlayerName()!=null){
                newPlayer.setPlayerName(player.getPlayerName());
            }
            if(player.getJerseyNumber()!=0){
                newPlayer.setJerseyNumber(player.getJerseyNumber());
            }
            if(player.getRole()!=null){
            newPlayer.setRole(player.getRole());
            }
            return newPlayer;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
        
    }
    public void deletePlayer(int playerId){
        try{
            playerRepo.deleteById(playerId);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    
}
