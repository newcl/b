package info.chenliang.b.service.message;


import akka.actor.typed.ActorRef;
import info.chenliang.b.generated.message.MessageWrapper;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ActorMessage {
  MessageWrapper messageWrapper;
  ActorRef actorRef;
}
