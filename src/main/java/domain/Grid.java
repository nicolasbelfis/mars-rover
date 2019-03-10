package domain;

import java.util.List;

public class Grid {

  private final List<PositionableObject> obstacles;

  private final int xMax;

  private final int yMax;

  public Grid(List<PositionableObject> obstacles, int xMax, int yMax) {
    this.obstacles = obstacles;
    this.xMax = xMax;
    this.yMax = yMax;
  }

  public int getxMax() {
    return this.xMax;
  }

  public int getyMax() {
    return this.yMax;
  }

  public List<PositionableObject> getObstacles() {
    return this.obstacles;
  }
}
