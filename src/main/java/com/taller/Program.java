package com.taller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class Program {

  static List<int[]> getTargetSum(int[] array, int targetSum) {

    Function<int[], Boolean> target = a -> Arrays.stream(a).sum() == targetSum;
    List<int[]> list = new ArrayList<>();
    getSumSummedNumbersForTarget(array, new int[4], 0, array.length - 1, 0, 4, list, target);
    return list;
  }

  private static void getSumSummedNumbersForTarget(int[] arr, int[] data, int start, int end, int index,
      int newArraySize, List<int[]> list, Function<int[], Boolean> target) {

    if (index == newArraySize) {
      if (target.apply(data)) {
        list.add(data.clone());
      }
    } else {
      for (int i = start; i <= end && end - i + 1 >= newArraySize - index; i++) {
        data[index] = arr[i];
        getSumSummedNumbersForTarget(arr, data.clone(), i + 1, end, index + 1,
            newArraySize, list, target);

      }

    }
  }
}