package javalab11.lab;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ServicesController
{
     @Autowired
     private PlayersRepository playersRepository;

     private final AtomicInteger gameCounter = new AtomicInteger();
     private final AtomicInteger playerCounter = new AtomicInteger();

    @PostMapping("/insertPlayer")
     public @ResponseBody String insertPlayer(@RequestParam String name)
     {
         Players newPlayer = new Players();
         newPlayer.setName(name);
         newPlayer.setGameId(gameCounter.get());
         newPlayer.setId(playerCounter.incrementAndGet());
         playersRepository.save(newPlayer);
         return "Succes";
     }

     @PutMapping("/modifyName")
     public @ResponseBody String modifyName(@RequestParam int id, @RequestParam String name)
     {
         Players newPlayer = new Players();
         newPlayer = playersRepository.findById(id).get();
         newPlayer.setName(name);
         playersRepository.save(newPlayer);
         return "Succes";
     }

     @DeleteMapping("/deletePlayer")
     public @ResponseBody String deletePlayer(@RequestParam int id)
     {
         Players player = new Players();
         player = playersRepository.findById(id).get();
         playersRepository.delete(player);
         return "Deleted";
     }

     @GetMapping("/listPlayers")
     public List<Players> getAllPlayers()
     {
         List<Players> playersList = Lists.newArrayList(playersRepository.findAll());
         return playersList;
     }

}
