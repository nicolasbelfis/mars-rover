package invoker;

import domain.Obstacle;
import domain.Rover;

import java.util.Optional;

public class InvokerResult {
  private final Rover rover;
  private final Optional<Obstacle> obstacle;

  public InvokerResult(Rover rover, Optional<Obstacle> obstacle) {
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
