package handler;

import domain.Grid;
import domain.Position;

@FunctionalInterface
public interface PostionCalcultor {

  Position handle(Position position, Grid grid);
}
