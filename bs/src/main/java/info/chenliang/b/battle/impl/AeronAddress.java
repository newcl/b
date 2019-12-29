package info.chenliang.b.battle.impl;

import info.chenliang.b.message.Address;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AeronAddress implements Address {
    private final String ip;
    private final int port;
    private final int streamId;
}
