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

    final Direction direction = rover.getDirection();
    return receiver.turn(rover, direction::moveRight);

  }
}
