package api.repository;

import domain.Direction;
import domain.Position;
import domain.Rover;
import handler.RoverHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoverImplRepository implements RoverRepository {

  private final RoverHandler roverHandler;
  /**
   * for in memory implem, the app is initialised with a Rover at 0,0 , facing North
   */
  private Rover rover = new Rover(Direction.NORTH, new Position(0, 0), false);

  public RoverImplRepository(@Autowired RoverHandler roverHandler) {
    this.roverHandler = roverHandler;
  }

  public RoverHandler getRoverHandler() {
    return this.roverHandler;
  }

  @Override
  public Rover findRover() {
    return rover;
  }

  @Override
  public void saveRover(Rover rover) {
    this.rover = rover;
  }
}
