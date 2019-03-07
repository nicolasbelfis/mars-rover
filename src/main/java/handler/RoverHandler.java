package handler;

import domain.Grid;
import domain.Position;
import domain.Rover;

import java.util.Optional;

public class RoverHandler {

  private final Grid grid;

  public RoverHandler(Grid grid) {
    this.grid = grid;
  }

  boolean detectCollision(Position position) {
    return Optional.ofNullable(getGrid())
      .flatMap(
        grid1 -> grid1.getObstacles().stream()
          .filter(positionableObject -> positionableObject.getPosition().equals(position))
          .findFirst()
      ).map(positionableObject -> true)
      .orElse(false);
  }

  public Grid getGrid() {
    return this.grid;
  }

  public Rover move(Rover rover, PostionCalcultor postionCalcultor) {
    final Position newPosition = postionCalcultor.handle(rover.getPosition(), grid);
    if (detectCollision(newPosition)) throw new ObstacleEncounteredException(newPosition);
    return new Rover(rover.getDirection(), newPosition, false);
  }

  public Rover turn(Rover rover) {
    return null;
  }
}
