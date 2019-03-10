package handler;

import domain.Direction;
import domain.Grid;
import domain.Position;

@FunctionalInterface
public interface DirectionCalculator {

  Direction handle(Direction Direction);
}
