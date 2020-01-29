package info.chenliang.b;

import com.badlogic.gdx.math.Vector2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PositionComponent {
  Vector2 position;
  float rotation;

  public PositionComponent(PositionComponent pos) {
    this.position = pos.position.cpy();
    this.rotation = pos.rotation;
  }
}
