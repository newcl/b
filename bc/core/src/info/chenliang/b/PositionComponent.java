package info.chenliang.b;

import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class PositionComponent {
  @NonNull
  Vector2 position;

  @NonNull
  float rotation;


  float speed = 5.f;
  float rotationSpeed = 30.f;

  public PositionComponent(PositionComponent pos) {
    this.position = pos.position.cpy();
    this.rotation = pos.rotation;
  }
}
