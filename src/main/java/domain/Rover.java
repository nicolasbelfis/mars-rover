package domain;

import java.util.Optional;

public class Rover extends PositionableObject {

  private final Direction direction;
  private final boolean blocked;

  public Rover(Direction direction, Position position, boolean blocked) {
    super(position);
    this.direction = direction;
    this.blocked = blocked;
  }

  public boolean isBlocked() {
    return this.blocked;
  }

  public Direction getDirection() {
    return this.direction;
  }

}
