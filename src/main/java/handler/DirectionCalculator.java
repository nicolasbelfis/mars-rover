package handler;

import domain.Direction;

@FunctionalInterface
public interface DirectionCalculator {

  Direction handle();
}
