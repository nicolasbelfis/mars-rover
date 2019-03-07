package handler;

import domain.Grid;
import domain.Position;

public interface PostionCalcultor {

  Position handle(Position position, Grid grid);
}
