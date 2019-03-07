package command;

import domain.Direction;
import domain.Position;
import domain.Rover;
import handler.RoverHandler;

public class CommandBackward implements Command {

  private final RoverHandler receiver;

  public CommandBackward(RoverHandler receiver) {
    this.receiver = receiver;
  }

  public Rover execute(Rover rover) {
    if(rover.getDirection().equals(Direction.NORTH))
      return receiver.move(rover,(position, grid) -> new Position(position.getX(),position.getY()+1));
    if(rover.getDirection().equals(Direction.SOUTH))
      return receiver.move(rover,(position, grid) -> new Position(position.getX(),position.getY()-1));

    throw new IllegalStateException("");
  }
}
