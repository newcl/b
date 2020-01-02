package info.chenliang.b.service.message.impl;

import info.chenliang.b.service.message.Address;
import lombok.Builder;

@Builder
public class AeronAddressFromChannel implements Address {

  private final String channel;
  private final int streamId;

  @Override
  public int getStreamId() {
    return streamId;
  }

  @Override
  public String getChannel() {
    return channel;
  }
}
