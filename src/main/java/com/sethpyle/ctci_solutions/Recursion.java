package com.sethpyle.ctci_solutions;

import java.util.List;
import java.util.Stack;

public class Recursion {
  /**
   * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time
   * Implement a method to count how many possible ways the child can run up the stairs.
  */
  public static int staircaseProblem(int stepsLeft) {
    return (stepsLeft / 3 > 0 ? staircaseProblem(stepsLeft - 3) : 0)
        + (stepsLeft / 2 > 0 ? staircaseProblem(stepsLeft - 2) : 0)
        + (stepsLeft > 0 ? staircaseProblem(stepsLeft - 1) : 1);
  }

  record RobotCoordinate(int x, int y) {}

  /**
   * Imagine a robot sitting in the upper left corner of grid with r rows and c columns. The robot can only move
   * in 2 directions, right and down, but certain cells are "off limits" such that the robot cannot step on them.
   * Design an algorithm to find a path for the robot from the top left to the bottom right.
   */
  public static boolean robotInAGrid(
      List<List<Boolean>> grid,
      RobotCoordinate currentCoordinate,
      Stack<RobotCoordinate> path) {
    if (currentCoordinate.y() == grid.size() - 1) {
      if (currentCoordinate.x() == grid.get(0).size() - 1) {
        path.push(currentCoordinate);
        return true;
      }
    }

    if (currentCoordinate.y() < grid.size() - 1) {
      var newCoordinate = new RobotCoordinate(currentCoordinate.x(), currentCoordinate.y() + 1);
      if (grid.get(newCoordinate.y()).get(currentCoordinate.x())) {
        if (robotInAGrid(grid, newCoordinate, path)) {
          path.push(currentCoordinate);
          return true;
        }
      }
    }

    if (currentCoordinate.x() < grid.get(currentCoordinate.x()).size() - 1) {
      var newCoordinate = new RobotCoordinate(currentCoordinate.x() + 1, currentCoordinate.y());
      if (grid.get(newCoordinate.y()).get(newCoordinate.x())) {
        if (robotInAGrid(grid, newCoordinate, path)) {
          path.push(currentCoordinate);
          return true;
        }
      }
    }
    return false;
  }
}
