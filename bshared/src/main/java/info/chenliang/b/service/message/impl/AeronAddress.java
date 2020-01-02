package info.chenliang.b.service.message.impl;

import info.chenliang.b.service.message.Address;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AeronAddress implements Address {
    private final String ip;
    private final int port;
    private final int streamId;

    @Override
    public String getChannel() {
        return String.format("aeron:udp?endpoint=%s:%s", ip, port);
    }
}
