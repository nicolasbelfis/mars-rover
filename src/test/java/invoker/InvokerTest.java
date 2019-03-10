package invoker;

import command.CommandBackward;
import command.CommandForward;
import command.CommandLeft;
import command.CommandRight;
import domain.*;
import handler.RoverHandler;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class InvokerTest {

  private final Grid grid = new Grid(Arrays.asList(new Obstacle(new Position(2, 2)), new Obstacle(new Position(4, 4))), 10, 10);
  private final RoverHandler receiver = new RoverHandler(grid);

  @Test()
  public void should_lead_to_obstacle() {
    CommandForward commandForward = new CommandForward(receiver);
    CommandRight commandRight = new CommandRight(receiver);
    CommandForward commandForward2 = new CommandForward(receiver);
    final InvokerResult invokerResult = Invoker.applyCommands(Arrays.asList(commandForward, commandRight, commandForward2), new Rover(Direction.NORTH, new Position(1, 1), false));
    assertEquals(true, invokerResult.getObstacle().isPresent());
  }

  @Test
  public void should_retrieve_obstacle_position() throws Exception {
    CommandForward commandForward = new CommandForward(receiver);
    CommandRight commandRight = new CommandRight(receiver);
    CommandForward commandForward2 = new CommandForward(receiver);
    Position obstaclePosition = Invoker.applyCommands(Arrays.asList(commandForward, commandRight, commandForward2), new Rover(Direction.NORTH, new Position(1, 1), false))
      .getObstacle().map(PositionableObject::getPosition)
      .orElseThrow(Exception::new);
    assertEquals(new Position(2, 2), obstaclePosition);
  }

  @Test
  public void should_retrieve_new_rover_position() {
    CommandForward commandForward = new CommandForward(receiver);
    CommandRight commandRight = new CommandRight(receiver);
    CommandForward commandForward2 = new CommandForward(receiver);
    Position actualPosition = Invoker
      .applyCommands(Arrays.asList(commandForward, commandRight, commandForward2), new Rover(Direction.NORTH, new Position(1, 1), false))
      .getRover()
      .getPosition();

    Position expectedPostion = new Position(1, 2);
    assertEquals(expectedPostion, actualPosition);
  }

  @Test
  public void should_restart_from_new_position() {
    CommandForward commandForward = new CommandForward(receiver);
    CommandRight commandRight = new CommandRight(receiver);
    CommandForward commandForward2 = new CommandForward(receiver);
    final Rover rover = Invoker
      .applyCommands(Arrays.asList(commandForward, commandRight, commandForward2), new Rover(Direction.NORTH, new Position(1, 1), false))
      .getRover();

    CommandLeft commandLeft = new CommandLeft(receiver);
    CommandForward commandForward3 = new CommandForward(receiver);
    CommandBackward commandBackward = new CommandBackward(receiver);
    Rover actualRover = Invoker
      .applyCommands(Arrays.asList(commandLeft, commandForward3, commandBackward), rover)
      .getRover();
    Position expectedPostion = new Position(1, 2);
    Direction expectedDirection = Direction.NORTH;
    assertEquals(expectedPostion, actualRover.getPosition());
    assertEquals(expectedDirection, actualRover.getDirection());
  }
}
