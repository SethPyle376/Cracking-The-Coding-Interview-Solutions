package com.sethpyle.ctci_solutions;

import org.junit.Test;

import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class RecursionTest {
  @Test
  public void testStaircaseProblem() {
    assertThat(Recursion.staircaseProblem(1)).isEqualTo(1);
    assertThat(Recursion.staircaseProblem(2)).isEqualTo(2);
    assertThat(Recursion.staircaseProblem(3)).isEqualTo(4);
    assertThat(Recursion.staircaseProblem(4)).isEqualTo(7);
    assertThat(Recursion.staircaseProblem(5)).isEqualTo(13);
  }

  @Test
  public void testRobotInAGrid() {
    // T F F
    // T F F
    // T T T
    var testGrid1 = List.of(
        List.of(true, false, false),
        List.of(true, false, false),
        List.of(true, true, true)
    );

    var startingCoordinate = new Recursion.RobotCoordinate(0, 0);
    var path = new Stack<Recursion.RobotCoordinate>();

    Recursion.robotInAGrid(testGrid1, startingCoordinate, path);

    assertThat(path).hasSize(5);
    assertThat(path).containsExactly(
        new Recursion.RobotCoordinate(2, 2),
        new Recursion.RobotCoordinate(1, 2),
        new Recursion.RobotCoordinate(0, 2),
        new Recursion.RobotCoordinate(0, 1),
        new Recursion.RobotCoordinate(0, 0)
    );

    // T F F F F
    // T T F F F
    // F T T T F
    // F F F T T
    // F F F F T

    var testGrid2 = List.of(
        List.of(true, false, false, false, false),
        List.of(true, true, false, false, false),
        List.of(false, true, true, true, false),
        List.of(false, false, false, true, true),
        List.of(false, false, false, false, true)
    );

    path = new Stack<>();

    Recursion.robotInAGrid(testGrid2, startingCoordinate, path);

    assertThat(path).hasSize(9);
    assertThat(path).containsExactly(
        new Recursion.RobotCoordinate(4, 4),
        new Recursion.RobotCoordinate(4, 3),
        new Recursion.RobotCoordinate(3, 3),
        new Recursion.RobotCoordinate(3, 2),
        new Recursion.RobotCoordinate(2, 2),
        new Recursion.RobotCoordinate(1, 2),
        new Recursion.RobotCoordinate(1, 1),
        new Recursion.RobotCoordinate(0, 1),
        new Recursion.RobotCoordinate(0, 0)
    );

    // T T T T
    // F F F T
    // F F F T

    var testGrid3 = List.of(
        List.of(true, true, true, true),
        List.of(false, false, false, true),
        List.of(false, false, false, true)
    );

    path = new Stack<>();

    Recursion.robotInAGrid(testGrid3, startingCoordinate, path);

    assertThat(path).hasSize(6);

    assertThat(path).containsExactly(
        new Recursion.RobotCoordinate(3, 2),
        new Recursion.RobotCoordinate(3, 1),
        new Recursion.RobotCoordinate(3, 0),
        new Recursion.RobotCoordinate(2, 0),
        new Recursion.RobotCoordinate(1, 0),
        new Recursion.RobotCoordinate(0, 0)
    );
  }
}
