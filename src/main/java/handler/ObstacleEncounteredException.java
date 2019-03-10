package handler;

import domain.Position;

public class ObstacleEncounteredException extends RuntimeException {
  private final Position position;

  public ObstacleEncounteredException(Position position) {
    this.position = position;
  }

  public Position getPosition() {
    return this.position;
  }
}
