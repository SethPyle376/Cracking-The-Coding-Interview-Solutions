package com.sethpyle.ctci_solutions;

import org.junit.Test;

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
}
