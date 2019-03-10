package command;

import domain.Direction;
import domain.Rover;
import handler.RoverHandler;

public class CommandLeft implements Command {
  private final RoverHandler receiver;

  public CommandLeft(RoverHandler roverHandler) {
    receiver = roverHandler;
  }

  @Override
  public Rover execute(Rover rover) {
    final Direction direction = rover.getDirection();
    return receiver.turn(rover, direction::moveLeft);
  }
}
