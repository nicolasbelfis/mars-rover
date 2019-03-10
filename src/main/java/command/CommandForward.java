package command;

import domain.Direction;
import domain.Position;
import domain.Rover;
import handler.RoverHandler;

public class CommandForward implements Command {

  private final RoverHandler receiver;

  public CommandForward(RoverHandler receiver) {
    this.receiver = receiver;
  }

  public Rover execute(Rover rover) {
    if (rover.getDirection().equals(Direction.NORTH))
      return receiver.move(rover, RoverHandler::moveUp);
    if (rover.getDirection().equals(Direction.SOUTH))
      return receiver.move(rover, RoverHandler::moveDown);
    if (rover.getDirection().equals(Direction.EAST))
      return receiver.move(rover, RoverHandler::moveEast);
    if (rover.getDirection().equals(Direction.WEST))
      return receiver.move(rover, RoverHandler::moveWest);
    throw new IllegalStateException("");
  }
}
