package domain;

import java.util.List;

public class Grid {

  private final List<PositionableObject> obstacles;

  public Grid(List<PositionableObject> obstacles) {
    this.obstacles = obstacles;
  }

  public List<PositionableObject> getObstacles() {
    return this.obstacles;
  }
}
