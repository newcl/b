package info.chenliang.b.service.message;

import akka.actor.ActorRef;
import info.chenliang.b.generated.message.MessageWrapper;
import lombok.Builder;

@Builder
public class ActorMessage {
  MessageWrapper messageWrapper;
  ActorRef actorRef;
}
