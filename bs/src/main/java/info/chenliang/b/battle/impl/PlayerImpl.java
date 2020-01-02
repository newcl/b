package info.chenliang.b.battle.impl;

import info.chenliang.b.battle.Player;
import info.chenliang.b.service.message.Address;
import io.aeron.Publication;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class PlayerImpl implements Player {
    @Getter
    private final String id;

    public PlayerImpl(String id) {
        this.id = id;
    }

    @Getter
    @Setter
    private Publication publication;

    @Getter
    @Setter
    private Address subscriptionAddress;

    @Builder
    public static Player build(String id) {
        return new PlayerImpl(id);
    }


}
