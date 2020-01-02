package info.chenliang.b.battle;

import info.chenliang.b.service.message.Address;

public interface Player {
    String getId();

    Address getSubscriptionAddress();
    void setSubscriptionAddress(Address address);
}
