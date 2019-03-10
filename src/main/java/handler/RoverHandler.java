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

  public Rover turn(Rover rover, DirectionCalculator directionCalculator) {
    return new Rover(directionCalculator.handle(rover.getDirection()), rover.getPosition(), false);
  }

  public static Position moveUp(Position position, Grid grid) {
    return new Position(position.getX(), (position.getY() + 1) % grid.getyMax());
  }

  public static Position moveDown(Position position, Grid grid) {
    return new Position(position.getX(), Math.floorMod(position.getY() - 1, grid.getyMax()));
  }

  public static Position moveEast(Position position, Grid grid) {
    return new Position((position.getX() + 1) % grid.getxMax(), position.getY());
  }

  public static Position moveWest(Position position, Grid grid) {
    return new Position(Math.floorMod(position.getX() - 1, grid.getxMax()), position.getY());
  }

}
