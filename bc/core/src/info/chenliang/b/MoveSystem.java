package info.chenliang.b;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;

public class MoveSystem {
    public void move(PositionComponent source, PositionComponent target) {
        Vector2 direction = target.getPosition().cpy().sub(source.getPosition());
        if (direction.len() <= 5) {
            source.getPosition().set(target.getPosition());
            return;
        }

//        Vector2 normal = direction.cpy().nor();

        float alpha = source.speed / direction.len();
//
//        source.getPosition().add(normal.scl(Interpolation.linear.apply(0, direction.len(), alpha)));

        source.getPosition().interpolate(target.getPosition(), alpha, Interpolation.linear);
    }
}
