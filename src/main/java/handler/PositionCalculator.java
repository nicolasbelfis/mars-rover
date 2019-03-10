package handler;

import domain.Grid;
import domain.Position;

@FunctionalInterface
public interface PositionCalculator {

  Position handle(Position position, Grid grid);
}
