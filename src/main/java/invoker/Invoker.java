package invoker;

import command.Command;
import domain.Obstacle;
import domain.Rover;
import handler.ObstacleEncounteredException;

import java.util.List;
import java.util.Optional;

public class Invoker {

  public static InvokerResult applyCommands(List<Command> commands, Rover rover) {
    for (Command command : commands) {
      try {
        rover = command.execute(rover);
      } catch (ObstacleEncounteredException ex) {
        return new InvokerResult(rover, java.util.Optional.of(new Obstacle(ex.getPosition())));
      }

    }
    return new InvokerResult(rover, Optional.empty());
  }
}
