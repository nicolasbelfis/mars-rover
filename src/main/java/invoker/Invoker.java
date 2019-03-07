package invoker;

import command.Command;
import domain.PositionableObject;
import domain.Rover;

import java.util.List;

public class Invoker {

  public static PositionableObject applyCommands(List<Command> commands, Rover rover) {
    for (Command command : commands) {
      rover = command.execute(rover);
    }
    return rover;
  }
}
