package command;

import domain.Direction;
import domain.Rover;
import handler.RoverHandler;

public class CommandBackward implements Command {

  private final RoverHandler receiver;

  public CommandBackward(RoverHandler receiver) {
    this.receiver = receiver;
  }

  public Rover execute(Rover rover) {
    final Direction direction = rover.getDirection();
    return receiver.move(rover, direction::moveBackward);
  }
}
