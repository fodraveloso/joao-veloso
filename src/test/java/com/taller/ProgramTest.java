  package com.taller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class ProgramTest {

  @Test
  void testTargetSum16() {

    int[] array = {7, 6, 4, -1, 1, 2};
    var targetSum = 16;

    List<int[]> result = execute(array, targetSum);

    List<int[]> expectedValues = new ArrayList<>(
        List.of(new int[]{7, 6, 4, -1}, new int[]{7, 6, 1, 2}));

    assertThat(expectedValues, containsInAnyOrder(result.stream().map(Matchers::equalTo).collect(
        Collectors.toList())));
  }

  @Test
  void testTargetSum10() {

    int[] array = {1, 2, 3, 4, 5, 6, 7};
    var targetSum = 10;

    List<int[]> result = execute(array, targetSum);

    List<int[]> expectedValues = new ArrayList<>(
        List.of(new int[]{1, 2, 3, 4}));

    assertThat(expectedValues, containsInAnyOrder(result.stream().map(Matchers::equalTo).collect(
        Collectors.toList())));
  }

  @Test
  void testTargetSum0() {

    int[] array = {5, -5, -2, 2, 3, -3};
    var targetSum = 0;

    List<int[]> result = execute(array, targetSum);

    List<int[]> expectedValues = new ArrayList<>(
        List.of(new int[]{5, -5, -2, 2},
            new int[]{5, -5, 3, -3},
            new int[]{-2, 2, 3, -3}));

    assertThat(expectedValues, containsInAnyOrder(result.stream().map(Matchers::equalTo).collect(
        Collectors.toList())));
  }

  @Test
  void testTargetSum4() {

    int[] array = {-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    var targetSum = 4;

    List<int[]> result = execute(array, targetSum);

    List<int[]> expectedValues = new ArrayList<>(
        List.of(new int[]{-2, -1, 1, 6},
            new int[]{-2, 1, 2, 3},
            new int[]{-2, -1, 2, 5},
            new int[]{-2, -1, 3, 4}));

    assertThat(expectedValues, containsInAnyOrder(result.stream().map(Matchers::equalTo).collect(
        Collectors.toList())));
  }

  @Test
  void testTargetSum30() {

    int[] array = {-1, 22, 18, 4, 7, 11, 2, -5, -3};
    var targetSum = 30;

    List<int[]> result = execute(array, targetSum);

    List<int[]> expectedValues = new ArrayList<>(
        List.of(new int[]{-1, 22, 7, 2},
            new int[]{22, 4, 7, -3},
            new int[]{-1, 18, 11, 2},
            new int[]{18, 4, 11, -3},
            new int[]{22, 11, 2, -5}));

    assertThat(expectedValues, containsInAnyOrder(result.stream().map(Matchers::equalTo).collect(
        Collectors.toList())));
  }

  @Test
  void testTargetSum20() {

    int[] array = {-10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5};
    var targetSum = 20;

    List<int[]> result = execute(array, targetSum);

    List<int[]> expectedValues = new ArrayList<>(
        List.of(new int[]{-5, 2, 15, 8},
            new int[]{-3, 2, -7, 28},
            new int[]{-10, -3, 28, 5},
            new int[]{-10, 28, -6, 8},
            new int[]{-7, 28, -6, 5},
            new int[]{-5, 2, 12, 11},
            new int[]{-5, 12, 8, 5}));

    assertThat(expectedValues, containsInAnyOrder(result.stream().map(Matchers::equalTo).collect(
        Collectors.toList())));
  }

  @Test
  void testTargetSum100() {

    int[] array = {1, 2, 3, 4, 5};
    var targetSum = 100;

    List<int[]> result = execute(array, targetSum);

    assertThat(result, is(empty()));
  }

  @Test
  void testTargetSum5() {

    int[] array = {1, 2, 3, 4, 5, -5, 6, -6};
    var targetSum = 5;

    List<int[]> result = execute(array, targetSum);

    List<int[]> expectedValues = new ArrayList<>(
        List.of(new int[]{2, 3, 5, -5},
            new int[]{1, 4, 5, -5},
            new int[]{2, 4, 5, -6},
            new int[]{1, 3, -5, 6},
            new int[]{2, 3, 6, -6},
            new int[]{1, 4, 6, -6}));

    assertThat(expectedValues, containsInAnyOrder(result.stream().map(Matchers::equalTo).collect(
        Collectors.toList())));
  }

  private List<int[]> execute(int[] array, int targetSum) {
    Instant start = Instant.now();
    List<int[]> result = Program.getTargetSum(array, targetSum);
    Instant end = Instant.now();
    System.out.println(String.format("Array: %s -> Target: %s : Execution: %s",
        Arrays.toString(Arrays.stream(array).limit(15).toArray()), targetSum,
        Duration.between(start, end)));
    return result;
  }
}
