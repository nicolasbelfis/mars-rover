package command;

import domain.Direction;
import domain.Rover;
import handler.RoverHandler;

public class CommandRight implements Command {
  private final RoverHandler receiver;

  public CommandRight(RoverHandler roverHandler) {
    this.receiver = roverHandler;
  }

  @Override
  public Rover execute(Rover rover) {
    if (rover.getDirection().equals(Direction.NORTH))
      return receiver.turn(rover, direction -> Direction.EAST);
    if (rover.getDirection().equals(Direction.SOUTH))
      return receiver.turn(rover, direction -> Direction.WEST);
    if (rover.getDirection().equals(Direction.EAST))
      return receiver.turn(rover, direction -> Direction.SOUTH);
    if (rover.getDirection().equals(Direction.WEST))
      return receiver.turn(rover, direction -> Direction.NORTH);
    throw new IllegalStateException("");
  }
}