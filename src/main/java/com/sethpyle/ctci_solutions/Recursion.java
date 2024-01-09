package com.sethpyle.ctci_solutions;

public class Recursion {
  // A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time
  // Implement a method to count how many possible ways the child can run up the stairs.
  public static int staircaseProblem(int stepsLeft) {
    return (stepsLeft / 3 > 0 ? staircaseProblem(stepsLeft - 3) : 0)
        + (stepsLeft / 2 > 0 ? staircaseProblem(stepsLeft - 2) : 0)
        + (stepsLeft > 0 ? staircaseProblem(stepsLeft - 1) : 1);
  }
}
