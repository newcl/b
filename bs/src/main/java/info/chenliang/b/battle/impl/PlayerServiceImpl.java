package info.chenliang.b.battle.impl;

import info.chenliang.b.battle.Player;
import info.chenliang.b.battle.PlayerService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class PlayerServiceImpl implements PlayerService {
    private Map<String, Player> players = new HashMap<>();

    @Override
    public Player getPlayer(String id) {
        Player player = players.get(id);
        if (player == null) {
            player = PlayerImpl.builder().id(id).build();
            players.put(id, player);
        }
        return player;
    }

    @PostConstruct
    public void init() {

    }
}
