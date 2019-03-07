import domain.*;
import handler.ObstacleEncounteredException;
import handler.RoverHandler;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class RoverTest {

  @Test
  public void should_move_up_y_coordinates_on_forward() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    rover = roverHandler.move(rover, (position, grid) -> position);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_move_down_y_coordinates_on_forward() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    rover = roverHandler.move(rover, (position, grid) -> position);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_move_down_x_coordinates_on_forward() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    rover = roverHandler.move(rover, (position, grid) -> position);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_move_up_x_coordinates_on_forward() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    rover = roverHandler.move(rover, (position, grid) -> position);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_move_up_y_coordinates_on_backward() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    rover = roverHandler.move(rover, (position, grid) -> position);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_move_down_y_coordinates_on_backward() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    rover = roverHandler.move(rover, (position, grid) -> position);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_move_down_x_coordinates_on_backward() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    rover = roverHandler.move(rover, (position, grid) -> position);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_move_up_x_coordinates_on_backward() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    rover = roverHandler.move(rover, (position, grid) -> position);
    assertEquals(expectedPosition, rover.getPosition());
  }

  @Test
  public void should_turn_west_on_right() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    final Rover rover1 = roverHandler.turn(rover);
    assertEquals("W", rover1.getDirection());
  }

  @Test
  public void should_turn_south_on_right() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    final Rover rover1 = roverHandler.turn(rover);
    assertEquals("W", rover1.getDirection());
  }

  @Test
  public void should_turn_east_on_right() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    final Rover rover1 = roverHandler.turn(rover);
    assertEquals("W", rover1.getDirection());
  }

  @Test
  public void should_turn_north_on_right() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    final Rover rover1 = roverHandler.turn(rover);
    assertEquals("W", rover1.getDirection());
  }

  @Test
  public void should_turn_west_on_left() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    final Rover rover1 = roverHandler.turn(rover);
    assertEquals("W", rover1.getDirection());
  }

  @Test
  public void should_turn_south_on_left() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    final Rover rover1 = roverHandler.turn(rover);
    assertEquals("W", rover1.getDirection());
  }

  @Test
  public void should_turn_east_on_left() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    final Rover rover1 = roverHandler.turn(rover);
    assertEquals("W", rover1.getDirection());
  }

  @Test
  public void should_turn_north_on_left() {
    Rover rover = new Rover(Direction.NORTH, new Position(1, 1), false);
    Position expectedPosition = new Position(1, 2);
    RoverHandler roverHandler = new RoverHandler(null);
    final Rover rover1 = roverHandler.turn(rover);
    assertEquals("W", rover1.getDirection());
  }

  @Test(expected = ObstacleEncounteredException.class)
  public void should_detect_obstacle() {
    final Grid grid = new Grid(Collections.singletonList(new Obstacle(new Position(1,2))));
    final RoverHandler receiver = new RoverHandler(grid);
    receiver.move(
      new Rover(Direction.NORTH, new Position(1, 1), false),
      (position, grid1) -> new Position(position.getX(),position.getY()+1)
    );
  }
}
