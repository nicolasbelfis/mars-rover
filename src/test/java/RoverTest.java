import command.CommandBackward;
import command.CommandForward;
import command.CommandLeft;
import command.CommandRight;
import domain.*;
import handler.ObstacleEncounteredException;
import handler.RoverHandler;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class RoverTest {

  RoverHandler roverHandler = new RoverHandler(null);
  CommandForward commandForward = new CommandForward(roverHandler);
  CommandBackward commandBackward = new CommandBackward(roverHandler);
  CommandLeft commandLeft = new CommandLeft(roverHandler);
  CommandRight commandRight = new CommandRight(roverHandler);

  @Test
  public void should_move_up_y_coordinates_on_forward() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    rover = commandForward.execute(rover);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_move_down_y_coordinates_on_forward() {
    Rover rover = new Rover(Direction.SOUTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 0);
    rover = commandForward.execute(rover);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_move_up_x_coordinates_on_forward() {
    Rover rover = new Rover(Direction.EAST, new Position(1, 1), false);
    Position expectedPosition = new Position(2, 1);
    rover = commandForward.execute(rover);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_move_down_x_coordinates_on_forward() {
    Rover rover = new Rover(Direction.WEST, new Position(1, 1), false);
    Position expectedPosition = new Position(0, 1);
    rover = commandForward.execute(rover);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_move_up_y_coordinates_on_backward() {
    Rover rover = new Rover(Direction.SOUTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    rover = commandBackward.execute(rover);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_move_down_y_coordinates_on_backward() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 0);
    rover = commandBackward.execute(rover);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_move_up_x_coordinates_on_backward() {
    Rover rover = new Rover(Direction.WEST, new Position(1, 1), false);
    Position expectedPosition = new Position(2, 1);
    rover = commandBackward.execute(rover);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_move_down_x_coordinates_on_backward() {
    Rover rover = new Rover(Direction.EAST, new Position(1, 1), false);
    Position expectedPosition = new Position(0, 1);
    rover = commandBackward.execute(rover);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_turn_east_on_right() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    final Rover rover1 = commandRight.execute(rover);
    assertEquals(Direction.EAST, rover1.getDirection());
  }

  @Test
  public void should_turn_south_on_right() {
    Rover rover = new Rover(Direction.EAST, new Position(1, 1), false);
    final Rover rover1 = commandRight.execute(rover);
    assertEquals(Direction.SOUTH, rover1.getDirection());
  }

  @Test
  public void should_turn_west_on_right() {
    Rover rover = new Rover(Direction.SOUTH, new Position(1, 1), false);
    final Rover rover1 = commandRight.execute(rover);
    assertEquals(Direction.WEST, rover1.getDirection());
  }

  @Test
  public void should_turn_north_on_right() {
    Rover rover = new Rover(Direction.WEST, new Position(1, 1), false);
    final Rover rover1 = commandRight.execute(rover);
    assertEquals(Direction.NORTH, rover1.getDirection());
  }

  @Test
  public void should_turn_west_on_left() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    final Rover rover1 = commandLeft.execute(rover);
    assertEquals(Direction.WEST, rover1.getDirection());
  }

  @Test
  public void should_turn_south_on_left() {
    Rover rover = new Rover(Direction.WEST, new Position(1, 1), false);
    final Rover rover1 = commandLeft.execute(rover);
    assertEquals(Direction.SOUTH, rover1.getDirection());
  }

  @Test
  public void should_turn_east_on_left() {
    Rover rover = new Rover(Direction.SOUTH, new Position(1, 1), false);
    final Rover rover1 = commandLeft.execute(rover);
    assertEquals(Direction.EAST, rover1.getDirection());
  }

  @Test
  public void should_turn_north_on_left() {
    Rover rover = new Rover(Direction.EAST, new Position(1, 1), false);
    final Rover rover1 = commandLeft.execute(rover);
    assertEquals(Direction.NORTH, rover1.getDirection());
  }

  @Test(expected = ObstacleEncounteredException.class)
  public void should_detect_obstacle() {
    final Grid grid = new Grid(Collections.singletonList(new Obstacle(new Position(1, 2))));
    final RoverHandler receiver = new RoverHandler(grid);
    new CommandForward(receiver).execute(new Rover(Direction.NORTH, new Position(1, 1), false));
  }
}
