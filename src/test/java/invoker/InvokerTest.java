package invoker;

import command.CommandForward;
import domain.*;
import handler.ObstacleEncounteredException;
import handler.RoverHandler;
import invoker.Invoker;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class InvokerTest {

  private final Grid grid = new Grid(Collections.emptyList());
  private final RoverHandler receiver = new RoverHandler(grid);

  @Test(expected = ObstacleEncounteredException.class)
  public void should_lead_to_obstacle() {
    CommandForward commandForward = new CommandForward(receiver);
    Invoker.applyCommands(Arrays.asList(commandForward), new Rover(Direction.NORTH, new Position(1, 2), false));
  }

  @Test
  public void should_retrieve_obstacle_position() {
    CommandForward commandForward = new CommandForward(receiver);
    Position expectedPosition = new Position(1, 3);
    Position actualPosition = new Position(1, 2);
    try {
      Invoker.applyCommands(Arrays.asList(commandForward), new Rover(Direction.NORTH, actualPosition, false));
    } catch (ObstacleEncounteredException e) {
      actualPosition = e.getPosition();
    }
    assertEquals(expectedPosition, actualPosition);
  }

  @Test
  public void should_retrieve_new_rover_position() {
    CommandForward commandForward = new CommandForward(receiver);
    final PositionableObject positionableObject = Invoker.applyCommands(Arrays.asList(commandForward), new Rover(Direction.NORTH, new Position(1, 1), false));
    Position expectedPostion = new Position(1, 2);
    assertEquals(expectedPostion, positionableObject.getPosition());
  }
}
