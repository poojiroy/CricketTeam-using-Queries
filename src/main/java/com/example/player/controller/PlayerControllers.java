
 package com.example.player.controller;
 import org.springframework.web.bind.annotation.*;
 import org.springframework.beans.factory.annotation.Autowired;
 
import com.example.player.model.Player;
import com.example.player.service.PlayerJpaService;
//import com.example.player.service.PlayerH2Service;
//import com.example.player.repository.*;
import java.util.*;
 @RestController
 public class PlayerController{
    @Autowired
    //public PlayerH2Service playerService;
    public PlayerJpaService playerService;

    @GetMapping("/player")
     public ArrayList<Player> getPlayer(){
        return playerService.getPlayer();
      

     }
     @GetMapping("/player/playerId")
     
      public Player getPlayerById(@PathVariable("playerId") int playerId){
         return playerService.getPlayerById(playerId);

      }
      @PostMapping("player")
      public Player addPlayer(@RequestBody Player player){
         return playerService.addPlayer(player);
      }
      @PutMapping("player/playerId")
      public Player updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player player){
         return playerService.updatePlayer(playerId, player);
      }
      
@DeleteMapping("player/playerId")
public void deletePlayer(@PathVariable("playerId") int playerId){
   playerService.deletePlayer(playerId);
}
    
 }

