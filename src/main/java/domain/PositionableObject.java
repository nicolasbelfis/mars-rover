package domain;

public class PositionableObject {
  private final Position position;

  protected PositionableObject(Position position) {
    this.position = position;
  }

  public Position getPosition() {
    return this.position;
  }
}
