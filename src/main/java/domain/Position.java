package domain;

public class Position {

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  private final int x;
  private final int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
