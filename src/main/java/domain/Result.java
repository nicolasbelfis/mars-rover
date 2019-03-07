package domain;

import java.util.Optional;

public class Result {

  private final Rover rover;
  private final Optional<Obstacle> obstacle;

  public Result(Rover rover, Optional<Obstacle> obstacle) {
    this.rover = rover;
    this.obstacle = obstacle;
  }

  public Rover getRover() {
    return this.rover;
  }

  public Optional<Obstacle> getObstacle() {
    return this.obstacle;
  }
}
