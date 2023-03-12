package com.example.player.repository;

import com.example.player.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlayerJpaRepository extends JpaRepository<Player, Integer>{

}
