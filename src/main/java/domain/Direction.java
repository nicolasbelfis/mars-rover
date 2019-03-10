package domain;

import handler.RoverHandler;

public enum Direction {

  NORTH {
    @Override
    public Position moveForward(Position position, Grid grid) {
      return RoverHandler.moveUp(position, grid);
    }

    @Override
    public Position moveBackward(Position position, Grid grid) {
      return RoverHandler.moveDown(position, grid);
    }

    @Override
    public Direction moveLeft() {
      return Direction.WEST;
    }

    @Override
    public Direction moveRight() {
      return Direction.EAST;
    }
  },
  WEST {
    @Override
    public Position moveForward(Position position, Grid grid) {
      return RoverHandler.moveWest(position, grid);
    }

    @Override
    public Position moveBackward(Position position, Grid grid) {
      return RoverHandler.moveEast(position, grid);
    }

    @Override
    public Direction moveLeft() {
      return Direction.SOUTH;
    }

    @Override
    public Direction moveRight() {
      return Direction.NORTH;
    }
  },
  SOUTH {
    @Override
    public Position moveForward(Position position, Grid grid) {
      return RoverHandler.moveDown(position, grid);
    }

    @Override
    public Position moveBackward(Position position, Grid grid) {
      return RoverHandler.moveUp(position, grid);
    }

    @Override
    public Direction moveLeft() {
      return Direction.EAST;
    }

    @Override
    public Direction moveRight() {
      return Direction.WEST;
    }
  },
  EAST {
    @Override
    public Position moveForward(Position position, Grid grid) {
      return RoverHandler.moveEast(position, grid);
    }

    @Override
    public Position moveBackward(Position position, Grid grid) {
      return RoverHandler.moveWest(position, grid);
    }

    @Override
    public Direction moveLeft() {
      return Direction.NORTH;
    }

    @Override
    public Direction moveRight() {
      return Direction.SOUTH;
    }
  };

  public abstract Position moveForward(Position position, Grid grid);

  public abstract Position moveBackward(Position position, Grid grid);

  public abstract Direction moveLeft();

  public abstract Direction moveRight();
}
